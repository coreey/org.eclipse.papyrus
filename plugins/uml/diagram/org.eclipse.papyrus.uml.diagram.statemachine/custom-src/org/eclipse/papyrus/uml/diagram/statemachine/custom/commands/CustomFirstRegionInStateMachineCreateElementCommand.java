/**
 * Copyright (c) 2014, 2020 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) - vincent.lorenzo@cea.fr - bug 561512
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.adapter.SemanticAdapter;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Create a region.
 * TODO: Differences with generated RegionCreateCommand ? (is the latter used?)
 */
public class CustomFirstRegionInStateMachineCreateElementCommand extends AbstractTransactionalCommand {
	IAdaptable adaptable;
	IAdaptable adaptableForDropped = null;
	PreferencesHint prefHints;
	CreateViewRequest.ViewDescriptor viewDescriptor;
	CreateElementRequest createElementRequest;
	String dropLocation = Zone.NONE;

	public CustomFirstRegionInStateMachineCreateElementCommand(IAdaptable adaptable, IAdaptable adaptableForDropped, PreferencesHint prefHints, TransactionalEditingDomain domain, String label, String dropLocation) {
		super(domain, label, null);
		this.adaptable = adaptable;
		this.adaptableForDropped = adaptableForDropped;
		this.prefHints = prefHints;
		viewDescriptor = new ViewDescriptor(adaptable, prefHints);
		// make sure the return object is available even before
		// executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
		this.dropLocation = dropLocation;
	}

	/**
	 * TODO : useless since 3.2.200
	 */
	@Deprecated
	protected void doConfigure(Region newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = createElementRequest.getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(createElementRequest.getClientContext());
		configureRequest.addParameters(createElementRequest.getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// adapt the view at execution time
		View ownerView = adaptable.getAdapter(View.class);
		Node compartment = (Node) ownerView.getChildren().get(1);
		// get state bounds
		int height = Zone.getHeight(ownerView);
		int width = Zone.getWidth(ownerView);
		if (height < Zone.defaultHeight) {
			height = Zone.defaultHeight;
			Zone.setHeight(ownerView, height);
		}
		if (width < Zone.defaultWidth) {
			width = Zone.defaultWidth;
			Zone.setWidth(ownerView, width);
		}
		if (adaptableForDropped == null) {
			final State umlState = (State) ownerView.getElement();
			final CreateElementRequest request = new CreateElementRequest(umlState, org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.REGION, UMLPackage.eINSTANCE.getState_Region());
			final IElementEditService service = ElementEditServiceUtils.getCommandProvider(umlState);
			final ICommand cmd = service.getEditCommand(request);
			cmd.execute(new NullProgressMonitor(), null);
			adaptableForDropped = new SemanticAdapter(request.getNewElement(), null);
		}
		// create a view for the new region on the stateMachineCompartment
		String semanticHint = ((IHintedType) UMLElementTypes.Region_Shape).getSemanticHint();
		Node newRegion = ViewService.getInstance().createNode(adaptableForDropped, compartment, semanticHint, -1, prefHints);
		// add region specific annotation
		Zone.createRegionDefaultAnnotation(newRegion);
		// adjust bounds and zone
		LayoutConstraint lc = compartment.getLayoutConstraint();
		if (lc instanceof Bounds) {
			Bounds bounds = (Bounds) lc;
			Zone.setWidth(newRegion, bounds.getWidth());
			Zone.setHeight(newRegion, bounds.getHeight());
		}
		viewDescriptor.setView(newRegion);
		return CommandResult.newOKCommandResult(viewDescriptor);
	}
}
