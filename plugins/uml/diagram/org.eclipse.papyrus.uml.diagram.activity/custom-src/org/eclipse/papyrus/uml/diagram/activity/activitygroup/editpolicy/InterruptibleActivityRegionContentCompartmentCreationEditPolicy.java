/*****************************************************************************
 * Copyright (c) 2011 Atos.
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
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy;

import org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor;

/**
 * Handle creation in interruptible activity region content compartment
 *
 * @author adaussy
 *
 */
public class InterruptibleActivityRegionContentCompartmentCreationEditPolicy extends GroupCreationEditPolicy {

	public InterruptibleActivityRegionContentCompartmentCreationEditPolicy(IContainerNodeDescriptor groupDescriptor) {
		super(groupDescriptor);
	}
}
