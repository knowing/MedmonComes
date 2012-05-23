package net.comes.care.ui.views;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import net.comes.care.entity.Patient;
import net.comes.care.ui.login.SessionStore;
import net.comes.care.ws.sycare.DeviceType;
import net.comes.care.ws.sycare.GetMeasuredDataRequest;
import net.comes.care.ws.sycare.GetMeasuredDataResponse;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.service.Sycare;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
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
	private Patient patient;

	@Inject
	private Sycare sycare;

	@PostConstruct
	protected void createContent(Composite parent) {
		dataViewer = new TreeViewer(parent, SWT.NONE);

		// InputProvider
		dataViewer.setContentProvider(new DataContentProvider());

		// Columns
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
		update();
	}

	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Patient patient) {
		this.patient = patient;
		if (patient == null || dataViewer == null || dataViewer.getControl().isDisposed())
			return;
		update();
	}

	private void update() {
		if (patient == null) {
			dataViewer.setInput(Collections.EMPTY_LIST);
			return;
		}
		List<String> sampleInput = new ArrayList<>();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		sampleInput.add("Data01 " + df.format(patient.getDateOfBirth()));
		sampleInput.add("Data02 " + df.format(patient.getDateOfBirth()));
		sampleInput.add("Data03 " + df.format(patient.getDateOfBirth()));
		dataViewer.setInput(sampleInput);

		SessionStore store = SessionStore.getInstance();
		if (!store.getSession().isPresent())
			return;

		Session session = store.getSession().get();
		
		GetMeasuredDataRequest parameters = new GetMeasuredDataRequest();
		parameters.setSessionId(session.getSessionId());
		parameters.setDeviceType(DeviceType.AC);
		GetMeasuredDataResponse data = sycare.getMeasuredData(parameters);
		System.err.println("##### Data ####");
		for (String dataString : data.getACData()) {
			System.err.println("Data: " + dataString);
		}
		
		/* org.apache.cxf.binding.soap.SoapFault: Call to undefined method MDB2_Error::fetchRow()
		System.err.println("##### Manufacturers ####");
		GetDeviceManufacturersRequest parameters2 = new GetDeviceManufacturersRequest();
		parameters2.setDeviceType(DeviceType.AC);
		parameters2.setSessionId(session.getSessionId());
		DeviceManufacturers manufacturers = sycare.getDeviceManufacturers(parameters2);
		for (String man : manufacturers.getDeviceManufacturer()) {
			System.err.println("Manufacturer: " + man);
		}
	*/
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
