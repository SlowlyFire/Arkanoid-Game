package arkanoid.sprites;
import arkanoid.animations.*;
import arkanoid.geometry.*;
import arkanoid.run.*;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Gal Giladi
 */
public class Ball implements Sprite {
    // members
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private int width = 200;
    private int height = 200;
    private GameEnvironment gameEnvironment;
    /**
     * constructor function: the function creates a new Ball-type variable.
     * @param center : a Point-type variable that represents the center Point of the new Ball.
     * @param r : an Integer-type variable that represents the radius of the ball.
     * @param color : a java.awt.Color-type variable that represents the color of the ball.
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = null;
    }
    /**
     * constructor function: the function creates a new Ball-type variable.
     * @param x : an Integer-type variable that represents the x value of the center Point of the new Ball.
     * @param y : an Integer-type variable that represents the y value of the center Point of the new Ball.
     * @param r : an Integer-type variable that represents the radius of the ball.
     * @param color : a java.awt.Color-type variable that represents the color of the ball.
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point((double) x, (double) y);
        this.r = r;
        this.color = color;
        this.velocity = null;
    }
    /**
     * getX function: the function returns the x value of the center of the Ball.
     * @return : Integer-type variable of the x value of the center of the Ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * getY function: the function returns the y value of the center of the Ball.
     * @return : Integer-type variable of the y value of the center of the Ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * getSize function: the function returns the radius of the Ball.
     * @return : Integer-type variable of the radius of the Ball.
     */
    public int getSize() {
        return this.r;
    }
    /**
     * getCenter function: the function returns the radius of the Ball.
     * @return : Integer-type variable of the radius of the Ball.
     */
    public int getCenter() {
        return this.r;
    }
    /**
     * getColor function: the function returns the color of the Ball.
     * @return : java.awt.Color-type variable of the color of the Ball.
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * setVelocity function: the function sets the Velocity of the ball to the received Velocity v.
     * @param v  : a Velocity-type variable that represents the Velocity of the Ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * setVelocity function: the function creates a new Velocity-type variable and applies it to the Ball.
     * @param dx  : a double-type variable that represents the dx value of the Velocity.
     * @param dy  : a double-type variable that represents the dy value of the Velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    /**
     * getVelocity function: the function returns the Velocity of the Ball.
     * @return : the Velocity-type variable of the Ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * moveOneStep function: the function moves this Ball one step according to his Velocity.
     */
    public void moveOneStep() {
        // startTrajectory is where the ball start moving.
        Point startTrajectory = this.center;
        // endTrajectory is where the ball end moving according to its velocity, assuming there are no obstacles.
        Point endTrajectory = new Point(this.center.getX() + this.getVelocity().getDX(), this.center.getY()
                + this.getVelocity().getDY());
        // set start Point and end Point of the Line-variable trajectory.
        Line trajectory = new Line(startTrajectory, endTrajectory);
        // info is CollisionInfo variable, means it has information
        // about: Point collisionPoint and Collidable collisionObject
        CollisionInfo info = this.gameEnvironment.getClosestCollision(trajectory);
        // if there is no collision object on the way of trajectory Line, move the ball to the end
        // Point according to its velocity in Line.
        if (info == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            // now we move the ball (its center) slightly before the hit, according to where it hit on the Rectangle
            // object (up / down / left / right).
        } else {
            if (info.collisionObject().getCollisionRectangle().getUpRectangle().isIntersecting(trajectory)) {
                this.center = new Point(this.center.getX(), this.center.getY() - this.r);
            } else if (info.collisionObject().getCollisionRectangle().getDownRectangle().isIntersecting(trajectory)) {
                this.center = new Point(this.center.getX(), this.center.getY() + this.r);
            } else if (info.collisionObject().getCollisionRectangle().getLeftSideRectangle().
                    isIntersecting(trajectory)) {
                this.center = new Point(this.center.getX() - this.r, this.center.getY());
            } else if (info.collisionObject().getCollisionRectangle().getRightSideRectangle().
                    isIntersecting(trajectory)) {
                this.center = new Point(this.center.getX() + this.r, this.center.getY());
            }
            // update the velocity to the new velocity returned by the hit() method.
            this.velocity = info.collisionObject().hit(this, info.collisionPoint(), this.getVelocity());
        }
    }
//    /**
//     * moveOneStepInBound function: the function moves this Ball one step according to its Velocity within the
//     received
//     * bound.
//     * @param start : a Point-type variable of the start of the bound.
//     * @param widthBound : an Integer-type variable of the width of the bound.
//     * @param heightBound : an Integer-type variable of the height of the bound.
//     */
//    public void moveOneStepInBound(Point start, int widthBound, int heightBound) {
//        // checks if before the movement the ball is out of the bound.
//        if (this.center.getX() + this.r >= start.getX() + widthBound) {
//            if (this.velocity.getDX() > 0) {
//                this.velocity = new Velocity(-this.velocity.getDX(), this.velocity.getDY());
//            }
//        }
//        // checks if before the movement the ball is out of the bound.
//        if (this.center.getX() - this.r <= start.getX()) {
//            if (this.velocity.getDX() < 0) {
//                this.velocity = new Velocity(-this.velocity.getDX(), this.velocity.getDY());
//            }
//        }
//        // checks if before the movement the ball is out of the bound.
//        if (this.center.getY() + this.r >= start.getY() + heightBound) {
//            if (this.velocity.getDY() > 0) {
//                this.velocity = new Velocity(this.velocity.getDX(), -this.velocity.getDY());
//            }
//        }
//        // checks if before the movement the ball is out of the bound.
//        if (this.center.getY() - this.r <= start.getY()) {
//            if (this.velocity.getDY() < 0) {
//                this.velocity = new Velocity(this.velocity.getDX(), -this.velocity.getDY());
//            }
//        }
//        // moves the Ball (the center of the ball), 1 step forward according to its velocity.
//        this.center = this.getVelocity().applyToPoint(this.center);
//
//        // checks if after the movement the ball is out of the bound.
//        if (this.center.getX() + this.r >= start.getX() + widthBound || this.center.getX() - this.r <= start.getX()) {
//            this.velocity = new Velocity(-this.velocity.getDX(), this.velocity.getDY());
//        }
//        // checks if after the movement the ball is out of the bound.
//        if (this.center.getY() + this.r >= start.getY() + heightBound || this.center.getY() -
//        this.r <= start.getY()) {
//            this.velocity = new Velocity(this.velocity.getDX(), -this.velocity.getDY());
//        }
//    }
    /**
     * setWidth function: the function sets the width of the frame.
     * @param newWidth : an Integer-type variable of the width of the frame.
     */
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    /**
     * setHeight function: the function sets the height of the frame.
     * @param newHeight : an Integer-type variable of the width of the frame.
     */
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    /**
     * setGameEnvironment function: the function sets the gameEnvironment of the ball.
     * @param gameEnvironment : a GameEnvironment-type variable which is an ArrayList of Collidable objects in the game.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * drawOn function: the function draws this ball on the received DrawSurface variable.
     * @param surface : a DrawSurface-type variable that the Ball will be drawn on.
     */
    public void drawOn(DrawSurface surface) {
        //set the color to draw inside the Ball.
        surface.setColor(this.getColor());
        //draw a circle (the edge and fill).
        surface.fillCircle(getX(), getY(), getSize());
        //set the color to draw on the edge of the Ball.
        surface.setColor(Color.BLACK);
        //draw a circle (the edge only).
        surface.drawCircle(getX(), getY(), getSize());
    }
    /**
     * timePassed function: the function notify the sprite that time has passed, so the ball should move one step.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * addToGame function: the function adds a new Ball as a Sprite to the game.
     * @param game : a Game-type variable that the Ball will be drawn on.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * removeFromGame function: the function removes an existing Ball, which is a Sprite, from the game.
     * @param g : a Game-type variable that the Ball will be drawn on.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
} //end class Ball
