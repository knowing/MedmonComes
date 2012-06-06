package net.comes.care.common.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

import de.lmu.ifi.dbs.knowing.core.service.IDPUDirectory;
import de.lmu.ifi.dbs.knowing.core.service.IEvaluateService;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class SDRConverterHandler {

	@Inject
	private IEvaluateService eval;

	@Inject
	private IDPUDirectory dpuDir;

	@Inject
	private ISensorDirectoryService sensorDir;

	@Execute
	public void execute(@Named("net.comes.care.parameters.file") String uifactory, @Named("net.comes.care.parameters.file") String file,
			@Named("net.comes.care.parameters.sensor") String sensorId, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
	}
}
