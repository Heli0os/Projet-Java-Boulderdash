package controller;

public class FallingController {
    private Model model;

    public FallingController(Model model) {
        this.model = model;
    }

    public void run() {
        while (this.model.isGameRunning()) {
            this.Falling();
        }
    }

    private void detectFallingElements() {
        for (int x = this.model.getWidth() - 1; x >= 0; x--) {
            for (int y = this.model.getHeight() -1; y >+ 0; y++) {
                Elements element = this.model.getLocation()[x][y];
            }

            String spriteName = element.getSpriteName();

            if(spriteName == "Boulder" || spriteName == "Diamond") {
                this.Falling(x,y);
            }
        }
    }

    private void Falling(int x, int y) {
        Elements elementDown = this.model.getLocation()[x][y+1];

        String spriteNameDown = elementDown.getSpriteName();

        if (spriteNameDown == "Digged") {
            this.model.elementsFalling(x,y);
        }
        else if (spriteNameDown == "Boulder") {
            if (this.model.getLocation()[x-1][y+1].getSpriteName == "Digged") {
                this.model.fallingLeft(x,y);
            }
            else if (this.model.getLocation()[x+1][y+1].getSpriteName == "Digged") {
                this.model.fallingRight(x,y);
            }
        }
    }
}
