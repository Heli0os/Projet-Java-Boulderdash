package controller;

import contract.IElements;
import contract.ILevel;
import contract.IMapController;
import contract.IModel;
import model.Elements.Digged;

/**
 * @author Théophile
 */
public class MapController implements IMapController {

    /**
     * The model
     */
    private IModel model;

    /**
     * The level
     */
    private ILevel level;

    /**
     * The current element
     */
    private IElements current;

    /**
     * The old x position
     */
    private int oldX;

    /**
     * The old y position
     */
    private int oldY;

    /**
     * The new x position
     */
    private int newX;

    /**
     * The new y position
     */
    private int newY;

    /**
     * The constructor of the MapController
     * @param model The model
     */
    public MapController(IModel model) {
        this.model = model;
        this.level = this.model.getLevel();
    }

    /**
     * The function that will move the elements in the map
     */
    public void UpdateMap(){
        this.level = this.model.getLevel();
        for(int x = 0; x <= this.level.getDimensions().getHeight(); x++){
            for (int y = 0; y <= this.level.getDimensions().getWidth(); y++){
                //System.err.println("updatemap is called");
                this.MoveInMap(this.level.getElement(x,y),x,y);
            }
        }
    }
    /**
     * MoveTo method move the element parameter to the x and y parameter
     * @param element,x,y The element, the x position and the y position
     * */
    public void MoveInMap(IElements element,int x, int y) { //x and y are the current position of the element
        if (element != null) {
            this.current = this.model.getLevel().getElement(element.getX(), element.getY());
            this.newX = element.getX();
            this.newY = element.getY();
            this.oldX = x;
            this.oldY = y;

            if (current.getName() == "Diamonds" && element.getName() == "Player") {
                //pick up item
            }
            if ((current.getName() == "Ennemy" && element.getName() == "Player") || (current.getName() == "Player" && element.getName() == "Ennemy")) {
                //die
            }
            if(this.newX != this.oldX || this.newY != this.oldY) {
                this.model.getLevel().setElement(element, this.newX, this.newY);
                this.model.getLevel().setElement(new Digged(this.oldX, this.oldY), this.oldX, this.oldY);
            }

        }
    }


}
