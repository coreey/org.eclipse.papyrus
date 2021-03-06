/*****************************************************************************
 * Copyright (c) 2010, 2021 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Strategy improvement of generated files
 *  Christian W. Damus (CEA) - bug 422257
 *  Christian W. Damus - bug 573987
 *
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.generation.wizard;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.customization.properties.generation.extensionpoint.LayoutExtensionPoint;
import org.eclipse.papyrus.customization.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.customization.properties.generation.layout.ILayoutGenerator;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.papyrus.customization.properties.generation.validators.SourceValidator;
import org.eclipse.papyrus.customization.properties.generation.validators.TargetValidator;
import org.eclipse.papyrus.customization.properties.generation.wizard.widget.FileChooser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

/**
 * A WizardPage to display the selected generator's options, as well as the
 * context's target file. The options depend on the selected generator.
 *
 * @author Camille Letavernier
 */
public class GeneratorPage extends AbstractCreateContextPage implements Listener {

	private final List<ILayoutGenerator> layoutGenerators;

	protected IGenerator generator;

	private Composite root, generatorControl;

	protected FileChooser targetFileChooser;

	private CCombo layoutCombo;

	protected IObservableValue srcTextObservable;

	protected IObservableValue targetTextObservable;

	protected UpdateValueStrategy srcFieldStrategy;

	protected UpdateValueStrategy targetFieldStrategy;

	protected SourceValidator srcValidator;

	protected TargetValidator targetValidator;

	protected Binding binding;

	protected DataBindingContext ctx;

	protected boolean next = false;

	protected URI oldURI;

	/**
	 * Constructor.
	 */
	public GeneratorPage() {
		super(Messages.GeneratorPage_title);
		ctx = new DataBindingContext();
		srcFieldStrategy = new UpdateValueStrategy();
		targetFieldStrategy = new UpdateValueStrategy();

		layoutGenerators = new LayoutExtensionPoint().getGenerators();
	}

	/**
	 * Sets the IGenerator for this wizard, and displays its controls in the
	 * page.
	 *
	 * @param generator
	 */
	public void setGenerator(IGenerator generator) {
		cleanGeneratorControl();
		generator.addListener(this);

		setDescription(generator.getDescription());
		this.generator = generator;
		generator.createControls(generatorControl, getWizard().getCurrentlySelectedFile().orElse(null));
		generatorControl.layout();
		srcTextObservable = this.generator.getObservableValue();
		root.layout();
	}

	@Override
	public void dispose() {
		this.generator.removeListener(this);
	}

	@Override
	public boolean isPageComplete() {
		return targetFileChooser.getFilePath() != null && (generator != null && generator.isReady());
	}

	private void cleanGeneratorControl() {
		for (Control control : generatorControl.getChildren()) {
			control.dispose();
		}
	}

	@Override
	public void createControl(Composite parent) {
		root = new Composite(parent, SWT.NONE);
		root.setLayout(new GridLayout(2, false));
		root.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		generatorControl = new Composite(root, SWT.NONE);
		generatorControl.setLayout(new FillLayout());
		generatorControl.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		Label layoutGeneratorLabel = new Label(root, SWT.NONE);
		layoutGeneratorLabel.setText(Messages.GeneratorPage_layoutGenerator);
		GridData data = new GridData();
		data.widthHint = 100;
		layoutGeneratorLabel.setLayoutData(data);

		layoutCombo = new CCombo(root, SWT.BORDER);
		layoutCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		layoutCombo.setEditable(false);
		layoutCombo.setBackground(new Color(layoutCombo.getDisplay(), 255, 255, 255));
		for (ILayoutGenerator layoutGenerator : layoutGenerators) {
			layoutCombo.add(layoutGenerator.getName());
		}
		layoutCombo.select(0);

		Label targetLabel = new Label(root, SWT.NONE);
		targetLabel.setText(Messages.GeneratorPage_target);
		data = new GridData();
		data.widthHint = 100;
		targetLabel.setLayoutData(data);

		targetFileChooser = new FileChooser(root, true);
		targetFileChooser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		targetFileChooser.addListener(this);
		targetTextObservable = targetFileChooser.getObservableValue();
		targetFileChooser.setFilterExtensions(new String[] { "ctx" });
		if (targetFieldStrategy != null) {
			targetFieldStrategy.setConverter(new IConverter() {

				@Override
				public Object getToType() {

					return String.class;
				}

				@Override
				public Object getFromType() {
					return String.class;
				}

				@Override
				public String convert(Object fromObject) {
					if (srcTextObservable != null) {
						return (String) srcTextObservable.getValue();
					} else if (targetFileChooser.getFilePath() != null) {
						return targetFileChooser.getFilePath();

					}
					return "";
				}
			});
		}
		if (srcFieldStrategy != null) {
			srcFieldStrategy.setConverter(new IConverter() {

				@Override
				public Object getToType() {
					return String.class;
				}

				@Override
				public Object getFromType() {
					return String.class;
				}

				@Override
				public String convert(Object fromObject) {

					if (fromObject instanceof String) {
						String stringObject = (String) fromObject;
						if (stringObject.equals("")) {
							return "";
						}
						String[] result = stringObject.split("/");
						String filename = result[result.length - 1];
						String[] ext = filename.split("\\.");
						StringBuilder builder = new StringBuilder();

						if (targetTextObservable != null) {
							String s = (String) targetTextObservable.getValue();
							if (!s.equals("")) {
								String original[] = s.split("/");
								builder.append("/");
								for (int i = 1; i < original.length - 1; i++) {
									builder.append(original[i]);
									builder.append("/");

								}
							} else {
								builder.append("/");
								builder.append(result[1]);
								builder.append("/properties/");
							}
						}

						builder.append(ext[0]);
						builder.append(".ctx");
						return builder.toString();
					}
					return "";
				}
			});
		}
		WizardPageSupport.create(this, ctx);


		setControl(root);
	}

	@Override
	public void handleEvent(Event event) {

		String filePath = targetFileChooser.getFilePath();

		if (filePath != null) {
			super.getContainer().updateButtons();
		}



	}

	@Override
	public IWizardPage getNextPage() {
		int selection = layoutCombo.getSelectionIndex();
		getWizard().layoutGenerator = layoutGenerators.get(selection);
		oldURI = URI.createPlatformResourceURI(targetFileChooser.getFilePath(), true);

		return super.getNextPage();
	}

	public void doBinding() {
		if (srcTextObservable != null || targetTextObservable != null) {

			srcValidator = new SourceValidator(generator);
			targetValidator = new TargetValidator();
			srcFieldStrategy.setAfterGetValidator(srcValidator);
			srcFieldStrategy.setAfterConvertValidator(targetValidator);
			targetFieldStrategy.setAfterGetValidator(targetValidator);
			targetFieldStrategy.setAfterConvertValidator(srcValidator);
			binding = ctx.bindValue(srcTextObservable, targetTextObservable, srcFieldStrategy, targetFieldStrategy);

			binding.getValidationStatus().addValueChangeListener(event -> {
				IStatus status = event.diff.getNewValue();
				if (status.isOK() || status.getSeverity() == IStatus.WARNING) {
					setNext(true);
				} else {
					setNext(false);
				}
			});

			// The source file is the "target", which the binding would not normally update to the "model."
			// But if the source file is already suggested, then we do want to initialize the output file
			// from it, so update the "target" to the "model" in binding-speak
			if (srcTextObservable.getValue() != null && !"".equals(srcTextObservable.getValue())) {
				binding.updateTargetToModel();
			}
		}
	}

	@Override
	public boolean canFlipToNextPage() {
		return this.next;
	}

	public void setNext(boolean next) {
		this.next = next;
		super.getContainer().updateButtons();


	}


	public void setStrategy(int strategy) {
		this.generator.setStrategy(strategy);

	}

}
