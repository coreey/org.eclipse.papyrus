/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal.query;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementationFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;
import org.osgi.framework.Bundle;

public class IntegerLiteralQueryImplementationFactory implements IQueryImplementationFactory {

	public EClass getManagedQueryType() {
		return QueryPackage.eINSTANCE.getIntegerLiteralQuery();
	}

	public IQueryImplementation create(final Query query, final Bundle queryBundle, final IDerivedTypedElementManager manager) throws DerivedTypedElementException {
		final IntegerLiteralQueryImplementation evaluator = new IntegerLiteralQueryImplementation();
		evaluator.setCheckResultType(true);
		return evaluator;
	}
}
