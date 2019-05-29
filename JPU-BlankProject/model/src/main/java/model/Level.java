package model;

import contract.*;

/**
 * The Class Model.
 *
 * @author Clément
 */
public class Level implements ILevel {
    private IPlayer player;
    private int id;
    private IDimensions dimensions;
    private String name;
    private int diamondsNumber;

    private boolean finished;
    private boolean paused;
    private int diamondsCollected;

    public Level(int id, String name, int height, int width, IPlayer player, int diamondsNumber) {
        this.id = id;
        this.dimensions =  new Dimensions(height, width);
        this.name = name;
        this.player = player;
        this.diamondsNumber = diamondsNumber;
        this.diamondsCollected = 0;
        this.finished = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IDimensions getDimensions() {
        return dimensions;
    }
    public void setDimensions(IDimensions dimensions) {
        this.dimensions = dimensions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiamondsNumber() {
        return diamondsNumber;
    }

    public void setDiamondsNumber(int diamondsNumber) {
        this.diamondsNumber = diamondsNumber;
    }

    public IPlayer getPlayer() {
        return player;
    }

    public void setPlayer(IPlayer player) {
        this.player = player;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getDiamondsCollected() {
        return diamondsCollected;
    }

    public void setDiamondsCollected(int diamondsCollected) {
        this.diamondsCollected = diamondsCollected;
    }

    IElements[][] map;

    public IElements[][] getElements(){
        return map;
    }

    public IElements getElement(int x,int y){
        return map[x][y];
    }

    public void setElement(IElements element,int x,int y){
        map[x][y]= element;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
