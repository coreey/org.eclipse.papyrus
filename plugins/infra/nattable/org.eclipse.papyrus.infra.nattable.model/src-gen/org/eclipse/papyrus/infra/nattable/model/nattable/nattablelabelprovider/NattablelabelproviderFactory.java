/**
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
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage
 * @generated
 */
public interface NattablelabelproviderFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattablelabelproviderFactory eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Feature Label Provider Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Label Provider Configuration</em>'.
	 * @generated
	 */
	FeatureLabelProviderConfiguration createFeatureLabelProviderConfiguration();

	/**
	 * Returns a new object of class '<em>Object Label Provider Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Label Provider Configuration</em>'.
	 * @generated
	 */
	ObjectLabelProviderConfiguration createObjectLabelProviderConfiguration();

	/**
	 * Returns a new object of class '<em>Operation Label Provider Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Label Provider Configuration</em>'.
	 * @generated
	 */
	OperationLabelProviderConfiguration createOperationLabelProviderConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NattablelabelproviderPackage getNattablelabelproviderPackage();
} // NattablelabelproviderFactory
