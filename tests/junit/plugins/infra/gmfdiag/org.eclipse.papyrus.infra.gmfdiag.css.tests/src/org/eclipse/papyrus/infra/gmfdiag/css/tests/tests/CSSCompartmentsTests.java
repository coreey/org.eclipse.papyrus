/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 422257
 *  Celine Janssens (ALL4TEC) - Update tests due to CSS engine modification (Bug 491334)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.tests.tests;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.StringListValueStyle;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.ResetStyleHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.tests.Activator;
import org.eclipse.papyrus.junit.framework.classification.NotImplemented;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPart;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test case for Compartment-related styles and properties
 * See resources/model/compartmentsTest/model.di for details
 *
 * @author Camille Letavernier
 *
 */
public class CSSCompartmentsTests extends AbstractPapyrusTest {

	public static final String CLASS_ATTRIBUTE_COMPARTMENT_TYPE = ClassAttributeCompartmentEditPart.VISUAL_ID; //$NON-NLS-1$

	public static final String CLASS_OPERATION_COMPARTMENT_TYPE = ClassOperationCompartmentEditPart.VISUAL_ID; //$NON-NLS-1$

	public static final String CLASS_CLASSIFIER_COMPARTMENT_TYPE = ClassNestedClassifierCompartmentEditPart.VISUAL_ID; //$NON-NLS-1$

	public static final String INTERFACE_ATTRIBUTE_COMPARTMENT_TYPE = InterfaceAttributeCompartmentEditPart.VISUAL_ID; //$NON-NLS-1$

	public static final String INTERFACE_OPERATION_COMPARTMENT_TYPE = InterfaceOperationCompartmentEditPart.VISUAL_ID; //$NON-NLS-1$

	public static final String INTERFACE_INTERFACEIFIER_COMPARTMENT_TYPE = InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID; //$NON-NLS-1$

	public static final String ENUMERATION_LITERAL_COMPARTMENT_TYPE = EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID; //$NON-NLS-1$

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	private CSSDiagram diagram;

	@Before
	public void init() {
		ResourceSet resourceSet = houseKeeper.createResourceSet();
		CSSHelper.installCSSSupport(resourceSet);

		URI uri = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model/compartmentsTest/model.notation", true); //$NON-NLS-1$
		try {
			Diagram diagram = (Diagram)EMFHelper.loadEMFModel(resourceSet, uri);
			Assert.assertNotNull("Cannot find the model", diagram);
			Assert.assertTrue("CSS are not activated on this resource", diagram instanceof CSSDiagram);
			this.diagram = (CSSDiagram)diagram;
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	/* Test Class1 and Class2 */
	@Test
	public void testAttributeCompartment() {
		Shape class1 = findShape("Class1");
		Shape class2 = findShape("Class2");

		BasicCompartment attributes1 = findCompartment(class1, CLASS_ATTRIBUTE_COMPARTMENT_TYPE);
		Assert.assertTrue("Attribute compartment should be collapsed, as it contains a P1 property", attributes1.isCollapsed());
		Assert.assertTrue("Attribute compartment should be visible", attributes1.isVisible());
		BasicCompartment operations1 = findCompartment(class1, CLASS_OPERATION_COMPARTMENT_TYPE);
		Assert.assertTrue("Operation compartment should be visible", operations1.isVisible());
		BasicCompartment classifiers1 = findCompartment(class1, CLASS_CLASSIFIER_COMPARTMENT_TYPE);
		Assert.assertFalse("Classifiers compartment should be hidden", classifiers1.isVisible());

		BasicCompartment attributes2 = findCompartment(class2, CLASS_ATTRIBUTE_COMPARTMENT_TYPE);
		Assert.assertFalse("Attribute compartment should not be collapsed, as it doesn't contain a P1 property", attributes2.isCollapsed());
		Assert.assertTrue("Attribute compartment should be visible", attributes2.isVisible());
		BasicCompartment operations2 = findCompartment(class2, CLASS_OPERATION_COMPARTMENT_TYPE);
		Assert.assertTrue("Operation compartment should be visible", operations2.isVisible());
		BasicCompartment classifiers2 = findCompartment(class2, CLASS_CLASSIFIER_COMPARTMENT_TYPE);
		Assert.assertFalse("Classifiers compartment should be hidden", classifiers2.isVisible());


	}

	/* Test Enumeration1 */
	@NotImplemented("The 'case insensitive' attributes are not supported by Eclipse E4 CSS")
	@Test
	public void testCaseInsensitiveForEnumeration() {
		Shape enumeration = findShape("Enumeration1");
		BasicCompartment compartment = findCompartment(enumeration, ENUMERATION_LITERAL_COMPARTMENT_TYPE);

		Assert.assertFalse("EnumerationLiteral Compartment should not be collapsed", compartment.isCollapsed());
	}

	/* Test Interface 1 and Interface 2 */
	@Test
	public void testAttributeCompartmentForInterface() {
		Shape interface1 = findShape("Interface1");
		Shape interface2 = findShape("Interface2");

		BasicCompartment attributes1 = findCompartment(interface1, INTERFACE_ATTRIBUTE_COMPARTMENT_TYPE);
		Assert.assertTrue("Attribute compartment should be visible, as it contains a Property", attributes1.isVisible());
		BasicCompartment operations1 = findCompartment(interface1, INTERFACE_OPERATION_COMPARTMENT_TYPE);
		Assert.assertTrue("Operation compartment should be visible", operations1.isVisible());
		BasicCompartment classifiers1 = findCompartment(interface1, INTERFACE_INTERFACEIFIER_COMPARTMENT_TYPE);
		Assert.assertFalse("Classifiers compartment should be hidden", classifiers1.isVisible());

		BasicCompartment attributes2 = findCompartment(interface2, INTERFACE_ATTRIBUTE_COMPARTMENT_TYPE);
		Assert.assertTrue("Attribute compartment should be visible by default, as it doesn't contain any property", attributes2.isVisible());
		BasicCompartment operations2 = findCompartment(interface2, INTERFACE_OPERATION_COMPARTMENT_TYPE);
		Assert.assertTrue("Operation compartment should be visible", operations2.isVisible());
		BasicCompartment classifiers2 = findCompartment(interface2, INTERFACE_INTERFACEIFIER_COMPARTMENT_TYPE);
		Assert.assertFalse("Classifiers compartment should be hidden", classifiers2.isVisible());
	}

	/* Test Class 3 */
	@Test
	public void testCompartmentForceValue() {
		//Test initial situation
		Shape class3 = findShape("Class3");

		//Check all compartments
		for(View childNode : (List<View>)class3.getChildren()) {
			if(childNode instanceof BasicCompartment) {
				Assert.assertFalse("All compartments from Class3 should be hidden. " + childNode.getType() + " is visible", childNode.isVisible());
			}
		}

		//We need an editingDomain for the ResetStyle operation
		createAndAttachEditingDomain(diagram);

		//Test resetStyle
		ResetStyleHelper.resetStyle(Collections.singleton(class3));

		//Check only some specific compartments. Some style rules still hide the nestedClassifier compartment. The visibility of e.g. the ShapeCompartment is undetermined.
		BasicCompartment attributesCompartment = findCompartment(class3, CLASS_ATTRIBUTE_COMPARTMENT_TYPE);
		BasicCompartment operationsCompartment = findCompartment(class3, CLASS_OPERATION_COMPARTMENT_TYPE);

		Assert.assertTrue("Attributes compartment should be visible after the reset style", attributesCompartment.isVisible());
		Assert.assertTrue("Operations compartment should be visible after the reset style", operationsCompartment.isVisible());
	}

	/* Test apply style */
	@Test
	//Currently fails. showTitle is not properly supported for BasicCompartments
	//Unlike Compartment, BasicCompartment doesn't implement TitleStyle. Instead,
	//it owns a specific instance of TitleStyle, which is not supported by the CSS Engine (?)
	public void testShowAllCompartmentsTitles() {
		//Initial state: title should be hidden
		for(View childNode : (List<View>)diagram.getChildren()) {
			for(View compartment : (List<View>)childNode.getChildren()) {
				if(compartment instanceof BasicCompartment) {
					TitleStyle titleStyle = (TitleStyle)compartment.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
					Assert.assertFalse("Title should be hidden for " + childNode + ", " + compartment, titleStyle.isShowTitle());
				}
			}
		}

		//Apply style
		StringListValueStyle stylesList = (StringListValueStyle)diagram.getNamedStyle(NotationPackage.eINSTANCE.getStringListValueStyle(), "cssClass");
		if(stylesList == null) {
			stylesList = NotationFactory.eINSTANCE.createStringListValueStyle();
		}
		stylesList.getStringListValue().add("showTitleForAllCompartments");

		//Check that all titles are visible
		for(View childNode : (List<View>)diagram.getChildren()) {
			for(View compartment : (List<View>)childNode.getChildren()) {
				if(compartment instanceof BasicCompartment) {
					TitleStyle titleStyle = (TitleStyle)compartment.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
					Assert.assertTrue("Title should be visible", titleStyle.isShowTitle());
				}
			}
		}

	}

	protected static TransactionalEditingDomain createAndAttachEditingDomain(EObject element) {
		TransactionalEditingDomain domain = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), element.eResource().getResourceSet());
		element.eResource().getResourceSet().eAdapters().add(new AdapterFactoryEditingDomain.EditingDomainProvider(domain));
		return domain;
	}

	@After
	public void dispose() {
		Iterator<Resource> iterator = diagram.eResource().getResourceSet().getResources().iterator();
		while(iterator.hasNext()) {
			iterator.next().unload();
			iterator.remove();
		}
	}

	private BasicCompartment findCompartment(Shape element, String type) {
		for(View childNode : (List<View>)element.getChildren()) {
			if(type.equals(childNode.getType())) {
				return (BasicCompartment)childNode;
			}
		}

		return null;
	}

	private Shape findShape(String elementName) {
		for(Object viewObject : diagram.getChildren()) {
			View view = (View)viewObject;
			if(view instanceof Shape && view.getElement() instanceof NamedElement) {
				NamedElement element = (NamedElement)view.getElement();
				if(elementName.equals(element.getName())) {
					return (Shape)view;
				}
			}
		}

		Assert.fail("Cannot find the view associated to " + elementName);
		return null;
	}

}
