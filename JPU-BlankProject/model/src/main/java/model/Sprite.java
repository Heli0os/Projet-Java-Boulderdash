package model;

import contract.ISprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

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
     * @param imagePath The image path
     */
    public Sprite(String imagePath) {
        loadImage(imagePath);
    }

    /**
     * Get the image
     * @return The image
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Load the image
     * @param imagePath the path of the image
     */
    void loadImage(String imagePath) {
        try {
            this.image = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
