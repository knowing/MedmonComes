package net.comes.care.patient.views;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import net.comes.care.common.preferences.SensorPreferences;
import net.comes.care.common.ui.DataViewer;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.osgi.service.prefs.BackingStoreException;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class DataView {

	@Inject
	private ISensorDirectoryService sensorDirectory;

	private DataViewer dataViewer;
	private ComboViewer sensorViewer;

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
				dataViewer.setInput(sensor, directory);
			}
		});

		dataViewer = new DataViewer(parent, SWT.BORDER);
		dataViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		Composite buttonPane = new Composite(parent, SWT.NONE);
		buttonPane.setLayout(new RowLayout());
		buttonPane.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 3, 1));

		Button upload = new Button(buttonPane, SWT.PUSH);
		RowData layoutData = new RowData();
		layoutData.width = 80;
		upload.setLayoutData(layoutData);

		upload.setText("Upload");
	}

	private void onSensorSelection(SelectionChangedEvent event) {
		if (event.getSelection().isEmpty())
			return;

		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		ISensor sensor = (ISensor) selection.getFirstElement();

		String path = fetchSensorPath(sensor);
		if (path == null)
			return;

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

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
	}

}
