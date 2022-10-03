package arkanoid.sprites;
import arkanoid.hit_listener.*;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Gal Giladi
 */
public class ScoreIndicator implements Sprite {
    // members
    private Counter scoreCounter;

    /**
     * constructor function: the function creates a new Counter-type variable.
     * @param scoreCounter : a Counter type variable that indicates our score at the moment and draw it to our gui,
     * assuming ScoreIndicator is a Sprite.
     */
    public ScoreIndicator(Counter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }

    /**
     * drawOn function: the function draws the sprite on the received DrawSurface variable.
     * @param d : a DrawSurface-type variable that the sprite will be drawn on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.RED);
        d.drawText(370, 30, "Score: " + this.scoreCounter.getValue(), 16);
    }

    /**
     * timePassed function: the function notify the sprite that time has passed.
     */
    public void timePassed() {
    }
} // end class ScoreIndicator
