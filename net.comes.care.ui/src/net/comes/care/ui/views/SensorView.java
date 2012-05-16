package net.comes.care.ui.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class SensorView {

	public static final String ID = "net.comes.care.ui.view.sensor";
	
	@Inject
	ISensorDirectoryService sensorDirectory;
	
	private Text txtSearch;

	private TableViewer sensorTableViewer;
	
	@PostConstruct
	protected void createContent(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		txtSearch = new Text(parent, SWT.BORDER);
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		sensorTableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		sensorTableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		sensorTableViewer.setContentProvider(new ArrayContentProvider());
		sensorTableViewer.setLabelProvider(new LabelProvider());
		sensorTableViewer.setInput(sensorDirectory.getSensors());
		
		System.err.println("Sensors: " + sensorDirectory.getSensors());
	}
	
}
