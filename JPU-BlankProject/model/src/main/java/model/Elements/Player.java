package model.Elements;

import contract.*;

/**
 * @author Clément
 */
public class Player extends MotionElements implements  IPlayer{
    private boolean isAlive;

    public Player (int x, int y, Direction direction) {
        super (x, y, direction.NO, "Player", "../images/Player.png");
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive (boolean isAlive) {
        this.isAlive = isAlive;
    }
}
