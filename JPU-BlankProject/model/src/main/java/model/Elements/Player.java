package model.Elements;

import contract.*;

/**
 * @author Clément
 */
public class Player extends MotionElements {
    private boolean isAlive;

    public Player (int x, int y, Direction direction) {
        super (x, y, direction.NO, "Player", "");
        this.isAlive = true;
    }

    public boolean getIfIsAlive() {
        return isAlive;
    }

    public void setIsAlive (boolean isAlive) {
        this.isAlive = isAlive;
    }
}
