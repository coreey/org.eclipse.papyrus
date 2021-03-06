/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.ui.emf.providers.MoDiscoContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.InteractionOverviewDiagramEditPart;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Interaction;

/**
 *
 * this content provider is used to display diagrams and their contents
 *
 */
@Deprecated
public class DiagramContentProvider extends MoDiscoContentProvider implements IHierarchicContentProvider {

	/**
	 * @since 3.0
	 */
	protected static final String PAPYRUS_UML_TIMING_DIAGRAM = "PapyrusUMLTimingDiagram"; //$NON-NLS-1$

	/**
	 * @since 3.0
	 */
	protected final static String PAPYRUS_SEQUENCE_DIAGRAM_MODEL_ID = "PapyrusUMLSequenceDiagram"; //$NON-NLS-1$

	private final Interaction interaction;

	public DiagramContentProvider(final Interaction interation) {
		super();
		this.interaction = interation;
	}

	@Override
	public EObject[] getRootElements(final Object inputElement) {

		try {
			if (!(inputElement instanceof ServicesRegistry)) {
				return null;
			}

			final ServicesRegistry servicesRegistry = (ServicesRegistry) inputElement;

			modelSet = ModelUtils.getModelSetChecked(servicesRegistry);
			pageMngr = servicesRegistry.getService(IPageManager.class);

			final ArrayList<EObject> result = new ArrayList<>();
			final List<Object> list = pageMngr.allPages();
			for (int i = 0; i < list.size(); i++) {
				final Object element = pageMngr.allPages().get(i);
				if (element instanceof Diagram && isValidDiagram((Diagram) element)) {
					result.add((EObject) pageMngr.allPages().get(i));
				}
			}

			final EObject[] eObject = new EObject[result.size()];
			return result.toArray(eObject);

		} catch (final Exception e) {
			Activator.log.error(e);
		}

		return new EObject[0];
	}

	private boolean isValidDiagram(final Diagram diagram) {
		// seqDiagram or comDiagram
		if (diagram.getType().equals(PAPYRUS_SEQUENCE_DIAGRAM_MODEL_ID) || diagram.getType().equals(ModelEditPart.MODEL_ID)) {
			if (diagram.getElement().equals(interaction)) {
				return true;
			}
			// timing Diagram
		} else if (PAPYRUS_UML_TIMING_DIAGRAM.equals(diagram.getType())) {
			return true;
			// InteractionOverviewDiagram
		} else if (diagram.getType().equals(InteractionOverviewDiagramEditPart.MODEL_ID)) {
			if (diagram.getElement() instanceof Activity) {
				if (((Activity) diagram.getElement()).getOwnedBehaviors().contains(interaction)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isValidValue(final Object element) {
		final EObject eObject = EMFHelper.getEObject(element);
		if (eObject instanceof Diagram) {
			return isValidDiagram((Diagram) eObject);
		}
		return false;
	}
}
