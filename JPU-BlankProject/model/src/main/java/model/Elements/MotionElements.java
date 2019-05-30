package model.Elements;

import contract.Direction;
import contract.IMotionElements;

/**
 * @author Clément
 */
public abstract class MotionElements extends Elements implements IMotionElements {

    protected Direction direction;

    public MotionElements (int x, int y, Direction direction, String name, String imagePath) {
        super(x, y, name, imagePath);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection (Direction direction) {
        this.direction = direction;
    }
}
