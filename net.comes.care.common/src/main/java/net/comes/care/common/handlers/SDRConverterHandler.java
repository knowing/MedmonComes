package net.comes.care.common.handlers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;

import net.comes.care.common.evaluation.EvaluationDialog;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.lmu.ifi.dbs.knowing.core.exceptions.KnowingException;
import de.lmu.ifi.dbs.knowing.core.exceptions.ValidationException;
import de.lmu.ifi.dbs.knowing.core.model.IDataProcessingUnit;
import de.lmu.ifi.dbs.knowing.core.service.IActorSystemManager;
import de.lmu.ifi.dbs.knowing.core.service.IDPUDirectory;
import de.lmu.ifi.dbs.knowing.core.service.IEvaluateService;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class SDRConverterHandler {

	private final Logger log = LoggerFactory.getLogger(SDRConverterHandler.class);

	@Inject
	private ISensorDirectoryService sensorDir;

	@Execute
	public void execute(@Named("net.comes.care.parameters.file") String file,
			@Optional @Named("net.comes.care.parameters.uifactory") String uifactory,
			@Optional @Named("net.comes.care.parameters.sensor") String sensorId, @Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			IActorSystemManager asm, IDPUDirectory dpuDir, IEvaluateService eval) {

		log.debug("Start evaluation with file[" + file + "], uifactory [" + uifactory + "], sensorId [" + sensorId + "]");
		EvaluationDialog dlg = new EvaluationDialog(shell, asm);
		dlg.open();
		try {
			// TODO generate execution path
			Path execPath = Paths.get(System.getProperty("user.home"), "wekafiles", "comes");

			// Check file if it exists
			Path sdrFile = Paths.get(file);
			Files.copy(sdrFile, execPath.resolve(sdrFile.getFileName()), StandardCopyOption.REPLACE_EXISTING);

			Properties parameters = new Properties();
			parameters.setProperty("sdr-file", sdrFile.getFileName().toString());
			parameters.setProperty("arff-output", sdrFile.getFileName().toString() + "-results.arff");

			IDataProcessingUnit dpu = dpuDir.getDPU("SDR Classification No UI").get();
			eval.evaluate(dpu, execPath.toUri(), dlg.getUiFactory(), dlg.getSystem(), parameters, null, null);

			// clean up
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ValidationException ex) {
			ex.printStackTrace();
			System.out.println(ex.getErrors());
		} catch (KnowingException ex) {
			ex.printStackTrace();
		}

		// DPUs
		// ARFF Classification Testing

		// 1. Selected SDR file
		// 2. Call SDRConverterHandler with parameters
		// "DPU  := SDR Classification Testing"
		// "File := <path-to-file>
		// 3. SDRConverterHandler loads and configures DPU
	}
}
