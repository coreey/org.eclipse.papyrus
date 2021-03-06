/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.tests.tests.configs;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.papyrus.junit.framework.classification.InvalidTest;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the genericTreeTable model :
 *  - validate the model
 * 
 * @author Benoit Maggi
 */
public class GenericTreeTableConfigurationTest extends AbstractPapyrusTest{
	
	// path to the model
	public static final String GENERIC_TREE_TABLE_CONFIGURATION_MODEL_PATH = org.eclipse.papyrus.uml.nattable.Activator.PLUGIN_ID+"/configs/genericTreeTable.configuration"; //$NON-NLS-0$
	
	/**
	 * Validate the model with the rules defined in the meta-model tooling
	 */
	@InvalidTest("The current model is not complient with the ecore model")
	@Test
	public void validateGenericTreeTableConfigurationModel() {
		URI createPlatformPluginURI = URI.createPlatformPluginURI(GENERIC_TREE_TABLE_CONFIGURATION_MODEL_PATH, true);
		Resource resource = new ResourceSetImpl().getResource(createPlatformPluginURI, true);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		Assert.assertEquals("The genericTreeTable model is not valid ", Diagnostic.OK, diagnostic.getSeverity());
	}
}
