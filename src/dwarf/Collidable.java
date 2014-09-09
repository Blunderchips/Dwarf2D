package dwarf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.io.Serializable;
import java.awt.Polygon;

import dwarf.gfx.Circle;
import dwarf.gfx.Colour;
import dwarf.util.Point2D;
import dwarf.engine.core.Window;

import static dwarf.mouse.MOUSE_LEFT;

/**
 * A wrapper around the values needed for a malleable 2D polygon collision
 * class.
 *
 * <p>
 * will detect - but not resolve - collisions. It uses an efficient data search
 * structure to quickly find intersecting <code>Collidable</code> as well as
 * offering general utilities to the <code>Collidable</code>. Cant not have more
 * than 32767 vertices.
 * </p>
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Object
 * @see java.lang.Cloneable
 * @see java.io.Serializable
 */
@SuppressWarnings("serial")
public class Collidable extends java.lang.Object implements Cloneable, Serializable {

    private Point2D position;
    private ArrayList<Point2D> vertices;

    /**
     * Default constructor.
     */
    public Collidable() {
        super();
    }

    public Collidable(Point2D[] vertices) {
        this(new Point2D(0, 0), vertices);
    }

    public Collidable(Point2D position, Point2D[] vertices) {
        super();

        this.position = position;

        this.vertices = new ArrayList<>();
        this.vertices.addAll(Arrays.asList(vertices));
    }

    public Collidable(int xPos, int yPos, Point2D[] vertices) {
        this(new Point2D(xPos, yPos), vertices);
    }

    public Collidable(double[] xPoints, double[] yPoints) {
        this(new Point2D(0, 0), null);
        this.setVertices(xPoints, yPoints);
    }

    public Collidable(int[] xPoints, int[] yPoints) {
        this(new Point2D(0, 0), null);
        this.setVertices(xPoints, yPoints);
    }

    public Collidable(Point2D position, double[] xPoints, double[] yPoints) {
        this(position, null);
        this.setVertices(xPoints, yPoints);
    }

    public Collidable(Polygon p) {
        this(p.xpoints, p.ypoints);
    }

    /**
     * creates a new <code>Collidable</code> from a inputed
     * <code>Collidable</code>.
     *
     * @param Collidable the inputed <code>Collidable</code>.
     */
    public Collidable(Collidable Collidable) {
        this(Collidable.getPosition(), Collidable.getVertices());
    }

    /**
     * @return all vertices as a Vector2 array of the <code>Collidable</code>.
     */
    public Point2D[] getVertices() {
        Point2D[] points = new Point2D[vertices.size()];

        for (short i = 0; i < vertices.size(); i++) {
            points[i] = new Point2D(vertices.get(i));
        }

        return points;
    }

    public void addPoint(Point2D point) {
        this.vertices.add(point);
    }

    public void addPoint(double xPos, double yPos) {
        this.addPoint(new Point2D(xPos, yPos));
    }

    public void addPoints(Point2D[] points) {
        for (Point2D point : points) {
            this.addPoint(point.getX(), point.getY());
        }
    }

    public Collidable get() {
        return this;
    }

    public void set(Collidable coll) {
        this.setVertices(coll.getVertices());
        this.setPosition(coll.getPosition());
    }

    /**
     * creates a new <code>Collidable</code> with the <code>Point</code> arrays
     * given.
     *
     * @param vertices an array of the Vector2 coordinates of the
     * <code>Collidable</code>
     */
    public void setVertices(Point2D[] vertices) {
        double[] xPoints = new double[vertices.length];
        double[] yPoints = new double[vertices.length];

        for (short i = 0; i < vertices.length; i++) {
            xPoints[i] = vertices[i].getX();
            yPoints[i] = vertices[i].getY();
        }

        this.setVertices(xPoints, yPoints);
    }

    public void setVertices(Polygon p) {
        double[] xpoints = new double[p.npoints];
        double[] ypoints = new double[p.npoints];

        for (int i = 0; i < p.npoints; i++) {
            xpoints[i] = p.xpoints[i];
            ypoints[i] = p.ypoints[i];
        }

        this.setVertices(xpoints, ypoints);
    }

    /**
     * creates a new <code>Collidable</code> with the arrays given.This method
     * is called from within the constructor to initialize the
     * <code>Collidable</code>. WARNING: Do NOT modify this code.
     *
     * @throws IllegalArgumentException if the the number of X points does not
     * equal the number of Y points or if they contain less than 3 points.
     *
     * @param xPoints an array of the x coordinates of the polygon.
     * @param yPoints an array of the y coordinates of the polygon.
     */
    public final void setVertices(int[] xPoints, int[] yPoints) {
        double[] xpoints = new double[xPoints.length];
        double[] ypoints = new double[yPoints.length];

        for (int i = 0; i < xPoints.length; i++) {
            xpoints[i] = xPoints[i];
        }
        for (int i = 0; i < yPoints.length; i++) {
            ypoints[i] = yPoints[i];
        }

        this.setVertices(xpoints, ypoints);
    }

    /**
     * The total number of points. The value of <code>vertices.size()</code>
     * represents the number of valid points in this <code>Collidable</code> and
     * might be less than the number of elements in vertices. This value can be
     * NULL.
     *
     * @return the total number of points in the vertices ArrayList.
     */
    public int getNumVertices() {
        return this.vertices.size();
    }

    /**
     * creates a new <code>Collidable</code> with the arrays given.This method
     * is called from within the constructor to initialize the
     * <code>Collidable</code>. WARNING: Do NOT modify this code.
     *
     * @throws IllegalArgumentException if the the number of X points does not
     * equal the number of Y points or if they contain less than 3 points.
     *
     * @param xPoints an array of the x coordinates of the polygon.
     * @param yPoints an array of the y coordinates of the polygon.
     */
    public final void setVertices(double[] xPoints, double[] yPoints) {
//        if (x == null || y == null) {
//            throw new NullPointerException(
//                    "Polygon requires non-null x and y coordinates");
//        } else
        if (xPoints.length < 3) {
            throw new IllegalArgumentException(
                    "Polygon requires at least 3 x values. Found " + xPoints.length);
        } else if (yPoints.length < 3) {
            throw new IllegalArgumentException(
                    "Polygon requires at least 3 y values. Found " + yPoints.length);
        } else if (xPoints.length != yPoints.length) {
            throw new IllegalArgumentException(
                    "Polygon requires the same amount of x and y values. Found "
                    + xPoints.length + "," + yPoints.length);
        } else {
            ArrayList<Point2D> temp = new ArrayList<>(xPoints.length);

            for (int i = 0; i < xPoints.length; i++) {
                temp.add(new Point2D(xPoints[i], yPoints[i]));
            }

            this.vertices = temp;
        }
    }

    /**
     * Determines whether the specified coordinates are inside this
     * <code>Collidable</code>.
     * <p>
     *
     * @param point the <code>Point2D</code> to be tested
     * @return <code>true</code> if this <code>Collidable</code> contains the
     * specified coordinates (x;y) <code>false</code> otherwise.
     */
    public boolean contains(Point2D point) {
        return this.contains(point.getX(), point.getY());
    }

    /**
     * Determines whether the specified coordinates are inside this
     * <code>Collidable</code>.
     *
     * @param xPos the specified X coordinate to be tested
     * @param yPos the specified Y coordinate to be tested
     *
     * @return <code>true</code> if this <code>Collidable</code> contains the
     * specified coordinates <code>(xPos; yPos)</code> <code>false</code>
     * otherwise.
     */
    public boolean contains(double xPos, double yPos) {

        short hits = 0;

        double lastPosX = getVertices()[getNumVertices() - 1].getX() + getPosition().getX() + 1;
        double lastPosY = getVertices()[getNumVertices() - 1].getY() + getPosition().getY() + 1;
        double curPosX, curPosY;

        for (short i = 0; i < getNumVertices(); lastPosX = curPosX, lastPosY = curPosY, i++) {
            curPosX = getVertices()[i].getX() + getPosition().getX() + 1;
            curPosY = getVertices()[i].getY() + getPosition().getY() + 1;

            if (curPosY == lastPosY) {
                continue;
            }

            double leftPosX;
            if (curPosX < lastPosX) {
                if (xPos >= lastPosX) {
                    continue;
                }
                leftPosX = curPosX;
            } else {
                if (xPos >= curPosX) {
                    continue;
                }
                leftPosX = lastPosX;
            }

            double testA, testB;
            if (curPosY < lastPosY) {
                if (yPos < curPosY || yPos >= lastPosY) {
                    continue;
                }
                if (xPos < leftPosX) {
                    hits++;
                    continue;
                }
                testA = xPos - curPosX;
                testB = yPos - curPosY;
            } else {
                if (yPos < lastPosY || yPos >= curPosY) {
                    continue;
                }
                if (xPos < leftPosX) {
                    hits++;
                    continue;
                }
                testA = xPos - lastPosX;
                testB = yPos - lastPosY;
            }

            if (testA < (testB / (lastPosY - curPosY) * (lastPosX - curPosX))) {
                hits++;
            }
        }

        return ((hits & 1) != 0);
    }

    /**
     * Translates the vertices of the <code>Collidable</code> by
     * <code>deltaX</code> along the X axis and by <code>deltaY</code> along the
     * Y axis.
     *
     * @param deltaX the amount to translate along the X axis. (double)
     * @param deltaY the amount to translate along the Y axis. (double)
     */
    public void translate(double deltaX, double deltaY) {
        this.getPosition().translate(new Point2D(deltaX, deltaY));
        for (Point2D point : getVertices()) {
            point.translate(new Point2D(deltaX, deltaY));
        }
    }

    /**
     * Translates the vertices of the <code>Collidable</code> by the inputed
     * Vector2 (<code>delta</code>).
     *
     * @param delta the amount to translate along the axis.
     */
    public void translate(Point2D delta) {
        this.getPosition().translate(new Point2D(delta.getX(), delta.getY()));
        for (Point2D point : getVertices()) {
            point.translate(new Point2D(delta.getX(), delta.getY()));
        }
    }

    /**
     * Translates the vertices of the <code>Collidable</code> by
     * <code>deltaX</code> along the X axis.
     *
     * @param deltaX the amount to translate along the X axis. (double)
     */
    public void translateX(double deltaX) {
        this.getPosition().translateX(deltaX);
        for (Point2D point : getVertices()) {
            point.translateX(deltaX);
        }
    }

    /**
     * Translates the vertices of the <code>Collidable</code> by
     * <code>deltaX</code> along the Y axis.
     *
     * @param deltaY the amount to translate along the Y axis. (double)
     */
    public void translateY(double deltaY) {
        this.getPosition().translateY(deltaY);
        for (Point2D point : getVertices()) {
            point.translateY(deltaY);
        }
    }

    /**
     * Resets this <code>Collidable</code> object to an empty
     * <code>Collidable</code> by setting the vertices ArrayList equal to a new
     * ArrayList of Vector2s.
     *
     * @see java.awt.Polygon#reset()
     */
    @SuppressWarnings("Convert2Diamond")
    public void reset() {
        this.vertices = new ArrayList<Point2D>();
    }

    /**
     * Returns the <code>Collidable</code> as a new Abstract Window Toolkit
     * (AWT) <code>Polygon</code>. The <code>Polygon</code> class encapsulates a
     * description of a closed, two-dimensional region within a coordinate
     * space.
     *
     * @see java.awt.Polygon
     * @return a new Java AWT Polygon created by the points in the vertices
     * ArrayList
     */
    public java.awt.Polygon toPolygon() {
        int[] x = new int[getNumVertices()];
        int[] y = new int[getNumVertices()];

        for (short i = 0; i < getNumVertices(); i++) {
            x[i] = (int) this.getVertices()[i].getX();
            y[i] = (int) this.getVertices()[i].getY();
        }

        return new java.awt.Polygon(x, y, getNumVertices());
    }

    /**
     * Returns Average of the height of the <code>Collidable</code>, in pixels.
     *
     * @return Average of the height, in pixels.
     */
    public float getAverageHeight() {
        float result = 0;

        for (Point2D point : getVertices()) {
            result += point.getX();
        }

        result /= getNumVertices();

        return result;
    }

    /**
     * Returns average of the width of the <code>Collidable</code>, in pixels.
     *
     * @return average of the width, in pixels.
     */
    public float getAverageWidth() {
        float result = 0;

        for (Point2D point : getVertices()) {
            result += point.getX();
        }

        return result / getNumVertices();
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    /**
     * Class Object is the root of the class hierarchy. Every class has Object
     * as a superclass. All objects, including arrays, implement the methods of
     * this class.
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(getVertices());
        hash = 79 * hash + Objects.hashCode(getPosition());
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Collidable coll = (Collidable) obj;

        if (!Objects.equals(this.getVertices(), coll.getVertices())) {
            return false;
        } else {
            return Objects.equals(this.getPosition(), coll.getPosition());
        }
    }

    /**
     * Returns a string representation of the object. In general, the toString
     * method returns a string that "textually represents" this object. The
     * result should be a concise but informative representation that is easy
     * for a person to read. It is recommended that all subclasses override this
     * method.
     *
     * @return a textually representation of this object
     */
    @Override
    public String toString() {
        return "Collidable = {" + "points: " + Arrays.toString(getVertices()) + ", " + "position: " + getPosition() + "}";
    }

    /**
     * Returns the position of the center of the <code>Collidable</code>.
     *
     * @return the position of the center of the <code>Collidable</code>.
     */
    public Point2D getCenter() {
        return new Point2D(
                this.getCenterX().getX(),
                this.getCenterY().getY()
        );
    }

    /**
     * Returns the coordinate of the center of the <code>Collidable</code> in
     * the X axis.
     *
     * @return the coordinate of the center of the <code>Collidable</code> in
     * the X axis
     */
    public Point2D getCenterX() {
        return new Point2D(
                this.getPosition().getX() - this.getAverageWidth(),
                this.getPosition().getY()
        );
    }

    /**
     * Returns the coordinate of the center of the <code>Collidable</code> in
     * the Y axis.
     *
     * @return the coordinate of the center of the <code>Collidable</code> in
     * the Y axis
     */
    public Point2D getCenterY() {
        return new Point2D(
                this.getPosition().getX(),
                this.getPosition().getY() - this.getAverageWidth()
        );
    }

    /**
     * returns true if the <code>Collidable</code> have intersected with this
     * <code>Collidable</code>.
     *
     * @see dwarf.Collidable#contains(dwarf.util.Point2D)
     *
     * @param coll the <code>Collidable</code> to be tested
     * @return true if the <code>Collidable</code> has intersected/collided with
     * this
     */
    public boolean intersects(Collidable coll) {
        if (coll.getNumVertices() != 0) {
            for (short i = 0; i < coll.getNumVertices();) {
                if (this.contains(
                        coll.getVertices()[i].getX() + coll.getPosition().getX(),
                        coll.getVertices()[i].getY() + coll.getPosition().getY()
                )) {
                    return true;
                }

                if (coll instanceof Circle) {
                    i += (35 * coll.getNumVertices()) / 100;
                } else {
                    i++;
                }
            }
        }

        if (this.getNumVertices() != 0) {
            for (short i = 0; i < this.getNumVertices();) {
                if (coll.contains(
                        this.getVertices()[i].getX() + this.getPosition().getX(),
                        this.getVertices()[i].getY() + this.getPosition().getY()
                )) {
                    return true;
                }

                if (this instanceof Circle) {
                    i += (35 * this.getNumVertices()) / 100;
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    public void setPosition(double xPos, double yPos) {
        this.setPosition(new Point2D(xPos, yPos));
    }

    /**
     * tests if the mouse is hovering over the <code>Collidable</code>.
     *
     * @return true if the mouse is hovering over the <code>Collidable</code>
     * otherwise false.
     */
    public boolean isMouseHover() {
        return intersects(new Circle(1, dwarf.mouse.getMousePosition(), 1, Colour.white));
    }

    /**
     * tests if the <code>Collidable</code> is clicked of by a mouse button.
     *
     * @see dwarf.mouse#isMouseClicked(int)
     * @see dwarf.Collidable#isMouseHover()
     *
     * @param button the that needs to be clicked.
     * @return true if the <code>Collidable</code> is clicked on.
     */
    public boolean isClickedOn(int button) {
        return dwarf.mouse.isMouseClicked(button) && isMouseHover();
    }

    /**
     * tests if the <code>Collidable</code> is clicked of by the left mouse
     * button.
     *
     * @see dwarf.Collidable#isClickedOn(int)
     *
     * @return true is the <code>Collidable</code> is clicked on by the left
     * mouse button.
     */
    public boolean isClickedOn() {
        return isClickedOn(MOUSE_LEFT);
    }

    /**
     * tests if the <code>Collidable</code> is clicked of by a mouse button.
     *
     * @see dwarf.mouse#isMouseClicked(String)
     * @see dwarf.Collidable#isMouseHover()
     *
     * @param button the that needs to be clicked.
     * @return true if the <code>Collidable</code> is clicked on.
     */
    public boolean isClickedOn(String button) {
        return dwarf.mouse.isMouseClicked(button) && isMouseHover();
    }

    /**
     * tests if the <code>Collidable</code> in the current view screen.
     *
     * @return true if the <code>Collidable</code> position bigger than or equal
     * to the Camera's position at all four sides.
     */
    public boolean atEdge() {
        if (this.getPosition().getX() > (Window.getWidth() + Window.getActiveCamera().getPosition().getX())) {
            return true;
        }
        if (this.getPosition().getX() < (0 + Window.getActiveCamera().getPosition().getX())) {
            return true;
        }
        if (this.getPosition().getY() > (Window.getHeight() + Window.getActiveCamera().getPosition().getY())) {
            return true;
        }
        if (this.getPosition().getY() < (0 + Window.getActiveCamera().getPosition().getY())) {
            return true;
        }
        return false;
    }

    public void gotoPos(Point2D destination, float speed) {
        if (this.getPosition().getX() > destination.getX()) {
            this.getPosition().translateX(-speed);
        }
        if (this.getPosition().getX() < destination.getX()) {
            this.getPosition().translateX(speed);
        }
        if (this.getPosition().getY() < destination.getY()) {
            this.getPosition().translateY(speed);
        }
        if (this.getPosition().getY() > destination.getY()) {
            this.getPosition().translateY(-speed);
        }
    }

    public void gotoPos(Point2D destination) {
        this.gotoPos(destination, 1);
    }

    public void gotoPos(double xPos, double yPos) {
        this.gotoPos(new Point2D(xPos, yPos), 1);
    }

    public void gotoPos(double xPos, double yPos, float speed) {
        this.gotoPos(new Point2D(xPos, yPos), speed);
    }

    public final Collidable getCollidable() {
        return this;
    }

    @Override
    public Collidable clone() throws CloneNotSupportedException {
        return new Collidable(this);
    }
}
