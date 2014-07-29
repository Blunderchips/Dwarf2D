package dwarf.engine.core;

import static dwarf.engine.core.Input.MOUSE_LEFT;
import static dwarf.engine.core.Input.getMousePosition;
import dwarf.graphics.Circle;
import dwarf.graphics.Colour;
import dwarf.util.Vector2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * a wrapper around the values needed for a malleable 2D polygon collision class
 *
 * @author sid_th3_sl0th
 */
public class Collidable extends java.lang.Object {

    private ArrayList<Vector2> vertices;
    private Vector2 position;

    public Collidable(Vector2 position) {
        super();
        this.init(position);
    }

    private void init(Vector2 position) {
        this.setPosition(position);
        this.vertices = new ArrayList<Vector2>();
    }

    /**
     * @return all vertices as a Vector2 array
     */
    public Vector2[] getPoints() {
        Vector2[] points = new Vector2[vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            points[i] = new Vector2(vertices.get(i));
        }

        return points;
    }

    public void addPoint(Vector2 point) {
        this.vertices.add(point);
    }

    public void addPoint(double xPos, double yPos) {
        this.addPoint(new Vector2(xPos, yPos));
    }

    public void addPoints(Vector2[] points) {
        for (Vector2 point : points) {
            this.addPoint(point.getX(), point.getY());
        }
    }

    public Collidable get() {
        return this;
    }

    /**
     * creates a new polygon with the arrays given
     *
     * @param points an array of the Vector2d coordinates of the polygon
     */
    public void setPoints(Vector2[] points) {
        double[] x = new double[points.length];
        double[] y = new double[points.length];

        for (int i = 0; i < points.length; i++) {
            x[i] = points[i].getX();
            y[i] = points[i].getY();
        }

        this.setPoints(x, y);
    }

    /**
     * The total number of points. The value of <code>getPoints().size()</code>
     * represents the number of valid points in this <code>Collidable</code> and
     * might be less than the number of elements in {@link #vertices} or
     * {@link #vertices}. This value can be NULL.
     *
     * @return this.getPoints().size()
     */
    public int getNumPoints() {
        return this.getPoints().length;
    }

    /**
     * creates a new polygon with the arrays given
     *
     * @param x an array of the x coordinates of the polygon
     * @param y an array of the y coordinates of the polygon
     */
    public void setPoints(double[] x, double[] y) {
//        if (x == null || y == null) {
//            throw new NullPointerException(
//                    "Polygon requires non-null x and y coordinates");
//        } else
        if (x.length < 3) {
            throw new IllegalArgumentException(
                    "Polygon requires at least 3 x values. Found " + x.length);
        } else if (y.length < 3) {
            throw new IllegalArgumentException(
                    "Polygon requires at least 3 y values. Found " + y.length);
        } else if (x.length != y.length) {
            throw new IllegalArgumentException(
                    "Polygon requires the same amount of x and y values. Found "
                    + x.length + "," + y.length);
        } else {
            ArrayList<Vector2> temp = new ArrayList<>(x.length);

            for (int i = 0; i < x.length; i++) {
                temp.add(new Vector2(x[i], y[i]));
            }

            this.vertices = temp;
        }
    }

    /**
     * Determines whether the specified coordinates are inside this
     * <code>Collidable</code>.
     * <p>
     * @param point - Vector2d
     * @return {@code true} if this {@code Collidable} contains the specified
     * coordinates {@code (x,y)};
     *         {@code false} otherwise.
     */
    public boolean contains(Vector2 point) {
        return this.contains(point.getX(), point.getY());
    }

    /**
     * Determines whether the specified coordinates are inside this
     * <code>Collidable</code>.
     * <p>
     * @param xPos the specified X coordinate to be tested
     * @param yPos the specified Y coordinate to be tested
     * @return {@code true} if this {@code Collidable} contains the specified
     * coordinates {@code (x,y)};
     *         {@code false} otherwise.
     */
    public boolean contains(double xPos, double yPos) {

        int hits = 0;

        double lastPosX = getPoints()[getNumPoints() - 1].getX() + getCenter().getX() + 1;
        double lastPosY = getPoints()[getNumPoints() - 1].getY() + getCenter().getY() + 1;
        double curPosX, curPosY;

        for (int i = 0; i < getNumPoints(); lastPosX = curPosX, lastPosY = curPosY, i++) {
            curPosX = getPoints()[i].getX() + getCenter().getX() + 1;
            curPosY = getPoints()[i].getY() + getCenter().getY() + 1;

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
     * <code>deltaX</code> along the x axis and by <code>deltaY</code> along the
     * y axis.
     *
     * @param deltaX the amount to translate along the X axis
     * @param deltaY the amount to translate along the Y axis
     */
    public void translate(float deltaX, float deltaY) {
        this.getPosition().change(new Vector2(deltaX, deltaY));
        for (Vector2 point : getPoints()) {
            point.change(new Vector2(deltaX, deltaY));
        }
    }

    public void translate(Vector2 delta) {
        this.getPosition().change(new Vector2(delta.getX(), delta.getY()));
        for (Vector2 point : getPoints()) {
            point.change(new Vector2(delta.getX(), delta.getY()));
        }
    }

    public void translateX(float deltaX) {
        this.getPosition().changeX(deltaX);
        for (Vector2 point : getPoints()) {
            point.changeX(deltaX);
        }
    }

    public void translateY(float deltaY) {
        this.getPosition().changeY(deltaY);
        for (Vector2 point : getPoints()) {
            point.changeY(deltaY);
        }
    }

    /**
     * Resets this <code>Collidable</code> object to an empty polygon. The
     * coordinate arrays and the data in them are left untouched but the number
     * of points is reset to zero to mark the old vertex data as invalid and to
     * start accumulating new vertex data at the beginning. All
     * internally-cached data relating to the old vertices are discarded. Note
     * that since the coordinate arrays from before the reset are reused,
     * creating a new empty <code>Collidable</code> might be more memory
     * efficient than resetting the current one if the number of vertices in the
     * new polygon data is significantly smaller than the number of vertices in
     * the data from before the reset.
     */
    public void reset() {
        this.vertices = null;
    }

    public java.awt.Polygon toPolygon() {
        int[] x = new int[getNumPoints()];
        int[] y = new int[getNumPoints()];

        for (int i = 0; i < getNumPoints(); i++) {
            x[i] = (int) this.getPoints()[i].getX();
            y[i] = (int) this.getPoints()[i].getY();
        }

        return new java.awt.Polygon(x, y, getNumPoints());
    }

    public void turnTowards(float xPos, float yPos) {
        this.getPosition().turnTowards(xPos, yPos);
        for (Vector2 point : getPoints()) {
            point.turnTowards(xPos, yPos);
        }
    }

    public void turnTowards(Vector2 point) {
        this.turnTowards((float) point.getX(), (float) point.getY());
    }

    /**
     * Returns Average of the height of the Collidable, in pixels.
     *
     * @return Average of the height, in pixels
     */
    public float getAverageHeight() {
        float result = 0;

        for (Vector2 point : getPoints()) {
            result += point.getX();
        }

        result /= getNumPoints();

        return result;
    }

    /**
     * Returns average of the width of the Collidable, in pixels.
     *
     * @return average of the width, in pixels
     */
    public float getAverageWidth() {
        float result = 0;

        for (Vector2 point : getPoints()) {
            result += point.getX();
        }

        return result / getNumPoints();
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setPosition(Vector2 position) {
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
        hash = 79 * hash + Objects.hashCode(getPoints());
        hash = 79 * hash + Objects.hashCode(getPosition());
        return hash;
    }

    /**
     * Returns true if the arguments are equal to each other and false
     * otherwise. Consequently, if both arguments are null, true is returned and
     * if exactly one argument is null, false is returned. Otherwise, equality
     * is determined by using the equals method of the first argument.
     *
     * @return true if the arguments are equal to each other and false otherwise
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else if (!super.equals(obj)) {
            return false;
        }
        final Collidable coll = (Collidable) obj;
        if (!Objects.equals(this.getPoints(), coll.getPoints())) {
            return false;
        } else {
            return Objects.equals(this.getPosition(), coll.getPosition());
        }
    }

    @Override
    public String toString() {
        return "Collidable = {" + "\n"
                + "\t" + "points: " + Arrays.toString(getPoints()) + "\n"
                + "\t" + "position: " + getPosition() + "\n"
                + "\t" + "super: " + super.toString() + "\n"
                + "}";
    }

    /**
     * Returns the position of the center of the rectangle.
     *
     * @return the position of the center of the rectangle
     */
    public Vector2 getCenter() {
        return new Vector2(
                this.getCenterX().getX(),
                this.getCenterY().getY(),
                this.getPosition().getRotation()
        );
    }

    /**
     * Returns the coordinate of the center of the rectangle in the horizontal
     * axis.
     *
     * @return the coordinate of the center of the rectangle in the horizontal
     * axis
     */
    public Vector2 getCenterX() {
        return new Vector2(
                this.getPosition().getX() - this.getAverageWidth(),
                this.getPosition().getY(),
                this.getPosition().getRotation()
        );
    }

    /**
     * Returns the coordinate of the center of the rectangle in the vertical
     * axis.
     *
     * @return the coordinate of the center of the rectangle in the vertical
     * axis
     */
    public Vector2 getCenterY() {
        return new Vector2(
                this.getPosition().getX(),
                this.getPosition().getY() - this.getAverageWidth(),
                this.getPosition().getRotation()
        );
    }

    /**
     * returns true if the Collidable have intersected with this Collidable
     *
     * @param coll - the Collidable to be tested
     * @return true if the Collidable has intersected/collided with this
     */
    public boolean intersects(Collidable coll) {
        for (int i = 0; i < coll.getNumPoints();) {
            if (this.contains(coll.getPoints()[i].add(coll.getCenter()))) {
                return true;
            }

            if (coll.getNumPoints() > 3) {
                i += (35 * coll.getNumPoints()) / 100;
            } else {
                i++;
            }
        }

        for (int i = 0; i < this.getNumPoints();) {
            if (coll.contains(this.getPoints()[i].add(this.getCenter()))) {
                return true;
            }

            if (this.getNumPoints() > 3) {
                i += (35 * this.getNumPoints()) / 100;
            } else {
                i++;
            }
        }
        return false;
    }

    public void setPosition(double xPos, double yPos) {
        this.setPosition(new Vector2(xPos, yPos));
    }

    /**
     * tests if the mouse is hovering over the Collidable
     *
     * @return true if the mouse is hovering over the Collidable otherwise false
     */
    public boolean isMouseHover() {
        return intersects(new Circle(1, getMousePosition(), "stroke", Colour.white));
    }

    /**
     * tests if the Collidable is clicked of by a mouse button
     *
     * @param button the that needs to be clicked
     * @return true if the Collidable is clicked on
     */
    public boolean isClickedOn(int button) {
        if (Input.isMouseClicked(button)) {
            return isMouseHover();
        } else {
            return false;
        }
    }

    /**
     * tests if the Collidable is clicked of by the left mouse button
     *
     * @return true is the Collidable is clicked on by the left mouse button
     */
    public boolean isClickedOn() {
        return isClickedOn(MOUSE_LEFT);
    }

    /**
     * tests if the Collidable in the current view screen
     *
     * @return true if the Collidable position bigger than or equal to the
     * camera's position at all four sides
     */
    public boolean atEdge() {
        if (this.getPosition().getX() > (Window.getWidth() + camera.getPosition().getX())) {
            return true;
        } else if (this.getPosition().getX() < (0 + camera.getPosition().getX())) {
            return true;
        } else if (this.getPosition().getY() > (Window.getHeight() + camera.getPosition().getY())) {
            return true;
        } else if (this.getPosition().getY() < (0 + camera.getPosition().getY())) {
            return true;
        } else {
            return false;
        }
    }
}
