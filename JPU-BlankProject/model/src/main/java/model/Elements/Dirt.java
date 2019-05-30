package model.Elements;

import contract.IElements;

/**
 * @author Clément
 */
public class Dirt extends Elements implements IElements {
    public Dirt (int x, int y) {
        super (x, y, "Dirt", "../images/Dirt.png");
    }
}
