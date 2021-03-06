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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.emf.expressions.ExpressionsPackage;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.BooleanExpressionsPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.NattableaxisPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.FeatureAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TreeFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.util.NattableaxisconfigurationValidator;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.NattablecelleditorPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.impl.NattablecelleditorPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.NattableproblemPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.NattablestylePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.impl.NattablestylePackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.NattabletesterPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.impl.NattabletesterPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablewrapper.NattablewrapperPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablewrapper.impl.NattablewrapperPackageImpl;
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattableaxisconfigurationPackageImpl extends EPackageImpl implements NattableaxisconfigurationPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractHeaderAxisConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axisManagerRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axisManagerConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableHeaderAxisConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localTableHeaderAxisConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAxisConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureAxisConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFillingConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStructuralFeatureValueFillingConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPasteConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pasteEObjectConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeFillingConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum axisIndexStyleEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NattableaxisconfigurationPackageImpl() {
		super(eNS_URI, NattableaxisconfigurationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link NattableaxisconfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NattableaxisconfigurationPackage init() {
		if (isInited) return (NattableaxisconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredNattableaxisconfigurationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		NattableaxisconfigurationPackageImpl theNattableaxisconfigurationPackage = registeredNattableaxisconfigurationPackage instanceof NattableaxisconfigurationPackageImpl ? (NattableaxisconfigurationPackageImpl)registeredNattableaxisconfigurationPackage : new NattableaxisconfigurationPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		ElementTypesConfigurationsPackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI);
		NattablePackageImpl theNattablePackage = (NattablePackageImpl)(registeredPackage instanceof NattablePackageImpl ? registeredPackage : NattablePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI);
		NattableconfigurationPackageImpl theNattableconfigurationPackage = (NattableconfigurationPackageImpl)(registeredPackage instanceof NattableconfigurationPackageImpl ? registeredPackage : NattableconfigurationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI);
		NattableaxisproviderPackageImpl theNattableaxisproviderPackage = (NattableaxisproviderPackageImpl)(registeredPackage instanceof NattableaxisproviderPackageImpl ? registeredPackage : NattableaxisproviderPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI);
		NattablelabelproviderPackageImpl theNattablelabelproviderPackage = (NattablelabelproviderPackageImpl)(registeredPackage instanceof NattablelabelproviderPackageImpl ? registeredPackage : NattablelabelproviderPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattabletesterPackage.eNS_URI);
		NattabletesterPackageImpl theNattabletesterPackage = (NattabletesterPackageImpl)(registeredPackage instanceof NattabletesterPackageImpl ? registeredPackage : NattabletesterPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattableaxisPackage.eNS_URI);
		NattableaxisPackageImpl theNattableaxisPackage = (NattableaxisPackageImpl)(registeredPackage instanceof NattableaxisPackageImpl ? registeredPackage : NattableaxisPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattablecellPackage.eNS_URI);
		NattablecellPackageImpl theNattablecellPackage = (NattablecellPackageImpl)(registeredPackage instanceof NattablecellPackageImpl ? registeredPackage : NattablecellPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattableproblemPackage.eNS_URI);
		NattableproblemPackageImpl theNattableproblemPackage = (NattableproblemPackageImpl)(registeredPackage instanceof NattableproblemPackageImpl ? registeredPackage : NattableproblemPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattablestylePackage.eNS_URI);
		NattablestylePackageImpl theNattablestylePackage = (NattablestylePackageImpl)(registeredPackage instanceof NattablestylePackageImpl ? registeredPackage : NattablestylePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattablecelleditorPackage.eNS_URI);
		NattablecelleditorPackageImpl theNattablecelleditorPackage = (NattablecelleditorPackageImpl)(registeredPackage instanceof NattablecelleditorPackageImpl ? registeredPackage : NattablecelleditorPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NattablewrapperPackage.eNS_URI);
		NattablewrapperPackageImpl theNattablewrapperPackage = (NattablewrapperPackageImpl)(registeredPackage instanceof NattablewrapperPackageImpl ? registeredPackage : NattablewrapperPackage.eINSTANCE);

		// Create package meta-data objects
		theNattableaxisconfigurationPackage.createPackageContents();
		theNattablePackage.createPackageContents();
		theNattableconfigurationPackage.createPackageContents();
		theNattableaxisproviderPackage.createPackageContents();
		theNattablelabelproviderPackage.createPackageContents();
		theNattabletesterPackage.createPackageContents();
		theNattableaxisPackage.createPackageContents();
		theNattablecellPackage.createPackageContents();
		theNattableproblemPackage.createPackageContents();
		theNattablestylePackage.createPackageContents();
		theNattablecelleditorPackage.createPackageContents();
		theNattablewrapperPackage.createPackageContents();

		// Initialize created meta-data
		theNattableaxisconfigurationPackage.initializePackageContents();
		theNattablePackage.initializePackageContents();
		theNattableconfigurationPackage.initializePackageContents();
		theNattableaxisproviderPackage.initializePackageContents();
		theNattablelabelproviderPackage.initializePackageContents();
		theNattabletesterPackage.initializePackageContents();
		theNattableaxisPackage.initializePackageContents();
		theNattablecellPackage.initializePackageContents();
		theNattableproblemPackage.initializePackageContents();
		theNattablestylePackage.initializePackageContents();
		theNattablecelleditorPackage.initializePackageContents();
		theNattablewrapperPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theNattableaxisconfigurationPackage,
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return NattableaxisconfigurationValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theNattableaxisconfigurationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NattableaxisconfigurationPackage.eNS_URI, theNattableaxisconfigurationPackage);
		return theNattableaxisconfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractHeaderAxisConfiguration() {
		return abstractHeaderAxisConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractHeaderAxisConfiguration_IndexStyle() {
		return (EAttribute)abstractHeaderAxisConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractHeaderAxisConfiguration_DisplayLabel() {
		return (EAttribute)abstractHeaderAxisConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractHeaderAxisConfiguration_DisplayFilter() {
		return (EAttribute)abstractHeaderAxisConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractHeaderAxisConfiguration_DisplayIndex() {
		return (EAttribute)abstractHeaderAxisConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractHeaderAxisConfiguration_OwnedLabelConfigurations() {
		return (EReference)abstractHeaderAxisConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractHeaderAxisConfiguration_OwnedAxisConfigurations() {
		return (EReference)abstractHeaderAxisConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAxisManagerRepresentation() {
		return axisManagerRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAxisManagerRepresentation_AxisManagerId() {
		return (EAttribute)axisManagerRepresentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAxisManagerRepresentation_LabelProviderContext() {
		return (EAttribute)axisManagerRepresentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAxisManagerRepresentation_HeaderLabelConfiguration() {
		return (EReference)axisManagerRepresentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAxisManagerRepresentation_SpecificAxisConfigurations() {
		return (EReference)axisManagerRepresentationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAxisManagerConfiguration() {
		return axisManagerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAxisManagerConfiguration_LocalHeaderLabelConfiguration() {
		return (EReference)axisManagerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAxisManagerConfiguration_AxisManager() {
		return (EReference)axisManagerConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAxisManagerConfiguration_LocalSpecificConfigurations() {
		return (EReference)axisManagerConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTableHeaderAxisConfiguration() {
		return tableHeaderAxisConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTableHeaderAxisConfiguration_AxisManagers() {
		return (EReference)tableHeaderAxisConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLocalTableHeaderAxisConfiguration() {
		return localTableHeaderAxisConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLocalTableHeaderAxisConfiguration_AxisManagerConfigurations() {
		return (EReference)localTableHeaderAxisConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIAxisConfiguration() {
		return iAxisConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeatureAxisConfiguration() {
		return featureAxisConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFeatureAxisConfiguration_ShowOnlyCommonFeature() {
		return (EAttribute)featureAxisConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIFillingConfiguration() {
		return iFillingConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEStructuralFeatureValueFillingConfiguration() {
		return eStructuralFeatureValueFillingConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEStructuralFeatureValueFillingConfiguration_ListenFeature() {
		return (EReference)eStructuralFeatureValueFillingConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPasteConfiguration() {
		return iPasteConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPasteConfiguration_PostActions() {
		return (EAttribute)iPasteConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPasteConfiguration_DetachedMode() {
		return (EAttribute)iPasteConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPasteEObjectConfiguration() {
		return pasteEObjectConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPasteEObjectConfiguration_PastedElementId() {
		return (EAttribute)pasteEObjectConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPasteEObjectConfiguration_PasteElementContainementFeature() {
		return (EReference)pasteEObjectConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPasteEObjectConfiguration_AxisIdentifier() {
		return (EReference)pasteEObjectConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTreeFillingConfiguration() {
		return treeFillingConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTreeFillingConfiguration_AxisUsedAsAxisProvider() {
		return (EReference)treeFillingConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTreeFillingConfiguration_PasteConfiguration() {
		return (EReference)treeFillingConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTreeFillingConfiguration_Depth() {
		return (EAttribute)treeFillingConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTreeFillingConfiguration_LabelProvider() {
		return (EReference)treeFillingConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTreeFillingConfiguration_LabelProviderContext() {
		return (EAttribute)treeFillingConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeFillingConfiguration_FilterRule() {
		return (EReference)treeFillingConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAxisIndexStyle() {
		return axisIndexStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NattableaxisconfigurationFactory getNattableaxisconfigurationFactory() {
		return (NattableaxisconfigurationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractHeaderAxisConfigurationEClass = createEClass(ABSTRACT_HEADER_AXIS_CONFIGURATION);
		createEAttribute(abstractHeaderAxisConfigurationEClass, ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE);
		createEAttribute(abstractHeaderAxisConfigurationEClass, ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL);
		createEAttribute(abstractHeaderAxisConfigurationEClass, ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER);
		createEAttribute(abstractHeaderAxisConfigurationEClass, ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX);
		createEReference(abstractHeaderAxisConfigurationEClass, ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS);
		createEReference(abstractHeaderAxisConfigurationEClass, ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS);

		axisManagerRepresentationEClass = createEClass(AXIS_MANAGER_REPRESENTATION);
		createEAttribute(axisManagerRepresentationEClass, AXIS_MANAGER_REPRESENTATION__AXIS_MANAGER_ID);
		createEAttribute(axisManagerRepresentationEClass, AXIS_MANAGER_REPRESENTATION__LABEL_PROVIDER_CONTEXT);
		createEReference(axisManagerRepresentationEClass, AXIS_MANAGER_REPRESENTATION__HEADER_LABEL_CONFIGURATION);
		createEReference(axisManagerRepresentationEClass, AXIS_MANAGER_REPRESENTATION__SPECIFIC_AXIS_CONFIGURATIONS);

		axisManagerConfigurationEClass = createEClass(AXIS_MANAGER_CONFIGURATION);
		createEReference(axisManagerConfigurationEClass, AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION);
		createEReference(axisManagerConfigurationEClass, AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER);
		createEReference(axisManagerConfigurationEClass, AXIS_MANAGER_CONFIGURATION__LOCAL_SPECIFIC_CONFIGURATIONS);

		tableHeaderAxisConfigurationEClass = createEClass(TABLE_HEADER_AXIS_CONFIGURATION);
		createEReference(tableHeaderAxisConfigurationEClass, TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS);

		localTableHeaderAxisConfigurationEClass = createEClass(LOCAL_TABLE_HEADER_AXIS_CONFIGURATION);
		createEReference(localTableHeaderAxisConfigurationEClass, LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS);

		iAxisConfigurationEClass = createEClass(IAXIS_CONFIGURATION);

		featureAxisConfigurationEClass = createEClass(FEATURE_AXIS_CONFIGURATION);
		createEAttribute(featureAxisConfigurationEClass, FEATURE_AXIS_CONFIGURATION__SHOW_ONLY_COMMON_FEATURE);

		iFillingConfigurationEClass = createEClass(IFILLING_CONFIGURATION);

		eStructuralFeatureValueFillingConfigurationEClass = createEClass(ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION);
		createEReference(eStructuralFeatureValueFillingConfigurationEClass, ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE);

		iPasteConfigurationEClass = createEClass(IPASTE_CONFIGURATION);
		createEAttribute(iPasteConfigurationEClass, IPASTE_CONFIGURATION__POST_ACTIONS);
		createEAttribute(iPasteConfigurationEClass, IPASTE_CONFIGURATION__DETACHED_MODE);

		pasteEObjectConfigurationEClass = createEClass(PASTE_EOBJECT_CONFIGURATION);
		createEAttribute(pasteEObjectConfigurationEClass, PASTE_EOBJECT_CONFIGURATION__PASTED_ELEMENT_ID);
		createEReference(pasteEObjectConfigurationEClass, PASTE_EOBJECT_CONFIGURATION__PASTE_ELEMENT_CONTAINEMENT_FEATURE);
		createEReference(pasteEObjectConfigurationEClass, PASTE_EOBJECT_CONFIGURATION__AXIS_IDENTIFIER);

		treeFillingConfigurationEClass = createEClass(TREE_FILLING_CONFIGURATION);
		createEReference(treeFillingConfigurationEClass, TREE_FILLING_CONFIGURATION__AXIS_USED_AS_AXIS_PROVIDER);
		createEReference(treeFillingConfigurationEClass, TREE_FILLING_CONFIGURATION__PASTE_CONFIGURATION);
		createEAttribute(treeFillingConfigurationEClass, TREE_FILLING_CONFIGURATION__DEPTH);
		createEReference(treeFillingConfigurationEClass, TREE_FILLING_CONFIGURATION__LABEL_PROVIDER);
		createEAttribute(treeFillingConfigurationEClass, TREE_FILLING_CONFIGURATION__LABEL_PROVIDER_CONTEXT);
		createEReference(treeFillingConfigurationEClass, TREE_FILLING_CONFIGURATION__FILTER_RULE);

		// Create enums
		axisIndexStyleEEnum = createEEnum(AXIS_INDEX_STYLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		NattablestylePackage theNattablestylePackage = (NattablestylePackage)EPackage.Registry.INSTANCE.getEPackage(NattablestylePackage.eNS_URI);
		NattablelabelproviderPackage theNattablelabelproviderPackage = (NattablelabelproviderPackage)EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI);
		NattableaxisPackage theNattableaxisPackage = (NattableaxisPackage)EPackage.Registry.INSTANCE.getEPackage(NattableaxisPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		BooleanExpressionsPackage theBooleanExpressionsPackage = (BooleanExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(BooleanExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractHeaderAxisConfigurationEClass.getESuperTypes().add(theNattablestylePackage.getStyledElement());
		axisManagerRepresentationEClass.getESuperTypes().add(theNattablestylePackage.getStyledElement());
		axisManagerConfigurationEClass.getESuperTypes().add(theNattablestylePackage.getStyledElement());
		tableHeaderAxisConfigurationEClass.getESuperTypes().add(this.getAbstractHeaderAxisConfiguration());
		localTableHeaderAxisConfigurationEClass.getESuperTypes().add(this.getAbstractHeaderAxisConfiguration());
		iAxisConfigurationEClass.getESuperTypes().add(theNattablestylePackage.getStyledElement());
		featureAxisConfigurationEClass.getESuperTypes().add(this.getIAxisConfiguration());
		iFillingConfigurationEClass.getESuperTypes().add(this.getIAxisConfiguration());
		eStructuralFeatureValueFillingConfigurationEClass.getESuperTypes().add(this.getIFillingConfiguration());
		iPasteConfigurationEClass.getESuperTypes().add(this.getIAxisConfiguration());
		pasteEObjectConfigurationEClass.getESuperTypes().add(this.getIPasteConfiguration());
		treeFillingConfigurationEClass.getESuperTypes().add(this.getIFillingConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractHeaderAxisConfigurationEClass, AbstractHeaderAxisConfiguration.class, "AbstractHeaderAxisConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractHeaderAxisConfiguration_IndexStyle(), this.getAxisIndexStyle(), "indexStyle", null, 1, 1, AbstractHeaderAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractHeaderAxisConfiguration_DisplayLabel(), ecorePackage.getEBoolean(), "displayLabel", "true", 1, 1, AbstractHeaderAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getAbstractHeaderAxisConfiguration_DisplayFilter(), ecorePackage.getEBoolean(), "displayFilter", "false", 1, 1, AbstractHeaderAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getAbstractHeaderAxisConfiguration_DisplayIndex(), ecorePackage.getEBoolean(), "displayIndex", "true", 1, 1, AbstractHeaderAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getAbstractHeaderAxisConfiguration_OwnedLabelConfigurations(), theNattablelabelproviderPackage.getILabelProviderConfiguration(), null, "ownedLabelConfigurations", null, 0, -1, AbstractHeaderAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractHeaderAxisConfiguration_OwnedAxisConfigurations(), this.getIAxisConfiguration(), null, "ownedAxisConfigurations", null, 0, -1, AbstractHeaderAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(axisManagerRepresentationEClass, AxisManagerRepresentation.class, "AxisManagerRepresentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAxisManagerRepresentation_AxisManagerId(), ecorePackage.getEString(), "axisManagerId", null, 1, 1, AxisManagerRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAxisManagerRepresentation_LabelProviderContext(), ecorePackage.getEString(), "labelProviderContext", null, 0, 1, AxisManagerRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAxisManagerRepresentation_HeaderLabelConfiguration(), theNattablelabelproviderPackage.getILabelProviderConfiguration(), null, "headerLabelConfiguration", null, 1, 1, AxisManagerRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAxisManagerRepresentation_SpecificAxisConfigurations(), this.getIAxisConfiguration(), null, "specificAxisConfigurations", null, 0, -1, AxisManagerRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(axisManagerConfigurationEClass, AxisManagerConfiguration.class, "AxisManagerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAxisManagerConfiguration_LocalHeaderLabelConfiguration(), theNattablelabelproviderPackage.getILabelProviderConfiguration(), null, "localHeaderLabelConfiguration", null, 0, 1, AxisManagerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAxisManagerConfiguration_AxisManager(), this.getAxisManagerRepresentation(), null, "axisManager", null, 1, 1, AxisManagerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAxisManagerConfiguration_LocalSpecificConfigurations(), this.getIAxisConfiguration(), null, "localSpecificConfigurations", null, 0, -1, AxisManagerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tableHeaderAxisConfigurationEClass, TableHeaderAxisConfiguration.class, "TableHeaderAxisConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTableHeaderAxisConfiguration_AxisManagers(), this.getAxisManagerRepresentation(), null, "axisManagers", null, 1, -1, TableHeaderAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(localTableHeaderAxisConfigurationEClass, LocalTableHeaderAxisConfiguration.class, "LocalTableHeaderAxisConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLocalTableHeaderAxisConfiguration_AxisManagerConfigurations(), this.getAxisManagerConfiguration(), null, "axisManagerConfigurations", null, 0, -1, LocalTableHeaderAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iAxisConfigurationEClass, IAxisConfiguration.class, "IAxisConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(featureAxisConfigurationEClass, FeatureAxisConfiguration.class, "FeatureAxisConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getFeatureAxisConfiguration_ShowOnlyCommonFeature(), ecorePackage.getEBoolean(), "showOnlyCommonFeature", null, 0, 1, FeatureAxisConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iFillingConfigurationEClass, IFillingConfiguration.class, "IFillingConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(eStructuralFeatureValueFillingConfigurationEClass, EStructuralFeatureValueFillingConfiguration.class, "EStructuralFeatureValueFillingConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEStructuralFeatureValueFillingConfiguration_ListenFeature(), ecorePackage.getEStructuralFeature(), null, "listenFeature", null, 1, 1, EStructuralFeatureValueFillingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iPasteConfigurationEClass, IPasteConfiguration.class, "IPasteConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIPasteConfiguration_PostActions(), ecorePackage.getEString(), "postActions", null, 0, -1, IPasteConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIPasteConfiguration_DetachedMode(), ecorePackage.getEBoolean(), "detachedMode", "true", 0, 1, IPasteConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(pasteEObjectConfigurationEClass, PasteEObjectConfiguration.class, "PasteEObjectConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPasteEObjectConfiguration_PastedElementId(), ecorePackage.getEString(), "pastedElementId", null, 0, 1, PasteEObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPasteEObjectConfiguration_PasteElementContainementFeature(), ecorePackage.getEStructuralFeature(), null, "pasteElementContainementFeature", null, 0, 1, PasteEObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPasteEObjectConfiguration_AxisIdentifier(), theNattableaxisPackage.getIAxis(), null, "axisIdentifier", null, 0, 1, PasteEObjectConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(treeFillingConfigurationEClass, TreeFillingConfiguration.class, "TreeFillingConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTreeFillingConfiguration_AxisUsedAsAxisProvider(), theNattableaxisPackage.getIAxis(), null, "axisUsedAsAxisProvider", null, 1, 1, TreeFillingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTreeFillingConfiguration_PasteConfiguration(), this.getPasteEObjectConfiguration(), null, "pasteConfiguration", null, 0, 1, TreeFillingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTreeFillingConfiguration_Depth(), theEcorePackage.getEInt(), "depth", null, 0, 1, TreeFillingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTreeFillingConfiguration_LabelProvider(), theNattablelabelproviderPackage.getILabelProviderConfiguration(), null, "labelProvider", null, 1, 1, TreeFillingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTreeFillingConfiguration_LabelProviderContext(), ecorePackage.getEString(), "labelProviderContext", null, 1, 1, TreeFillingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTreeFillingConfiguration_FilterRule(), theBooleanExpressionsPackage.getIBooleanEObjectExpression(), null, "filterRule", null, 0, 1, TreeFillingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(axisIndexStyleEEnum, AxisIndexStyle.class, "AxisIndexStyle"); //$NON-NLS-1$
		addEEnumLiteral(axisIndexStyleEEnum, AxisIndexStyle.ALPHABETIC);
		addEEnumLiteral(axisIndexStyleEEnum, AxisIndexStyle.NUMERIC);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$ //$NON-NLS-2$
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$ //$NON-NLS-2$
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (axisManagerRepresentationEClass,
		   source,
		   new String[] {
			   "constraints", "nonEmptyAxisManager" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (tableHeaderAxisConfigurationEClass,
		   source,
		   new String[] {
			   "constraints", "axisManagersIdUnique" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"; //$NON-NLS-1$
		addAnnotation
		  (axisManagerRepresentationEClass,
		   source,
		   new String[] {
			   "nonEmptyAxisManager", "not (axisManagerId.oclIsUndefined() or axisManagerId = \'\')" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (tableHeaderAxisConfigurationEClass,
		   source,
		   new String[] {
			   "axisManagersIdUnique", "axisManagers->forAll(am1 : AxisManagerRepresentation | ( (axisManagers->excluding (am1))->forAll(am2 : AxisManagerRepresentation | am1.axisManagerId<>am2.axisManagerId) ))" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}
} // NattableaxisconfigurationPackageImpl
