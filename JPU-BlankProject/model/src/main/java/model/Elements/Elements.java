package model.Elements;

import contract.IMapController;
import contract.ISprite;
import model.Sprite;

/**
 * @author Clément
 */
public abstract class Elements {
    protected int x;
    protected int y;
    protected String spriteName;
    protected ISprite sprite;
    protected IMapController mapController;

    public Elements (int x, int y, String spriteName, String image) {
        this.setX(x);
        this.setY(y);
        this.setSpriteName(spriteName);
        this.sprite = new Sprite(image);
    }

    public void setLocation(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }

    public String getSpriteName() {
        return spriteName;
    }

    public ISprite getSprite() {
        return sprite;
    }

    public void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }

    public String getImage() {
        return this.sprite.getImagePath();
    }
}
