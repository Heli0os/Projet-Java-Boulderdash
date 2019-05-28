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

    public Sprite(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}