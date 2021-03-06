/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
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
 *   Christian W. Damus (CEA) - bug 434993
 *   Christian W. Damus (CEA) - bug 436047
 *   Christian W. Damus - bug 473183
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.tests.Activator;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.tests.canonical.StateNotShareable;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.junit.Test;

/**
 * Drag and drop is not well supported for all elements of sequence diagrams. Dnd
 * should be supported for all elements. Moreover, it would be interesting to have
 * an advanced drag and drop support for some elements. For instance, a drag and
 * drop of a ConnectableElement on an Interaction should create a Lifeline and
 * reference the dropped ConnectableElement in the Lifeline "represents" property.
 * A generic solution may be possible.
 */
@StateNotShareable
public class TestAdvancedDragDrop_364696 extends TestTopNode {

	private static final String UML_REPLACEMENT_TEMPLATE = "><nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_zAqbcIP8EeGnt9CMb_JfYQ\" name=\"Person\">"
			+ "<ownedAttribute xmi:id=\"__-RhYIP8EeGnt9CMb_JfYQ\" name=\"company\" isStatic=\"true\" type=\"_6imi4IP8EeGnt9CMb_JfYQ\"/>" + "</nestedClassifier>" + "<nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_6imi4IP8EeGnt9CMb_JfYQ\" name=\"Company\">"
			+ "<ownedAttribute xmi:type=\"uml:Port\" xmi:id=\"_1oQd4IP-EeGnt9CMb_JfYQ\" name=\"port1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EShort\"/>" + "</ownedAttribute>"
			+ "<ownedAttribute xmi:id=\"_CVUmYIP_EeGnt9CMb_JfYQ\" name=\"Property1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EDouble\"/>" + "</ownedAttribute>" + "</nestedClassifier>" + "</packagedElement>"
			+ "<packageImport xmi:id=\"_q19q4YP8EeGnt9CMb_JfYQ\">" + "<importedPackage xmi:type=\"uml:Model\" href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#_0\"/>" + "</packageImport>";

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

	@Override
	protected void projectCreation() {
		project = houseKeeper.createProject(getProjectName());
		file = project.getFile(getFileName());
		this.diResourceSet = houseKeeper.cleanUpLater(new DiResourceSet());
		try {
			// at this point, no resources have been created
			if (file.exists()) {
				file.delete(true, new NullProgressMonitor());
			}

			if (!file.exists()) {
				// Don't create a zero-byte file. Create an empty XMI document
				Resource diResource = diResourceSet.createResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
				diResource.save(null);
				diResource.unload();
				diResourceSet.createsModels(file);
				new CreateUMLModelCommand().createModel(this.diResourceSet);
				ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
				try {
					registry.add(ModelSet.class, Integer.MAX_VALUE, diResourceSet); // High priority to override all contributions
					registry.startRegistry();
				} catch (ServiceException ex) {
					// Ignore exceptions
				}
				ICreationCommand command = getDiagramCommandCreation();
				command.createDiagram(diResourceSet, null, "DiagramToTest");
				diResourceSet.save(new NullProgressMonitor());

			}
			initUml();

			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(true);

			papyrusEditor = houseKeeper.openPapyrusEditor(file);
		} catch (Exception e) {
			Activator.log.error("TestAdvancedDragDrop_364696 > projectCreation()", e);
		}
	}

	protected void initUml() throws CoreException {
		IFile uml = project.getFile("SequenceDiagramTest.uml");
		String content = FileUtil.read(uml.getContents());
		content = content.replaceAll("/>", UML_REPLACEMENT_TEMPLATE);

		uml.setContents(new ByteArrayInputStream(content.getBytes()), false, true, new NullProgressMonitor());
	}

	@FailingTest ("To be erased or rewritten to take new architecture into account")
	@Test
	public void testDragDrop() {
		Interaction interaction = (Interaction) getRootSemanticModel();
		{
			Classifier p = interaction.getNestedClassifier("Person");
			Feature feature = p.getFeature("company");

			assertTrue("", getRootEditPart().getChildren().size() == 0);
			dropObject(getRootEditPart(), feature);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(0) instanceof LifelineEditPart);
			assertTrue(DROP + TEST_THE_EXECUTION, getRepresents(((LifelineEditPart) getRootEditPart().getChildren().get(0))) == feature);
		}
		{
			Classifier p = interaction.getNestedClassifier("Company");
			Feature feature = p.getFeature("Property1");

			dropObject(getRootEditPart(), feature);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 2);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(1) instanceof LifelineEditPart);
			assertTrue(DROP + TEST_THE_EXECUTION, getRepresents(((LifelineEditPart) getRootEditPart().getChildren().get(1))) == feature);
		}

		{
			Classifier p = interaction.getNestedClassifier("Company");
			Feature feature = p.getFeature("port1");

			dropObject(getRootEditPart(), feature);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 3);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(2) instanceof LifelineEditPart);
			assertTrue(DROP + TEST_THE_EXECUTION, getRepresents(((LifelineEditPart) getRootEditPart().getChildren().get(2))) == feature);
		}
	}

	protected ConnectableElement getRepresents(LifelineEditPart editPart) {
		Lifeline lifeline = (Lifeline) editPart.resolveSemanticElement();
		return lifeline.getRepresents();
	}

	protected void dropObject(GraphicalEditPart parent, Object obj) {
		int childrenSize = parent.getChildren().size();

		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList list = new ArrayList();
		list.add(obj);
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20, 20));
		Command command = parent.getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
		assertTrue(DROP + TEST_THE_EXECUTION, parent.getChildren().size() == childrenSize + 1);

		getDiagramCommandStack().undo();
		assertTrue(DROP + TEST_THE_UNDO, parent.getChildren().size() == childrenSize);

		getDiagramCommandStack().redo();
		assertTrue(DROP + TEST_THE_REDO, parent.getChildren().size() == childrenSize + 1);
	}
}
