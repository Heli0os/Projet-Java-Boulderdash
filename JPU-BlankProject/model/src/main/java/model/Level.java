package model;

import contract.*;

/**
 * The Class Model.
 *
 * @author Clément
 */
public class Level implements ILevel {

    private IPlayer player;

    /**
     * The player
     */


    /**
     * The id
     */
    private int id;

    /**
     * The dimensions
     */
    private IDimensions dimensions;

    /**
     * The name
     */
    private String name;

    /**
     * The number of diamonds in the level
     */
    private int diamondsNumber;

    /**
     * The level is finished or not
     */
    private boolean finished;

    /**
     * The level is paused or not
     */
    private boolean paused;

    /**
     * The number of diamonds collected
     */
    private int diamondsCollected;


    /**
     * The constructor of the level
     * @param id The id
     * @param name The name
     * @param height The height
     * @param width The width
     * @param player The player
     * @param diamondsNumber The number of diamonds in the level
     */
    public Level(int id, String name, int height, int width, IPlayer player, int diamondsNumber) {
        this.id = id;
        this.dimensions =  new Dimensions(height, width);
        this.name = name;
        this.player = player;
        this.diamondsNumber = diamondsNumber;
        this.diamondsCollected = 0;
        this.finished = false;
    }

    /**
     * Get the id
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the dimensions
     * @return The dimensions
     */
    public IDimensions getDimensions() {
        return dimensions;
    }

    /**
     * Set the dimensions
     * @param dimensions The dimensions
     */
    public void setDimensions(IDimensions dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Get the name
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the number of diamonds in the level
     * @return The number of diamonds in the level
     */
    public int getDiamondsNumber() {
        return diamondsNumber;
    }

    /**
     * Set the number of diamonds in the level
     * @param diamondsNumber The number of diamonds to get in the level
     */
    public void setDiamondsNumber(int diamondsNumber) {
        this.diamondsNumber = diamondsNumber;
    }


    /**
     * Get the player
     * @return The player
     */
    public IPlayer getPlayer() {
        return player;
    }


    /**
     * Set the player
     * @param player The player
     */
    public void setPlayer(IPlayer player) {
        this.player = player;
    }

    /**
     * The level is finished or not
     * @return
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * Set the level as finished or not
     * @param finished
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * Get the number of diamonds collected
     * @return The number of diamonds collected
     */
    public int getDiamondsCollected() {
        return diamondsCollected;
    }

    /**
     * Set the number of diamonds
     * @param diamondsCollected The number of diamonds collected
     */
    public void setDiamondsCollected(int diamondsCollected) {
        this.diamondsCollected = diamondsCollected;
    }

    /**
     * The map
     */
    IElements[][] map;

    /**
     * Get the elements
     * @return The map
     */
    public IElements[][] getElements(){
        return map;
    }

    /**
     * Get the elements
     * @param x The y position
     * @param y The x position
     * @return The map
     */
    public IElements getElement(int x,int y){
        return map[x][y];
    }

    /**
     * Set the elements
     * @param element The element
     * @param x The x position
     * @param y The y position
     */
    public void setElement(IElements element,int x,int y){
        map[x][y]= element;
    }

    /**
     * The game is paused or not
      * @return
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * Set the game as paused or not
     * @param paused
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
