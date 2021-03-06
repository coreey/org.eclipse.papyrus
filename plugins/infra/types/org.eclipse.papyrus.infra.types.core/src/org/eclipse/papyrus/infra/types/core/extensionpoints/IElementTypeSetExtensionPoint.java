/*****************************************************************************
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.types.core.extensionpoints;

import org.eclipse.papyrus.infra.types.core.Activator;

public interface IElementTypeSetExtensionPoint {

	/** ID of the extension point */
	public static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".elementTypeSetConfiguration";

	/** attribute: path to the model file in the bundle */
	public static final String PATH = "path";

	/** attribute: identifier of the clientContext in which to register the elementTypeConfigurationSet */
	public static final String CLIENT_CONTEXT_ID = "clientContextID";
}
