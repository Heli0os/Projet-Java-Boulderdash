package controller;

import contract.IElements;
import contract.ILevel;
import contract.IModel;
import model.Elements.Digged;

/**
 * @author Théophile
 */
public class MapController {
    private IModel model;
    private ILevel level;
    private IElements current;
    private int oldX;
    private int oldY;
    private int newX;
    private int newY;

    public MapController(IModel model) {
        this.model = model;
    }


    public void UpdateMap(){
        for(int x = 0;x <= level.getDimensions().getHeight(); x++){
            for (int y = 0; y <= level.getDimensions().getWidth(); y++){
                MoveInMap(level.getElement(x,y),x,y);
            }
        }
    }
    /**
     * MoveTo method move the element parameter to the x and y parameter
     * @param element,x,y
     * */
    public void MoveInMap(IElements element,int x, int y){ //x and y are the current position of the element
        current = (IElements) level.getElement(element.getX(),element.getY());
        newX = element.getX();
        newY = element.getY();
        oldX = x;
        oldY = y;

        if(current.getSpriteName()== "Diamonds" && element.getSpriteName()=="Player"){
            //pick up item
        }
        if((current.getSpriteName()== "Ennemy" && element.getSpriteName()=="Player") || (current.getSpriteName()== "Player" && element.getSpriteName()=="Ennemy") ){
            //die
        }
        level.setElement(element,newX,newY);
        level.setElement((IElements) new Digged(oldX,oldY),oldX,oldY);

    }


}
