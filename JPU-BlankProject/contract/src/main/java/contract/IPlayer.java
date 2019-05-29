package contract;

/**
 * @author Clément 
 */
public interface IPlayer extends IMotionElements {
    /**
     * says if the player is alive or not
     * @return
     */
    boolean isAlive();

    /**
     * set the player as alive or not
     * @param isAlive
     */
    void setIsAlive (boolean isAlive);
}
