package net.comes.care.sensors;

import java.io.IOException;
import java.io.InputStream;

import de.lmu.ifi.dbs.medmon.sensor.core.AbstractSensor;
import de.lmu.ifi.dbs.medmon.sensor.core.IConverter;

public class SendsorAccelerometer extends AbstractSensor{

	@Override
	public String getName() {
		return "Sendsor 3D Accelerometer";
	}

	@Override
	public String getDescription() {
		return "Sendsor 3D Accelerometer";
	}

	@Override
	public String getVersion() {
		return "Prototype 1";
	}

	@Override
	public String getFilePrefix() {
		return ".sdr";
	}

	@Override
	public boolean isConvertable(InputStream inputStream) throws IOException {
		return false;
	}

	@Override
	public IConverter newConverter(InputStream inputStream) throws IOException {
		return null;
	}

}
