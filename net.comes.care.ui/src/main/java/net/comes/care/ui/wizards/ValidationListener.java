package net.comes.care.ui.wizards;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ValidationListener extends SelectionAdapter implements
		ModifyListener, ISelectionChangedListener {

	/** The <code>IValidationPage</code>. */
	private IValidationPage validationPage;

	/**
	 * Constructor for <class>ValidationListener</class>.
	 */
	public ValidationListener(IValidationPage validationPage) {
		super();
		this.validationPage = validationPage;
	}

	/**
	 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
	 */
	public void modifyText(ModifyEvent e) {
		validationPage.checkContents();
	}

	/**
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		validationPage.checkContents();
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		validationPage.checkContents();
	}

}