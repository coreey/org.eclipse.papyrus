/*****************************************************************************
 * Copyright (c) 2008, 2021  Atos Origin, CEA LIST, Artal and others
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
 * Thibault Landre (Atos Origin) - initial API and implementation
 * Patrick Tessier(CEA LIST)
 * Etienne Allogo (ARTAL) - etienne.allogo@artal.fr - Bug 569174 : 1.4 Merge papyrus extension templates into codegen.xtend
 *****************************************************************************/
package utils

import com.google.inject.Singleton

@Singleton class PrefsConstant_qvto {


	def String getDiagramPreferencePageCategory() {
		return "org.eclipse.papyrus.infra.gmfdiag.preferences.diagrams"
	}

	def String getPreferenceConstant() {
		return "_PREF_"
	}

	def String getPreferenceGradientPolicyConstant(String _element) {
		return _element + getPreferenceConstant() + "GRADIENT_POLICY"
	}

	def String getPreferenceGradientColorConstant(String _element) {
		return _element + getPreferenceConstant() + "GRADIENT_COLOR"
	}

	def String getPreferenceFillColorConstant(String _element) {
		return _element + getPreferenceConstant() + "FILL_COLOR"
	}

	def String getPreferenceFontColorConstant(String _element) {
		return _element + getPreferenceConstant() + "FONT_COLOR"
	}

	def String getPreferenceFontConstant(String _element) {
		return _element + getPreferenceConstant() + "FONT"
	}

	def String getPreferenceLineColorConstant(String _element) {
		return _element + getPreferenceConstant() + "LINE_COLOR"
	}

	def String getPreferenceJumpLinkConstant() {
		return getPreferenceConstant() + "JUMPLINK_"
	}

	def String getPreferenceJumpLinkReverseConstant(String _element) {
		return _element + getPreferenceJumpLinkConstant() + "REVERSE"
	}

	def String getPreferenceJumpLinkStatusConstant(String _element) {
		return _element + getPreferenceJumpLinkConstant() + "STATUS"
	}

	def String getPreferenceJumpLinkTypeConstant(String _element) {
		return _element + getPreferenceJumpLinkConstant() + "TYPE"
	}

	def String getPreferenceRoutingConstant() {
		return getPreferenceConstant() + "ROUTING_"
	}

	def String getPreferenceRoutingDistancePolicyConstant(String _element) {
		return _element + getPreferenceRoutingConstant() + "DISTANCE_POLICY"
	}

	def String getPreferenceRoutingObstructionPolicyConstant(String _element) {
		return _element + getPreferenceRoutingConstant() + "OBSTRUCTION_POLICY"
	}

	def String getPreferenceRoutingStyleConstant(String _element) {
		return _element + getPreferenceRoutingConstant() + "STYLE"
	}

	def String getPreferenceSmoothnessConstant(String _element) {
		return _element + getPreferenceConstant() + "SMOOTHNESS"
	}

	def String getPreferencePageSuffix() {
		return "PreferencePage"
	}
}
