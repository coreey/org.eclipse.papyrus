/*****************************************************************************
 * Copyright (c) 2011, 2021 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - add prototype reference to Context (CDO)
 *   Christian W. Damus - bug 573986
 *****************************************************************************/
package org.eclipse.papyrus.infra.properties.contexts.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.constraints.impl.DisplayUnitImpl;
import org.eclipse.papyrus.infra.properties.contexts.Annotatable;
import org.eclipse.papyrus.infra.properties.contexts.Annotation;
import org.eclipse.papyrus.infra.properties.contexts.Context;
import org.eclipse.papyrus.infra.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.contexts.Section;
import org.eclipse.papyrus.infra.properties.contexts.View;
import org.eclipse.papyrus.infra.properties.contexts.operations.AnnotatableOperations;
import org.eclipse.uml2.common.util.CacheAdapter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.properties.contexts.impl.ViewImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.properties.contexts.impl.ViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.properties.contexts.impl.ViewImpl#getSections <em>Sections</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.properties.contexts.impl.ViewImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.properties.contexts.impl.ViewImpl#isAutomaticContext <em>Automatic Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.properties.contexts.impl.ViewImpl#getDatacontexts <em>Datacontexts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewImpl extends DisplayUnitImpl implements View {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSections() <em>Sections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSections()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> sections;

	/**
	 * The default value of the '{@link #isAutomaticContext() <em>Automatic Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutomaticContext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTOMATIC_CONTEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutomaticContext() <em>Automatic Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutomaticContext()
	 * @generated
	 * @ordered
	 */
	protected boolean automaticContext = AUTOMATIC_CONTEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDatacontexts() <em>Datacontexts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatacontexts()
	 * @generated
	 * @ordered
	 */
	protected EList<DataContextElement> datacontexts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentWithInverseEList<Annotation>(Annotation.class, this, ContextsPackage.VIEW__ANNOTATIONS, ContextsPackage.ANNOTATION__ELEMENT);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.VIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Section> getSections() {
		if (sections == null) {
			sections = new EObjectResolvingEList<Section>(Section.class, this, ContextsPackage.VIEW__SECTIONS);
		}
		return sections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Context getContext() {
		if (eContainerFeatureID() != ContextsPackage.VIEW__CONTEXT) return null;
		return (Context)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(Context newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContext, ContextsPackage.VIEW__CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContext(Context newContext) {
		if (newContext != eInternalContainer() || (eContainerFeatureID() != ContextsPackage.VIEW__CONTEXT && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, ContextsPackage.CONTEXT__VIEWS, Context.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.VIEW__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation getAnnotation(String source) {
		return AnnotatableOperations.getAnnotation(this, source);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAutomaticContext() {
		return automaticContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAutomaticContext(boolean newAutomaticContext) {
		boolean oldAutomaticContext = automaticContext;
		automaticContext = newAutomaticContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextsPackage.VIEW__AUTOMATIC_CONTEXT, oldAutomaticContext, automaticContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataContextElement> getDatacontexts() {
		if (datacontexts == null) {
			datacontexts = new EObjectResolvingEList<DataContextElement>(DataContextElement.class, this, ContextsPackage.VIEW__DATACONTEXTS);
		}
		return datacontexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.VIEW__ANNOTATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotations()).basicAdd(otherEnd, msgs);
			case ContextsPackage.VIEW__CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((Context)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextsPackage.VIEW__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case ContextsPackage.VIEW__CONTEXT:
				return basicSetContext(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ContextsPackage.VIEW__CONTEXT:
				return eInternalContainer().eInverseRemove(this, ContextsPackage.CONTEXT__VIEWS, Context.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContextsPackage.VIEW__ANNOTATIONS:
				return getAnnotations();
			case ContextsPackage.VIEW__NAME:
				return getName();
			case ContextsPackage.VIEW__SECTIONS:
				return getSections();
			case ContextsPackage.VIEW__CONTEXT:
				return getContext();
			case ContextsPackage.VIEW__AUTOMATIC_CONTEXT:
				return isAutomaticContext();
			case ContextsPackage.VIEW__DATACONTEXTS:
				return getDatacontexts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ContextsPackage.VIEW__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case ContextsPackage.VIEW__NAME:
				setName((String)newValue);
				return;
			case ContextsPackage.VIEW__SECTIONS:
				getSections().clear();
				getSections().addAll((Collection<? extends Section>)newValue);
				return;
			case ContextsPackage.VIEW__CONTEXT:
				setContext((Context)newValue);
				return;
			case ContextsPackage.VIEW__AUTOMATIC_CONTEXT:
				setAutomaticContext((Boolean)newValue);
				return;
			case ContextsPackage.VIEW__DATACONTEXTS:
				getDatacontexts().clear();
				getDatacontexts().addAll((Collection<? extends DataContextElement>)newValue);
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
			case ContextsPackage.VIEW__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case ContextsPackage.VIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ContextsPackage.VIEW__SECTIONS:
				getSections().clear();
				return;
			case ContextsPackage.VIEW__CONTEXT:
				setContext((Context)null);
				return;
			case ContextsPackage.VIEW__AUTOMATIC_CONTEXT:
				setAutomaticContext(AUTOMATIC_CONTEXT_EDEFAULT);
				return;
			case ContextsPackage.VIEW__DATACONTEXTS:
				getDatacontexts().clear();
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
			case ContextsPackage.VIEW__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case ContextsPackage.VIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ContextsPackage.VIEW__SECTIONS:
				return sections != null && !sections.isEmpty();
			case ContextsPackage.VIEW__CONTEXT:
				return getContext() != null;
			case ContextsPackage.VIEW__AUTOMATIC_CONTEXT:
				return automaticContext != AUTOMATIC_CONTEXT_EDEFAULT;
			case ContextsPackage.VIEW__DATACONTEXTS:
				return datacontexts != null && !datacontexts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Annotatable.class) {
			switch (derivedFeatureID) {
				case ContextsPackage.VIEW__ANNOTATIONS: return ContextsPackage.ANNOTATABLE__ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Annotatable.class) {
			switch (baseFeatureID) {
				case ContextsPackage.ANNOTATABLE__ANNOTATIONS: return ContextsPackage.VIEW__ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Annotatable.class) {
			switch (baseOperationID) {
				case ContextsPackage.ANNOTATABLE___GET_ANNOTATION__STRING: return ContextsPackage.VIEW___GET_ANNOTATION__STRING;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ContextsPackage.VIEW___GET_ANNOTATION__STRING:
				return getAnnotation((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", automaticContext: "); //$NON-NLS-1$
		result.append(automaticContext);
		result.append(')');
		return result.toString();
	}

	/**
	 * Retrieves the cache adapter for this '<em><b>View</b></em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The cache adapter for this '<em><b>View</b></em>'.
	 * @generated
	 */
	protected CacheAdapter getCacheAdapter() {
		return CacheAdapter.getInstance();
	}

} // ViewImpl
