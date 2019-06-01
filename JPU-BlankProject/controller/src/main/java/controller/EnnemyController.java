package controller;

import contract.Direction;
import contract.IElements;
import contract.IModel;
import model.Elements.Ennemies;

import java.util.Random;

/**
 * The Controller for the ennemies
 * @author Clément / Théophile
 */
public class EnnemyController {

    /**
     * the EnnemyController
     */
    private static EnnemyController ec;

    /**
     * The model
     */
    private IModel model;

    /**
     * The move controller
     */
    private MoveControl moveControl;

    /**
     * A random
     */
    private static Random random;

    /**
     * The direction
     */
    private Direction direction;

    /**
     * Get the instance of the EnnemyController
     * @return The instance of the EnnemyController
     */
    public static EnnemyController getInstance() {
        if (ec == null)
            System.err.println("no EnnemyController");
        return ec;
    }

    /**
     * The constructor of the EnnemyController
     * @param model The model
     */
    public EnnemyController(IModel model) {
        this.model = model;
        this.moveControl = moveControl.getInstance();
    }

    /**
     * Initialisation
     * @param model The model
     */
    public static void init (IModel model) {
        ec = new EnnemyController(model);
        random = new Random();
    }

    /**
     * Scan the level and perform the movement for the ennemies detected
     */
    protected void performMovement() {
        for (int x = model.getLevel().getDimensions().getHeight() - 1; x >= 0; x--) {
            for (int y = model.getLevel().getDimensions().getWidth() - 1; y >= 0; y--) {
                IElements element = this.model.getLevel().getElement(x, y);
                if (element instanceof Ennemies) {
                    moveControl.movementIsPossible(Direction.getRandomDirection(), element.getX(), element.getY());
                }
            }
        }
    }
}
