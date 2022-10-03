package arkanoid.animations;
import arkanoid.hit_listener.*;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * @author Gal Giladi
 */
public class EndScreen implements Animation {
    private boolean stop;
    private Counter scoreCounter;
    private String status;
    private KeyboardSensor ks;

    /**
     * constructor: creates an EndScreen object.
     * @param scoreCounter is a Counter-type variable.
     * @param status is a String-type variable.
     */
    public EndScreen(Counter scoreCounter, String status) {
        this.stop = false;
        this.scoreCounter = scoreCounter;
        this.status = status;
    }
    /**
     * doOneFrame function: do one frame of the game.
     * @param d is a DrawSurface-type variable.
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.RED);
        if (this.status.equals("LOSE")) {
            d.drawText(50, 300, "Game Over. Your score is " + this.scoreCounter.getValue(), 50);

        } else if (this.status.equals("WIN")) {
            d.drawText(50, 300, "You Win! Your score is " + this.scoreCounter.getValue(), 50);
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