/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component;

import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;

/**
 * A factory for creating ComponentDiagramEditor objects.
 */
public class ComponentDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * Instantiates a new component diagram editor factory.
	 */
	public ComponentDiagramEditorFactory() {
		super(UmlComponentDiagramForMultiEditor.class, ComponentDiagramEditPart.MODEL_ID);

	}


}
