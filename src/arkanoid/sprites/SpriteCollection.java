package arkanoid.sprites;
import biuoop.DrawSurface;
import java.util.ArrayList;
/**
 * @author Gal Giladi
 */
public class SpriteCollection {
    //members
    private java.util.List<Sprite> spriteList;
    /**
     constructor function: the function creates a new ArrayList-type variable from sprite objects.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }
    /**
     * addSprite function: the function add the given sprite to the sprite array list.
     * @param s : a Sprite-type variable which is a sprite (can be a paddle, block, ball, etc.).
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }
    /**
     * notifyAllTimePassed function: the function notify all the sprites in our array list that time has passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < spriteList.size(); i++) {
            spriteList.get(i).timePassed();
        }
    }

    /**
     * drawAllOn function: the function draws all the sprites from the array list on the received DrawSurface variable.
     * @param d : a DrawSurface-type variable that the sprites will be drawn on.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < spriteList.size(); i++) {
            spriteList.get(i).drawOn(d);
        }
    }
    /**
     * getSpriteList function: the function returns the ArrayList of the sprites.
     * @return : an ArrayList of Sprite objects type variable in the game.
     */
    public java.util.List<Sprite> getSpriteList() {
        return this.spriteList;
    }
} // end SpriteCollection class
