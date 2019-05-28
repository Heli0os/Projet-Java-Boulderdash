package model;

import contract.IElements;
import java.util.ArrayList;

/**
 * The Class Model.
 *
 * @author Clément
 */
public class Level {
    private int id;
    private String name;
    private int levelNumber;
    private int diamondsNumber;
    private ArrayList<IElements> elements;
    private IElements element[][];
    private IElements player;
    private boolean finished;
    private int diamondsCollected;

    public Level(int id, int x, int y, String name, IElements player, int levelNumber, int diamondsNumber) {
        this.id = id;
        this.name = name;
        this.player = player;
        this.levelNumber = levelNumber;
        this.diamondsNumber = diamondsNumber;
        this.element = new IElements[x][y];
        this.elements = new ArrayList<IElements>();
        this.diamondsCollected = 0;
        this.finished = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<IElements> getElements() {
        return elements;
    }

    public void setElements(ArrayList<IElements> elements) {
        this.elements = elements;
    }

    public IElements[][] getElement() {
        return element;
    }

    public void setElement(IElements[][] element) {
        this.element = element;
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
}
