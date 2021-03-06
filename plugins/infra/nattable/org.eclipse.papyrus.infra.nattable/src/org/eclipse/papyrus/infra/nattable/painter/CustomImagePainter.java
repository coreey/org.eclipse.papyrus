/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.painter;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.ImagePainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;

/**
 *
 * Custom Image painter for the header of the table
 *
 */
public class CustomImagePainter extends ImagePainter {

	private LabelProviderCellContextElementWrapper contextElement = new LabelProviderCellContextElementWrapper();
	/**
	 *
	 * @see org.eclipse.nebula.widgets.nattable.painter.cell.ImagePainter#getImage(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell, org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 *
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	@Override
	protected Image getImage(ILayerCell cell, IConfigRegistry configRegistry) {
		contextElement.setConfigRegistry(configRegistry);
		contextElement.setCell(cell);
		contextElement.setObject(cell.getDataValue());
		final LabelProviderService serv = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		final ILabelProvider provider = serv.getLabelProvider(Constants.TABLE_LABEL_PROVIDER_CONTEXT, contextElement);
		return provider.getImage(contextElement);
	}
}
