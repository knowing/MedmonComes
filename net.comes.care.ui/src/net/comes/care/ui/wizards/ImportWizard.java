package net.comes.care.ui.wizards;

import net.comes.care.ui.wizards.pages.DataPage;
import net.comes.care.ui.wizards.pages.SensorAndDirectoryPage;

import org.eclipse.jface.wizard.Wizard;

public class ImportWizard extends Wizard {

	public ImportWizard() {
		setWindowTitle("Import Wizard");
	}

	@Override
	public void addPages() {
		addPage(new SensorAndDirectoryPage());
		addPage(new DataPage());
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
