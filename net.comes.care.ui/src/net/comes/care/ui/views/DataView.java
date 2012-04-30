package net.comes.care.ui.views;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class DataView {


	public static final String ID = "net.comes.care.ui.view.data";
	private TreeViewer dataViewer;
	
	@PostConstruct
	protected void createContent(Composite parent) {
		dataViewer = new TreeViewer(parent, SWT.NONE);
	}
	
}
