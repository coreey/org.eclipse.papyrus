/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
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
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.toolsmiths.modelelement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.views.properties.toolsmiths.modelelement.GenericAttributeModelElement;
import org.eclipse.papyrus.infra.constraints.ConfigProperty;
import org.eclipse.papyrus.infra.constraints.ConstraintsFactory;
import org.eclipse.papyrus.infra.constraints.ConstraintsPackage;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.properties.contexts.DataContextElement;
import org.eclipse.papyrus.infra.properties.ui.modelelement.AbstractModelElementFactory;
import org.eclipse.papyrus.views.properties.toolsmiths.Activator;

/**
 * A ModelElementFactory for handling {@link ConfigProperty} properties
 *
 * @author Camille Letavernier
 */
public class GenericPropertyModelElementFactory extends AbstractModelElementFactory<GenericAttributeModelElement> {

	// Source : Group
	// context : Custom:Attribute:Group
	@Override
	protected GenericAttributeModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {

		EObject source = EMFHelper.getEObject(sourceElement);
		if (source == null) {
			Activator.log.warn("Unable to resolve the source element to an EObject"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);

		EClass valueProperty = ConstraintsPackage.eINSTANCE.getValueProperty();
		EClass referenceProperty = ConstraintsPackage.eINSTANCE.getReferenceProperty();
		EStructuralFeature attributes = ConstraintsPackage.eINSTANCE.getSimpleConstraint_Properties();

		return new GenericAttributeModelElement(source, domain, attributes, ConstraintsFactory.eINSTANCE, valueProperty, referenceProperty);
	}

	// public List<ModelElement> createFromDataSource(ModelElement currentElement, DataSource source, String propertyPath, DataContextElement context) {
	// throw new UnsupportedOperationException();
	// }

	@Override
	protected void updateModelElement(GenericAttributeModelElement modelElement, Object newSourceElement) {
		EObject eObject = EMFHelper.getEObject(newSourceElement);
		if (eObject == null) {
			throw new IllegalArgumentException("Cannot resolve EObject selection: " + newSourceElement);
		}
		modelElement.source = eObject;
		modelElement.domain = EMFHelper.resolveEditingDomain(eObject);
	}
}
