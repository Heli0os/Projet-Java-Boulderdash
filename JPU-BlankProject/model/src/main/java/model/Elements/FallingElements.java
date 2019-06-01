package model.Elements;

import contract.IElements;
import contract.IFallingElements;
import model.Model;

/**
 * The class FallingElements
 * @author Clément & Théophile
 */
abstract class FallingElements extends Elements implements IFallingElements {

    /**
     * The model
     */
    private Model model = Model.getInstance();

    /**
     * Falling or not
     */
    public boolean fallingStatus;

    /**
     * Refers to the different elements around the falling element
     */
    IElements elementUnder;
    IElements elementLeft;
    IElements elementRight;
    IElements elementLUnder;
    IElements elementRUnder;

    /**
     * The constructor
     * @param x Position x
     * @param y Position y
     * @param name The name
     * @param imagePath The path of the image
     */
    public FallingElements (int x, int y, String name, String imagePath) {
        super(x, y, name, imagePath);
        this.fallingStatus = false;
    }

    /**
     * Scan the elements around the falling element
     */
    public void scan(){
        this.elementUnder = this.model.getLevel().getElement(this.x,this.y+1);
        this.elementLeft = this.model.getLevel().getElement(this.x-1,this.y);
        this.elementRight = this.model.getLevel().getElement(this.x+1,this.y);
        this.elementLUnder = this.model.getLevel().getElement(this.x-1,this.y+1);
        this.elementRUnder = this.model.getLevel().getElement(this.x+1,this.y+1);
    }

    /**
     * Falling function just move the current object down and replace his older position with "digged" and set falling status to true
     */
    public void falling() {
        this.scan();
        if (elementUnder.getName().equals("Digged")) {
            this.y += 1;
            this.fallingStatus=true;
        }
        this.rolling();
        this.crushing();
    }

    /**
     *  Make falling element roll to fall aside
     */
    public void rolling(){
        if(elementUnder.getName().equals("Rock") || elementUnder.getName().equals("Diamond")){
            if(elementLeft.getName().equals("Digged") && elementLUnder.getName().equals("Digged")){
                this.x-= 1;
            }
            if(elementRight.getName().equals("Digged") && elementRUnder.getName().equals("Digged")){
                this.x+= 1;
            }
        }
    }

    /**
     * Destroy the player and the ennemies under if it is falling, if it is an ennemy, it will transform him as a diamond
     */
    public void crushing(){
        this.scan();
        if (this.fallingStatus && elementUnder.getName().equals("Player")){
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    model.getLevel().setElement( new Digged(i,j),i,j);
                }
            }
            this.model.getLevel().getPlayer().setIsAlive(false);
        }
        if (this.fallingStatus && elementUnder.getName().equals("Enemy")){
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
