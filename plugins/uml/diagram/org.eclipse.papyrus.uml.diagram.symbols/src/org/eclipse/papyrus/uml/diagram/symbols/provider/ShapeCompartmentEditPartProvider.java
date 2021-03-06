/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.symbols.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.AbstractShapeCompartmentEditPartProvider;

/**
 * provides edit part to display shapes in compartment for all Papyrus diagrams
 */
public class ShapeCompartmentEditPartProvider extends AbstractShapeCompartmentEditPartProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		// should test here for Papyrus?

		return super.provides(operation);
	}

}
