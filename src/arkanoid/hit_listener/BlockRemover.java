package arkanoid.hit_listener;
import arkanoid.animations.*;
import arkanoid.sprites.*;


/**
 * @author Gal Giladi
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor function: the function creates a new BlockRemover-type variable.
     * @param game : a Game-type variable that represents out game.
     * @param removedBlocks : a Counter-type variable that represents the number of removes blocks.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * hitEvent function: the function decrease the count of the remaining Blocks, and remove the un-needed
     * blocks from the game and from our List<'HitListeners'>.
     * @param beingHit  : a Block-type variable that represents that block that is being hitted.
     * @param hitter  : a Ball-type variable that represents the ball that hit a block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
    }
} // end class BlockRemover