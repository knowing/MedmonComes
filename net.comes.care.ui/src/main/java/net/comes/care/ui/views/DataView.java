package net.comes.care.ui.views;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.ws.soap.SOAPFaultException;

import net.comes.care.entity.Patient;
import net.comes.care.ui.Activator;
import net.comes.care.ui.login.SessionStore;
import net.comes.care.ws.sycare.DeviceManufacturers;
import net.comes.care.ws.sycare.DeviceType;
import net.comes.care.ws.sycare.GetDeviceManufacturersRequest;
import net.comes.care.ws.sycare.GetMeasuredDataRequest;
import net.comes.care.ws.sycare.GetMeasuredDataResponse;
import net.comes.care.ws.sycare.Session;
import net.comes.care.ws.sycare.service.Sycare;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataView {

	public static final String ID = "net.comes.care.ui.view.data";
	private final Logger log = LoggerFactory.getLogger(DataView.class);

	private TreeViewer dataViewer;
	private ComboViewer deviceComboViewer;
	private Patient patient;

	@Inject
	private Sycare sycare;
	
	@Inject
	private SessionStore store;

	@PostConstruct
	protected void createContent(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		deviceComboViewer = new ComboViewer(parent, SWT.NONE);
		Combo combo = deviceComboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		deviceComboViewer.add(DeviceType.values());
		deviceComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				update();
			}
		});

		dataViewer = new TreeViewer(parent, SWT.NONE);
		Tree tree = dataViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

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

		if (!store.getSession().isPresent())
			return;
		
		if(deviceComboViewer.getSelection().isEmpty())
			return;
		
		IStructuredSelection selection = (IStructuredSelection) deviceComboViewer.getSelection();
		DeviceType deviceType = (DeviceType) selection.getFirstElement();

		Session session = store.getSession().get();

		try {
			GetMeasuredDataRequest parameters = new GetMeasuredDataRequest();
			parameters.setSessionId(session.getSessionId());
			parameters.setDeviceType(deviceType);
			GetMeasuredDataResponse data = sycare.getMeasuredData(parameters);
			log.debug("##### Data ####");
			for (String dataString : data.getACData()) {
				log.debug("Data: " + dataString);
			}

			// org.apache.cxf.binding.soap.SoapFault: Call to undefined method
			// MDB2_Error::fetchRow()
			log.debug("##### Manufacturers ####");
			GetDeviceManufacturersRequest parameters2 = new GetDeviceManufacturersRequest();
			parameters2.setDeviceType(DeviceType.AC);
			parameters2.setSessionId(session.getSessionId());
			DeviceManufacturers manufacturers = sycare.getDeviceManufacturers(parameters2);
			for (String man : manufacturers.getDeviceManufacturer()) {
				log.debug("Manufacturer: " + man);
			}
		} catch (SOAPFaultException e) {
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Fehler beim Ger\u00e4te laden", e);
			ErrorDialog.openError(dataViewer.getControl().getShell(), "Fehler", null, status);
			log.error("SOAP error", e);
		}

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
