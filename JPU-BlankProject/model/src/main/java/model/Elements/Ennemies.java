package model.Elements;

import contract.Direction;
import contract.IMotionElements;

/**
 * @author Clément
 */
public class Ennemies extends MotionElements implements IMotionElements {
    public Ennemies (int x, int y, Direction direction) {
        super (x, y, direction.LEFT, "Ennemy", "images/Enemy");
    }
}
