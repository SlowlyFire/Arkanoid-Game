package arkanoid.sprites;
import arkanoid.hit_listener.*;
import arkanoid.geometry.*;
import arkanoid.animations.*;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Gal Giladi
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle block;
    private java.awt.Color color;
    /**
     * constructor function: the function creates a new Rectangle-type variable from location and width/height.
     * @param rect : a Rectangle-type variable that represents a block we collide with.
     * @param color : a Color-type variable that represents the color of the block.
     */
    public Block(Rectangle rect, Color color) {
        this.block = rect;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * Rectangle function: the function returns the "collision shape" of the object we collide with.
     * @return : a Rectangle-type variable which we collide with.
     */
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * addHitListener function: the function adds HitListeners to List<'HitListener'>.
     * @param hl  : a HitListener-type variable that represents the listener we notify about the hit.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * removeHitListener function: the function removes HitListeners from List<'HitListener'>.
     * @param hl  : an HitListener-type variable that represents the listener we notify about the hit.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notifyHit function: the function notify all the listeners, about the hit, by using hitEvent method.
     * @param hitter  : a Ball-type variable that represents the ball that hits.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            //addHitListener(hl);
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * hit function: the function notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * @param hitter : a Ball-type variable which represents the ball that hits.
     * @param collisionPoint : a Point-type variable which is the collision Point of the Ball and the Rectangle.
     * @param currentVelocity : a Velocity-type variable which represents the velocity of the Ball at collision time.
     * @return : a Velocity-type variable which is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // saves a pointer to currentVelocity.
        Velocity newVelocity = currentVelocity;
        // we check if the collision Point is on the up Rectangle Line of the Block.
        // then we don't change the horizontal direction, but change the vertical.
        if (this.getCollisionRectangle().getUpRectangle().isPointInLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDX(), (-1) * (currentVelocity.getDY()));
            // we check if the collision Point is on the down Rectangle Line of the Block.
            // then we don't change the horizontal direction, but change the vertical.
        } else if (this.getCollisionRectangle().getDownRectangle().isPointInLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDX(), (-1) * (currentVelocity.getDY()));
            // we check if the collision Point is on the left side Rectangle Line of the Block.
            // then we don't change the vertical direction, but change the horizontal.
        } else if (this.getCollisionRectangle().getLeftSideRectangle().isPointInLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity((-1) * (currentVelocity.getDX()), currentVelocity.getDY());
            // we check if the collision Point is on the right side Rectangle Line of the Block.
            // then we don't change the vertical direction, but change the horizontal.
        } else if (this.getCollisionRectangle().getRightSideRectangle().isPointInLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity((-1) * (currentVelocity.getDX()), currentVelocity.getDY());
        }
        this.notifyHit(hitter);
        return newVelocity;
    }
    /**
     * drawOn function: the function draws this Block on the received DrawSurface variable.
     * @param d : a DrawSurface-type variable that the Block will be drawn on.
     */
    public void drawOn(DrawSurface d) {
        //set the color to draw inside the Block.
        d.setColor(this.getColor());
        d.fillRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
        //set the color to draw on the edge of the Block.
        d.setColor(color.BLACK);
        d.drawRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
    }
    /**
     * getColor function: the function returns the color of the Block.
     * @return : java.awt.Color-type variable of the color of the Block.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * timePassed function: the function notify the block that time has passed.
     */
    public void timePassed() {
    }
    /**
     * addToGame function: the function adds a new Block as a Sprite and a Collidable object to the game.
     * @param game : a Game-type variable that the Block will be drawn on.
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * removeFromGame function: the function removes an existing Block, which is a Sprite and a Collidable object,
     * from the game.
     * @param game : a Game-type variable that the Block will be drawn on.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
} // end Block class