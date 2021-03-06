/*****************************************************************************
 * Copyright (c) 2014, 2017 CEA LIST.
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
 *  Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 509357
 /*****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.modelexplorer.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.modelexplorer.messages.messages"; //$NON-NLS-1$

	public static String DuplicateDiagramHandler_CopyOf;

	public static String RenameDiagramHandler_NewName;

	public static String RenameDiagramHandler_RenameAnExistingDiagram;

	public static String RenameDiagramHandler_Label_DialogTitle;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
