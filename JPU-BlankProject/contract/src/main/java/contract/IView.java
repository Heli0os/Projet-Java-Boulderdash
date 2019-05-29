package contract;

/**
 * The Interface IView.
 *
 * @author Clément
 */
public interface IView {
    void close();
    
    Observer getObserver();
}
