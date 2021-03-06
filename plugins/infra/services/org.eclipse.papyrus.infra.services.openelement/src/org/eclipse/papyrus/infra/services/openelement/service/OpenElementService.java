/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.services.openelement.service;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.ui.PartInitException;

/**
 * A Service to open an element in an editor.
 * If an editor is already opened for the model, it will be reused.
 * Otherwise, a new editor will be opened
 *
 * @author Camille Letavernier
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface OpenElementService extends IService {

	/**
	 * Opens and select the view element
	 *
	 * @param viewElement
	 * @return The IMultiDiagramEditor in which the element has been opened
	 * @throws PartInitException
	 * @throws ServiceException
	 */
	public IMultiDiagramEditor openElement(EObject viewElement) throws PartInitException, ServiceException;

	/**
	 * Retrieves and opens the pages representing the semantic element, and select
	 * the view(s) associated to the semantic element
	 *
	 * @param semanticElement
	 * @return The IMultiDiagramEditor in which the element has been opened
	 * @throws PartInitException
	 * @throws ServiceException
	 */
	public IMultiDiagramEditor openSemanticElement(EObject semanticElement) throws PartInitException, ServiceException;

	/**
	 * Opens and selects the views associated to the semantic element
	 * in the given page(s)
	 *
	 * @param semanticElement
	 * @param pages
	 * @return The IMultiDiagramEditor in which the element has been opened
	 * @throws PartInitException
	 * @throws ServiceException
	 */
	public IMultiDiagramEditor openSemanticElement(EObject semanticElement, Object[] pages) throws PartInitException, ServiceException;

}
