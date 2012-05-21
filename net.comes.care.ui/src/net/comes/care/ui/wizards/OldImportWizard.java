package net.comes.care.ui.wizards;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import net.comes.care.ui.wizards.pages.DataPage;
import net.comes.care.ui.wizards.pages.SensorAndDirectoryPage;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensorDirectoryService;

public class OldImportWizard extends Wizard {

	private final ISensorDirectoryService sensorDirectoryService;
	
	private SensorAndDirectoryPage pageSensorAndDirectory;
	private DataPage pageDataPage;

	public OldImportWizard(ISensorDirectoryService sensorDirectoryService) {
		this.sensorDirectoryService = sensorDirectoryService;
		setWindowTitle("Import Wizard");
	}
	
	@Override
	public void addPages() {
		addPage(pageSensorAndDirectory = new SensorAndDirectoryPage(sensorDirectoryService));
		addPage(pageDataPage = new DataPage());
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page instanceof SensorAndDirectoryPage) {
			ISensor sensor = ((SensorAndDirectoryPage) page).getSelectedSensor();
			String directory = ((SensorAndDirectoryPage) page).getSelectedDirectory();
			DataPage dataPage = (DataPage) super.getNextPage(page);
			updateDataPage(dataPage, sensor, directory);
			return dataPage;
		}
		return super.getNextPage(page);
	}
	
	private void updateDataPage(DataPage dataPage, ISensor sensor, String directory) {
		List<URI> uriList = new ArrayList<URI>();
		try (DirectoryStream<Path> directoyStream = Files.newDirectoryStream(Paths.get(directory))) {
			String filePrefix = sensor.getFilePrefix();
			for (Path file : directoyStream) {
				// Don't use file.endsWith() -> checks the last foldername
				// of the path not the prefix of the file
				if (file.toString().endsWith(filePrefix))
					uriList.add(file.toUri());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		dataPage.setInput(null, uriList);
	}

	@Override
	public boolean performFinish() {
		ISensor sensor = pageSensorAndDirectory.getSelectedSensor();
		URI fileURI = pageDataPage.getSelectedURI();
		
		System.err.println("Sensor: " + sensor);
		System.err.println("File: " + fileURI);
		
		return false;
	}

}
