/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Benoit Maggi  benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.clipboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * Clipboard for Papyrus Copy : cross Editor and cross model
 *
 * @param <E>
 */
public class PapyrusClipboard<E> extends ArrayList<E> {

	private static final long serialVersionUID = -6902170636133989420L;

	/**
	 * Current papyrus clipboard instance
	 */
	public static PapyrusClipboard<Object> instance = null;

	/**
	 * @return singleton of papyrus clipboard
	 */
	public static PapyrusClipboard<Object> getInstance() {
		if (instance == null) {
			instance = new PapyrusClipboard<Object>();
		}
		return instance;
	}

	/**
	 * Set instance of papyrus clipboard
	 *
	 * @param pInstance
	 */
	public static void setInstance(PapyrusClipboard<Object> pInstance) {
		instance = pInstance;
	}

	/**
	 * Init a new instance for a new copy selection
	 *
	 * @return
	 */
	public static PapyrusClipboard<Object> getNewInstance() {
		instance = new PapyrusClipboard<Object>();
		return instance;
	}

	private static String UNKNOW_TYPE = "unknown"; //$NON-NLS-1$

	/** Type of the source container, ex : type of Diagram */
	protected String containerType;


	/**
	 * @return containerType
	 */
	public String getContainerType() {
		if (containerType != null) {
			return containerType;
		}
		return UNKNOW_TYPE;
	}

	/**
	 * set containerType
	 *
	 * @param containerType
	 */
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	/**
	 * Clean the clipboard (target data) before pasting
	 */
	public void resetTarget() {
		internalClipboardToTargetCopy = new HashMap<Object, EObject>();
	}


	/**
	 * @return true if the clipboard is empty without additional data
	 */
	public boolean isEmptyWithNoAdditionalData() {
		return this.isEmpty() && this.getStrategiesAdditionalData().isEmpty();
	}

	/**
	 * Keeps the mapping between the source and the temporary copy in clipboard
	 * (Can be use for a reference copy strategy)
	 */
	private Map<EObject, Object> sourceToInternalClipboard = new HashMap<EObject, Object>();

	/**
	 * Get the mapping for source to internal clipboard
	 *
	 * @return
	 */
	public Map<EObject, Object> getSourceToInternalClipboard() {
		return sourceToInternalClipboard;
	}

	/**
	 * Keeps the mapping between the internal clipboard copy and the target copy
	 * (Used by paste strategies)
	 */
	private Map<Object, EObject> internalClipboardToTargetCopy = new HashMap<Object, EObject>();


	/**
	 * Get the mapping for internal copy to target copy
	 *
	 * @return
	 */
	public Map<Object, EObject> getInternalClipboardToTargetCopy() {
		return internalClipboardToTargetCopy;
	}

	/**
	 * Store all additional data needed for paste stregies application
	 * key: Strategy id ; Map<E,ClipboardAdditionalData> data for each object
	 */
	private Map<String, Map<E, IClipboardAdditionalData>> strategiesAdditionalData = new HashMap<String, Map<E, IClipboardAdditionalData>>();

	/**
	 * Store internal copy in clipboard while keeping mapping
	 *
	 * @param source
	 *            the copied selection
	 * @param copy
	 *            the temporary copy stored in clipboard
	 */
	public void addInternalCopyInClipboard(EObject source, Object copy) {
		getInstance().add(copy);
		sourceToInternalClipboard.put(source, copy);
	}

	public void addAllInternalCopyInClipboard(Map<EObject, Object> mapInternalCopyInClipboard) {
		getInstance().addAll(mapInternalCopyInClipboard.values());
		sourceToInternalClipboard.putAll(mapInternalCopyInClipboard);
	}


	/**
	 * Store internal copy in clipboard while keeping mapping
	 *
	 * @param source
	 *            the copied selection
	 * @param copy
	 *            the temporary copy stored in clipboard
	 */
	public void addAllInternalToTargetCopy(Map<Object, EObject> mapInternalClipboardToTargetCopy) {
		internalClipboardToTargetCopy.putAll(mapInternalClipboardToTargetCopy);
	}

	/**
	 * Add target for internal copy
	 *
	 * @param copy
	 * @param target
	 */
	public void addTargetForInternalCopy(Object copy, EObject target) {
		internalClipboardToTargetCopy.put(copy, target);
	}

	/**
	 * Iterate on the copy selection
	 * (Use by paste strategy to prepare IAdditionalData)
	 *
	 * @return
	 */
	public Iterator<EObject> iterateOnSource() {
		return sourceToInternalClipboard.keySet().iterator();
	}

	/**
	 * Get the internal clipboard copy from the source selection
	 * (Use by paste strategy to prepare IAdditionalData)
	 *
	 * @return the internal clipboard copy
	 */
	public Object getCopyFromSource(EObject eObject) {
		return sourceToInternalClipboard.get(eObject);
	}

	/**
	 * Get Additional data for all strategies
	 *
	 * @return
	 */
	public Map<String, Map<E, IClipboardAdditionalData>> getStrategiesAdditionalData() {
		return strategiesAdditionalData;
	}

	/**
	 * push data for a specific strategy
	 *
	 * @param key
	 *            of the strategy
	 * @param strategyAdditionalData
	 */
	public void pushAdditionalData(String key, Map<E, IClipboardAdditionalData> strategyAdditionalData) {
		getStrategiesAdditionalData().put(key, strategyAdditionalData);
	}

	/**
	 * Get Additional Data for a strategy
	 *
	 * @param key
	 *            of the strategy
	 * @return
	 */
	public Map<E, IClipboardAdditionalData> getAdditionalDataForStrategy(String key) {
		return getStrategiesAdditionalData().get(key);
	}

	/**
	 * Get the target copy from the internal clipboard copy
	 *
	 * @param object
	 * @return
	 */
	public EObject getTragetCopyFromInternalClipboardCopy(Object object) {
		return internalClipboardToTargetCopy.get(object);
	}

	/**
	 * Iterate on the copy selection
	 * (Use by paste strategy to prepare IAdditionalData)
	 *
	 * @return
	 */
	public Collection<EObject> getTarget() {
		return internalClipboardToTargetCopy.values();
	}

}
