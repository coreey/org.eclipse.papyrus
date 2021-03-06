/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.test.canonical;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.appearance.AbstractAppearanceNodeTest;
import org.junit.Test;

/**
 * The Class TestClassDiagramTopNode.
 */
public class TestAppearanceClassDiagramTopNode extends AbstractAppearanceNodeTest {

	@Override
	public GraphicalEditPart getContainerEditPart() {
		return getDiagramEditPart();
	}
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}
	@Override
	protected String getProjectName() {
		return IClassDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IClassDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageComponent() {
		testAppearance(UMLElementTypes.Component_Shape);
	}

	/**
	 * Test to manage instance specification.
	 */
	@Test
	public void testToManageInstanceSpecification() {
		testAppearance(UMLElementTypes.InstanceSpecification_Shape);
	}

	/**
	 * Test to manage signal.
	 */
	@Test
	public void testToManageSignal() {
		testAppearance(UMLElementTypes.Signal_Shape);
	}

	/**
	 * Test to manage model.
	 */
	@Test
	public void testToManageModel() {
		testAppearance(UMLElementTypes.Model_Shape);
	}

	/**
	 * Test to manage enumeration.
	 */
	@Test
	public void testToManageEnumeration() {
		testAppearance(UMLElementTypes.Enumeration_Shape);
	}

	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testAppearance(UMLElementTypes.Package_Shape);
	}

	/**
	 * Test to manage class.
	 */
	@Test
	public void testToManageClass() {
		testAppearance(UMLElementTypes.Class_Shape);
	}

	/**
	 * Test to manage primitive type.
	 */
	@Test
	public void testToManagePrimitiveType() {
		testAppearance(UMLElementTypes.PrimitiveType_Shape);
	}

	/**
	 * Test to manage data type.
	 */
	@Test
	public void testToManageDataType() {
		testAppearance(UMLElementTypes.DataType_Shape);
	}

	/**
	 * Test to manage constraint.
	 */
	@Test
	public void testToManageConstraint() {
		testAppearance(UMLElementTypes.Constraint_PackagedElementShape);
	}

	/**
	 * Test to manage comment.
	 */
	@Test
	public void testToManageComment() {
		testAppearance(UMLElementTypes.Comment_Shape);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageInformationItem() {
		testAppearance(UMLElementTypes.InformationItem_Shape);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageInterface() {
		testAppearance(UMLElementTypes.Interface_Shape);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageTimeObservation() {
		testAppearance(UMLElementTypes.TimeObservation_Shape);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageDurationObservation() {
		testAppearance(UMLElementTypes.DurationObservation_Shape);
	}


}
