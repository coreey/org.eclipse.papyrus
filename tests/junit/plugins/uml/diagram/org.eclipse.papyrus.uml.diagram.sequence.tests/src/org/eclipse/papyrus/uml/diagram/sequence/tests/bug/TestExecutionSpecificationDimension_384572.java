/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;

/**
 * Cannot reduce dimensions of Behavior Execution Specification box. The minimal height is 20.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=384572
 *
 */
public class TestExecutionSpecificationDimension_384572 extends TestTopNode {

	private static final String RESIZE = "Resize: ";

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	@FailingTest ("To be erased or rewritten to take new architecture into account")
	@Test
	public void testResizeActionExecutionNorth() {
		resizeNorth(UMLElementTypes.ActionExecutionSpecification_Shape);
	}
	
	@FailingTest ("To be erased or rewritten to take new architecture into account")
	@Test
	public void testResizeBehaviorExecutionNorth() {
		resizeNorth(UMLElementTypes.BehaviorExecutionSpecification_Shape);
	}

	@FailingTest ("To be erased or rewritten to take new architecture into account")
	@Test
	public void testResizeActionExecutionSouth() {
		resizeSouth(UMLElementTypes.ActionExecutionSpecification_Shape);
	}

	@FailingTest ("To be erased or rewritten to take new architecture into account")
	@Test
	public void testResizeBehaviorExecutionSouth() {
		resizeSouth(UMLElementTypes.BehaviorExecutionSpecification_Shape);
	}

	protected void resizeNorth(IElementType elementType) {
		createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart) getRootEditPart().getChildren().get(0);
		waitForComplete();

		createNode(elementType, lifeline1, new Point(131, 200), new Dimension(20, 60));
		waitForComplete();

		IGraphicalEditPart esp = (IGraphicalEditPart) lifeline1.getChildren().get(1);
		resize(esp, getAbsoluteBounds(esp).getTop(), PositionConstants.NORTH, new Dimension(0, 30));
		resize(esp, getAbsoluteBounds(esp).getTop(), PositionConstants.NORTH, new Dimension(0, -30));
		resize(esp, getAbsoluteBounds(esp).getTop(), PositionConstants.NORTH, new Dimension(0, -20));
	}

	protected void resizeSouth(IElementType elementType) {
		createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart) getRootEditPart().getChildren().get(0);
		waitForComplete();

		createNode(elementType, lifeline1, new Point(131, 200), new Dimension(20, 40));
		waitForComplete();

		IGraphicalEditPart esp = (IGraphicalEditPart) lifeline1.getChildren().get(1);
		resize(esp, getAbsoluteBounds(esp).getBottom(), PositionConstants.SOUTH, new Dimension(0, 30));
		resize(esp, getAbsoluteBounds(esp).getBottom(), PositionConstants.SOUTH, new Dimension(0, -30));

		resize(esp, getAbsoluteBounds(esp).getBottom(), PositionConstants.SOUTH, new Dimension(0, -20));
	}

	private void resize(IGraphicalEditPart op, Point p, int resizeDir, Dimension deltaSize) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(resizeDir);
		req.setSizeDelta(deltaSize);
		if (resizeDir == PositionConstants.NORTH || resizeDir == PositionConstants.WEST) {
			req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));
		}

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	private void manageResizeCommnad(IGraphicalEditPart op, Dimension deltaSize, Command c) {
		assertNotNull(RESIZE + COMMAND_NULL, c);
		assertTrue(RESIZE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, c.canExecute());
		Rectangle before = getAbsoluteBounds(op);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(op);
		Dimension expected = getExpectedSize(op, before, deltaSize);
		assertEquals(RESIZE + TEST_THE_EXECUTION, expected.width() - before.width(), after.width() - before.width());
		assertEquals(RESIZE + TEST_THE_EXECUTION, expected.height() - before.height(), after.height() - before.height());

		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(op)));

		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_REDO, after.equals(getAbsoluteBounds(op)));
	}

	private Dimension getExpectedSize(IGraphicalEditPart op, Rectangle before, Dimension deltaSize) {
		int expectedHeight = before.height() + deltaSize.height();
		int expectedWidth = before.width() + deltaSize.width();
		Dimension minSize = op.getFigure().getMinimumSize();
		Dimension maxSize = op.getFigure().getMaximumSize();
		expectedHeight = expectedHeight > maxSize.height() ? maxSize.height() : expectedHeight;
		expectedHeight = expectedHeight < minSize.height() ? minSize.height() : expectedHeight;
		expectedWidth = expectedWidth > maxSize.width() ? maxSize.width() : expectedWidth;
		expectedWidth = expectedWidth < minSize.width() ? minSize.width() : expectedWidth;
		return new Dimension(expectedWidth, expectedHeight);
	}

	public void createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		// CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parentPart.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}
}
