package controller;

import contract.IModel;
import model.Elements.Diamonds;

import static junit.framework.TestCase.*;

public class MoveControlTest {

    private IModel model;
    private int moveToTest = 5;
    private MoveControl moveControl = new MoveControl(model);
    private Diamonds diamond = new Diamonds(moveToTest, moveToTest);

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testGetInstanceIfNotNull() {
        MoveControl result = moveControl.getInstance();
        assertNotNull(result);
    }

    @org.junit.Test
    public void testGetInstance() {
        MoveControl result = moveControl.getInstance();
        assertEquals(moveControl, result);
    }

    @org.junit.Test
    public void testGetInstanceIfNull() {
        moveControl.setInstance(null);
        MoveControl result = moveControl.getInstance();
        assertNull(result);
    }

    @org.junit.Test
    public void movementIsPossible() {
    }

    @org.junit.Test
    public void testMoveToIfNotMoving() {
        int expectedX = diamond.getX();
        int expectedY = diamond.getY();
        moveControl.moveTo(diamond, moveToTest, moveToTest);
        int resultX = diamond.getX();
        int resultY = diamond.getY();
        assertEquals(expectedX, resultX);
        assertEquals(expectedY, resultY);
    }

    @org.junit.Test
    public void testMoveToIfNotMovingPlus() {
        int expectedX = diamond.getX();
        int expectedY = diamond.getY();
        moveControl.moveTo(diamond, moveToTest +1, moveToTest +1);
        int resultX = diamond.getX();
        int resultY = diamond.getY();
        assertEquals(expectedX +1, resultX);
        assertEquals(expectedY +1, resultY);
    }

    @org.junit.Test
    public void testMoveToIfNotMovingMinus() {
        int expectedX = diamond.getX();
        int expectedY = diamond.getY();
        moveControl.moveTo(diamond, moveToTest -1, moveToTest -1);
        int resultX = diamond.getX();
        int resultY = diamond.getY();
        assertEquals(expectedX -1, resultX);
        assertEquals(expectedY -1, resultY);
    }
}