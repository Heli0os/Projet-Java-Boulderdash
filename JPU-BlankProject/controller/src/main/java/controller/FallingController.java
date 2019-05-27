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
            this.detectFallingElements();
        }
    }
    
    /**
     * Detect the elements that can fall, if it detects a rock or a diamond, the Falling function will start
     */
    private void detectFallingElements() {
        for (int x = this.model.getWidth() - 1; x >= 0; x--) {
            for (int y = this.model.getHeight() -1; y >+ 0; y++) {
                Elements element = this.model.getElement(x,y);




                if(element.getSpriteName() == "Rock" || element.getSpriteName == "Diamond") {
                    element.Falling(x,y);
                }
            }
        }
    }
    
}
