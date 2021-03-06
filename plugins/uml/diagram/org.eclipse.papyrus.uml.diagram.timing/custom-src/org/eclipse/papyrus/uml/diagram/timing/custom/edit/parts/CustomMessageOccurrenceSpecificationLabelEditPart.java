/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.parsers.OccurrenceSpecificationNameParser;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationLabelEditPart;

public class CustomMessageOccurrenceSpecificationLabelEditPart extends MessageOccurrenceSpecificationLabelEditPart {

	private IParser parser;

	public CustomMessageOccurrenceSpecificationLabelEditPart(final View view) {
		super(view);
	}

	@Override
	public IParser getParser() {
		if (this.parser == null) {
			this.parser = new OccurrenceSpecificationNameParser();
		}
		return this.parser;
	}
}
