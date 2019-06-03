package contract;

/**
 * The Interface IMotionElements.
 *
 * @author Clément
 */
public interface IMotionElements extends IElements {


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
