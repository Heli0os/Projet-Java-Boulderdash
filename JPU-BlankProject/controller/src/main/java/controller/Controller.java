package controller;

import contract.*;

/**
 * The Class Controller.
 *
 * @author Clément
 */
public final class Controller implements IController {

	/**
	 * The view.
	 */
	private IView view;

	/**
	 * The model.
	 */
	private IModel model;

	private boolean isGameOver = false;
	private boolean isGamePaused = false;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
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
			case PAUSED:
				isGamePaused = true;
			default:
				break;
		}
	}

	@Override
	public boolean isGamePaused() {
		return false;
	}

	@Override
	public void setGamePaused(boolean isGamePaused) {
	}

	public void start() {
		this.model.loadLevels();
		this.model.loadLevel(this.model.getLevelsList().get(0));
		this.model.getObservable().addObserver(this.view.getObserver());
		this.play();
	}

	public void play() {
		this.gameLoop();
		this.view.close();
	}

	public void gameLoop() {
		while (!this.isGameOver || !this.isGamePaused) {
			try {
				Thread.sleep(30);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			this.model.update();
		}
	}
}
