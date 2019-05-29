package contract;

import java.util.Random;

/**
 * The Enum ControllerOrder.
 *
 * @author Clément
 */
public enum Direction {
    /** The UP direction. */
    UP,
    /** The LEFT direction. */
    LEFT,
    /** The DOWN direction. */
    DOWN,
    /** The RIGHT direction. */
    RIGHT,
    /** No direction set. */
    NO;
    
    /**
    * A function that set a random direction 
    * Used for the ennemies
    */
    public static Direction getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
