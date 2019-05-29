/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import controller.Controller;
import model.Model;
import view.View;

import java.sql.SQLException;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) throws SQLException {
        final Model model = new Model();
        final View view = new View();
        final Controller controller = new Controller(view, model);
        view.setController(controller);
        controller.start(0);


        /*
        * Game sequence:
        * -initialisation
        * -load map data through database
        * -place elements
         */
    }
}
