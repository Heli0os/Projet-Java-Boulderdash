package model.Elements;

import contract.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    Player test = new Player (4, 6, Direction.DOWN);

    @Test
    public void isAlive() {
        test.setIsAlive(true);
        assertTrue("The player must be alive", test.isAlive());
    }
}
