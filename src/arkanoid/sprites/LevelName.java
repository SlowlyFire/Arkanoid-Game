package arkanoid.sprites;
import arkanoid.levels.*;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Gal Giladi
 */
public class LevelName implements Sprite {
    // members
    private LevelInformation level;

    /**
     * constructor: creates a LevelInformation object.
     * @param level is a LevelInformation-type variable.
     */
    public LevelName(LevelInformation level) {
        this.level = level;
    }
    /**
     * drawOn function: the function draws the sprite on the received DrawSurface variable.
     * @param d : a DrawSurface-type variable that the sprite will be drawn on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.RED);
        d.drawText(580, 30, "Level Name: " + this.level.levelName(), 16);
    }
    /**
     * timePassed function: the function notify the sprite that time has passed.
     */
    public void timePassed() {
    }
}