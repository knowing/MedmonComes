package net.comes.care.ui.viewer;

import net.comes.care.ui.Activator;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;

public class SensorTableViewer extends TableViewer {

	public SensorTableViewer(Composite parent, int style) {
		super(parent, style);
		init();
	}
	
	private void init() {
		getTable().setHeaderVisible(true);
		
		//Columns
		TableViewerColumn colName = new TableViewerColumn(this, SWT.LEAD);
		colName.getColumn().setText("Name");
		colName.getColumn().setResizable(true);
		colName.getColumn().setWidth(250);
		
		TableViewerColumn colVersion = new TableViewerColumn(this, SWT.LEAD);
		colVersion.getColumn().setText("Version");
		colVersion.getColumn().setResizable(true);
		colVersion.getColumn().setWidth(80);
		
		TableViewerColumn colPath = new TableViewerColumn(this, SWT.LEAD);
		colPath.getColumn().setText("Pfad");
		colPath.getColumn().setResizable(true);
		colPath.getColumn().setWidth(300);
		colPath.setEditingSupport(new SensorPathEditingSupport(this));
		colPath.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				
			}
		});
		
		//Provider
		setContentProvider(new ArrayContentProvider());
		setLabelProvider(new SensorLabelProvider());
		
	}
	
	public class SensorLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return Activator.getImageDescriptor("icons/24/usb.png").createImage();
			default:
				return null;
			}
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			ISensor sensor = (ISensor) element;
			switch (columnIndex) {
			case 0:
				return sensor.getName();
			case 1:
				return sensor.getVersion();
			case 2:
				return SensorPathEditingSupport.getSensorPath(sensor);
			default:
				return element.toString();
			}
		}

	}



}
