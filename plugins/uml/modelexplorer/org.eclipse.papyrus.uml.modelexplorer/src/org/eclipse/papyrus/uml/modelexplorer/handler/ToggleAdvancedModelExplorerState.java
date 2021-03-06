/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 434635
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.handler;

import org.eclipse.core.commands.State;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.views.modelexplorer.Activator;

/**
 * State for the AdvancedModelExplorer toggle action
 *
 * @author Camille Letavernier
 *
 * @see {@link ToggleAdvancedModelExplorerHandler}
 *
 */
public class ToggleAdvancedModelExplorerState extends State {

	@Override
	public Boolean getValue() {
		ICustomizationManager customizationManager = Activator.getDefault().getCustomizationManager();
		ICustomizationCatalogManager customCatalog = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(customizationManager.getResourceSet());
		Customization simpleUMLCustomization = null;

		// look for SIMPLE UML Customization
		for (Customization customization : customCatalog.getRegisteredCustomizations()) {
			if (ToggleAdvancedModelExplorerHandler.SIMPLE_UML_CUSTOMIZATION.equals(customization.getName())) {
				simpleUMLCustomization = customization;
			}
		}

		if (simpleUMLCustomization == null) {
			// The SimpleUML Customization doesn't exist. The advanced mode is activated
			return true;
		}

		return !customizationManager.getManagedCustomizations().contains(simpleUMLCustomization);
	}

}
