/**
 *
 */
package org.eclipse.papyrus.infra.ui.editorsfactory;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;

/**
 * Factory used to get the Icon associated to the editor used to render the
 * specified pageIdentifier.
 *
 *
 * @author cedric dumoulin
 * @since 1.2
 *
 */
public interface IEditorFactory {

	/**
	 * Create the {@link IPageModel} for the specified identifier. TODO throw an
	 * exception encapsulating problems encountered while creating the model.
	 *
	 * @param pageIdentifier
	 *            Object identifying an Editor.
	 * @return PageModel allowing to create the editor.
	 */
	public IPageModel createIPageModel(Object pageIdentifier);

	/**
	 * Return true if the factory can create an IPageModel for the specified
	 * pageIdentifier. Return false otherwise TODO throw an exception
	 * encapsulating problems encountered while creating the model.
	 *
	 * @param pageIdentifier
	 *            The object representing the page to test
	 * @return
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier);

	/**
	 * The ID of this factory
	 * 
	 * @return
	 */
	default String getFactoryID() {
		return getClass().getName();
	}

	/**
	 * The display label of this factory
	 * 
	 * @return
	 */
	default String getLabel() {
		return getClass().getSimpleName();
	}

}
