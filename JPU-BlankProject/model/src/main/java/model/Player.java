package model.Elements;

/**
 * @author Clément
 */
public class Player extends MotionElements {
    private String spriteName;
    private boolean isAlive;

    public Player (int x, int y) {
        super (x, y, "");
        this.isAlive = true;
        this.spriteName = "Player";
    }

    public boolean getIfIsAlive() {
        return isAlive;
    }

    public void setIsAlive (boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }
}
