package model.Elements;

import contract.IElements;

/**
 * @author Clément
 */

public class Walls extends Elements implements IElements {
    public Walls (int x, int y) {
        super (x, y, "Wall", "../images/Wall.png");
    }
}
