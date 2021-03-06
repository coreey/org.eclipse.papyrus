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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.LabelConfigurationManagementUtils;

/**
 * The abstract handler used to change the column header label configuration
 *
 * @author Vincent Lorenzo
 *
 */
public abstract class AbstractColumnChangeLabelConfigurationValueHandler extends AbstractChangeLabelConfigurationValueHandler {

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractChangeLabelConfigurationValueHandler#getLabelProviderConfiguration()
	 *
	 * @return
	 */
	@Override
	protected ILabelProviderConfiguration getLabelProviderConfiguration() {
		return LabelConfigurationManagementUtils.getUsedColumnFeatureLabelConfiguration(getCurrentNattableModelManager().getTable());
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractChangeLabelConfigurationValueHandler#getLocalHeaderAxisConfigurationFeature()
	 *
	 * @return
	 */
	@Override
	protected EStructuralFeature getLocalHeaderAxisConfigurationFeature() {
		Table table = getCurrentNattableModelManager().getTable();
		if (!table.isInvertAxis()) {
			return NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration();
		}
		return NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration();
	}

	/**
	 *
	 * @return
	 *         the edited axis configuration
	 */
	@Override
	protected AbstractHeaderAxisConfiguration getHeaderAxisConfiguration() {
		return HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisConfigurationUsedInTable(getCurrentNattableModelManager().getTable());
	}


	/**
	 *
	 * @return
	 *         the table header axis defined in the TableConfiguration and used for edited label axis configuration
	 */
	@Override
	protected TableHeaderAxisConfiguration getTableHeaderAxisConfiguration() {
		return (TableHeaderAxisConfiguration) HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTableConfiguration(getCurrentNattableModelManager().getTable());
	}
}
