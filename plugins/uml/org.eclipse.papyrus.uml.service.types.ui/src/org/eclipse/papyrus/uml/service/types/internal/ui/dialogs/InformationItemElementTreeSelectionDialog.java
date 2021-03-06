/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.internal.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.uml.service.types.internal.ui.messages.Messages;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

/**
 * Add a Button to the super-class {@link ElementTreeSelectionDialog} to create a new
 * InformationItem
 *
 */
public class InformationItemElementTreeSelectionDialog extends ElementTreeSelectionDialog {

	protected Button newInformationItemButton;

	public static final int newInformationItemButton_ID = IDialogConstants.CLIENT_ID + 1;

	public InformationItemElementTreeSelectionDialog(Shell parent, ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider);

	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, newInformationItemButton_ID, Messages.InformationItemElementTreeSelectionDialog_0, false);
		super.createButtonsForButtonBar(parent);
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == newInformationItemButton_ID) {
			newInformationItemButtonPressed();
		} else {
			super.buttonPressed(buttonId);
		}

	}

	/**
	 * Write the ReturnCode and close the window
	 *
	 */
	protected void newInformationItemButtonPressed() {
		setReturnCode(newInformationItemButton_ID);
		close();
	}
}
