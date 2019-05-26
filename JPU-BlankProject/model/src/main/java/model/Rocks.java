package model.Elements;

/**
 * @author Clément
 */
public class Rocks extends Elements {
    private String spriteName;

    public Rocks (int x, int y) {
        super (x, y, "");
        this.spriteName = "Rock";
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }
}
