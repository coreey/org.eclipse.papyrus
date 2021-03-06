/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which accompanies this distribution, and is
t https://www.eclipse.org/legal/epl-2.0/
t
t SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

/**
 * Meant to implemented by the objects used in the ExtensionPointParser.
 *
 * @author gmerin
 *
 */
public interface IObjectWithContributorId {

	/**
	 * Return the Plugin's ID that made the contribution of this object
	 *
	 * @return The Plugin's ID String
	 */
	// @unused
	public String getContributorId();

	/**
	 * Set the Plugin's ID that made the contribution of this object
	 */
	public void setContributorId(String contributorId);

}
