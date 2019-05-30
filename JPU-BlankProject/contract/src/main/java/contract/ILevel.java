package contract;

/**
 * The Interface IModel.
 *
 * @author Clément
 */
public interface ILevel {

    /**
     * get the id of the level
     * @return
     */
    int getId();

    /**
     * set the id of the level
     * @param id
     */
    void setId(int id);

    /**
     * get the name of the level
     * @return
     */
    String getName();

    /**
     * set the name of the level
     * @param name The name
     */
    void setName(String name);

    /**
     * get the number of diamonds you must get in the level
     * @return
     */
    int getDiamondsNumber();

    /**
     * set the number of diamonds you must get in the level
     * @param diamondsNumber The number of diamonds to get in the level
     */
    void setDiamondsNumber(int diamondsNumber);

    /**
     * get the player
     * @return
     */
    IPlayer getPlayer();


    /**
     * set the player
     * @param player
     */
    void setPlayer(IPlayer player);

    /**
     * the level is finished or not
     * @return
     */
    boolean isFinished();

    /**
     * set the level as finished or not
     * @param finished
     */
    void setFinished(boolean finished);

    /**
     * the game is paused or not
     * @return
     */
    boolean isPaused();

    /**
     * set the game as paused or not
     * @param paused
     */
    void setPaused(boolean paused);

    /**
     * get the number of diamonds collected
     * @return The number of diamonds collected
     */
    int getDiamondsCollected();

    /**
     * set the number of diamonds collected
     * @param diamondsCollected The number of diamonds collected
     */
    void setDiamondsCollected(int diamondsCollected);

    /**
     * get the Dimensions
     * @return Dimensions
     */
    IDimensions getDimensions();

    /**
     * set the Dimensions
     * @param dimensions The dimensions
     */
    void setDimensions (IDimensions dimensions);

    /**
     * get the Elements
     * @return
     */
    IElements[][] getElements();

    /**
     * get the Element at a defined position
     * @param x The y position
     * @param y The x position
     * @return
     */
    IElements getElement(int x,int y);

    /**
     * set the Element with his position
     * @param element The element
     * @param x The x position
     * @param y The y position
     */
    void setElement(IElements element,int x,int y);

}
