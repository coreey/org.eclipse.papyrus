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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paste EObject Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Configuration to use to paste EObject in the table.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getPastedElementId <em>Pasted Element Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getPasteElementContainementFeature <em>Paste Element Containement Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getAxisIdentifier <em>Axis Identifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getPasteEObjectConfiguration()
 * @model
 * @generated
 */
public interface PasteEObjectConfiguration extends IPasteConfiguration {

	/**
	 * Returns the value of the '<em><b>Pasted Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The String representing the EClass of the elements to create (see papyrus services types for further information)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pasted Element Id</em>' attribute.
	 * @see #setPastedElementId(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getPasteEObjectConfiguration_PastedElementId()
	 * @model
	 * @generated
	 */
	String getPastedElementId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getPastedElementId <em>Pasted Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Element Id</em>' attribute.
	 * @see #getPastedElementId()
	 * @generated
	 */
	void setPastedElementId(String value);

	/**
	 * Returns the value of the '<em><b>Paste Element Containement Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field references the feature of the context of the table in which the created element will be added.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Paste Element Containement Feature</em>' reference.
	 * @see #setPasteElementContainementFeature(EStructuralFeature)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getPasteEObjectConfiguration_PasteElementContainementFeature()
	 * @model
	 * @generated
	 */
	EStructuralFeature getPasteElementContainementFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getPasteElementContainementFeature <em>Paste Element Containement Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paste Element Containement Feature</em>' reference.
	 * @see #getPasteElementContainementFeature()
	 * @generated
	 */
	void setPasteElementContainementFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Axis Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Identifier</em>' containment reference.
	 * @see #setAxisIdentifier(IAxis)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getPasteEObjectConfiguration_AxisIdentifier()
	 * @model containment="true"
	 * @generated
	 */
	IAxis getAxisIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration#getAxisIdentifier <em>Axis Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis Identifier</em>' containment reference.
	 * @see #getAxisIdentifier()
	 * @generated
	 */
	void setAxisIdentifier(IAxis value);
} // PasteEObjectConfiguration
