package net.comes.care.patient.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import net.comes.care.ws.sycare.AMessage;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Composite;

public class MessageContentView {

	@PostConstruct
	public void createControls(Composite parent) {

	}

	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) AMessage msg) {
		if (msg == null)
			return;
		System.err.println("Selection: " + msg.getMessageTitle());
	}

}
