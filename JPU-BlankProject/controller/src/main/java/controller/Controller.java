package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 *
 * @author Clément
 */
public final class Controller implements IController {

	/**
	 * References to other controllers
	 */
	EnnemyController ennemyController;
	FallingController fallingController;
	MapController mapController;
	MoveControl moveControl;
	PlayerController playerController;

	/**
	 * The view.
	 */
	private IView view;

	/**
	 * The model.
	 */
	private IModel model;

	/**
	 * the game is over or not
	 */
	private boolean isGameOver = false;
	
	/**
	 * the game is paused or not
	 */
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

		this.fallingController = new FallingController(this.model);
		this.mapController = new MapController(this.model);
		this.moveControl = new MoveControl(this.model);
		this.ennemyController = new EnnemyController(this.model);
		this.playerController = new PlayerController(this.model);
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
				player.move(contract.Direction.UP);
				break;
			case MOVE_LEFT:
				player.move(contract.Direction.LEFT);
				break;
			case MOVE_DOWN:
				player.move(contract.Direction.DOWN);
				break;
			case MOVE_RIGHT:
				player.move(contract.Direction.RIGHT);
				break;
			case PAUSED:
				setGamePaused(true);
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

	/**
	 * Starting the game with the level selected
	 * @param levelIndex The index of the level
	 */
	public void start(int levelIndex) {
		this.model.loadLevels();
		this.model.loadLevel(this.model.getLevelsList().get(levelIndex));
		this.model.getObservable().addObserver(this.view.getObserver());

		this.play(levelIndex);
	}

	/**
	 * Start the gameLoop for the level selected
	 * @param levelIndex The index of the level
	 */
	public void play(int levelIndex) {
		this.gameLoop(levelIndex);
		this.view.close();
	}

	/**
	 * The gameLoop for the level selected
	 * @param levelIndex The index of the level
	 */
	public void gameLoop(int levelIndex) {
		model.getLevel().setDiamondsCollected(0);
		while (!this.isGameOver || !this.isGamePaused || !this.model.getLevel().isFinished()) {
			try {
				Thread.sleep(30);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			ennemyController.performMovement();
			fallingController.detectFallingElements();
			mapController.UpdateMap();
			this.model.update();
		}
		if (this.model.getLevel().isFinished()) {
			this.start(levelIndex++);
		}
	}
}
