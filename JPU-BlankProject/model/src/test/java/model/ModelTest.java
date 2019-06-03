package model;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * The test for the class model
 * @author Clément
 */
public class ModelTest {

    /**
     * The model test
     */
    Model test;

    /**
     * A boolean to notify the observer
     */
    boolean notified = false;

    /**
     * The DAOMap test
     */
    DAOMap daoMap;

    Level leveltest;

    /**
     * Instanciate a new model for the tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        test = new Model();
        leveltest = new Level (4, "test", 5, 6, 7);
    }

    @Test
    public void testGetLevel() {
        test.getLevel();
        assertNotNull("fail", leveltest);
    }

    /**
     * Test for the start method
     * @throws SQLException
     */
    @Test
    public void testStart() throws SQLException {
        test.loadLevels();
        assertNotNull("The list of levels can't be null",test.getLevelsList());
        assertTrue("The list of levels can't be empty",test.getLevelsList().size() > 0);
        test.loadLevel(this.daoMap.getLevelsList().get(0));
        assertNotNull("Level can't be null after loading",test.getLevel());
        assertTrue("The player must be alive when the level is loaded",test.getLevel().getPlayer().isAlive());
        assertFalse("The level can't be finished when the level is loaded",test.getLevel().isFinished());
    }

    /**
     * Test for the collectDiamonds method
     */
    @Test
    public void testCollectDiamonds() {
        leveltest.setDiamondsCollected(4);
        test.collectDiamonds();
        assertEquals("The number of diamonds collected must be 5",5, leveltest.getDiamondsCollected());
    }

    /**
     * Test for the loadingLevels method
     */
    @Test
    public void testLoadLevels() {
        test.loadLevels();
        assertNotNull("The list of levels can't be null",test.getLevelsList());
        assertTrue("The list of levels can't be empty",test.getLevelsList().size() > 0);
    }

    /**
     * Test for the LoadingLevel method
     * @throws Exception
     */
    @Test
    public void testLoadLevel() throws Exception {
        test.loadLevel(0);
        assertNotNull("Level can't be null after loading",test.getLevel());
        assertTrue("The player must be alive when the level is loaded",test.getLevel().getPlayer().isAlive());
        assertFalse("The level can't be finished when the level is loaded",test.getLevel().isFinished());
    }
}
