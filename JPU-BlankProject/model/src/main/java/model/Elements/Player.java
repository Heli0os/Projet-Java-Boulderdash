package model.Elements;

import contract.*;

/**
 * @author Clément
 */
public class Player extends MotionElements {
    private boolean isAlive;

    public Player (int x, int y, Direction direction) {
        super (x, y, direction.NO, "Player", "images/Player_0");
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive (boolean isAlive) {
        this.isAlive = isAlive;
    }
}
