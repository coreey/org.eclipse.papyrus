/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 377866 - selection customization
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.ui;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;

/**
 *
 * @since 0.2
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ISelectionPropertiesHandler {
	/** This customization property returns the selection for a given source EObject and a given ETypedElement parameter */
	FacetOperation getSelectionProperty();
}
