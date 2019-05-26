package model.Elements;

import contract.Direction;

/**
 * @author Clément
 */
public abstract class MotionElements extends Elements {
    public boolean moveTo (Integer x, Integer y) {
        return false;
    }

    protected Direction direction;

    public MotionElements (int x, int y, String image) {
        super (x, y, image);
    }

    public void moveTo (int x, int y) {
        this.setLocation(x,y);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection (Direction direction) {
        this.direction = direction;
    }
}
