/*****************************************************************************
 * Copyright (c) 2011, 2014 LIFL and others.
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
 *  LIFL - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.services;

/**
 * An Service that can be registered in the {@link ServicesRegistry}. A service
 * is a singleton available throw the registry. A service can be shared across
 * editors. <br>
 * The life cycle is as follow:
 * <ul>
 * <li>service creation</li>
 * <li>{@link #init(ServicesRegistry)} - Other service can be retrieved from the registry, but are not started yet.</li>
 * <li>{@link #startService()} - service is started.</li>
 * <li>Service can be used</li>
 * <li>{@link #disposeService()} - service is disposed and should not be used anymore.</li>
 * </ul>
 *
 * @author cedric dumoulin
 *
 */
public interface IService {

	/**
	 * Init the service and set its associated Registry. The registry can be
	 * used to retrieve other services.
	 *
	 * @param servicesRegistry
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException;

	/**
	 * Start the service. This method is called when the service is started.
	 */
	public void startService() throws ServiceException;

	/**
	 * Dispose the service.
	 */
	public void disposeService() throws ServiceException;

}
