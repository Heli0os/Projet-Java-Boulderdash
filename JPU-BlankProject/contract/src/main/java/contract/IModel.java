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

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	void update();

	void loadLevels();

	void loadLevel(int id);

	ArrayList<Integer> getLevelsList();

    boolean isGameRunning();
}
