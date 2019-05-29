package model;

import contract.Direction;
import contract.IModel;
import model.Elements.Player;

import java.sql.SQLException;
import java.util.ArrayList;
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

	public ArrayList<Integer> LevelsList;

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

	public void loadLevels() {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection(),this);
			daoMap.getLevelsList();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(int id) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection(),this);
			daoMap.getMap(id);
			daoMap.getComponents(id);
			this.getLevel().getPlayer().isAlive();
			this.getLevel().setFinished(false);
			this.getLevel().setPaused(false);
			this.getLevel().setDiamondsCollected(0);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Integer> getLevelsList() {
		return LevelsList;
	}

	public boolean isGameRunning(){return true;}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
