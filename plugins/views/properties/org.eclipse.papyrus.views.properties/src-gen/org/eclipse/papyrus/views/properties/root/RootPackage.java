/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.views.properties.root;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.views.properties.root.RootFactory
 * @model kind="package"
 * @generated
 */
public interface RootPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "root"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/properties/root"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "root"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	RootPackage eINSTANCE = org.eclipse.papyrus.views.properties.root.impl.RootPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.views.properties.root.impl.PropertiesRootImpl <em>Properties Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.views.properties.root.impl.PropertiesRootImpl
	 * @see org.eclipse.papyrus.views.properties.root.impl.RootPackageImpl#getPropertiesRoot()
	 * @generated
	 */
	int PROPERTIES_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Environments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_ROOT__ENVIRONMENTS = 0;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_ROOT__CONTEXTS = 1;

	/**
	 * The number of structural features of the '<em>Properties Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_ROOT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.views.properties.root.PropertiesRoot <em>Properties Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Properties Root</em>'.
	 * @see org.eclipse.papyrus.views.properties.root.PropertiesRoot
	 * @generated
	 */
	EClass getPropertiesRoot();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.views.properties.root.PropertiesRoot#getEnvironments <em>Environments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Environments</em>'.
	 * @see org.eclipse.papyrus.views.properties.root.PropertiesRoot#getEnvironments()
	 * @see #getPropertiesRoot()
	 * @generated
	 */
	EReference getPropertiesRoot_Environments();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.views.properties.root.PropertiesRoot#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Contexts</em>'.
	 * @see org.eclipse.papyrus.views.properties.root.PropertiesRoot#getContexts()
	 * @see #getPropertiesRoot()
	 * @generated
	 */
	EReference getPropertiesRoot_Contexts();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RootFactory getRootFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.views.properties.root.impl.PropertiesRootImpl <em>Properties Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.views.properties.root.impl.PropertiesRootImpl
		 * @see org.eclipse.papyrus.views.properties.root.impl.RootPackageImpl#getPropertiesRoot()
		 * @generated
		 */
		EClass PROPERTIES_ROOT = eINSTANCE.getPropertiesRoot();

		/**
		 * The meta object literal for the '<em><b>Environments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference PROPERTIES_ROOT__ENVIRONMENTS = eINSTANCE.getPropertiesRoot_Environments();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference PROPERTIES_ROOT__CONTEXTS = eINSTANCE.getPropertiesRoot_Contexts();

	}

} // RootPackage
