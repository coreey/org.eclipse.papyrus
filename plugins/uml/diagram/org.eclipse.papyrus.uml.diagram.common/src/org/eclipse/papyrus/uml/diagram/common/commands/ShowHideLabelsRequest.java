/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.gmf.runtime.diagram.ui.requests.ToggleConnectionLabelsRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This request is used to manage the display (or not) of ONE label for the
 * connection
 *
 *
 *
 */
public class ShowHideLabelsRequest extends ToggleConnectionLabelsRequest {

	/**
	 * the request type
	 */
	public static final String SHOW_HIDE_LABELS_REQUEST_TYPE = "ShowHideLabelsRequest"; //$NON-NLS-1$

	/**
	 * the view to show/hide
	 */
	private View view;

	/**
	 *
	 * Constructor.
	 *
	 * @param showConnectionLabel
	 *            the value for the action : <code>true</code> means show and <code>false</code> means hdie
	 * @param view
	 *            the view to manage
	 */
	public ShowHideLabelsRequest(boolean showConnectionLabel, View view) {
		super(showConnectionLabel);
		this.view = view;
		setType(SHOW_HIDE_LABELS_REQUEST_TYPE);
	}

	/**
	 * Returns the view to show/hide
	 *
	 * @return the view to show/hide
	 */
	public View getView() {
		return this.view;
	}

}
