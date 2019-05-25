package controller;

import contract.*;

/**
 * The Class Controller.
 * 
 * @author Clément 
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Player control : Z (UP), Q (LEFT), S (DOWN), D (RIGHT)");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		PlayerController player = PlayerController.getInstance();
		switch (controllerOrder) {
			case MOVE_UP:
				player.move(Direction.UP);
				break;
			case MOVE_LEFT:
				player.move(Direction.LEFT);
				break;
			case MOVE_DOWN:
				player.move(Direction.DOWN);
				break;
			case MOVE_RIGHT:
				player.move(Direction.RIGHT);
				break;
			default:
				break;
		}
	}
/* ajout de plusieurs fonctions en attente*/
}
