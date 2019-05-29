package model;

import contract.ISprite;
import java.awt.*;

/**
 * @author Clément
 */
public class Sprite implements ISprite {
    /**
     * The image.
     */
    protected Image image;

    /**
     * The constructor of the sprite
     * @param image The image 
     */
    public Sprite(Image image) {
        this.image = image;
    }

    /**
     * Get the image
     * @return The image
     */
    public Image getImage() {
        return image;
    }
}
