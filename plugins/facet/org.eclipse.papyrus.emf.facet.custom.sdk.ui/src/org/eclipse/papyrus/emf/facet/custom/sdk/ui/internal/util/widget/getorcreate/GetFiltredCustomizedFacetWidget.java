/**
 * Copyright (c) 2012 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetSetCatalogManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.util.emf.ui.util.EditingUtil;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget extends {@link AbstractGetOrCreateFilteredElementCommandWidget} and allow
 * the selection of a {@link Facet} that the Customization will customize. It
 * displays a selection window with a textfield to filter the element in the
 * selection window. Extending {@link AbstractGetOrCreateFilteredElementCommandWidget},
 * a [New...] button can be displayed. Here, no button is displayed because we
 * only select the extended facet into the existing facet.
 * <p/>
 *
 * The selection window will be full up with the customization properties returned by {@link IFacetSetCatalogManager}.
 */
public class GetFiltredCustomizedFacetWidget extends
		AbstractGetOrCreateFilteredElementCommandWidget<Facet, Object> {

	protected static final String TMP_NAME = Activator.getDefault()
			.getBundle().getSymbolicName()
			+ ".tmp"; //$NON-NLS-1$
	public static final File DEFAULT_FILE = new File(Platform
			.getStateLocation(Activator.getDefault().getBundle()).toOSString(),
			GetFiltredCustomizedFacetWidget.TMP_NAME);

	private final IFacetSetCatalogManager facetSetCatMan;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the map of properties of the parent.
	 */
	public GetFiltredCustomizedFacetWidget(final Composite parent) {
		super(parent);
		this.facetSetCatMan = IFacetSetCatalogManagerFactory.DEFAULT
				.getOrCreateFacetSetCatalogManager(EditingUtil
						.createDefaultResource(
								GetFiltredCustomizedFacetWidget.DEFAULT_FILE)
						.getResourceSet());
	}

	@Override
	protected Map<String, Facet> getElements() {
		final Map<String, Facet> allFacets = new HashMap<String, Facet>();
		final Collection<FacetSet> facetSets = this.facetSetCatMan
				.getRegisteredFacetSets();
		for (final FacetSet facetSet : facetSets) {
			for (final EClassifier eClassifier : facetSet.getEClassifiers()) {
				if ((eClassifier instanceof Facet)
						&& (eClassifier.getName() != null)) {
					allFacets.put(eClassifier.getName(), (Facet) eClassifier);
				}
			}
		}
		return allFacets;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public Command getCommand() {
		// Here, this widget only return a selected element so, no command is
		// returned.
		return null;
	}

	@Override
	protected IDialog<Object> createDialog() {
		// No "New..." button.
		return null;
	}


	@Override
	public void onDialogValidation() {
		// Nothing.
	}

	/**
	 * @return
	 */
	public Facet getFacetSelected() {
		return getElementSelected();
	}

}
