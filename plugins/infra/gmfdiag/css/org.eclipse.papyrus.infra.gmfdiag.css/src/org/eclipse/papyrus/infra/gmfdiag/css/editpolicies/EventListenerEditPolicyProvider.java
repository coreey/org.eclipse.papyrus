/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.editpolicies;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.service.ProviderServiceUtil;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;

/**
 * An a provide which installs EventListenerEditPolicy on EditPart which support CSS Styling
 *
 * @author Camille Letavernier
 *
 */
// TODO: Currently this provider is not plugged. Performance improvements are required
public class EventListenerEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	@Override
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation) operation;
		EditPart editPart = epOperation.getEditPart();
		if (!ProviderServiceUtil.isEnabled(this, editPart)) {
			return false;
		}
		if (!(editPart instanceof GraphicalEditPart)) {
			return false;
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(editPart);
		if (domain == null) {
			return false;
		}

		ResourceSet resourceSet = domain.getResourceSet();
		return CSSHelper.isCSSSupported(resourceSet);
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EventListenerEditPolicy.ROLE, new EventListenerEditPolicy());
	}

}
