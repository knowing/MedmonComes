package net.comes.care.patient.views;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class UserToolControl {
	
	private Text txtUsername;
	private Text txtPassword;
	private Label lblUsername;

	@PostConstruct
	public void createContent(Composite parent) {
		parent.setLayout(new GridLayout(4, false));
		
		lblUsername = new Label(parent, SWT.NONE);
		lblUsername.setText("Nicht eingeloggt");
		lblUsername.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		txtUsername = new Text(parent, SWT.BORDER);
		GridData layoutData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		layoutData.widthHint = 200;
		txtUsername.setLayoutData(layoutData);
		txtUsername.setText("Benutzername");
		
		txtPassword = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setLayoutData(layoutData);
		
		Button login = new Button(parent, SWT.PUSH);
		login.setText("login");
		login.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
	}
}
