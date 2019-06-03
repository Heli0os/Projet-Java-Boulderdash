package model;

import contract.Direction;
import model.Elements.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test for the class Level
 * @author Clément
 */
public class LevelTest {

    /**
     * The test level
     */
    Level test;

    /**
     * The test player
     */
    Player player;

    /**
     * instanciate a test player and a test level
     */
    @Before
    public void setUp() {
        player = new Player(4, 6, Direction.UP);
        test = new Level(0, "test", 20, 10, 7);
    }

    /**
     * Test the getter and setter for the level Id
     */
    @Test
    public void testGetId() {
        assertEquals("The id should be 0", 0, test.getId());
        test.setId(5);
        assertEquals("The id should be 5", 5, test.getId());
    }

    /**
     * Test the getter and setter for the dimensions of the level
     */
    @Test
    public void testGetDimensions() {
        Dimensions dimensions = new Dimensions(41, 52);
        test.setDimensions(dimensions);
        assertEquals("The Dimensions should be 41 - 52", dimensions, test.getDimensions());
    }

    /**
     * Test the setter and the getter for the name of the level
     */
    @Test
    public void testGetName() {
        test.setName("Level 1");
        assertEquals("The name should be Level 1", "Level 1", test.getName());
    }

    /**
     * Test the getter and the setter for the number of diamonds in the level
     */
    @Test
    public void testGetDiamondsNumber() {
        Level test1 = new Level(0, "test", 20, 10, 5);
        assertEquals("The number of diamonds in the level must be 5", 5, test1.getDiamondsNumber());
    }

    /**
     * Test the getter and setter for the player in the level
     */
    @Test
    public void testGetPlayer() {
        Player player1 = new Player(9,2, Direction.DOWN);
        test.setPlayer(player1);
        assertSame("Should be the same",player1,test.getPlayer());
    }

    /**
     * Test the getter and the setter for the boolean isFinished for the level
     * @throws Exception
     */
    @Test
    public void testIsFinished() throws Exception {
        assertFalse("The level can't be finished when created",test.isFinished());
        test.setFinished(true);
        assertTrue("The level can't be finished when created",test.isFinished());
    }

    /**
     * Test the getter and setter for the number of diamonds collected in the level
     */
    @Test
    public void testGetDiamondsCollected() {
        test.setDiamondsCollected(8);
        assertEquals("You can't have collected diamonds when starting the level", 8, test.getDiamondsCollected());
    }

    /**
     * Test the getter and setter for the boolean isPaused for the level
     */
    @Test
    public void testIsPaused() {
        assertFalse("The level can't be paused when created",test.isPaused());
        test.setPaused(true);
        assertTrue("The level can't be paused when created",test.isPaused());
    }
}
