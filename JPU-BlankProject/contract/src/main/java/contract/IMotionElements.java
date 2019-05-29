package contract;

/**
 * The Interface IMotionElements.
 *
 * @author Clément
 */
public interface IMotionElements extends IElements {
    /**
     * Move the element to the next position
     * @param x The x position
     * @param y The y position
     */
    void moveTo (int x, int y);

    /**
     * get the direction of the element
     * @return The direction
     */
    Direction getDirection();

    /**
     * set the direction of the element
     * @param direction The direction
     */
    void setDirection (Direction direction);
}
