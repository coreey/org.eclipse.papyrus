/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.hyperlink.Activator;


/**
 * The Class EditorListContentProvider.
 */
// TODO why a tree content provider
public class EditorListContentProvider implements ITreeContentProvider {

	// The context of the ContentProvider
	private EObject model;

	public EditorListContentProvider(EObject model) {
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		try {
			IPageManager iPageMngr = ServiceUtilsForEObject.getInstance().getService(IPageManager.class, model);
			Object[] result = iPageMngr.allPages().toArray();

			List<Object> res = new ArrayList<Object>();
			for (Object current : result) {
				if (current != null /* && current instanceof PapyrusTableInstance */) {
					// if the model is a little bit corrupted, we can have a null element in the list
					res.add(current);
				}
			}
			return res.toArray();

		} catch (Exception e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// nothing to do
	}
}
