package model.Elements;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class PlayerTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Player.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    Player test;

    @Test
    public void isAlive() {
        test.setIsAlive(true);
        assertTrue("The player must be alive", test.isAlive());
    }
}