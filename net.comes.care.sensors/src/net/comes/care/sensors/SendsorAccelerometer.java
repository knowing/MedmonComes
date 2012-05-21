package net.comes.care.sensors;

import java.io.IOException;
import java.net.URI;

import weka.core.Instances;
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
	public Instances getHeader() {
		return null;
	}

	@Override
	public boolean isConvertable(URI input) throws IOException {
		return true;
	}

	@Override
	public IConverter newConverter(URI input) throws IOException {
		return null;
	}

}
