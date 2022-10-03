package arkanoid.geometry;
/**
 * @author Gal Giladi
 */
public class Point {
    // members
    private double x;
    private double y;
    /**
     * constructor function: the function creates a new Point-type variable.
     * @param x : the x value of the new Point.
     * @param y : the y value of the new Point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * distance function: measures and returns the distance between this Point to the other Point.
     * @param other : the other Point to measure the distance to.
     * @return : the distance between the Points.
     */
    public double distance(Point other) {
        double dx, dy;
        dx = this.x - other.x;
        dy = this.y - other.y;
        return Math.sqrt((dx * dx) + (dy * dy));
    }
    /**
     * equals function: the function returns true if the two points are the same and false otherwise.
     * @param other : the point to check if it is equal.
     * @return : true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }
    /**
     * getX function: the function returns the value x of the Point.
     * @return : the x value (in double) of the Point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * getY function: the function returns the value y of the Point.
     * @return : the y value (in double) of the Point.
     */
    public double getY() {
        return this.y;
    }
    /**
     * setX function: the function sets the value x of the Point.
     * @param x : the value x of the Point.
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * getY function: the function sets the value y of the Point.
     * @param y : the value y of the Point.
     */
    public void setY(double y) {
        this.y = y;
    }
} // end class Point
