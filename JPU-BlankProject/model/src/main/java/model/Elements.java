package model.Elements;

import contract.*;
import model.Sprite;
import model.Location;

/**
 * @author Clément
 */
public abstract class Elements {
    protected ILocation location;
    protected ISprite sprite;

    public Elements (Location Location, String image) {
        this.location = location;
        this.sprite = new Sprite (image);
    }

    public Elements (int x, int y, String image) {
        this.location = new Location (x,y);
        this.sprite = new Sprite(image);
    }

    public Elements (int x, int y, Sprite sprite) {
        this.location = new Location (x,y);
        this.sprite = sprite;
    }

    public Elements (Location location, Sprite sprite) {
        this.location = location;
        this.sprite = sprite;
    }

    public ILocation getLocation() {
        return location;
    }

    public void setLocation(ILocation location) {
        this.location = location;
    }

    public void setLocation(int x, int y) {
        this.location.setX(x);
        this.location.setY(y);
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
