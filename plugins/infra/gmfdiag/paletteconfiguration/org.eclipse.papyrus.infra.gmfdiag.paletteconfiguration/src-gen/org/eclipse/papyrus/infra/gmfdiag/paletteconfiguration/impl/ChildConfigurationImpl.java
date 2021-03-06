/**
 * Copyright (c) 2015 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.ChildConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.PaletteconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ChildConfigurationImpl extends ConfigurationImpl implements ChildConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PaletteconfigurationPackage.Literals.CHILD_CONFIGURATION;
	}

} //ChildConfigurationImpl
