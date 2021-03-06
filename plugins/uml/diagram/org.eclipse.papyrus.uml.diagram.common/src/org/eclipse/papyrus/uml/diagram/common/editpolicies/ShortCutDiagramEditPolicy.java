/*****************************************************************************
 * Copyright (c) 2009, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Bug 454386
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;

/**
 * This class is used to open a new diagram when the double click is detected.
 * It is dependent of papyrus environment
 * 
 * @deprecated since 1.0.2 / use org.eclipse.papyrus.infra.gmfdiag.hyperlink.editpolicies.NavigationEditPolicy
 * 
 */
@Deprecated
public class ShortCutDiagramEditPolicy extends OpenEditPolicy {

	/**
	 * The Class OpenDiagramCommand.
	 */
	private static class OpenDiagramCommand extends AbstractTransactionalCommand {

		/** The diagram to open. */
		private Diagram diagramToOpen = null;

		/**
		 * Instantiates a new open diagram command.
		 *
		 * @param domain
		 *            the domain
		 * @param diagram
		 *            the diagram
		 */
		public OpenDiagramCommand(TransactionalEditingDomain domain, Diagram diagram) {
			super(domain, "open diagram", null);
			diagramToOpen = diagram;
		}

		/**
		 * {@inheritedDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			try {
				IPageManager pageMngr = ServiceUtilsForEObject.getInstance().getService(IPageManager.class, diagramToOpen);
				if (pageMngr.isOpen(diagramToOpen)) {
					pageMngr.selectPage(diagramToOpen);
				} else {
					pageMngr.openPage(diagramToOpen);
				}
				return CommandResult.newOKCommandResult();
			} catch (Exception e) {
				throw new ExecutionException("Can't open diagram", e);
			}
		}
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected Command getOpenCommand(Request request) {
		if (((GraphicalEditPart) getHost()).getNotationView().getElement() instanceof Diagram && ((GraphicalEditPart) getHost()).getNotationView().getElement().eResource() != null) {
			Diagram diagram = (Diagram) ((GraphicalEditPart) getHost()).getNotationView().getElement();
			OpenDiagramCommand openDiagramCommand = new OpenDiagramCommand(((GraphicalEditPart) getHost()).getEditingDomain(), diagram);
			return new ICommandProxy(openDiagramCommand);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

}
