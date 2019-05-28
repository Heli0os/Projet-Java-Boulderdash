package model;

import contract.ISprite;

/**
 * @author Clément
 */
public class Sprite implements ISprite {
    /**
     * The imagePath.
     */
    protected String imagePath;

    public Sprite(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}