package model.Elements;

import contract.IMapController;

/**
 * @author Clément
 */
public class Diamonds extends FallingElements {
    public Diamonds (int x, int y, IMapController mapController) {
        super (x, y, "Diamonds", "images/Diamond",mapController);
    }
}
