/*
 * Copyright (c) 2014 CEA and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.services.markerlistener.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * This is the Messages type. Enjoy.
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.services.markerlistener.internal.messages.messages"; //$NON-NLS-1$

	public static String DiagnosticDialog_0;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
