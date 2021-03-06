/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.BehaviorPortEditPart;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

/**
 * This class provide customization of the CreationEditPolicy to support the case where
 * a Port or Parameter is created in a Compartment. In such a case the Port (Parameter) should be added to the compartment owner.
 *
 */
public class PortInCompartmentCreationEditPolicy extends DefaultCreationEditPolicy {
	@Override
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest createUnspecifiedTypeRequest = (CreateUnspecifiedTypeRequest) request;
			if (understandsRequest(request)) {
				List<?> elementTypes = createUnspecifiedTypeRequest.getElementTypes();
				// Treat the case where only one element type is listed
				// Only take Port or Parameter element type into account
				if ((elementTypes.size() == 1) && (((IElementType) (elementTypes.get(0)) == UMLElementTypes.Port_Shape) || ((IElementType) (elementTypes.get(0)) == UMLElementTypes.Parameter_Shape))) {
					// If the target is a compartment replace by its parent edit part
					if ((getHost() instanceof ShapeCompartmentEditPart)) {
						return getHost().getParent();
					}
				}
			}
		}
		return super.getTargetEditPart(request);
	}

	@Override
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		Iterator<?> editParts = request.getEditParts().iterator();
		while (editParts.hasNext()) {
			EditPart ep = (EditPart) editParts.next();
			if (ep instanceof BehaviorPortEditPart) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getReparentCommand(request);
	}
}
