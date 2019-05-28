package controller;

import contract.*;

/**
 * The Class MoveControl.
 *
 * @author Clément
 */
    public class MoveControl {
    private static MoveControl mc;
    private IModel model;

    public static MoveControl getInstance() {
        if(mc == null)
            System.err.println("No MoveControl");
        return mc;
    }

    public static void init(IModel model) {
        mc = new MoveControl(model);
    }

    private MoveControl(IModel model) {
        this.model = model;
    }

    /*IElement Collision(IElement element) {
        ILocation elementLocation = element.getLocation();
        for(IElement movingElement: this.model.getLevel().getMovingElement()) {
            if(elementLocation.getX() == movingElement.getLocation().getX() && elementLocation.getY() == movingElement.getLocation().getY() && element != movingElement) {
                return movingElement;
            }
        }
        return this.model.getLevel().getElements()[elementLocation.getY()][elementLocation.getX()];
    }*/

    /**
     * Tell if a movement is possible on the next block, according the direction
     * @param x
     * Position x
     * @param y
     * Position y
     * @return
     * A movement is possible
     */
    boolean movementIsPossible(Direction direction, int x, int y) {
        IElements element;
        String spriteName;

        switch (direction) {
            case UP:
                element = this.model.getElements(x, y-1);
                spriteName = element.getSpriteName();
                if (spriteName == "Wall" || spriteName == "Rock") {
                    return false;
                }
                return true;
            case LEFT:
                element = this.model.getElements(x-1, y);
                spriteName = element.getSpriteName();
                if (spriteName == "Wall" || spriteName == "Rock") {
                    return false;
                }
                return true;
            case DOWN:
                element = this.model.getElements(x, y+1);
                spriteName = element.getSpriteName();
                if (spriteName == "Wall" || spriteName == "Rock") {
                    return false;
                }
                return true;
            case RIGHT:
                element = this.model.getElements(x+1, y);
                spriteName = element.getSpriteName();
                if (spriteName == "Wall" || spriteName == "Rock") {
                    return false;
                }
                return true;
        }
    }

    /**
     * Tell if the movement is safe, according the return of the boolean movementIsPossible
     * @param element
     * Get the element which as to move
     * @param x
     * Position x
     * @param y
     * Position y
     * @return
     * Safe move for the entity
     */
    boolean movementIsSafe(IMotionElements element, int x, int y) {
        if(movementIsPossible(direction, x, y) = true) {
            element.moveTo(x,y);
            this.model.update();
            return true;
        }
        return false;
    }
}
