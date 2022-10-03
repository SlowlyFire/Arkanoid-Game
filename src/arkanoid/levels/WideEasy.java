package arkanoid.levels;
import arkanoid.sprites.*;
import arkanoid.geometry.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Gal Giladi
 */
public class WideEasy implements LevelInformation {
    /**
     * numberOfBalls function: returns number of balls we wish to have.
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 10;
    }
    /**
     * getBalls function: returns list of balls.
     * @return List< Ball > which is a list of balls.
     */
    public List<Ball> getBalls() {
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(new Point(200, 420), 4, Color.WHITE));
        ballList.add(new Ball(new Point(230, 390), 4, Color.WHITE));
        ballList.add(new Ball(new Point(260, 360), 4, Color.WHITE));
        ballList.add(new Ball(new Point(290, 330), 4, Color.WHITE));
        ballList.add(new Ball(new Point(320, 300), 4, Color.WHITE));
        ballList.add(new Ball(new Point(500, 300), 4, Color.WHITE));
        ballList.add(new Ball(new Point(530, 330), 4, Color.WHITE));
        ballList.add(new Ball(new Point(560, 360), 4, Color.WHITE));
        ballList.add(new Ball(new Point(590, 390), 4, Color.WHITE));
        ballList.add(new Ball(new Point(620, 420), 4, Color.WHITE));
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
        velocityList.add(new Velocity(-2, 2.5));
        velocityList.add(new Velocity(3, 2));
        velocityList.add(new Velocity(-4, 1.5));
        velocityList.add(new Velocity(5, 1));
        velocityList.add(new Velocity(5, 1));
        velocityList.add(new Velocity(4, 1.5));
        velocityList.add(new Velocity(-2, 2));
        velocityList.add(new Velocity(-2, 2.5));
        velocityList.add(new Velocity(-1, 3));
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
        return 600;
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
        return new Point(100, 570);
    }
    /**
     * paddleColor function: returns color of the paddle.
     * @return color of paddle.
     */
    public Color paddleColor() {
        return Color.PINK;
    }
    /**
     * levelName function: represents the level name that will be displayed at the top of the screen.
     * @return name of level.
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * getBackground function: the background color for the level.
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        return new Background(Color.WHITE);
    }
    /**
     * blocks function: creates all the blocks for the level.
     * @return List< Block > which is the blocks we will have for the level.
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(new Rectangle(new Point(10, 230), 52, 20), Color.RED));
        blockList.add(new Block(new Rectangle(new Point(62, 230), 52, 20), Color.RED));
        blockList.add(new Block(new Rectangle(new Point(114, 230), 52, 20), Color.ORANGE));
        blockList.add(new Block(new Rectangle(new Point(166, 230), 52, 20), Color.ORANGE));
        blockList.add(new Block(new Rectangle(new Point(218, 230), 52, 20), Color.YELLOW));
        blockList.add(new Block(new Rectangle(new Point(270, 230), 52, 20), Color.YELLOW));
        blockList.add(new Block(new Rectangle(new Point(322, 230), 52, 20), Color.GREEN));
        blockList.add(new Block(new Rectangle(new Point(374, 230), 52, 20), Color.GREEN));
        blockList.add(new Block(new Rectangle(new Point(426, 230), 52, 20), Color.GREEN));
        blockList.add(new Block(new Rectangle(new Point(478, 230), 52, 20), Color.BLUE));
        blockList.add(new Block(new Rectangle(new Point(530, 230), 52, 20), Color.BLUE));
        blockList.add(new Block(new Rectangle(new Point(582, 230), 52, 20), Color.PINK));
        blockList.add(new Block(new Rectangle(new Point(634, 230), 52, 20), Color.PINK));
        blockList.add(new Block(new Rectangle(new Point(686, 230), 52, 20), Color.CYAN));
        blockList.add(new Block(new Rectangle(new Point(738, 230), 52, 20), Color.CYAN));
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
