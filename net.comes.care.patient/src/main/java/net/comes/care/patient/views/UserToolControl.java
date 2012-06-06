package net.comes.care.patient.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.xml.ws.soap.SOAPFaultException;

import net.comes.care.common.login.SessionStore;
import net.comes.care.ws.sycare.Credentials;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.service.Sycare;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;

public class UserToolControl {
	
	@Inject
	private Sycare sycare;
	
	private Text txtUsername;
	private Text txtPassword;
	private Link login;

	@PostConstruct
	public void createContent(final Composite parent, final SessionStore store) {
		parent.setLayout(new GridLayout(4, false));
		
		final Label lblStatus = new Label(parent, SWT.NONE);
		lblStatus.setText("Nicht eingeloggt");
		lblStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
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
				//Already logged in
				if(store.getSession().isPresent()) {
					store.setSession(null);
					login.setText("<a>login</a>");
					txtUsername.setVisible(true);
					txtPassword.setVisible(true);
					parent.layout();
					return;
				}
				
				//Login
				Credentials credentials = new Credentials();
				credentials.setUsername(txtUsername.getText());
				credentials.setPassword(txtPassword.getText());
				
				try {
					Session session = sycare.authenticate(credentials);
					store.setSession(session);
					lblStatus.setText(txtUsername.getText());
					login.setText("<a>ausloggen</a>");
					txtUsername.setVisible(false);
					txtUsername.setText("");
					txtPassword.setVisible(false);
					txtPassword.setText("");
					parent.layout();
				} catch (SOAPFaultException ex) {
					ex.printStackTrace();
					lblStatus.setText("Falscher Benutzername oder Passwort");
				}

			}
		});
		
	}
}
