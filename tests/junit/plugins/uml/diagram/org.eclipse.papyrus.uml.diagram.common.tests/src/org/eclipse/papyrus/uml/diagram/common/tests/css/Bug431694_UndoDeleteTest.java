/*****************************************************************************
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
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.tests.css;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;
import org.eclipse.papyrus.junit.utils.DiagramUtils;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Package;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * Test for bug 431694: [All diagrams] Problem with Surfboard display after Delete -> Undo
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=431694
 */
public class Bug431694_UndoDeleteTest extends AbstractEditorTest {

	private static final String PACKAGE1 = "Package1";

	private static final String CLASS_NAMED_STYLE_FONT = "ClassNamedStyleFont";

	private static final String DIAGRAM_MAIN_NAME = "Main";

	private static final String PROJECT_NAME = "431694_UndoDeleteTest";

	public static final String SOURCE_PATH = "resources/431694/";

	protected boolean operationFailed = false;


	@Before
	public void prepareTest() throws Exception {
		initModel(PROJECT_NAME, "model", getBundle());
	}

	/**
	 * Test with a {@link Package} with a css style already applied
	 */
	@Test
	public void testDeleteOnPackageWithStyle() throws Exception {
		// check css on the package P1
		// get Package 1 view on the open diagram
		// get the rootModel
		Assert.assertNotNull("RootModel is null", getRootUMLModel());

		Diagram mainDiagram = DiagramUtils.getNotationDiagram(getModelSet(), DIAGRAM_MAIN_NAME);
		getPageManager().openPage(mainDiagram);
		Assert.assertEquals("current opened diagram is not the expected one", mainDiagram.getName(), DIAGRAM_MAIN_NAME);

		// check css is working
		Assert.assertTrue("CSS is not supported on the given model", CSSHelper.isCSSSupported(getModelSet()));
		Shape package1View = DiagramUtils.findShape(mainDiagram, PACKAGE1);
		if(package1View == null) {
			return;
		}
		checkPackage1CSS(package1View);

		// delete P1
		// get edit part for this view and send a delete request
		IGraphicalEditPart packageEditPart = DiagramUtils.findEditPartforView(editor, package1View, IGraphicalEditPart.class);
		Assert.assertNotNull("Impossible to find package edit part", packageEditPart);
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = packageEditPart.getCommand(deleteViewRequest);
		assertNotNull("Impossible to create a delete command", command);
		Assert.assertNotEquals("This should not be an unexecutable command", command, UnexecutableCommand.INSTANCE);
		assertTrue("command should be executable", command.canExecute());
		execute(command);
		Assert.assertNull("There should be no shape for this element: " + PACKAGE1, DiagramUtils.findShape(mainDiagram, PACKAGE1));

		// undo
		undo();

		// check css on P1
		Shape newPackage1View = DiagramUtils.findShape(mainDiagram, PACKAGE1);
		Assert.assertNotNull("There should be a shape for this element: " + PACKAGE1, newPackage1View);
		checkPackage1CSS(newPackage1View);

	}

	/**
	 * Test with a {@link Package} with a css style already applied
	 */
	@Test
	public void testDeleteOnClassNamedStyleFont() throws Exception {
		// check css on the class ClassNamedStyleFont
		Assert.assertNotNull("RootModel is null", getRootUMLModel());

		Diagram mainDiagram = DiagramUtils.getNotationDiagram(getModelSet(), DIAGRAM_MAIN_NAME);
		getPageManager().openPage(mainDiagram);
		Assert.assertEquals("current opened diagram is not the expected one", mainDiagram.getName(), DIAGRAM_MAIN_NAME);

		// check css is working
		Assert.assertTrue("CSS is not supported on the given model", CSSHelper.isCSSSupported(getModelSet()));
		Shape ClassNamedStyleFontView = DiagramUtils.findShape(mainDiagram, CLASS_NAMED_STYLE_FONT);
		if(ClassNamedStyleFontView == null) {
			return;
		}
		checkClassNamedStyleFontCSS(ClassNamedStyleFontView);

		// delete ClassNamedStyleFont
		// get edit part for this view and send a delete request
		IGraphicalEditPart ClassNamedStyleFontEditPart = DiagramUtils.findEditPartforView(editor, ClassNamedStyleFontView, IGraphicalEditPart.class);
		Assert.assertNotNull("Impossible to find the edit part", ClassNamedStyleFontEditPart);
		Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		Command command = ClassNamedStyleFontEditPart.getCommand(deleteViewRequest);
		assertNotNull("Impossible to create a delete command", command);
		Assert.assertNotEquals("This should not be an unexecutable command", command, UnexecutableCommand.INSTANCE);
		assertTrue("command should be executable", command.canExecute());
		execute(command);
		Assert.assertNull("There should be no shape for this element: " + CLASS_NAMED_STYLE_FONT, DiagramUtils.findShape(mainDiagram, CLASS_NAMED_STYLE_FONT));

		// undo
		undo();

		// check css on the new view for ClassNamedStyleFont
		Shape newClassNamedStyleFontView = DiagramUtils.findShape(mainDiagram, CLASS_NAMED_STYLE_FONT);
		Assert.assertNotNull("There should be a shape for this element: " + CLASS_NAMED_STYLE_FONT, newClassNamedStyleFontView);
		checkClassNamedStyleFontCSS(newClassNamedStyleFontView);

	}

	private void checkClassNamedStyleFontCSS(Shape classNamedStyleFontView) {
		// default style: papyrus theme
		Assert.assertEquals("Invalid Fill color (Default): " + DiagramUtils.integerToRGBString(classNamedStyleFontView.getFillColor()), DiagramUtils.rgb(195, 215, 221), classNamedStyleFontView.getFillColor()); // Papyrus Theme =
		Assert.assertEquals("Gradient should be default (vertical)", classNamedStyleFontView.getGradient().getGradientStyle(), GradientStyle.VERTICAL); // Papyrus Theme =
		Assert.assertEquals("Invalid Gradient Color (Default)", DiagramUtils.rgb(255, 255, 255), classNamedStyleFontView.getGradient().getGradientColor1()); // Papyrus Theme =

		// named style: font color is white
		Assert.assertEquals("Invalid Font Color", DiagramUtils.rgb(255, 255, 255), classNamedStyleFontView.getFontColor()); // White font by the named style
	}

	protected void checkPackage1CSS(Shape packageShape) {
		// named style: fill red and horizontal green gradient
		Assert.assertEquals("Invalid Fill color", DiagramUtils.rgb(255, 0, 0), packageShape.getFillColor()); //Red = #FF0000
		Assert.assertEquals("Gradient should be horizontal", packageShape.getGradient().getGradientStyle(), GradientStyle.HORIZONTAL);
		Assert.assertEquals("Invalid Gradient Color", DiagramUtils.rgb(0, 255, 0), packageShape.getGradient().getGradientColor1()); // GREEN

		// unnamed style: font color is blue
		Assert.assertEquals("Invalid gradient", DiagramUtils.rgb(0, 0, 255), packageShape.getFontColor()); // Blue font by the named style
	}


	@Override
	protected String getSourcePath() {
		return SOURCE_PATH;
	}

	@Override
	protected Bundle getBundle() {
		return org.eclipse.papyrus.uml.diagram.common.Activator.getDefault().getBundle();
	}

	/**
	 * Call {@link AbstractPapyrusTestCase#execute(Command) execute} on the UI
	 * thread.
	 */
	protected void executeOnUIThread(final Command command) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				execute(command);
			}
		});
	}

	/** Call {@link AbstractPapyrusTestCase#undo() undo} on the UI thread. */
	protected void undoOnUIThread() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				undo();
			}
		});
	}

	/** Call {@link AbstractPapyrusTestCase#redo() redo} on the UI thread. */
	protected void redoOnUIThread() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				redo();
			}
		});
	}

	protected void assertLastOperationSuccessful() {
		Assert.assertFalse("The operation failed. Look at the log, or put a breakpoint on ExecutionException or DefaultOperationHistory#notifyNotOK to find the cause.", this.operationFailed);
	}

	/**
	 * Reset the "operation failed" state. Call this before executing each
	 * operation for which you want to test whether if failed with {@link AbstractPapyrusTestCase#assertLastOperationSuccessful()}.
	 */
	protected void resetLastOperationFailedState() {
		this.operationFailed = false;
	}

	/** Execute the given command in the diagram editor. */
	protected void execute(final Command command) {
		resetLastOperationFailedState();
		getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertLastOperationSuccessful();
	}

	/** Undo the last command done in the diagram editor. */
	protected void undo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		Assert.assertTrue("We should be able to undo", commandStack.canUndo());
		commandStack.undo();
		assertLastOperationSuccessful();
	}

	/** Redo the last command undone in the diagram editor. */
	protected void redo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		Assert.assertTrue("We should be able to redo", commandStack.canRedo());
		commandStack.redo();
		assertLastOperationSuccessful();
	}

	/** The command stack to use to execute commands on the diagram. */
	protected CommandStack getCommandStack() {
		// not "diagramEditor.getDiagramEditDomain().getDiagramCommandStack()"
		// because it messes up undo contexts
		try {
			return getTransactionalEditingDomain().getCommandStack();
		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}
		return null;
	}


}
