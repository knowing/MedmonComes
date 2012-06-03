package net.comes.care.ui.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.comes.care.ui.login.SessionStore;
import net.comes.care.ui.preferences.SensorPreferences;
import net.comes.care.ui.viewer.SensorTableViewer;
import net.comes.care.ws.sycare.DeviceManufacturers;
import net.comes.care.ws.sycare.DeviceType;
import net.comes.care.ws.sycare.DeviceTypes;
import net.comes.care.ws.sycare.GetDeviceManufacturersRequest;
import net.comes.care.ws.sycare.GetDeviceTypesRequest;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.service.Sycare;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.prefs.BackingStoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class SensorView {

	public static final String ID = "net.comes.care.ui.view.sensor";
	private final Logger log = LoggerFactory.getLogger(SensorView.class);

	@Inject
	private ISensorDirectoryService sensorDirectory;

	@Inject
	private ESelectionService selectionService;
	
	@Inject
	private Sycare sycare;
	
	@Inject
	@Preference(nodePath = SensorPreferences.NODE_PATH)
	private IEclipsePreferences preferences;

	private Text txtSearch;
	private SensorTableViewer sensorTableViewer;

	@PostConstruct
	protected void createContent(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		txtSearch = new Text(parent, SWT.BORDER);
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		sensorTableViewer = new SensorTableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		sensorTableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		sensorTableViewer.setInput(sensorDirectory.getSensors());
		sensorTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection().isEmpty()) {
					selectionService.setSelection(null);
					return;
				}
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				ISensor sensor = (ISensor) selection.getFirstElement();
				selectionService.setSelection(sensor);
				preferences.put(SensorPreferences.LAST_SENSOR_ID, sensor.getId());
				try {
					preferences.flush();
				} catch (BackingStoreException e) {
					e.printStackTrace();
				}
			}
		});
		
		String id = preferences.get(SensorPreferences.LAST_SENSOR_ID, null);
		if(id == null)
			return;
		
		for(ISensor sensor : sensorDirectory.getSensors()) {
			if(sensor.getId().equals(id))
				sensorTableViewer.setSelection(new StructuredSelection(sensor));
		}
	}

	@Inject
	protected void sensorChanged(final @Optional @UIEventTopic(ISensorDirectoryService.SENSOR_TOPIC) ISensor sensor) {
		if (sensorTableViewer == null || sensorTableViewer.getControl().isDisposed())
			return;

		// Even it's a UIEventTopic it isn't always synced.
		sensorTableViewer.getControl().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				sensorTableViewer.setInput(sensorDirectory.getSensors());
				MessageDialog.openConfirm(txtSearch.getShell(), "Sensor changed", "Sensor " + sensor.getName());
			}
		});

	}

}
