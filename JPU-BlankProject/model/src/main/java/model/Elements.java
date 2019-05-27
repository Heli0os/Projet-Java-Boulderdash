package model.Elements;

import contract.*;
import model.Sprite;

/**
 * @author Clément
 */
public abstract class Elements {
    protected int x;
    protected int y;
    protected ISprite sprite;

    public Elements (int x, int y, String image) {
        this.x = x;
        this.y = y;
        this.sprite = new Sprite(image);
    }

    public Elements (int x, int y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }
    
    public void setLocation(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ISprite getSprite() {
        return sprite;
    }

    public void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }

    public Image getImage() {
        return this.sprite.getImage();
    }
}
