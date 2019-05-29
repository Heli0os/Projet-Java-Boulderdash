package contract;

import java.sql.SQLException;

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
	void start(int levelIndex) throws SQLException;
	void play(int levelIndex) throws SQLException;
	void gameLoop(int levelIndex) throws SQLException;
}
