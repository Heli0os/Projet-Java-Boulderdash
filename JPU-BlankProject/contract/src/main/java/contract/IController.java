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
	boolean isGamePaused();
	void setGamePaused(boolean isGamePaused);
	void start(int levelIndex);
	void play(int levelIndex);
	void gameLoop(int levelIndex);
}
