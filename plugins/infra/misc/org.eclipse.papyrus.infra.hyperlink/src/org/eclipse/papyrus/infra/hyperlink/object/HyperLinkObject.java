/*****************************************************************************
 * Copyright (c) 2011, 2016 CEA LIST, Christian W. Damus, and others.
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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 488965
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.object;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;


/**
 * This is the Object use to manipulate into hyperlinks
 *
 */
public abstract class HyperLinkObject {

	/**
	 * the associated tool tip
	 */
	protected String tooltipText;

	/** the object that is the target of the hyperlink **/
	protected Object object;

	/**
	 * boolean to known if this hyperlink is a default hyperlink
	 */
	protected boolean isDefault = false;

	/**
	 * @return the associated tooltip
	 */
	public String getTooltipText() {
		return tooltipText;
	}

	/**
	 * set a string that is the associated tool tup
	 *
	 * @param tooltipText
	 */
	public void setTooltipText(String tooltipText) {
		this.tooltipText = tooltipText;
	}

	/**
	 *
	 * @return the object that is the target of the hyperlink
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * set the object that will be the target of the hyperlink
	 *
	 * @param object
	 *            the targeted object
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * set a boolean in order to make this hyperlink as default
	 *
	 * @param isDefault
	 *            true or false
	 */
	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 *
	 * @return true is the hyperlink is default
	 */
	public boolean getIsDefault() {
		return this.isDefault;
	}

	/**
	 * Used to execute an action when the hyperlink object is selected and clicked to be edited
	 *
	 * @param list
	 *            of hyperlink that are containted by a graphical element
	 * @param amodel
	 *            the top package root element
	 * @since 2.0
	 */
	public abstract void executeEditMousePressed(Shell parentShell, List<HyperLinkObject> list, EObject amodel);

	/**
	 * Tells whether openLink() should be called within an EMF command
	 *
	 * @return
	 */
	public abstract boolean needsOpenCommand();

	/**
	 * Opens the current hyperlink.
	 */
	public abstract void openLink();

}
