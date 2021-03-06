/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.properties.ui.providers;

import org.eclipse.papyrus.infra.properties.ui.widgets.MaskProvider;

/**
 * Given the way the XWT files are parsed, the MaskProvider is passed to its
 * parent before being fully initialized.
 *
 * This interface enables a MaskProvider to notify its parent when it is ready,
 * so that the parent is forced to wait for its MaskProvider to be ready before
 * it can call any method on it.
 *
 * @author Camille Letavernier
 */
public interface XWTCompliantMaskProvider extends MaskProvider {

	public void addMaskProviderListener(XWTCompliantMaskProviderListener listener);

	public void removeMaskProviderListener(XWTCompliantMaskProviderListener listener);
}
