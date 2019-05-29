package contract;

/**
 * The Interface IElements.
 *
 * @author Clément
 */
public interface IElements {


    String spriteName = "";



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
     * set the spriteName
     * @param spriteName
     */
    void setSpriteName(String spriteName);

    /**
     * get the spriteName
     * @return
     */
    String getSpriteName();

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

    String getImage();
    /**
     * get the image
     * @return
     */
    Image getImage();

    /**
     * boolean that says if the element is alive or not
     * @return
     */
    boolean isAlive();

    /**
     * set the element as alive or not
     * @param isAlive
     */
    void setIsAlive (boolean isAlive);






    /**
     * the fall function
     */
    void falling();

    /**
     * the roll function
     */
    void rolling();

    /**
     * the cruch function
     */
    void cruching();
}

