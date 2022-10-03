package arkanoid.run;
import arkanoid.sprites.*;
import arkanoid.geometry.*;
import java.util.ArrayList;
/**
 * @author Gal Giladi
 */
public class GameEnvironment {
    // members
    private java.util.List<Collidable> collidableArrayList;

    /**
     * constructor function: the function creates a new ArrayList-type variable from Collidable objects.
     */
    public GameEnvironment() {
        this.collidableArrayList = new ArrayList<>();
    }

    /**
     * addCollidable function: the function adds the given collidable to the environment.
     * @param c : a Collidable-type variable which is an object the Ball can collide with.
     */
    public void addCollidable(Collidable c) {
        this.collidableArrayList.add(c);
    }

    /**
     * getClosestCollision function: If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory : a Line-type variable which we assume that an object moving from line.start() to line.end().
     * @return : a CollisionInfo-type variable, which is a collision Point and a Collidable object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // if there are no collidable objects at all.
        if (this.collidableArrayList.isEmpty()) {
            return null;
        }
        // because we assume that an object moving from start of line to end, we take the closest
        // Point of the line to be the farthest point, and then check from end to start.
        Point closestPoint = trajectory.end();
        Collidable object = collidableArrayList.get(0);
        // looking for the closest collidable object which intersect the given line, and its collision Point.
        for (int i = 0; i < collidableArrayList.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(collidableArrayList.get(i).
                    getCollisionRectangle()) != null) {
                Point maybeClosestPoint =
                        trajectory.closestIntersectionToStartOfLine(collidableArrayList.get(i).getCollisionRectangle());
                if (maybeClosestPoint.distance(trajectory.start()) < closestPoint.distance(trajectory.start())) {
                    closestPoint = maybeClosestPoint;
                    object = collidableArrayList.get(i);
                }
            }
        }
        // if there is no collision at all along the given line.
        if (closestPoint.equals(trajectory.end())) {
            return null;
        }

        return new CollisionInfo(closestPoint, object);
    }

    /**
     * getCollidableList function: the function return the ArrayList of Collidables in game.
     * @return : @return : an ArrayList of Collidable objects type variable in the game.
     */
    public java.util.List<Collidable> getCollidableList() {
        return this.collidableArrayList;
    }
} // end class GameEnvironment