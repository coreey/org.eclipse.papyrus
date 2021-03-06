/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.documentation.profile;


public interface IUMLDocumentationConstants {

	public static final String STEREOTYPE_NAME = "Documentation"; //$NON-NLS-1$

	public static final String RESOURCE_PROPERTY_NAME = "associatedResource"; //$NON-NLS-1$

	public static final String PAPYRUS_PROFILE_NAME = "Papyrus"; //$NON-NLS-1$

	public static final String DOCUMENTATION_SUB_PROFILE_NAME = "Documentation"; //$NON-NLS-1$

	public static final String PROFILE_NAME = PAPYRUS_PROFILE_NAME + "::" + DOCUMENTATION_SUB_PROFILE_NAME; //$NON-NLS-1$

	public static final String STEREOTYPE_QUALIFIED_NAME = PROFILE_NAME + "::" + STEREOTYPE_NAME; //$NON-NLS-1$

	public static final String PROFILE_URI = "pathmap://Papyrus.profile.uml"; //$NON-NLS-1$

}
