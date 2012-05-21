package net.comes.care.ui.wizards.pages;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import net.comes.care.entity.Patient;
import net.comes.care.ui.preferences.SensorPreferences;
import net.comes.care.ui.wizards.IValidationPage;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
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
	private TableViewer dataViewer;

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
				updateDataViewer(sensor, directory);
			}
		});

		Group grpData = new Group(container, SWT.BORDER);
		grpData.setLayout(new FillLayout());
		grpData.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		grpData.setText("Daten");

		dataViewer = new TableViewer(grpData, SWT.NONE | SWT.FULL_SELECTION);
		dataViewer.setContentProvider(new ArrayContentProvider());
		dataViewer.setLabelProvider(new DataLabelProvider());

		// Initial Selection
		if (patient != null) {
			txtPatient.setText(patient.getUser().getName() + " " + patient.getUser().getSurname());
		}
		if (sensor != null) {
			sensorComboViewer.setSelection(new StructuredSelection(sensor));
			updateDataViewer(sensor, SensorPreferences.getSensorPath(sensor));
		}

	}

	@Override
	public void checkContents() {

	}

	private void updateDataViewer(ISensor sensor, String directory) {
		List<URI> uriList = new ArrayList<URI>();
		try (DirectoryStream<Path> directoyStream = Files.newDirectoryStream(Paths.get(directory))) {
			String filePrefix = sensor.getFilePrefix();
			for (Path file : directoyStream) {
				// Don't use file.endsWith() -> checks the last foldername
				// of the path not the prefix of the file
				if (file.toString().endsWith(filePrefix))
					uriList.add(file.toUri());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		dataViewer.setInput(uriList);
	}

	private class DataLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			URI uri = (URI) element;
			switch (columnIndex) {
			case 0:
				return Paths.get(uri).getFileName().toString();
			default:
				return getText(element);
			}
		}
	}

}
