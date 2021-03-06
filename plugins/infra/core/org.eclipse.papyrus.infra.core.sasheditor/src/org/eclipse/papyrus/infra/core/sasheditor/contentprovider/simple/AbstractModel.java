/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL
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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;


/**
 * @author dumoulin
 */
public abstract class AbstractModel {


	/**
	 * Return the parent of the model. Can be null in the case of rootModel.
	 *
	 * @return the parent
	 */
	public abstract AbstractModel getParent();


	/**
	 * @param parent
	 *            the parent to set
	 */
	public abstract void setParent(AbstractModel parent);

	/**
	 * Replace the oldChild by the newChild
	 *
	 * @param oldChild
	 * @param newChild
	 */
	public abstract void replaceChild(AbstractPanelModel oldChild, AbstractPanelModel newChild);

}
