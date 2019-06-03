package model.Elements;

import contract.Direction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * The test for the class MotionElements
 * @author Clément
 */
@RunWith(Arquillian.class)
public class MotionElementsTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(MotionElements.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    /**
     * The motion element test
     */
    MotionElements test;

    /**
     * Test the getter and setter of the Direction for a MotionElement
     */
    @Test
    public void testGetDirection() {
    test.setDirection(Direction.UP);
        assertEquals("The direction must be UP", Direction.UP, test.getDirection());
    }
}
