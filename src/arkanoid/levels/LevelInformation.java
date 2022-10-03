package arkanoid.levels;
import arkanoid.sprites.*;
import arkanoid.geometry.*;
import java.awt.Color;
import java.util.List;
/**
 * @author Gal Giladi
 */
public interface LevelInformation {
    /**
     * numberOfBalls function: returns number of balls we wish to have.
     * @return number of balls.
     */
    int numberOfBalls();
    /**
     * getBalls function: returns list of balls.
     * @return List< Ball > which is a list of balls.
     */
    List<Ball> getBalls();
    /**
     * initialBallVelocities function: initial velocities to balls in our ball list accordingly.
     * @return List< Velocity > which is a list of velocities of the balls we created.
     */
    List<Velocity> initialBallVelocities();
    /**
     * paddleSpeed function: returns paddle speed by pixels we move it to each side.
     * @return speed of paddle.
     */
    int paddleSpeed();
    /**
     * paddleWidth function: returns width of the paddle.
     * @return width of the paddle.
     */
    int paddleWidth();
    /**
     * paddleHeight function: returns the height of the paddle.
     * @return height of the paddle.
     */
    int paddleHeight();
    /**
     * paddleColor function: returns color of the paddle.
     * @return color of paddle.
     */
    Color paddleColor();
    /**
     * paddleUpperLeft function: returns the upper left Point of the rectangle (Block paddle).
     * @return the upper left Point of the paddle.
     */
    Point paddleUpperLeft();
    /**
     * levelName function: represents the level name that will be displayed at the top of the screen.
     * @return name of level.
     */
    String levelName();
    /**
     * getBackground function: the background color for the level.
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();
    /**
     * blocks function: creates all the blocks for the level.
     * @return List< Block > which is the blocks we will have for the level.
     */
    List<Block> blocks();
    /**
     * numberOfBlocksToRemove function: Number of blocks that should be removed before the level is
     * considered to be "cleared". This number should be <= blocks.size().
     * @return number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
}