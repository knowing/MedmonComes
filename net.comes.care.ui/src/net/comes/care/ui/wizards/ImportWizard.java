package net.comes.care.ui.wizards;

import net.comes.care.ui.wizards.pages.SensorAndPatientPage;

import org.eclipse.jface.wizard.Wizard;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class ImportWizard extends Wizard {
	
	private final ISensorDirectoryService directoryService;

	public ImportWizard(ISensorDirectoryService directoryService) {
		this.directoryService = directoryService;
		setWindowTitle("Datenimport");
	}

	@Override
	public void addPages() {
		addPage(new SensorAndPatientPage(directoryService));
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
