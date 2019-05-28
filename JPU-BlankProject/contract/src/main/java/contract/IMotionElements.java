package contract;

/**
 * The Interface IModel.
 *
 * @author Clément
 */
public interface IMotionElements extends IElements {
    void moveTo (int x, int y);

    Direction getDirection();

    void setDirection (Direction direction);
}
