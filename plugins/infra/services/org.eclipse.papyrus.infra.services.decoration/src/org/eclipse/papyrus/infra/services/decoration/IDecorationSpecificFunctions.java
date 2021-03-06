/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST.
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
 *	Ansgar Radermacher (CEA LIST) - ansgar.radermacher@cea.fr
 * Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.decoration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

/**
 * This interface allows to access a set of functions that depend on the decorator type.
 * The objective is that plug-ins for a specific decoration type can implement this interface (via an extension point)
 * to provide the information that depends on the decoration type, notably the used icons, their possition, the way how
 * messages are calculated and how decoration might propagate from children to parents.
 *
 * @author ansgar
 */
public interface IDecorationSpecificFunctions {

	/**
	 * The Enum MarkChildren.
	 */

	public enum MarkChildren {

		/**
		 * Do not propagate markers from child to parent
		 */
		NO,

		/**
		 * Only propagate markers from direct child to parent
		 */
		DIRECT,

		/**
		 * Propagate markers from child (direct or nested) to parent
		 */
		ALL
	};

	/**
	 * Get the image descriptor for a graphical editor
	 *
	 * @param marker
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptorForGE(IPapyrusMarker marker);

	/**
	 * Get the image descriptor for model explorer. May be identical to the image for a graphical editor
	 *
	 * @param marker
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptorForME(IPapyrusMarker marker);

	/**
	 * @return the preferred position for markers within the model explorer
	 *
	 */
	public PreferedPosition getPreferedPosition(IPapyrusMarker marker);

	/**
	 * Return a textual information for the marker (used for fixed messages that do not need to
	 * be stored in each marker)
	 *
	 * @param marker
	 * @return
	 */
	public String getMessage(IPapyrusMarker marker);

	/**
	 * return the priority of a decoration. This enables to select a marker with a high priority, if multiple markers for the
	 * same model element and the same position exist. See also bug 392724
	 */
	public int getPriority(IPapyrusMarker marker);

	/**
	 * does the decoration type support a propagation from child to parent, e.g. in case of a problem marker
	 * parents (package) might be marked as containing warnings or errors
	 */
	public MarkChildren supportsMarkerPropagation();

	/**
	 * calculate a propagated marker for the parent, given the set of child decorations
	 *
	 * @param childDecorations
	 *            The set of decorations on children
	 * @return the calculated decoration for the parent
	 */
	public IPapyrusDecoration markerPropagation(EList<IPapyrusDecoration> childDecorations);
}
