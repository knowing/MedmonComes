package net.comes.care.ui.views;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PatientView {

	public static final String ID = "net.comes.care.ui.view.patient";
	
	@Inject
	@GeminiPersistenceContext(unitName="comes")
	private EntityManager em;
	
	@Inject
	protected void createContent(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		Label lblLastName = new Label(container, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblLastName.setText("Nachname");
		Text txtLastName = new Text(container, SWT.BORDER);
		txtLastName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		CLabel imgPatient = new CLabel(container, SWT.BORDER | SWT.SHADOW_IN);
		imgPatient.setAlignment(SWT.CENTER);
		GridData gd_imgPatient = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 3);
		gd_imgPatient.heightHint = 120;
		gd_imgPatient.widthHint = 120;
		imgPatient.setLayoutData(gd_imgPatient);
		imgPatient.setText("<image>");
		Label lblFirstName = new Label(container, SWT.NONE);
		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblFirstName.setText("Vorname");
		Text txtFirstName = new Text(container, SWT.BORDER);
		txtFirstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		Label lblInsuranceId = new Label(container, SWT.NONE);
		lblInsuranceId.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));
		lblInsuranceId.setText("VersicherungsNr.");
		Text txtInsuranceId = new Text(container, SWT.BORDER);
		txtInsuranceId.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
	}
}
