package model;

import model.Elements.Elements;

public class GameMap {

    public Elements[][] map;

    public Elements getElement(int x,int y){
        return map[x][y];
    }

    public Elements[][] getElements(){return map;}

    public void setElement(Elements element,int x,int y){
        map[x][y]= element;
    }
}
