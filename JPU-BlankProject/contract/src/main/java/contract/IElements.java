package contract;

/**
 * The Interface IElements.
 * @author Clément
 */
public interface IElements {

    /**
     * The name of the element
     */
    String name = "";
    
    /**
     * set the Element location
     * The x position
     * @param x
     * The y position
     * @param y
     */
    void setLocation(int x, int y);

    /**
     * get the x position
     * @return
     */
    int getX();

    /**
     * set the y position
     * @return
     */
    int getY();

    /**
     * set the x position
     * @param x
     */
    void setX(int x);

    /**
     * set the y position
     * @param y
     */
    void setY(int y);

    /**
     * set the name
     * @param name
     */
    void setName(String name);

    /**
     * get the spriteName
     * @return
     */
    String getName();

    /**
     * get the sprite
     * @return
     */
    ISprite getSprite();

    /**
     * set the sprite
     * @param sprite
     */
    void setSprite(ISprite sprite);
}
