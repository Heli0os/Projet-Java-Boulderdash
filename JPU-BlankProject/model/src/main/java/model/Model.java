package model;

import contract.Direction;
import contract.IModel;
import model.Elements.Player;

import java.util.Observable;

/**
 * The Class Model.
 *
 * @author Clément
 */
public final class Model extends Observable implements IModel {

	/** the Level. */
	private Level level;

	/** the Player. */
	private Player player;

	private Model model;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.player = new Player(1, 1, Direction.UP);
	}

	public Level getLevel() {
		return this.level;
	}

	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	public void collectDiamonds() {
		model.getLevel().setDiamondsCollected(model.getLevel().getDiamondsCollected()+1);
	}
	public boolean isGameRunning(){
		return true;
	}

	public Observable getObservable() {
		return this;
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	/*public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}*/



	/**
     * Gets the observable.
     *
     * @return the observable
     */

}
