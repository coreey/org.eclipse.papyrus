/*****************************************************************************
 * Copyright (c) 2010, 2016 ATOS ORIGIN, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.toolbox.utils;

import java.io.IOException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.papyrus.infra.widgets.toolbox.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;


/**
 * A class retrieving the icons used in papyrus toolbox
 *
 * @author tfaure
 *
 */
public class ToolbooxImageUtils {

	/**
	 * Returns an image according to {@link ISharedImages}
	 *
	 * @param id
	 *            , the constant
	 * @return
	 */
	public static Image getImage(int id) {
		StringBuffer path = new StringBuffer("/icons/");
		switch (id) {
		case ISharedImages.IMG_RUN:
			path = path.append("run.gif");
			break;
		case ISharedImages.IMG_PAPYRUS:
			path = path.append("Papyrus.gif");
			break;
		default:
			break;
		}
		String key = Activator.PLUGIN_ID + path;
		Image result = JFaceResources.getImageRegistry().get(key);
		if (result == null) {
			URL url = Activator.getDefault().getBundle().getEntry(path.toString());
			try {
				if (url != null) {
					result = new Image(Display.getDefault(), url.openStream());
					JFaceResources.getImageRegistry().put(key, result);
				}
			} catch (IOException e) {
			}
		}
		return result;
	}

	/**
	 * Returns an image descriptor according to {@link ISharedImages}
	 *
	 * @param id
	 *            , the constant
	 * @return
	 */
	public static ImageDescriptor getImageDescriptor(final int id) {
		return new ImageDescriptor() {

			@Override
			public ImageData getImageData() {
				return getImage(id).getImageData();
			}
		};
	}
}
