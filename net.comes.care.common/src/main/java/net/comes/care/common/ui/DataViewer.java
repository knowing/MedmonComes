package net.comes.care.common.ui;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;

public class DataViewer extends TableViewer {

	public DataViewer(Composite parent, int style) {
		super(parent, style);
		setContentProvider(new ArrayContentProvider());
		setLabelProvider(new DataLabelProvider());
	}
	
	public void setInput(ISensor sensor, String directory) {
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
		setInput(uriList);
	}
	
	@SuppressWarnings("unchecked")
	public List<URI> getSelectedFiles() {
		ISelection selection = getSelection();
		if(selection.isEmpty())
			return (List<URI>) getInput();
		IStructuredSelection sel = (IStructuredSelection) selection;
		return sel.toList();
	}
	
	public class DataLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			URI uri = (URI) element;
			switch (columnIndex) {
			case 0:
				return Paths.get(uri).getFileName().toString();
			default:
				return getText(element);
			}
		}
	}
}
