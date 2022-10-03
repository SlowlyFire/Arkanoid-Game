package arkanoid.geometry;
import java.util.ArrayList;
/**
 * @author Gal Giladi
 */
public class Line {
    // members
    private Point start;
    private Point end;

    /**
     * constructor function: the function creates a new Line-type variable.
     * @param start : a Point type variable that starts the Line.
     * @param end : a Point type variable that ends the Line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor function: the function creates a new Point-type variable.
     *
     * @param x1 : double type variable - the x value of the start Point.
     * @param y1 : double type variable - the y value of the start Point.
     * @param x2 : double type variable - the x value of the end Point.
     * @param y2 : double type variable - the y value of the end Point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * length function: the function returns the length of the Line.
     * @return : double-type variable of the length of the Line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * middle function: the function returns the middle of the Line.
     * @return : a Point-type variable of the middle of the Line.
     */
    public Point middle() {
        double midX, midY;
        midX = (start.getX() + end.getX()) / 2;
        midY = (start.getY() + end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     * start function: the function returns the start of the Line.
     * @return : a Point-type variable of the start of the Line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * end function: the function returns the end of the Line.
     * @return : a Point-type variable of the end of the Line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * isPointInLine function: the function checks if a given Point p is in the Line using epsilon.
     * @param p : a Point-type variable to be checked if it is in the Line.
     * @return : true if the Point p is in the Line, false otherwise.
     */
    public boolean isPointInLine(Point p) {
        double epsilon = 0.000001d;
        double disAP = this.start.distance(p);
        double disBP = this.end.distance(p);
        double disAB = this.start.distance(this.end);
        return disAP + disBP >= disAB - epsilon && disAP + disBP <= disAB + epsilon;
    }

    /**
     * isIntersecting function: the function checks if the two Lines intersect.
     * @param other : a Line-type variable to be checked if he is intersecting with this Line.
     * @return : true if the Lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * intersectionWith function: the function checks if the two Lines intersect, and if they are it will return the
     * intersection Point, and if they don't intersect it will return null.
     * @param other : a Line-type variable to be checked where and if he is intersecting with this Line.
     * @return : a Point-type variable of the intersection Point if it exists and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double m1 = 0, m2 = 0, n1, n2, interX, interY;
        boolean parallel1 = false, parallel2 = false;
        // checks if this Line is parallel to the Y coordinate.
        if (this.start.getX() == this.end.getX()) {
            parallel1 = true;
        } else {
            m1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        }
        // checks if the other Line is parallel to the Y coordinate.
        if (other.start.getX() == other.end.getX()) {
            parallel2 = true;
        } else {
            m2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
        }
        // if both of the lines are parallel to the Y coordinate and there is exactly 1 intersection.
        if (parallel1 && parallel2 && (this.start.equals(other.end) ^ this.start.equals(other.start)
                ^ this.end.equals(other.start) ^ this.end.equals(other.end))) {
            if (this.start.equals(other.end)) {
                return this.start;
            } else if (this.start.equals(other.start)) {
                return this.start;
            } else if (this.end.equals(other.start)) {
                return this.end;
            } else {
                return this.end;
            }
        // if both of the lines are parallel to the X coordinate and there is exactly 1 intersections.
        } else if (!parallel1 && !parallel2 && m1 == m2 && (this.start.equals(other.end)
                ^ this.start.equals(other.start) ^ this.end.equals(other.start) ^ this.end.equals(other.end))) {
            if (this.start.equals(other.end)) {
                return this.start;
            } else if (this.start.equals(other.start)) {
                return this.start;
            } else if (this.end.equals(other.start)) {
                return this.end;
            } else {
                return this.end;
            }
        // if this Line is parallel to the Y coordinate and the other Line is parallel to the X coordinate.
        } else if (!parallel1 && parallel2 && m1 == m2) {
            double x, x1, x2;
            x = other.start.getX();
            x1 = this.start.getX();
            x2 = this.end.getX();
            if ((x1 >= x && x >= x2) || (x2 >= x && x >= x1)) {
                return new Point(x, this.start.getY());
            }
            return null;
        // if this Line is parallel to the X coordinate and the other Line is parallel to the Y coordinate.
        } else if (parallel1 && !parallel2 && m1 == m2) {
            double x, x1, x2;
            x = this.start.getX();
            x1 = other.start.getX();
            x2 = other.end.getX();
            if ((x1 >= x && x >= x2) || (x2 >= x && x >= x1)) {
                return new Point(x, other.start.getY());
            }
            return null;
            // if both of the Lines have the same incline (but not parallel to either X or Y coordinate).
        } else if (m1 == m2) {
            return null;
        }
        n1 = this.start.getY() - (this.start.getX() * m1);
        n2 = other.start.getY() - (other.start.getX() * m2);
        if (parallel1 && !parallel2) {
            interX = this.start.getX();
            interY = m2 * interX + n2;
        } else if (!parallel1 && parallel2) {
            interX = other.start.getX();
            interY = m1 * interX + m2;
        } else {
            interX = (n2 - n1) / (m1 - m2);
            interY = m1 * interX + n1;
        }
        Point inter = new Point(interX, interY);
        // checks if the intersection Point is in both Lines.
        if (this.isPointInLine(inter) && other.isPointInLine(inter)) {
            return inter;
        } else {
            return null;
        }
    }
    /**
     * equals function: the function checks if a given Line is equal to this Line.
     *
     * @param other : a Point-type variable to be checked if it is in the Line.
     * @return : true if the Point p is in the Line, false otherwise.
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        if (this.end.equals(other.start) && this.start.equals(other.end)) {
            return true;
        }
        return false;
    }
    /**
     * closestIntersectionToStartOfLine function: returns the closest intersection Point to start of this Line with the
     * rectangle.
     * @param rect : a Rectangle-type variable we check intersection Points with this Line.
     * @return : the closest Point to start of Line, which is an intersection of this Line and the rectangle.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> list = new ArrayList<Point>();
        list = rect.intersectionPoints(this);
        if (list.isEmpty()) {
            return null;
        }
        // find the closest intersection Point to start of line by looping.
        Point closest = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (this.start.distance(list.get(i)) < this.start.distance(closest)) {
                closest = list.get(i);
            }
        }
        return closest;
    }
} // end class Line