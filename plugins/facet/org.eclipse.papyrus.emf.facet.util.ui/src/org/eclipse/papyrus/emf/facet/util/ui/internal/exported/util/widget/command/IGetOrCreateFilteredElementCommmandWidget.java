/**
 * Copyright (c) 2012 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;

/**
 * @since 0.3
 */
public interface IGetOrCreateFilteredElementCommmandWidget<T extends Object, W extends Object>
		extends ICommandWidget {

	/**
	 * @return the selected element in the filtredList.
	 */
	T getElementSelected();

	void selectElement(T element);

	void selectElementByName(String name);

	IDialog<W> pressNewButton();

}