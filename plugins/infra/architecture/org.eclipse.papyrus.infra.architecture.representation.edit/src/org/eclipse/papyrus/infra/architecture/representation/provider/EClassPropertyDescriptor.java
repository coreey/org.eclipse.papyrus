/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  Maged Elaasar - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.architecture.representation.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.core.architecture.provider.SurrogateItemPropertyDescriptor;

/**
 * Represents a descriptor for properties of type EClass
 *
 * @author Laurent Wouters
 */
public class EClassPropertyDescriptor extends SurrogateItemPropertyDescriptor {
	private static final Collection<EObject> empty = new ArrayList<>();

	/**
	 * Constructor.
	 *
	 * @param inner
	 */
	public EClassPropertyDescriptor(IItemPropertyDescriptor inner) {
		super(inner);
	}

	/**
	 * @see org.eclipse.papyrus.infra.architecture.representation.provider.SurrogateItemPropertyDescriptor#getChoiceOfValues(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public Collection<?> getChoiceOfValues(Object object) {
		EObject current = (EObject) object;
		while (current != null && !(current instanceof ArchitectureDescriptionLanguage)) {
			current = current.eContainer();
		}
		if (current == null) {
			return empty;
		}
		ArchitectureDescriptionLanguage conf = (ArchitectureDescriptionLanguage) current;
		List<EClass> result = new ArrayList<>();
		EPackage p = conf.getMetamodel();
		if (p == null) {
			return result;
		}
		for (EClassifier c : p.getEClassifiers()) {
			if (c instanceof EClass) {
				result.add((EClass) c);
			}
		}
		return result;
	}
}
