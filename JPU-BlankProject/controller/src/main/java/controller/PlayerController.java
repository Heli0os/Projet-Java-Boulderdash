package controller;

import contract.*;

/**
 * The Class PlayerController.
 *
 * @author Clément
 */
public class PlayerController {
    private static PlayerController pc;
    private IModel model;
    private MoveControl moveControl;

    public static PlayerController getInstance() {
        if (pc == null)
            System.err.println("No playerController");
        return pc;
    }

    public static void init(IModel model) {
        pc = new PlayerController(model);
    }

    public PlayerController(IModel model) {
        this.model = model;
        this.moveControl = MoveControl.getInstance();
    }

    public void move(Direction direction) {
        IMotionElements player = (IMotionElements) this.model.getLevel().getPlayer();
        int x = player.getX();
        int y = player.getY();
        if (player.isAlive() && !this.model.getLevel().isFinished() /*&& !this.model.getLevel().isPaused()*/) {
            player.setDirection(direction);
            moveControl.movementIsPossible(direction, x,y);
        }
        else {
            player.setDirection(direction);
        }
    }
}
