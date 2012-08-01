package net.comes.care.patient.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.xml.ws.soap.SOAPFaultException;

import net.comes.care.common.login.SessionStore;
import net.comes.care.ws.sycare.Credentials;
import net.comes.care.ws.sycare.GetStatusRequest;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.Status;
import net.comes.care.ws.sycare.Sycare;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.prefs.BackingStoreException;

public class UserToolControl {

	@Inject
	Sycare sycare;

	@Inject
	ESelectionService selectionService;

	private Text txtUsername;
	private Text txtPassword;
	private Link login;

	@PostConstruct
	public void createContent(final Composite parent, final SessionStore store,
			@Preference(nodePath = "net.comes.care.patient") final IEclipsePreferences prefs) {
		parent.setLayout(new GridLayout(4, false));

		final Label lblStatus = new Label(parent, SWT.NONE);
		lblStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtUsername = new Text(parent, SWT.BORDER);
		GridData layoutData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		layoutData.widthHint = 170;
		txtUsername.setLayoutData(layoutData);
		txtUsername.setToolTipText("Benutzername");
		txtUsername.setText(prefs.get("lastUser", ""));

		txtPassword = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		layoutData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		layoutData.widthHint = 170;
		txtPassword.setLayoutData(layoutData);
		txtPassword.setToolTipText("Passwort");
		if(!txtUsername.getText().isEmpty())
			txtPassword.setFocus();

		login = new Link(parent, SWT.NONE);
		login.setText("<a>login</a>");
		login.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Already logged in
				if (store.getSession().isPresent()) {
					store.setSession(null);
					login.setText("<a>login</a>");
					txtUsername.setVisible(true);
					txtUsername.setText(prefs.get("lastUser", ""));
					txtPassword.setVisible(true);
					lblStatus.setText("");
					parent.layout();
					return;
				}

				// Login
				Credentials credentials = new Credentials();
				credentials.setUsername(txtUsername.getText());
				credentials.setPassword(txtPassword.getText());

				try {
					prefs.put("lastUser", txtUsername.getText());
					prefs.flush();
					Session session = sycare.authenticate(credentials);

					// Success
					store.setSession(session);

					Status status = fetchStatus(session);
					selectionService.setSelection(session);
					selectionService.setSelection(status);

					StringBuilder sb = new StringBuilder();
					sb.append(txtUsername.getText()).append(" | ").append("Ungelesene Nachrichten ").append(status.getAvailableMessages())
							.append(" | ").append("Ungelesene Auswertungen ").append(status.getAvailableSurveys()).toString();

					lblStatus.setText(sb.toString());
					login.setText("<a>ausloggen</a>");

					// Set login fields invisible
					txtUsername.setVisible(false);
					txtUsername.setText("");
					txtPassword.setVisible(false);
					txtPassword.setText("");
					parent.layout();
				} catch (SOAPFaultException ex) {
					lblStatus.setText("Falscher Benutzername oder Passwort");
					ex.printStackTrace();
				} catch (BackingStoreException ex) {
					ex.printStackTrace();
				}

			}
		});

	}

	private Status fetchStatus(Session session) {
		GetStatusRequest parameters = new GetStatusRequest();
		parameters.setSessionId(session.getSessionId());
//		parameters.setStatusScope(StatusScope.MESSAGE | StatusScope.SURVEYS);
		return sycare.getStatus(parameters);
	}
}
