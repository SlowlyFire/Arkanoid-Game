package arkanoid.animations;
import arkanoid.sprites.*;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;
/**
 * @author Gal Giladi
 */
public class CountdownAnimation implements Animation {
    // members
    private SpriteCollection gameScreen;
    private double numOfSeconds;
    private int countFrom;
    private boolean stop;
    private Sleeper sleeper;

    /**
     * constructor: creates a CountdownAnimation object.
     * @param numOfSeconds - number of second to run the countdown.
     * @param countFrom - count from a specific number.
     * @param gameScreen - a SpriteCollection-type variable we draw all the sprites on.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.stop = false;
        this.sleeper = new Sleeper();
    }
    /**
     * doOneFrame function: do one frame of the game.
     * @param d is a DrawSurface-type variable.
     */
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        d.setColor(Color.RED);
        if (this.countFrom == 3) {
            d.drawText(370, 300, "3", 100);
            this.countFrom--;
        } else if (this.countFrom == 2) {
            d.drawText(370, 300, "2", 100);
            this.countFrom--;
            this.sleeper.sleepFor((long) (this.numOfSeconds / (this.countFrom + 1)) * 1000);
        } else if (this.countFrom == 1) {
            d.drawText(370, 300, "1", 102);
            this.countFrom--;
            this.sleeper.sleepFor((long) (this.numOfSeconds / (this.countFrom + 2)) * 1000);
        } else if (this.countFrom == 0) {
            this.sleeper.sleepFor((long) (this.numOfSeconds / (this.countFrom + 2)) * 1000);
            this.stop = true;
        }
    }
    /**
     * shouldStop function: tells us if we should stop the frame or not.
     * @return boolean-type variable.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}