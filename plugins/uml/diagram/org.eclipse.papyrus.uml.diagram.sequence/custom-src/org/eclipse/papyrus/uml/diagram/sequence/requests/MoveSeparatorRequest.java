/*****************************************************************************
 * Copyright (c) 2018 EclipseSource and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation (Bug 533770)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.requests;

import org.eclipse.gef.requests.ChangeBoundsRequest;

/**
 * <p>
 * A request to move the separator between two Operands in a CombinedFragment.
 * This should expand one of the Operands, and shrink the other one of the same
 * amount.
 * </p>
 *
 * @since 5.0
 */
public class MoveSeparatorRequest extends ChangeBoundsRequest {

	public static final String REQ_MOVE_SEPARATOR = "MoveSeparatorRequest";
	private final int separatorIndex;

	public MoveSeparatorRequest(int separatorIndex) {
		this.separatorIndex = separatorIndex;
	}

	@Override
	public Object getType() {
		return REQ_MOVE_SEPARATOR;
	}

	/**
	 * @return
	 *         The index of the separator being moved
	 */
	public int getSeparatorIndex() {
		return separatorIndex;
	}

}
