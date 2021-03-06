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
package org.eclipse.papyrus.infra.widgets.strategy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

/**
 * A Strategy to search for a Resource in the Workspace
 *
 * @author Camille Letavernier
 *
 */
public class WorkspaceRevealStrategy extends ProviderBasedBrowseStrategy<Viewer> {

	public WorkspaceRevealStrategy(ITreeContentProvider provider) {
		super(provider);
	}

	public WorkspaceRevealStrategy() {
		super();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		this.viewer = viewer;
	}

	@Override
	public void revealSemanticElement(List<?> elementsToReveal) {
		if (viewer instanceof TreeViewer) {
			TreeViewer treeViewer = (TreeViewer) viewer;
			TreePath[] paths = new TreePath[elementsToReveal.size()];
			int i = 0;

			List<?> roots = Arrays.asList(getElements());

			for (Object elementToReveal : elementsToReveal) {
				LinkedList<IResource> segments = new LinkedList<IResource>();

				if (elementToReveal instanceof IResource) {
					IResource currentElement = (IResource) elementToReveal;

					segments.add(currentElement);

					currentElement = currentElement.getParent();
					while (currentElement != null) {
						segments.addFirst(currentElement);

						if (roots.contains(currentElement)) {
							break; // If the tree root is not the Workspace Root, stop now
						}
						currentElement = currentElement.getParent();
					}
				}

				paths[i++] = new TreePath(segments.toArray());
			}

			TreeSelection selection = new TreeSelection(paths);
			treeViewer.setSelection(selection, true);
		} else {
			super.revealSemanticElement(elementsToReveal);
		}
	}
}
