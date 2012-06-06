package net.comes.care.common.internal;

import java.net.URL;

import net.comes.care.common.resources.ResourceManager;

import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public static final String PLUGIN_ID = "net.comes.care.common"; //$NON-NLS-1$

	private static BundleContext context;

	@Override
	public void start(BundleContext context) throws Exception {

	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

	public static BundleContext getBundleContext() {
		return context;
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		if(context != null) {
			URL resource = context.getBundle().getResource(path);
			return ImageDescriptor.createFromURL(resource);
		}
		return ResourceManager.getPluginImageDescriptor(PLUGIN_ID, path);
	}
}
