/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which accompanies this distribution, and is
t https://www.eclipse.org/legal/epl-2.0/
t
t SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers.assistant;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.MDTUtil;

/**
 * An assistant that can add or remove element types to various EditPart. Created for the
 * 'es.cv.gvcase.mdt.common.editorAssistantProvider' extension point.
 *
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 *
 */
public class Assistant {

	public String editorID;

	public List<AssistedEditPart> AssistedEditPart;

	/**
	 * Adds or removes IElemenTypes for the edit part.
	 *
	 * @param editPart
	 * @param types
	 * @return
	 */
	public List customizeTypesForEditPart(EditPart editPart, List types) {
		for (AssistedEditPart assistedEditPart : this.AssistedEditPart) {
			if (assistedEditPart.editPartClass != null) {
				if (MDTUtil.isOfType(editPart.getClass(), assistedEditPart.editPartClass)) {
					types = assistedEditPart.customizeTypes(types);
				}
			}
		}
		return types;
	}

}
