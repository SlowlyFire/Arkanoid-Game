package arkanoid.animations;
import arkanoid.sprites.*;
import arkanoid.hit_listener.*;
import arkanoid.run.*;
import arkanoid.levels.*;
import arkanoid.geometry.*;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.List;
/**
 * @author Gal Giladi
 */
public class GameLevel implements Animation {
    // members
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter scoreCounter;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation level;
    private LevelInformation lastLevel;
    private int numberOfArgs;
    private int levelsCounter;

    /**
     * construcor: creates a GameLevel object.
     * @param level is a LevelInformation-type variable.
     * @param runner is a AnimationRunner-type variable.
     * @param gui is a GUI-type variable.
     * @param scoreCounter is a Counter-type variable.
     * @param lastLevel is a LevelInformation-type variable.
     * @param numberOfArgs is number of arguments we got on command line.
     * @param levelsCounter is a counter that counts how many levels we had been through.
     */
    public GameLevel(LevelInformation level, AnimationRunner runner, GUI gui,
                      Counter scoreCounter, LevelInformation lastLevel, int numberOfArgs, int levelsCounter) {
        this.level = level;
        this.runner = runner;
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.scoreCounter = scoreCounter;
        this.lastLevel = lastLevel;
        this.numberOfArgs = numberOfArgs;
        this.levelsCounter = levelsCounter;
    }

    /**
     * addCollidable function: the function add the given collidable to the environment.
     * @param c : a Collidable-type variable which is an object the Ball can collide with.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * addSprite function: the function add the given sprite to the sprite array list.
     * @param s : a Sprite-type variable which is a sprite (can be a paddle, block, ball, etc.).
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * removeCollidable function: the function remove the given collidable from the environment.
     * @param c : a Collidable-type variable which is an object the Ball can collide with.
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidableList().remove(c);
    }

    /**
     * removeSprite function: the function remove the given sprite from the sprite array list.
     * @param s : a Sprite-type variable which is a sprite (can be a paddle, block, ball, etc.).
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSpriteList().remove(s);
    }
    /**
     * shouldStop function: tells us if we should stop the frame or not.
     * @return boolean-type variable.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * getBallCounter function: return how many balls we have at the moment.
     * @return the number of balls that we play with.
     */
    public int getBallCounter() {
        return this.ballCounter.getValue();
    }

    /**
     * getBlockCounter function: return how many blocks we have at the moment.
     * @return the number of blocks that we play with.
     */
    public int getBlockCounter() {
        return this.blockCounter.getValue();
    }
    /**
     * doOneFrame function: do one frame of the game.
     * @param d is a DrawSurface-type variable.
     */
    public void doOneFrame(DrawSurface d) {
        // game logic
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        // pause the game if "p" or "P" is pressed
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("P")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }

        String win = "WIN";
        String lose = "LOSE";
        // end the game - stop conditions
        // if we have successfully finished the game
        if (this.numberOfArgs == 0) {
            if (this.level.levelName().equals(this.lastLevel.levelName())) {
                if (this.blockCounter.getValue() == 0) {
                    this.scoreCounter.increase(100);
                    this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                            new EndScreen(this.scoreCounter, win)));
                    this.running = false;
                    this.gui.close();
                }
            }
        } else {
            // else the user entered some arguments, which are the levels the user wishes to play in a specified order.
            if (this.level.levelName().equals(this.lastLevel.levelName()) && levelsCounter + 1 == numberOfArgs) {
                if (this.blockCounter.getValue() == 0) {
                    this.scoreCounter.increase(100);
                    this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                            new EndScreen(this.scoreCounter, win)));
                    this.running = false;
                    this.gui.close();
                }
            }
        }

        // in charge that after all blocks in a level are gone, moving to next level
        if (this.blockCounter.getValue() == 0) {
            this.running = false;
        }

        // if all balls fell on the floor, end the game
        if (this.ballCounter.getValue() == 0) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new EndScreen(this.scoreCounter, lose)));
            this.running = false;
        }
    }

    /**
     * initialize function: the function initialize (creates) thr GUI, all the collidables and sprites objects.
     */
    public void initialize() {
        // new Counter creation for each initialize
        this.blockCounter = new Counter(0);
        this.ballCounter = new Counter(0);

        // creates a BlockRemover object that holds a reference to the counter
        BlockRemover blockRemover = new BlockRemover(this, this.blockCounter);
        // creates a BallRemover object that hold a reference to the counter
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        // creates a scoreTrackingListener object, which is a HitListener
        ScoreTrackingListener scoreObject = new ScoreTrackingListener(this.scoreCounter);
        // creates a ScoreIndicator sprite
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.scoreCounter);
        // creates a levelName sprite
        LevelName levelName = new LevelName(this.level);

        // sets ArrayLists of Sprites and Collidable objects.
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();

        // add the sprites we wish to use for our game
        this.sprites.addSprite(this.level.getBackground());
        this.sprites.addSprite(scoreIndicator);
        this.sprites.addSprite(levelName);

        // add bounds to the game
        Rectangle leftBound = new Rectangle(new Point(0, 0), 10, 600);
        Block leftBlock = new Block(leftBound, Color.GRAY);
        Rectangle rightBound = new Rectangle(new Point(790, 0), 10, 600);
        Block rightBlock = new Block(rightBound, Color.GRAY);
        Rectangle upperBound = new Rectangle(new Point(0, 0), 800, 10);
        Block upperBlock = new Block(upperBound, Color.GRAY);
        Rectangle underBound = new Rectangle(new Point(0, 590), 800, 10);
        Block underBlock = new Block(underBound, Color.GRAY);

        // add underBlock to be the "death region" to the ball, when the ball fall on the floor
        underBlock.addHitListener(ballRemover);

        // add all bound blocks to the game (Sprites and Collidables)
        leftBlock.addToGame(this);
        rightBlock.addToGame(this);
        upperBlock.addToGame(this);
        underBlock.addToGame(this);

        // add balls to the game
        int k = 0;
        for (Ball ball : this.level.getBalls()) {
            ball.setVelocity(this.level.initialBallVelocities().get(k));
            ball.setGameEnvironment(environment);
            ball.addToGame(this);
            this.ballCounter.increase(1);
            k++;
        }

        // add paddle to the game
        Rectangle paddleRectangle = new Rectangle(this.level.paddleUpperLeft(), this.level.paddleWidth(),
                this.level.paddleHeight());
        Paddle paddle = new Paddle(paddleRectangle, this.level.paddleColor());
        paddle.setGui(this.gui);
        paddle.addToGame(this);

        // add blocks to the game
        List<Block> blockList = this.level.blocks();
        for (Block block : blockList) {
            block.addToGame(this);
            this.blockCounter.increase(1);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreObject);
        }
    }

    /**
     * run function: the function run the game -- start the animation loop.
     */
    public void run() {
        //this.runner = new AnimationRunner(this.gui);
        //this.initialize();
        // countdown before turn starts
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }
} // end class Game