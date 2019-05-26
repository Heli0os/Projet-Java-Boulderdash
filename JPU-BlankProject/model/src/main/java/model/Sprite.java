package model;

import java.awt.*;

/**
 * @author Clément
 */
public class Sprite {
    /**
     * The image.
     */
    protected Image image;

    public Sprite(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}