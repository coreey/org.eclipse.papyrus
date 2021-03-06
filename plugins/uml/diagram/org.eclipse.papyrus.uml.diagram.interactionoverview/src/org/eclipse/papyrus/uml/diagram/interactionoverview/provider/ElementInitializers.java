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
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.CallBehaviorAction;


public class ElementInitializers extends org.eclipse.papyrus.uml.diagram.activity.providers.ElementInitializers {

	public static ElementInitializers getInstance() {
		ElementInitializers cached = Activator.getInstance().getElementInitializers();
		if (cached == null) {
			UMLDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}

	public void init_CallBehaviorAction_InteractionShape(final CallBehaviorAction instance) {
		try {
			final Object value_0 = name_CallBehaviorAction_InteractionShape(instance);
			instance.setName((String) value_0);
		} catch (final RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	private String name_CallBehaviorAction_InteractionShape(final CallBehaviorAction self) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(self.eClass().getName(), self.eContainer().eContents());
	}
}
