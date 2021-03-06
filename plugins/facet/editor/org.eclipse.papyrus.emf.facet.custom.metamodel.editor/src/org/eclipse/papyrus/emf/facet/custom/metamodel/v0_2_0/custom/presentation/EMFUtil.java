/*******************************************************************************
 * Copyright (c) 2008, 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/** Utility functions related to EMF */
public class EMFUtil {

	/**
	 * @return whether the given EObject is in the first resource of its
	 *         resource set
	 */
	public static boolean isInFirstResource(final EObject eObject) {
		final Resource resource = eObject.eResource();
		if (resource == null) {
			return false;
		}
		final ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null) {
			return false;
		}
		final EList<Resource> resources = resourceSet.getResources();
		if (resources.size() > 0) {
			if (resourceSet.getResources().get(0) == resource) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Search for instances of the given EClass
	 *
	 * @param eClass
	 *            the EClass of the elements that are looked for
	 * @param resource
	 *            the resource to search in
	 * @return elements that are instances of the given EClass
	 */
	public Collection<EObject> findInstancesOf(final EClass eClass, final Resource resource) {
		final ArrayList<EObject> instances = new ArrayList<EObject>();
		final TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			final EObject eObject = allContents.next();
			if (eObject.eClass() == eClass) {
				instances.add(eObject);
			}
		}
		return instances;
	}

	/**
	 * Add all the classes in <code>resources</code> to the <code>classes</code> set
	 */
	private static void addAll(final Set<EClass> classes, final List<Resource> resources) {
		for (final Resource resource : resources) {
			final TreeIterator<EObject> allContents = resource.getAllContents();
			while (allContents.hasNext()) {
				final EObject eObject = allContents.next();
				if (eObject instanceof EClass) {
					final EClass eClass = (EClass) eObject;
					classes.add(eClass);
				}
			}
		}
	}

	/**
	 * Find the most specific metaclass that is common to all of the given
	 * elements.
	 *
	 * @return the common metaclass or <code>null</code> if none was found
	 */
	public static EClass findCommonClass(final List<EObject> elements) {
		// FIXME this algorithm can make a choice about a branch early and not
		// find
		// a solution, when a solution does exist
		EClass eClass = null;
		for (final EObject element : elements) {
			final EClass elementEClass = element.eClass();
			if (eClass == null) {
				eClass = elementEClass;
			} else {
				if (eClass.isSuperTypeOf(elementEClass)) {
					continue;
				} else if (elementEClass.isSuperTypeOf(eClass)) {
					eClass = elementEClass;
				} else {
					// elements are on two different branches
					// try to find a common metaclass
					eClass = findSuperType(eClass, elementEClass);
					if (eClass == null) {
						return null;
					}
				}
			}
		}
		return eClass;
	}

	/**
	 * Find the first superclass of <code>eClass</code> that is a superclass of <code>element</code>
	 */
	private static EClass findSuperType(final EClass eClass, final EClass element) {
		// do a breadth-first search (with a bottom-up tree)
		final LinkedList<EClass> breadthFirstList = new LinkedList<EClass>();
		breadthFirstList.addFirst(eClass);

		while (!breadthFirstList.isEmpty()) {
			final EClass candidateClass = breadthFirstList.poll();

			if (candidateClass.isSuperTypeOf(element)) {
				return candidateClass;
			}

			// add all the direct super-types of this class
			for (final EClass supertype : candidateClass.getESuperTypes()) {
				breadthFirstList.addLast(supertype);
			}
		}

		return null;
	}

	/**
	 * Try to resolve the given proxy.
	 *
	 * @return whether the proxy could be resolved
	 */
	public static boolean tryResolve(final EObject eObject) {
		final EObject resolved = EcoreUtil.resolve(eObject, (EObject) null);
		return !resolved.eIsProxy();
	}

	/** @return the proxy URI for the given EObject or an empty String if none */
	public static String proxyURI(final EObject eObject) {
		final URI eProxyURI = ((InternalEObject) eObject).eProxyURI();
		if (eProxyURI == null) {
			return ""; //$NON-NLS-1$
		}
		return eProxyURI.toString();
	}

	public static <T extends ENamedElement> T findElementWithName(final String name,
			final EList<T> elements) {
		for (T element : elements) {
			if (name.equals(element.getName())) {
				return element;
			}
		}
		return null;
	}

	/**
	 * @return the name of the package in the package registry with this nsURI,
	 *         or <code>null</code> if not found
	 */
	public static String getMetamodelName(final String nsURI) {
		if (nsURI != null) {
			final EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
			if (ePackage != null) {
				final String name = ePackage.getName();
				if (name != null) {
					return name;
				}
			}

			final URI uri = URI.createURI(nsURI);
			final String lastSegment = uri.lastSegment();
			if (lastSegment != null) {
				return lastSegment;
			}
		}
		return null;
	}

	/** @return the list of {@link EClass}es found in the following resource */
	public static List<EClass> getMetaclasses(final Resource metamodel) {
		final List<EClass> metaclasses = new ArrayList<EClass>();
		final TreeIterator<EObject> allContents = metamodel.getAllContents();
		while (allContents.hasNext()) {
			final EObject eObject = allContents.next();
			if (eObject instanceof EClass) {
				final EClass eClass = (EClass) eObject;
				metaclasses.add(eClass);
			}
		}
		return metaclasses;
	}

	/**
	 * Find the {@link EObject} with the given URI in the given {@link ResourceSet}
	 *
	 * @return the element or <code>null</code> if no element was found with
	 *         this URI in the given {@link ResourceSet}
	 */
	public static EObject findElementByURI(final String uriFragment, final ResourceSet resourceSet) {
		EList<Resource> resources = resourceSet.getResources();
		for (Resource resource : resources) {
			EObject eObject = resource.getEObject(uriFragment);
			if (eObject != null) {
				return eObject;
			}
		}
		return null;
	}

}
