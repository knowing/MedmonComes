package net.comes.care.ui.dialogs;

import javax.xml.ws.soap.SOAPFaultException;

import net.comes.care.ui.Activator;
import net.comes.care.ws.sycare.Credentials;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.service.Sycare;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class UserPasswordDialog extends TitleAreaDialog {

	private static final int RESET_ID = IDialogConstants.NO_TO_ALL_ID + 1;

	private Text usernameField;
	private Text passwordField;

	private final Sycare sycare;

	private Session session;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 * @param sycare 
	 */
	public UserPasswordDialog(Shell parentShell, Sycare sycare) {
		super(parentShell);
		this.sycare = sycare;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Login");
		setTitleImage(Activator.getImageDescriptor("img/comes-logo.png").createImage());
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		container.setLayout(new GridLayout(2, false));
		
		Label usernameLabel = new Label(container, SWT.RIGHT);
		usernameLabel.setText("Benutzername: ");

		usernameField = new Text(container, SWT.SINGLE | SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.verticalIndent = 5;
		usernameField.setLayoutData(data);

		Label passwordLabel = new Label(container, SWT.RIGHT);
		passwordLabel.setText("Passwort: ");

		passwordField = new Text(container, SWT.SINGLE | SWT.PASSWORD | SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.verticalIndent = 5;
		passwordField.setLayoutData(data);

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == RESET_ID) {
			usernameField.setText("");
			passwordField.setText("");
		} else {
			super.buttonPressed(buttonId);
		}
	}
	
	@Override
	protected void okPressed() {
		Credentials credentials = new Credentials();
		credentials.setUsername(usernameField.getText());
		credentials.setPassword(passwordField.getText());
		try {
			session = sycare.authenticate(credentials);
			super.okPressed();
		} catch (SOAPFaultException e) {
			setErrorMessage("Login fehlgeschlagen. Falscher Benutzername / Passwort ");
		} catch (Exception e){
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Login fehlgeschlagen", e);
			ErrorDialog.openError(getShell(), "Unerwarteter Fehler beim Login", null, status);
		}
	}
	
	public Session getSession() {
		return session;
	}
}
