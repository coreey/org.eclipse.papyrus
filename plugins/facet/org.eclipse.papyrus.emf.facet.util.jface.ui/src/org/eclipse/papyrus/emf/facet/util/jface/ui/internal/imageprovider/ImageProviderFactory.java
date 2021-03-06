/*******************************************************************************
 * Copyright (c) 2013 Soft-Maint.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thomas Cicognani (Soft-Maint) - Bug 424416 - Plug-in for JFace Utilities
 ******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.jface.ui.internal.imageprovider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.papyrus.emf.facet.util.jface.ui.imageprovider.IImageProvider;
import org.eclipse.papyrus.emf.facet.util.jface.ui.imageprovider.IImageProviderFactory;

public class ImageProviderFactory implements IImageProviderFactory {

	private final Map<Plugin, IImageProvider> map = new HashMap<Plugin, IImageProvider>();

	@Override
	public IImageProvider createIImageProvider(final Plugin plugin) {
		IImageProvider result = this.map.get(plugin);
		if (result == null) {
			result = new ImageProvider(plugin);
			this.map.put(plugin, result);
		}
		return result;
	}

}
