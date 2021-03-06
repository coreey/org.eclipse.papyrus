/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
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
 *   Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr
 *   Christian W. Damus (CEA) - bug 392301
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.internationalization.utils.utils.LabelInternationalization;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditor;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.osgi.framework.ServiceException;


/**
 * The Class UmlDeploymentDiagramForMultiEditor.
 */
public class UmlDeploymentDiagramForMultiEditor extends UMLDiagramEditor {

	/** The location of diagram icon in the plug-in. */
	private static final String DIAG_IMG_PATH = "icons/obj16/DeploymentDiagram.gif";

	/** The image descriptor of the diagram icon. */
	private static final ImageDescriptor DIAG_IMG_DESC = UMLDiagramEditorPlugin.getBundledImageDescriptor(UmlDeploymentDiagramForMultiEditor.DIAG_IMG_PATH);

	/** The editor splitter. */
	private Composite splitter;

	private Image titleImage;

	/**
	 * Constructor for SashSystem v2. Context and required objects are retrieved from the ServiceRegistry.
	 *
	 * @param servicesRegistry
	 *            the services registry
	 * @param diagram
	 *            the diagram
	 * @throws BackboneException
	 *             the backbone exception
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceException
	 *             the service exception
	 */
	public UmlDeploymentDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException, ServiceException, org.eclipse.papyrus.infra.core.services.ServiceException {
		super(servicesRegistry, diagram);
	}

	/**
	 * Inits the.
	 *
	 * @param site
	 *            the site
	 * @param input
	 *            the input
	 * @throws PartInitException
	 *             the part init exception
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		setPartName(LabelInternationalization.getInstance().getDiagramLabel(getDiagram()));
		titleImage = DIAG_IMG_DESC.createImage();
		setTitleImage(titleImage);
	}

	@Override
	public void dispose() {
		if (titleImage != null) {
			titleImage.dispose();
			titleImage = null;
		}

		super.dispose();
	}

	/**
	 * Sets the input.
	 *
	 * @param input
	 *            the new input
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#setInput(org.eclipse.ui.IEditorInput)
	 */

	@Override
	public void setInput(IEditorInput input) {
		try {
			// Provide an URI with fragment in order to reuse the same Resource
			// and set the diagram to the fragment.
			URIEditorInput uriInput = new URIEditorInput(EcoreUtil.getURI(getDiagram()));
			doSetInput(uriInput, true);
		} catch (CoreException x) {
			String title = "Problem opening";
			String msg = "Cannot open input element:";
			Shell shell = getSite().getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
		}
	}

	/**
	 * Creates the graphical viewer.
	 *
	 * @param parent
	 *            the parent
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#createGraphicalViewer(org.eclipse.swt.widgets.Composite)
	 */

	@Override
	protected void createGraphicalViewer(Composite parent) {
		splitter = parent;
		super.createGraphicalViewer(parent);
	}

	/**
	 * Sets the focus.
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette#setFocus()
	 */

	@Override
	public void setFocus() {
		splitter.setFocus();
		super.setFocus();
	}

	/**
	 * Gets the editing domain id.
	 *
	 * @return the editing domain id
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#getEditingDomainID()
	 */

	@Override
	public String getEditingDomainID() {
		return "org.eclipse.papyrus.uml.diagram.deployment.EditingDomain";
	}
}
