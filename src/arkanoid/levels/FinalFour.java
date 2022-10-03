package arkanoid.levels;
import arkanoid.sprites.*;
import arkanoid.geometry.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Gal Giladi
 */
public class FinalFour implements LevelInformation {
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
        ballList.add(new Ball(new Point(350, 390), 4, Color.WHITE));
        ballList.add(new Ball(new Point(400, 390), 4, Color.WHITE));
        ballList.add(new Ball(new Point(450, 390), 4, Color.WHITE));
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
        velocityList.add(new Velocity(0.01, 4));
        velocityList.add(new Velocity(-1, 3));
        velocityList.add(new Velocity(-2, 4));
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
        return 200;
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
        return new Point(300, 570);
    }

    /**
     * paddleColor function: returns color of the paddle.
     * @return color of paddle.
     */
    public Color paddleColor() {
        return Color.BLACK;
    }

    /**
     * levelName function: represents the level name that will be displayed at the top of the screen.
     * @return name of level.
     */
    public String levelName() {
        return "Final Four";
    }

    /**
     * getBackground function: the background color for the level.
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        return new Background(new Color(65, 105, 225));
    }

    /**
     * blocks function: creates all the blocks for the level.
     * @return List< Block > which is the blocks we will have for the level.
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();

        for (int i = 10; i < 790; i += 52) {
            blockList.add(new Block(new Rectangle(new Point(i, 100), 52, 20), Color.GRAY));
            blockList.add(new Block(new Rectangle(new Point(i, 120), 52, 20), Color.RED));
            blockList.add(new Block(new Rectangle(new Point(i, 140), 52, 20), Color.YELLOW));
            blockList.add(new Block(new Rectangle(new Point(i, 160), 52, 20), Color.GREEN));
            blockList.add(new Block(new Rectangle(new Point(i, 180), 52, 20), Color.WHITE));
            blockList.add(new Block(new Rectangle(new Point(i, 200), 52, 20), Color.PINK));
            blockList.add(new Block(new Rectangle(new Point(i, 220), 52, 20), Color.CYAN));
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