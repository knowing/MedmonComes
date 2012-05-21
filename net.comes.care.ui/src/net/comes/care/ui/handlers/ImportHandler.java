package net.comes.care.ui.handlers;

import javax.inject.Named;

import net.comes.care.entity.Patient;
import net.comes.care.ui.views.PatientView;
import net.comes.care.ui.views.SensorView;
import net.comes.care.ui.wizards.ImportWizard;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class ImportHandler {


	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell, ISensorDirectoryService sensorDirectoryService,
			ESelectionService selectionService) {
		Patient patient = (Patient) selectionService.getSelection(PatientView.ID);
		ISensor sensor = (ISensor) selectionService.getSelection(SensorView.ID);
		new WizardDialog(shell, new ImportWizard(sensorDirectoryService, patient, sensor)).open();
	}
	
}
