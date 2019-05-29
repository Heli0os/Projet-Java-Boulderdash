package model;

import contract.IDimensions;

public class Dimensions implements IDimensions {
    private int width;
    private int height;

    public Dimensions (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Dimensions(final Dimensions dimensions) {
        this(dimensions.getWidth(), dimensions.getHeight());
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }
}
