package net.comes.care.ui.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.comes.care.ui.Activator;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class SensorView implements EventHandler {

	public static final String ID = "net.comes.care.ui.view.sensor";

	@Inject
	ISensorDirectoryService sensorDirectory;

	private Text txtSearch;

	private TableViewer sensorTableViewer;

	@PostConstruct
	protected void createContent(Composite parent, IEventBroker broker) {
		parent.setLayout(new GridLayout(1, false));

		txtSearch = new Text(parent, SWT.BORDER);
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		sensorTableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		sensorTableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		//Columns
		TableViewerColumn colName = new TableViewerColumn(sensorTableViewer, SWT.LEAD);
		colName.getColumn().setText("Name");
		colName.getColumn().setResizable(true);
		colName.getColumn().setWidth(250);
		
		TableViewerColumn colVersion = new TableViewerColumn(sensorTableViewer, SWT.LEAD);
		colVersion.getColumn().setText("Version");
		colVersion.getColumn().setResizable(true);
		colVersion.getColumn().setWidth(80);
		
		sensorTableViewer.setContentProvider(new ArrayContentProvider());
		sensorTableViewer.setLabelProvider(new SensorLabelProvider());
		sensorTableViewer.setInput(sensorDirectory.getSensors());

		broker.subscribe(ISensorDirectoryService.SENSOR_TOPIC_CHANGED, this);
	}

	@Override
	public void handleEvent(Event event) {
		sensorTableViewer.setInput(sensorDirectory.getSensors());
	}

	private class SensorLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return Activator.getImageDescriptor("icons/24/usb.png").createImage();
			default:
				return null;
			}
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			ISensor sensor = (ISensor) element;
			switch (columnIndex) {
			case 0:
				return sensor.getName();
			case 1:
				return sensor.getVersion();
			default:
				return null;
			}
		}

	}

}
