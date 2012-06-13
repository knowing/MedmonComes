package net.comes.care.patient.views;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import net.comes.care.common.login.SessionStore;
import net.comes.care.common.ui.MessageViewer;
import net.comes.care.ws.sycare.service.Sycare;

import org.eclipse.e4.ui.di.Focus;
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
	private Sycare sycare;

	@Inject
	private SessionStore store;

	@Inject
	private ESelectionService selectionService;

	private MessageViewer messageViewer;
	private Text txtSearch;

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		txtSearch = new Text(parent, SWT.BORDER);
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		messageViewer = new MessageViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
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

		Composite cButtonBar = new Composite(parent, SWT.NONE);
		cButtonBar.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, true, false, 1, 1));
		cButtonBar.setLayout(new RowLayout(SWT.HORIZONTAL));

		Button btnRefresh = new Button(cButtonBar, SWT.NONE);
		btnRefresh.setLayoutData(new RowData(85, SWT.DEFAULT));
		btnRefresh.setText("Aktualisieren");
		btnRefresh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onRefresh();
			}
		});

		Button btnSend = new Button(cButtonBar, SWT.CENTER);
		btnSend.setLayoutData(new RowData(85, SWT.DEFAULT));
		btnSend.setText("Senden");
	}

	private void onRefresh() {
		if (!store.getSession().isPresent())
			return;

		messageViewer.setInput(sycare, store.getSession().get().getSessionId());
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		txtSearch.setFocus();
	}

}
