package model.Elements;

import contract.IElements;
import contract.ISprite;
import model.Sprite;

/**
 * @author Clément
 */
public abstract class Elements implements IElements {

    /**
     * The x position
     */
    protected int x;

    /**
     * The y position
     */
    protected int y;

    /**
     * The name
     */
    protected String name;

    /**
     * The sprite
     */
    protected ISprite sprite;

    /**
     * The constructor
     * @param x The x position
     * @param y The y position
     * @param name The name
     * @param imagePath The image path
     */
    public Elements (int x, int y, String name, String imagePath) {
        this.setX(x);
        this.setY(y);
        this.setName(name);
        this.sprite = new Sprite(imagePath);
    }

    /**
     * Set the location of the element
     * @param x The x position
     * @param y The y position
     */
    public void setLocation(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * get the x position
     * @return the x position
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the y position
     * @return The y position
     */
    public int getY() {
        return this.y;
    }

    /**
     * set the x position
     * @param x the x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set the y position
     * @param y the y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * set the name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the name
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * get the sprite
     * @return the sprite
     */
    public ISprite getSprite() {
        return this.sprite;
    }

    /**
     * set the sprite
     * @param sprite the sprite
     */
    public void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }
}
