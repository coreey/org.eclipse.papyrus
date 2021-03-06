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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.predicates;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Predicate;

/**
 * Same as {@link EcoreUtil#filterDescendants(java.util.Collection)}
 *
 * @author arthur daussy
 *
 */
public class DescendantsFilter implements Predicate<EObject> {

	private Iterable<? extends EObject> initialCollection;

	public DescendantsFilter(Iterable<? extends EObject> initialCollection) {
		super();
		this.initialCollection = initialCollection;
	}

	@Override
	public boolean apply(EObject input) {
		for (EObject target : initialCollection) {
			if (target == input) {
				continue;
			}
			if (EcoreUtil.isAncestor(input, target)) {
				return false;
			}
		}
		return true;
	}
}
