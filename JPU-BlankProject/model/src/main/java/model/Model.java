package model;

import contract.IDAOMap;
import contract.ILevel;
import contract.IModel;
import contract.IView;

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
	private ILevel level;
	/**
	 * The model
	 */
	private static Model model;
	/**
	 * The view
	 */
	private IView view;

	/**
	 * The model
	 */
	final IDAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection(),this);

	/**
	 * The list of levels
	 */
	public ArrayList<Integer> LevelsList;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		Model.model=this;
	}

	/**
	 * set the view
	 * @param view the View
	 */
	public void setView(IView view){
		this.view=view;
		this.addObserver(view.getObserver());
	}

	/**
	 * Get the level
	 * @return The level
	 */
	public ILevel getLevel() {
		try {
			this.level = this.daoMap.getMap(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return level;
	}

	/**
	 * get the instance of the model
	 * @return the model
	 */
	public static Model getInstance(){
		return model;
	}

	/**
	 * The DAOMap
	 * @return the daoMap
	 */
	public IDAOMap getDaoMap(){
		return this.daoMap;
	}

	/**
	 * Update
	 */
	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Load the levels and the level selected
	 */
	public void start(){
		this.loadLevels();
		try {
			this.loadLevel(this.daoMap.getLevelsList().get(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add the diamond collected on the number of diamonds collected
	 */
	public void collectDiamonds() {
		this.getLevel().setDiamondsCollected(this.getLevel().getDiamondsCollected()+1);
	}

	/**
	 * Load all the levels
	 */
	public void loadLevels() {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection(), this);
			daoMap.getLevelsList();
		}
		catch(final SQLException e){
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
	public void loadLevel(int id)  {
		try {
			this.level = daoMap.getMap(id);
			daoMap.getComponents(id);
			this.daoMap.setPlayer();
			this.getLevel().setFinished(false);
			this.getLevel().setPaused(false);
			this.getLevel().setDiamondsCollected(0);
			this.getLevel().getPlayer().setIsAlive(true);
		}
		catch(final SQLException e){
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
