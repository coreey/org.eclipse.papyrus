/**
 *
 */
package org.eclipse.papyrus.infra.ui.extension.diagrameditor;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.editorsfactory.IEditorFactory;

/**
 * A proxy implementation of {@link IEditorFactory} used to do lazy
 * instantiation of concrete {@link IPluggableEditorFactory}. This class is used
 * by the {@link PluggableEditorFactoryReader}
 *
 * @author cedric dumoulin
 * @since 1.2
 *
 */
public class EditorFactoryProxy implements IEditorFactory {

	/**
	 * The concrete implementation.
	 */
	private IPluggableEditorFactory editorFactory;

	/**
	 * EditorDescriptor associated to the factory.
	 */
	protected EditorDescriptor editorDescriptor;

	/**
	 * ServiceRegistry that can be provided to created editors.
	 */
	private ServicesRegistry serviceRegistry;

	/**
	 * Constructor.
	 *
	 * @param serviceRegistry
	 * @param editorDescriptor
	 */
	public EditorFactoryProxy(ServicesRegistry serviceRegistry, EditorDescriptor editorDescriptor) {
		this.serviceRegistry = serviceRegistry;
		this.editorDescriptor = editorDescriptor;
	}

	/**
	 * @see org.eclipse.papyrus.infra.ui.editorsfactory.IEditorFactory#createIPageModel(java.lang.Object)
	 *
	 * @param pageIdentifier
	 * @return
	 */
	@Override
	public IPageModel createIPageModel(Object pageIdentifier) {
		try {
			return getEditorFactory().createIPageModel(pageIdentifier);
		} catch (Exception ex) {
			// An error occurred in a contribution. Do not use this factory
			return null;
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.ui.editorsfactory.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 *
	 * @param pageIdentifier
	 * @return
	 */
	@Override
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		try {
			return getEditorFactory().isPageModelFactoryFor(pageIdentifier);
		} catch (Exception ex) {
			// An error occurred in a contribution. Do not use this factory
			return false;
		}
	}

	/**
	 * @return the editorFactory
	 */
	protected IPluggableEditorFactory getEditorFactory() {

		if (editorFactory == null) {
			editorFactory = createEditorFactory();
		}

		return editorFactory;

	}

	/**
	 * Create an instance of IPluggableEditorFactory as described in the
	 * editorDescriptor. TODO let propagate the exceptions.
	 *
	 * @return
	 */
	private IPluggableEditorFactory createEditorFactory() {
		// Create the requested class.
		try {
			editorFactory = editorDescriptor.getEditorFactoryClass().newInstance();
			// Set the descriptor. USed by the factory to get the ActionBarId
			// and Icon
			editorFactory.init(serviceRegistry, editorDescriptor);
			return editorFactory;
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be
			// solved by programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be
			// solved by programmer.
			throw new RuntimeException(e);
		}

	}

	/**
	 * @see org.eclipse.papyrus.infra.ui.editorsfactory.IEditorFactory#getFactoryID()
	 *
	 * @return
	 */
	@Override
	public String getFactoryID() {
		return getEditorFactory().getFactoryID();
	}

	/**
	 * @see org.eclipse.papyrus.infra.ui.editorsfactory.IEditorFactory#getLabel()
	 *
	 * @return
	 */
	@Override
	public String getLabel() {
		return getEditorFactory().getLabel();
	}

}
