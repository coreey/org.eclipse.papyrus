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
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


/**
 * Preference page for stereotype paste strategy
 *
 */
public class StereotypePasteStrategyPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	protected RadioGroupFieldEditor dblClkFieldEditor;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	protected void createFieldEditors() {
		String[][] labelAndValues = new String[][] {
				// TODO: { "Ask before Aplying Profile", IStereotypePasteStrategyPreferenceConstant.ASK_POPUP },
				{ "Always apply missing profiles", IStereotypePasteStrategyPreferenceConstant.IMPORT_MISSING_PROFILE },
				{ "Never apply missing profiles", IStereotypePasteStrategyPreferenceConstant.IGNORE_MISSING_PROFILE }
		};
		dblClkFieldEditor = new RadioGroupFieldEditor(
				IStereotypePasteStrategyPreferenceConstant.PROFILE_STRATEGY, "Missing profiles strategy :", 1,
				labelAndValues,
				getFieldEditorParent());
		addField(dblClkFieldEditor);
		dblClkFieldEditor.setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}
}
