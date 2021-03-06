/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;



import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.messages.Messages;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


/**
 * Specific String editor to select a file with unique button.
 *
 * @author gpascual
 *
 */
public class BrowseFileEditor extends StringEditor {

	/** Unique button with associated menu to choice where file will be selected. */
	private Button button = null;

	/** List of accepted file extensions. */
	private List<String> filterExtensions = new ArrayList<String>();

	/** List of accepted names. */
	private List<String> filterNames = new ArrayList<String>();

	/** Attribute to allow file from workspace. */
	private boolean allowWorkspace = true;

	/** Attribute to allow file from file system. */
	private boolean allowFileSystem = true;

	/** Attribute for writing rights. */
	private boolean readOnly = false;

	/** Menu of file system. */
	private MenuItem fileSystemMenuItem = null;

	/** Menu of workspace. */
	private MenuItem workspaceMenuItem = null;

	/**
	 * Default constructor.
	 *
	 * @param parent
	 *            the parent
	 * @param style
	 *            the style
	 */
	public BrowseFileEditor(Composite parent, int style) {
		super(parent, style);
		((GridLayout) getLayout()).numColumns++;
		button = factory.createButton(this, Messages.StringFileSelector_Browse, SWT.PUSH);
		button.setLayoutData(new GridData());


		final Menu browseMenu = createButtonMenu();



		// Display menu when user select button
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				browseMenu.setVisible(true);
			}
		});

	}


	/**
	 * Creates the button menu.
	 *
	 * @return the menu
	 */
	private Menu createButtonMenu() {
		final Menu browseMenu = new Menu(button);

		// Add file system menu
		fileSystemMenuItem = new MenuItem(browseMenu, SWT.NONE);
		fileSystemMenuItem.setText("File system");
		fileSystemMenuItem.addSelectionListener(new SelectionAdapter() {



			@Override
			public void widgetSelected(SelectionEvent e) {
				File file = getFile(text.getText());

				FileDialog dialog = new FileDialog(getShell());
				if (labelText != null) {
					dialog.setText(labelText);
				}
				dialog.setFileName(file.getAbsolutePath());
				dialog.setFilterExtensions(filterExtensions.toArray(new String[filterExtensions.size()]));
				dialog.setFilterNames(filterNames.toArray(new String[filterNames.size()]));
				String result = dialog.open();
				if (result == null) { // Cancel
					return;
				}
				setResult(result);
			}
		});

		// Add workspace menu
		workspaceMenuItem = new MenuItem(browseMenu, SWT.NONE);
		workspaceMenuItem.setText("Workspace");
		workspaceMenuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				LabelProviderService labelProviderService = new LabelProviderServiceImpl();
				try {
					labelProviderService.startService();
				} catch (ServiceException ex) {
					Activator.log.error(ex);
				}

				ILabelProvider labelProvider = labelProviderService.getLabelProvider();

				IFile currentFile = getIFile(text.getText());

				TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
				if (labelText != null) {
					dialog.setTitle(labelText);
				}

				WorkspaceContentProvider contentProvider = new WorkspaceContentProvider();

				if (!(filterExtensions.isEmpty() || filterNames.isEmpty())) {
					// The filters have been defined
					contentProvider.setExtensionFilters(new LinkedHashMap<String, String>()); // Reset the default filters

					// Use our own filters
					for (int i = 0; i < Math.min(filterNames.size(), filterExtensions.size()); i++) {
						contentProvider.addExtensionFilter(filterExtensions.get(i), filterNames.get(i));
					}
				}

				dialog.setContentProvider(contentProvider);
				dialog.setLabelProvider(labelProvider);


				if (currentFile != null && currentFile.exists()) {
					dialog.setInitialSelections(new IFile[] { currentFile });
				}

				int code = dialog.open();
				if (code == Window.OK) {
					Object[] result = dialog.getResult();
					if (result.length > 0) {
						Object file = result[0];
						if (file instanceof IFile) {
							setResult((IFile) file);
						}
					}
				}
			}
		});

		return browseMenu;
	}


	/**
	 * Sets the result.
	 *
	 * @param file
	 *            the new result
	 */
	protected void setResult(IFile file) {
		text.setText(file.getFullPath().toString());
		notifyChange();
	}

	/**
	 * Sets the result.
	 *
	 * @param file
	 *            the new result
	 */
	protected void setResult(File file) {
		text.setText(file.getAbsolutePath());
		notifyChange();
	}

	/**
	 * Sets the result.
	 *
	 * @param path
	 *            the new result
	 */
	protected void setResult(String path) {
		text.setText(path);
		notifyChange();
	}

	/**
	 * Gets the file.
	 *
	 * @param path
	 *            the path
	 * @return the i file
	 */
	protected IFile getIFile(String path) {
		return FileUtil.getIFile(path);
	}

	/**
	 * Gets the file.
	 *
	 * @param path
	 *            the path
	 * @return the file
	 */
	protected File getFile(String path) {
		return FileUtil.getFile(path);
	}

	/**
	 * Sets the filters.
	 *
	 * @param filterExtensions
	 *            the filter extensions
	 * @param filterNames
	 *            the filter names
	 */
	public void setFilters(String[] filterExtensions, String[] filterNames) {
		if (filterExtensions.length != filterNames.length) {
			// This is a simple warning. Only valid filters will be retained.
			Activator.log.warn("FilterExtensions and FilterNames do not match");
		}

		setFilterNames(getFilterLabels(filterNames, filterExtensions));
		setFilterExtensions(filterExtensions);
	}

	/**
	 * Gets the filter labels.
	 *
	 * @param filterNames
	 *            the filter names
	 * @param filterExtensions
	 *            the filter extensions
	 * @return the filter labels
	 */
	protected String[] getFilterLabels(String[] filterNames, String[] filterExtensions) {
		int size = Math.min(filterNames.length, filterExtensions.length);
		String[] filters = new String[size];
		for (int i = 0; i < size; i++) {
			filters[i] = filterNames[i] + " (" + filterExtensions[i] + ")";
		}
		return filters;
	}

	/**
	 * Sets the filter extensions.
	 *
	 * @param filterExtensions
	 *            the new filter extensions
	 */
	public void setFilterExtensions(String[] filterExtensions) {
		this.filterExtensions = Arrays.asList(filterExtensions);
	}

	/**
	 * Sets the filter names.
	 *
	 * @param filterNames
	 *            the new filter names
	 */
	public void setFilterNames(String[] filterNames) {
		this.filterNames = Arrays.asList(filterNames);
	}

	/**
	 * Adds the filtered extension.
	 *
	 * @param filteredExtension
	 *            the filtered extension
	 * @param filterName
	 *            the filter name
	 */
	public void addFilteredExtension(String filteredExtension, String filterName) {
		if (filteredExtension != null) {
			if (filterName == null) {
				filterName = filteredExtension;
			}

			filterExtensions.add(filteredExtension);
			filterNames.add(filterName);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.StringEditor#getEditableType()
	 *
	 * @return
	 */

	@Override
	public Object getEditableType() {
		return String.class;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.StringEditor#setReadOnly(boolean)
	 *
	 * @param readOnly
	 */

	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly);
		this.readOnly = readOnly;
		updateButtons();
	}

	/**
	 * Sets the allow workspace.
	 *
	 * @param allowWorkspace
	 *            the new allow workspace
	 */
	public void setAllowWorkspace(boolean allowWorkspace) {
		this.allowWorkspace = allowWorkspace;
		updateButtons();
	}

	/**
	 * Sets the allow file system.
	 *
	 * @param allowFileSystem
	 *            the new allow file system
	 */
	public void setAllowFileSystem(boolean allowFileSystem) {

		this.allowFileSystem = allowFileSystem;
		updateButtons();
	}

	/**
	 * Sets the button label.
	 *
	 * @param label
	 *            the new button label
	 */
	public void setButtonLabel(String label) {
		button.setText(label);
	}

	/**
	 * Gets the button label.
	 *
	 * @return the button label
	 */
	public String getButtonLabel() {
		return button.getText();
	}

	/**
	 * Update buttons.
	 */
	private void updateButtons() {
		boolean enableWorkspace = !readOnly && allowWorkspace;
		boolean enableFileSystem = !readOnly && allowFileSystem;
		// ((GridData)browseWorkspace.getLayoutData()).exclude = !allowWorkspace;
		// ((GridData)browse.getLayoutData()).exclude = !allowFileSystem;
		fileSystemMenuItem.setEnabled(enableWorkspace);
		workspaceMenuItem.setEnabled(enableFileSystem);
	}
}
