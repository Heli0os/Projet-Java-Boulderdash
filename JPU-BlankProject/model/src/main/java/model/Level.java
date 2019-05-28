package model;

import contract.*;
import model.Elements.Elements;
import java.util.ArrayList;

/**
 * The Class Model.
 *
 * @author Clément
 */
public class Level implements ILevel {
    private IElements player;
    private int id;
    private IDimensions dimensions;
    private String name;
    private int levelNumber;
    private int diamondsNumber;
    private GameMap gameMap;
    private boolean finished;
    private int diamondsCollected;

    public Level(int id, int height, int width, String name, IElements player, int levelNumber, int diamondsNumber) {
        this.id = id;
        this.dimensions = new Dimensions(height, width);
        this.name = name;
        this.player = player;
        this.levelNumber = levelNumber;
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

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getDiamondsNumber() {
        return diamondsNumber;
    }

    public void setDiamondsNumber(int diamondsNumber) {
        this.diamondsNumber = diamondsNumber;
    }

    public IElements getPlayer() {
        return player;
    }

    public void setPlayer(IElements player) {
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

    Elements[][] map;

    public Elements[][] getElements(){
        return map;
    }

    public Elements getElement(int x,int y){
        return map[x][y];
    }

    public void setElement(Elements element,int x,int y){
        map[x][y]= element;
    }
}
