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
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.commands;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.RefreshCommandForDo;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CallBehaviorActionAsInteractionEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;


public class UpdateDiagramInSnapshotCommandHandler extends GraphicalCommandHandler {

	@Override
	protected Command getCommand() {
		final CompoundCommand cmd = new CompoundCommand(Messages.UpdateDiagramInSnapshotCommandHandler_updateDiagram);
		final List<IGraphicalEditPart> selectedElements = getSelectedElements();
		for (final IGraphicalEditPart selectedElement : selectedElements) {
			if (selectedElement instanceof CallBehaviorActionAsInteractionEditPart) {
				cmd.add(new RefreshCommandForUndo(selectedElement));
				cmd.add(getUpdateDiagramCommand((CallBehaviorActionAsInteractionEditPart) selectedElement));
				cmd.add(new RefreshCommandForDo(selectedElement));
			}
		}
		return cmd;
	}

	private Command getUpdateDiagramCommand(final CallBehaviorActionAsInteractionEditPart callBehaviorActionEditPart) {
		return new ICommandProxy(new CreateSnapshotFromContextMenuCommand(getEditingDomain(), callBehaviorActionEditPart));
	}

}
