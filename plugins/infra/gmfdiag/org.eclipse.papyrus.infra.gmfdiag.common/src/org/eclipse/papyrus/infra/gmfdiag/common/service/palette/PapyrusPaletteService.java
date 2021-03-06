/*****************************************************************************
 * Copyright (c) 2009, 2017 CEA LIST, Esterel Technologies SAS and others.
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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Micka�l ADAM (ALL4TEC) mickael.adam@all4tec.net - bug 512343.
 *  Sebastien Gabel (Esterel Technologies SAS) - bug 513803
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.service.palette;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.ProviderChangeEvent;
import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.gmf.runtime.common.ui.util.ActivityUtil;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.ContributeToPaletteOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteService;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.SelectionToolEx;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDescriptionLanguage;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.messages.Messages;
import org.eclipse.papyrus.infra.gmfdiag.common.service.palette.XMLPaletteProviderConfiguration.EditorDescriptor;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.provider.IExtendedPaletteEntry;
import org.eclipse.papyrus.infra.gmfdiag.representation.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.ui.IEditorPart;
import org.osgi.framework.Bundle;

/**
 * Service that contributes to the palette of a given editor with a given
 * content.
 * <p>
 * It replaces the standard palette service. It provides better preferences management, and better customization possibilities.
 */
public class PapyrusPaletteService extends PaletteService implements IPaletteProvider, IPapyrusPaletteConstant, IPreferenceChangeListener {

	/**
	 * Extension point is of palette providers.
	 */
	public static final String PALETTE_PROVIDERS = "paletteProviders"; //$NON-NLS-1$

	/**
	 * A descriptor for palette providers defined by a configuration element.
	 */
	public static class ProviderDescriptor extends ActivityFilterProviderDescriptor {

		/** the provider configuration parsed from XML */
		protected XMLPaletteProviderConfiguration providerConfiguration;

		/**
		 * Constructs a <code>ISemanticProvider</code> descriptor for the
		 * specified configuration element.
		 *
		 * @param element
		 *            The configuration element describing the provider.
		 */
		public ProviderDescriptor(IConfigurationElement element) {
			super(element);

			if (element != null) {
				this.providerConfiguration = parseConfiguration(element);
				Assert.isNotNull(getProviderConfiguration());
			}
		}

		/**
		 * Return the ID of the target editor for this ProviderDescriptor or null if none
		 *
		 * @return
		 */
		public String getTargetEditorID() {
			if (providerConfiguration != null) {
				EditorDescriptor targetEditor = providerConfiguration.getEditor();
				if (targetEditor != null) {
					return targetEditor.getTargetId();
				}
			}
			return null;
		}

		/**
		 * Parses the content of the xml file configuration
		 *
		 * @param element
		 *            the configuration element for this provider descriptor
		 * @return the configuration of the descriptor
		 */
		protected XMLPaletteProviderConfiguration parseConfiguration(IConfigurationElement element) {
			return XMLPaletteProviderConfiguration.parse(element);
		}

		/**
		 * Returns the provider configuration for this descriptor
		 *
		 * @return the provider Configuration for this descriptor
		 */
		protected XMLPaletteProviderConfiguration getProviderConfiguration() {
			return providerConfiguration;
		}

		/**
		 * Returns <code>true</code> if this configuration provides only
		 * predefinition of entries and neither use predefined entries nor
		 * creates new entries.
		 *
		 * @return <code>true</code> if this configuration provides only
		 *         predefinition of entries and neither use predefined entries
		 *         nor creates new entries.
		 */
		// @unused
		public boolean hasOnlyEntriesDefinition() {
			return getProviderConfiguration().hasOnlyEntriesDefinition();
		}

		/**
		 * Returns this contribution's name
		 *
		 * @return this contribution's name
		 */
		public String getContributionName() {
			return getProviderConfiguration().getName();
		}

		/**
		 * Returns this contribution's id
		 *
		 * @return this contribution's id
		 */
		public String getContributionID() {
			return getProviderConfiguration().getID();
		}

		/**
		 * Returns true if this contributor is hidden in the preferences
		 *
		 * @param operation
		 * @return
		 */
		public boolean isHidden(ContributeToPaletteOperation operation) {
			// checks it is not in the list of hidden palettes for the editor
			List<String> hiddenPalettes = PapyrusPalettePreferences.getHiddenPalettes(operation.getEditor());
			return hiddenPalettes.contains(getContributionID());
		}

		/**
		 * Returns the priority for this provider
		 *
		 * @return the priority for this provider
		 */
		public ProviderPriority getPriority() {
			return getProviderConfiguration().getPriority();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean provides(IOperation operation) {
			if (!super.provides(operation)) {
				return false;
			}
			if (!policyInitialized) {
				policy = getPolicy();
				policyInitialized = true;
			}
			if (policy != null) {
				return policy.provides(operation);
			}

			if (operation instanceof ContributeToPaletteOperation) {
				ContributeToPaletteOperation o = (ContributeToPaletteOperation) operation;

				IEditorPart part = o.getEditor();
				if (!(part instanceof DiagramEditorWithFlyOutPalette)) {
					return false;
				}
				return getProviderConfiguration().supports(o.getEditor(), o.getContent()) && !isHidden(o);
			}

			return false;
		}

		/**
		 * checks if this provider is providing elements, even if this should be
		 * hidden
		 *
		 * @param operation
		 *            the operation to contribute
		 * @return <code>true</code> if this provider contributes to the
		 *         operation
		 */
		public boolean providesWithVisibility(ContributeToPaletteOperation operation) {
			if (!super.provides(operation)) {
				return false;
			}
			if (!policyInitialized) {
				policy = getPolicy();
				policyInitialized = true;
			}
			if (policy != null) {
				return policy.provides(operation);
			}


			return getProviderConfiguration().supports(operation.getEditor(), operation.getContent());
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IProvider getProvider() {
			if (provider == null) {
				provider = super.getProvider();
				if (provider instanceof IPaletteProvider) {
					((IPaletteProvider) provider).setContributions(getElement());
				}
			}
			return provider;
		}
	}

	/**
	 * Provider descriptor for a extended palette definition.
	 */
	public static class ExtendedProviderDescriptor extends ProviderDescriptor {

		/**
		 * Constructor.
		 *
		 * @param element
		 *            configuration element for this descriptor
		 */
		public ExtendedProviderDescriptor(IConfigurationElement element) {
			super(element);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected ExtendedPaletteProviderConfiguration parseConfiguration(IConfigurationElement element) {
			return ExtendedPaletteProviderConfiguration.parse(element);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected ExtendedPaletteProviderConfiguration getProviderConfiguration() {
			return (ExtendedPaletteProviderConfiguration) providerConfiguration;
		}

		/**
		 * Creates a new local redefinition of the configuration file
		 *
		 * @return the path to the configuration file
		 */
		public String createLocalRedefinition() {
			String filePath = getProviderConfiguration().getPath();
			String bundleId = getProviderConfiguration().getBundleID();
			String realId = bundleId;
			InputStream stream = null;

			Bundle bundle = Platform.getBundle(bundleId);
			if (Platform.isFragment(bundle)) {
				// retrieve the file in the fragment itself
				stream = openConfigurationFile(bundle, filePath);
			} else {
				// this is a plugin. Search in sub fragments, then in the plugin
				Bundle[] fragments = Platform.getFragments(bundle);
				// no fragment, so the file should be in the plugin itself
				if (fragments == null) {
					stream = openConfigurationFile(bundle, filePath);
				} else {
					for (Bundle fragment : fragments) {
						if (stream == null) {
							stream = openConfigurationFile(fragment, filePath);
							realId = fragment.getSymbolicName();
						}
					}

					if (stream == null) {
						// no file in fragments. open in the plugin itself
						stream = openConfigurationFile(bundle, filePath);
						realId = bundle.getSymbolicName();
					}
				}
			}

			// check the stream
			if (stream == null) {
				Activator.log.error("Impossible to read initial file", null);
				return null;
			}

			File stateLocationRootFile = Activator.getInstance().getStateLocation().toFile();
			File bundleFolder = new File(stateLocationRootFile, realId);
			bundleFolder.mkdir();

			// for all intermediate folders in filePath, create a folder in
			// plugin state location
			File root = bundleFolder;
			// Split folder with / or \ file separator
			String[] folders = filePath.split("\\Q\\\\E|\\Q/\\E");//$NON-NLS-1$
			for (int i = 0; i < folders.length - 1; i++) { // all intermediate
															// folders. Last one
															// is the file name
															// itself...
				String folderName = folders[i];
				if (folderName != null && folderName.length() != 0) {
					File newFolder = new File(root, folders[i]);
					newFolder.mkdir();
					root = newFolder;
				}
			}

			File newFile = new File(root, folders[folders.length - 1]);
			boolean fileCreated = false;

			// check if file already exists or not
			if (newFile.exists()) {
				fileCreated = true;
			} else {
				try {
					fileCreated = newFile.createNewFile();
				} catch (IOException e) {
					Activator.log.error("Impossible to create new file", e);
					return null;
				}
			}

			if (!fileCreated) {
				Activator.log.error("It was not possible to create the file", null);
				return null;
			}

			try {
				FileOutputStream fileOutputStream = new FileOutputStream(newFile);
				byte[] buf = new byte[1024];
				int len;
				while ((len = stream.read(buf)) > 0) {
					fileOutputStream.write(buf, 0, len);
				}
				stream.close();
				fileOutputStream.close();
			} catch (FileNotFoundException e) {
				Activator.log.error("It was not possible to write in the file", e);
				return null;
			} catch (IOException e) {
				Activator.log.error("It was not possible to write in the file", e);
				return null;
			}

			// Needs to add a / to have a correct path or the concatenation will be false.
			if (!filePath.startsWith("/") || !filePath.startsWith("\\")) {//$NON-NLS-1$ //$NON-NLS-2$
				filePath = IPath.SEPARATOR + filePath;
			}

			return realId + filePath;
		}

		/**
		 * Reads the configuration file in the bundle
		 *
		 * @param bundle
		 * @param filePath
		 * @return
		 */
		protected InputStream openConfigurationFile(Bundle bundle, String filePath) {
			try {
				URL urlFile = bundle.getEntry(filePath);
				urlFile = FileLocator.resolve(urlFile);
				urlFile = FileLocator.toFileURL(urlFile);
				if ("file".equals(urlFile.getProtocol())) { //$NON-NLS-1$
					return new FileInputStream(urlFile.getFile());
				} else if ("jar".equals(urlFile.getProtocol())) { //$NON-NLS-1$
					String path = urlFile.getPath();
					if (path.startsWith("file:")) {
						// strip off the file: and the !/
						int jarPathEndIndex = path.indexOf("!/");
						if (jarPathEndIndex < 0) {
							Activator.log.error("Impossible to find the jar path end", null);
							return null;
						}
						String jarPath = path.substring("file:".length(), jarPathEndIndex);
						ZipFile zipFile = new ZipFile(jarPath);
						filePath = filePath.substring(jarPathEndIndex + 2, path.length());
						ZipEntry entry = zipFile.getEntry(path);
						return zipFile.getInputStream(entry);
					}
				}
			} catch (IOException e) {
				Activator.log.error("Impossible to find initial file", e);
			}
			return null;
		}

		/**
		 * Returns the redefinition file URI
		 *
		 * @return the redefinition file URI or <code>null</code> if no local
		 *         redefinition can be found.
		 */
		public URI getRedefinitionFileURI() {
			String path = PapyrusPalettePreferences.getPaletteRedefinition(getContributionID());
			if (path == null) {
				Activator.log.error("Path is null for the given contribution: " + getContributionID(), null);
				return null;
			}

			File stateLocationRootFile = Activator.getInstance().getStateLocation().append(path).toFile();
			if (stateLocationRootFile == null) {
				Activator.log.error("No redefinition file was found for id: " + getContributionID(), null);
				return null;
			}
			if (!stateLocationRootFile.exists()) {
				Activator.log.error("local definition file does not exists : " + stateLocationRootFile, null);
				return null;
			}

			if (!stateLocationRootFile.canRead()) {
				Activator.log.error("Impossible to read local definition of the file " + stateLocationRootFile, null);
				return null;
			}
			return URI.createFileURI(stateLocationRootFile.getAbsolutePath());
		}
	}

	/**
	 * Provider descriptor for a local palette definition.
	 * <p>
	 * It has no configuration element attached to it, it should not be used everywhere without checks.
	 * </p>
	 */
	public static class LocalProviderDescriptor extends ProviderDescriptor {

		/** palette description */
		protected final IPaletteDescription description;

		/**
		 * Creates a new Local Palette Descriptor
		 *
		 * @param description
		 *            the description of the palette
		 */
		public LocalProviderDescriptor(IPaletteDescription description) {
			super(null);
			this.description = description;
		}

		/**
		 * Returns <code>true</code> if this configuration provides only
		 * predefinition of entries and neither use predefined entries nor
		 * creates new entries.
		 *
		 * @return <code>false</code> as local palettes are never defining tools
		 */
		@Override
		public boolean hasOnlyEntriesDefinition() {
			return false;
		}

		/**
		 * Returns the description of this palette provider
		 *
		 * @return the description of this palette provider
		 */
		public IPaletteDescription getDescription() {
			return description;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getContributionName() {
			return description.getName();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getContributionID() {
			return description.getPaletteID();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isHidden(ContributeToPaletteOperation operation) {
			// checks it is not in the list of hidden palettes for the editor
			List<String> hiddenPalettes = PapyrusPalettePreferences.getHiddenPalettes(operation.getEditor());
			return hiddenPalettes.contains(getContributionID());
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ProviderPriority getPriority() {
			return description.getPriority();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean provides(IOperation operation) {
			boolean isEnable = ActivityUtil.isEnabled(getContributionID(), Activator.ID);

			if (!isEnable) {
				return false;
			}

			if (operation instanceof ContributeToPaletteOperation) {
				ContributeToPaletteOperation o = (ContributeToPaletteOperation) operation;

				IEditorPart part = o.getEditor();
				if (!(part instanceof DiagramEditorWithFlyOutPalette)) {
					return false;
				}

				// will never work, ID of the site is the multi diagram
				// editor...
				if (description.getContributionEditorID() != null) {
					if (!description.getContributionEditorID().equals(((DiagramEditorWithFlyOutPalette) part).getContributorId())) {
						return false;
					}
				}

				// TODO find a way to manage it
				// if (!PaletteUtil.areRequiredProfileApplied(part, this)) {
				// return false;
				// }

				if (isHidden(o)) {
					return false;
				}
				return true;
			}

			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean providesWithVisibility(ContributeToPaletteOperation operation) {
			/**
			 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
			 */
			boolean isEnable = ActivityUtil.isEnabled(getContributionID(), Activator.ID);

			if (!isEnable) {
				return false;
			}

			IEditorPart part = operation.getEditor();
			if (!(part instanceof DiagramEditorWithFlyOutPalette)) {
				return false;
			}

			// will never work, ID of the site is the multi diagram
			// editor...
			if (description.getContributionEditorID() != null) {
				if (!description.getContributionEditorID().equals(((DiagramEditorWithFlyOutPalette) part).getContributorId())) {
					return false;
				}
			}

			return true;
		}

	}

	/**
	 * ProviderDescriptor for workspace palette model.
	 */
	public static class WorkspaceExtendedProviderDescriptor extends LocalProviderDescriptor {
		/**
		 * @param description
		 */
		public WorkspaceExtendedProviderDescriptor(IPaletteDescription description) {
			super(description);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IProvider getProvider() {
			if (provider == null) {
				provider = new WorkspaceExtendedPaletteProvider();
				((WorkspaceExtendedPaletteProvider) provider).setContributions(description);
			}
			return provider;
		}
	}



	/**
	 * Provider Descriptor for extended palette defined locally (ie not in workspace)
	 */
	public static class LocalExtendedProviderDescriptor extends LocalProviderDescriptor {
		/**
		 * @param description
		 */
		public LocalExtendedProviderDescriptor(IPaletteDescription description) {
			super(description);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IProvider getProvider() {
			if (null == provider) {
				provider = new LocalExtendedPaletteProvider();
				((LocalExtendedPaletteProvider) provider).setContributions(description);
			}
			return provider;
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setContributions(IConfigurationElement configElement) {
		//
	}

	/** the singleton instance of the palette service */
	private static PapyrusPaletteService instance;

	/** the standard group id */
	public static final String GROUP_STANDARD = "standardGroup"; //$NON-NLS-1$

	/** the standard separator id */
	public static final String SEPARATOR_STANDARD = "standardSeparator"; //$NON-NLS-1$

	/** the standard separator id */
	public static final String TOOL_SELECTION = "selectionTool"; //$NON-NLS-1$

	/**
	 * Creates a new instance of the Palette Service
	 */
	protected PapyrusPaletteService() {
		super();

		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.ID);
		prefs.addPreferenceChangeListener(this);
	}

	/**
	 * add providers for workspace palettes based on model
	 */
	protected void configureWorkspaceExtendedPalettes() {
		// read the preference field that indicates where the workspace palettes
		// are, their IDs, etc...
		List<IPaletteDescription> workspacePalettes = PapyrusPalettePreferences.getWorkspaceExtendedPalettes();
		// create the providers linked to these configuration
		// remove all local descriptors
		for (org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor descriptor : getProviders()) {
			if (descriptor instanceof WorkspaceExtendedProviderDescriptor) {
				removeProvider(descriptor);
			}
		}

		// create new list
		for (IPaletteDescription palette : workspacePalettes) {
			LocalProviderDescriptor descriptor = new WorkspaceExtendedProviderDescriptor(palette);
			addProvider(palette.getPriority(), descriptor);
		}

	}

	/**
	 * Add providers for palettes based on model declared in architecture.
	 */
	protected void configureArchitectureExtendedPalettes() {

		// remove all local descriptors
		for (org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor descriptor : getProviders()) {
			if (descriptor instanceof ArchitectureExtendedProviderDescriptor) {
				removeProvider(descriptor);
			}
		}

		// get all PapyrusDiagram declare in architecture
		List<PapyrusDiagram> papyrusDiagrams = ArchitectureDomainManager.getInstance().getVisibleArchitectureContexts().stream()
				.filter(MergedArchitectureDescriptionLanguage.class::isInstance)
				.map(MergedArchitectureDescriptionLanguage.class::cast)
				.flatMap(adl -> adl.getRepresentationKinds().stream())
				.filter(PapyrusDiagram.class::isInstance)
				.map(PapyrusDiagram.class::cast)
				.filter(d -> !d.getPalettes().isEmpty())
				.collect(Collectors.toList());


		for (PapyrusDiagram diagram : papyrusDiagrams) {
			ArchitectureExtendedProviderDescriptor descriptor = new ArchitectureExtendedProviderDescriptor(diagram);
			addProvider(ProviderPriority.MEDIUM, descriptor);
		}
	}

	/**
	 * add providers for workspace palettes based on model
	 */
	protected void configureRedefinedPalettes() {
		// Nothing to do
	}


	/**
	 * gets the singleton instance
	 *
	 * @return <code>PaletteService</code>
	 */
	public static synchronized PapyrusPaletteService getInstance() {
		if (instance == null) {
			instance = new PapyrusPaletteService();
			configureProviders();
		}
		return instance;
	}

	/**
	 * Configure providers.
	 */
	private static void configureProviders() {
		getInstance().configureProviders(DiagramUIPlugin.getPluginId(), PALETTE_PROVIDERS);
		getInstance().configureProviders(Activator.ID, PALETTE_DEFINITION);
		getInstance().configureWorkspaceExtendedPalettes();
		getInstance().configureLocalExtendedPalettes();
		getInstance().configureRedefinedPalettes();
		getInstance().configureArchitectureExtendedPalettes();
	}

	/**
	 * Configure local extended palettes.
	 */
	protected void configureLocalExtendedPalettes() {
		// read the preference field that indicates where the local extended palettes
		// are, their IDs, etc...
		List<IPaletteDescription> localExtendedPalettes = PapyrusPalettePreferences.getLocalExtendedPalettes();
		// create the providers linked to these configuration
		// remove all local descriptors
		for (org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor descriptor : getProviders()) {
			if (descriptor instanceof LocalExtendedProviderDescriptor) {
				removeProvider(descriptor);
			}
		}

		// create new list
		for (IPaletteDescription palette : localExtendedPalettes) {
			LocalExtendedProviderDescriptor descriptor = new LocalExtendedProviderDescriptor(palette);
			addProvider(palette.getPriority(), descriptor);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		// if provider is coming from palette definition extension point :
		// define an extended palette provider...
		String extensionPointId = element.getDeclaringExtension().getExtensionPointUniqueIdentifier();
		if (PALETTE_DEFINITION_FULL_ID.equals(extensionPointId)) {
			return new ExtendedProviderDescriptor(element);
		}
		return new ProviderDescriptor(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, Map predefinedEntries) {

		PaletteToolbar standardGroup = new PaletteToolbar(Messages.StandardGroup_Label);
		standardGroup.setDescription(""); //$NON-NLS-1$
		standardGroup.setId(GROUP_STANDARD);
		root.add(standardGroup);

		PaletteSeparator standardSeparator = new PaletteSeparator(SEPARATOR_STANDARD);
		standardGroup.add(standardSeparator);

		ToolEntry selectTool = new PanningSelectionToolEntry();
		selectTool.setId(TOOL_SELECTION);
		selectTool.setToolClass(SelectionToolEx.class);
		standardGroup.add(selectTool);
		root.setDefaultEntry(selectTool);

		execute(new ContributeToPaletteOperation(editor, content, root, predefinedEntries));
	}

	/**
	 * Returns the list of providers for this service
	 *
	 * @return the list of providers for this service
	 */
	@SuppressWarnings("unchecked")
	public List<? extends Service.ProviderDescriptor> getProviders() {
		return getAllProviders();
	}

	/**
	 * Executes the palette operation using the REVERSE execution strategy.
	 *
	 * @param operation
	 * @return List of results
	 */
	@SuppressWarnings("unchecked")
	private List execute(IOperation operation) {
		return execute(ExecutionStrategy.REVERSE, operation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaletteRoot createPalette(final IEditorPart editor, final Object content) {
		final PaletteRoot root = new PaletteRoot();
		try {
			IEditingDomainProvider provider = editor.getAdapter(IEditingDomainProvider.class);
			if (provider != null) {
				EditingDomain domain = provider.getEditingDomain();
				if (domain instanceof TransactionalEditingDomain) {
					((TransactionalEditingDomain) domain).runExclusive(new Runnable() {

						@Override
						public void run() {
							contributeToPalette(editor, content, root, new HashMap());
						}
					});
				}
			}
		} catch (Exception e) {
			Activator.getInstance().logError("Error in PapyrusPaletteService::createPalette()", e); //$NON-NLS-1$
		}

		Diagram diagram = ((DiagramEditor) editor).getDiagram();
		PolicyChecker checker = PolicyChecker.getFor(diagram);
		for (Object o : root.getChildren()) {
			if (o instanceof PaletteContainer) {
				PaletteContainer drawer = (PaletteContainer) o;
				configurePaletteVisibility(checker, diagram, drawer);
			}
		}

		// if the default entry is set but not visible, set it to null instead to avoid a potential NPE
		if (root.getDefaultEntry() != null && !isVisible(root.getDefaultEntry())) {
			root.setDefaultEntry(null);
		}

		return root;
	}

	private boolean isVisible(PaletteEntry entry) {
		PaletteContainer parent = entry.getParent();
		return entry.isVisible() && (parent == null || isVisible(parent));
	}

	protected void configurePaletteVisibility(PolicyChecker checker, Diagram diagram, PaletteContainer container) {
		boolean isVisible = checker.isInPalette(diagram, container.getId());
		container.setVisible(isVisible);
		if (isVisible) {
			for (Object child : container.getChildren()) {
				if (child instanceof PaletteContainer) {
					configurePaletteVisibility(checker, diagram, (PaletteContainer) child);
				}
				if (child instanceof PaletteEntry) {
					PaletteEntry entry = (PaletteEntry) child;
					entry.setVisible(checker.isInPalette(diagram, entry.getId()));
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updatePalette(PaletteRoot existingRoot, final IEditorPart editor, final Object content) {
		PaletteRoot newRoot = createPalette(editor, content);
		updatePaletteContainerEntries(existingRoot, newRoot);
	}

	/**
	 * Updates the children of an existing palette container to match the
	 * palette entries in a new palette container by adding or removing new
	 * palette entries only. This method works recursively on any children that
	 * are palette container entries. Existing leaf palette entries that are to
	 * be kept remain the same -- they are not replaced with the new palette
	 * entry. This is so that palette state (such as whether a drawer is pinned
	 * or expanded) can be preserved when the palette is updated.
	 *
	 * @param existingContainer
	 *            the palette container to be updated with new entries, have
	 *            obsolete entries removed, and whose existing entries will
	 *            remain the same
	 * @param newContainer
	 *            the new palette entries
	 */
	protected void updatePaletteContainerEntries(PaletteContainer existingContainer, PaletteContainer newContainer) {
		HashMap existingEntryIds = new HashMap();
		for (Iterator iter = existingContainer.getChildren().iterator(); iter.hasNext();) {
			PaletteEntry entry = (PaletteEntry) iter.next();
			existingEntryIds.put(entry.getId(), entry);
		}

		int nextNewIndex = 0;
		// cycle through the new entries
		for (Iterator iter = newContainer.getChildren().iterator(); iter.hasNext();) {
			PaletteEntry newEntry = (PaletteEntry) iter.next();

			PaletteEntry existingEntry = (PaletteEntry) existingEntryIds.get(newEntry.getId());
			if (existingEntry != null) { // is already in existing container
				// update the index
				nextNewIndex = existingContainer.getChildren().indexOf(existingEntry) + 1;

				// remove the entry that was just updated from the map
				existingEntryIds.remove(existingEntry.getId());

				if (existingEntry instanceof PaletteContainer && newEntry instanceof PaletteContainer) {
					// look for new/deleted entries in
					// palette containers
					updatePaletteContainerEntries((PaletteContainer) existingEntry, (PaletteContainer) newEntry);
				}
			} else { // this is a new entry that did not previously exist
				existingContainer.add(nextNewIndex++, newEntry);
			}
		}

		// remove existing entries that were not found in the new container
		for (Iterator iter = existingEntryIds.values().iterator(); iter.hasNext();) {
			PaletteEntry entry = (PaletteEntry) iter.next();
			// only process palette entries that Papyrus is able to support
			if (entry instanceof IExtendedPaletteEntry) {
				existingContainer.remove(entry);
			}
		}

	}

	/**
	 * Returns the list of all providers that are really contributing to the
	 * palette
	 *
	 * @param part
	 *            the editor part fopr which the palette is displayed
	 * @param root
	 *            the palette root of the current palette
	 * @return the list of all providers that are really contributing to the
	 *         palette
	 */
	public List<PapyrusPaletteService.ProviderDescriptor> getContributingProviders(IEditorPart part, PaletteRoot root) {
		// init...
		// 1. inits the return list of providers contributing to the specified
		// editor part
		// 2. inits the operation used to check if the provider really provides
		// to this service
		// 3. inits the list of ids of hidden palettes
		List<PapyrusPaletteService.ProviderDescriptor> descriptors = new ArrayList<>();
		final ContributeToPaletteOperation o = new ContributeToPaletteOperation(part, part.getEditorInput(), root, new HashMap());
		// For each provider, checks it contributes to the palette of this
		// editor part
		Iterator<? extends Service.ProviderDescriptor> it = getProviders().iterator();
		while (it.hasNext()) {
			Service.ProviderDescriptor provider = it.next();
			if (provider instanceof PapyrusPaletteService.ProviderDescriptor) {

				PapyrusPaletteService.ProviderDescriptor papyrusProviderDesc = (PapyrusPaletteService.ProviderDescriptor) provider;

				// get provider name
				String name = papyrusProviderDesc.getContributionName();
				if (name == null || name.equals("")) {
					name = papyrusProviderDesc.getContributionID();
				}

				// check if the name of the descriptor does not correspond to
				// the name of a palette
				// that should not be removed
				boolean add = isChangeable(papyrusProviderDesc, name);

				// check if this provider is really contributing this palette
				add = add && isContributing(papyrusProviderDesc, o);

				if (add) {
					descriptors.add(papyrusProviderDesc);
				}
			} else {
				Activator.getInstance().logInfo("impossible to cast this provider: " + provider);
			}
		}

		return descriptors;
	}

	/**
	 * Checks if the name does not belong to a set of names that should not be
	 * in the action list
	 *
	 * @param provider
	 *            the provider to check
	 * @param name
	 *            the name of the provider to check
	 * @return <code>true</code> if the provider should appear in the list of
	 *         actions
	 */
	protected boolean isChangeable(PapyrusPaletteService.ProviderDescriptor provider, String name) {
		assert name != null;
		final String[] providersToRemove = new String[] { "<Unnamed>", "Presentation Palette", "Geoshapes", "org.eclipse.papyrus.uml.diagram.common" };
		final List<String> providersList = Arrays.asList(providersToRemove);

		// if the name is in the list, it is not changeable
		if (providersList.contains(name)) {
			return false;
		}
		// if it contains predefined entries in its name, it should return false
		return name.indexOf("Predefined Entries") == -1;
	}

	/**
	 * Checks if the provider descriptor is able to fill the palette for the
	 * current active diagram
	 *
	 * @param provider
	 *            the provider to check
	 * @return <code>true</code> if the provider is able to fill the palette for
	 *         the current active diagram
	 */
	protected boolean isContributing(PapyrusPaletteService.ProviderDescriptor provider, ContributeToPaletteOperation o) {
		return provider.providesWithVisibility(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void preferenceChange(PreferenceChangeEvent event) {
		// listen for local palette preferences...

		String id = event.getKey();
		if (IPapyrusPaletteConstant.EXTENDED_PALETTE_WORKSPACE_DEFINITIONS.equals(id)) {
			// refresh available palette table viewer
			getInstance().configureWorkspaceExtendedPalettes();
			providerChanged(new ProviderChangeEvent(this));
		} else if (IPapyrusPaletteConstant.LOCAL_EXTENDED_PALETTE_DEFINITIONS.equals(id)) {
			// refresh available palette table viewer
			getInstance().configureLocalExtendedPalettes();
			providerChanged(new ProviderChangeEvent(this));
		} else if (IPapyrusPaletteConstant.PALETTE_CUSTOMIZATIONS_ID.equals(id)) {
			// refresh available palette table viewer
			providerChanged(new ProviderChangeEvent(this));
		} else if (IPapyrusPaletteConstant.PALETTE_REDEFINITIONS.equals(id)) {
			for (Service.ProviderDescriptor descriptor : getProviders()) {
				removeProvider(descriptor);
			}
			configureProviders();
			// refresh available palette table viewer
			providerChanged(new ProviderChangeEvent(this));
		}
	}

	/**
	 * Notification that the architecture have changed.
	 */
	public void architectureChanged() {
		getInstance().configureArchitectureExtendedPalettes();
		providerChanged(new ProviderChangeEvent(getInstance()));
	}

	/**
	 * Notifies the listeners for this abstract provider that the specified
	 * event has occurred.
	 *
	 * @param event
	 *            The provider change event to be fired.
	 */
	@Override
	protected void fireProviderChange(ProviderChangeEvent event) {
		// Bug 407849: If a listener throws an exception, the operation is rolled back. This could have bad side effects, as explained in the bug
		try {
			super.fireProviderChange(event);
		} catch (Exception e) {
			Activator.log.error(e);
		}

	}
}
