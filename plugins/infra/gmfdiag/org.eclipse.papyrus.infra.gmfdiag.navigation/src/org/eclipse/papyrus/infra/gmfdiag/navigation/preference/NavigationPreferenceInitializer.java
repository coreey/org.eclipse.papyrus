/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.navigation.preference;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;

/**
 * This preference initializer initializes Navigation preferences
 */
public class NavigationPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize default preferences
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(INavigationPreferenceConstant.PAPYRUS_NAVIGATION_DOUBLECLICK_KIND, INavigationPreferenceConstant.EXPLICIT_IMPLICIT_NAVIGATION);
		store.setDefault(INavigationPreferenceConstant.PAPYRUS_NAVIGATION_DECORATOR_VISIBILITY, INavigationPreferenceConstant.DISPLAY_ONLY);
	}

	/**
	 * Get the preference store
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}
}
