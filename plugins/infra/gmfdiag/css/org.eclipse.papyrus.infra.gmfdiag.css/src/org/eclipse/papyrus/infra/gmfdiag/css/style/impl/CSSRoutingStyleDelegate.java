/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.style.impl;

import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSRoutingStyle;
import org.w3c.dom.css.CSSValue;

public class CSSRoutingStyleDelegate implements CSSRoutingStyle {

	private RoutingStyle routingStyle;

	private ExtendedCSSEngine engine;

	public CSSRoutingStyleDelegate(RoutingStyle routingStyle, ExtendedCSSEngine engine) {
		this.routingStyle = routingStyle;
		this.engine = engine;
	}

	// //////////////////////////////////////////////
	// Implements a getter for each CSS property //
	// //////////////////////////////////////////////

	@Override
	public int getCSSRoundedBendpointsRadius() {
		CSSValue cssValue = engine.retrievePropertyValue(routingStyle, "roundedBendpointsRadius");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius().getDefaultValue();
			return (Integer) defaultValue;
		}
		return (Integer) engine.convert(cssValue, Integer.class, null);
	}

	@Override
	public Routing getCSSRouting() {
		CSSValue cssValue = engine.retrievePropertyValue(routingStyle, "routing");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_Routing().getDefaultValue();
			return (Routing) defaultValue;
		}
		return Routing.get(cssValue.getCssText());
	}

	@Override
	public Smoothness getCSSSmoothness() {
		CSSValue cssValue = engine.retrievePropertyValue(routingStyle, "smoothness");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_Smoothness().getDefaultValue();
			return (Smoothness) defaultValue;
		}
		return Smoothness.get(cssValue.getCssText());
	}

	@Override
	public boolean isCSSAvoidObstructions() {
		CSSValue cssValue = engine.retrievePropertyValue(routingStyle, "avoidObstructions");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions().getDefaultValue();
			return (Boolean) defaultValue;
		}
		return (Boolean) engine.convert(cssValue, Boolean.class, null);
	}

	@Override
	public boolean isCSSClosestDistance() {
		CSSValue cssValue = engine.retrievePropertyValue(routingStyle, "closestDistance");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance().getDefaultValue();
			return (Boolean) defaultValue;
		}
		return (Boolean) engine.convert(cssValue, Boolean.class, null);
	}

	@Override
	public JumpLinkStatus getCSSJumpLinkStatus() {
		CSSValue cssValue = engine.retrievePropertyValue(routingStyle, "jumpLinkStatus");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus().getDefaultValue();
			return (JumpLinkStatus) defaultValue;
		}
		return JumpLinkStatus.get(cssValue.getCssText());
	}

	@Override
	public JumpLinkType getCSSJumpLinkType() {
		CSSValue cssValue = engine.retrievePropertyValue(routingStyle, "jumpLinkType");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType().getDefaultValue();
			return (JumpLinkType) defaultValue;
		}
		return JumpLinkType.get(cssValue.getCssText());
	}

	@Override
	public boolean isCSSJumpLinksReverse() {
		CSSValue cssValue = engine.retrievePropertyValue(routingStyle, "jumpLinksReverse");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse().getDefaultValue();
			return (Boolean) defaultValue;
		}
		return (Boolean) engine.convert(cssValue, Boolean.class, null);
	}
}
