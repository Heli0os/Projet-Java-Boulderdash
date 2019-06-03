package model.Elements;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * The test for the class elements
 * @author Clément
 */
@RunWith(Arquillian.class)
public class ElementsTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Elements.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    /**
     * The element test
     */
    Elements test;

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
