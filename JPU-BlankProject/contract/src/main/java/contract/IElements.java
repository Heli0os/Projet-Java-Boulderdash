package contract;

import java.awt.*;

/**
 * The Interface IElements.
 *
 * @author Clément
 */
public interface IElements {
    void setLocation(int x, int y);

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    void setSpriteName(String spriteName);

    String getSpriteName();

    ISprite getSprite();

    void setSprite(ISprite sprite);

    Image getImage();

    boolean isAlive();

    void setIsAlive (boolean isAlive);

    void falling();
    void rolling();
    void cruching();




}

