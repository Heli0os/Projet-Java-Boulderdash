package view;

import java.util.Observer;
import contract.IController;
import contract.IView;

/**
 * The Class View.
 *
 * @author Clément
 */
public class View implements IView {

	/**
	 * The viewFrame
	 */
	private ViewFrame frame;

	/**
	 * The constructor of the view
	 */
	public View() {
		this.frame = new ViewFrame();
	}

	/**
	 * repaint the view
	 */
	public void repaint() {

	}

	/**
	 * close the view
	 */
	public void close() {
		this.frame.dispose();
	}

	/**
	 * Get the observer
	 * @return The observer
	 */
	public Observer getObserver() {
		return this.frame.getViewPanel();
	}

	/**
	 * Set the controller
	 * @param controller The controller
	 */
	public void setController(IController controller) {
		this.frame.setController(controller);
	}
}
