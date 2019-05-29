package controller;

import contract.*;

/**
 * The Class PlayerController.
 *
 * @author Clément
 */
public class PlayerController {

    /**
     * The playerController
     */
    private static PlayerController pc;

    /**
     * The model
     */
    private IModel model;

    /**
     * The moveControl
     */
    private MoveControl moveControl;

    /**
     * Get the instance of the PlayerController
     * @return The instance of the PlayerController
     */
    public static PlayerController getInstance() {
        if (pc == null)
            System.err.println("No playerController");
        return pc;
    }

    /**
     * initialisation
     * @param model The model
     */
    public static void init(IModel model) {
        pc = new PlayerController(model);
    }

    /**
     * Constructor of the PlayerController
     * @param model The model
     */
    public PlayerController(IModel model) {
        this.model = model;
        this.moveControl = MoveControl.getInstance();
        pc = this;
    }

    /**
     * Move the player
     * @param direction The direction selected by the player
     */
    public void move(contract.Direction direction) {
        IMotionElements player = (IMotionElements) this.model.getLevel().getPlayer();
        int x = player.getX();
        int y = player.getY();
        if (player.isAlive() && !this.model.getLevel().isFinished() && !this.model.getLevel().isPaused()) {
            player.setDirection(direction);
            moveControl.movementIsPossible(direction, x,y);
        }
        else {
            player.setDirection(direction);
        }
    }
}
