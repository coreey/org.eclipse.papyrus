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
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.getorcreate;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithButtonWidget;

/**
 * @see AbstractGetOrCreateElementWithButtonWidget
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IAbstractGetOrCreateElementWithButtonWidget<D>
		extends
		IAbstractGetOrCreateElementWidget {

	/**
	 * @param buttonEnabled
	 *            the buttonEnabled to set
	 */
	void setButtonEnabled(final boolean buttonEnabled);

	/**
	 * Press the button.
	 *
	 * @return the potential object return when the button is pressed. Can be
	 *         null.
	 */
	D pressButton();

}