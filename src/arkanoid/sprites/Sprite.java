package arkanoid.sprites;
import biuoop.DrawSurface;
/**
 * @author Gal Giladi
 */
public interface Sprite {
    /**
     * drawOn function: the function draws the sprite on the received DrawSurface variable.
     * @param d : a DrawSurface-type variable that the sprite will be drawn on.
     */
    void drawOn(DrawSurface d);
    /**
     * timePassed function: the function notify the sprite that time has passed.
     */
    void timePassed();
}
