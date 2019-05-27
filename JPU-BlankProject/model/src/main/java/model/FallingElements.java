package model;


public class FallingElements extends Elements {

    Elements elementUnder = getElement(x,y-1);
    Elements elementLeft = getElement(x-1,y);
    Elements elementRight = getElement(x+1,y);
    Elements elementLUnder = getElement(x-1,y+1);
    Elements elementRUnder = getElement(x+1,y+1);
    public void falling() {

        /*
        Falling function just move the current object down and replace his older position with "digged"
         */
        if (elementUnder.spriteName == "Digged") {
            this.y++;
            setElement(model.Elements.Digged, this.x, this.y);
            this.fallingStatus = true;
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
           for(int i=x-;i<=x+1;i++){
               for(int j=y-;j<=y+1;j++){
                    setElement(model.Elements.Digged,i,j);
               }
           }
           /*restart function here*/
        }
        if(this.fallingStatus == true && elementUnder.spriteName == "Enemy"){
            for(int i=x-;i<=x+1;i++){
                for(int j=y-;j<=y+1;j++){
                    setElement(model.Elements.Digged,i,j);
                }
            }
            SetElement(model.Elements.Diamonds,x,y+1);
        }
    }


}
