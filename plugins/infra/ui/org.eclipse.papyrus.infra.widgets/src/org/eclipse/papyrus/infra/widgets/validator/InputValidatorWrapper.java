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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IInputValidator;

/**
 * A Wrapper for IValidator to IInputValidator
 *
 * @author Camille Letavernier
 */
public class InputValidatorWrapper implements IInputValidator {

	protected IValidator validator;

	public InputValidatorWrapper(IValidator validator) {
		Assert.isNotNull(validator);
		this.validator = validator;
	}

	@Override
	public String isValid(String newText) {
		IStatus status = validator.validate(newText);
		if (status.isOK()) {
			return null;
		}

		return status.getMessage();
	}

}
