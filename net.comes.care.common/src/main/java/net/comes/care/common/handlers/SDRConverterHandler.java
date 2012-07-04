package net.comes.care.common.handlers;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;

import net.comes.care.common.evaluation.EvaluationDialog;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.lmu.ifi.dbs.knowing.core.exceptions.KnowingException;
import de.lmu.ifi.dbs.knowing.core.exceptions.ValidationException;
import de.lmu.ifi.dbs.knowing.core.model.IDataProcessingUnit;
import de.lmu.ifi.dbs.knowing.core.service.IDPUDirectory;
import de.lmu.ifi.dbs.knowing.core.service.IEvaluateService;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class SDRConverterHandler {

	private final Logger log = LoggerFactory.getLogger(SDRConverterHandler.class);

	@Inject
	private ISensorDirectoryService sensorDir;

	private Path execPath;

	@Execute
	public void execute(@Named("net.comes.care.parameters.file.source") String srcFile,
			@Named("net.comes.care.parameters.file.target") String trgFile,
			@Optional @Named("net.comes.care.parameters.uifactory") String uifactory,
			@Optional @Named("net.comes.care.parameters.sensor") String sensorId, IDPUDirectory dpuDir, IEvaluateService eval,
			IEventBroker broker, EvaluationDialog dlg) {

		log.debug("Start evaluation with file[" + srcFile + "], uifactory [" + uifactory + "], sensorId [" + sensorId + "]");
		dlg.open();
		try {
			execPath = Files.createTempDirectory("comes");
			log.debug("Executionpath : " + execPath);

			// Check file if it exists
			Path sdrFile = Paths.get(srcFile);
			Files.copy(sdrFile, execPath.resolve(sdrFile.getFileName()), StandardCopyOption.REPLACE_EXISTING);

			Properties parameters = new Properties();
			parameters.setProperty("sdr-file", sdrFile.getFileName().toString());
			parameters.setProperty("arff-output", trgFile);

			// SDR Classification No UI No Reclassification | SDR Classification No UI
			// SDR Classification To ACData No Reclassification
			IDataProcessingUnit dpu = dpuDir.getDPU("SDR Classification To ACData No Reclassification").get();
			eval.evaluate(dpu, execPath.toUri(), dlg.getUiFactory(), dlg.getSystem(), parameters, null, null);

			// clean up
			broker.subscribe(EvaluationDialog.FINISH_EVENT_TOPIC, new EventHandler() {

				@Override
				public void handleEvent(Event event) {
					try {
						Files.walkFileTree(execPath, new SimpleFileVisitor<Path>() {

							@Override
							public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
								Files.delete(file);
								return CONTINUE;
							}

							@Override
							public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
								if (exc == null) {
									Files.delete(dir);
									return CONTINUE;
								} else {
									throw exc;
								}
							}

						});
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});

		} catch (IOException ioe) {
			log.error("Error creating tmp directory.", ioe);
		} catch (ValidationException ex) {
			log.error(ex.getErrors().toString(), ex);
		} catch (KnowingException ex) {
			log.error("Exception in classification process.", ex);
		}
	}

}
