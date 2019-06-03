package model.Elements;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test for the class elements
 * @author Clément
 */
public class ElementsTest {

    /**
     * The element test
     */
    Elements test = new Elements(4, 7, "Rock", "") {
    };

    @Test
    public void setLocation() {
    test.setLocation(5, 6);
    assertEquals("The x position must be 5", 5, test.getX());
    assertEquals("The y position must be 6", 6, test.getY());
    }

    @Test
    public void setX() {
    test.setX(7);
    assertEquals("The x position must be 7", 7, test.getX());
    }

    @Test
    public void setY() {
        test.setY(3);
    assertEquals("The x position must be 7", 3, test.getY());
    }

    @Test
    public void setName() {
        test.setName("Rock");
        test.setX(7);
        assertEquals("The name must be Rock", "Rock", test.getName());
    }
}
