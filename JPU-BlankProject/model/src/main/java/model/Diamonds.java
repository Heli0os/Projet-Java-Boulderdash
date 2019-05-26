package model.Elements;

/**
 * @author Clément
 */
public class Diamonds extends Elements {
    private String spriteName;

    public Diamonds (int x, int y) {
        super (x, y, "");
        this.spriteName = "Diamonds";
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }
}
