/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Adapted from Sequence Diagram
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.edit.parts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.communication.custom.figures.InteractionRectangleFigure;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.InteractionEditPart;
import org.eclipse.swt.graphics.Color;

/**
 * The Class CustomInteractionEditPart.
 */
public class CustomInteractionEditPart extends InteractionEditPart {

	/**
	 * Instantiates a new custom interaction edit part.
	 *
	 * @param view
	 *            the view
	 */
	public CustomInteractionEditPart(View view) {
		super(view);
	}

	/**
	 * The change in the background color of the Container must set the foreground color of the
	 * ContainerCompartment to avoid the separation line between the Compartment and the
	 * ContainerLabel.
	 *
	 * @param color
	 *            the new background color
	 *
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
			if (primaryShape instanceof InteractionRectangleFigure) {
				InteractionRectangleFigure irf = (InteractionRectangleFigure) primaryShape;
				if (irf.getCompartmentFigure() != null) {
					irf.getCompartmentFigure().setForegroundColor(color);
				}
			}
		}
	}
}
