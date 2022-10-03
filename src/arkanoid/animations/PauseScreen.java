package arkanoid.animations;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Gal Giladi
 */
public class PauseScreen implements Animation {
    // members
    private boolean stop;

    /**
     * construcor function: creates a PauseScreen object.
     */
    public PauseScreen() {
        this.stop = false;
    }
    /**
     * doOneFrame function: do one frame of the game.
     * @param d is a DrawSurface-type variable.
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    /**
     * shouldStop function: tells us if we should stop the frame or not.
     * @return boolean-type variable.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}