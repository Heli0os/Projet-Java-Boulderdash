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

    private PlayerController(IModel model) {
        this.model = model;
        this.moveControl = MoveControl.getInstance();
    }

    public boolean move(Direction direction) {
        IElement player = this.model.getLevel().getPlayer();
        if (!player.isAlive() || this.model.getLevel().isFinished() || movementIsPossible == false)
            return false;
        int nextX = player.getX();
        int nextY = player.getY();
        switch (direction) {
            case UP:
                nextY--;
                break;
            case LEFT:
                nextX--;
                break;
            case DOWN:
                nextY++;
                break;
            case RIGHT:
                nextX++;
                break;
            default:
                System.out.println("No move set");
                break;
        }
        player.setDirection(direction);
        return moveControl.movementIsSafe(player, nextX, nextY);
    }
}
