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
	public void orderPerform(ControllerOrder controllerOrder);
	public boolean isGamePaused();
	void setGamePaused(boolean isGamePaused);
	void start();
	void play();
	void gameLoop();
}
