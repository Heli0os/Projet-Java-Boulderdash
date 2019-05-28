package contract;

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
}
