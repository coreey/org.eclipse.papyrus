/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Fabien Giquel (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 334546 - [celleditors] no border on Text field
 *    Nicolas Bros (Mia-Software) - Bug 338437 - compositeEditors extension point cannot be used to register user types
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.ecore.composite;

import org.eclipse.papyrus.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.ICompositeEditorFactory;
import org.eclipse.swt.widgets.Composite;

public class FloatCompositeFactory implements ICompositeEditorFactory<Float> {

	public AbstractCellEditorComposite<Float> createCompositeEditor(final Composite parent, final int style) {
		return new FloatComposite(parent, style);
	}

	public Class<Float> getHandledType() {
		return Float.class;
	}

}
