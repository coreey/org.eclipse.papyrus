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
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.util;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.State;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.ui.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandImageService;
import org.eclipse.ui.commands.ICommandService;

/**
 * This class provides useful methods to manipulate Eclipse Command
 *
 * @author Vincent Lorenzo
 * @since 1.2
 *
 */
public class EclipseCommandUtils {

	private EclipseCommandUtils() {
		// to prevent instanciation
	}

	public static final String TOGGLE_STATE = "org.eclipse.ui.commands.toggleState"; //$NON-NLS-1$

	public static final String RADIO_STATE = "org.eclipse.ui.commands.radioState"; //$NON-NLS-1$

	public static final String DELETE_COMMAND = "org.eclipse.ui.edit.delete"; //$NON-NLS-1$

	/**
	 *
	 * @param categoryId
	 *            a category id
	 * @return
	 * 		all commands defined for this category
	 */
	public static final Collection<Command> getAllExistingCommandsInCategory(final String categoryId) {
		final Set<Command> commands = new TreeSet<Command>();
		final ICommandService commandService = PlatformUI.getWorkbench().getService(ICommandService.class);
		final Category category = commandService.getCategory(categoryId);
		for (final Command command : commandService.getDefinedCommands()) {
			Category currentCategory = null;
			try {
				currentCategory = command.getCategory();
			} catch (NotDefinedException e) {
				Activator.log.debug(e.getLocalizedMessage());
				continue;
			}
			if (/* command.isDefined() && */category.equals(currentCategory)) {
				commands.add(command);
			}
		}
		return commands;
	}

	/**
	 *
	 * @param command
	 *            an Eclipse command
	 * @return
	 * 		the image descriptor associated to this command
	 */
	public static final ImageDescriptor getCommandIcon(final Command command) {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final ICommandImageService service = workbench.getService(ICommandImageService.class);
		final ImageDescriptor imageDescriptor = service.getImageDescriptor(command.getId());
		return imageDescriptor;
	}

	/**
	 *
	 * @param command
	 *            an eclipse command
	 * @param newValue
	 *            the new boolean value to set to the state of this command
	 */
	public static final void updateToggleCommandState(final org.eclipse.core.commands.Command command, final boolean newValue) {
		if (command != null) {
			final State state = command.getState(TOGGLE_STATE);
			if (state != null) {
				state.setValue(newValue);
			}
		}
	}

	/**
	 *
	 * @param command
	 *            an eclipse command
	 * @param newValue
	 *            the new value to set to the state of this command
	 */
	public static final void updateRadioCommandState(final org.eclipse.core.commands.Command command, final Object newValue) {
		if (command != null) {
			final State state = command.getState(RADIO_STATE);
			if (state != null) {
				state.setValue(newValue);
			}
		}
	}

	/**
	 * 
	 * @return
	 * 		the eclipse command service
	 */
	public static final ICommandService getCommandService() {
		IWorkbench wb = PlatformUI.getWorkbench();
		if (wb != null) {
			IWorkbenchWindow ww = wb.getActiveWorkbenchWindow();
			if (ww != null) {
				return ww.getService(ICommandService.class);
			}
		}
		return null;
	}
}
