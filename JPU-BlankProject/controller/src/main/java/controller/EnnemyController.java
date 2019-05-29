package controller;

import contract.*;
import model.Elements.Ennemies;

import java.util.Random;

public class EnnemyController {
        private static EnnemyController ec;
        private IModel model;
        private MoveControl moveControl;
        private static Random random;
        private Direction direction;

        public static EnnemyController getInstance() {
            if (ec == null)
                System.err.println("no EnnemyController");
            return ec;
        }

        public EnnemyController(IModel model) {
            this.model = model;
            this.moveControl = moveControl.getInstance();
        }

        public static void init (IModel model) {
            ec = new EnnemyController(model);
            random = new Random();
        }

        protected void performMovement() {
            for (int x = model.getLevel().getDimensions().getHeight() - 1; x >= 0; x--) {
                for (int y = model.getLevel().getDimensions().getWidth() - 1; y >= 0; y--) {
                    IElements element = this.model.getLevel().getElement(x, y);

                    if (element instanceof Ennemies) {
                        moveControl.movementIsPossible(Direction.getRandomDirection(), element.getX(), element.getY());
                    }
                }
            }
        }
}
