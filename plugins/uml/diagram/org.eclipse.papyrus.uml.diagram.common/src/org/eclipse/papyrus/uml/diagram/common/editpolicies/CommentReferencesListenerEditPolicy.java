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
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.uml2.uml.Comment;


public class CommentReferencesListenerEditPolicy extends AbstractNameReferencesListenerEditPolicy {

	@Override
	protected String getText() {
		return getModel().getBody();
	}

	@Override
	protected Comment getModel() {
		return (Comment) super.getModel();
	}

}
