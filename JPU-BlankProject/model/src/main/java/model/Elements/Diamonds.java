package model.Elements;

import contract.IFallingElements;

/**
 * @author Clément
 */
public class Diamonds extends FallingElements implements IFallingElements {
    public Diamonds (int x, int y) {
        super (x, y, "Diamonds", "../images/Diamond.png");
    }
}
