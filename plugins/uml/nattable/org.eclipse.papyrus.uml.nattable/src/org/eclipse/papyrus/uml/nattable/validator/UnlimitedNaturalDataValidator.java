/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.nattable.validator;

import org.eclipse.nebula.widgets.nattable.data.validate.DataValidator;
import org.eclipse.papyrus.infra.widgets.validator.UnlimitedNaturalInputValidator;

/**
 *
 * @author Vincent Lorenzo
 *         Validator for UnlimitedNatural
 */
public class UnlimitedNaturalDataValidator extends DataValidator {

	/**
	 *
	 * @see org.eclipse.nebula.widgets.nattable.data.validate.DataValidator#validate(int, int, java.lang.Object)
	 *
	 * @param columnIndex
	 * @param rowIndex
	 * @param newValue
	 * @return
	 */
	@Override
	public boolean validate(int columnIndex, int rowIndex, Object newValue) {
		final UnlimitedNaturalInputValidator validator = new UnlimitedNaturalInputValidator();
		return validator.isValid(newValue.toString()) == null;
	}
}
