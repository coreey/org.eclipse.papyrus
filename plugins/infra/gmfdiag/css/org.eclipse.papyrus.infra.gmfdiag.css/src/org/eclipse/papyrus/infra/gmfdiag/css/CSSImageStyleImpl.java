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
package org.eclipse.papyrus.infra.gmfdiag.css;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ImageStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSImageStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSImageStyleDelegate;

public class CSSImageStyleImpl extends ImageStyleImpl implements CSSImageStyle {

	protected ExtendedCSSEngine engine;

	private CSSImageStyle imageStyle;

	protected CSSImageStyle getImageStyle() {
		if (imageStyle == null) {
			imageStyle = new CSSImageStyleDelegate(this, getEngine());
		}
		return imageStyle;
	}

	protected ExtendedCSSEngine getEngine() {
		if (engine == null) {
			engine = ((CSSDiagram) findView().getDiagram()).getEngine();
		}
		return engine;
	}

	protected View findView() {
		EObject parent = eContainer();
		while (!(parent instanceof View) && parent != null) {
			parent = parent.eContainer();
		}

		if (parent != null) {
			return (View) parent;
		}

		return null;
	}


	// ////////////////////////////////////////
	// Forwards accesses to CSS properties //
	// ////////////////////////////////////////


	@Override
	public java.lang.Boolean getCSSAntiAlias() {
		java.lang.Boolean value = super.getAntiAlias();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getImageStyle_AntiAlias(), value)) {
			return value;
		} else {
			return getImageStyle().getCSSAntiAlias();
		}
	}

	@Override
	public java.lang.Boolean getCSSMaintainAspectRatio() {
		java.lang.Boolean value = super.getMaintainAspectRatio();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getImageStyle_MaintainAspectRatio(), value)) {
			return value;
		} else {
			return getImageStyle().getCSSMaintainAspectRatio();
		}
	}


	@Override
	public java.lang.Boolean getAntiAlias() {
		return getCSSAntiAlias();
	}

	@Override
	public java.lang.Boolean getMaintainAspectRatio() {
		return getCSSMaintainAspectRatio();
	}



	// //////////////////////////////////////////////
	// Implements a setter for each CSS property //
	// //////////////////////////////////////////////

	@Override
	public void setAntiAlias(java.lang.Boolean value) {
		super.setAntiAlias(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getImageStyle_AntiAlias();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setMaintainAspectRatio(java.lang.Boolean value) {
		super.setMaintainAspectRatio(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getImageStyle_MaintainAspectRatio();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	// ////////////////////////////////
	// Implements the unset method //
	// ////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(findView(), feature);
	}


}
