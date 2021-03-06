/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.util.Collection;

import org.eclipse.papyrus.uml.internationalization.utils.utils.UMLLabelInternationalization;
import org.eclipse.uml2.uml.Parameter;

/**
 * Utility class for <code>org.eclipse.uml2.uml.Parameter</code><BR>
 */
public class ParameterUtil {

	/**
	 * Returns the modifier of the property, separated by a comma, as as single line if <code>multiline</code> is <code>false</code> or as a multiline
	 * string if <code>multiline</code> is <code>false</code>.
	 *
	 * @param multiLine
	 *            boolean that indicates if the string should have several lines when set to <code>true</code> or only one line when set to <code>false</code>.
	 *
	 * @return a string giving all modifiers for the property
	 */
	public static String getModifiersAsString(Parameter parameter, boolean multiLine) {
		StringBuffer buffer = new StringBuffer();
		boolean needsComma = false;
		String NL = (multiLine) ? "\n" : " ";

		// Return parameter modifiers
		if (parameter.isOrdered()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "ordered");
			;
		}
		if (parameter.isUnique()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "unique");
		}
		if (parameter.isException()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "exception");
		}
		if (parameter.isStream()) {
			needsComma = updateModifiersString(buffer, needsComma, NL, "stream");
		}

		if (!buffer.toString().equals("")) {
			buffer.insert(0, "{");
			buffer.append("}");
		}

		return buffer.toString();
	}

	/**
	 * Update the modifiers string
	 *
	 * @param buffer
	 *            the existing bufferString to append
	 * @param needsComma
	 *            if it needs coma
	 * @param NL
	 *            if it is multiline
	 * @param message
	 *            the message top
	 * @return true because the modifier string is no more empty
	 */
	private static boolean updateModifiersString(StringBuffer buffer, boolean needsComma, String NL, String message) {
		if (needsComma) {
			buffer.append(",");
			buffer.append(NL);
		}
		buffer.append(message);
		return true;
	}

	/**
	 * return the full label of the Parameter.
	 *
	 * @return the string corresponding to the label of the parameter
	 */
	public static String getLabel(Parameter parameter) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		buffer.append(NamedElementUtil.getVisibilityAsSign(parameter));

		// direction
		buffer.append(" ");
		buffer.append(parameter.getDirection().getLiteral());

		// name
		buffer.append(" ");
		if (parameter.getName() != null) {
			buffer.append(UMLLabelInternationalization.getInstance().getLabel(parameter));
		}

		// type
		if (parameter.getType() != null) {
			buffer.append(": " + UMLLabelInternationalization.getInstance().getLabel(parameter.getType()));
		} else {
			buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(parameter);
		if (!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}

		// default value
		if (parameter.getDefault() != null) {
			buffer.append(" = ");
			buffer.append(parameter.getDefault());
		}

		// property modifiers
		buffer.append(ParameterUtil.getModifiersAsString(parameter, false));

		return buffer.toString();
	}

	/**
	 * return the custom label of the property, given UML2 specification and a custom style.
	 *
	 * @param style
	 *            the integer representing the style of the label
	 *
	 * @return the string corresponding to the label of the property
	 */
	public static String getCustomLabel(Parameter parameter, Collection<String> maskValues) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		if (maskValues.contains(ICustomAppearance.DISP_VISIBILITY)) {
			buffer.append(NamedElementUtil.getVisibilityAsSign(parameter));
		}

		// direction property
		if (maskValues.contains(ICustomAppearance.DISP_PARAMETER_DIRECTION) || maskValues.contains(ICustomAppearance.DISP_DIRECTION)) {
			buffer.append(" ");
			buffer.append(parameter.getDirection().getLiteral());
		}

		// name
		if (maskValues.contains(ICustomAppearance.DISP_PARAMETER_NAME) || maskValues.contains(ICustomAppearance.DISP_NAME)) {
			buffer.append(" ");
			buffer.append(UMLLabelInternationalization.getInstance().getLabel(parameter));
		}

		if (maskValues.contains(ICustomAppearance.DISP_PARAMETER_TYPE) || maskValues.contains(ICustomAppearance.DISP_TYPE)) {
			// type
			if (parameter.getType() != null) {
				buffer.append(": " + UMLLabelInternationalization.getInstance().getLabel(parameter.getType()));
			} else {
				buffer.append(": " + TypeUtil.UNDEFINED_TYPE_NAME);
			}
		}

		if (maskValues.contains(ICustomAppearance.DISP_PARAMETER_MULTIPLICITY) || maskValues.contains(ICustomAppearance.DISP_MULTIPLICITY)) {
			// multiplicity -> do not display [1]
			String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(parameter);
			buffer.append(multiplicity);
		}

		if (maskValues.contains(ICustomAppearance.DISP_PARAMETER_DEFAULT) || maskValues.contains(ICustomAppearance.DISP_DEFAULT_VALUE)) {
			// default value
			if (parameter.getDefault() != null) {
				buffer.append(" = ");
				buffer.append(parameter.getDefault());
			}
		}

		if (maskValues.contains(ICustomAppearance.DISP_MODIFIERS)) {
			boolean multiLine = (maskValues.contains(ICustomAppearance.DISP_MULTI_LINE));
			// property modifiers
			String modifiers = ParameterUtil.getModifiersAsString(parameter, multiLine);
			if (!modifiers.equals("")) {
				if (multiLine) {
					buffer.append("\n");
				}
				buffer.append(modifiers);
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns the default value as a String
	 *
	 * @param equalSign
	 *            boolean set to <code>true</code> if the label must have the <code>=</code> sign
	 *            before the default value
	 * @return the default value as a String
	 */
	private static String getDefaultAsString(Parameter parameter, boolean equalSign) {
		String defaultString = "";
		// default value
		if ((parameter.getDefault() != null) && !parameter.getDefault().equals("")) {
			if (equalSign) {
				defaultString += "= ";
			}
			defaultString += parameter.getDefault();
		}
		return "";
	}
}
