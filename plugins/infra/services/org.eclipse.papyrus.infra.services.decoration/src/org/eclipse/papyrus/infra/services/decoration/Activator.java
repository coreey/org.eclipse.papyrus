/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.decoration;

import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.services.decoration"; //$NON-NLS-1$

	/** The shared instance (Singleton pattern). */
	private static Activator plugin;

	/** The log service. */
	public static LogHelper log;


	/**
	 * The constructor.
	 */
	public Activator() {
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 *
	 * @param context
	 * @throws Exception
	 */

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(plugin);
	}


	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 *
	 * @param context
	 * @throws Exception
	 */

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		log = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
