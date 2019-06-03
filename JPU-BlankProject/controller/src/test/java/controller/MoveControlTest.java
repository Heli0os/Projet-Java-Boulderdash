package controller;

import contract.IModel;
import model.Elements.Diamonds;

import static junit.framework.TestCase.*;

/**
 * Test of the class MoveControl
 * @author Baptiste
 */
public class MoveControlTest {

    /**
     * The model
     */
    private IModel model;

    /**
     * Initializing moveToTest
     */
    private int moveToTest = 5;

    /**
     * The moveControl to test getInstance method
     */
    private MoveControl moveControl;

    /**
     * The diamond to test moveTo method
     */
    private Diamonds diamond;

    /**
     * Set up the moveControl and the diamond with coordinates 5, 5 (moveToTest, moveToTest)
     * @throws Exception
     */
    @org.junit.Before
    public void setUp() throws Exception {
        moveControl = new MoveControl(model);
        diamond = new Diamonds(moveToTest, moveToTest);
    }

    /**
     * Test if the instance of moveControl is not null
     * @throws Exception
     */
    @org.junit.Test
    public void testGetInstanceIfNotNull() throws Exception {
        MoveControl result = moveControl.getInstance();
        assertNotNull(result);
    }

    /**
     * Test if the getter returns the correct value
     * @throws Exception
     */
    @org.junit.Test
    public void testGetInstance() throws Exception {
        MoveControl result = moveControl.getInstance();
        assertEquals(moveControl, result);
    }

    /**
     * Test if moveControl is set null
     * @throws Exception
     */
    @org.junit.Test
    public void testGetInstanceIfNull() throws Exception {
        moveControl.setInstance(null);
        MoveControl result = moveControl.getInstance();
        assertNull(result);
    }

    /**
     * Test both x and y coordinates before and after if diamond doesn't move
     * @throws Exception
     */
    @org.junit.Test
    public void testMoveToIfNotMoving() throws Exception {
        int expectedX = diamond.getX();
        int expectedY = diamond.getY();
        moveControl.moveTo(diamond, moveToTest, moveToTest);
        int resultX = diamond.getX();
        int resultY = diamond.getY();
        assertEquals(expectedX, resultX);
        assertEquals(expectedY, resultY);
    }

    /**
     * Test both x and y coordinates before and after if diamond goes +1, +1
     * @throws Exception
     */
    @org.junit.Test
    public void testMoveToPlus() throws Exception {
        int expectedX = diamond.getX();
        int expectedY = diamond.getY();
        moveControl.moveTo(diamond, moveToTest +1, moveToTest +1);
        int resultX = diamond.getX();
        int resultY = diamond.getY();
        assertEquals(expectedX +1, resultX);
        assertEquals(expectedY +1, resultY);
    }

    /**
     * Test both x and y coordinates before and after if diamond goes -1, -1
     * @throws Exception
     */
    @org.junit.Test
    public void testMoveToMinus() throws Exception {
        int expectedX = diamond.getX();
        int expectedY = diamond.getY();
        moveControl.moveTo(diamond, moveToTest -1, moveToTest -1);
        int resultX = diamond.getX();
        int resultY = diamond.getY();
        assertEquals(expectedX -1, resultX);
        assertEquals(expectedY -1, resultY);
    }
}