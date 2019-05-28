package entity;

/**
 * The Class HelloWorld.
 *
 * @author Clément
 */
public class LevelGenerated extends Entity {

	/** The id. */
	private int	id_level;

	/**
	 * Instantiates a new Level.
	 * @param id_level
	 * the id
	 */
	public LevelGenerated(final int id_level) {
		this.setIdLevel(id_level);
	}

	/**
	 * Instantiates a new Level.
	 */
	public LevelGenerated() {
		this(1);
	}

	/**
	 * Gets the id.
	 * @return the id
	 */
	public int getIdLevel() {
		return this.id_level;
	}

	/**
	 * Sets the id.
	 * @param id_level
	 * the new id
	 */
	public void setIdLevel(final int id_level) {
		this.id_level = id_level;
	}

}
