package model;

import contract.Direction;
import contract.IDAOMap;
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
	private static Model model;

	/** the Player. */
	private Player player;


	final IDAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection(),this);

	public ArrayList<Integer> LevelsList;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.player = new Player(1, 1, Direction.UP);
		this.model=this;
	}

	public Level getLevel() {
		return this.level;
	}

	public static Model getInstance(){
		if (model == null)
		{
			System.err.println("no model created");
		}

		return model;
	}

	public IDAOMap getDaoMap(){
		return this.daoMap;
	}

	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	public void collectDiamonds() {
		this.getLevel().setDiamondsCollected(this.getLevel().getDiamondsCollected()+1);
	}

	public void loadLevels() throws SQLException {
			daoMap.getLevelsList();
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(int id) throws SQLException {
			daoMap.getMap(id);
			daoMap.getComponents(id);
			this.getLevel().getPlayer().isAlive();
			this.getLevel().setFinished(false);
			this.getLevel().setPaused(false);
			this.getLevel().setDiamondsCollected(0);
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
