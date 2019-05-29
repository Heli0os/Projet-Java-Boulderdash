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

	void update();

	void loadLevels() throws SQLException;

	void loadLevel(int id) throws SQLException;

	ArrayList<Integer> getLevelsList();

    boolean isGameRunning();
}
