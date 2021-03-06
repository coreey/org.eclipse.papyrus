/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.decoration;

import java.util.List;
import java.util.Observer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;


/**
 * The Interface IDecorationService.
 */
public interface IDecorationService extends IMarkerEventListener {

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */

	void startService() throws ServiceException;

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */

	void disposeService() throws ServiceException;

	/**
	 * Adds the listener.
	 *
	 * @param o
	 *            the o
	 */
	void addListener(Observer o);

	/**
	 * Delete listener.
	 *
	 * @param o
	 *            the o
	 */
	void deleteListener(Observer o);

	/**
	 * Adds the decoration. If a decoration with the same ID already exists, do not add, but update
	 * the decoration.
	 *
	 * @param id
	 *            the id
	 * @param type
	 *            the decoration type, currently corresponding to the marker type
	 * @param element
	 *            the element
	 * @param decorationForGE
	 *            the decoration image for a graphical editor
	 * @param decorationForME
	 *            the decoration image for the model explorer
	 * @param message
	 *            the message
	 * @return the created (or existing) decoration
	 */
	IPapyrusDecoration addDecoration(String id, String type, EObject element, ImageDescriptor decorationForGE, ImageDescriptor decorationForME, PreferedPosition position, String message, int priority);

	/**
	 * Removes the decoration.
	 *
	 * @param id
	 *            the id
	 */
	void removeDecoration(String id);

	/**
	 * Gets the decoration.
	 *
	 * @param element
	 *            the element
	 * @param navigateToParents
	 *            the navigate to parents
	 * @return the decoration
	 */
	List<IPapyrusDecoration> getDecorations(Object element, boolean navigateToParents);
}
