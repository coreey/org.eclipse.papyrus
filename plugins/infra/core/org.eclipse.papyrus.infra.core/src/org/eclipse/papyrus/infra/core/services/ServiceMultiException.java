/*****************************************************************************
 * Copyright (c) 2011, 2015 LIFL, Christian W. Damus, and others.
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
 *  Christian W. Damus - bug 468030
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.services;

import java.util.ArrayList;
import java.util.List;

/**
 * An exception encapsulating multiple exceptions. This exception is thrown when
 * an operation performed on several Services fails on one or more of these
 * Service. The exception contains all the exceptions encoutered while
 * opertating on Services.
 *
 * @author cedric dumoulin
 *
 */
public class ServiceMultiException extends ServiceException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * List of encountered exceptions.
	 */
	List<Throwable> encounteredExceptions = new ArrayList<Throwable>();

	/**
	 * List of identifiers corresponding to exceptions.
	 */
	List<Object> serviceIdentifiers = new ArrayList<Object>();

	/**
	 * @return the encounteredExceptions
	 */
	public List<Throwable> getExceptions() {
		return encounteredExceptions;
	}

	/**
	 * Constructor.
	 *
	 */
	public ServiceMultiException() {
		super("Multiple exceptions"); //$NON-NLS-1$
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public ServiceMultiException(String message) {
		super(message);
	}

	/**
	 * Return the first exception.
	 *
	 * @see java.lang.Throwable#getCause()
	 *
	 * @return
	 */
	@Override
	public Throwable getCause() {
		return (encounteredExceptions.size() > 0 ? encounteredExceptions.get(0) : null);
	}

	/**
	 * Return the message if any, or the message of the first exception.
	 *
	 * @see java.lang.Throwable#getMessage()
	 *
	 * @return
	 */
	@Override
	public String getMessage() {

		StringBuffer buffer = new StringBuffer();

		String message = super.getMessage();
		if (message != null) {
			buffer.append(message).append('\n');
		}

		buffer.append("----- exceptions : ----------\n");
		for (int i = 0; i < encounteredExceptions.size(); i++) {
			Throwable exception = encounteredExceptions.get(i);
			Object identifierMsg = serviceIdentifiers.get(i);

			if (identifierMsg != null) {
				buffer.append(identifierMsg.toString()).append(" : ");
			}
			String msg = exception.getMessage();
			if (msg != null) {
				buffer.append(msg).append('\n');
			}
		}
		buffer.append("----------------------------- \n");

		return buffer.toString();
		// // Check for first exception
		// if( encounteredExceptions.size() > 1)
		// return encounteredExceptions.get(0).getMessage();
		//
		// // default
		// return null;
	}

	/**
	 * Add an exception to the list of exceptions.
	 *
	 * @param exception
	 */
	public void addException(Throwable exception) {
		addException("unknown", exception);
	}

	/**
	 * Add an exception to the list of exceptions. Also record the corresponding
	 * model identifier if any.
	 *
	 * @param exception
	 */
	public void addException(Object identifier, Throwable exception) {
		encounteredExceptions.add(exception);
		serviceIdentifiers.add(identifier);
	}

	/**
	 * Merge both exceptions
	 *
	 * @param e
	 */
	public void addAll(ServiceMultiException e) {
		encounteredExceptions.addAll(e.encounteredExceptions);
		serviceIdentifiers.addAll(serviceIdentifiers);
	}

	@Override
	public ServiceException chain(Throwable next) {
		if (next instanceof ServiceMultiException) {
			addAll((ServiceMultiException) next);
		} else if (next != null) {
			addException(next);
		}
		return this;
	}

	@Override
	public ServiceException chain(String identifier, Throwable next) {
		if (next != null) {
			addException(identifier, next);
		}
		return this;
	}
}
