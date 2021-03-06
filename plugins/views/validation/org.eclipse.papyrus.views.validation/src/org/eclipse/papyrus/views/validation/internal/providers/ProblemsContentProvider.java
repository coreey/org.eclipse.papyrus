/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
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
 *   Christian W. Damus (CEA) - bug 437217
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.validation.internal.providers;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.AbstractTableViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.validation.IValidationMarkerListener;
import org.eclipse.papyrus.infra.services.validation.IValidationMarkersService;

import com.google.common.collect.Iterables;

/**
 * This is the ProblemsContentProvider type. Enjoy.
 */
public class ProblemsContentProvider implements IStructuredContentProvider {

	private static final Object[] NONE = {};

	private AbstractTableViewer viewer;

	private IValidationMarkersService service;

	private IValidationMarkerListener listener;

	private ResourceSetListener resourceSetListener;

	public ProblemsContentProvider() {
		super();
	}

	public void dispose() {
		viewer = null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (AbstractTableViewer) viewer;

		if (oldInput instanceof IValidationMarkersService) {
			IValidationMarkersService service = (IValidationMarkersService) oldInput;
			unhookMarkers(service);

			// The old service may have been disposed if its editor was closed
			if (service.getModelSet() != null) {
				unhookResourceSet(service.getModelSet().getTransactionalEditingDomain());
			}

			this.service = null;
		}

		if (newInput instanceof IValidationMarkersService) {
			IValidationMarkersService service = (IValidationMarkersService) newInput;
			this.service = service;
			hookMarkers(service);
			hookResourceSet(service.getModelSet().getTransactionalEditingDomain());
		}
	}

	public Object[] getElements(Object inputElement) {
		return (inputElement instanceof IValidationMarkersService) ? Iterables.toArray(((IValidationMarkersService) inputElement).getMarkers(), IPapyrusMarker.class) : NONE;
	}

	protected void hookMarkers(IValidationMarkersService service) {
		service.addValidationMarkerListener(getValidationMarkerListener());
	}

	protected void unhookMarkers(IValidationMarkersService service) {
		service.removeValidationMarkerListener(getValidationMarkerListener());
	}

	private IValidationMarkerListener getValidationMarkerListener() {
		if (listener == null) {
			listener = new IValidationMarkerListener() {

				public void notifyMarkerChange(IPapyrusMarker marker, MarkerChangeKind kind) {
					if (viewer != null) {
						switch (kind) {
						case ADDED:
							viewer.add(marker);
							break;
						case REMOVED:
							viewer.remove(marker);
							break;
						}
					}
				}
			};
		}

		return listener;
	}

	protected void hookResourceSet(TransactionalEditingDomain domain) {
		domain.addResourceSetListener(getResourceSetListener());
	}

	protected void unhookResourceSet(TransactionalEditingDomain domain) {
		domain.removeResourceSetListener(getResourceSetListener());
	}

	private ResourceSetListener getResourceSetListener() {
		if (resourceSetListener == null) {
			resourceSetListener = new DemultiplexingListener() {

				@Override
				protected void handleNotification(TransactionalEditingDomain domain, Notification notification) {

					// handle containment changes of problem elements to update
					// labels
					Object feature = notification.getFeature();
					if ((feature instanceof EReference) && ((EReference) feature).isContainment()) {

						switch (notification.getEventType()) {
						case Notification.ADD:
							handleContainment((EObject) notification.getNewValue());
							break;
						case Notification.ADD_MANY:
							for (Object next : (Collection<?>) notification.getNewValue()) {
								handleContainment((EObject) next);
							}
							break;
						case Notification.SET:
							handleContainment((EObject) notification.getNewValue());
							break;
						}
					}
				}

				private void handleContainment(EObject object) {
					Object[] markers = service.getMarkers(object).toArray();
					if (markers.length > 0) {
						viewer.update(markers, null);
					}
				}
			};
		}

		return resourceSetListener;
	}
}
