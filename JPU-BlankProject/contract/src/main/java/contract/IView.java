package contract;

import java.util.Observer;

/**
 * The Interface IView.
 *
 * @author Clément
 */
public interface IView {
    void close();
    
    Observer getObserver();
}
