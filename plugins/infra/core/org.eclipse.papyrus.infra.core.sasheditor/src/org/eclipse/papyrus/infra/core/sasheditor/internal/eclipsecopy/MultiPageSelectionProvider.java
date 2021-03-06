/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IMultiPageEditorPart;
import org.eclipse.ui.IEditorPart;

/**
 * Manages the current selection in a multi-page editor by tracking the active nested editor within the multi-page editor. When the selection changes,
 * notifications are sent to all registered
 * listeners.
 * <p>
 * This class may be instantiated; it is not intended to be subclassed. The base implementation of <code>MultiPageEditor.init</code> creates an instance of this class.
 * </p>
 *
 * @noextend This class is not intended to be subclassed by clients.
 */
public class MultiPageSelectionProvider implements IPostSelectionProvider {

	/**
	 * Registered selection changed listeners (element type: <code>ISelectionChangedListener</code>).
	 */
	private ListenerList listeners = new ListenerList();

	/**
	 * Registered post selection changed listeners.
	 */
	private ListenerList postListeners = new ListenerList();

	/**
	 * The multi-page editor.
	 */
	private IMultiPageEditorPart multiPageEditor;

	/**
	 * Creates a selection provider for the given multi-page editor.
	 *
	 * @param multiPageEditor
	 *            the multi-page editor
	 */
	public MultiPageSelectionProvider(IMultiPageEditorPart multiPageEditor) {
		Assert.isNotNull(multiPageEditor);
		this.multiPageEditor = multiPageEditor;
	}

	/*
	 * (non-Javadoc) Method declared on <code>ISelectionProvider</code>.
	 */
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	/**
	 * Adds a listener for post selection changes in this multi page selection provider.
	 *
	 * @param listener
	 *            a selection changed listener
	 * @since 3.2
	 */
	@Override
	public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
		postListeners.add(listener);
	}

	/**
	 * Notifies all registered selection changed listeners that the editor's selection has changed. Only listeners registered at the time this method
	 * is called are notified.
	 *
	 * @param event
	 *            the selection changed event
	 */
	public void fireSelectionChanged(final SelectionChangedEvent event) {
		Object[] listeners = this.listeners.getListeners();
		fireEventChange(event, listeners);
	}

	/**
	 * Notifies all post selection changed listeners that the editor's selection has changed.
	 *
	 * @param event
	 *            the event to propogate.
	 * @since 3.2
	 */
	public void firePostSelectionChanged(final SelectionChangedEvent event) {
		Object[] listeners = postListeners.getListeners();
		fireEventChange(event, listeners);
	}

	private void fireEventChange(final SelectionChangedEvent event, Object[] listeners) {
		for (int i = 0; i < listeners.length; ++i) {
			final ISelectionChangedListener l = (ISelectionChangedListener) listeners[i];
			SafeRunner.run(new SafeRunnable() {

				@Override
				public void run() {
					l.selectionChanged(event);
				}
			});
		}
	}

	// /**
	// * Returns the multi-page editor.
	// *
	// * @return the multi-page editor.
	// */
	// private IMultiPageEditorPart getMultiPageEditor() {
	// return multiPageEditor;
	// }

	/*
	 * (non-Javadoc) Method declared on <code>ISelectionProvider</code>.
	 */
	@Override
	public ISelection getSelection() {
		IEditorPart activeEditor = multiPageEditor.getActiveEditor();
		if (activeEditor != null) {
			ISelectionProvider selectionProvider = activeEditor.getSite().getSelectionProvider();
			if (selectionProvider != null) {
				return selectionProvider.getSelection();
			}
		}
		return StructuredSelection.EMPTY;
	}

	/*
	 * (non-JavaDoc) Method declaed on <code>ISelectionProvider</code>.
	 */
	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Removes a listener for post selection changes in this multi page selection provider.
	 *
	 * @param listener
	 *            a selection changed listener
	 * @since 3.2
	 */
	@Override
	public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
		postListeners.remove(listener);
	}

	/*
	 * (non-Javadoc) Method declared on <code>ISelectionProvider</code>.
	 */
	@Override
	public void setSelection(ISelection selection) {
		IEditorPart activeEditor = multiPageEditor.getActiveEditor();
		if (activeEditor != null) {
			ISelectionProvider selectionProvider = activeEditor.getSite().getSelectionProvider();
			if (selectionProvider != null) {
				selectionProvider.setSelection(selection);
			}
		}
	}
}
