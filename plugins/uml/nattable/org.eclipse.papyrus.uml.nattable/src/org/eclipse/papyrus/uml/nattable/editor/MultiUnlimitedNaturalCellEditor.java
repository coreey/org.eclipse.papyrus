/*****************************************************************************
 * Copyright (c) 2013, 2018 CEA LIST.
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
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 517190
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.editor;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.creation.UnlimitedNaturalEditionFactory;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.IntegerSelector;

/**
 * CellEditor for multivalued unlimited natural
 *
 * @author Vincent Lorenzo
 *
 */
public class MultiUnlimitedNaturalCellEditor extends AbstractMultiValuePrimitiveTypeCellEditor {

	/**
	 *
	 * Constructor.
	 *
	 * @param axisElement
	 * @param elementProvider
	 */
	public MultiUnlimitedNaturalCellEditor(Object axisElement, ITableAxisElementProvider elementProvider) {
		super(axisElement, elementProvider);
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.nattable.celleditor.AbstractUMLMultiValueCellEditor#getElementSelector(boolean, org.eclipse.jface.viewers.ILabelProvider, org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider)
	 *
	 * @param isUnique
	 * @param labelProvider
	 * @param contentProvider
	 * @return
	 */
	@Override
	protected IElementSelector getElementSelector(boolean isUnique, ILabelProvider labelProvider, IStaticContentProvider contentProvider) {
		return new IntegerSelector();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.nattable.celleditor.AbstractUMLMultiValueCellEditor#getFactory()
	 *
	 * @return
	 */
	@Override
	protected ReferenceValueFactory getFactory() {
		return new UnlimitedNaturalEditionFactory();
	}
}
