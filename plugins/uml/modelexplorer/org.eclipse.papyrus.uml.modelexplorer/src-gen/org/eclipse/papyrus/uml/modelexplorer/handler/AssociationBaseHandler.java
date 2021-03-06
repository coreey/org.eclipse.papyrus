/*
 *
 */
package org.eclipse.papyrus.uml.modelexplorer.handler;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

/**
 * <pre>
 * Command handler for AssociationBase creation
 *
 * </pre>
 *
 * @generated
 */
public class AssociationBaseHandler extends AbstractUmlModelExplorerCreateCommandHandler {

	/**
	 * <pre>
	 * @see org.eclipse.papyrus.uml.service.types.ui.handlers.AbstractCreateCommandHandler#getElementTypeToCreate()
	 *
	 * @return the IElementType this handler is supposed to create
	 *
	 * </pre>
	 *
	 * @generated
	 */
	@Override
	protected IElementType getElementTypeToCreate() {
		return UMLElementTypes.ASSOCIATION_BASE;
	}
}
