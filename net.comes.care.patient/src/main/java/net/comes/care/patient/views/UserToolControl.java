package net.comes.care.patient.views;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;

public class UserToolControl {
	
	private Text txtUsername;
	private Text txtPassword;
	private Link login;

	@PostConstruct
	public void createContent(Composite parent) {
		parent.setLayout(new GridLayout(4, false));
		
		final Label lblUsername = new Label(parent, SWT.NONE);
		lblUsername.setText("Nicht eingeloggt");
		lblUsername.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		txtUsername = new Text(parent, SWT.BORDER);
		GridData layoutData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		layoutData.widthHint = 170;
		txtUsername.setLayoutData(layoutData);
		txtUsername.setToolTipText("Benutzername");
		
		txtPassword = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		layoutData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		layoutData.widthHint = 170;
		txtPassword.setLayoutData(layoutData);
		txtPassword.setToolTipText("Passwort");
		
		login = new Link(parent, SWT.NONE);
		login.setText("<a>login</a>");
		login.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblUsername.setText("Muki Seiler");
			}
		});
		
	}
}
