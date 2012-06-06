package net.comes.care.ui.viewer;

import net.comes.care.common.preferences.SensorPreferences;
import net.comes.care.ui.Activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.osgi.service.prefs.BackingStoreException;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;

public class SensorPathEditingSupport extends EditingSupport {

	public SensorPathEditingSupport(TableViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new PathDialogCellEditor(((TableViewer) getViewer()).getTable());
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		return SensorPreferences.getPreferenceNode((ISensor) element).get(SensorPreferences.SENSOR_PATH, "");
	}

	@Override
	protected void setValue(Object element, Object value) {
		IEclipsePreferences config = SensorPreferences.getPreferenceNode((ISensor) element);
		config.put(SensorPreferences.SENSOR_PATH, value.toString());
		try {
			config.flush();
		} catch (BackingStoreException e) {
			//Try to use StatusManager
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, "", e);
			ErrorDialog.openError(getViewer().getControl().getShell(), "Error saving preferences", null, status);
			e.printStackTrace();
		}
		getViewer().refresh();
	}

}
