package model.Elements;

/**
 * @author Clément
 */
public class Dirt extends Elements {
    private String spriteName;

    public Dirt (int x, int y) {
        super (x, y, "");
        this.spriteName = "Dirt";
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }
}
