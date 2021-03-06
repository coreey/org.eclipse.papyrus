/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.properties.constraints;

import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.TableHelper;

/**
 * The constraint which allow to determinate if this is a nattable editor as current editor part and a tree table.
 * 
 * @since 2.2
 */
public class IsEObjectInTreeTableConstraint extends IsEObjectInTableConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.constraints.IsEObjectInTableConstraint#checkMoreTableConstraint(org.eclipse.papyrus.infra.nattable.model.nattable.Table)
	 */
	@Override
	protected boolean checkMoreTableConstraint(final Table table) {
		return TableHelper.isTreeTable(table);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint#equivalent(org.eclipse.papyrus.infra.constraints.constraints.Constraint)
	 */
	@Override
	protected boolean equivalent(final Constraint constraint) {
		return constraint == this || constraint instanceof IsEObjectInTreeTableConstraint;
	}

}
