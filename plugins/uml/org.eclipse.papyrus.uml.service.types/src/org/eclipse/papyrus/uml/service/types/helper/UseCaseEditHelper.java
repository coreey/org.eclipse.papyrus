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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;

/**
 * <pre>
 * 
 * Edit helper class for {@link UseCase}
 * 
 * Expected behavior:
 * - Remove any related {@link Include} or {@link Extend}
 * 
 * </pre>
 */
public class UseCaseEditHelper extends BehavioredClassifierEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getDestroyDependentsCommand(DestroyDependentsRequest req) {

		UseCase elementToDelete = (UseCase)req.getElementToDestroy();

		List<DirectedRelationship> relationships = new ArrayList<DirectedRelationship>();
		// Get related includes
		relationships.addAll(elementToDelete.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getInclude()));
		relationships.addAll(elementToDelete.getTargetDirectedRelationships(UMLPackage.eINSTANCE.getInclude()));
		// Get related extends
		relationships.addAll(elementToDelete.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getExtend()));
		relationships.addAll(elementToDelete.getTargetDirectedRelationships(UMLPackage.eINSTANCE.getExtend()));

		// Return the command to destroy all these Include and Extend relationships
		if(!relationships.isEmpty()) {
			return req.getDestroyDependentsCommand(relationships);
		}

		return super.getDestroyDependentsCommand(req);
	}
}
