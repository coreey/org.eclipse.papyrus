/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.scope;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;

/**
 *
 * Implements a visitor that goes through a hierarchy of Iresource from a root and collect only those that can be processed for search
 *
 */
public class ResourceVisitor implements IResourceProxyVisitor {

	private Collection<URI> participantURIs;

	public ResourceVisitor() {
		super();
		this.participantURIs = new HashSet<URI>();
	}

	public boolean visit(IResourceProxy proxy) throws CoreException {
		switch (proxy.getType()) {
		case IResource.FILE:
			IResource resource = proxy.requestResource();

			URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);

			if ("di".equals(uri.fileExtension())) { //$NON-NLS-1$
				// Verify that it is a true papyrus model
				// try {
				// ModelSet modelSet = ModelUtils.openFile(resource);
				// modelSet.unload();
				participantURIs.add(uri);
				// } catch (ModelMultiException e) {
				// }
			}

			break;
		default:
			break;
		}
		return true;
	}

	public Collection<URI> getParticipantURIs() {
		return participantURIs;
	}

}
