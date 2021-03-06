/*****************************************************************************
 * Copyright (c) 2013, 2017, 2020 CEA LIST.
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
 *  Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 515737
 *  Vincent Lorenzo (CEA LIST) - bug 517617, 532452
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

/**
 * Common methods for axis management
 *
 * @author Vincent Lorenzo
 *
 */
public class AxisUtils {

	private AxisUtils() {
		// to prevent instanciation
	}

	/**
	 * This regex allows to find all word character (letters + numbers)+ the whitespace
	 */
	public static final String REGEX = "[^\\w\\s]"; //$NON-NLS-1$

	/**
	 * This methods avoid to duplicate these some lines
	 *
	 * @param axisElement
	 *            an axis element
	 * @return
	 *         if the axis element is a String returns it and if the axis element is an instance of IdAxis, returns the String represented by this
	 *         axis
	 */
	public static final String getPropertyId(final Object axisElement) {
		String id = null;
		if (axisElement instanceof IdAxis) {
			id = ((IdAxis) axisElement).getElement();
		} else if (axisElement instanceof String) {
			id = (String) axisElement;
		}
		return id;
	}

	/**
	 *
	 * @param axisElement
	 *            an axis element
	 * @return
	 *         if axisElement is an IAxis, we return the element represented by the IAxis using IAxis.getElement() else we return the element itself
	 */
	public static final Object getRepresentedElement(final Object axisElement) {
		Object representedElement;
		if (axisElement instanceof IAxis) {
			representedElement = ((IAxis) axisElement).getElement();
		} else {
			representedElement = axisElement;
		}
		return representedElement;
	}

	/**
	 *
	 * @param table
	 *            a table
	 * @return
	 *         the axismanager used for rows, managing the invert axis
	 */
	public static final AbstractAxisProvider getAxisProviderUsedForRows(final Table table) {
		AbstractAxisProvider provider = table.getCurrentRowAxisProvider();
		if (table.isInvertAxis()) {
			provider = table.getCurrentColumnAxisProvider();
		}
		return provider;
	}

	/**
	 *
	 * @param table
	 *            a table
	 * @return
	 *         the axismanager used for columns, managing the invert axis
	 */
	public static final AbstractAxisProvider getAxisProviderUsedForColumns(final Table table) {
		AbstractAxisProvider provider = table.getCurrentColumnAxisProvider();
		if (table.isInvertAxis()) {
			provider = table.getCurrentRowAxisProvider();
		}
		return provider;
	}

	/**
	 *
	 * @param manager
	 *            a table manager
	 * @return
	 *         the axismanager used for rows, managing the invert axis
	 */
	public static final AbstractAxisProvider getAxisProviderUsedForRows(final INattableModelManager manager) {
		return getAxisProviderUsedForRows(manager.getTable());
	}

	/**
	 *
	 * @param manager
	 *            a table manager
	 * @return
	 *         the axismanager used for columns, managing the invert axis
	 */
	public static final AbstractAxisProvider getAxisProviderUsedForColumns(final INattableModelManager manager) {
		return getAxisProviderUsedForColumns(manager.getTable());
	}

	/**
	 * Return the index of the unique selected axis (column or row).
	 * If not only 1 axis is selected, return -1.
	 *
	 * @param nattableManager
	 *            The nattable manager
	 * @return The index of the unique selected axis or -1 otherwise
	 * @since 5.0
	 */
	public static int getUniqueSelectedAxisIndex(final INattableModelManager nattableManager) {

		int axisIndex = -1;

		if (null != nattableManager) {
			final TableSelectionWrapper tableSelectionWrapper = nattableManager.getAdapter(TableSelectionWrapper.class);
			if (null != tableSelectionWrapper && null != nattableManager.getTable()) {
				final Table table = nattableManager.getTable();

				// If the table is already inverted, handle with the number of fully selected rows
				// otherwise, handle with the number of fully selected columns
				if (table.isInvertAxis()) {
					if (tableSelectionWrapper.getFullySelectedRows().size() == 1) {
						int axisPosition = (int) tableSelectionWrapper.getFullySelectedRows().keySet().toArray()[0];
						axisIndex = nattableManager.getBodyLayerStack().getSelectionLayer().getRowIndexByPosition(axisPosition);
					}
				} else if (tableSelectionWrapper.getFullySelectedColumns().size() == 1) {
					int axisPosition = (int) tableSelectionWrapper.getFullySelectedColumns().keySet().toArray()[0];
					axisIndex = nattableManager.getBodyLayerStack().getSelectionLayer().getColumnIndexByPosition(axisPosition);
				}
			}
		}

		return axisIndex;
	}
}
