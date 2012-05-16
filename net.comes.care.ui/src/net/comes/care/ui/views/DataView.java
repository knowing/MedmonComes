package net.comes.care.ui.views;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import net.comes.care.entity.Patient;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class DataView implements EventHandler {


	public static final String ID = "net.comes.care.ui.view.data";
	private TreeViewer dataViewer;
	private Patient patient;
	
	@PostConstruct
	protected void createContent(Composite parent, IEventBroker broker) {
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
		
		broker.subscribe("patient", this);
	}
	
	@Override
	public void handleEvent(Event event) {
		patient = (Patient) event.getProperty(IEventBroker.DATA);
		List<String> sampleInput = new ArrayList<>();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		sampleInput.add("Data01 " + df.format(patient.getDateOfBirth()));
		sampleInput.add("Data02 " + df.format(patient.getDateOfBirth()));
		sampleInput.add("Data03 " + df.format(patient.getDateOfBirth()));
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

