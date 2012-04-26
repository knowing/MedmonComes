package net.comes.care.ui.views;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SensorView {


	public static final String ID = "net.comes.care.ui.view.sensor";
	
	@Inject
	protected void createContent(Composite parent) {
		Label lblTest = new Label(parent, SWT.NONE);
		lblTest.setText("Test");
	}
	
}
