/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.css.engine;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.ui.css.core.dom.IElementProvider;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSDOMSemanticElementHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.IPapyrusElementProvider;
import org.w3c.dom.Element;

/**
 * Provides an Element for a GMF Notation object.
 *
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public class ElementProviderWrapper implements IPapyrusElementProvider {

	public static final String EXTENSION_POINT = Activator.PLUGIN_ID + ".domElementAdapter";

	private IElementProvider delegate;

	public ElementProviderWrapper(CSSDiagram diagram) {
		this.delegate = getElementProviderFor(diagram);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param element
	 *            A GMF View
	 * @param engine
	 *            An ExtendedCSSEngine
	 */
	@Override
	public Element getElement(Object element, CSSEngine engine) {
		return delegate.getElement(element, engine);
	}

	private List<ICSSElementProviderFactory> getCSSElementProviders() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT);


		// Ordered Factories (Map of Lists to allow equalities)
		SortedMap<Integer, List<ICSSElementProviderFactory>> sortedFactories = new TreeMap<Integer, List<ICSSElementProviderFactory>>();

		for (IConfigurationElement e : config) {
			try {
				final int order = Integer.parseInt(e.getAttribute("order")); //$NON-NLS-1$
				final ICSSElementProviderFactory factory = (ICSSElementProviderFactory) e.createExecutableExtension("factory"); //$NON-NLS-1$

				getFactories(sortedFactories, order).add(factory);
			} catch (Exception ex) {
				Activator.log.error(String.format("Plugin %s contributed an invalid CSS DOM Element Provider Factory", e.getContributor()), ex);
			}
		}

		// SortedMap to List
		List<ICSSElementProviderFactory> factories = new LinkedList<ICSSElementProviderFactory>();
		for (List<ICSSElementProviderFactory> factoriesEntry : sortedFactories.values()) {
			factories.addAll(factoriesEntry);
		}

		return factories;
	}

	private List<ICSSElementProviderFactory> getFactories(Map<Integer, List<ICSSElementProviderFactory>> sortedFactories, int order) {
		if (!sortedFactories.containsKey(order)) {
			sortedFactories.put(order, new LinkedList<ICSSElementProviderFactory>());
		}
		return sortedFactories.get(order);
	}

	private IPapyrusElementProvider getElementProviderFor(CSSDiagram diagram) {
		for (ICSSElementProviderFactory providerFactory : getCSSElementProviders()) {
			if (providerFactory.isProviderFor(diagram)) {
				return providerFactory.createProvider(diagram);
			}
		}

		return new GMFElementProvider();
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.provider.IPapyrusElementProvider#getPrimaryView(org.eclipse.emf.ecore.EObject)
	 *
	 * @param notationElement
	 * @return
	 */
	@Override
	public View getPrimaryView(EObject notationElement) {

		View canonicalNotationElement = null;
		if (delegate instanceof IPapyrusElementProvider) {
			canonicalNotationElement = ((IPapyrusElementProvider) delegate).getPrimaryView(notationElement);
		} else {
			canonicalNotationElement = CSSDOMSemanticElementHelper.getInstance().findPrimaryView(notationElement);

		}
		return canonicalNotationElement;
	}

}
