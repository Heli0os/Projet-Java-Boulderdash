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

	private ViewFrame frame;

	public View() {
		this.frame = new ViewFrame();
	}

	public void repaint() {

	}

	public Observer getObserver() {
		return this.frame.getViewPanel();
	}

	public void setController(IController controller) {
		this.frame.setController(controller);
	}
}
