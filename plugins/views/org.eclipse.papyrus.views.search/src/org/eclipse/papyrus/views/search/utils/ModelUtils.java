/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;

public class ModelUtils {

	public static final ModelSet openResource(URI resourceURI) throws ModelMultiException {
		if (resourceURI != null) {
			// TODO: Need to be able to create CDOAwareModelSet
			ModelSet modelSet = new ModelSet();
			ModelsReader reader = new ModelsReader();
			reader.readModel(modelSet);
			modelSet.loadModels(resourceURI);
			return modelSet;
		} else {
			return null;
		}
	}

}
