/*
 *
 */
package org.eclipse.papyrus.uml.modelexplorer.handler;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

/**
 * <pre>
 * Command handler for InterruptibleActivityRegion creation
 *
 * </pre>
 *
 * @generated
 */
public class InterruptibleActivityRegionHandler extends AbstractUmlModelExplorerCreateCommandHandler {

	/**
	 * <pre>
	 * @see org.eclipse.papyrus.uml.service.creation.handler.CreateHandler#getElementTypeToCreate()
	 *
	 * @return the IElementType this handler is supposed to create
	 *
	 * </pre>
	 *
	 * @generated
	 */
	@Override
	protected IElementType getElementTypeToCreate() {
		return UMLElementTypes.INTERRUPTIBLE_ACTIVITY_REGION;
	}
}
