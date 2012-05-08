package net.comes.care.ui.views;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class PresenterView {


	public static final String ID = "net.comes.care.ui.view.presenter";
	
	@PostConstruct
	protected void createContent(Composite parent) {
		Composite container = new Composite(parent, SWT.BORDER);
	}
	
}
