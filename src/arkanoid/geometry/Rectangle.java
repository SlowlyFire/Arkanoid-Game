package arkanoid.geometry;
import java.util.ArrayList;
/**
 * @author Gal Giladi
 */
public class Rectangle {
    // members
    private Point upperLeft;
    private double width;
    private double height;
    /**
     * constructor function: the function creates a new Rectangle-type variable from location and width/height.
     * @param upperLeft : a Point-type variable that represents the upper left Point of the new Rectangle.
     * @param width : a double-type variable that represents the width of the Rectangle.
     * @param height : a double-type variable that represents the height of the Rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * intersectionPoints function: the function returns a (possibly empty) List
     * of intersection points of the Rectangle, with a specified Line.
     * @param  line : a Line type variable that is checked to have intersection Points with the Rectangle.
     * @return : List of Points-type variables.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        // creates an array list of Points.
        java.util.List<Point> list = new ArrayList<>();
        // to find all the intersections of a Line and this Rectangle, we separate the Rectangle to 4 Lines
        // then we use the intersection methods of class Line.
        Line up = this.getUpRectangle();
        Line left = this.getLeftSideRectangle();
        Line right = this.getRightSideRectangle();
        Line under = this.getDownRectangle();
        // checks if there are any intersections Points of line and all the Lines of the Rectangle.
        // if so - add them to the Points Array-list.
        if (up.isIntersecting(line)) {
            list.add(up.intersectionWith(line));
        }
        if (left.isIntersecting(line)) {
            list.add(left.intersectionWith(line));
        }
        if (under.isIntersecting(line)) {
            list.add(under.intersectionWith(line));
        }
        if (right.isIntersecting(line)) {
            list.add(right.intersectionWith(line));
        }
        return list;
    }
    /**
     * getWidth function: the function returns the width (double value) of the Rectangle.
     * @return : double-type variable of the value width.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * getHeight function: the function returns the height (double value) of the Rectangle.
     * @return : double-type variable of the value height.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * getUpperLeft function: the function returns the upper left Point of the Rectangle.
     * @return : Point-type variable which is the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * getUpperRight function: the function returns the upper right Point of the Rectangle.
     * @return : Point-type variable which is the upper right point of the rectangle.
     */
    public Point getUpperRight() {
        return new Point(this.getUpperLeft().getX() + this.getWidth(), this.getUpperLeft().getY());
    }
    /**
     * getUnderLeft function: the function returns the under left Point of the Rectangle.
     * @return : Point-type variable which is the under left point of the rectangle.
     */
    public Point getUnderLeft() {
        return new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.getHeight());
    }
    /**
     * getUnderRight function: the function returns the under right Point of the Rectangle.
     * @return : Point-type variable which is the under right point of the rectangle.
     */
    public Point getUnderRight() {
        return new Point(this.getUpperRight().getX(), this.getUnderLeft().getY());
    }
    /**
     * getUpRectangle function: the function returns the upper Line of the Rectangle.
     * @return : Line-type variable which is the upper line of the rectangle.
     */
    public Line getUpRectangle() {
        return new Line(this.getUpperLeft(), this.getUpperRight());
    }
    /**
     * getLeftSideRectangle function: the function returns the left side Line of the Rectangle.
     * @return : Line-type variable which is the left side line of the rectangle.
     */
    public Line getLeftSideRectangle() {
        return new Line(this.getUpperLeft(), this.getUnderLeft());
    }
    /**
     * getDownRectangle function: the function returns the under Line of the Rectangle.
     * @return : Line-type variable which is the under line of the rectangle.
     */
    public Line getDownRectangle() {
        return new Line(this.getUnderLeft(), this.getUnderRight());
    }
    /**
     * getRightSideRectangle function: the function returns the right side Line of the Rectangle.
     * @return : Line-type variable which is the right side line of the rectangle.
     */
    public Line getRightSideRectangle() {
        return new Line(this.getUpperRight(), this.getUnderRight());
    }

//    public static void main(String[]args) {
//        GUI gui = new GUI("title", 800, 600);
//        DrawSurface d = gui.getDrawSurface();
//        d.drawRectangle(100, 70, 170, 120);
//        d.drawLine(0, 0, 400, 400);
//        d.drawLine(0, 0, 200, 200);
//
//        Point start = new Point(100,70);
//        Rectangle r = new Rectangle(start, 170, 120);
//        Line l1 = new Line(0,0,400,400);
//        Line l2 = new Line(0,0,200,200);
//        List<Point> list2 = r.intersectionPoints(l2);
//        List<Point> list1 = r.intersectionPoints(l1);
//        for (Point p : list2) {
//            d.drawCircle((int) p.getX(), (int) p.getY(), 3);
//            d.fillCircle((int) p.getX(), (int) p.getY(), 3);
//        }
//        for (Point p : list1) {
//            d.drawCircle((int) p.getX(), (int) p.getY(), 3);
//            d.fillCircle((int) p.getX(), (int) p.getY(), 3);
//        }
//        if (list1.isEmpty() && list2.isEmpty()) {
//            System.out.println("empty");
//        }
//        else {
//            for (Point p : list1) {
//                System.out.println("x=" + p.getX() + "y=" + p.getY());
//            }
//            for (Point p : list2) {
//                System.out.println("x=" + p.getX() + "y=" + p.getY());
//            }
//        }
//        gui.show(d);
//    } //end class main

} // end class Rectangle