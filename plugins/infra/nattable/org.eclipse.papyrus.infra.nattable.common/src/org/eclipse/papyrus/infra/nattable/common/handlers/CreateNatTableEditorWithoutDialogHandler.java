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
package org.eclipse.papyrus.infra.nattable.common.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;

/**
 * The handler used to create a nattable editor without the name dialog
 *
 * @author Vincent Lorenzo
 *
 */
public class CreateNatTableEditorWithoutDialogHandler extends CreateNatTableEditorHandler {



	/**
	 *
	 * Constructor.
	 *
	 */
	public CreateNatTableEditorWithoutDialogHandler() {
		super();
	}


	/**
	 * Run the command as a transaction. Create a Transaction and delegate the
	 * command to {@link #doExecute(ServicesRegistry)}.
	 *
	 * @throws ServiceException
	 *
	 */
	@Override
	public void runAsTransaction(final ExecutionEvent event) throws ServiceException {
		// we create a new resourceSet to avoid to load unused config in the resourceset in case of Cancel
		TableConfiguration conf = getTableEditorConfiguration();
		String defaultName = conf.getName();
		runAsTransaction(event, defaultName);
	}




}
