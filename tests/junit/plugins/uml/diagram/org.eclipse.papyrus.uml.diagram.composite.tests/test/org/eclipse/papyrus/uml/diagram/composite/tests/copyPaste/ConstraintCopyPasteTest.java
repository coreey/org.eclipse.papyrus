/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.composite.tests.copyPaste;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.junit.utils.DiagramUtils;
import org.eclipse.papyrus.junit.utils.HandlerUtils;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.junit.utils.rules.ShowView;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts.CustomConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ClassCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;


@PluginResource("model/copyPaste/ConstraintPasteStrategy.di")
@ShowView(value = "org.eclipse.papyrus.views.modelexplorer.modelexplorer")
public class ConstraintCopyPasteTest {

	@Rule
	public final PapyrusEditorFixture editorFixture = new PapyrusEditorFixture();

	public static final String COPY_COMMAND_ID = "org.eclipse.ui.edit.copy"; //$NON-NLS-1$

	public static final String PASTE_COMMAND_ID = "org.eclipse.ui.edit.paste"; //$NON-NLS-1$

	public static final String CLASS1_NAME = "Class1"; //$NON-NLS-1$

	public static final String CLASS2_NAME = "Class2"; //$NON-NLS-1$

	public static final String CONSTRAINT_NAME = "Constraint1"; //$NON-NLS-1$

	public static final String DIAGRAM_NAME = "ConstraintCompositeStructureDiagram"; //$NON-NLS-1$

	@Test
	public void testCopyConstraintFromClassToClass() throws Exception {

		// get all semantic element that will handled
		Model model = (Model) editorFixture.getModel();
		Assert.assertNotNull("RootModel is null", model);

		org.eclipse.uml2.uml.Class class1 = (org.eclipse.uml2.uml.Class) model.getPackagedElement(CLASS1_NAME);
		org.eclipse.uml2.uml.Class class2 = (org.eclipse.uml2.uml.Class) model.getPackagedElement(CLASS2_NAME);
		org.eclipse.uml2.uml.Constraint constraint = (org.eclipse.uml2.uml.Constraint) class1.getMember(CONSTRAINT_NAME);

		Assert.assertNotNull("Constraint is missing in the model", constraint);

		Diagram mainDiagram = DiagramUtils.getNotationDiagram(editorFixture.getModelSet(), DIAGRAM_NAME);
		editorFixture.getPageManager().openPage(mainDiagram);
		Assert.assertEquals("current opened diagram is not the expected one", mainDiagram.getName(), DIAGRAM_NAME);

		View class1View = DiagramUtils.findShape(mainDiagram, CLASS1_NAME);
		View class1CompartmentView = findChildView(class1View, ClassCompositeCompartmentEditPart.VISUAL_ID);
		Shape constraintView = DiagramUtils.findShape(class1CompartmentView, CONSTRAINT_NAME);
		Assert.assertNotNull("Constraint view not present", constraintView);

		Object defaultSelection = getSelectionLikeTestOnModelExplorer();
		Object defaultSelectionHandler = getSelectionLikeInAbstractGraphicalHandler();

		editorFixture.flushDisplayEvents();
		Assert.assertNotNull("Constraint TreeElement is null", defaultSelection); //$NON-NLS-1$		
		Assert.assertEquals("TreeElement is not a model", CompositeStructureDiagramEditPart.class, defaultSelection.getClass());
		Assert.assertEquals("TreeElement is not a model", CompositeStructureDiagramEditPart.class, defaultSelectionHandler.getClass());

		EditPart constraintEP = editorFixture.findEditPart(constraint);
		editorFixture.select(constraintEP);

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelectionService selectionService = activeWorkbenchWindow.getSelectionService();
		Object constraintSelection = ((IStructuredSelection) selectionService.getSelection()).toList().get(0);

		// it's working on service selection
		Assert.assertEquals("TreeElement is not a constraint", CustomConstraintEditPartCN.class, constraintSelection.getClass());

		ISelection selection = editorFixture.getEditor().getEditorSite().getSelectionProvider().getSelection();
		Object editorConstraintSelection = ((IStructuredSelection) selection).toList().get(0);

		// it's working on editor selection
		Assert.assertEquals("TreeElement is not a constraint", CustomConstraintEditPartCN.class, editorConstraintSelection.getClass());

		editorFixture.flushDisplayEvents();
		Object defaultConstraintFromLinkHelperSelection = getSelectionLikeInAbstractGraphicalHandler(0);
		Assert.assertEquals("TreeElement is not a constraint", CustomConstraintEditPartCN.class, defaultConstraintFromLinkHelperSelection.getClass());

		// Copy
		IHandler copyHandler = HandlerUtils.getActiveHandlerFor(COPY_COMMAND_ID);
		Assert.assertTrue("Copy not available", copyHandler.isEnabled()); //$NON-NLS-1$
		copyHandler.execute(new ExecutionEvent());

		// Select diagram
		EditPart class2EP = editorFixture.findEditPart(class2);
		IGraphicalEditPart classCompartmentEditPart = ((IGraphicalEditPart)class2EP).getChildBySemanticHint(ClassCompositeCompartmentEditPart.VISUAL_ID);
		editorFixture.deselect(constraintEP);
		editorFixture.select(classCompartmentEditPart);
		editorFixture.getPageManager().selectPage(mainDiagram);

		editorFixture.flushDisplayEvents();

		int class1AmountRulesBeforeCopy = class1.getOwnedRules().size();
		int class2AmountRulesBeforeCopy = class2.getOwnedRules().size();

		// Paste
		IHandler pasteHandler = HandlerUtils.getActiveHandlerFor(PASTE_COMMAND_ID);
		Assert.assertTrue("Paste not available", pasteHandler.isEnabled()); //$NON-NLS-1$
		pasteHandler.execute(new ExecutionEvent());

		editorFixture.flushDisplayEvents();

		// Check that there is a copy of Constraint
		Assert.assertEquals("The copy failed", class1AmountRulesBeforeCopy, class1.getOwnedRules().size()); //$NON-NLS-1$
		Assert.assertEquals("The copy failed", class2AmountRulesBeforeCopy + 1, class2.getOwnedRules().size());
	}

	private Object getSelectionLikeInAbstractGraphicalHandler() {
		return getSelectionLikeInAbstractGraphicalHandler(0);
	}

	private Object getSelectionLikeInAbstractGraphicalHandler(int numberOfSelectedEl) {
		IEvaluationService evaluationService = PlatformUI.getWorkbench().getService(IEvaluationService.class);
		IEvaluationContext currentState = evaluationService.getCurrentState();
		Object defaultVariable = currentState.getDefaultVariable();
		if (defaultVariable instanceof List) {
			List arrayList = (List) defaultVariable;
			if (!arrayList.isEmpty()) {
				return arrayList.get(numberOfSelectedEl);
			}
		}
		return defaultVariable;
	}

	private Object getSelectionLikeTestOnModelExplorer() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelectionService selectionService = activeWorkbenchWindow.getSelectionService();
		return ((IStructuredSelection) selectionService.getSelection()).getFirstElement();
	}

	private View findChildView(View baseView, String compartmentID) {
		String type = compartmentID;
		for (Object childObject: baseView.getChildren()) {
			View child = (View)childObject; 
			if (child.getType().equals(type)) {
				return child;
			}
		}
		return null;
	}
}
