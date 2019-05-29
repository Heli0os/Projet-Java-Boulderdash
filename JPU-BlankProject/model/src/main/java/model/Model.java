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

	/**
	 * The model
	 */
	private Model model;

	/**
	 * The list of levels
	 */
	private ArrayList<Integer> LevelsList;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.player = new Player(1, 1, Direction.UP);
	}

	/**
	 * Get the level
	 * @return The level
	 */
	public Level getLevel() {
		return this.level;
	}

	/**
	 * Update
	 */
	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Add the diamond collected on the number of diamonds collected 
	 */
	public void collectDiamonds() {
		model.getLevel().setDiamondsCollected(model.getLevel().getDiamondsCollected()+1);
	}

	/**
	 * Load all the levels
	 */
	public void loadLevels() {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			daoMap.getLevelsList();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load the level selected
	 * @param id The id of the level
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(int id) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
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

	/**
	 * The list of levels
	 * @return
	 */
	public ArrayList<Integer> getLevelsList() {
		return LevelsList;
	}

	/**
	 * The game is running or not
	 * @return
	 */
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
