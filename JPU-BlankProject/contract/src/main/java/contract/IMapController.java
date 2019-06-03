package contract;

/**
 * @author Théophile
 */
public interface IMapController {

    /**
     * update the map
     */
    void UpdateMap();

    /**
     * Move the elements in the map
     * @param element The element
     * @param x The x position
     * @param y The y position
     */
    void MoveInMap(IElements element,int x, int y);

}
