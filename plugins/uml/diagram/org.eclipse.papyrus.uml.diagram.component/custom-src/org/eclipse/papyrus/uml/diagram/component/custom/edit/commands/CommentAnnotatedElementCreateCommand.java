/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.component.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.component.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;


/**
 * @since 5.0
 */
public class CommentAnnotatedElementCreateCommand extends EditElementCommand {


	protected final EObject source;


	protected final EObject target;


	public CommentAnnotatedElementCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
	}


	@Override
	public boolean canExecute() {
		if ((source == null && target == null) || (source != null && !(source instanceof Comment))) {
			return false;
		}
		if (target != null && !(target instanceof Element)) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateComment_AnnotatedElementEdge(getSource(), getTarget());
	}


	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		if (getSource() != null && getTarget() != null) {
			getSource().getAnnotatedElements()
					.add(getTarget());
		}
		return CommandResult.newOKCommandResult();

	}


	@Override
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}


	protected Comment getSource() {
		return (Comment) source;
	}


	protected Element getTarget() {
		return (Element) target;
	}
}
