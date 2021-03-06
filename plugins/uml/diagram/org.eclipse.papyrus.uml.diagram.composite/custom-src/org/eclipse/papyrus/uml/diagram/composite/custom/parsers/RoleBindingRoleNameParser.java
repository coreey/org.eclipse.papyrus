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
 *   Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.parsers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This is a read only ISemanticParser used to show the name of the binded role
 * in a RoleBinding dependency.
 *
 * Several method do not need implementation due to the read only status of the
 * label where the role name is shown.
 *
 * It is assumed here that the parsed element is a {@link Dependency} acting as
 * a RoleBinding.
 * </pre>
 */
public class RoleBindingRoleNameParser implements ISemanticParser {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		// no implementation needed.
		if (notification instanceof Notification) {
			Notification event = (Notification) notification;
			if ((event.getEventType() == Notification.SET) && (UMLPackage.eINSTANCE.getNamedElement_Name().equals(event.getFeature()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <pre>
	 * Retrieves the {@link ConnectableElement} that acts as the binded role.
	 *
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	public List<?> getSemanticElementsBeingParsed(EObject eObject) {
		Dependency binding = (Dependency) eObject;
		List<EObject> result = new LinkedList<EObject>();

		if (!binding.getClients().isEmpty()) {
			NamedElement role = binding.getClients().get(0);
			result.add(role);
		}
		return result;
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public IContentAssistProcessor getCompletionProcessor(IAdaptable subject) {
		// no implementation needed.
		return null;
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public String getEditString(IAdaptable element, int flags) {
		// no implementation needed.
		return ""; //$NON-NLS-1$
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// no implementation needed.
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * <pre>
	 * Provides the name of the binded role.
	 *
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {
		Dependency binding = doAdapt(element);

		if (!binding.getClients().isEmpty()) {
			NamedElement role = binding.getClients().get(0);
			return UMLLabelInternationalization.getInstance().getLabel(role);
		} // else
		return ""; //$NON-NLS-1$
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAffectingEvent(Object event, int flags) {
		// no implementation needed.
		return false;
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// no implementation needed.
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	/**
	 * Adapt object to {@link Dependency}
	 *
	 * @param adaptable
	 *            the object to adapt
	 * @return the {@link Dependency} adapted from the adaptable
	 */
	private Dependency doAdapt(IAdaptable adaptable) {
		Dependency element = (Dependency) EMFHelper.getEObject(adaptable);
		return element;
	}

}
