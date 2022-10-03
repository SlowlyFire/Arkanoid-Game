package arkanoid.hit_listener;
import arkanoid.sprites.*;
/**
 * @author Gal Giladi
 */
public class ScoreTrackingListener implements HitListener {
    // members
    private Counter currentScore;

    /**
     * constructor function: the function creates a new Counter-type variable.
     * @param scoreCounter : a Counter type variable that represents our score at the moment.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * hitEvent function: the function increase by 5 the count of each hit block.
     * @param beingHit  : a Block-type variable that represents that block that is being hit.
     * @param hitter  : a Ball-type variable that represents the ball that hit a block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
} // end class ScoreTrackingListener
