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
 * Test of the class DBConnection
 * @author Clément
 */
@RunWith(Arquillian.class)
public class DBConnectionTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(DBConnection.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    /**
     * The database connection test
     */
    DBConnection test;

    /**
     * Set up the test connection
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        test = DBConnection.getInstance();
    }

    /**
     * test the getter of the instance
     * @throws Exception
     */

    @Test
    public void testGetInstance() throws Exception {
        assertNotNull("The instance of the database can't be null",test);
    }

    /**
     * Test the getter of the connection to the database
     * @throws Exception
     */

    @Test
    public void testGetConnection() throws Exception {
        assertNotNull("The connection to the database can't be null",test.getConnection());
        assertFalse("The database connection should be opened",test.getConnection().isClosed());
        assertFalse("The database connection should be writable",test.getConnection().isReadOnly());
    }
}
