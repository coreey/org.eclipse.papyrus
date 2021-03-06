/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *   
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.validation.internal;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.validation.Activator;
import org.eclipse.papyrus.infra.services.validation.IValidationMarkerListener;
import org.eclipse.papyrus.infra.services.validation.IValidationMarkerListener.MarkerChangeKind;
import org.eclipse.papyrus.infra.services.validation.IValidationMarkersService;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * This is the ValidationMarkersService type. Enjoy.
 */
public class ValidationMarkersService
		implements IMarkerEventListener, IValidationMarkersService {

	private ModelSet modelSet;

	private final Multimap<EObject, IPapyrusMarker> markers = HashMultimap
			.create();

	private final CopyOnWriteArrayList<IValidationMarkerListener> listeners = new CopyOnWriteArrayList<IValidationMarkerListener>();

	public ValidationMarkersService() {
		super();
	}

	public void init(ServicesRegistry services)
			throws ServiceException {

		modelSet = ServiceUtils.getInstance().getModelSet(services);
	}

	public void startService()
			throws ServiceException {

		// pass
	}

	public void disposeService()
			throws ServiceException {

		markers.clear();
		modelSet = null;
	}

	public boolean isNotifiedOnInitialMarkerCheck() {
		return true;
	}

	public void notifyMarkerChange(EObject eObjectOfMarker,
			IPapyrusMarker marker, int addedOrRemoved) {

		// ADDED
		try {
			if (marker.exists() && !marker.isSubtypeOf(IMarker.PROBLEM)) {
				return;
			}
		} catch (CoreException e1) {
			Activator.log.error(e1);
		}
		// ////

		MarkerChangeKind kind = (addedOrRemoved == MARKER_ADDED)
				? MarkerChangeKind.ADDED
				: MarkerChangeKind.REMOVED;

		switch (kind) {
		case ADDED:
			markers.put(eObjectOfMarker, marker);
			break;
		case REMOVED:
			// workspace markers don't know their EObjects, so we can't look
			// up the mapping to remove by key
			markers.values().remove(marker);
			break;
		}

		for (IValidationMarkerListener next : listeners) {
			try {
				next.notifyMarkerChange(marker, kind);
			} catch (Exception e) {
				Activator.log.error(
						"Uncaught exception in validation marker listener.", e);
			}
		}
	}

	public ModelSet getModelSet() {
		return modelSet;
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.validation.IValidationMarkersService#getMarkers()
	 *
	 * @return
	 */
	public Collection<IPapyrusMarker> getMarkers() {
		return markers.values();
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.validation.IValidationMarkersService#getMarkers(org.eclipse.emf.ecore.EObject)
	 *
	 * @param object
	 * @return
	 */
	public Collection<IPapyrusMarker> getMarkers(EObject object) {
		return markers.get(object);
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.validation.IValidationMarkersService#addValidationMarkerListener(org.eclipse.papyrus.infra.services.validation.IValidationMarkerListener)
	 *
	 * @param listener
	 */
	public void addValidationMarkerListener(IValidationMarkerListener listener) {
		listeners.addIfAbsent(listener);
	}

	/**
	 * @see org.eclipse.papyrus.infra.services.validation.IValidationMarkersService#removeValidationMarkerListener(org.eclipse.papyrus.infra.services.validation.IValidationMarkerListener)
	 *
	 * @param listener
	 */
	public void removeValidationMarkerListener(
			IValidationMarkerListener listener) {

		listeners.remove(listener);
	}
}
