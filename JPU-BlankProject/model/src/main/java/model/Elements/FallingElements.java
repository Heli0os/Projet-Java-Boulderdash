package model.Elements;

import contract.IFallingElements;
import model.Model;

abstract class FallingElements extends Elements implements IFallingElements {

    private Model model;
    public boolean fallingStatus;


    Elements elementUnder = (Elements) this.model.getLevel().getElement(this.x,this.y-1);
    Elements elementLeft = (Elements) this.model.getLevel().getElement(this.x-1,this.y);
    Elements elementRight = (Elements) this.model.getLevel().getElement(this.x+1,this.y);
    Elements elementLUnder = (Elements) this.model.getLevel().getElement(this.x-1,this.y+1);
    Elements elementRUnder = (Elements) this.model.getLevel().getElement(this.x+1,this.y+1);

    public FallingElements (int x, int y, String spriteName, String imagePath) {
        super(x, y, spriteName, imagePath);
        this.fallingStatus = false;
    }

    public void falling() {

        /*
        Falling function just move the current object down and replace his older position with "digged" and set falling status to true
         */
        if (elementUnder.spriteName == "Digged") {
            this.y++;
            this.fallingStatus=true;
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

    public void crushing(){
        if(this.fallingStatus == true && elementUnder.spriteName == "Player"){
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    model.getLevel().setElement( new Digged(i,j),i,j);
                }
            }
            /*restart function here*/
        }
        if(this.fallingStatus == true && elementUnder.spriteName == "Enemy"){
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    model.getLevel().setElement( new Digged(i,j),i,j);
                }
            }
            model.getLevel().setElement( new Diamonds(x,y+1),x,y+1);
        }
        this.fallingStatus=false;
    }


}
