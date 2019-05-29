package controller;

import contract.IElements;
import contract.IModel;
import model.Elements.Diamonds;
import model.Elements.Rocks;

/**
 * The Class FallingController.
 *
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
    protected void detectFallingElements() {
        for (int x = model.getLevel().getDimensions().getHeight() - 1; x >= 0; x--) {
            for (int y = model.getLevel().getDimensions().getWidth() -1; y >= 0; y--) {
                IElements element = this.model.getLevel().getElement(x, y);

                if(element instanceof Rocks || element instanceof Diamonds) {
                    element.rolling();

                    element.falling();

                    element.cruching();
                }
            }
        }
    }

}
