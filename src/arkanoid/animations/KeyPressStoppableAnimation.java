package arkanoid.animations;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author Gal Giladi
 */
public class KeyPressStoppableAnimation implements Animation {
    // members
    private boolean stop;
    private KeyboardSensor ks;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;

    /**
     * constructor: creates a KeyPressStoppableAnimation object.
     * @param sensor is a KeyboardSensor-type variable.
     * @param key is a String-type variable.
     * @param animation is an Animation-type variable.
     * also initialize stop to false, and isAlreadyPressed to true.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.ks = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
    }
    /**
     * doOneFrame function: do one frame of the game.
     * @param d is a DrawSurface-type variable.
     */
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.ks.isPressed(this.key) && !isAlreadyPressed) {
            this.stop = true;
        } else {
            this.isAlreadyPressed = false;
        }
    }
    /**
     * shouldStop function: tells us if we should stop the frame or not.
     * @return boolean-type variable.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}