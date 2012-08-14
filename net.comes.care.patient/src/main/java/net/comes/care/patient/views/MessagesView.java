package net.comes.care.patient.views;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import net.comes.care.common.login.SessionStore;
import net.comes.care.common.resources.ISharedImages;
import net.comes.care.common.resources.ResourceManager;
import net.comes.care.common.ui.MessageViewer;
import net.comes.care.services.IMessagesService;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.Sycare;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class MessagesView {

	@Inject
	Sycare sycare;
	
	@Inject
	IMessagesService messagesService;

	@Inject
	SessionStore store;

	@Inject
	ESelectionService selectionService;

	private MessageViewer messageViewer;
	private Text txtSearch;
	
	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));

		txtSearch = new Text(container, SWT.BORDER);
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		messageViewer = new MessageViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		messageViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		messageViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection().isEmpty())
					return;
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				selectionService.setSelection(selection.getFirstElement());
			}
		});

		Composite cButtonBar = new Composite(container, SWT.NONE);
		cButtonBar.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, true, 1, 1));
		cButtonBar.setLayout(new RowLayout(SWT.VERTICAL));

		Button btnRefresh = new Button(cButtonBar, SWT.NONE);
		btnRefresh.setLayoutData(new RowData(125, SWT.DEFAULT));
		btnRefresh.setText("Aktualisieren");
		btnRefresh.setImage(ResourceManager.getPluginImage(ISharedImages.PLUGIN_ID, ISharedImages.ICON_REFRESH_16));
		btnRefresh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (store.getSession().isPresent())
					onLogin(store.getSession().get());
			}
		});

		Button btnRead = new Button(cButtonBar, SWT.CENTER);
		btnRead.setLayoutData(new RowData(125, SWT.DEFAULT));
		btnRead.setText("Gelesen");
		
	}
	
	@Inject @Optional
	protected void onLogin(@UIEventTopic(UserToolControl.LOGIN_TOPIC) Session session) {
		if (messageViewer == null || messageViewer.getControl().isDisposed())
			return;
		// TODO until bug is fixed
		messagesService.login(store.getEmail().orNull());
		messageViewer.setInput(messagesService.getMessages());
		messageViewer.setInput(sycare, session.getSessionId());

		// Mock until fixed
	}
	
	@Inject @Optional
	protected void onLogout(@UIEventTopic(UserToolControl.LOGOUT_TOPIC) Session session) {
		messageViewer.setInput(Collections.EMPTY_LIST);
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		txtSearch.setFocus();
	}

}
