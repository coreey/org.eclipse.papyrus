/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.papyrus.infra.widgets.selectors.StringSelector;
import org.eclipse.swt.widgets.Composite;

/**
 * A compact editor for multivalued String attributes
 *
 * @author Camille Letavernier
 *
 */
public class CompactMultipleStringEditor extends CompactMultipleValueEditor {

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The Composite widget in which this editor will be displayed
	 * @param style
	 *            The value label's style
	 */
	public CompactMultipleStringEditor(Composite parent, int style) {
		this(parent, style, true, false, DEFAULT_VALUE_SEPARATOR, null);
	}

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The Composite widget in which this editor will be displayed
	 * @param style
	 *            The value label's style
	 * @param ordered
	 *            True if the values should be ordered
	 * @param unique
	 *            True if the values should be unique
	 */
	public CompactMultipleStringEditor(Composite parent, int style, boolean ordered, boolean unique) {
		this(parent, style, ordered, unique, DEFAULT_VALUE_SEPARATOR, null);
	}

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            The Composite widget in which this editor will be displayed
	 * @param style
	 *            The value label's style
	 * @param ordered
	 *            True if the values should be ordered
	 * @param unique
	 *            True if the values should be unique
	 * @param separator
	 *            The String used to separate the different values in the value label
	 * @param label
	 *            The editor's label
	 */
	public CompactMultipleStringEditor(Composite parent, int style, boolean ordered, boolean unique, String separator, String label) {
		super(parent, style, new StringSelector(), ordered, unique, separator, label);
	}

}
