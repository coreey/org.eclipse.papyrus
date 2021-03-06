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
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.ITreeNattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectTreeItemAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TreeFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.tree.CollapseAndExpandActionsEnum;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * This allows to test the deletion of a requirement containing a nested requirement and its display in the table.
 */
@PluginResource("resources/bugs/bug481020/DeleteRequirementsWithNestedClassifier.di")
public class DeleteRequirementsWithNestedClassifier {

	/**
	 * The papyrus editor fixture.
	 */
	@Rule
	public final PapyrusEditorFixture fixture = new PapyrusEditorFixture();

	/**
	 * the nattable editor
	 */
	private NatTableEditor editor;

	/**
	 * the tree table manager
	 */
	private ITreeNattableModelManager manager;

	/**
	 * The root element.
	 */
	private Package root;

	/**
	 * The existing requirement.
	 */
	private Class requirement1;

	/**
	 * The name of the existing requirement.
	 */
	private static final String REQUIREMENT_1 = "Requirement1"; //$NON-NLS-1$

	/**
	 * The name of the existing nested requirement.
	 */
	private static final String NESTED_REQUIREMENT_1 = "NestedRequirement1"; //$NON-NLS-1$

	/**
	 * Load the table editor
	 */
	@Before
	public void init() {
		// Get the first
		IPageManager pageManager = fixture.getPageManager();
		List<Object> pages = pageManager.allPages();
		pageManager.openPage(pages.get(0));
		IEditorPart part = fixture.getEditor().getActiveEditor();
		Assert.assertTrue(part instanceof NatTableEditor);
		this.editor = (NatTableEditor) part;
		INattableModelManager m = (INattableModelManager) editor.getAdapter(INattableModelManager.class);
		Assert.assertTrue(m instanceof ITreeNattableModelManager);
		this.manager = (ITreeNattableModelManager) m;

		// Get the needed elements in the table
		final EObject context = this.manager.getTable().getContext();
		Assert.assertTrue(context instanceof Package);
		this.root = (Package) context;
		this.requirement1 = (Class) this.root.getMember(REQUIREMENT_1);
		Assert.assertNotNull(requirement1);
	}

	/**
	 * This allows to test the deletion of requirement containening the nested requirement.
	 * 
	 * @throws Exception
	 *             The exception.
	 */
	@Test
	public void testDeleteRequirementWithNestedRequirement() throws Exception {

		// Expand the table
		manager.doCollapseExpandAction(CollapseAndExpandActionsEnum.EXPAND_ALL, null);
		fixture.flushDisplayEvents();

		// Check the rows contents
		List<?> rowElements = manager.getRowElementsList();
		checkInitialRowscontent(rowElements);

		// Create a requirement as nested classifier
		final TransactionalEditingDomain editingDomain = fixture.getEditingDomain();
		editingDomain.getCommandStack().execute(RemoveCommand.create(editingDomain, root, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, requirement1));

		// Check the rows content (must be empty because all requirements was deleted)
		rowElements = manager.getRowElementsList();
		Assert.assertEquals(0, rowElements.size());

		// Manage the undo
		editingDomain.getCommandStack().undo();
		
		// Expand the table
		manager.doCollapseExpandAction(CollapseAndExpandActionsEnum.EXPAND_ALL, null);
		fixture.flushDisplayEvents();

		// Check the rows contents
		rowElements = manager.getRowElementsList();
		checkInitialRowscontent(rowElements);

		// Manage the redo
		editingDomain.getCommandStack().redo();
		
		// Check the rows content (must be empty because all requirements was deleted)
		rowElements = manager.getRowElementsList();
		Assert.assertEquals(0, rowElements.size());
	}

	/**
	 * This allows to check the initial rows contents (it will be identical after the undo).
	 * 
	 * @param rowElements The rows elements from the table.
	 */
	protected void checkInitialRowscontent(final List<?> rowElements) {
		Assert.assertEquals(4, rowElements.size());

		final Object firstRowRepresentedElement = ((EObjectTreeItemAxis) rowElements.get(0)).getElement();
		Assert.assertTrue("The first row must be a tree filling configuration", firstRowRepresentedElement instanceof TreeFillingConfiguration);

		final Object secondRowRepresentedElement = ((EObjectTreeItemAxis) rowElements.get(1)).getElement();
		Assert.assertEquals(UMLPackage.eINSTANCE.getClass_(), ((EObject) secondRowRepresentedElement).eClass());
		Assert.assertEquals(REQUIREMENT_1, ((org.eclipse.uml2.uml.Class) secondRowRepresentedElement).getName());

		final Object thirdRowRepresentedElement = ((EObjectTreeItemAxis) rowElements.get(2)).getElement();
		Assert.assertTrue("The third row must be a tree filling configuration", thirdRowRepresentedElement instanceof TreeFillingConfiguration);

		final Object fourthRowRepresentedElement = ((EObjectTreeItemAxis) rowElements.get(3)).getElement();
		Assert.assertEquals(UMLPackage.eINSTANCE.getClass_(), ((EObject) fourthRowRepresentedElement).eClass());
		Assert.assertEquals(NESTED_REQUIREMENT_1, ((org.eclipse.uml2.uml.Class) fourthRowRepresentedElement).getName());
	}

}
