package net.comes.care.ui.views;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PatientView {

	public static final String ID = "net.comes.care.ui.view.patient";
	
	@Inject
	@GeminiPersistenceContext(unitName="comes")
	private EntityManager em;
	
	@Inject
	protected void createContent(Composite parent) {
		Label lblTest = new Label(parent, SWT.NONE);
		lblTest.setText("Test");
	}
}
