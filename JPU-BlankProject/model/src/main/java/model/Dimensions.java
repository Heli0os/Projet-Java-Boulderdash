package model;

import contract.IDimensions;

/**
 * The class dimensions
 * @author Clément 
 */
public class Dimensions implements IDimensions {

    /**
     * The Width
     */
    private int width;

    /**
     * The Height
     */
    private int height;

    /**
     * The constructor Dimensions
     * @param width The width
     * @param height The height
     */
    public Dimensions (int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * The constructor Dimensions
     * @param dimensions The dimensions
     */
    /*public Dimensions(final Dimensions dimensions) {
        this(dimensions.getWidth(), dimensions.getHeight());
    }*/

    /**
     * Get the width
     * @return The width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Set the width
     * @param width The width
     */
    public void setWidth(final int width) {
        this.width = width;
    }

    /**
     * Get the height
     * @return The height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Set the height
     * @param height The height
     */
    public void setHeight(final int height) {
        this.height = height;
    }
}
