package model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Test of the class DBProperties
 * @author Clément
 */
@RunWith(Arquillian.class)
public class DBPropertiesTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(DBProperties.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    /**
     * The test database properties
     */
    DBProperties test;

    /**
     * Set up the test database properties
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        test = new DBProperties();
    }

    /**
     * test the getter of the url of the database
     * @throws Exception
     */
    @Test
    public void testGetUrl() throws Exception {
        assertNotNull("The url can't be null",test.getLogin());
        assertNotEquals("The database must have an url","",test.getUrl());
    }

    /**
     * test the getter for the login of the database
     * @throws Exception
     */
    @Test
    public void testGetLogin() throws Exception {
        assertNotNull("The login field can't be null",test.getLogin());
        assertNotEquals("The database must have a login","",test.getLogin());
    }

    /**
     * test the getter for the password of the database
     * @throws Exception
     */
    @Test
    public void testGetPassword() throws Exception {
        assertEquals("Password field must be empty in our case", "",test.getPassword());
    }
}
