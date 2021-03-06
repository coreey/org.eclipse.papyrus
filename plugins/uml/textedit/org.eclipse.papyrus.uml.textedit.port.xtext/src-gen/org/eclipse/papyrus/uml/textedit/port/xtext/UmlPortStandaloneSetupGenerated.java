/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.port.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
@SuppressWarnings("all")
public class UmlPortStandaloneSetupGenerated implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.papyrus.uml.alf.CommonStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}

	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.papyrus.uml.textedit.port.xtext.UmlPortRuntimeModule());
	}

	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/papyrus/uml/textedit/port/xtext/UmlPort")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/papyrus/uml/textedit/port/xtext/UmlPort", org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage.eINSTANCE);
		}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("umlport", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("umlport", serviceProvider);




	}
}
