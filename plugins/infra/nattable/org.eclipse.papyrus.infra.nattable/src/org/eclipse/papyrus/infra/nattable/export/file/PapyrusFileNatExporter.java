/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.export.file;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.nebula.widgets.nattable.Messages;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.export.ExportConfigAttributes;
import org.eclipse.nebula.widgets.nattable.export.IExportFormatter;
import org.eclipse.nebula.widgets.nattable.export.ILayerExporter;
import org.eclipse.nebula.widgets.nattable.formula.command.DisableFormulaEvaluationCommand;
import org.eclipse.nebula.widgets.nattable.formula.command.EnableFormulaEvaluationCommand;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.print.command.PrintEntireGridCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOffCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOnCommand;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.summaryrow.command.CalculateSummaryRowValuesCommand;
import org.eclipse.nebula.widgets.nattable.util.IClientAreaProvider;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.style.configattribute.PapyrusExportConfigAttributes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/**
 * The nattable file exporter.
 * 
 * @since 2.0
 */
public class PapyrusFileNatExporter {

	/**
	 * The parent shell.
	 */
	private final Shell shell;
	
	/**
	 * Boolean to determinate if this must be used in a shell or not.
	 */
	private final boolean runInShell;
	
	/**
	 * Constructor.
	 *
	 * @param shell The parent shell.
	 */
	public PapyrusFileNatExporter(final Shell shell) {
		this(shell, true);
	}

	/**
	 * Constructor.
	 *
	 * @param shell The parent shell.
	 * @param runInShell Boolean to determinate if this must be used in a shell or not.
	 */
	public PapyrusFileNatExporter(final Shell shell, final boolean runInShell) {
		this.shell = shell;
		this.runInShell = runInShell;
	}

	/**
	 * Exports a single ILayer using the ILayerExporter registered in the
	 * ConfigRegistry.
	 *
	 * @param layer
	 *            The ILayer to export, usually a NatTable instance.
	 * @param configRegistry
	 *            The ConfigRegistry of the NatTable instance to export, that contains the necessary export configurations.
	 */
	public void exportSingleLayer(
			final ILayer layer,
			final IConfigRegistry configRegistry) {

		final ILayerExporter exporter = configRegistry.getConfigAttribute(
				PapyrusExportConfigAttributes.SIMPLE_FILE_EXPORTER,
				DisplayMode.NORMAL);

		final OutputStream outputStream = exporter.getOutputStream(this.shell);
		if (null == outputStream) {
			return;
		}

		Runnable exportRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					exporter.exportBegin(outputStream);

					exportLayer(exporter, outputStream, "", layer, configRegistry); //$NON-NLS-1$

					exporter.exportEnd(outputStream);
				} catch (final IOException e) {
					throw new RuntimeException("Failed to export.", e); //$NON-NLS-1$
				} finally {
					try {
						outputStream.close();
					} catch (IOException e) {
						Activator.log.error("Failed to close the output stream", e); //$NON-NLS-1$
					}
				}
			}
		};

		if (null != this.shell && runInShell) {
			// Run with the SWT display so that the progress bar can paint
			this.shell.getDisplay().asyncExec(exportRunnable);
		} else {
			exportRunnable.run();
		}
	}

	/**
	 * Exports the given layer to the outputStream using the provided exporter.
	 * The exporter.exportBegin() method should be called before this method is
	 * invoked, and exporter.exportEnd() should be called after this method
	 * returns. If multiple layers are being exported as part of a single
	 * logical export operation, then exporter.exportBegin() will be called once
	 * at the very beginning, followed by n calls to this exportLayer() method,
	 * and finally followed by exporter.exportEnd().
	 *
	 * @param exporter The exporter to use writing the outputstream.
	 * @param outputStream The outputstream where write the result.
	 * @param layerName The layer name.
	 * @param layer The ILayer to export, usually a NatTable instance.
	 * @param configRegistry The ConfigRegistry of the NatTable instance to export, that contains the necessary export configurations.
	 */
	protected void exportLayer(
			final ILayerExporter exporter,
			final OutputStream outputStream,
			final String layerName,
			final ILayer layer,
			final IConfigRegistry configRegistry) {

		final IClientAreaProvider originalClientAreaProvider = layer.getClientAreaProvider();

		// This needs to be done so that the layer can return all the cells
		// not just the ones visible in the viewport
		layer.doCommand(new TurnViewportOffCommand());
		setClientAreaToMaximum(layer);

		// if a SummaryRowLayer is in the layer stack, we need to ensure that
		// the values are calculated
		layer.doCommand(new CalculateSummaryRowValuesCommand());

		// if a FormulaDataProvider is involved, we need to ensure that the
		// formula evaluation is disabled so the formula itself is exported
		// instead of the calculated value
		layer.doCommand(new DisableFormulaEvaluationCommand());

		ProgressBar progressBar = null;

		if (null != this.shell && runInShell) {
			final Shell childShell = new Shell(this.shell.getDisplay(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			childShell.setText(Messages.getString("NatExporter.exporting")); //$NON-NLS-1$

			int startRow = 0;
			int endRow = layer.getRowCount() - 1;

			progressBar = new ProgressBar(childShell, SWT.SMOOTH);
			progressBar.setMinimum(startRow);
			progressBar.setMaximum(endRow);
			progressBar.setBounds(0, 0, 400, 25);
			progressBar.setFocus();

			childShell.pack();
			childShell.open();
		}

		try {
			exporter.exportLayerBegin(outputStream, layerName);

			for (int rowPosition = 0; rowPosition < layer.getRowCount(); rowPosition++) {
				exporter.exportRowBegin(outputStream, rowPosition);
				if (null != progressBar) {
					progressBar.setSelection(rowPosition);
				}

				for (int columnPosition = 0; columnPosition < layer.getColumnCount(); columnPosition++) {
					final ILayerCell cell = layer.getCellByPosition(columnPosition, rowPosition);

					final IExportFormatter exportFormatter = configRegistry.getConfigAttribute(
							ExportConfigAttributes.EXPORT_FORMATTER,
							cell.getDisplayMode(),
							cell.getConfigLabels().getLabels());
					final Object exportDisplayValue = exportFormatter.formatForExport(cell, configRegistry);

					exporter.exportCell(outputStream, exportDisplayValue, cell, configRegistry);
				}

				exporter.exportRowEnd(outputStream, rowPosition);
			}

			exporter.exportLayerEnd(outputStream, layerName);
		} catch (final Exception e) {
			Activator.log.error("Export failed", e); //$NON-NLS-1$
		} finally {
			// These must be fired at the end of the thread execution
			layer.setClientAreaProvider(originalClientAreaProvider);
			layer.doCommand(new TurnViewportOnCommand());

			layer.doCommand(new EnableFormulaEvaluationCommand());

			if (null != progressBar) {
				Shell childShell = progressBar.getShell();
				progressBar.dispose();
				childShell.dispose();
			}
		}
	}

	/**
	 * This allows to maximize the client area.
	 * 
	 * @param layer The ILayer to export, usually a NatTable instance.
	 */
	private void setClientAreaToMaximum(final ILayer layer) {
		final Rectangle maxClientArea = new Rectangle(0, 0, layer.getWidth(), layer.getHeight());

		layer.setClientAreaProvider(new IClientAreaProvider() {
			@Override
			public Rectangle getClientArea() {
				return maxClientArea;
			}
		});

		layer.doCommand(new PrintEntireGridCommand());
	}
}
