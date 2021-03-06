/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.preferences.dialog;

import java.util.ArrayList;

/**
 * The Class ApplyValueOnPreferenceKeyDialog display all the preference key and give all selected keys
 * 
 * @since 1.2
 */
public abstract class AbstractApplyValueOnPreferenceKeyDialog extends AbstractPreferenceKeyDialog {

	/** The checked key. */
	protected ArrayList<String> checkedKey;

	/**
	 * Instantiates a new apply value on preference key dialog.
	 *
	 * @param keys
	 *            the keys
	 */
	public AbstractApplyValueOnPreferenceKeyDialog(String[] keys) {
		super(keys);
		checkedKey = new ArrayList<String>();
	}

	/**
	 * Gets the key to remove.
	 *
	 * @return the key to remove
	 */
	public ArrayList<String> getKeyToRemove() {
		return checkedKey;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		for (int i = 0; i < keyTable.getItems().length; i++) {
			if (keyTable.getItems()[i].getChecked()) {
				checkedKey.add((String) keyTable.getItems()[i].getData());
			}
		}
		super.okPressed();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		super.cancelPressed();
		checkedKey = new ArrayList<String>();
	}
}
