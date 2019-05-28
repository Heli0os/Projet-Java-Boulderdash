package model.Elements;

import contract.Direction;

/**
 * @author Clément
 */
public abstract class MotionElements extends Elements {

    protected Direction direction;

    public MotionElements (int x, int y, Direction direction, String spriteName, String image) {
        super(x, y, spriteName, image);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection (Direction direction) {
        this.direction = direction;
    }
}
