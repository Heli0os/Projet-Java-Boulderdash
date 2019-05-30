package model.Elements;

import contract.IElements;
import contract.IFallingElements;
import model.Model;

abstract class FallingElements extends Elements implements IFallingElements {

    private Model model = Model.getInstance();
    public boolean fallingStatus;


    IElements elementUnder;
    IElements elementLeft;
    IElements elementRight;
    IElements elementLUnder;
    IElements elementRUnder;

    public FallingElements (int x, int y, String name, String imagePath) {
        super(x, y, name, imagePath);
        this.fallingStatus = false;
    }
    public void scan(){
        this.elementUnder = this.model.getLevel().getElement(this.x,this.y-1);
        this.elementLeft =  this.model.getLevel().getElement(this.x-1,this.y);
        this.elementRight =  this.model.getLevel().getElement(this.x+1,this.y);
        this.elementLUnder=  this.model.getLevel().getElement(this.x-1,this.y+1);
        this.elementRUnder =  this.model.getLevel().getElement(this.x+1,this.y+1);
    }


    public void falling() {
        this.scan();
        /*
        Falling function just move the current object down and replace his older position with "digged" and set falling status to true
         */
        if (elementUnder.name == "Digged") {
            this.y++;
            this.fallingStatus=true;
        }
    }

    public void rolling(){
        this.scan();
        /*
        Make falling element roll to fall aside
         */
        if(elementUnder.name == "Rock" || elementUnder.name == "Diamond"){
            if(elementLeft.name == "Digged" && elementLUnder.name == "Digged"){
                this.x--;
            }
            if(elementRight.name == "Digged" && elementRUnder.name == "Digged"){
                this.x++;
            }
        }
    }

    public void crushing(){
        this.scan();
        if(this.fallingStatus == true && elementUnder.name == "Player"){
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    model.getLevel().setElement( new Digged(i,j),i,j);
                }
            }
            /*restart function here*/
        }
        if(this.fallingStatus == true && elementUnder.name == "Enemy"){
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
