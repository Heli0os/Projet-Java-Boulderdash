package model.Elements;

import contract.IMapController;

/**
 * @author Clément
 */
public class Dirt extends Elements {
    public Dirt (int x, int y, IMapController mapController) {
        super (x, y, "Dirt", "images/Dirt", mapController);
    }
}
