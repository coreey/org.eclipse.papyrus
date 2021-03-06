/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;

public class GeneralOrderingDescriptor extends UMLEdgeFigure {

	private WrappingLabel fAppliedStereotypeLabel;

	public GeneralOrderingDescriptor() {
		this.setLineStyle(Graphics.LINE_DASH);
		this.setForegroundColor(ColorConstants.black);
		setTargetDecoration(createTargetDecoration());
	}

	@Override
	public void resetStyle() {
		super.resetStyle();
		setTargetDecoration(createTargetDecoration());
	}

	private RotatableDecoration createTargetDecoration() {
		IMapMode mapMode = SequenceMapModeUtil.getMapModel(this);
		PolygonDecoration df = new PolygonDecoration();
		df.setFill(true);
		df.setForegroundColor(ColorConstants.black);
		df.setBackgroundColor(ColorConstants.black);
		PointList pl = new PointList();
		pl.addPoint(mapMode.DPtoLP(-2), mapMode.DPtoLP(2));
		pl.addPoint(mapMode.DPtoLP(0), mapMode.DPtoLP(0));
		pl.addPoint(mapMode.DPtoLP(-2), mapMode.DPtoLP(-2));
		pl.addPoint(mapMode.DPtoLP(-2), mapMode.DPtoLP(2));
		df.setTemplate(pl);
		df.setScale(mapMode.DPtoLP(7), mapMode.DPtoLP(3));
		return df;
	}

	@Override
	public WrappingLabel getAppliedStereotypeLabel() {
		return fAppliedStereotypeLabel;
	}
}