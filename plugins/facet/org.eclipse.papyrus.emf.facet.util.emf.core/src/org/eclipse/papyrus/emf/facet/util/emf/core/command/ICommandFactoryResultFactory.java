/**
 *  Copyright (c) 2012 Mia-Software.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.util.emf.core.command;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.emf.facet.util.emf.core.internal.command.CommandFactoryResultFactory;

/**
 * @since 0.2
 */
public interface ICommandFactoryResultFactory {

	ICommandFactoryResultFactory DEFAULT = new CommandFactoryResultFactory();

	<T> ICommandFactoryResult<T> createCommandFactoryResult(Command command, T result);
}
