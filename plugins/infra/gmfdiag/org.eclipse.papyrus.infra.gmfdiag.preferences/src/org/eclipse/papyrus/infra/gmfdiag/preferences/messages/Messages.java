/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.preferences.messages.messages"; //$NON-NLS-1$

	public static String ApplyValueOnPreferenceKeyDialog_DIAGRAM;

	public static String ApplyValueOnPreferenceKeyDialog_ELEMENT;

	public static String EditorConnectionGroup_ConnectionBendpoints;

	public static String EditorConnectionGroup_DrawCommonBendpoint_EditorLabel;

	public static String LabelGroup_Labels_To_Display;

	public static String RulersAndGridGroup_GridColor;

	public static String RulersAndGridGroup_GridInFront;

	public static String RulersAndGridGroup_GridStyle;



	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
