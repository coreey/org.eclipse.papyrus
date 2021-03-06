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
package org.eclipse.papyrus.infra.services.labelprovider.service;

import org.eclipse.jface.viewers.ILabelProvider;

/**
 * A LabelProvider which only accepts a specific set of objects
 *
 * @author Camille Letavernier
 */
public interface IFilteredLabelProvider extends ILabelProvider {

	public boolean accept(Object element);
}
