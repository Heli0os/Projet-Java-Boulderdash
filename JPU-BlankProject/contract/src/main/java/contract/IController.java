package contract;

/**
 * The Interface IController.
 *
 * @author Clément
 */
public interface IController {

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	void orderPerform(ControllerOrder controllerOrder);

	/**
	 * The game is paused or not
	 * @return
	 */
	boolean isGamePaused();

	/**
	 * set the game paused or not
	 * @param isGamePaused
	 */
	void setGamePaused(boolean isGamePaused);


	/**
	 * Start the game
	 * @param levelIndex
	 */
	void start(int levelIndex);

	/**
	 * Function play that will launch the gameLoop
	 * @param levelIndex
	 */
	void play(int levelIndex);

	/**
	 * Function that will launch movements while the game isn't finished or paused
	 * @param levelIndex
	 */
	void gameLoop(int levelIndex);
}
