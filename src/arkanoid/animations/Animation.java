package arkanoid.animations;
import biuoop.DrawSurface;
/**
 * @author Gal Giladi
 */
public interface Animation {
    /**
     * doOneFrame function: do one frame of the game.
     * @param d is a DrawSurface-type variable.
     */
    void doOneFrame(DrawSurface d);

    /**
     * shouldStop function: tells us if we should stop the frame or not.
     * @return boolean-type variable.
     */
    boolean shouldStop();
}
