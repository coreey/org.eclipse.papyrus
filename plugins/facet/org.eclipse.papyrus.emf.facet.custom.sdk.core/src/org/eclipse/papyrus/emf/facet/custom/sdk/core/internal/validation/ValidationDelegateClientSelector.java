/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.sdk.core.internal.validation;

import org.eclipse.emf.validation.model.IClientSelector;

/** Enables validation depending on a client context. */
public class ValidationDelegateClientSelector implements IClientSelector {

	public boolean selects(final Object object) {
		// always enabled
		return true;
	}

}
