/*****************************************************************************
 * Copyright (c) 2009, 2015 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus - bug 464647
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.tests.createFromPalette;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Element;

public abstract class AbstractCreateLinkOwnedBySourceFromPaletteTest extends AbstractCreateLinkFromPaletteTest {


	/**
	 * Test to create a link.
	 *
	 * @param linkType
	 *            the type
	 */
	@Override
	public void testToCreateALink(IElementType linkType, String initialName) {
		assertEquals(CREATION + INITIALIZATION_TEST, 4, getContainerEditPart().getChildren().size());
		assertEquals(CREATION + INITIALIZATION_TEST, 4, getContainerSemanticModel().getOwnedElements().size());
		assertEquals(CREATION + INITIALIZATION_TEST, 0, ((Element) source.resolveSemanticElement()).getOwnedElements().size());
		Command command = target.getCommand(createConnectionViewRequest(linkType, source, target));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertEquals(CREATION + TEST_THE_EXECUTION, 1, ((Diagram) getRootView()).getEdges().size());
		assertEquals(CREATION + TEST_THE_EXECUTION, 4, getContainerSemanticModel().getOwnedElements().size());
		assertEquals(CREATION + TEST_THE_EXECUTION, 1, ((Element) source.resolveSemanticElement()).getOwnedElements().size());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
		assertEquals(CREATION + TEST_THE_UNDO, 4, getContainerEditPart().getChildren().size());
		assertEquals(CREATION + TEST_THE_UNDO, 4, getContainerSemanticModel().getOwnedElements().size());
		assertEquals(CREATION + TEST_THE_UNDO, 0, ((Element) source.resolveSemanticElement()).getOwnedElements().size());
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
		assertEquals(CREATION + TEST_THE_REDO, 1, ((Diagram) getRootView()).getEdges().size());
		assertEquals(CREATION + TEST_THE_REDO, 4, getContainerSemanticModel().getOwnedElements().size());
		assertEquals(CREATION + TEST_THE_REDO, 1, ((Element) source.resolveSemanticElement()).getOwnedElements().size());
	}

	@Override
	public void installEnvironment(IElementType sourceType, IElementType targetType) {
		assertTrue(CREATION + INITIALIZATION_TEST, getContainerEditPart().getChildren().size() == 0);
		// assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 0);
		// create the source
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(sourceType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(100, 100));
		Command command = getContainerEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true); //$NON-NLS-1$
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		// create the source player to test reconnect
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(sourceType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(100, 300));
		command = getContainerEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true); //$NON-NLS-1$
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		// create the target
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(targetType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(300, 100));
		command = getContainerEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true); //$NON-NLS-1$
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		// create the target player to test reconnect
		requestcreation = CreateViewRequestFactory.getCreateShapeRequest(targetType, getDiagramEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(new Point(300, 300));
		command = getContainerEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true); //$NON-NLS-1$
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		source = (GraphicalEditPart) getContainerEditPart().getChildren().get(0);
		sourcePlayer = (GraphicalEditPart) getContainerEditPart().getChildren().get(1);
		target = (GraphicalEditPart) getContainerEditPart().getChildren().get(2);
		targetPlayer = (GraphicalEditPart) getContainerEditPart().getChildren().get(3);
	}


	/**
	 * test the drop of a link where the source and the target are the same objects
	 *
	 * @param linkType
	 * @param allowed
	 */
	@Override
	protected void testToDropAlinkOnTheSame(IElementType linkType, boolean allowed) {
		// DROP
		if (allowed) {
			assertTrue(DROP + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
			assertTrue(DROP + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 4);
			assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram) getRootView()).getEdges().size() == 2);
			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			ArrayList<Element> list = new ArrayList<Element>();
			list.add(((Element) source.resolveSemanticElement()).getOwnedElements().get(1));
			dropObjectsRequest.setObjects(list);
			dropObjectsRequest.setLocation(new Point(20, 20));
			Command command = getDiagramEditPart().getCommand(dropObjectsRequest);
			assertNotNull(DROP + COMMAND_NULL, command);
			assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(DROP + TEST_THE_EXECUTION, getDiagramEditPart().getChildren().size() == 4);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootSemanticModel().getOwnedElements().size() == 4);
			assertTrue(DROP + TEST_THE_EXECUTION, ((Diagram) getRootView()).getEdges().size() == 3);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
			assertTrue(DROP + TEST_THE_UNDO, getDiagramEditPart().getChildren().size() == 4);
			assertTrue(DROP + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 4);
			assertTrue(DROP + TEST_THE_UNDO, ((Diagram) getRootView()).getEdges().size() == 2);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
			assertTrue(DROP + TEST_THE_REDO, getDiagramEditPart().getChildren().size() == 4);
			assertTrue(DROP + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 4);
			assertTrue(DROP + TEST_THE_REDO, ((Diagram) getRootView()).getEdges().size() == 3);
		}
	}

	/**
	 * test the creation of a link where the source and the target are the same objects
	 *
	 * @param linkType
	 * @param allowed
	 */
	@Override
	protected void testToCreateAlinkOnTheSame(IElementType linkType, boolean allowed) {
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 4);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 4);
		// Note: Must always ask the target edit-part to create the connection, and in this case the target is 'source'
		Command command = source.getCommand(createConnectionViewRequest(linkType, source, source));
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CONTAINER_CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == allowed);
		if (allowed) {
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(CREATION + INITIALIZATION_TEST, ((Diagram) getRootView()).getEdges().size() == 2);
			assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 4);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().undo();
			assertTrue(CREATION + TEST_THE_UNDO, getRootView().getChildren().size() == 4);
			assertTrue(CREATION + TEST_THE_UNDO, getRootSemanticModel().getOwnedElements().size() == 4);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().redo();
			assertTrue(CREATION + TEST_THE_REDO, ((Diagram) getRootView()).getEdges().size() == 2);
			assertTrue(CREATION + TEST_THE_REDO, getRootSemanticModel().getOwnedElements().size() == 4);
		}
	}
}
