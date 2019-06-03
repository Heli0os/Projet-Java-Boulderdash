package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of the class DBProperties
 * @author Clément
 */
public class DBPropertiesTest {

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
