package arkanoid.sprites;
import arkanoid.geometry.*;
/**
 * @author Gal Giladi
 */
public interface Collidable {
    /**
     * Rectangle function: the function returns the "collision shape" of the object we collide with.
     * @return : a Rectangle-type variable which we collide with.
     */
    Rectangle getCollisionRectangle();

    /**
     * hit function: the function notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * @param hitter : a Ball-type variable which represents the ball that hits.
     * @param collisionPoint : a Point-type variable which is the collision Point of the Ball and the Rectangle.
     * @param currentVelocity : a Velocity-type variable which represents the velocity of the Ball at collision time.
     * @return : a Velocity-type variable which is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}