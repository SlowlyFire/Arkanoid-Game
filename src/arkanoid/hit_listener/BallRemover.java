package arkanoid.hit_listener;
import arkanoid.animations.*;
import arkanoid.sprites.*;


/**
 * @author Gal Giladi
 */
public class BallRemover implements HitListener {
    // members
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor function: the function creates a new BallRemover-type variable.
     * @param game : a Game-type variable that represents the game we play.
     * @param removedBalls : a Counter-type variable that represents how many balls left we have.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * hitEvent function: the function decrease the count of the remaining Balls, and remove the un-needed
     * ball from the game.
     * @param beingHit  : a Block-type variable that represents that block that is being hitted.
     * @param hitter  : a Ball-type variable that represents the ball that hit a block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        remainingBalls.decrease(1);
        hitter.removeFromGame(this.game);
    }
} // end class BallRemover