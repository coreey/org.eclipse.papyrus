/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------
package org.eclipse.papyrus.toolsmiths.profilemigration.migrators;

import java.util.List;

import org.eclipse.papyrus.toolsmiths.profilemigration.migrators.atomic.IAtomicMigrator;

/**
 * A CompositeMigrator is a migrator done from one or multiple AtomicMigrator
 * This is a way to combine multiple AtomicMigrator to do an other action when those
 * AtomicMigrator correspond to a specific case
 */
public interface ICompositeMigrator extends IMigrator {

	/**
	 * Get the list of list of AtomicMigrator which compose the CompositeMigrator
	 * 
	 * @return the list of list of AtomicMigrator which compose the CompositeMigrator
	 */
	public List<IAtomicMigrator> getAtomicList();
};
