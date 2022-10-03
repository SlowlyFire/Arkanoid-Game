package arkanoid.sprites;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Gal Giladi
 */
public class Background implements Sprite {
    // members
    private Color color;

    /**
     * construcor: creates a Background object.
     * @param color which is the color we want, of the background.
     */
    public Background(Color color) {
        this.color = color;
    }
    /**
     * drawOn function: the function draws the sprite on the received DrawSurface variable.
     * @param d : a DrawSurface-type variable that the sprite will be drawn on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle(10, 10, d.getWidth() - 20, d.getHeight() - 20);
    }

    /**
     * timePassed function: the function notify the sprite that time has passed.
     */
    public void timePassed() {
    }
}