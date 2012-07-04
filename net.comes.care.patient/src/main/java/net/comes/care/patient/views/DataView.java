package net.comes.care.patient.views;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import net.comes.care.common.handlers.SDRConverterHandler;
import net.comes.care.common.login.SessionStore;
import net.comes.care.common.preferences.SensorPreferences;
import net.comes.care.common.resources.ISharedImages;
import net.comes.care.common.resources.ResourceManager;
import net.comes.care.common.ui.DataViewer;
import net.comes.care.ws.sycare.DataType;
import net.comes.care.ws.sycare.DeviceADDR;
import net.comes.care.ws.sycare.DeviceData;
import net.comes.care.ws.sycare.DeviceType;
import net.comes.care.ws.sycare.SendDataRequest;
import net.comes.care.ws.sycare.Status;
import net.comes.care.ws.sycare.service.Sycare;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.osgi.service.prefs.BackingStoreException;

import de.lmu.ifi.dbs.knowing.core.service.IActorSystemManager;
import de.lmu.ifi.dbs.knowing.core.service.IDPUDirectory;
import de.lmu.ifi.dbs.knowing.core.service.IEvaluateService;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class DataView {

	@Inject
	ISensorDirectoryService sensorDirectory;

	@Inject
	IEvaluateService evaluateService;

	@Inject
	IActorSystemManager asm;

	@Inject
	IDPUDirectory dpuDirectory;

	@Inject
	ECommandService commandService;

	@Inject
	EHandlerService handlerService;

	@Inject
	Sycare sycare;

	@Inject
	SessionStore store;

	private DataViewer dataViewer;
	private ComboViewer sensorViewer;
	private Button btnUpload;

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(3, false));

		Label lblSensor = new Label(parent, SWT.NONE);
		lblSensor.setText("Sensor");
		lblSensor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		sensorViewer = new ComboViewer(parent, SWT.BORDER | SWT.READ_ONLY);
		sensorViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		sensorViewer.setContentProvider(new ArrayContentProvider());
		sensorViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((ISensor) element).getName();
			}
		});
		sensorViewer.setInput(sensorDirectory.getSensors());
		sensorViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				onSensorSelection(event);
			}
		});

		Button btnConfigure = new Button(parent, SWT.NONE);
		btnConfigure.setText("Konfigurieren");
		btnConfigure.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (sensorViewer.getSelection().isEmpty())
					return;
				IStructuredSelection selection = (IStructuredSelection) sensorViewer.getSelection();
				ISensor sensor = (ISensor) selection.getFirstElement();
				String directory = updateSensor(sensor);
				if (directory != null)
					dataViewer.setInput(sensor, directory);
			}
		});

		dataViewer = new DataViewer(parent, SWT.BORDER);
		dataViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		Composite buttonPane = new Composite(parent, SWT.NONE);
		buttonPane.setLayout(new RowLayout());
		buttonPane.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 3, 1));

		btnUpload = new Button(buttonPane, SWT.PUSH);
		btnUpload.setImage(ResourceManager.getPluginImage(ISharedImages.PLUGIN_ID, ISharedImages.IMG_IMPORT));
		btnUpload.setEnabled(false);
		btnUpload.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onUpload();
			}
		});
	}

	private void onSensorSelection(SelectionChangedEvent event) {
		if (event.getSelection().isEmpty()) {
			btnUpload.setEnabled(false);
			return;
		}

		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		ISensor sensor = (ISensor) selection.getFirstElement();

		String path = fetchSensorPath(sensor);
		if (path == null)
			return;

		btnUpload.setEnabled(true);
		// update
		dataViewer.setInput(sensor, path);
	}

	private String fetchSensorPath(ISensor sensor) {
		String path = SensorPreferences.getSensorPath(sensor);
		if (path != null && !path.isEmpty())
			return path;
		// Configure sensor on first call

		return updateSensor(sensor);
	}

	private String updateSensor(ISensor sensor) {
		DirectoryDialog dialog = new DirectoryDialog(sensorViewer.getControl().getShell());
		String directory = dialog.open();
		if (directory == null || directory.isEmpty())
			return null;
		IEclipsePreferences prefs = SensorPreferences.getPreferenceNode(sensor);
		prefs.put(SensorPreferences.SENSOR_PATH, directory);
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
		return directory;
	}

	private void onUpload() {
		List<URI> files = dataViewer.getSelectedFiles();
		if (files.isEmpty()) {
			MessageDialog.openInformation(dataViewer.getControl().getShell(), "Daten ausw\u00e4hlen",
					"Bitte w\u00e4hlen Sie einen Datensatz zum hochladen aus.");
			return;
		}
		Command command = commandService.getCommand("net.comes.care.patient.ConverterCommand");

		Properties parameter = new Properties();
		try {
			Path srcFile = Paths.get(files.get(0));
			Path trgFile = Files.createTempFile("comes-upload", ".acdata");
			parameter.setProperty("net.comes.care.parameters.file.source", srcFile.toString());
			parameter.setProperty("net.comes.care.parameters.file.target", trgFile.toString());
			parameter.setProperty("net.comes.care.parameters.uifactory", "none");
		} catch (IOException e) {
			e.printStackTrace();
		}

		ParameterizedCommand cmd = commandService.createCommand("net.comes.care.patient.ConverterCommand", parameter);

		if (!command.isHandled()) {
			// Activate Handler, assume AboutHandler() class exists already
			handlerService.activateHandler("net.comes.care.patient.ConverterCommand", new SDRConverterHandler());
		}
		handlerService.executeHandler(cmd);

		/*
		SendDataRequest parameters = new SendDataRequest();
		parameters.setSessionId(store.getSession().get().getSessionId());
		parameters.setDataType(DataType.ASCII_DELIMITED);
		parameters.setDeviceType(DeviceType.AC);
		List<DeviceData> data = parameters.getDeviceData(); // Adding data
		DeviceData d = new DeviceData();

		DeviceADDR deviceADDR = new DeviceADDR();
		deviceADDR.setSerialNumber("00.02.C7.52.DF.9E");
		deviceADDR.setDeviceManufacturer(" Omron RX Genius 6371T");
		d.setDeviceADDR(deviceADDR);
		List<String> acData = d.getACData();
		acData.add("##;0;2010;5;25;19;50;41;Joggen;0;0;;;;");
		acData.add("##;1;2010;5;25;19;50;42;biken;0;0;;;;");
		acData.add("##;2;2010;5;25;19;50;48;Joggen;0;0;;;;");
		data.add(d);
		
		Status status = sycare.sendData(parameters);
		System.out.println("Status: " + status.isAccepted());
		*/
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
	}

}
