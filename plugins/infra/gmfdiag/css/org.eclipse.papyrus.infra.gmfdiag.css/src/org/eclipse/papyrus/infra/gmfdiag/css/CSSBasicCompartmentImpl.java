/*****************************************************************************
 * Copyright (c) 2012, 2016, 2019 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus - bugs 433206, 436665
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - bug 544547
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.impl.BasicCompartmentImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDrawerStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSView;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSDrawerStyleDelegate;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSViewDelegate;

public class CSSBasicCompartmentImpl extends BasicCompartmentImpl implements CSSDrawerStyle, CSSView.Internal {

	protected ExtendedCSSEngine engine;

	private CSSDrawerStyle drawerStyle;

	private CSSView cssView;

	protected CSSDrawerStyle getDrawerStyle() {
		if (drawerStyle == null) {
			drawerStyle = new CSSDrawerStyleDelegate(this, getEngine());
		}
		return drawerStyle;
	}

	protected ExtendedCSSEngine getEngine() {
		if (engine == null) {
			engine = ((CSSDiagram) getDiagram()).getEngine();
		}
		return engine;
	}

	protected CSSView getCSSView() {
		if (cssView == null) {
			cssView = new CSSViewDelegate(this, getEngine());
		}
		return cssView;
	}

	@Override
	public void resetCSS() {
		cssView = null;
		engine = null;
	}


	// ////////////////////////////////////////
	// Forwards accesses to CSS properties //
	// ////////////////////////////////////////


	@Override
	public boolean isCSSCollapsed() {
		boolean value = super.isCollapsed();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), value)) {
			return value;
		} else {
			return getDrawerStyle().isCSSCollapsed();
		}
	}


	@Override
	public boolean isCollapsed() {
		return isCSSCollapsed();
	}

	@Override
	public boolean isVisible() {
		return isCSSVisible();
	}

	@Override
	public boolean isCSSVisible() {
		boolean value = super.isVisible();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getView_Visible(), value)) {
			return value;
		} else {
			return getCSSView().isCSSVisible();
		}
	}



	// //////////////////////////////////////////////
	// Implements a setter for each CSS property //
	// //////////////////////////////////////////////

	@Override
	public void setVisible(boolean value) {
		super.setVisible(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Visible();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setType(java.lang.String value) {
		super.setType(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Type();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setMutable(boolean value) {
		super.setMutable(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Mutable();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setCollapsed(boolean value) {
		super.setCollapsed(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getDrawerStyle_Collapsed();
		ForceValueHelper.setValue(this, feature, value);
	}

	// ////////////////////////////////
	// Implements the unset method //
	// ////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(this, feature);
	}

	// ////////////////////////////////
	// Implements the getNamedStyle //
	// ////////////////////////////////

	@Override
	public NamedStyle getNamedStyle(EClass eClass, String name) {
		return getCSSNamedStyle(eClass, name);
	}

	@Override
	public NamedStyle getCSSNamedStyle(EClass eClass, String name) {
		NamedStyle userStyle = super.getNamedStyle(eClass, name);
		if (userStyle != null) {
			return userStyle;
		}

		return getCSSView().getCSSNamedStyle(eClass, name);
	}

	// /////////////////////////////////
	// Implements the getStyle method //
	// /////////////////////////////////

	@Override
	public Style getStyle(EClass eClass) {
		return getCSSStyle(eClass);
	}

	@Override
	public Style getCSSStyle(EClass eClass) {
		Style userStyle = super.getStyle(eClass);
		if (userStyle != null) {
			return userStyle;
		}

		return getCSSView().getCSSStyle(eClass);
	}


}
