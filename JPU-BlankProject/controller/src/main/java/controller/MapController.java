package controller;

import model.Elements.Digged;
import model.Elements.Elements;
import model.GameMap;


/**
 * @author Théophile
 */
public class MapController {
    private GameMap map;
    private Elements current;
    private int oldX;
    private int oldY;
    private int newX;
    private int newY;

    public void CreateMap(){
        map = new GameMap();

    }

    public void UpdateMap(){
        for(int x = 0;x <= height; x++){
            for (int y = 0; y <= width; y++){
                MoveInMap(map.getElement(x,y),x,y);
            }
        }
    }
    /**
     * MoveTo method move the element parameter to the x and y parameter
     * @param element,x,y
     * */
    public void MoveInMap(Elements element,int x, int y){ //x and y are the current position of the element
        current = map.getElement(element.getX(),element.getY());
        newX = element.getX();
        newY = element.getY();
        oldX = x;
        oldY = y;

        if(current.getSpriteName()== "Diamonds"){
            //pick up item
        }
            map.setElement(element,newX,newY);
            map.setElement(new Digged(oldX,oldY),oldX,oldY);

    }


}
