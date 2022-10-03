package arkanoid.hit_listener;
import arkanoid.sprites.*;
/**
 * @author Gal Giladi
 */
public interface HitListener {
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.
    /**
     * hitEvent function: the function is called whenever the beingHit object is hit.
     * @param beingHit  : a Block-type variable that represents that block that is being hitted.
     * @param hitter  : a Ball-type variable that represents the ball that hit a block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
