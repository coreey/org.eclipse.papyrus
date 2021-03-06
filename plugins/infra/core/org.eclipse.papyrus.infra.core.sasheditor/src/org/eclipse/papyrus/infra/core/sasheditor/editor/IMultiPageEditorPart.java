/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.infra.core.sasheditor.editor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * Marker to mark a EditorPart as a MultiPartEditor. Provides methods needed by classes
 * like MultiPageActionBarContributor and MultiPageSelectionProvider.
 */
public interface IMultiPageEditorPart extends IAdaptable {

	/**
	 * Get the currently active editor of the MultiPageEditorPart.
	 *
	 * @return
	 */
	public IEditorPart getActiveEditor();

	/**
	 * Get the main site of the MultiPageEditorPart.
	 *
	 * @return
	 */
	public IWorkbenchPartSite getSite();

	/**
	 * Get the IEditorSite associated to this MultiPageEditorPart.
	 * This return the same object as getSite().
	 *
	 * @return
	 */
	public IEditorSite getEditorSite();

}
