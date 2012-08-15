package net.comes.care.patient;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	
	public static String PLUGIN_ID = "net.comes.care.patient";

	private static BundleContext context;//$NON-NLS-1$
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
	
	public static BundleContext getBundleContext() {
		return context;
	}
	
	public static ImageDescriptor getImageDescriptor(String path) {
		URL resource = context.getBundle().getResource(path);
		return ImageDescriptor.createFromURL(resource);
	}

}
