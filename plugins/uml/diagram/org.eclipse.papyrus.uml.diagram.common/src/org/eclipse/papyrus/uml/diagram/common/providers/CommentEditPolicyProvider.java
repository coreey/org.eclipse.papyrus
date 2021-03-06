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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.common.service.ProviderServiceUtil;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractNameReferencesListenerEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.CommentReferencesListenerEditPolicy;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

/**
 * An edit policy provider to install
 *
 * @author Camille Letavernier
 *
 */
public class CommentEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	@Override
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation) operation;
		if (!ProviderServiceUtil.isEnabled(this, epOperation.getEditPart())) {
			return false;
		}
		Element element = UMLUtil.resolveUMLElement(epOperation.getEditPart());
		if (!(element instanceof Comment)) {
			return false;
		}
		try {
			ServicesRegistry registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(element);
			if (registry == null) {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}

		return !(epOperation.getEditPart() instanceof IPrimaryEditPart);
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(AbstractNameReferencesListenerEditPolicy.NAME_REFERENCES_LISTENER_ID, new CommentReferencesListenerEditPolicy());
	}

}
