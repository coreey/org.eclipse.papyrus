/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
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
 *  Patrick Tessier (CEA LIST) Patrick.Tessier.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 434133
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.tests;

import java.util.ArrayList;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.papyrus.views.modelexplorer.DecoratingLabelProviderWTooltips;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpendiagramTest extends AbstractEditorTest {
	/**
	 * here the purpose is to test the creation of constraint on variable elements.
	 */
	@Test
	public void testOpendiagramTest() throws Exception {

		// get the rootModel
		Assert.assertNotNull("RootModel is null", getRootUMLModel()); //$NON-NLS-1$
		// get all semantic elment that will handled
		Model model = (Model) getRootUMLModel();
		org.eclipse.uml2.uml.Class class1 = (org.eclipse.uml2.uml.Class) model.getPackagedElement("Class1");
		org.eclipse.uml2.uml.Class class2 = (org.eclipse.uml2.uml.Class) model.getPackagedElement("Class2");
		Diagram diagram1 = (Diagram) getPageManager().allPages().get(0);
		Diagram diagram2 = (Diagram) getPageManager().allPages().get(1);

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelectionService selectionService = activeWorkbenchWindow.getSelectionService();
		modelExplorerView = getModelExplorerView();
		modelExplorerView.setFocus();
		ArrayList<Object> elements = new ArrayList<Object>();
		elements.add(getRootUMLModel());
		modelExplorerView.revealSemanticElement(elements);


		// getItem for model
		Object modelTreeObject = ((IStructuredSelection) selectionService.getSelection()).getFirstElement();
		Assert.assertNotNull("Model TreeElement is null", modelTreeObject); //$NON-NLS-1$

		// get Item for class1
		elements.clear();
		elements.add(class1);
		modelExplorerView.revealSemanticElement(elements);
		Object class1TreeObject = ((IStructuredSelection) selectionService.getSelection()).getFirstElement();
		Assert.assertNotNull("Class1 TreeElement is null", class1TreeObject); //$NON-NLS-1$

		// get Item for class2
		elements.clear();
		elements.add(class2);
		modelExplorerView.revealSemanticElement(elements);
		Object class2TreeObject = ((IStructuredSelection) selectionService.getSelection()).getFirstElement();
		Assert.assertNotNull("Class2 TreeElement is null", class2TreeObject); //$NON-NLS-1$

		// get Item for diagram1
		elements.clear();
		elements.add(diagram1);
		modelExplorerView.revealSemanticElement(elements);
		Object diagram1TreeObject = ((IStructuredSelection) selectionService.getSelection()).getFirstElement();
		Assert.assertNotNull("digram1 TreeElement is null", diagram1TreeObject); //$NON-NLS-1$
		// get Item for diagram2
		elements.clear();
		elements.add(diagram2);
		modelExplorerView.revealSemanticElement(elements);
		Object diagram2TreeObject = ((IStructuredSelection) selectionService.getSelection()).getFirstElement();
		Assert.assertNotNull("digram2 TreeElement is null", diagram2TreeObject); //$NON-NLS-1$

		// test icons of closed diagram
		DecoratingLabelProviderWTooltips labeProvider = (DecoratingLabelProviderWTooltips) modelExplorerView.getCommonViewer().getLabelProvider();
		Assert.assertNotEquals("the label of diagram1 is not good", "Diagram1", labeProvider.getText(diagram1)); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.assertNotEquals("the label of class1 is not good", "class1", labeProvider.getText(class1)); //$NON-NLS-1$ //$NON-NLS-2$

		// now test image about diagram for open and closed diagram
		// select all Tree element in the common viewer.
	}

	@Before
	public void initOpendiagramTest() {
		try {
			initModel("openDiagramTest", "OpenDiagram", Activator.getDefault().getBundle()); // $NON-NLS-1$ // $NON-NLS-2$
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected String getSourcePath() {
		return "resources/openDiagramTest/"; //$NON-NLS-1$
	}

}
