package controller;

import contract.IElements;
import model.Elements.Digged;
import model.Elements.Elements;
import model.Level;
import model.Model;

/**
 * @author Théophile
 */
public class MapController {
    private Model model;
    private Level level;
    private Elements current;
    private int oldX;
    private int oldY;
    private int newX;
    private int newY;

    public MapController(Model model) {
        this.model = model;
    }


    public void UpdateMap(){
        for(int x = 0;x <= level.getDimensions().getHeight(); x++){
            for (int y = 0; y <= level.getDimensions().getWidth(); y++){
                MoveInMap((Elements) level.getElement(x,y),x,y);
            }
        }
    }
    /**
     * MoveTo method move the element parameter to the x and y parameter
     * @param element,x,y
     * */
    public void MoveInMap(Elements element,int x, int y){ //x and y are the current position of the element
        current = (Elements) level.getElement(element.getX(),element.getY());
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
        level.setElement((IElements) element,newX,newY);
        level.setElement((IElements) new Digged(oldX,oldY,this),oldX,oldY);

    }


}
