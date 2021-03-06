/*****************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * IBM Corporation - initial implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors.richtext;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * The base class for all dialogs used by the rich text editor.
 *
 * @author Kelvin Low
 * @since 2.0
 *
 *
 */
public class BaseDialog extends Dialog {

	// TODO: try to remove this class

	// The OK button.
	protected Button okButton;

	// The Cancel button.
	protected Button cancelButton;

	/**
	 * Creates a new instance.
	 *
	 * @param parent
	 *            the parent shell
	 */
	public BaseDialog(Shell parent) {
		super(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = (GridLayout) composite.getLayout();
		layout.marginWidth = 10;
		layout.marginHeight = 10;
		layout.numColumns = 2;
		GridData gridData = (GridData) composite.getLayoutData();
		gridData.verticalIndent = 10;
		return composite;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// Create the OK button.
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);

		// Create the Cancel button.
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);

		// Set help context for the OK button.
		okButton = super.getButton(IDialogConstants.OK_ID);

		// Set help context for the Cancel button.
		cancelButton = super.getButton(IDialogConstants.CANCEL_ID);
	}

}
