/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.providers;

import org.eclipse.papyrus.uml.diagram.clazz.custom.factory.CustomUMLEditPartFactory;

public class CustomUMLEditPartProvider extends org.eclipse.papyrus.uml.diagram.clazz.providers.UMLEditPartProvider {

	public CustomUMLEditPartProvider() {
		setFactory(new CustomUMLEditPartFactory());
		setAllowCaching(true);
	}
}
