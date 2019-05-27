package entity;

public class Map {

    Elements[][] map;

    public Elements getElement(int x,int y){
        return map[x][y];
    }

    public void setElement(Elements element,int x,int y){
        map[x][y]= element;
    }
}
