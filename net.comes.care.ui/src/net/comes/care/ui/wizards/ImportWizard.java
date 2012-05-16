package net.comes.care.ui.wizards;

import net.comes.care.ui.wizards.pages.DataPage;
import net.comes.care.ui.wizards.pages.SensorAndDirectoryPage;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class ImportWizard extends Wizard {

	private final ISensorDirectoryService sensorDirectoryService;

	public ImportWizard(ISensorDirectoryService sensorDirectoryService) {
		this.sensorDirectoryService = sensorDirectoryService;
		setWindowTitle("Import Wizard");
	}
	
	@Override
	public void addPages() {
		addPage(new SensorAndDirectoryPage(sensorDirectoryService));
		addPage(new DataPage());
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page instanceof SensorAndDirectoryPage) {
			ISensor sensor = ((SensorAndDirectoryPage) page).getSelectedSensor();
			DataPage dataPage = (DataPage) super.getNextPage(page);
			dataPage.setInput(sensor, new Object[0]);
			return dataPage;
		}
		return super.getNextPage(page);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
