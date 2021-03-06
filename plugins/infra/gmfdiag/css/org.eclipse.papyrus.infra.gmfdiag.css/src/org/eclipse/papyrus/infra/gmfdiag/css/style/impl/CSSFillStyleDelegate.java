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

import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.GradientHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSFillStyle;
import org.w3c.dom.css.CSSValue;

public class CSSFillStyleDelegate implements CSSFillStyle {

	private FillStyle fillStyle;

	private ExtendedCSSEngine engine;

	public CSSFillStyleDelegate(FillStyle fillStyle, ExtendedCSSEngine engine) {
		this.fillStyle = fillStyle;
		this.engine = engine;
	}

	// //////////////////////////////////////////////
	// Implements a getter for each CSS property //
	// //////////////////////////////////////////////

	@Override
	public int getCSSFillColor() {
		CSSValue cssValue = engine.retrievePropertyValue(fillStyle, "fillColor");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_FillColor().getDefaultValue();
			return (Integer) defaultValue;
		}
		return (Integer) engine.convert(cssValue, "GMFColor", null);
	}

	@Override
	public int getCSSTransparency() {
		CSSValue cssValue = engine.retrievePropertyValue(fillStyle, "transparency");
		if (cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_Transparency().getDefaultValue();
			return (Integer) defaultValue;
		}
		return (Integer) engine.convert(cssValue, Integer.class, null);
	}

	@Override
	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient() {
		return GradientHelper.computeGradient(engine, fillStyle);
	}
}
