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
}
