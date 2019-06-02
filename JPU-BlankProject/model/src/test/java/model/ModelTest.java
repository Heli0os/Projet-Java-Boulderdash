package model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;
import java.util.Observer;

import static org.junit.Assert.*;

/**
 * The test for the class model
 * @author Clément
 */
@RunWith(Arquillian.class)
public class ModelTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Model.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    Model test;
    boolean notified = false;
    DAOMap daoMap;

    @Before
    public void setUp() throws Exception {
        test = new Model();
    }

    @Test
    public void testUpdate() throws Exception {
        test.addObserver((Observer) this);
        assertFalse("Should notify only after update",notified);
        test.update();
        assertTrue("Should notify after update",notified);
    }

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

    @Test
    public void testCollectDiamonds() {
        int diamondsCollected = 0;
        int attempted = diamondsCollected + 1;
        test.collectDiamonds();
        assertEquals("The number of diamonds collected must be 1",attempted, test.getLevel().getDiamondsCollected());
    }

    @Test
    public void testLoadLevels() {
        test.loadLevels();
        assertNotNull("The list of levels can't be null",test.getLevelsList());
        assertTrue("The list of levels can't be empty",test.getLevelsList().size() > 0);
    }

    @Test
    public void testLoadLevel() throws Exception {
        test.loadLevel(0);
        assertNotNull("Level can't be null after loading",test.getLevel());
        assertTrue("The player must be alive when the level is loaded",test.getLevel().getPlayer().isAlive());
        assertFalse("The level can't be finished when the level is loaded",test.getLevel().isFinished());
    }
}
