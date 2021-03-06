/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.util;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.Activator;


/**
 * Util class for display in Papyrus (label providers, etc...)
 *
 * @deprecated Use the LabelProviderService instead
 * @since 1.2
 */
@Deprecated
public class DisplayUtils {

	/**
	 * Gets the shared label provider.
	 *
	 * @return Get the current {@link ILabelProvider} or <code>null</code> if
	 *         not found
	 */
	public static ILabelProvider getLabelProvider() {
		try {
			ServicesRegistry registry = EditorUtils.getServiceRegistry();
			return registry == null ? null : registry.getService(ILabelProvider.class);
		} catch (IllegalStateException e) {
			// Registry can't be found, do nothing.
			Activator.log.error(e);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

}
