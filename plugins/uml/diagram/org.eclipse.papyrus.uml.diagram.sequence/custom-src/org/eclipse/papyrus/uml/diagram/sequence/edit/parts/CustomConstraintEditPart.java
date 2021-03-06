/*****************************************************************************
 * Copyright (c) 2010, 2021 CEA, ARTAL
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
 *   Soyatec - Initial API and implementation
 *   Etienne ALLOGO (ARTAL) - etienne.allogo@artal.fr - Bug 569174 : generate less dead - method visibility changed
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomConstraintEditPart extends ConstraintEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomConstraintEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = super.createNodeFigure();
		figure.setForegroundColor(ColorConstants.black); // fix constraint link color
		figure.setBackgroundColor(ColorConstants.black);
		return figure;
	}


	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		if (event.getFeature() instanceof EReference) {
			EReference ref = (EReference) event.getFeature();
			if ("specification".equals(ref.getName())) {
				List<?> parts = getChildren();
				for (Object p : parts) {
					if (p instanceof Constraint2EditPart) {
						((Constraint2EditPart) p).notifyChanged(event); // Bug 569174 : handleNotificationEvent visibility changed
					}
				}
			}
		}
	}

	@Override
	protected void setLineWidth(int width) {
		if (primaryShape instanceof NodeFigure) {
			((NodeFigure) primaryShape).setLineWidth(width);
		}
		super.setLineWidth(width);
	}

	protected void refreshLabel() {
		List<?> parts = getChildren();
		for (Object p : parts) {
			if (p instanceof Constraint2EditPart) {
				((Constraint2EditPart) p).refresh(); // Bug 569174 : refreshLabel visibility changed
			}
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshTransparency();
	}

	@Override
	protected void refreshTransparency() {
		FillStyle style = (FillStyle) getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if (style != null) {
			setTransparency(style.getTransparency());
		}
	}

	@Override
	protected IElementType elementTypeOfToolAfterCreation() {
		return UMLElementTypes.Constraint_ContextEdge;
	}
}
