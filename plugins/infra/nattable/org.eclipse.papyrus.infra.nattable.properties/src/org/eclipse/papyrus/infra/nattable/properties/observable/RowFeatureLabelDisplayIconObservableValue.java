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
package org.eclipse.papyrus.infra.nattable.properties.observable;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;

/**
 * The Class RowFeatureLabelDisplayIconObservableValue.
 *
 * @author Vincent Lorenzo
 */
public class RowFeatureLabelDisplayIconObservableValue extends AbstractRowFeatureLabelProviderConfigurationObservableValue {

	/**
	 * Constructor.
	 *
	 * @param table
	 *            the table
	 */
	public RowFeatureLabelDisplayIconObservableValue(Table table) {
		super(table, NattablelabelproviderPackage.eINSTANCE.getObjectLabelProviderConfiguration_DisplayIcon());
	}

	/**
	 * Gets the value type.
	 *
	 * @return the value type
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 */
	@Override
	public Object getValueType() {
		return EcorePackage.eINSTANCE.getEBoolean();
	}
}
