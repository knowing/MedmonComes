package net.comes.care.ws;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

	public static final String PLUGIN_ID = "net.comes.care.ws";
	private static BundleContext context;
	
	private final Logger log = LoggerFactory.getLogger(PLUGIN_ID);

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		log.debug("Start " + PLUGIN_ID +" bundle");
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		log.debug("Stop " + PLUGIN_ID +" bundle");
		Activator.context = null;
	}

}
