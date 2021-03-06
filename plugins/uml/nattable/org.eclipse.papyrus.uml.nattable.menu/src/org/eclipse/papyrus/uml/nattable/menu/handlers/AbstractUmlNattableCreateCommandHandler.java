/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.menu.handlers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.INattableModelManagerUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.nattable.menu.util.TableMenuUtils;
import org.eclipse.papyrus.uml.service.types.ui.handlers.AbstractUmlCreateElementCommandHandler;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;

/**
 * Abstract handler for the creation commands of UML elements in the Nattable editor
 *
 */
public abstract class AbstractUmlNattableCreateCommandHandler extends AbstractUmlCreateElementCommandHandler {


	/**
	 * <pre>
	 *
	 * Build the create command for an element creation in the selected container.
	 * The create command is given by the {@link IElementEditService} of selected
	 * element.
	 *
	 * @return the composite creation command for current selection
	 *
	 * </pre>
	 */
	@Override
	protected Command buildCommand() {
		Command createCmd = super.buildCommand();
		return TableMenuUtils.buildNattableCreationCommand(createCmd, this.createRequest);

	}

	/**
	 * Obtain the context of the active table editor.
	 *
	 * @see org.eclipse.papyrus.uml.service.types.ui.handlers.AbstractUmlCreateCommandHandler#getCommandContext()
	 *
	 * @return
	 */
	@Override
	protected ICommandContext getCommandContext() {
		return TableMenuUtils.getTableCreateElementCommandContext(INattableModelManagerUtils.getTableManagerFromWorkbenchPart(getActiveWorkbenchPart()));

	}

	/**
	 * Verify if this handler is currently active and the command can execute. Additionally, verify if this table can add this type of element.
	 *
	 * @see org.eclipse.papyrus.uml.service.types.ui.handlers.AbstractCreateCommandHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		INattableModelManager tableManager = INattableModelManagerUtils.getTableManagerFromWorkbenchPart(getActiveWorkbenchPart());
		boolean isEnabled = tableManager.canCreateRowElement(getElementTypeToCreate().getId());
		if (isEnabled) {
			// we test the enable of the super implementation
			super.setEnabled(evaluationContext);
			isEnabled = super.isEnabled();
		}
		setBaseEnabled(isEnabled);
	}

}
