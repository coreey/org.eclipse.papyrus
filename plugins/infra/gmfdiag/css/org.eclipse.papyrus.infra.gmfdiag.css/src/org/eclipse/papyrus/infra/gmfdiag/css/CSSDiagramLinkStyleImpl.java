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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramLinkStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDiagramLinkStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSDiagramLinkStyleDelegate;

public class CSSDiagramLinkStyleImpl extends DiagramLinkStyleImpl implements CSSDiagramLinkStyle {

	protected ExtendedCSSEngine engine;

	private CSSDiagramLinkStyle diagramLinkStyle;

	protected CSSDiagramLinkStyle getDiagramLinkStyle() {
		if (diagramLinkStyle == null) {
			diagramLinkStyle = new CSSDiagramLinkStyleDelegate(this, getEngine());
		}
		return diagramLinkStyle;
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





	// //////////////////////////////////////////////
	// Implements a setter for each CSS property //
	// //////////////////////////////////////////////


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
