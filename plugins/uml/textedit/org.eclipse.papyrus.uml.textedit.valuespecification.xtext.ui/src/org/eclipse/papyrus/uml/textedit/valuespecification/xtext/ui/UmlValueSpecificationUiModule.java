/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui;

import org.eclipse.papyrus.uml.xtext.integration.PapyrusDefaultAutoEditStrategyProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class UmlValueSpecificationUiModule extends org.eclipse.papyrus.uml.textedit.valuespecification.xtext.ui.AbstractUmlValueSpecificationUiModule {
	public UmlValueSpecificationUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.xtext.ui.DefaultUiModule#bindAbstractEditStrategyProvider()
	 */
	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return PapyrusDefaultAutoEditStrategyProvider.class;
	}
}
