/*****************************************************************************
 * Copyright (c) 2009, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.pages;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramsPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.PapyrusPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.AbstractGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.BackgroundColor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.ConnectionGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.DecorationGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.FontGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.NodeColorGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.RulersAndGridGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.diagram.DiagramBackgroundColor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.diagram.DiagramConnectionGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.diagram.DiagramDecorationGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.diagram.DiagramFontGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.diagram.DiagramNodeColorGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.diagram.DiagramRulersAndGridGroup;
import org.eclipse.papyrus.infra.ui.preferences.IPapyrusPreferencePage;
import org.eclipse.papyrus.infra.ui.preferences.VisiblePageSingleton;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 */
public class DiagramPreferencePage extends DiagramsPreferencePage implements IPapyrusPreferencePage {


	private Set<AbstractGroup> groupSet;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		initGroup();
	}

	private String key = null;

	@Override
	protected Control createContents(Composite parent) {
		Group contentGroup = new Group(parent, 2);
		contentGroup.setLayout(new GridLayout(4, false));

		// FontGroup
		FontGroup fontGroupComposite = new DiagramFontGroup(contentGroup, getPreferenceKey(), this);
		addAbstractGroup(fontGroupComposite);
		// color
		NodeColorGroup colorGroupForNodeComposite = new DiagramNodeColorGroup(contentGroup, getPreferenceKey(), this);
		addAbstractGroup(colorGroupForNodeComposite);


		// router for links
		ConnectionGroup connectionGroupComposite = new DiagramConnectionGroup(contentGroup, getPreferenceKey(), this);
		addAbstractGroup(connectionGroupComposite);

		// background
		BackgroundColor backgroundColorGroup = new DiagramBackgroundColor(contentGroup, getPreferenceKey(), this);
		addAbstractGroup(backgroundColorGroup);

		DecorationGroup decorationGroupComposite = new DiagramDecorationGroup(contentGroup, getPreferenceKey(), this);
		addAbstractGroup(decorationGroupComposite);

		RulersAndGridGroup viewGroupComposite = new DiagramRulersAndGridGroup(parent, getPreferenceKey(), this);
		addAbstractGroup(viewGroupComposite);
		return super.createContents(parent);
	}

	protected String getPreferenceKey() {
		return this.key;
	}

	/**
	 * Init groups contained in this page.
	 */
	private void initGroup() {
		if (groupSet != null) {
			for (AbstractGroup gs : groupSet) {
				gs.setPreferenceStore(getPreferenceStore());
				gs.load();
			}
		}
	}

	@Override
	public boolean performOk() {
		VisiblePageSingleton.getInstance().store();
		return super.performOk();
	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	public void storePreferences() {
		if (groupSet != null) {
			for (AbstractGroup gs : groupSet) {
				gs.storePreferences();
			}
		}

	}

	/**
	 * store all preferences
	 */
	public void storeAllPreferences() {
		storePreferences();
		((PapyrusPreferenceStore) getPreferenceStore()).deleteAllSubPreference(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX);

	}

	protected void setPreferenceKey(String aKey) {
		this.key = aKey;
	}

	@Override
	public void dispose() {
		super.dispose();
		if (groupSet != null) {
			for (AbstractGroup gs : groupSet) {
				gs.dispose();
			}
		}


	}

	/**
	 * Add the given field editor to the page.
	 */
	protected void addAbstractGroup(AbstractGroup fe) {
		if (groupSet == null) {
			groupSet = new HashSet<AbstractGroup>();
		}
		groupSet.add(fe);
	}

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	private void loadDefaultPreferences() {
		if (groupSet != null) {
			for (AbstractGroup gs : groupSet) {
				gs.loadDefault();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	@Override
	protected void performDefaults() {
		loadDefaultPreferences();
		super.performDefaults();
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible == true) {
			VisiblePageSingleton.getInstance().setVisiblePage(this);
			initGroup();
		}
		super.setVisible(visible);

	}
}
