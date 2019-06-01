package contract;

import java.util.Observer;

/**
 * The Interface IView.
 *
 * @author Clément
 */
public interface IView {
    /**
     * close the view
     */
    void close();

    /**
     * get the observer
     * @return
     */
    Observer getObserver();

    /**
     * A function used to print a message on the screen
     * @param s The message
     */
    void printMessage(String s);
}
