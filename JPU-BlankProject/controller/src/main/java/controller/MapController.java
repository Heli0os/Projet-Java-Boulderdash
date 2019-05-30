package controller;

import contract.IElements;
import contract.ILevel;
import contract.IModel;
import model.Elements.Digged;

/**
 * @author Théophile
 */
public class MapController {

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
        for(int x = 0;x <= level.getDimensions().getHeight(); x++){
            for (int y = 0; y <= level.getDimensions().getWidth(); y++){
                this.MoveInMap(level.getElement(x,y),x,y);
            }
        }
    }
    /**
     * MoveTo method move the element parameter to the x and y parameter
     * @param element,x,y The element, the x position and the y position
     * */
    public void MoveInMap(IElements element,int x, int y){ //x and y are the current position of the element
        current =  level.getElement(element.getX(),element.getY());
        newX = element.getX();
        newY = element.getY();
        oldX = x;
        oldY = y;

        if(current.getName()== "Diamonds" && element.getName()=="Player"){
            //pick up item
        }
        if((current.getName()== "Ennemy" && element.getName()=="Player") || (current.getName()== "Player" && element.getName()=="Ennemy") ){
            //die
        }
        level.setElement(element,newX,newY);
        level.setElement((IElements) new Digged(oldX,oldY),oldX,oldY);

    }


}
