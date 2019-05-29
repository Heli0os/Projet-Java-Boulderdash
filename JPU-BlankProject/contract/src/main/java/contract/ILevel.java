package contract;

        /**
 * The Interface IModel.
 *
 * @author Clément
 */
public interface ILevel {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    int getDiamondsNumber();

    void setDiamondsNumber(int diamondsNumber);

    IElements getPlayer();

    void setPlayer(IElements player);

    boolean isFinished();

    void setFinished(boolean finished);

    boolean isPaused();

    void setPaused(boolean paused);

    int getDiamondsCollected();

    void setDiamondsCollected(int diamondsCollected);

    IDimensions getDimensions();

    void setDimensions (IDimensions dimensions);

    IElements[][] getElements();

    IElements getElement(int x,int y);

    void setElement(IElements element,int x,int y);

}
