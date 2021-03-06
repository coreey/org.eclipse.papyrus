/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
package org.eclipse.papyrus.junit.framework.classification;

import java.lang.annotation.Annotation;

/**
 * Enumerates all available TestCategories
 *
 * @author Camille Letavernier
 *
 */
public enum TestCategory {

	/**
	 * Test methods annotated with {@link NotImplemented}
	 */
	NotImplemented(NotImplemented.class),

	/**
	 * Test methods annotated with {@link InvalidTest}
	 */
	InvalidTest(InvalidTest.class),

	/**
	 * Test methods annotated with {@link FailingTest}
	 */
	FailingTest(FailingTest.class),

	/**
	 * Test methods annotated with {@link InteractiveTest}
	 */
	InteractiveTest(InteractiveTest.class),

	/**
	 * Test methods annotated with {@link GeneratedTest}
	 */
	GeneratedTest(GeneratedTest.class),

	/**
	 * Test methods annotated with {@link ExpensiveTest}
	 */
	ExpensiveTest(ExpensiveTest.class),

	/**
	 * Test methods without any classification-related annotation
	 */
	Standard();

	private Class<? extends Annotation> annotationClass;

	private TestCategory() {
		//Empty constructor for Standard
	}

	private TestCategory(Class<? extends Annotation> annotationClass) {
		this.annotationClass = annotationClass;
	}

	public boolean match(Class<? extends Annotation> annotationClass) {
		return annotationClass == this.annotationClass;
	}

}
