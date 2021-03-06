/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.views.properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.properties.spi.IPropertiesResolver;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.views.properties"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * Log
	 */
	public static LogHelper log;

	private ServiceRegistration<IPropertiesResolver> propertiesResolverReg;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(plugin);

		// We can resolve ppe: scheme URIs against our workspace metadata storage path
		propertiesResolverReg = context.registerService(IPropertiesResolver.class,
				ppeURI -> ppeURI.resolve(URI.createFileURI(getPreferencesPath().toString() + "/")),
				null);

		Job startProperties = new Job("Starting Configuration Manager") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ConfigurationManager.getInstance();
				return Status.OK_STATUS;
			}
		};

		startProperties.setSystem(true);
		startProperties.schedule();
	}

	/**
	 * @return The IPath representing the plugin's preferences folder location
	 */
	public IPath getPreferencesPath() {
		return getStateLocation();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (propertiesResolverReg != null) {
			propertiesResolverReg.unregister();
			propertiesResolverReg = null;
		}

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns the image at the given path from this plugin
	 *
	 * @param path
	 *            the path of the image to be displayed
	 * @return The Image at the given location, or null if it couldn't be found
	 */
	public Image getImage(String path) {
		return getImage(PLUGIN_ID, path);
	}

	/**
	 * Returns the image from the given image descriptor
	 *
	 * @param pluginId
	 *            The plugin in which the image is located
	 * @param path
	 *            The path to the image from the plugin
	 * @return
	 * 		The Image at the given location, or null if it couldn't be found
	 */
	public Image getImage(String pluginId, String path) {
		final ImageRegistry registry = getImageRegistry();
		String key = pluginId + "/" + path; //$NON-NLS-1$
		Image image = registry.get(key);
		if (image == null) {
			registry.put(key, AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, path));
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Returns the image from the given path
	 *
	 * @param imagePath
	 *            The path of the image, in the form /<plug-in ID>/<path to the image>
	 * @return
	 * 		The Image at the given location, or null if none was found
	 */
	public Image getImageFromPlugin(String imagePath) {
		if (imagePath.startsWith("/")) { //$NON-NLS-1$
			String pluginId, path;
			imagePath = imagePath.substring(1, imagePath.length());
			pluginId = imagePath.substring(0, imagePath.indexOf("/")); //$NON-NLS-1$
			path = imagePath.substring(imagePath.indexOf("/"), imagePath.length()); //$NON-NLS-1$
			return getImage(pluginId, path);
		} else {
			return getImage(imagePath);
		}
	}
}
