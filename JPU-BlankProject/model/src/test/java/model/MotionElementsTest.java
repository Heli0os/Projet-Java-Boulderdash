package model.Elements;

import contract.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test for the class MotionElements
 * @author Clément
 */
public class MotionElementsTest {

    /**
     * The motion element test
     */
    MotionElements test = new MotionElements(5, 6, Direction.DOWN, "test", "") {
    };

    /**
     * Test the getter and setter of the Direction for a MotionElement
     */
    @Test
    public void testGetDirection() {
    test.setDirection(Direction.UP);
        assertEquals("The direction must be UP", Direction.UP, test.getDirection());
    }
}
