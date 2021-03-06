/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.SequenceDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.Activator;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * It should be possible from property view (appearance) and from papyrus preferences to decide how the represented ConnectableElement appears in
 * Lifeline label.
 * One should be able to only show the represented element type name, or its name, or both. When the type is not set, one should have the choice to
 * make it appear as undefined or to be systematically hidden.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=383722
 *
 */
public class TestLifelineLabelCustomize_383722 extends TestTopNode {

	private static final String LABEL = "Label: ";

	private static final String CHANGE_REPRESENTS = "Change Represents: ";

	/** key for the appearance of properties or other specific display */
	public static final String CUSTOM_APPEARENCE_ANNOTATION = "CustomAppearance_Annotation";

	/** key for the appearance of properties or other specific display */
	public static final String CUSTOM_APPEARANCE_MASK_VALUE = "CustomAppearance_MaskValue";

	public static final int SHOW_REPRESENT_NAME = 1 << 1;

	public static final int SHOW_REPRESENT_TYPE = 1 << 2;

	public static final int SHOW_UNDEFINED_TYPE = 1 << 3;

	public static final int SHOW_LIFELINE_NAME = 1 << 4;

	public static final String LABEL_DISPLAY_PREFERENCE = SequenceDiagramEditPart.MODEL_ID + "_Lifeline.label.display";

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

	@Test
	public void testLabelAppearence1() {
		final LifelineEditPart lifeline1 = setupLifeline();
		WrappingLabel label = lifeline1.getPrimaryShape().getFigureLifelineLabelFigure();
		setLabelAppearence(lifeline1, SHOW_REPRESENT_NAME | SHOW_REPRESENT_TYPE);
		assertTrue(LABEL, "company:Company".equals(label.getText()));
	}

	@Test
	public void testLabelAppearence2() {
		final LifelineEditPart lifeline1 = setupLifeline();
		WrappingLabel label = lifeline1.getPrimaryShape().getFigureLifelineLabelFigure();
		setLabelAppearence(lifeline1, SHOW_LIFELINE_NAME);
		assertTrue(LABEL, "Lifeline".equals(label.getText()));
	}

	@Test
	public void testLabelAppearence3() {
		final LifelineEditPart lifeline1 = setupLifeline();
		WrappingLabel label = lifeline1.getPrimaryShape().getFigureLifelineLabelFigure();
		setLabelAppearence(lifeline1, SHOW_REPRESENT_TYPE);
		assertTrue(LABEL, "Lifeline:Company".equals(label.getText()));
	}

	@Test
	public void testLabelAppearence4() {
		final LifelineEditPart lifeline1 = setupLifeline();
		WrappingLabel label = lifeline1.getPrimaryShape().getFigureLifelineLabelFigure();
		setLabelAppearence(lifeline1, SHOW_LIFELINE_NAME | SHOW_REPRESENT_NAME | SHOW_REPRESENT_TYPE);
		assertTrue(LABEL, "Lifeline:Company".equals(label.getText()));
	}

	@Test
	public void testLabelPreference1() {
		setLabelPreference(SHOW_REPRESENT_NAME | SHOW_REPRESENT_TYPE);
		final LifelineEditPart lifeline1 = setupLifeline();
		WrappingLabel label = lifeline1.getPrimaryShape().getFigureLifelineLabelFigure();
		assertTrue(LABEL, "company:Company".equals(label.getText()));
	}

	@Test
	public void testLabelPreference2() {
		setLabelPreference(SHOW_LIFELINE_NAME);
		final LifelineEditPart lifeline1 = setupLifeline();
		WrappingLabel label = lifeline1.getPrimaryShape().getFigureLifelineLabelFigure();
		assertTrue(LABEL, "Lifeline".equals(label.getText()));
	}

	@Test
	public void testLabelPreference3() {
		setLabelPreference(SHOW_REPRESENT_TYPE);
		final LifelineEditPart lifeline1 = setupLifeline();
		WrappingLabel label = lifeline1.getPrimaryShape().getFigureLifelineLabelFigure();
		assertTrue(LABEL, "Lifeline:Company".equals(label.getText()));
	}

	@Test
	public void testLabelPreference4() {
		setLabelPreference(SHOW_LIFELINE_NAME | SHOW_REPRESENT_NAME | SHOW_REPRESENT_TYPE);
		final LifelineEditPart lifeline1 = setupLifeline();
		WrappingLabel label = lifeline1.getPrimaryShape().getFigureLifelineLabelFigure();
		assertTrue(LABEL, "Lifeline:Company".equals(label.getText()));
	}

	protected LifelineEditPart setupLifeline() {
		createNode(UMLElementTypes.Lifeline_Shape, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart) getRootEditPart().getChildren().get(0);
		waitForComplete();

		// set lifeline represent
		Interaction interaction = (Interaction) getRootSemanticModel();
		Classifier p = interaction.getNestedClassifier("Person");
		changeRepresents(lifeline1, p.getFeature("company"));
		return lifeline1;
	}

	protected IPreferenceStore setLabelPreference(final int value) {
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		store.setValue(LABEL_DISPLAY_PREFERENCE, value);
		return store;
	}

	protected void setLabelAppearence(final LifelineEditPart lifeline1, final int value) {
		DummyCommand c = new DummyCommand() {

			@Override
			public void execute() {
				View view = lifeline1.getNotationView();
				EAnnotation oldAnnotation = view.getEAnnotation(CUSTOM_APPEARENCE_ANNOTATION); // VisualInformationPapyrusConstants
				if (oldAnnotation == null) {
					oldAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					oldAnnotation.setSource(CUSTOM_APPEARENCE_ANNOTATION);
					view.getEAnnotations().add(oldAnnotation);
				}
				oldAnnotation.getDetails().put(CUSTOM_APPEARANCE_MASK_VALUE, String.valueOf(value));
			}
		};
		getEMFCommandStack().execute(c);
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
				ICreationCommand command = getDiagramCommandCreation();
				command.createDiagram(diResourceSet, null, "DiagramToTest");
				diResourceSet.save(new NullProgressMonitor());

			}
			initUml();

			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(true);

			papyrusEditor = houseKeeper.openPapyrusEditor(file);
		} catch (Exception e) {
			Activator.log.error("TestLifelineLabelCustomize_383722 > projectCreation()", e);
		}
	}

	protected void initUml() throws CoreException {
		IFile uml = project.getFile("SequenceDiagramTest.uml");
		String content = FileUtil.read(uml.getContents());
		content = content.replaceAll("/>", UML_REPLACEMENT_TEMPLATE);

		uml.setContents(new ByteArrayInputStream(content.getBytes()), false, true, new NullProgressMonitor());
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

	protected void changeRepresents(LifelineEditPart p, Object value) {
		Lifeline lifeline = (Lifeline) p.resolveSemanticElement();
		EReference feature = UMLPackage.eINSTANCE.getLifeline_Represents();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(lifeline);
		SetRequest request = new SetRequest(p.getEditingDomain(), lifeline, feature, value);
		ICommand createGMFCommand = provider.getEditCommand(request);
		org.eclipse.emf.common.command.AbstractCommand emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		assertTrue(CHANGE_REPRESENTS + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, emfCommand.canExecute() == true);
		getEMFCommandStack().execute(emfCommand);
		waitForComplete();
		if (value != null) {
			assertTrue(CHANGE_REPRESENTS + TEST_THE_EXECUTION, lifeline.getRepresents().equals(value));
		}
	}

	static class DummyCommand extends org.eclipse.emf.common.command.AbstractCommand {

		@Override
		public void execute() {
		}

		@Override
		public void redo() {
		}

		@Override
		public void undo() {
		}

		@Override
		protected boolean prepare() {
			return true;
		}
	};
}
