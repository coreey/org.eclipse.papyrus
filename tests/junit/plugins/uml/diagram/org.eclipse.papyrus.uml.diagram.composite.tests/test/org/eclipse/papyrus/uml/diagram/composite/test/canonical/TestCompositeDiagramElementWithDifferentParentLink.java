/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.test.canonical;

import static org.junit.Assert.assertTrue;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.infra.gmfdiag.common.updater.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.composite.CreateCompositeDiagramCommand;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.composite.test.ICompositeDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLinkWithParent;
import org.junit.Before;
import org.junit.Test;


/**
 * The Class TestCompositeDiagramElementWithDifferentParentLink.
 */
public class TestCompositeDiagramElementWithDifferentParentLink extends TestLinkWithParent {

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return UMLDiagramUpdater.INSTANCE;
	}

	/** The target parent. */
	private GraphicalEditPart targetParent;

	/**
	 * Gets the diagram command creation.
	 *
	 * @return the diagram command creation
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getDiagramCommandCreation()
	 */

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateCompositeDiagramCommand();
	}

	/**
	 * Gets the project name.
	 *
	 * @return the project name
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getProjectName()
	 */

	@Override
	protected String getProjectName() {
		return ICompositeDiagramTestsConstants.PROJECT_NAME;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getFileName()
	 */

	@Override
	protected String getFileName() {
		return ICompositeDiagramTestsConstants.FILE_NAME;
	}


	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#setUp()
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		parentType = UMLElementTypes.Class_Shape;
	}


	/**
	 * Inits the configuration for a link owned by the parent.
	 */
	protected void initConfLinkOwnedByParent() {
		// expected values before link creation
		beginRootSemanticOwnedElementSize = 2;
		beginDiagramEditPartChildrenSize = 2;
		beginRootEdgeSize = 0;
		beginSourceConnectionsSize = 0;
		beginRootViewChildrenSize = 2;
		// expected values after link creation
		endSourceConnectionsSize = beginSourceConnectionsSize + 1;
		endRootSemanticOwnedElementSize = beginRootSemanticOwnedElementSize + 1;
		endDiagramEditPartChildrenSize = beginDiagramEditPartChildrenSize;
		endRootEdgeSize = beginRootEdgeSize + 1;
		endRootViewChildrenSize = beginRootViewChildrenSize;
	}


	/**
	 * Install environment.
	 *
	 * @param sourceType
	 *            the source type
	 * @param targetType
	 *            the target type
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.TestLinkWithParent#installEnvironment(org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 */

	@Override
	public void installEnvironment(IElementType sourceType, IElementType targetType) {
		super.installEnvironment(sourceType, targetType);

		// create the parent source
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(parentType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(DEFAULT_PARENT_LOCATION);
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertTrue(command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		targetParent = (GraphicalEditPart) getDiagramEditPart().getChildren().get(1);

		// create the target
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(targetType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(DEFAULT_SOURCE_LOCATION);
		command = targetParent.getCommand(requestcreation);
		assertTrue(command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);

		// FIXME : get(0) : header; get(1) : floatingLabel; get(2) : container
		// List<GraphicalEditPart> children = targetParent.getChildren();
		// target = children.get(3);

		target = (GraphicalEditPart) targetParent.getChildBySemanticHint(((IHintedType) targetType).getSemanticHint());
	}

	/**
	 * Test to manage port connector.
	 */
	@Test
	public void testToManagePortConnector() {
		testImpossibleToManageLink(UMLElementTypes.Port_Shape, UMLElementTypes.Port_Shape, UMLElementTypes.Connector_Edge);
	}

	/**
	 * Test to manage port usage.
	 */
	@Test
	public void testToManagePortUsage() {
		initConfLinkOwnedByParent();
		testToManageLink(UMLElementTypes.Port_Shape, UMLElementTypes.Port_Shape, UMLElementTypes.Usage_Edge, UMLElementTypes.Class_Shape, true);
	}

	/**
	 * Test to manage port abstraction.
	 */
	@Test
	public void testToManagePortAbstraction() {
		initConfLinkOwnedByParent();
		testToManageLink(UMLElementTypes.Port_Shape, UMLElementTypes.Port_Shape, UMLElementTypes.Abstraction_Edge, UMLElementTypes.Class_Shape, true);
	}


	/**
	 * Test to manage port generalization.
	 */
	@Test
	public void testToManagePortGeneralization() {
		testImpossibleToManageLink(UMLElementTypes.Port_Shape, UMLElementTypes.Port_Shape, UMLElementTypes.Generalization_Edge);
	}

}
