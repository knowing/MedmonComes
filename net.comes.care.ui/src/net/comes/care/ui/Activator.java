package net.comes.care.ui;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "net.comes.care.ui"; //$NON-NLS-1$
	
	private static BundleContext context;

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
