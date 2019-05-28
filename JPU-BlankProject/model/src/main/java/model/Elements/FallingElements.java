package model.Elements;

import contract.IElements;
import contract.IMapController;
import model.Model;

abstract class FallingElements extends Elements {

    private Model model;

    Elements elementUnder = (Elements) model.getLevel().getElement(x,y-1);
    Elements elementLeft = (Elements) model.getLevel().getElement(x-1,y);
    Elements elementRight = (Elements) model.getLevel().getElement(x+1,y);
    Elements elementLUnder = (Elements) model.getLevel().getElement(x-1,y+1);
    Elements elementRUnder = (Elements) model.getLevel().getElement(x+1,y+1);
    public boolean fallingStatus;

    public FallingElements (int x, int y, String spriteName, String imagePath, IMapController mapController) {
        super(x, y, spriteName, imagePath, mapController);
        this.fallingStatus = false;
    }

    public void falling() {

        /*
        Falling function just move the current object down and replace his older position with "digged"
         */
        if (elementUnder.spriteName == "Digged") {

        }
    }
    public void rolling(){
        /*
        Make falling element roll to fall aside
         */
        if(elementUnder.spriteName == "Rock" || elementUnder.spriteName == "Diamond"){
            if(elementLeft.spriteName == "Digged" && elementLUnder.spriteName == "Digged"){
                this.x--;
            }
            if(elementRight.spriteName == "Digged" && elementRUnder.spriteName == "Digged"){
                this.x++;
            }
        }
    }

    public void cruching(){
        if(this.fallingStatus == true && elementUnder.spriteName == "Player"){
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    model.getLevel().setElement((IElements) new Digged(i,j),i,j);
                }
            }
            /*restart function here*/
        }
        if(this.fallingStatus == true && elementUnder.spriteName == "Enemy"){
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    model.getLevel().setElement((IElements) new Digged(i,j),i,j);
                }
            }
            model.getLevel().setElement((IElements) new Diamonds(x,y+1),x,y+1);
        }
    }


}
