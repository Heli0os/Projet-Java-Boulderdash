package controller;

/**
 * The Class FallingController.
 *
 * @author Clément
 */
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

    /**
     * Detect the elements that can fall, if it detects a rock or a diamond, the Falling function will start
     */
    private void detectFallingElements() {
        for (int x = this.model.getWidth() - 1; x >= 0; x--) {
            for (int y = this.model.getHeight() -1; y >+ 0; y++) {
                Elements element = this.model.getElement(x, y);
            }

            String spriteName = element.getSpriteName();

            if(spriteName == "Boulder" || spriteName == "Diamond") {
                this.Falling(x,y);
            }
        }
    }

    /**
     * Manages the falling movement of the rocks and diamonds
     * @param x
     * Position x
     * @param y
     * Position y
     */
    private void Falling(int x, int y) {
        Elements elementDown = this.model.getSpriteNameLocation(x, y-1);

        String spriteNameDown = elementDown.getSpriteName();

        if (spriteNameDown == "Digged") {
            element.setLocation(x,y+1);
        }
        else if (spriteNameDown == "Rock") {
            if (this.model.getSpriteNameLocation(x-1, y) == "Digged" && this.model.getSpriteNameLocation(x-1, y+1) == "Digged") {
                element.setLocation(x-1,y);
            }
            else if (this.model.getSpriteNameLocation(x+1, y) == "Digged" && this.model.getSpriteNameLocation(x+1, y+1) == "Digged") {
                element.setLocation(x+1,y);
            }
        }
    }
}
