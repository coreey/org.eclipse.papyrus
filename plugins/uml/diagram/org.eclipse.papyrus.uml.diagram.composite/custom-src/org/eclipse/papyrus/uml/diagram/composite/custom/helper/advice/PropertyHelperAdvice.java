/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.helper.advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 *
 * This advice is used to remove the view of the parts which become inconsistent when we change the type of the property
 *
 */
public class PropertyHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * Returns the command to destroy the views of the parts which are not owned by the new type
	 *
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeSetCommand(org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest)
	 *
	 * @param request
	 *            the request to modify the model
	 * @return
	 * 		the command to destroy the views of the parts which are not owned by the new type
	 *
	 */
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		Type oldType = null;
		Type newType = null;

		EObject elementToEdit = request.getElementToEdit();
		Set<View> viewsToDelete = new HashSet<View>();
		if ((elementToEdit instanceof Property) && (request.getFeature() == UMLPackage.eINSTANCE.getTypedElement_Type()) && ((request.getValue() == null) || (request.getValue() instanceof Type))) {

			Property propertyToEdit = (Property) elementToEdit;

			oldType = propertyToEdit.getType();
			newType = (Type) request.getValue();

			if ((oldType != null) && (oldType instanceof Classifier) && ((request.getValue() == null) || (newType instanceof Classifier))) {

				EList<NamedElement> newTypeMembers = (newType != null) ? ((Classifier) newType).getMembers() : new BasicEList<NamedElement>();
				EList<NamedElement> oldTypeMembers = ((Classifier) oldType).getMembers();

				// Remove members of the new type from the list.
				// oldTypeMembers now contains the list of members for which views will become
				// inconsistent (if shown in the propertyToEdit) after setting the new type.
				List<NamedElement> possiblyInconsistentMembers = new ArrayList<NamedElement>();
				possiblyInconsistentMembers.addAll(oldTypeMembers);
				possiblyInconsistentMembers.removeAll(newTypeMembers);

				if (!possiblyInconsistentMembers.isEmpty()) {

					Set<View> propertyToEditViews = null;

					// Parse the list of possibly inconsistent members
					for (NamedElement possiblyInconsistentMember : possiblyInconsistentMembers) {

						// Retrieve views of the current possiblyInconsistentMember
						Iterator<View> viewIt = CrossReferencerUtil.getCrossReferencingViews(possiblyInconsistentMember, CompositeStructureDiagramEditPart.MODEL_ID).iterator();
						while (viewIt.hasNext()) {
							if (propertyToEditViews == null) {
								propertyToEditViews = CrossReferencerUtil.getCrossReferencingViews(propertyToEdit, CompositeStructureDiagramEditPart.MODEL_ID);
							}

							View possiblyInconsistentMemberView = viewIt.next();
							if (isConcerned(possiblyInconsistentMemberView, propertyToEditViews)) {
								viewsToDelete.add(possiblyInconsistentMemberView);
							}
						}
					}
				}
			}
		}

		if ((viewsToDelete != null) && !(viewsToDelete.isEmpty())) {
			DestroyDependentsRequest req = new DestroyDependentsRequest(request.getEditingDomain(), elementToEdit, false);
			req.setClientContext(request.getClientContext());
			req.addParameters(request.getParameters());
			return req.getDestroyDependentsCommand(viewsToDelete);
		}

		return null;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeEditContextCommand(org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeEditContextCommand(GetEditContextRequest request) {
		if (request.getEditCommandRequest() instanceof CreateElementRequest) {
			// check the element to create is a sub kind of UML PORT
			CreateElementRequest createElementRequest = ((CreateElementRequest) request.getEditCommandRequest());
			// retrieve element type from this request and check if this is a kind of UML PORT
			IElementType type = createElementRequest.getElementType();
			List<IElementType> types = new ArrayList<IElementType>(Arrays.asList(type.getAllSuperTypes()));
			types.add(type);
			if (types.contains(UMLElementTypes.PROPERTY) && (!UMLPackage.eINSTANCE.getProperty_Qualifier().equals(createElementRequest.getContainmentFeature()))) {
				GetEditContextCommand command = new GetEditContextCommand(request);
				if (request.getEditContext() instanceof Property) {
					// this line is very important
					// change the context ok, but the feature must be change ifn order to create a port inside the class
					createElementRequest.setContainmentFeature(UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute());

					Property p = (Property) request.getEditContext();
					if (p.getType() != null) {
						command.setEditContext(p.getType());
						return command;
					}

				}
			}
		}

		return super.getBeforeEditContextCommand(request);
	}

	/**
	 * Tests if the view must be deleted
	 *
	 * @param view
	 *            the view to test
	 * @param list
	 *            the list of the property view
	 * @return
	 * 		<code>true</code> if the view need to be removed <code>false</code> if not
	 */
	protected boolean isConcerned(View view, Set<View> propertyViews) {

		EObject parentView = view.eContainer();
		if (parentView instanceof DecorationNode) {
			parentView = parentView.eContainer();
		}
		return propertyViews.contains(parentView);

	}
}
