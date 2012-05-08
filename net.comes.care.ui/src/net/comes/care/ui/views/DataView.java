package net.comes.care.ui.views;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class DataView {


	public static final String ID = "net.comes.care.ui.view.data";
	private TreeViewer dataViewer;
	
	@PostConstruct
	protected void createContent(Composite parent) {
		dataViewer = new TreeViewer(parent, SWT.NONE);
		
		//InputProvider
		dataViewer.setContentProvider(new DataContentProvider());
		
		//Columns
		TreeViewerColumn cFirst = new TreeViewerColumn(dataViewer, SWT.NONE);
		cFirst.getColumn().setText("Name");
		cFirst.getColumn().setWidth(120);
		cFirst.getColumn().setMoveable(true);
		cFirst.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return element.toString().split(" ")[0];
			}
		});
		
		TreeViewerColumn cSecond = new TreeViewerColumn(dataViewer, SWT.NONE);
		cSecond.getColumn().setText("Date");
		cSecond.getColumn().setWidth(200);
		cSecond.getColumn().setMoveable(true);
		cSecond.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return element.toString().split(" ")[1];
			}
		});
		
		testInput();
	}
	
	private void testInput() {
		List<String> sampleInput = new ArrayList<>();
		sampleInput.add("Data01 2012-03-04");
		sampleInput.add("Data02 2012-03-05");
		sampleInput.add("Data03 2012-03-06");
		dataViewer.setInput(sampleInput);
	}
	
	private class DataContentProvider extends ArrayContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getChildren(Object parentElement) {
			return null;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}


		
	}
		
}

