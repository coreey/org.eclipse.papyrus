/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.ui.dialogs;


import org.eclipse.swt.widgets.Shell;


/**
 * The Class ComboSelectionDialog.
 */
public class ComboSelectionDialog extends ChooseDialog {

	/**
	 * The index of selection.
	 */
	public int indexOfSelection = 0;

	/**
	 * The Constructor.
	 *
	 * @param parentShell
	 *            the parent shell
	 * @param message
	 *            the message
	 * @param listofChoice
	 *            the listof choice
	 * @param initial
	 *            the initial
	 */
	public ComboSelectionDialog(Shell parentShell, String message, String[] listofChoice, String initial) {
		super(parentShell);
		announce = message;
		elementList = listofChoice;
		initialValue = initial;
	}

	/**
	 * Ok pressed.
	 */
	@Override
	protected void okPressed() {
		value = combo.getText();
		indexOfSelection = combo.getSelectionIndex();
		super.okPressed();
	}
}
