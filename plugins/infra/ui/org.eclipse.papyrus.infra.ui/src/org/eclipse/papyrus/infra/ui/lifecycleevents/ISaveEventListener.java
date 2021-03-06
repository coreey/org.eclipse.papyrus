/**
 *
 */
package org.eclipse.papyrus.infra.ui.lifecycleevents;

/**
 * Interface used to listen on open, save and saveAs events.
 *
 * @author cedric dumoulin
 *
 * @param <T>
 *            Type of event passed to methods.
 * @since 1.2
 */
public interface ISaveEventListener {

	/**
	 *
	 * @param editor
	 */
	public void doSave(DoSaveEvent event);

	/**
	 *
	 * @param editor
	 */
	public void doSaveAs(DoSaveEvent event);
}
