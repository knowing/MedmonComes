package net.comes.care.ui.wizards;

import net.comes.care.entity.Patient;
import net.comes.care.ui.wizards.pages.SensorAndPatientPage;

import org.eclipse.jface.wizard.Wizard;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class ImportWizard extends Wizard {
	
	private final ISensorDirectoryService directoryService;
	private final Patient patient;
	private final ISensor sensor;

	/**
	 * 
	 * @param directoryService
	 * @param patient - can be null
	 * @param sensor - can be null
	 */
	public ImportWizard(ISensorDirectoryService directoryService, Patient patient, ISensor sensor) {
		this.directoryService = directoryService;
		this.patient = patient;
		this.sensor = sensor;
		setWindowTitle("Datenimport");
	}

	@Override
	public void addPages() {
		addPage(new SensorAndPatientPage(directoryService, patient, sensor));
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
