package net.comes.care.patient.views;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DataView {

	private TableViewer dataViewer;
	private ComboViewer sensorViewer;

	public DataView() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2,false));
		
		Label lblSensor = new Label(parent, SWT.NONE);
		lblSensor.setText("Sensor");
		lblSensor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		sensorViewer = new ComboViewer(parent, SWT.BORDER | SWT.READ_ONLY);
		sensorViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		dataViewer = new TableViewer(parent, SWT.BORDER);
		dataViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,2,1));
		
		Composite buttonPane = new Composite(parent, SWT.NONE);
		buttonPane.setLayout(new RowLayout());
		buttonPane.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false,2,1));
		
		Button upload = new Button(buttonPane, SWT.PUSH);
		upload.setText("Upload");
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
	}

}
