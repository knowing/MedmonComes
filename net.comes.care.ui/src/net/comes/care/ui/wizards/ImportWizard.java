package net.comes.care.ui.wizards;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import net.comes.care.entity.Patient;
import net.comes.care.ui.wizards.pages.SensorAndPatientPage;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import de.lmu.ifi.dbs.medmon.sensor.core.IConverter;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class ImportWizard extends Wizard {

	private final ISensorDirectoryService directoryService;
	private final Patient patient;
	private final ISensor sensor;

	private SensorAndPatientPage page;

	/**
	 * 
	 * @param directoryService
	 * @param patient
	 *            - can be null
	 * @param sensor
	 *            - can be null
	 */
	public ImportWizard(ISensorDirectoryService directoryService, Patient patient, ISensor sensor) {
		this.directoryService = directoryService;
		this.patient = patient;
		this.sensor = sensor;
		setWindowTitle("Datenimport");
	}

	@Override
	public void addPages() {
		addPage(page = new SensorAndPatientPage(directoryService, patient, sensor));
	}

	@Override
	public boolean performFinish() {
		List<URI> files = page.getSelectedFiles();
		Patient patient = page.getSelectedPatient();
		ISensor sensor = page.getSelectedSensor();
		try {
			for (URI file : files) {
				IConverter converter = sensor.newConverter(file);
				Instances data = converter.getData();
				FileDialog saveDialog = new FileDialog(getShell(), SWT.SAVE);
				String filepath = saveDialog.open();
				if(filepath == null || filepath.isEmpty())
					return true;
				
				if(!filepath.endsWith(".arff"))
					filepath = filepath + ".arff";
				Path path = Paths.get(filepath);
				try(OutputStream output = Files.newOutputStream(path)) {
					ArffSaver saver = new ArffSaver();
					saver.setDestination(output);
					saver.setInstances(data);
					saver.writeBatch();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		MessageDialog.openInformation(getShell(), "Erfolg", "Daten erfolgreich gespeichert");
		return true;
	}

}
