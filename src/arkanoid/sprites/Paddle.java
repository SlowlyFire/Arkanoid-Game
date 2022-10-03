package arkanoid.sprites;
import arkanoid.geometry.*;
import arkanoid.animations.*;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.GUI;
import java.awt.Color;
/**
 * @author Gal Giladi
 */
public class Paddle implements Sprite, Collidable {
    // members
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddle;
    private GUI gui;
    private java.awt.Color color;

    /**
     * constructor function: the function creates a new Paddle-type variable from a given Rectangle.
     * @param rect : a Rectangle-type variable that represents the rectangle we want to be the paddle.
     * @param color : a Color-type variable that represents the color of the Paddle.
     */
    public Paddle(Rectangle rect, Color color) {
        this.paddle = rect;
        this.color = color;
    }
    /**
     * moveLeft function: the function changes the paddle position, so it seems its moving left.
     * the function also saves the paddle inside the bounds (not generic).
     */
    public void moveLeft() {
        // saves pointers to Paddle and to its members
        double height = this.paddle.getHeight();
        double width = this.paddle.getWidth();
        Point newUpperLeft = this.paddle.getUpperLeft();
        // because Paddle moves left, we subtract 5 pixels from its x value.
        newUpperLeft.setX(newUpperLeft.getX() - 5);
        // we don't want the paddle to get out of bounds.
        if (newUpperLeft.getX() < 10) {
            newUpperLeft.setX(newUpperLeft.getX() + 5);
        }
        // we create new Paddle, width and height stay the same, except to its position.
        Rectangle newPaddle = new Rectangle(newUpperLeft, width, height);
        this.paddle = newPaddle;
    }

    /**
     * moveRight function: the function changes the paddle position, so it seems its moving right.
     * the function also saves the paddle inside the bounds (not generic).
     */
    public void moveRight() {
        // saves pointers to Paddle and to its members
        double height = this.paddle.getHeight();
        double width = this.paddle.getWidth();
        Point newUpperLeft = this.paddle.getUpperLeft();
        Point upperRight = this.paddle.getUpperRight();
        // because Paddle moves right, we add 5 pixels to its x value.
        newUpperLeft.setX(newUpperLeft.getX() + 5);
        // we don't want the paddle to get out of bounds.
        if (upperRight.getX() > 785) {
            newUpperLeft.setX(newUpperLeft.getX() - 5);
        }
        // we create new Paddle, width and height stay the same, except to its position.
        Rectangle newPaddle = new Rectangle(newUpperLeft, width, height);
        this.paddle = newPaddle;
    }

    /**
     * timePassed function: the function notify the paddle that time has passed.
     */
    public void timePassed() {
        // get a keyboard sensor using gui.
        this.keyboard = gui.getKeyboardSensor();
        // if our member in a loop animation recognize left arrow or right arrow is pressed, it moves the paddle.
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            System.out.println("the 'left arrow' key is pressed");
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            System.out.println("the 'right arrow' key is pressed");
            this.moveRight();
        }
    }
    /**
     * drawOn function: the function draws this Paddle on the received DrawSurface variable.
     * @param d : a DrawSurface-type variable that the Paddle will be drawn on.
     */
    public void drawOn(DrawSurface d) {
        // set the color to draw inside the Paddle.
        d.setColor(this.getColor());
        d.fillRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
        // set the color to draw on the edge of the Paddle.
        d.setColor(this.color.BLACK);
        d.drawRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }

    /**
     * getCollisionRectangle function: the function returns the "collision shape" of the object we collide with.
     * @return : a Rectangle-type variable which we collide with.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * hit function: the function notify the object that we collided with at collisionPoint with
     * a given velocity, in a specific logic of hit paddle which we separate the paddle to 5 parts and each
     * one of the parts gets a unique angle of hit.
     * @param hitter : a Ball-type variable which represents the ball that hits.
     * @param collisionPoint : a Point-type variable which is the collision Point of the Ball and the Paddle.
     * @param currentVelocity : a Velocity-type variable which represents the velocity of the Ball at collision time.
     * @return : a Velocity-type variable which is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double paddlePartWidth = this.paddle.getWidth() / 5;
        // get each upper lines from the parts of the real Paddle.
        //Line upLinePaddle = this.paddle.getUpRectangle();
        Line seg1 = new Line(this.paddle.getUpperLeft(),
                new Point(this.paddle.getUpperLeft().getX() + paddlePartWidth, this.paddle.getUpperLeft().getY()));
        Line seg2 = new Line(seg1.end(), new
                Point(this.paddle.getUpperLeft().getX() + 2 * paddlePartWidth, this.paddle.getUpperLeft().getY()));
        Line seg3 = new Line(seg2.end(), new
                Point(this.paddle.getUpperLeft().getX() + 3 * paddlePartWidth, this.paddle.getUpperLeft().getY()));
        Line seg4 = new Line(seg3.end(), new
                Point(this.paddle.getUpperLeft().getX() + 4 * paddlePartWidth, this.paddle.getUpperLeft().getY()));
        Line seg5 = new Line(seg4.end(), new
                Point(this.paddle.getUpperLeft().getX() + 5 * paddlePartWidth, this.paddle.getUpperLeft().getY()));

        // if the ball hits seg1 (the most left side) then set its velocity in a given logic, and go on.
        if (seg1.isPointInLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(240, 5);
        } else if (seg2.isPointInLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(210, 5);
        } else if (seg3.isPointInLine(collisionPoint)) {
            return new Velocity(currentVelocity.getDX(), (-1) * currentVelocity.getDY());
        } else if (seg4.isPointInLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(150, 5);
        } else if (seg5.isPointInLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(120, 5);
        }
        return new Velocity(currentVelocity.getDX(), (-1) * currentVelocity.getDY());
    }


//    /**
//     * hit function: the function notify the object that we collided with it at collisionPoint with
//     * a given velocity, but this function is a normal hit logic of the paddle.
//     * @param collisionPoint : a Point-type variable which is the collision Point of the Ball and the Paddle.
//     * @param currentVelocity : a Velocity-type variable which represents the velocity of the Ball at collision time.
//     * @return : a Velocity-type variable which is the new velocity expected after the hit (based on
//     * the force the object inflicted on us).
//     */
//    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
//        Velocity newVelocity = currentVelocity;
//        Line up = this.paddle.getUpRectangle();
//        double length = up.length();
//        //Line seg1 = new Line(this.paddle.getUpperLeft(), this.paddle.getUpperRight());
//        // if the ball hits the paddle - set its velocity.
//        if (up.isPointInLine(collisionPoint)) {
//            newVelocity = new Velocity(currentVelocity.getDX(), (-1) * currentVelocity.getDY());
//        }
//        return newVelocity;
//    }

    /**
     * setGui function: the function sets the gui for the Paddle.
     * @param gui : a GUI-type variable which represents the gui we have at the moment for the Paddle.
     */
    public void setGui(GUI gui) {
        this.gui = gui;
    }
    /**
     * getColor function: the function returns the color of the Paddle.
     * @return : java.awt.Color-type variable of the color of the Paddle.
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * addToGame function: the function adds a new Paddle as a Sprite and a Collidable object to the game.
     * @param g : a Game-type variable that the Paddle will be drawn on.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
} // end  class Paddle