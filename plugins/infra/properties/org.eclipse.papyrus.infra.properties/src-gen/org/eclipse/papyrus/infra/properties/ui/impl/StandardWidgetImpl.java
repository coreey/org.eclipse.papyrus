/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.infra.properties.ui.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.infra.properties.environment.StandardWidgetType;
import org.eclipse.papyrus.infra.properties.ui.StandardWidget;
import org.eclipse.papyrus.infra.properties.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Widget</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.properties.ui.impl.StandardWidgetImpl#getWidgetType <em>Widget Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StandardWidgetImpl extends WidgetImpl implements StandardWidget {
	/**
	 * The cached value of the '{@link #getWidgetType() <em>Widget Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgetType()
	 * @generated
	 * @ordered
	 */
	protected StandardWidgetType widgetType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardWidgetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.STANDARD_WIDGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StandardWidgetType getWidgetType() {
		if (widgetType != null && widgetType.eIsProxy()) {
			InternalEObject oldWidgetType = (InternalEObject)widgetType;
			widgetType = (StandardWidgetType)eResolveProxy(oldWidgetType);
			if (widgetType != oldWidgetType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.STANDARD_WIDGET__WIDGET_TYPE, oldWidgetType, widgetType));
			}
		}
		return widgetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardWidgetType basicGetWidgetType() {
		return widgetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidgetType(StandardWidgetType newWidgetType) {
		StandardWidgetType oldWidgetType = widgetType;
		widgetType = newWidgetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STANDARD_WIDGET__WIDGET_TYPE, oldWidgetType, widgetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiPackage.STANDARD_WIDGET__WIDGET_TYPE:
				if (resolve) return getWidgetType();
				return basicGetWidgetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UiPackage.STANDARD_WIDGET__WIDGET_TYPE:
				setWidgetType((StandardWidgetType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UiPackage.STANDARD_WIDGET__WIDGET_TYPE:
				setWidgetType((StandardWidgetType)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UiPackage.STANDARD_WIDGET__WIDGET_TYPE:
				return widgetType != null;
		}
		return super.eIsSet(featureID);
	}

} // StandardWidgetImpl
