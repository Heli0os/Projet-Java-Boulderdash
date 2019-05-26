package model.Elements;

/**
 * @author Clément
 */

public class Walls extends Elements {
    private String spriteName;

    public Walls (int x, int y) {
        super (x, y, "");
        this.spriteName = "Wall";
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }
}
