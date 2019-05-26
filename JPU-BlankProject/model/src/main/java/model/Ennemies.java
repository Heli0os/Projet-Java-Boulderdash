package model.Elements;

import contract.Direction;

/**
 * @author Clément
 */
public class Ennemies extends MotionElements {
    private String spriteName = "Ennemy";

    public Ennemies (int x, int y, Direction direction) {
        super (x, y, "");
        this.direction = direction;
    }
}
