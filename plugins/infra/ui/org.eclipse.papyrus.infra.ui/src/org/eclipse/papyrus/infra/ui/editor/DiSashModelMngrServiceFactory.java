/**
 *
 */
package org.eclipse.papyrus.infra.ui.editor;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr;
import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.Activator;
import org.eclipse.papyrus.infra.ui.editorsfactory.PageModelFactoryRegistry;
import org.eclipse.papyrus.infra.ui.extension.diagrameditor.PluggableEditorFactoryReader;

/**
 * Service Factory to create the {@link DiSashModelMngr} service.
 *
 * @author cedric dumoulin
 * @since 1.2
 *
 */
public class DiSashModelMngrServiceFactory implements IServiceFactory {

	private TransactionalEditingDomain transactionalEditingDomain;

	private SashModel sashModel;

	private DiSashModelMngr sashModelMngr;

	private ServicesRegistry servicesRegistry;

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 *
	 * @param servicesRegistry
	 * @throws ServiceException
	 */
	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {

		this.servicesRegistry = servicesRegistry;
		// Get required service
		transactionalEditingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);

		// Get the model holding the contentProvider
		sashModel = SashModelUtils.getSashModelChecked(servicesRegistry);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void startService() throws ServiceException {

		// Read declared editors
		PageModelFactoryRegistry pageModelRegistry = new PageModelFactoryRegistry();
		PluggableEditorFactoryReader editorReader = new PluggableEditorFactoryReader(Activator.PLUGIN_ID);
		editorReader.populate(pageModelRegistry, servicesRegistry);

		if (sashModel.getResource() == null) {
			throw new ServiceException("Can't start " + this.getClass().getSimpleName() + "'. Required model (SashModel) should be loaded prior starting the service."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// create the service
		sashModelMngr = new DiSashModelMngr(pageModelRegistry, sashModel.getResource());

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 *
	 * @throws ServiceException
	 */
	@Override
	public void disposeService() throws ServiceException {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.services.IServiceFactory#createServiceInstance()
	 *
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Object createServiceInstance() throws ServiceException {

		// Start locally the service if needed.
		// Question: Can createServiceInstance() method be called before
		// startService() is called ?
		if (sashModelMngr == null) {
			startService();
		}

		return sashModelMngr;
	}

}
