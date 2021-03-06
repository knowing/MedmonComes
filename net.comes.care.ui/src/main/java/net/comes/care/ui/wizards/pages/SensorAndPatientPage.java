package net.comes.care.ui.wizards.pages;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import net.comes.care.common.preferences.SensorPreferences;
import net.comes.care.common.ui.DataViewer;
import net.comes.care.entity.Patient;
import net.comes.care.ui.Activator;
import net.comes.care.ui.wizards.IValidationPage;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class SensorAndPatientPage extends WizardPage implements IValidationPage {

	private final ISensorDirectoryService sensorDirectory;
	private Patient patient;
	private ISensor sensor;

	private Text txtPatient;
	private ComboViewer sensorComboViewer;
	private DataViewer dataViewer;
	private Button btnEvaluation;

	/**
	 * Create the wizard.
	 * 
	 * @param patient
	 * @param sensor
	 */
	public SensorAndPatientPage(ISensorDirectoryService sensorDirectory, Patient patient, ISensor sensor) {
		super("SensorAndPatientPage");
		this.sensorDirectory = sensorDirectory;
		this.patient = patient;
		this.sensor = sensor;
		setTitle("Auswahl der Daten");
		setDescription("Bitte waehlen Sie einen Patienten und einen Sensor aus.");
		setImageDescriptor(Activator.getImageDescriptor("img/comes-logo-flat.png"));
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(3, false));
		setControl(container);

		Label lblPatient = new Label(container, SWT.NONE);
		lblPatient.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPatient.setText("Patient");

		txtPatient = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		txtPatient.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnChoose = new Button(container, SWT.NONE);
		btnChoose.setText("Auswaehlen");
		btnChoose.setEnabled(false);

		Label lblSensor = new Label(container, SWT.NONE);
		lblSensor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSensor.setText("Sensor");
		sensorComboViewer = new ComboViewer(container);
		sensorComboViewer.setContentProvider(new ArrayContentProvider());
		sensorComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((ISensor) element).getName();
			}
		});
		sensorComboViewer.setInput(sensorDirectory.getSensors());
		new Label(container, SWT.NONE);

		new Label(container, SWT.NONE);
		final Text txtInfo = new Text(container, SWT.NONE | SWT.READ_ONLY);
		txtInfo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		FontData fontData = txtInfo.getFont().getFontData()[0];
		Font font = new Font(txtInfo.getDisplay(), fontData.getName(), fontData.getHeight() - 1, SWT.ITALIC);
		txtInfo.setFont(font);
		sensorComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection().isEmpty())
					return;
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				ISensor sensor = (ISensor) selection.getFirstElement();
				String directory = SensorPreferences.getSensorPath(sensor);
				txtInfo.setText(directory);
				dataViewer.setInput(sensor, directory);
			}
		});

		Group grpData = new Group(container, SWT.BORDER);
		grpData.setLayout(new FillLayout());
		grpData.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		grpData.setText("Daten");

		dataViewer = new DataViewer(grpData, SWT.NONE | SWT.FULL_SELECTION);
		
		btnEvaluation = new Button(container, SWT.CHECK);
		btnEvaluation.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnEvaluation.setText("Auswertung");
		

		// Initial Selection
		if (patient != null) {
			txtPatient.setText(patient.getUser().getName() + " " + patient.getUser().getSurname());
		}
		if (sensor != null) {
			sensorComboViewer.setSelection(new StructuredSelection(sensor));
			dataViewer.setInput(sensor, SensorPreferences.getSensorPath(sensor));
		}

	}

	@Override
	public void checkContents() {

	}
	
	public List<URI> getSelectedFiles() {
		return dataViewer.getSelectedFiles();
	}
	
	public Patient getSelectedPatient() {
		return patient;
	}

	public ISensor getSelectedSensor() {
		IStructuredSelection selection = (IStructuredSelection) sensorComboViewer.getSelection();
		return (ISensor) selection.getFirstElement();
	}
	
	public boolean isEvaluate() {
		return btnEvaluation.getSelection();
	}

}
