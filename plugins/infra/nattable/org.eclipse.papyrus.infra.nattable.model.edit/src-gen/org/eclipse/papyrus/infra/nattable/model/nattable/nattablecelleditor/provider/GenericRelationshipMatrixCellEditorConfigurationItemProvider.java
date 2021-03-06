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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.BooleanExpressionsFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.GenericRelationshipMatrixCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.NattablecelleditorPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.provider.StyledElementItemProvider;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablewrapper.NattablewrapperFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecelleditor.GenericRelationshipMatrixCellEditorConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericRelationshipMatrixCellEditorConfigurationItemProvider extends StyledElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericRelationshipMatrixCellEditorConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCellEditorIdPropertyDescriptor(object);
			addDirectionPropertyDescriptor(object);
			addCellContentsFilterPropertyDescriptor(object);
			addEditedElementPropertyDescriptor(object);
			addRelationshipOwnerStrategyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Cell Editor Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCellEditorIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ICellEditorConfiguration_cellEditorId_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ICellEditorConfiguration_cellEditorId_feature", "_UI_ICellEditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablecelleditorPackage.Literals.ICELL_EDITOR_CONFIGURATION__CELL_EDITOR_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Direction feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDirectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRelationshipMatrixCellEditorConfiguration_direction_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRelationshipMatrixCellEditorConfiguration_direction_feature", "_UI_GenericRelationshipMatrixCellEditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__DIRECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cell Contents Filter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCellContentsFilterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRelationshipMatrixCellEditorConfiguration_cellContentsFilter_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRelationshipMatrixCellEditorConfiguration_cellContentsFilter_feature", "_UI_GenericRelationshipMatrixCellEditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Edited Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditedElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRelationshipMatrixCellEditorConfiguration_editedElement_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRelationshipMatrixCellEditorConfiguration_editedElement_feature", "_UI_GenericRelationshipMatrixCellEditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__EDITED_ELEMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Relationship Owner Strategy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelationshipOwnerStrategyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRelationshipMatrixCellEditorConfiguration_relationshipOwnerStrategy_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRelationshipMatrixCellEditorConfiguration_relationshipOwnerStrategy_feature", "_UI_GenericRelationshipMatrixCellEditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_STRATEGY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER);
			childrenFeatures.add(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER);
			childrenFeatures.add(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns GenericRelationshipMatrixCellEditorConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GenericRelationshipMatrixCellEditorConfiguration")); //$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GenericRelationshipMatrixCellEditorConfiguration)object).getCellEditorId();
		return label == null || label.length() == 0 ?
			getString("_UI_GenericRelationshipMatrixCellEditorConfiguration_type") : //$NON-NLS-1$
			getString("_UI_GenericRelationshipMatrixCellEditorConfiguration_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(GenericRelationshipMatrixCellEditorConfiguration.class)) {
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_EDITOR_ID:
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__DIRECTION:
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_STRATEGY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER:
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER:
			case NattablecelleditorPackage.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER,
				 BooleanExpressionsFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER,
				 BooleanExpressionsFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER,
				 BooleanExpressionsFactory.eINSTANCE.createNotExpression()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER,
				 BooleanExpressionsFactory.eINSTANCE.createLiteralTrueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER,
				 BooleanExpressionsFactory.eINSTANCE.createLiteralFalseExpression()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER,
				 BooleanExpressionsFactory.eINSTANCE.createReferenceBooleanExpression()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__CELL_CONTENTS_FILTER,
				 BooleanExpressionsFactory.eINSTANCE.createSingleEAttributeValueEqualityExpression()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER,
				 NattablewrapperFactory.eINSTANCE.createEObjectWrapper()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER,
				 NattablewrapperFactory.eINSTANCE.createIdWrapper()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createIdTreeItemAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createEObjectAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createEObjectTreeItemAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createFeatureIdAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createFeatureIdTreeItemAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createEStructuralFeatureAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createEOperationAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createEStructuralFeatureTreeItemAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createEOperationTreeItemAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createObjectIdAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createObjectIdTreeItemAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createAxisGroup()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createOperationIdAxis()));

		newChildDescriptors.add
			(createChildParameter
				(NattablecelleditorPackage.Literals.GENERIC_RELATIONSHIP_MATRIX_CELL_EDITOR_CONFIGURATION__RELATIONSHIP_OWNER_FEATURE,
				 NattableaxisFactory.eINSTANCE.createOperationIdTreeItemAxis()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ((IChildCreationExtender)adapterFactory).getResourceLocator();
	}
}
