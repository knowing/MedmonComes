package net.comes.care.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import net.comes.care.ui.dialogs.UserPasswordDialog;
import net.comes.care.ui.login.SessionStore;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.service.Sycare;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

public class ComesLoginHandler {

	@Inject
	private Sycare sycare;
	
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		UserPasswordDialog dialog = new UserPasswordDialog(shell, sycare);
		if(dialog.open() == UserPasswordDialog.CANCEL)
			return;
		
		Session session = dialog.getSession();
		SessionStore store = SessionStore.getInstance();
		store.setSession(session);
		
	}
}
