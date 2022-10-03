package arkanoid.sprites;
import arkanoid.geometry.*;
/**
 * @author Gal Giladi
 */
public class CollisionInfo {
    // members
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * constructor function: the function creates a new CollisionInfo-type variable from collisionPoint (Point variable)
     * and collisionObject (Collidable variable).
     * @param collisionPoint : a Point-type variable which represents the collision point of Collidable object and line.
     * @param collisionObject : a Collidable-type variable which represents the object the line collide with.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }
    /**
     * @collisionPoint function : a Point-type variable which represents the collision point of Collidable object
     * and line.
     * @return : a Point-type variable which represents at which point the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    /**
     * @collisionObject function : a Collidable-type variable which represents the object the line collide with.
     * @return : a Collidable-type variable which represents the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
