/*****************************************************************************
 * Copyright (c) 2013, 2019 CEA LIST.
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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 496905
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 550568
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.properties.utils;

/**
 * This class defines the contants use for the table property view
 *
 * @author Vincent Lorenzo
 *
 */
public class Constants {

	private Constants() {
		// to prevent instanciation
	}

	/**
	 * The table owner constant.
	 *
	 * @since 2.1
	 */
	public static final String TABLE_OWNER = "owner"; //$NON-NLS-1$

	public static final String TABLE_CONTEXT = "context"; //$NON-NLS-1$

	public static final String TABLE_LABEL = "label"; //$NON-NLS-1$

	public static final String TABLE_PROTOTYPE = "prototype"; //$NON-NLS-1$

	public static final String LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_LABEL = "localColumnHeaderAxisConfiguration.displayLabel"; //$NON-NLS-1$

	public static final String LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_FILTER = "localColumnHeaderAxisConfiguration.displayFilter"; //$NON-NLS-1$

	public static final String LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_INDEX = "localColumnHeaderAxisConfiguration.displayIndex"; //$NON-NLS-1$

	public static final String LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_INDEX_STYLE = "localColumnHeaderAxisConfiguration.indexStyle"; //$NON-NLS-1$

	public static final String LOCAL_ROW_HEADER_AXIS_CONFIGURATION_DISPLAY_LABEL = "localRowHeaderAxisConfiguration.displayLabel"; //$NON-NLS-1$

	public static final String LOCAL_ROW_HEADER_AXIS_CONFIGURATION_DISPLAY_INDEX = "localRowHeaderAxisConfiguration.displayIndex"; //$NON-NLS-1$

	public static final String LOCAL_ROW_HEADER_AXIS_CONFIGURATION_INDEX_STYLE = "localRowHeaderAxisConfiguration.indexStyle"; //$NON-NLS-1$

	public static final String COLUMN_FEATURE_LABEL_PROPERTY_PREFIX = "nattable:table:localColumnHeaderAxisConfiguration:ownedLabelConfigurations:featureLabelProviderConfiguration";



	public static final String COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_ICON = "columnFeatureLabelProviderConfigurationDisplayIcon"; //$NON-NLS-1$

	public static final String COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_LABEL = "columnFeatureLabelProviderConfigurationDisplayLabel"; //$NON-NLS-1$

	public static final String COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_IS_DERIVED = "columnFeatureLabelProviderConfigurationDisplayIsDerived"; //$NON-NLS-1$

	public static final String COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_TYPE = "columnFeatureLabelProviderConfigurationDisplayType"; //$NON-NLS-1$

	public static final String COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_MULTIPLICITY = "columnFeatureLabelProviderConfigurationDisplayMultiplicity"; //$NON-NLS-1$

	public static final String COLUMN__FEATURE_LABEL_CONFIGURATION_DISPLAY_NAME = "columnFeatureLabelProviderConfigurationDisplayName"; //$NON-NLS-1$



	public static final String COLUMN_OBJECT_LABEL_CONFIGURATION_DISPLAY_ICON = "columnObjectLabelProviderConfigurationDisplayIcon"; //$NON-NLS-1$

	public static final String COLUMN_OBJECT_LABEL_CONFIGURATION_DISPLAY_LABEL = "columnObjectLabelProviderConfigurationDisplayLabel"; //$NON-NLS-1$



	public static final String ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_ICON = "rowFeatureLabelProviderConfigurationDisplayIcon"; //$NON-NLS-1$

	public static final String ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_LABEL = "rowFeatureLabelProviderConfigurationDisplayLabel"; //$NON-NLS-1$

	public static final String ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_IS_DERIVED = "rowFeatureLabelProviderConfigurationDisplayIsDerived"; //$NON-NLS-1$

	public static final String ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_TYPE = "rowFeatureLabelProviderConfigurationDisplayType"; //$NON-NLS-1$

	public static final String ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_MULTIPLICITY = "rowFeatureLabelProviderConfigurationDisplayMultiplicity"; //$NON-NLS-1$

	public static final String ROW__FEATURE_LABEL_CONFIGURATION_DISPLAY_NAME = "rowFeatureLabelProviderConfigurationDisplayName"; //$NON-NLS-1$



	public static final String ROW_OBJECT_LABEL_CONFIGURATION_DISPLAY_ICON = "rowObjectLabelProviderConfigurationDisplayIcon"; //$NON-NLS-1$

	public static final String ROW_OBJECT_LABEL_CONFIGURATION_DISPLAY_LABEL = "rowObjectLabelProviderConfigurationDisplayLabel"; //$NON-NLS-1$



	public static final String ROW_PASTED_EOBJECT_ID = "localRowHeaderAxisConfiguration.pastedEObjectId";//$NON-NLS-1$

	public static final String ROW_PASTED_EOBJECT_CONTAINMENT_FEATURE = "localRowHeaderAxisConfiguration.pastedEObjectContainmentFeature";//$NON-NLS-1$

	public static final String ROW_PASTED_OBJECT_DETACHED_MODE_FEATURE = "localRowHeaderAxisConfiguration.detachedMode";//$NON-NLS-1$

	public static final String ROW_PASTED_OBJECT_POST_ACTIONS_FEATURE = "localRowHeaderAxisConfiguration.postActions";//$NON-NLS-1$

	public static final String COLUMN_PASTED_EOBJECT_ID = "localColumnHeaderAxisConfiguration.pastedEObjectId";//$NON-NLS-1$

	public static final String ROW_PASTED_EOBJECT_AXIS_IDENTIFIER_FEATURE = "localRowHeaderAxisConfiguration.axisIdentifier";//$NON-NLS-1$

	public static final String COLUMN_PASTED_EOBJECT_CONTAINMENT_FEATURE = "localColumnHeaderAxisConfiguration.pastedEObjectContainmentFeature";//$NON-NLS-1$

	public static final String COLUMN_PASTED_OBJECT_DETACHED_MODE_FEATURE = "localColumnHeaderAxisConfiguration.detachedMode";//$NON-NLS-1$

	public static final String COLUMN_PASTED_OBJECT_POST_ACTIONS_FEATURE = "localColumnHeaderAxisConfiguration.postActions";//$NON-NLS-1$

	public static final String COLUMN_PASTED_EOBJECT_AXIS_IDENTIFIER_FEATURE = "localColumnHeaderAxisConfiguration.axisIdentifier";//$NON-NLS-1$

}
