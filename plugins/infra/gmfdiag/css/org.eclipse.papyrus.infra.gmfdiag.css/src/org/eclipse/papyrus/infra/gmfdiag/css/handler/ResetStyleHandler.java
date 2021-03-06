/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.css.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.ResetStyleHelper;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForActionHandlers;


/**
 * This handler resets all the local appearance to their default value
 * for a set of GMF Views.
 *
 * @author Camille Letavernier
 *
 * @deprecated Not used. Use ResetStyleHelper instead
 */
@Deprecated
public class ResetStyleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection;

		try {
			// FIXME: Use ServiceUtilsForHandlers
			// FIXME: This method is sometimes called manually with a null ExecutionEvent. It won't work with ServiceUtilsForHandlers
			IMultiDiagramEditor editor = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry().getService(IMultiDiagramEditor.class);
			selection = editor.getEditorSite().getSelectionProvider().getSelection();
		} catch (ServiceException ex) {
			throw new ExecutionException(ex.getMessage(), ex);
		}

		// selection = HandlerUtil.getCurrentSelection(event);
		if (selection == null || selection.isEmpty()) {
			return null;
		}

		if (!(selection instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection sSelection = (IStructuredSelection) selection;

		ResetStyleHelper.resetStyle(sSelection);

		return null;
	}

}
