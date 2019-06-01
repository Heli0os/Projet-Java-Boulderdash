package controller;

import contract.IFallingElements;
import contract.IModel;
import model.Elements.Diamonds;
import model.Elements.Rocks;

/**
 * The Class FallingController.
 * @author Clément / Théophile
 */
public class FallingController {

    /**
     * The model
     */
    private IModel model;

    /**
     * The constructor of the FallingController
     * @param model The model
     */
    public FallingController(IModel model) {
        this.model = model;
    }

    /**
     * Detect the elements that can fall, if it detects a rock or a diamond, the Falling function will start
     */
    public void detectFallingElements() {
        for (int x = 0;x<=model.getLevel().getDimensions().getHeight() -1; x++) {
            for (int y = 0; y<=model.getLevel().getDimensions().getWidth() -1; y++) {
                try{
                    IFallingElements element = (IFallingElements) this.model.getLevel().getElement(x, y);
                    if(element instanceof Rocks || element instanceof Diamonds) {
                        element.falling();
                    }
                }
                catch (ClassCastException c){
                }
            }
        }
    }
}
