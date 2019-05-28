package model.Elements;

import contract.Direction;

/**
 * @author Clément
 */
public class Ennemies extends MotionElements {
    public Ennemies (int x, int y, Direction direction) {
        super (x, y, direction.LEFT, "Ennemy", "images/Enemy");
    }
}
