package arkanoid.geometry;
/**
 * @author Gal Giladi
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor function: the function creates a new Velocity-type variable.
     *
     * @param dx : a double-type variable that represents the advance along the x coordinate.
     * @param dy : a double-type variable that represents the advance along the y coordinate.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * fromAngleAndSpeed function: the function creates a new Velocity-type variable according to the received angle and
     * speed and returns the new Velocity.
     *
     * @param angle : a double-type variable that represents the angle of the velocity.
     * @param speed : a double-type variable that represents the speed of the velocity.
     * @return : the new Velocity achieved by the angle and the speed from the parameters.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx, dy, angleInRadian;
        // angle 0 or 360 is a vertical speed.
        if (angle == 0 || angle == 360) {
            dx = 0;
            dy = speed;
            // angle 90  is horizontal speed.
        } else if (angle == 90) {
            dx = speed;
            dy = 0;
            // angle 180 is a -vertical speed.
        } else if (angle == 180) {
            dx = 0;
            dy = -speed;
            // angle 270 is a -horizontal speed.
        } else if (angle == 270) {
            dx = -speed;
            dy = 0;
        } else {
            angleInRadian = Math.toRadians(angle);
            dx = Math.sin(angleInRadian) * speed;
            dy = Math.cos(angleInRadian) * speed;
        }
        return new Velocity(dx, dy);
    }

    /**
     * getDX function: the function returns the dx value of the Velocity.
     * @return : double-type variable of the value dx.
     */
    public double getDX() {
        return this.dx;
    }

    /**
     * getDy function: the function returns the dy value of the Velocity.
     * @return : double-type variable of the value dy.
     */
    public double getDY() {
        return this.dy;
    }

    /**
     * applyToPoint function: the function advances the Point one step according to the Point's Velocity.
     * @param p : the Point-type variable that is going to be moved.
     * @return : a Point-type variable of the Point with the position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + getDX(), p.getY() + getDY());
    }
} // end class Velocity

