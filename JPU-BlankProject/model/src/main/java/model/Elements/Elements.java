package model.Elements;

import contract.IElements;
import contract.ISprite;
import model.Sprite;

/**
 * @author Clément
 */
public abstract class Elements implements IElements {
    protected int x;
    protected int y;
    protected String name;
    protected ISprite sprite;

    public Elements (int x, int y, String name, String imagePath) {
        this.setX(x);
        this.setY(y);
        this.setName(name);
        this.sprite = new Sprite(imagePath);
    }


    public void setLocation(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ISprite getSprite() {
        return this.sprite;
    }

    public void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }


}
