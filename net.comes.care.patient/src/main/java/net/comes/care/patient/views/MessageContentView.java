package net.comes.care.patient.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import net.comes.care.ws.sycare.AMessage;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class MessageContentView {

	private StyledText messageViewer;

	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		messageViewer = new StyledText(parent, SWT.MULTI | SWT.BORDER);
		messageViewer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) AMessage msg) {
		if (msg == null)
			return;
		System.err.println("Selection: " + msg.getMessageTitle());
	}

}
