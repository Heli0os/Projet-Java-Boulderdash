package contract;

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
	void setView(IView view);

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


	/**
	 * load all the levels
	 */
	void loadLevels();


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
