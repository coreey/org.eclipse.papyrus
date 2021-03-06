/*******************************************************************************
 * Copyright (c) 2005, 2016 AIRBUS FRANCE, CEA, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Christian W. Damus (CEA) - bug 430701
 *    Christian W. Damus - bug 485220
 *
 *******************************************************************************/
package org.eclipse.papyrus.commands.wrappers;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.commands.INonDirtying;
import org.eclipse.papyrus.infra.emf.gmf.command.ICommandWrapper;

/**
 * A GEF Command that wraps an EMF command. Each method is redirected to the EMF one. <br>
 * Adapts an {@link org.eclipse.emf.common.command.Command EMF Command} to be a {@link org.eclipse.gef.commands.Command GEF Command}.
 *
 * Creation : 21 fev. 2006
 *
 * @author aarong, <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EMFtoGEFCommandWrapper extends Command implements ICommandWrapper<org.eclipse.emf.common.command.Command> {

	/**
	 * The wrapped EMF Command. Package-level visibility so that the command stack wrapper can
	 * access the field.
	 */
	private final org.eclipse.emf.common.command.Command emfCommand;

	static {
		REGISTRY.registerWrapper(org.eclipse.emf.common.command.Command.class, Command.class,
				EMFtoGEFCommandWrapper::wrap);
		REGISTRY.registerUnwrapper(EMFtoGEFCommandWrapper.class, org.eclipse.emf.common.command.Command.class,
				EMFtoGEFCommandWrapper::getWrappedCommand);
	}

	/**
	 * Constructor.
	 *
	 * @param command
	 *            the wrapped EMF command
	 */
	public EMFtoGEFCommandWrapper(final org.eclipse.emf.common.command.Command command) {
		super(command.getLabel());
		emfCommand = command;
	}

	/**
	 * Wraps the given {@code command}, accounting for possible non-dirty state.
	 *
	 * @param command
	 *            a command to wrap
	 * @return the best wrapper for the {@code command}
	 */
	public static Command wrap(org.eclipse.emf.common.command.Command command) {
		if (command instanceof AbstractCommand.NonDirtying) {
			return new NonDirtying(command);
		}
		return new EMFtoGEFCommandWrapper(command);
	}

	/**
	 * Returns the wrapped EMF command.
	 *
	 * @return the EMF command
	 */
	public org.eclipse.emf.common.command.Command getEMFCommand() {
		return emfCommand;
	}

	@Override
	public org.eclipse.emf.common.command.Command getWrappedCommand() {
		return getEMFCommand();
	}

	/**
	 * Dispose.
	 *
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		emfCommand.dispose();
	}

	/**
	 * Can execute.
	 *
	 * @return true, if can execute
	 *
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return emfCommand.canExecute();
	}

	/**
	 * Can undo.
	 *
	 * @return true, if can undo
	 *
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return emfCommand.canUndo();
	}

	/**
	 * Execute.
	 *
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		emfCommand.execute();
	}

	/**
	 * Redo.
	 *
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		emfCommand.redo();
	}

	/**
	 * Undo.
	 *
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		emfCommand.undo();
	}

	//
	// Nested types
	//

	/**
	 * A non-dirtying wrapper for non-dirtying commands.
	 */
	public static class NonDirtying extends EMFtoGEFCommandWrapper implements INonDirtying {

		public NonDirtying(org.eclipse.emf.common.command.Command command) {
			super(command);

			if (!(command instanceof org.eclipse.emf.common.command.AbstractCommand.NonDirtying)) {
				throw new IllegalArgumentException("Wrapped command is not non-dirtying"); //$NON-NLS-1$
			}
		}

	}
}
