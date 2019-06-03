package model.Elements;

import contract.IFallingElements;

/**
 * @author Clément
 */
public class Rocks extends FallingElements implements IFallingElements {
    public Rocks (int x, int y) {
        super (x, y, "Rocks", "../images/Rock.png");
    }
}
