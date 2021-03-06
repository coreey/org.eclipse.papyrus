/*****************************************************************************
 * Copyright (c) 2009, 2018 Atos Origin, Christian W. Damus, CEA LIST, and others.
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
 *   Atos Origin - Initial API and implementation
 *   Christian W. Damus - bug 536486
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.uml.diagram.sequence.expressions.UMLOCLFactory;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_Interaction_Shape(Interaction instance) {
		try {
			Object value_0 = name_Interaction_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_ConsiderIgnoreFragment_Shape(ConsiderIgnoreFragment instance) {
		try {
			Object value_0 = name_ConsiderIgnoreFragment_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_CombinedFragment_Shape(CombinedFragment instance) {
		try {
			Object value_0 = name_CombinedFragment_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_InteractionUse_Shape(InteractionUse instance) {
		try {
			Object value_0 = name_InteractionUse_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_Continuation_Shape(Continuation instance) {
		try {
			Object value_0 = name_Continuation_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_Lifeline_Shape(Lifeline instance) {
		try {
			Object value_0 = name_Lifeline_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_StateInvariant_Shape(StateInvariant instance) {
		try {
			Object value_0 = name_StateInvariant_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_DestructionOccurrenceSpecification_Shape(DestructionOccurrenceSpecification instance) {
		try {
			Object value_0 = name_DestructionOccurrenceSpecification_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_Shape(Constraint instance) {
		try {
			LiteralString newInstance_0_0 = UMLFactory.eINSTANCE.createLiteralString();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = value_specification_Constraint_Shape(newInstance_0_0);
			if (value_0_0_0 != null) {
				newInstance_0_0.setValue((String) value_0_0_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_Shape(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getComment(), null).evaluate(instance);
			if (value_0 != null) {
				instance.setBody((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeConstraint_Shape(TimeConstraint instance) {
		try {
			Object value_0 = name_TimeConstraint_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeObservation_Shape(TimeObservation instance) {
		try {
			Object value_0 = name_TimeObservation_Shape(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_GeneralOrdering_Edge(GeneralOrdering instance) {
		try {
			Object value_0 = name_GeneralOrdering_Edge(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationConstraint_Edge(DurationConstraint instance) {
		try {
			Object value_0 = name_DurationConstraint_Edge(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationObservation_Edge(DurationObservation instance) {
		try {
			Object value_0 = name_DurationObservation_Edge(instance);
			if (value_0 != null) {
				instance.setName((String) value_0);
			}
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String name_Interaction_Shape(Interaction it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_ConsiderIgnoreFragment_Shape(ConsiderIgnoreFragment it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_CombinedFragment_Shape(CombinedFragment it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_InteractionUse_Shape(InteractionUse it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_Continuation_Shape(Continuation it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_Lifeline_Shape(Lifeline it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_StateInvariant_Shape(StateInvariant it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_DestructionOccurrenceSpecification_Shape(DestructionOccurrenceSpecification it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String value_specification_Constraint_Shape(LiteralString it) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String name_TimeConstraint_Shape(TimeConstraint it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_TimeObservation_Shape(TimeObservation it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_GeneralOrdering_Edge(GeneralOrdering it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_DurationConstraint_Edge(DurationConstraint it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String name_DurationObservation_Edge(DurationObservation it) {
		return getNamedElement(it, "", it.eClass().getName(), ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = UMLDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			UMLDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}

	/**
	 * @generated NOT
	 *            Initialize the name of a namedElement
	 *
	 * @param namedElement
	 *            the namedElement
	 */
	public static void init_NamedElement(NamedElement namedElement) {
		init_NamedElement(namedElement, ""); //$NON-NLS-1$
	}

	/**
	 * @generated NOT
	 *            Initialize the name of a namedElement with a given prefix
	 *
	 * @param namedElement
	 *            the namedElement
	 * @param prefix
	 *            a prefix for the name
	 */
	public static void init_NamedElement(NamedElement namedElement, String prefix) {
		init_NamedElement(namedElement, prefix, namedElement.eClass().getName(), "");
	}

	/**
	 * @generated NOT
	 *            Initialize the name of a namedElement with a given suffix
	 *
	 * @param namedElement
	 *            the namedElement
	 * @param prefix
	 *            the prefix for the name
	 * @param suffix
	 *            a suffix for the name
	 */
	public static void init_NamedElement(NamedElement namedElement, String prefix, String suffix) {
		init_NamedElement(namedElement, prefix, namedElement.eClass().getName(), suffix);
	}

	/**
	 * @generated NOT
	 *            Initialize the name of a namedElement with a given suffix
	 *
	 * @param namedElement
	 *            the namedElement
	 * @param prefix
	 *            the prefix for the name
	 * @param body
	 *            the body used for the name
	 * @param suffix
	 *            a suffix for the name
	 */
	public static void init_NamedElement(NamedElement namedElement, String prefix, String body, String suffix) {
		try {
			namedElement.setName(getNamedElement(namedElement, prefix, body, suffix));
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated NOT
	 *
	 */
	private static String getNamedElement(NamedElement namedElement, String prefix, String body, String suffix) {
		String base = prefix + body + suffix;
		Namespace namespace = namedElement.getNamespace();
		if (namespace != null) {
			Set<NamedElement> members = new HashSet<>();
			members.addAll(namespace.getMembers());
			// add general orderings which are not in initial selection
			if (namespace instanceof Interaction) {
				members.addAll(((Interaction) namespace).getGeneralOrderings());
			}
			return getNextNumberedName(members, base);
		}
		return base;
	}

	@SuppressWarnings("rawtypes")
	public static String getNextNumberedName(Collection currentElements, String base) {
		int nextNumber = -1;
		Set<String> elementNames = new HashSet<>();
		for (Object o : currentElements) {
			if (o instanceof NamedElement) {
				String name = ((NamedElement) o).getName();
				if (name != null && name.startsWith(base)) {
					elementNames.add(name);
					String end = name.substring(base.length());
					int nextNumberTmp = -1;
					if (end.trim().equals("")) {
						nextNumberTmp = 0;
					} else {
						try {
							nextNumberTmp = Integer.parseInt(end) + 1;
						} catch (NumberFormatException ex) {
							nextNumberTmp = -1;
						}
					}
					if (nextNumberTmp > nextNumber) {
						nextNumber = nextNumberTmp;
					}
				}
			}
		}
		if (nextNumber == -1) {
			return generateUniqueName(base, elementNames, base, nextNumber);
		} else {
			return generateUniqueName(base + nextNumber, elementNames, base, nextNumber);
		}
	}

	private static String generateUniqueName(String name, Set<String> elementNames, String base, int nextNumber) {
		while (elementNames.contains(name)) {
			nextNumber++;
			name = base + nextNumber;
		}
		return name;
	}
}
