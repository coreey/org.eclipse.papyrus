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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The descriptor for ConditionalNode node used by
 * org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment extension point.
 *
 * @author vhemery
 */
public class ConditionalNodeContainment extends StructuredActivityNodeContainment {

	/**
	 * Get the eclass of the model eobject represented by the node
	 *
	 * @return ConditionalNode eclass
	 */
	@Override
	public EClass getContainerEClass() {
		return UMLPackage.eINSTANCE.getConditionalNode();
	}

	@Override
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		String hint = "" + ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID;
		return ((GraphicalEditPart) editpart).getChildBySemanticHintOnPrimaryView(hint);
	}
}
