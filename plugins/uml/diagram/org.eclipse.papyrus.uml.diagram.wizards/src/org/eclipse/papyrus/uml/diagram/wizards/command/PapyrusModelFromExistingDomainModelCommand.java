/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - create model by URI, not IFile (CDO)
 *  Christian W. Damus (CEA) - Support creating models in repositories (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.command;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.uml.tools.model.UmlModel;

/**
 * The command to initialize Papyrus diagram for a given domain model.
 */
public class PapyrusModelFromExistingDomainModelCommand extends RecordingCommand {

	/** The my di resource set. */
	private final ModelSet myDiResourceSet;

	/** The new model URI, without extension. */
	private final URI myURIWithoutExtension;

	/** The my root. */
	private final EObject myRoot;

	/**
	 * Instantiates a new papyrus model from existing domain model command.
	 *
	 * @param diResourceSet
	 *            the di resource set
	 * @param newURI
	 *            the URI of the new model's principal resource
	 * @param root
	 *            the root
	 */
	public PapyrusModelFromExistingDomainModelCommand(ModelSet modelSet, URI newURI, EObject root) {
		super(modelSet.getTransactionalEditingDomain());
		myDiResourceSet = modelSet;
		myURIWithoutExtension = newURI.trimFileExtension();
		// Bug 339504 - [Wizard] NPE when init diagram from an existing model
		modelSet.getInternal().setPrimaryModelResourceURI(newURI);
		myRoot = root;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		IModel model = myDiResourceSet.getModel(SashModel.MODEL_ID);
		model.createModel(myURIWithoutExtension);
		model = myDiResourceSet.getModel(DiModel.DI_MODEL_ID);
		model.createModel(myURIWithoutExtension);
		model = myDiResourceSet.getModel(NotationModel.MODEL_ID);
		model.createModel(myURIWithoutExtension);
		// START OF WORKAROUND for #315083
		IModel umlModel = new UmlModel() {

			@Override
			public void createModel(URI uri) {
				try {
					URI rootURI = myURIWithoutExtension.trimSegments(1);
					resourceURI = rootURI.appendSegment(myRoot.eResource().getURI().lastSegment());

					// as resource already exists, use rs.getResource() not rs.createResource() here
					try {
						resource = getResourceSet().getResource(resourceURI, true);
					} catch (WrappedException e) {
						if (ModelUtils.isDegradedModeAllowed(e.getCause())) {
							// in this case Papyrus can work in degraded mode
							resource = getResourceSet().getResource(resourceURI, false);
							if (resource == null) {
								throw e;
							}
						} else {
							throw e;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		};
		myDiResourceSet.getInternal().registerModel(umlModel, true);
		umlModel.createModel((URI) null);
		// // call snippets to allow them to do their stuff
		// snippets.performStart(this);
		// END OF WORKAROUND for #315083
	}
}
