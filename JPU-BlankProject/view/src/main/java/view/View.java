package view;

import contract.IController;
import contract.IModel;
import contract.IView;

import java.util.Observer;

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
	public View(IModel model) {
		if(model == null)System.err.println("model null in view");
		this.frame = new ViewFrame(model);
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
	 * Open a window and print a message
	 * @param message the message
	 */
	public void printMessage(final String message) {
		this.frame.printMessage(message);
	}

	/**
	 * Set the controller
	 * @param controller The controller
	 */
	public void setController(IController controller) {
		this.frame.setController(controller);
	}
}
