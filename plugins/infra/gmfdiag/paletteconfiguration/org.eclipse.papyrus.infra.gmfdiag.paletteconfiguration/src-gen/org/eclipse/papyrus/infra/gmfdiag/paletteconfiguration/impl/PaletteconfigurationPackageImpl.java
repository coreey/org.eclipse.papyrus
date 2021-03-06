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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.filters.FiltersPackage;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.ChildConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.Configuration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.DrawerConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.ElementDescriptor;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.IconDescriptor;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.LeafConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.PaletteconfigurationFactory;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.PaletteconfigurationPackage;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.SeparatorConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.StackConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.ToolConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.ToolKind;
import org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage;
import org.eclipse.uml2.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PaletteconfigurationPackageImpl extends EPackageImpl implements PaletteconfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paletteConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iconDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass drawerConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leafConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass separatorConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum toolKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.PaletteconfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PaletteconfigurationPackageImpl() {
		super(eNS_URI, PaletteconfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PaletteconfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PaletteconfigurationPackage init() {
		if (isInited) return (PaletteconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(PaletteconfigurationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPaletteconfigurationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PaletteconfigurationPackageImpl thePaletteconfigurationPackage = registeredPaletteconfigurationPackage instanceof PaletteconfigurationPackageImpl ? (PaletteconfigurationPackageImpl)registeredPaletteconfigurationPackage : new PaletteconfigurationPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		ElementTypesConfigurationsPackage.eINSTANCE.eClass();
		FiltersPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePaletteconfigurationPackage.createPackageContents();

		// Initialize created meta-data
		thePaletteconfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePaletteconfigurationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PaletteconfigurationPackage.eNS_URI, thePaletteconfigurationPackage);
		return thePaletteconfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPaletteConfiguration() {
		return paletteConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPaletteConfiguration_DrawerConfigurations() {
		return (EReference)paletteConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPaletteConfiguration_RequiredProfiles() {
		return (EAttribute)paletteConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Id() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Label() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Description() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_Icon() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIconDescriptor() {
		return iconDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIconDescriptor_PluginID() {
		return (EAttribute)iconDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIconDescriptor_IconPath() {
		return (EAttribute)iconDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDrawerConfiguration() {
		return drawerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDrawerConfiguration_OwnedConfigurations() {
		return (EReference)drawerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildConfiguration() {
		return childConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToolConfiguration() {
		return toolConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolConfiguration_Kind() {
		return (EAttribute)toolConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToolConfiguration_ElementDescriptors() {
		return (EReference)toolConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolConfiguration_ToolClassName() {
		return (EAttribute)toolConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLeafConfiguration() {
		return leafConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementDescriptor() {
		return elementDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementDescriptor_GraphicalHints() {
		return (EAttribute)elementDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementDescriptor_ElementType() {
		return (EReference)elementDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackConfiguration() {
		return stackConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStackConfiguration_OwnedConfigurations() {
		return (EReference)stackConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeparatorConfiguration() {
		return separatorConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getToolKind() {
		return toolKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PaletteconfigurationFactory getPaletteconfigurationFactory() {
		return (PaletteconfigurationFactory)getEFactoryInstance();
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
		paletteConfigurationEClass = createEClass(PALETTE_CONFIGURATION);
		createEReference(paletteConfigurationEClass, PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS);
		createEAttribute(paletteConfigurationEClass, PALETTE_CONFIGURATION__REQUIRED_PROFILES);

		configurationEClass = createEClass(CONFIGURATION);
		createEAttribute(configurationEClass, CONFIGURATION__ID);
		createEAttribute(configurationEClass, CONFIGURATION__LABEL);
		createEAttribute(configurationEClass, CONFIGURATION__DESCRIPTION);
		createEReference(configurationEClass, CONFIGURATION__ICON);

		iconDescriptorEClass = createEClass(ICON_DESCRIPTOR);
		createEAttribute(iconDescriptorEClass, ICON_DESCRIPTOR__PLUGIN_ID);
		createEAttribute(iconDescriptorEClass, ICON_DESCRIPTOR__ICON_PATH);

		drawerConfigurationEClass = createEClass(DRAWER_CONFIGURATION);
		createEReference(drawerConfigurationEClass, DRAWER_CONFIGURATION__OWNED_CONFIGURATIONS);

		childConfigurationEClass = createEClass(CHILD_CONFIGURATION);

		toolConfigurationEClass = createEClass(TOOL_CONFIGURATION);
		createEAttribute(toolConfigurationEClass, TOOL_CONFIGURATION__KIND);
		createEReference(toolConfigurationEClass, TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS);
		createEAttribute(toolConfigurationEClass, TOOL_CONFIGURATION__TOOL_CLASS_NAME);

		leafConfigurationEClass = createEClass(LEAF_CONFIGURATION);

		elementDescriptorEClass = createEClass(ELEMENT_DESCRIPTOR);
		createEAttribute(elementDescriptorEClass, ELEMENT_DESCRIPTOR__GRAPHICAL_HINTS);
		createEReference(elementDescriptorEClass, ELEMENT_DESCRIPTOR__ELEMENT_TYPE);

		stackConfigurationEClass = createEClass(STACK_CONFIGURATION);
		createEReference(stackConfigurationEClass, STACK_CONFIGURATION__OWNED_CONFIGURATIONS);

		separatorConfigurationEClass = createEClass(SEPARATOR_CONFIGURATION);

		// Create enums
		toolKindEEnum = createEEnum(TOOL_KIND);
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
		FiltersPackage theFiltersPackage = (FiltersPackage)EPackage.Registry.INSTANCE.getEPackage(FiltersPackage.eNS_URI);
		ElementTypesConfigurationsPackage theElementTypesConfigurationsPackage = (ElementTypesConfigurationsPackage)EPackage.Registry.INSTANCE.getEPackage(ElementTypesConfigurationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		paletteConfigurationEClass.getESuperTypes().add(this.getConfiguration());
		configurationEClass.getESuperTypes().add(theFiltersPackage.getFilteredElement());
		drawerConfigurationEClass.getESuperTypes().add(this.getConfiguration());
		childConfigurationEClass.getESuperTypes().add(this.getConfiguration());
		toolConfigurationEClass.getESuperTypes().add(this.getLeafConfiguration());
		leafConfigurationEClass.getESuperTypes().add(this.getChildConfiguration());
		stackConfigurationEClass.getESuperTypes().add(this.getChildConfiguration());
		separatorConfigurationEClass.getESuperTypes().add(this.getLeafConfiguration());

		// Initialize classes and features; add operations and parameters
		initEClass(paletteConfigurationEClass, PaletteConfiguration.class, "PaletteConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPaletteConfiguration_DrawerConfigurations(), this.getDrawerConfiguration(), null, "drawerConfigurations", null, 1, -1, PaletteConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPaletteConfiguration_RequiredProfiles(), ecorePackage.getEString(), "requiredProfiles", null, 0, -1, PaletteConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfiguration_Id(), ecorePackage.getEString(), "id", null, 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Label(), ecorePackage.getEString(), "label", null, 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Description(), ecorePackage.getEString(), "description", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfiguration_Icon(), this.getIconDescriptor(), null, "icon", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconDescriptorEClass, IconDescriptor.class, "IconDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIconDescriptor_PluginID(), ecorePackage.getEString(), "pluginID", null, 0, 1, IconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconDescriptor_IconPath(), ecorePackage.getEString(), "iconPath", null, 1, 1, IconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(drawerConfigurationEClass, DrawerConfiguration.class, "DrawerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDrawerConfiguration_OwnedConfigurations(), this.getChildConfiguration(), null, "ownedConfigurations", null, 1, -1, DrawerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childConfigurationEClass, ChildConfiguration.class, "ChildConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(toolConfigurationEClass, ToolConfiguration.class, "ToolConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToolConfiguration_Kind(), this.getToolKind(), "kind", "CreationTool", 1, 1, ToolConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToolConfiguration_ElementDescriptors(), this.getElementDescriptor(), null, "elementDescriptors", null, 0, -1, ToolConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToolConfiguration_ToolClassName(), ecorePackage.getEString(), "toolClassName", null, 0, 1, ToolConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(leafConfigurationEClass, LeafConfiguration.class, "LeafConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementDescriptorEClass, ElementDescriptor.class, "ElementDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementDescriptor_GraphicalHints(), ecorePackage.getEString(), "graphicalHints", null, 0, -1, ElementDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementDescriptor_ElementType(), theElementTypesConfigurationsPackage.getElementTypeConfiguration(), null, "elementType", null, 1, 1, ElementDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stackConfigurationEClass, StackConfiguration.class, "StackConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStackConfiguration_OwnedConfigurations(), this.getLeafConfiguration(), null, "ownedConfigurations", null, 1, -1, StackConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(separatorConfigurationEClass, SeparatorConfiguration.class, "SeparatorConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(toolKindEEnum, ToolKind.class, "ToolKind");
		addEEnumLiteral(toolKindEEnum, ToolKind.CREATION_TOOL);
		addEEnumLiteral(toolKindEEnum, ToolKind.CONNECTION_TOOL);

		// Create resource
		createResource(eNS_URI);
	}

} //PaletteconfigurationPackageImpl
