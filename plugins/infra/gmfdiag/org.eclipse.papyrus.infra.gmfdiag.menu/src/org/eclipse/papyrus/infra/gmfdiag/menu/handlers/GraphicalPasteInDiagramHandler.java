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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.menu.handlers;

import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;

/**
 * This Paste handler retarget the Paste action to the GMF action, but now this action is declared using the Eclipse Framework
 */
public class GraphicalPasteInDiagramHandler extends AbstractDiagramActionHandler {

	/**
	 *
	 * @see org.eclipse.papyrus.infra.gmfdiag.menu.handlers.AbstractDiagramActionHandler#getActionId()
	 *
	 * @return
	 */
	@Override
	protected String getActionId() {
		return GlobalActionId.PASTE;
	}

}
