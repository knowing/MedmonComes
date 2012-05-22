package net.comes.care.ui.preferences;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;

public class SensorPreferences {

	public static final String NODE_PATH = "medmon.sensor";
	public static final String SENSOR_PATH = "path";
	public static final String LAST_SENSOR_ID = "id";
	
	/**
	 * 
	 * @param sensor
	 * @return 
	 */
	public static IEclipsePreferences getPreferenceNode(ISensor sensor) {
		return ConfigurationScope.INSTANCE.getNode(NODE_PATH + "." + sensor.getId());
	}
	
	/**
	 * Looks up the sensor path in the eclipse preferences
	 * @param sensor
	 * @return path or empty string
	 */
	public static String getSensorPath(ISensor sensor) {
		return getPreferenceNode(sensor).get(SENSOR_PATH, "");
	}
}
