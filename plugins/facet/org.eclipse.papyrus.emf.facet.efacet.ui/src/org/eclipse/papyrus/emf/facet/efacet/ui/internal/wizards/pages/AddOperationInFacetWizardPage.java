/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.wizards.pages;

import java.util.Map;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.composites.SelectETypeComposite.ETypeSelectionOptions;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

@Deprecated
// TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class AddOperationInFacetWizardPage extends AbstractFacetWizardPage {

	public AddOperationInFacetWizardPage(final ISelection selection, final EditingDomain editingDomain,
			final Map<String, IQueryCreationPagePart> queryTypeNameToWizardPage) {
		super(selection, editingDomain, queryTypeNameToWizardPage, ETypeSelectionOptions.ECLASSIFIER);
		setTitle(Messages.Add_an_Operation);
		setDescription(Messages.Add_an_Operation_desc);
	}

	public void createControl(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = AbstractFacetWizardPage.VERTICAL_SPACING;

		showQueryTypeSelection(false);

		createControlParts(container);
		initializeTextContent(Messages.Facet, Messages.Operation_name);

		setControl(container);
	}
}
