/*****************************************************************************
 * Copyright (c) 2007, 2016, 2021 Borland Software Corporation, CEA LIST, Artal and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * Alexander Shatalin (Borland) - initial API and implementation
 * Michael Golubev (Montages) - #386838 - migrate to Xtend2
 * Florian Noyrit - Initial API and implementation
 * Etienne Allogo (ARTAL) - etienne.allogo@artal.fr - Bug 569174 : 1.4 Merge papyrus extension templates into codegen.xtend
 * Etienne Allogo (ARTAL) - etienne.allogo@artal.fr - Bug 569174 : L1.2 clean up
 *****************************************************************************/
package xpt.editor

import com.google.inject.Inject
import metamodel.MetaModel
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenNode
import org.eclipse.papyrus.gmf.codegen.xtend.annotations.MetaDef
import plugin.Activator
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.updater.DiagramUpdater
import xpt.diagram.updater.Utils_qvto
import xpt.diagram.updater.NodeDescriptor
import xpt.diagram.updater.LinkDescriptor

@com.google.inject.Singleton class DiagramContentInitializer {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;

	@Inject MetaModel xptMetaModel;
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject DiagramUpdater xptDiagramUpdater;
	@Inject Activator xptActivator;
	@Inject NodeDescriptor nodeDescriptor
	@Inject LinkDescriptor linkDescriptor

	def className(GenDiagram it) '''┬źdiagramContentInitializerClassName┬╗'''

	def packageName(GenDiagram it) '''┬źit.editorGen.editor.packageName┬╗'''

	def qualifiedClassName(GenDiagram it) '''┬źpackageName(it)┬╗.┬źclassName(it)┬╗'''

	def fullPath(GenDiagram it) '''┬źqualifiedClassName(it)┬╗'''

	def DiagramContentInitializer(GenDiagram it) '''
		┬źcopyright(getDiagram().editorGen)┬╗
		package ┬źpackageName(it)┬╗;

		┬źgeneratedClassComment┬╗
		public class ┬źclassName(it)┬╗ {

			┬źattributes(it)┬╗

			┬źinitDiagramContent(it)┬╗

			┬źFOR container : getAllContainers().filter[container|!container.sansDomain]┬╗
				┬źcreateChildren(container)┬╗
			┬źENDFOR┬╗

			┬źcreateNode(it)┬╗

			┬źcreateLinks(it)┬╗
			┬źIF getAllContainers().filter(typeof(GenCompartment)).notEmpty┬╗
				┬źgetCompartment(it)┬╗
			┬źENDIF┬╗
		}
	'''

	def attributes(GenDiagram it) '''
			┬źgeneratedMemberComment┬╗
			private java.util.Map myDomain2NotationMap = new java.util.HashMap();

			┬źgeneratedMemberComment┬╗
			private java.util.Collection myLinkDescriptors = new java.util.LinkedList();
	'''

	def initDiagramContent(GenDiagram it) '''
		┬źgeneratedMemberComment┬╗
		public void initDiagramContent(org.eclipse.gmf.runtime.notation.Diagram diagram) {
			if (!┬źVisualIDRegistry::modelID(it)┬╗.equals(diagram.getType())) {
				┬źxptActivator.qualifiedClassName(editorGen.plugin)┬╗.getInstance().logError("Incorrect diagram passed as a parameter: " + diagram.getType());
				return;
			}
			if (┬źxptMetaModel.NotInstance(domainDiagramElement, 'diagram.getElement()')┬╗) {
				┬źxptActivator.qualifiedClassName(editorGen.plugin)┬╗.getInstance().logError("Incorrect diagram element specified: " + diagram.getElement() + " instead of ┬źdomainDiagramElement.
			ecoreClass.name┬╗");
				return;
			}
			┬źcreateChildrenMethodName(it)┬╗(diagram);
			createLinks(diagram);
		}
	'''

	@MetaDef def createChildrenMethodName(GenContainerBase it) '''create┬źit.stringUniqueIdentifier┬╗_Children'''

	def createChildren(GenContainerBase it) '''
		┬źgeneratedMemberComment┬╗
		private void ┬źcreateChildrenMethodName(it)┬╗(org.eclipse.gmf.runtime.notation.View view) {
			┬źcollectContainedLinks(it)┬╗
			┬źIF hasSemanticChildren(it)┬╗
				java.util.Collection childNodeDescriptors = ┬źxptDiagramUpdater.getSemanticChildrenMethodCall(it)┬╗(view);
				for (java.util.Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
					createNode(view, (┬źnodeDescriptor.qualifiedClassName(diagram.editorGen.diagramUpdater)┬╗) it.next());
				}
			┬źENDIF┬╗
			┬źcreateCompartmentsChildren(it)┬╗
		}
	'''

	def dispatch collectContainedLinks(GenContainerBase it) ''''''

	def dispatch collectContainedLinks(GenNode it) '''
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(┬źxptDiagramUpdater.getOutgoingLinksMethodCall(it)┬╗(view));
	'''

	def dispatch createCompartmentsChildren(GenContainerBase it) ''''''

	def dispatch createCompartmentsChildren(GenNode it) '''
		┬źFOR comp : it.compartments┬╗
			┬źcallCreateCompartmentChildren(comp)┬╗
		┬źENDFOR┬╗
	'''

	/**
	 * Will be called for each compartment of GenNode for GenNode.isSansDomain() == false.
	 * if !GenNode.isSansDomain() => !GenCompartment.isSansDomain() so should not check
	 * !this.isSansDomain() here.
	 */
	def callCreateCompartmentChildren(GenCompartment it) '''
		┬źcreateChildrenMethodName(it)┬╗(getCompartment(view, ┬źVisualIDRegistry::visualID(it)┬╗));
	'''

	def createNode(GenDiagram it) '''
		┬źgeneratedMemberComment┬╗
		private void createNode(org.eclipse.gmf.runtime.notation.View parentView, ┬źnodeDescriptor.qualifiedClassName(editorGen.diagramUpdater)┬╗ nodeDescriptor) {
			final String nodeType = ┬źxptVisualIDRegistry.typeMethodCall(it, 'nodeDescriptor.getVisualID()')┬╗;
			org.eclipse.gmf.runtime.notation.Node node = org.eclipse.gmf.runtime.diagram.core.services.ViewService.createNode(parentView, nodeDescriptor.getModelElement(), nodeType, ┬źxptActivator.
			preferenceHintAccess(editorGen)┬╗);
			switch (nodeDescriptor.getVisualID()) {
				┬źFOR n : getAllNodes().filter[node|!node.sansDomain]┬╗
					case ┬źVisualIDRegistry::visualID(n)┬╗:
						┬źcreateChildrenMethodName(n)┬╗(node);
					return;
				┬źENDFOR┬╗		
			}
		}
	'''

	/**
	 * Adopt this code to work with links to links
	 */
	def createLinks(GenDiagram it) '''
		┬źgeneratedMemberComment┬╗
		private void createLinks(org.eclipse.gmf.runtime.notation.Diagram diagram) {
			for (boolean continueLinkCreation = true; continueLinkCreation;) {
				continueLinkCreation = false;
				java.util.Collection additionalDescriptors = new java.util.LinkedList();
				for (java.util.Iterator it = myLinkDescriptors.iterator(); it.hasNext();) {
					┬źlinkDescriptor.qualifiedClassName(editorGen.diagramUpdater)┬╗ nextLinkDescriptor = (┬ź
			linkDescriptor.qualifiedClassName(editorGen.diagramUpdater)┬╗) it.next();
					if (!myDomain2NotationMap.containsKey(nextLinkDescriptor.getSource()) || !myDomain2NotationMap.containsKey(nextLinkDescriptor.getDestination())) {
						continue;
					}
					final String linkType = ┬źxptVisualIDRegistry.typeMethodCall(it, 'nextLinkDescriptor.getVisualID()')┬╗;
					org.eclipse.gmf.runtime.notation.Edge edge = org.eclipse.gmf.runtime.diagram.core.services.ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), diagram, linkType, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true, ┬źxptActivator.
			preferenceHintAccess(editorGen)┬╗);
					if (edge != null) {
						edge.setSource((org.eclipse.gmf.runtime.notation.View) myDomain2NotationMap.get(nextLinkDescriptor.getSource()));
						edge.setTarget((org.eclipse.gmf.runtime.notation.View) myDomain2NotationMap.get(nextLinkDescriptor.getDestination()));
						it.remove();
						if (nextLinkDescriptor.getModelElement() != null) {
							myDomain2NotationMap.put(nextLinkDescriptor.getModelElement(), edge);
						}
						continueLinkCreation = true;
						switch (nextLinkDescriptor.getVisualID()) {
							┬źFOR link : it.links┬╗
								┬źIF link.metaClass !== null┬╗
								case ┬źVisualIDRegistry::visualID(link)┬╗:
								additionalDescriptors.addAll(┬źxptDiagramUpdater.getOutgoingLinksMethodCall(link)┬╗(edge));
								break;
								┬źENDIF┬╗
							┬źENDFOR┬╗		
						}
					}
				}
				myLinkDescriptors.addAll(additionalDescriptors);
			}
		}
	'''

	def getCompartment(GenDiagram it) '''
		┬źgeneratedMemberComment┬╗
		private org.eclipse.gmf.runtime.notation.Node getCompartment(org.eclipse.gmf.runtime.notation.View node, String visualID) {
			String type = ┬źxptVisualIDRegistry.typeMethodCall(it, 'visualID')┬╗;
			for (java.util.Iterator it = node.getChildren().iterator(); it.hasNext();) {
				org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) it.next();
				if (nextView instanceof org.eclipse.gmf.runtime.notation.Node && type.equals(nextView.getType())) {
					return (org.eclipse.gmf.runtime.notation.Node) nextView;
				}
			}
			return null;
		}
	'''
}