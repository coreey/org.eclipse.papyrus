/**
 * Copyright (c) 2014 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.component.part;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.structure.DiagramStructure;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentBodyEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConnectorAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConnectorEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConnectorNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintSpecificationEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceFloatingLabelEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceOperationCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.MultiDependencyLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.OperationForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PropertyForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PropertyPartEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PropertyPartNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ReceptionInInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceFloatingLabelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageNameEditPart;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 *
 * @generated
 */
public class UMLVisualIDRegistry {

	// Uncomment for debug purpose ?
	// /**
	// * @generated
	// */
	// private static final String DEBUG_KEY = "org.eclipse.papyrus.uml.diagram.component/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static String getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ComponentDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return ""; //$NON-NLS-1$
			}
		}
		return org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static String getVisualID(String type) {
		return type;
	}

	/**
	 * @generated
	 */
	public static String getType(String visualID) {
		return visualID;
	}

	/**
	 * @generated
	 */
	public static String getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return ""; //$NON-NLS-1$
		}
		return ComponentDiagramEditPart.VISUAL_ID;
	}

	/**
	 * @generated
	 */
	public static String getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return ""; //$NON-NLS-1$
		}
		String containerModelID = org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return ""; //$NON-NLS-1$
		}
		String containerVisualID;
		if (ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return ""; //$NON-NLS-1$
			}
		}
		if (containerVisualID != null) {
			switch (containerVisualID) {
			case ComponentDiagramEditPart.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
					return DependencyNodeEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
					return ComponentEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
					return ModelEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
					return PackageEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return RectangleInterfaceEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
					return CommentEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
					return ConstraintEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getNamedElement().isSuperTypeOf(domainElement.eClass())) {
					return DefaultNamedElementEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return InterfaceEditPart.VISUAL_ID;
				}
				break;
			case ComponentEditPart.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
					return PortEditPart.VISUAL_ID;
				}
				break;
			case ComponentEditPartCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
					return PortEditPart.VISUAL_ID;
				}
				break;
			case ComponentEditPartPCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
					return PortEditPart.VISUAL_ID;
				}
				break;
			case PropertyPartEditPartCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())) {
					return PortEditPart.VISUAL_ID;
				}
				break;
			case ComponentCompositeCompartmentEditPart.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
					return ComponentEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
					return PropertyPartEditPartCN.VISUAL_ID;
				}
				break;
			case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return RectangleInterfaceEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
					return ModelEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
					return PackageEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
					return ComponentEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
					return CommentEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
					return ConstraintEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return InterfaceEditPartPCN.VISUAL_ID;
				}
				break;
			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return RectangleInterfaceEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
					return CommentEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
					return ConstraintEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
					return ComponentEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
					return ModelEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
					return PackageEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return InterfaceEditPartPCN.VISUAL_ID;
				}
				break;
			case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return RectangleInterfaceEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
					return ModelEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
					return PackageEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
					return ComponentEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
					return CommentEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
					return ConstraintEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return InterfaceEditPartPCN.VISUAL_ID;
				}
				break;
			case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return RectangleInterfaceEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass())) {
					return ModelEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
					return PackageEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
					return ComponentEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())) {
					return CommentEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())) {
					return ConstraintEditPartPCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())) {
					return InterfaceEditPartPCN.VISUAL_ID;
				}
				break;
			case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
					return ComponentEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
					return PropertyPartEditPartCN.VISUAL_ID;
				}
				break;
			case ComponentCompositeCompartmentEditPartPCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())) {
					return ComponentEditPartCN.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
					return PropertyPartEditPartCN.VISUAL_ID;
				}
				break;
			case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
					return PropertyForInterfaceEditPart.VISUAL_ID;
				}
				break;
			case InterfaceOperationCompartmentEditPart.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
					return OperationForInterfaceEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
					return ReceptionInInterfaceEditPart.VISUAL_ID;
				}
				break;
			case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())) {
					return PropertyForInterfaceEditPart.VISUAL_ID;
				}
				break;
			case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
				if (UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
					return OperationForInterfaceEditPart.VISUAL_ID;
				}
				if (UMLPackage.eINSTANCE.getReception().isSuperTypeOf(domainElement.eClass())) {
					return ReceptionInInterfaceEditPart.VISUAL_ID;
				}
				break;
			}
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, String nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		String containerVisualID;
		if (ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		if (containerVisualID != null) {
			switch (containerVisualID) {
			case ComponentDiagramEditPart.VISUAL_ID:
				if (DependencyNodeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ModelEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PackageEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (RectangleInterfaceEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (CommentEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ConstraintEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (DefaultNamedElementEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case DependencyNodeEditPart.VISUAL_ID:
				if (MultiDependencyLabelEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (DependencyNodeFloatingLabelEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ComponentEditPart.VISUAL_ID:
				if (ComponentNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentFloatingLabelEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentCompositeCompartmentEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PortEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ModelEditPart.VISUAL_ID:
				if (ModelNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ModelPackageableElementCompartmentEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case PackageEditPart.VISUAL_ID:
				if (PackageNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PackagePackageableElementCompartmentEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case RectangleInterfaceEditPart.VISUAL_ID:
				if (RectangleInterfaceNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (RectangleInterfaceFloatingLabelEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceAttributeCompartmentEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceOperationCompartmentEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case CommentEditPart.VISUAL_ID:
				if (CommentBodyEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ConstraintEditPart.VISUAL_ID:
				if (ConstraintNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ConstraintSpecificationEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case DefaultNamedElementEditPart.VISUAL_ID:
				if (DefaultNamedElementNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case InterfaceEditPart.VISUAL_ID:
				if (InterfaceNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceFloatingLabelEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case PortEditPart.VISUAL_ID:
				if (PortNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PortAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ModelEditPartCN.VISUAL_ID:
				if (ModelNameEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ModelPackageableElementCompartmentEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case PackageEditPartCN.VISUAL_ID:
				if (PackageNameEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PackagePackageableElementCompartmentEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case RectangleInterfaceEditPartCN.VISUAL_ID:
				if (RectangleInterfaceNameEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (RectangleInterfaceFloatingLabelEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceAttributeCompartmentEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceOperationCompartmentEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ComponentEditPartCN.VISUAL_ID:
				if (ComponentNameEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentFloatingLabelEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentCompositeCompartmentEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PortEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ComponentEditPartPCN.VISUAL_ID:
				if (ComponentNameEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentFloatingLabelEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentCompositeCompartmentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PortEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case CommentEditPartPCN.VISUAL_ID:
				if (CommentBodyEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ConstraintEditPartPCN.VISUAL_ID:
				if (ConstraintNameEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ConstraintSpecificationEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case InterfaceEditPartPCN.VISUAL_ID:
				if (InterfaceNameEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceFloatingLabelEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case PropertyPartEditPartCN.VISUAL_ID:
				if (PropertyPartNameEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PortEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ComponentCompositeCompartmentEditPart.VISUAL_ID:
				if (ComponentEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PropertyPartEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
				if (RectangleInterfaceEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ModelEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PackageEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (CommentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ConstraintEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
				if (RectangleInterfaceEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (CommentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ConstraintEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ModelEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PackageEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
				if (RectangleInterfaceEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ModelEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PackageEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (CommentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ConstraintEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
				if (RectangleInterfaceEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ModelEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PackageEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (CommentEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ConstraintEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceEditPartPCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
				if (ComponentEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PropertyPartEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ComponentCompositeCompartmentEditPartPCN.VISUAL_ID:
				if (ComponentEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (PropertyPartEditPartCN.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
				if (PropertyForInterfaceEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case InterfaceOperationCompartmentEditPart.VISUAL_ID:
				if (OperationForInterfaceEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ReceptionInInterfaceEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
				if (PropertyForInterfaceEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
				if (OperationForInterfaceEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ReceptionInInterfaceEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case UsageEditPart.VISUAL_ID:
				if (UsageNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (UsageAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case InterfaceRealizationEditPart.VISUAL_ID:
				if (InterfaceRealizationNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (InterfaceRealizationAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case GeneralizationEditPart.VISUAL_ID:
				if (GeneralizationAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case SubstitutionEditPart.VISUAL_ID:
				if (SubstitutionNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (SubstitutionAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ManifestationEditPart.VISUAL_ID:
				if (ManifestationNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ManifestationAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ComponentRealizationEditPart.VISUAL_ID:
				if (ComponentRealizationNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case AbstractionEditPart.VISUAL_ID:
				if (AbstractionNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (AbstractionAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case DependencyEditPart.VISUAL_ID:
				if (DependencyNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (DependencyAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			case ConnectorEditPart.VISUAL_ID:
				if (ConnectorAppliedStereotypeEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				if (ConnectorNameEditPart.VISUAL_ID.equals(nodeVisualID)) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static String getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return ""; //$NON-NLS-1$
		}
		if (UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(domainElement.eClass())) {
			return UsageEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getInterfaceRealization().isSuperTypeOf(domainElement.eClass())) {
			return InterfaceRealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getSubstitution().isSuperTypeOf(domainElement.eClass())) {
			return SubstitutionEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getManifestation().isSuperTypeOf(domainElement.eClass())) {
			return ManifestationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getComponentRealization().isSuperTypeOf(domainElement.eClass())) {
			return ComponentRealizationEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getAbstraction().isSuperTypeOf(domainElement.eClass())) {
			return AbstractionEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return DependencyEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return DependencyBranchEditPart.VISUAL_ID;
		}
		if (UMLPackage.eINSTANCE.getConnector().isSuperTypeOf(domainElement.eClass())) {
			return ConnectorEditPart.VISUAL_ID;
		}
		return ""; //$NON-NLS-1$
	}

	// Uncomment for debug purpose ?
	// /**
	// * User can change implementation of this method to handle some specific
	// * situations not covered by default logic.
	// *
	// * @generated
	// */
	// private static boolean isDiagram(Package element) {
	// return true;
	// }


	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, String candidate) {
		if (candidate == null) {
			// unrecognized id is always bad
			return false;
		}
		String basic = getNodeVisualID(containerView, domainElement);
		return candidate.equals(basic);
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(String visualID) {
		if (visualID != null) {
			switch (visualID) {
			case ComponentCompositeCompartmentEditPart.VISUAL_ID:
			case ModelPackageableElementCompartmentEditPart.VISUAL_ID:
			case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
			case ComponentCompositeCompartmentEditPartPCN.VISUAL_ID:
			case InterfaceAttributeCompartmentEditPart.VISUAL_ID:
			case InterfaceOperationCompartmentEditPart.VISUAL_ID:
			case InterfaceAttributeCompartmentEditPartCN.VISUAL_ID:
			case InterfaceOperationCompartmentEditPartCN.VISUAL_ID:
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(String visualID) {
		if (visualID != null) {
			switch (visualID) {
			case ComponentDiagramEditPart.VISUAL_ID:
				return false;
			case PropertyForInterfaceEditPart.VISUAL_ID:
			case OperationForInterfaceEditPart.VISUAL_ID:
			case ReceptionInInterfaceEditPart.VISUAL_ID:
			case InterfaceEditPart.VISUAL_ID:
			case PortEditPart.VISUAL_ID:
			case InterfaceEditPartPCN.VISUAL_ID:
			case CommentEditPartPCN.VISUAL_ID:
			case ConstraintEditPartPCN.VISUAL_ID:
			case ConstraintEditPart.VISUAL_ID:
			case CommentEditPart.VISUAL_ID:
			case DependencyNodeEditPart.VISUAL_ID:
			case DefaultNamedElementEditPart.VISUAL_ID:
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public String getVisualID(View view) {
			return org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView, EObject domainElement, String candidate) {
			return org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(String visualID) {
			return org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(String visualID) {
			return org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};
}
