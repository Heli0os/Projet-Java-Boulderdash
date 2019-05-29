package model.Elements;

import contract.IElements;

/**
 * @author Clément
 */
public class Digged extends Elements implements IElements {
    public Digged (int x, int y) {
        super (x, y, "Digged", "images/Digged");
    }
}
