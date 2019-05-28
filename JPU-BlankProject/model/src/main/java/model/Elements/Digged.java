package model.Elements;

import contract.IMapController;

/**
 * @author Clément
 */
public class Digged extends Elements {
    public Digged (int x, int y, IMapController mapController) {
        super (x, y, "Digged", "images/Digged",mapController);
    }
}
