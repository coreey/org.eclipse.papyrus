/*****************************************************************************
 * Copyright (c) 2009, 2016 CEA LIST, Christian W. Damus, and others.
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
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Bug 363827 - [Improvement] Diagram creation, remember the latest tab chosen
 *  Vincent Lorenzo (CEA-LIST) Vincent.lorenzo@cea.fr (refactoring of the hyperlink)
 *  Christian W. Damus - bug 488965
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.ui;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.gmf.command.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.helper.HyperLinkHelperFactory;
import org.eclipse.papyrus.infra.hyperlink.ui.AbstractHyperLinkTab;
import org.eclipse.papyrus.infra.hyperlink.ui.HyperLinkManagerShell;
import org.eclipse.papyrus.infra.internationalization.utils.utils.LabelInternationalization;
import org.eclipse.papyrus.infra.ui.editorsfactory.IPageIconsRegistry;
import org.eclipse.swt.widgets.Shell;

/**
 *
 * This hyperlink manager can manage default hyperlinks and creation of diagram with heuristic
 */
public class AdvancedHLManager extends HyperLinkManagerShell {


	/**
	 *
	 * Constructor.
	 *
	 * @param editorFactoryRegistry
	 *            the editor factory registry
	 * @param model
	 *            the model that contains all elements
	 * @param domain
	 *            the domain in order to execute command
	 * @param umlElement
	 *            the uml element linked to the view
	 * @param aview
	 *            the view of the uml element
	 *
	 */
	public AdvancedHLManager(Shell parentShell, IPageIconsRegistry editorFactoryRegistry, TransactionalEditingDomain domain, EModelElement semanticElement, View aview, HyperLinkHelperFactory hyperHelperFactory) {
		super(parentShell, editorFactoryRegistry, domain, semanticElement, aview, hyperHelperFactory);
	}

	/**
	 * this method parse the command to extract created diagram and construct a list of hyperlinkDiagrams
	 *
	 * @param creationcommand
	 *            a gmf command
	 * @return the list of hyperlinks diagram
	 */
	protected ArrayList<HyperLinkEditor> getCreatedHyperlinkDiagramsWithHeuristic(ICommand creationcommand) {
		ArrayList<Diagram> diagrams = new ArrayList<Diagram>();
		if (creationcommand instanceof CompositeCommand) {
			CompositeCommand compositeCommand = (CompositeCommand) creationcommand;
			Object value = compositeCommand.getCommandResult().getReturnValue();
			if (value instanceof ArrayList) {
				diagrams.addAll((Collection<Diagram>) value);
			}
		}
		ArrayList<HyperLinkEditor> hyperLinkDiagrams = new ArrayList<HyperLinkEditor>();
		for (int i = 0; i < diagrams.size(); i++) {
			HyperLinkEditor hyperLinkEditor = new HyperLinkEditor();
			hyperLinkEditor.setObject(diagrams.get(i));
			hyperLinkEditor.setIsDefault(true);
			hyperLinkEditor.setTooltipText(LabelInternationalization.getInstance().getDiagramLabel(diagrams.get(i)));
			hyperLinkDiagrams.add(hyperLinkEditor);
		}
		return hyperLinkDiagrams;
	}

	@Override
	protected void doAction() {
		super.doAction();
		// defaultTab = getDefaultHyperLinkTab();
		final LocalDefaultLinkDiagramTab heuristicTab = getHeuristicTab();
		ArrayList<HyperLinkEditor> defaultdiagramsWithHeuristic = new ArrayList<HyperLinkEditor>();
		// if the default diagrams is opened, get created default diagrams
		if (heuristicTab.getDefaultHyperlinkComposite().isVisible()) {
			heuristicTab.okPressed();
			ICommand creationCommand = heuristicTab.getCommand();
			// TODO : should be chained with the others command
			transactionalEditingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(heuristicTab.getCommand()));
			defaultdiagramsWithHeuristic.addAll(getCreatedHyperlinkDiagramsWithHeuristic(creationCommand));
		}



		// add into the list all diagram create by using heuristic
		for (int i = 0; i < defaultdiagramsWithHeuristic.size(); i++) {
			allhypHyperlinkObjects.add(0, defaultdiagramsWithHeuristic.get(i));
		}

	}

	private LocalDefaultLinkDiagramTab getHeuristicTab() {
		int i = 0;
		LocalDefaultLinkDiagramTab tab = null;
		for (AbstractHyperLinkTab current : getTabs()) {
			if (current instanceof LocalDefaultLinkDiagramTab) {
				tab = (LocalDefaultLinkDiagramTab) current;
				i++;
			}
		}
		Assert.isTrue(i == 1);
		Assert.isNotNull(tab);
		return tab;
	}
}
