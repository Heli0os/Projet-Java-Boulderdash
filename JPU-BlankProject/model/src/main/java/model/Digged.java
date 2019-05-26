package model.Elements;

/**
 * @author Clément
 */
public class Digged extends Elements {
    private String spriteName;

    public Digged (int x, int y) {
        super (x, y, "");
        this.spriteName = "Digged";
    }

    public String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }
}
