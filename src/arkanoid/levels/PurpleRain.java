package arkanoid.levels;
import arkanoid.sprites.*;
import arkanoid.geometry.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Gal Giladi
 */
public class PurpleRain implements LevelInformation {
    /**
     * numberOfBalls function: returns number of balls we wish to have.
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * getBalls function: returns list of balls.
     * @return List< Ball > which is a list of balls.
     */
    public List<Ball> getBalls() {
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(new Point(300, 390), 4, Color.WHITE));
        ballList.add(new Ball(new Point(500, 390), 4, Color.WHITE));
        ballList.add(new Ball(new Point(400, 390), 4, Color.WHITE));
        return ballList;
    }

    /**
     * initialBallVelocities function: initial velocities to balls in our ball list accordingly.
     * @return List< Velocity > which is a list of velocities of the balls we created.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        // add only a vertical velocity (dy) to the ball, so its fly straight forward to the block
        velocityList.add(new Velocity(1, 3));
        velocityList.add(new Velocity(-1, 4));
        velocityList.add(new Velocity(2, 3));
        return velocityList;
    }
    /**
     * paddleSpeed function: returns paddle speed by pixels we move it to each side.
     * @return speed of paddle.
     */
    public int paddleSpeed() {
        return 5;
    }
    /**
     * paddleWidth function: returns width of the paddle.
     * @return width of the paddle.
     */
    public int paddleWidth() {
        return 250;
    }
    /**
     * paddleHeight function: returns the height of the paddle.
     * @return height of the paddle.
     */
    public int paddleHeight() {
        return 20;
    }
    /**
     * paddleUpperLeft function: returns the upper left Point of the rectangle (Block paddle).
     * @return the upper left Point of the paddle.
     */
    public Point paddleUpperLeft() {
        return new Point(275, 570);
    }
    /**
     * paddleColor function: returns color of the paddle.
     * @return color of paddle.
     */
    public Color paddleColor() {
        return Color.WHITE;
    }
    /**
     * levelName function: represents the level name that will be displayed at the top of the screen.
     * @return name of level.
     */
    public String levelName() {
        return "Purple Rain";
    }

    /**
     * getBackground function: the background color for the level.
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {

        return new Background(new Color(0, 0, 0));
    }

    /**
     * blocks function: creates all the blocks for the level.
     * @return List< Block > which is the blocks we will have for the level.
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();

        for (int i = 730; i > 140; i -= 60) {
            blockList.add(new Block(new Rectangle(new Point(i, 200), 60, 20), new Color(102, 0, 153)));
        }
        for (int i = 730; i > 200; i -= 60) {
            blockList.add(new Block(new Rectangle(new Point(i, 220), 60, 20), new Color(102, 0, 153)));
        }
        for (int i = 730; i > 260; i -= 60) {
            blockList.add(new Block(new Rectangle(new Point(i, 240), 60, 20), new Color(102, 0, 153)));
        }
        for (int i = 730; i > 320; i -= 60) {
            blockList.add(new Block(new Rectangle(new Point(i, 260), 60, 20), new Color(102, 0, 153)));
        }
        for (int i = 730; i > 380; i -= 60) {
            blockList.add(new Block(new Rectangle(new Point(i, 280), 60, 20), new Color(102, 0, 153)));
        }
        return blockList;
    }

    /**
     * numberOfBlocksToRemove function: Number of blocks that should be removed before the level is
     * considered to be "cleared". This number should be <= blocks.size().
     * @return number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
