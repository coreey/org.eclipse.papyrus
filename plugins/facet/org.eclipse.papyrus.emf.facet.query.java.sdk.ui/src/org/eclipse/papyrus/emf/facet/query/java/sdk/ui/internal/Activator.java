/**
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 */
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

// Copied from /org.eclipse.papyrus.emf.facet.aggregate.metamodel.notgenerated/src/org/eclipse/emf/facet/aggregate/metamodel/notgenerated/internal/Activator.java
@SuppressWarnings("PMD.UseSingleton")
// @SuppressWarnings("PMD.UseSingleton") We cannot conforms to this rule because
// this class is an Eclipse plug-in activator which will be instantiated by the
// Eclipse framework.
public class Activator extends Plugin {

	private static Activator plugin;

	@Override
	@SuppressWarnings("PMD.SignatureDeclareThrowsException")
	// @SuppressWarnings("PMD.SignatureDeclareThrowsException") We have to use
	// this signature because this is an override of an Eclipse framework's
	// method.
	public void start(final BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		Activator.plugin = this;
	}

	@Override
	@SuppressWarnings("PMD.SignatureDeclareThrowsException")
	// @SuppressWarnings("PMD.SignatureDeclareThrowsException") We have to use
	// this signature because this is an override of an Eclipse framework's
	// method.
	public void stop(final BundleContext bundleContext) throws Exception {
		// NOPMD: PMD say "Assigning an Object to null is a code smell."
		// No choice to right it in another way : this is an Eclipse pattern.
		Activator.plugin = null; // NOPMD by gdupe on 30/03/12 10:19
		super.stop(bundleContext);
	}

	public static Plugin getDefault() {
		return Activator.plugin;
	}

}
