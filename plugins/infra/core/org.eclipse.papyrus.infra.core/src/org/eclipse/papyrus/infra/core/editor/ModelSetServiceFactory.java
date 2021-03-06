/*****************************************************************************
 * Copyright (c) 2011, 2015 CEA LIST, Christian W. Damus, and others.
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
 *  Christian W. Damus (CEA) - bug 431953 (pre-requisite refactoring of ModelSet service start-up)
 *  Christian W. Damus - bug 468030
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.editor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.language.ILanguageService;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ModelSetServiceAdapter;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * A service starting the ModelSet
 *
 * @author cedric dumoulin
 *
 */
public class ModelSetServiceFactory implements IServiceFactory {

	private ServicesRegistry serviceRegistry;

	/** The ModelSet */
	private ModelSet service;

	/**
	 *
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.serviceRegistry = servicesRegistry;
	}

	@Override
	public void startService() throws ServiceException {
		// If the language service is available (optional dependency), the ModelSet will want to use it, so start it
		try {
			serviceRegistry.startServicesByClassKeys(ILanguageService.class);
		} catch (ServiceException e) {
			// It's okay: the language service is optional
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
		if (service != null) {
			try {
				setServiceRegistry(service, null);
			} finally {
				service.unload();
			}
		}
	}

	/**
	 * Create the service served by this factory.
	 */
	@Override
	public final Object createServiceInstance() throws ServiceException {
		if (service == null) {
			service = createModelSet();
			setServiceRegistry(service, serviceRegistry);
		}

		return service;
	}

	@SuppressWarnings("deprecation")
	protected ModelSet createModelSet() {
		// Return a DiResourceSet for backward compatibility
		// TODO return a ModelSet once DiResourceSet is removed
		return new org.eclipse.papyrus.infra.core.utils.DiResourceSet();
	}

	public static ServicesRegistry getServiceRegistry(ResourceSet resourceSet) {
		ModelSetServiceAdapter adapter = ModelSetServiceAdapter.getInstance(resourceSet);
		return (adapter == null) ? null : adapter.getServiceRegistry();
	}

	/**
	 * Associates a resource set with a service registry.
	 *
	 * @param resourceSet
	 *            a resource set. Must not be {@code null}
	 * @param serviceRegistry
	 *            a service registry. May be {@code null} to remove a previous association
	 */
	public static void setServiceRegistry(ResourceSet resourceSet, ServicesRegistry serviceRegistry) throws ServiceException {
		if (serviceRegistry != null) {
			ModelSetServiceAdapter adapter = new ModelSetServiceAdapter(resourceSet);
			adapter.init(serviceRegistry);
			adapter.startService();
		} else {
			ModelSetServiceAdapter adapter = ModelSetServiceAdapter.getInstance(resourceSet);
			if (adapter != null) {
				adapter.stopService();
			}
		}
	}

}
