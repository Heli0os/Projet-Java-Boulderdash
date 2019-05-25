package controller;

import contract.*;
import java.util.Random;

public class EnnemyController {
        private static EnnemyController ec;
        private IModel model;
        private MoveControl moveControl;
        private static Random random;
        
        public static EnnemyController getInstance() {
            if (ec == null)
                System.err.println("no EnnemyController");
            return ec;
        }
        
        private EnnemyController(IModel model) {
            this.model = model;
            this.moveControl = moveControl.getInstance();
        }
        
        public static void init (IModel model) {
            ec = new EnnemyController(model);
            random = new Random();
        }
        
        private void performMovement(IElement ennemies) {
            int nextX;
            int nextY;
            
            do {
                nextX = ennemies.getLocation().getX() + random.nextInt(1);
                nextY = ennemies.getLocation().getY() + random.nextInt(1);
            }
            while (!this.moveControl.movementIsPossible(nextX, nextY));
            moveControl.movementIsSafe(ennemies, nextX, nextY);
        }
}
