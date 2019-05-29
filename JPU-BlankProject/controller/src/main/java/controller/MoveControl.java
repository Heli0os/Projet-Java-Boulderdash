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
        if(mc == null) {
            System.err.println("No MoveControl");
        }
        return mc;
    }


    public MoveControl(IModel model) {
        this.model = model;
        mc = this;
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
                element = this.model.getLevel().getElement(x, y-1);
                spriteName = element.getSpriteName();
                if (spriteName == "Wall" || spriteName == "Rock") {
                    return false;
                }
                else{
                moveTo(model.getLevel().getElement(x, y), x, y-1);
                return true;
                }
            case LEFT:
                element = this.model.getLevel().getElement(x-1, y);
                spriteName = element.getSpriteName();
                if (spriteName == "Wall" || spriteName == "Rock") {
                    return false;
                }else{
                moveTo(model.getLevel().getElement(x, y), x-1, y);
                return true;
                }
            case DOWN:
                element = this.model.getLevel().getElement(x, y+1);
                spriteName = element.getSpriteName();
                if (spriteName == "Wall" || spriteName == "Rock") {
                    return false;
                }
                moveTo(model.getLevel().getElement(x, y), x, y+1);
                return true;
            case RIGHT:
                element = this.model.getLevel().getElement(x+1, y);
                spriteName = element.getSpriteName();
                if (spriteName == "Wall" || spriteName == "Rock") {
                    return false;
                }
                moveTo(model.getLevel().getElement(x, y), x+1, y);
                return true;
        }
        return true;
    }

    public void moveTo (IElements elements, int x, int y) {
        elements.setX(x);
        elements.setY(y);
    }
}
