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
}
