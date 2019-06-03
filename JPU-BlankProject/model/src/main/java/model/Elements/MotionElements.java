package model.Elements;

import contract.Direction;
import contract.IMotionElements;

/**
 * The class MotionElements
 * 
 * @author Clément
 */
public abstract class MotionElements extends Elements implements IMotionElements {

    /**
     * The direction
     */
    protected Direction direction;

    /**
     * The constructor
     * @param x The x position
     * @param y The y position
     * @param direction The direction
     * @param name The name
     * @param imagePath The image path
     */
    public MotionElements (int x, int y, Direction direction, String name, String imagePath) {
        super(x, y, name, imagePath);
        this.direction = direction;
    }

    /**
     * get the direction
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * set the direction
     * @param direction The direction
     */
    public void setDirection (Direction direction) {
        this.direction = direction;
    }
}
