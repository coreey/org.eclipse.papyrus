/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.services.validation.preferences;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.validation.Activator;
import org.eclipse.papyrus.infra.services.validation.Messages;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.ui.util.EditorUtils;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferencePage() {
		super(GRID);
	}

	@Override
	public void createFieldEditors() {

		String selection[][] = new String[][] {
				{ "&No", "NO" }, //$NON-NLS-1$//$NON-NLS-2$
				{ "&Direct parent", "DIRECT" }, //$NON-NLS-1$//$NON-NLS-2$
				{ "&All parents", "ALL" } //$NON-NLS-1$//$NON-NLS-2$
		};
		addField(new RadioGroupFieldEditor(PreferenceConstants.HIERARCHICAL_MARKERS, Messages.PreferencePage_MarkParents,
				1, selection, getFieldEditorParent()));

		addField(new BooleanFieldEditor(PreferenceConstants.AUTO_SHOW_VALIDATION_VIEW, Messages.PreferencePage_AutoOpenValidationView,
				getFieldEditorParent()));
		// stringField1 = new StringFieldEditor("MySTRING1",
		// "A &text preference:", getFieldEditorParent());
		// addField(stringField1);
	}

	@Override
	protected void checkState() {
		super.checkState();
		// checkState allow you to perform validations
	}

	@Override
	public boolean performOk() {
		boolean retCode = super.performOk();
		triggerRedraw();
		return retCode;
	}

	@Override
	protected void performApply() {
		super.performApply();
		triggerRedraw();
	}

	/**
	 * trigger a redraw of the model explorer by sending a notify signal (otherwise markers
	 * would remain (or not been drawn) on parent elements that are concerned by a change
	 * of the preference.
	 */
	protected void triggerRedraw() {
		// get references to all Papyrus editors, send the notification to each
		IMultiDiagramEditor papyrusEditors[] = EditorUtils.getMultiDiagramEditors();
		for (IMultiDiagramEditor papyrusEditor : papyrusEditors) {
			ServicesRegistry serviceRegistry = papyrusEditor.getServicesRegistry();
			if (serviceRegistry != null) {
				try {
					ModelSet modelSet = serviceRegistry.getService(ModelSet.class);
					modelSet.eNotify(new NotificationImpl(Notification.SET, new Object(), null));
				} catch (ServiceException e) {
				}
			}
		}
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		// setDescription("Preference page for validation");
	}
}
