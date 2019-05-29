package contract;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Clément
 */
public interface IModel {

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	ILevel getLevel();
	IDAOMap getDaoMap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	/**
	 * update the model
	 */
	void update();

	void loadLevels() throws SQLException;
	/**
	 * load all the levels
	 */
	void loadLevels();

	void loadLevel(int id) throws SQLException;
	/**
	 * load the level selected
	 * @param id The id of the level
	 */
	void loadLevel(int id);

	/**
	 * the list of levels
	 * @return
	 */
	ArrayList<Integer> getLevelsList();

	/**
	 * says if the game is running or not
	 * @return
	 */
	boolean isGameRunning();
}
