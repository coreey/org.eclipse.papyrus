/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.wizard.pages;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 *
 * @author Vincent Lorenzo
 *
 */
public class ImportInvertedTableErrorPage extends WizardPage {

	/**
	 *
	 * Constructor.
	 *
	 * @param pageName
	 *            the page name
	 * @param title
	 *            the title of the page
	 * @param titleImage
	 *            the image of the page
	 */
	public ImportInvertedTableErrorPage(final String pageName, final String title, final ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	/**
	 * Create contents of the wizard.
	 *
	 * @param parent
	 */
	@Override
	public void createControl(final Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Inverted Table are not yet managed"); //$NON-NLS-1$
		setControl(label);
	}

	/**
	 *
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 *
	 * @return
	 */
	@Override
	public boolean isPageComplete() {
		return false;
	}

}
