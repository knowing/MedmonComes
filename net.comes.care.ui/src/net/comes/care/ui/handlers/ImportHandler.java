package net.comes.care.ui.handlers;

import javax.inject.Named;

import net.comes.care.ui.wizards.ImportWizard;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class ImportHandler {

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell, ISensorDirectoryService sensorDirectoryService) {
		System.err.println("Execute");
		new WizardDialog(shell, new ImportWizard(sensorDirectoryService)).open();
	}
}
