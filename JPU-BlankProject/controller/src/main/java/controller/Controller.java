package controller;

import contract.*;

/**
 * The Class Controller.
 *
 * @author Clément
 */
public final class Controller implements IController {

	/**
	 * References to other controllers
	 */
	private EnnemyController ennemyController;
	private FallingController fallingController;
	private MapController mapController;
	private MoveControl moveControl;
	private PlayerController playerController;

	/**
	 * The view.
	 */
	private IView view;

	/**
	 * The model.
	 */
	private IModel model;

    /**
     * The daoMap.
     */
	private IDAOMap daoMap;

	/**
	 * Instantiates a new controller.
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(IView view,IModel model) {
		this.view = view;
		this.model = model;
		this.daoMap = this.model.getDaoMap();
		this.fallingController = new FallingController(this.model);
		this.mapController = new MapController(this.model);
		this.moveControl = new MoveControl(this.model);
		this.ennemyController = new EnnemyController(this.model);
		this.playerController = new PlayerController(this.model);
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
		switch (controllerOrder) {
			case MOVE_UP:
				this.playerController.move(contract.Direction.UP);
				break;
			case MOVE_LEFT:
				this.playerController.move(contract.Direction.LEFT);
				break;
			case MOVE_DOWN:
				this.playerController.move(contract.Direction.DOWN);
				break;
			case MOVE_RIGHT:
				this.playerController.move(contract.Direction.RIGHT);
				break;
			case PAUSED:
				this.model.getLevel().setPaused(true);
				if (this.model.getLevel().isPaused()) {
					this.model.getLevel().setPaused(false);
				}
			default:
				break;
		}
	}

	/**
	 * Starting the game with a welcome message and load all the levels
	 */
	public void start() {
		this.view.printMessage("Welcome in the Boulderdash Game" + "\n" + "Made by" + "\n" + "AMARY Clément" + "\n" + "MONTEMONT Théophile" + "\n" + "ALBERT Naomie" + "\n" + "MOENSCH Baptiste" + "\n" + "Player control : Z (UP), Q (LEFT), S (DOWN), D (RIGHT)" + "\n" + "Good game !");
		this.model.loadLevels();
		this.model.getObservable().addObserver(this.view.getObserver());
		//this.play(levelIndex);
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
		while (!this.model.getLevel().isFinished() && this.model.getLevel().getPlayer().isAlive()) {
			try {
				Thread.sleep(100);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			this.ennemyController.performMovement();
			this.fallingController.detectFallingElements();
			this.mapController.UpdateMap();
			this.model.update();
		}
	}
}
