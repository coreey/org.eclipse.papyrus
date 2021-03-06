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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.providers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

public class AttributeMatchLabelProvider implements IFilteredLabelProvider {

	public Image getImage(Object element) {
		if (element instanceof AttributeMatch) {
			LabelProviderService service = new LabelProviderServiceImpl();
			try {
				service.startService();
				return service.getLabelProvider().getImage(((AttributeMatch) element).getMetaAttribute());
			} catch (ServiceException e) {
				Activator.log.warn(Messages.AttributeMatchLabelProvider_0 + ((AttributeMatch) element).getMetaAttribute());
			}
		}
		return null;
	}

	private String printResult(String value, int offset, int length, String attributeName) {
		return "\"" + value.substring(offset, offset + length) + "\"" + Messages.AttributeMatchLabelProvider_3 + "\"" + value + "\" [" + (offset + 1) + "," + (offset + length) + "] (" + attributeName + Messages.AttributeMatchLabelProvider_8 + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
	}

	public String getText(Object element) {

		if (element instanceof AttributeMatch) {
			AttributeMatch attributeMatch = ((AttributeMatch) element);
			if ((attributeMatch).getSource() instanceof EObject) {
				EObject target = (EObject) attributeMatch.getSource();
				if (attributeMatch.getMetaAttribute() instanceof EAttribute) {
					EAttribute source = (EAttribute) attributeMatch.getMetaAttribute();
					if (target.eGet(source) instanceof String) {
						String value = (String) target.eGet(source);
						return printResult(value, attributeMatch.getOffset(), attributeMatch.getLength(), source.getName());
					} else {
						String value = String.valueOf(target.eGet(source));
						return printResult(value, attributeMatch.getOffset(), attributeMatch.getLength(), source.getName());
					}
				} else if (attributeMatch.getMetaAttribute() instanceof Property) {

					Property source = (Property) attributeMatch.getMetaAttribute();
					Class containingClass = source.getClass_();
					if (containingClass instanceof Stereotype) {
						if (target instanceof Element) {
							String value = StereotypeUtil.displayPropertyValueOnly((Stereotype) containingClass, (Property) attributeMatch.getMetaAttribute(), (Element) target, "");
							return printResult(value, attributeMatch.getOffset(), attributeMatch.getLength(), source.getName());
						}
					}
				}
			}
		}

		return ""; //$NON-NLS-1$

	}

	public void addListener(ILabelProviderListener listener) {

	}

	public void dispose() {

	}

	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	public void removeListener(ILabelProviderListener listener) {

	}

	public boolean accept(Object element) {
		if (element instanceof AttributeMatch) {
			return true;

		}
		return false;
	}

	private String getStringValueOfProperty(Element element, Stereotype stereotype, Property property) {
		Object value = element.getValue(stereotype, property.getName());
		if (value instanceof String) {
			return (String) value;
		} else if (value instanceof EnumerationLiteral) {
			return ((EnumerationLiteral) value).getName();
		} else {
			return String.valueOf(value);
		}
	}
	
	private String getStringValue(Object value) {
		if (value == null) {
			return "";
		}
		
		if (value instanceof String) { // Primitive types will hit this case
			return (String) value;
		} else if (value instanceof EnumerationLiteral) {
			return ((EnumerationLiteral) value).getName();
		} else if (value instanceof NamedElement) {
			return ((NamedElement) value).getName();
		} else if (value instanceof EObject) { // Ref to an element in a model
			Element baseElement = UMLUtil.getBaseElement((EObject) value);
			return getStringValue(baseElement);
		} else {
			return String.valueOf(value);
		}
	}
	
	private EList<String> getStringValuesOfProperty(Element element, Stereotype stereotype, Property property) {
		BasicEList<String> results = new BasicEList<String>();
		
		Object values = element.getValue(stereotype, property.getName());
		if (values instanceof EList) {
			for (Object val : (EList) values) {
				results.add(getStringValue(val));
			}
		} else {
			results.add(getStringValue(values));
		}
		
		return results;
	}

}
