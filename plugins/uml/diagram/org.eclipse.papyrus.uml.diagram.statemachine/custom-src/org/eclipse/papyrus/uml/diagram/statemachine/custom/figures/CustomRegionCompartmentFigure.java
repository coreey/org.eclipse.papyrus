/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */

package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * This figure is used by a region. It displays the contents of a region.
 */
public class CustomRegionCompartmentFigure extends ShapeCompartmentFigure {

	public CustomRegionCompartmentFigure(String compartmentTitle, IMapMode mm) {
		super(compartmentTitle, mm);

		setTitleVisibility(false);

		setBorder(null);
	}

	@Override
	protected void configureFigure(IMapMode mm) {
		super.configureFigure(mm);
		scrollPane.setBorder(null);
	}

}
