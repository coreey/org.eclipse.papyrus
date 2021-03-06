/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which accompanies this distribution, and is
t https://www.eclipse.org/legal/epl-2.0/
t
t SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.graphics.Image;

/**
 * Provides images (icons) and text (labels) for IAdaptable elements. This implementation can handle
 * IElementType elements.
 *
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @NOT-generated
 */
public class BaseModelTypeProvider implements IModelTypesProvider {

	/**
	 * Returns null.
	 */
	@Override
	public Image getImageHelper(IAdaptable hint) {
		return null;
	}

	/**
	 * Label to return for an unknown type of element.
	 */
	private static final String UNKNOWN_TEXT = "Unknown type";

	/**
	 * Returns the display name of the given IElementType
	 */
	@Override
	public String getTextHelper(IAdaptable hint) {
		IElementType elementType = (IElementType) Platform.getAdapterManager().getAdapter(hint, IElementType.class);
		if (elementType != null) {
			return elementType.getDisplayName();
		}
		return UNKNOWN_TEXT;
	}

}
