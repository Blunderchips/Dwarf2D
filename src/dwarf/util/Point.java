package dwarf.util;

import java.util.Arrays;

/**
 * A point is what has a position in polydimensional space but no dimension,
 * magnitude nor direction. A Point is neither a solid, nor a surface, nor a
 * line hence no length, breadth nor depth.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Object
 * @see java.lang.Cloneable
 */
public class Point extends java.lang.Object implements Cloneable {

    public static final byte X = 0x0;
    public static final byte Y = 0x1;
    public static final byte Z = 0x2;

    /**
     * returns the length of the line between the two inputed Points.
     *
     * @see dwarf.util.Line#length()
     *
     * @param A the first Point
     * @param B the second Point
     * @return the distance between two Points
     */
    public static final double distance(Point A, Point B) {
        return new Line(A, B).length();
    }

    /**
     * returns the squared length of the line between the two inputed Points.
     *
     * @see dwarf.util.Line#lengthSq()
     *
     * @param A the first Point
     * @param B the second Point
     * @return the distance between two Points
     */
    public static final double distanceSq(Point A, Point B) {
        return new Line(A, B).lengthSq();
    }

    /**
     * returns the midpoint of the line between the two inputed Points.
     *
     * @see dwarf.util.Line#midpoint()
     *
     * @param A the first Point
     * @param B the second Point
     * @return the midpoint between two Points
     */
    public static final Point midpoint(Point A, Point B) {
        return new Line(A, B).midpoint();
    }

    private double[] components;

    public Point() {
        super();

        this.components = null;
    }

    public Point(double[] components) {
        super();

        this.components = components;
    }

    /**
     * Constructs and initializes a point with the same location as the
     * specified Point object.
     *
     * @param p the specified Point
     */
    public Point(Point p) {
        super();

        this.components = p.getComponents();
    }

    /**
     * A 2-dimensional, single-precision, double-point Point.
     *
     * @param x the X value of the Point
     * @param y the Y value of the Point
     */
    public Point(double x, double y) {
        super();

        this.components = new double[]{x, y};
    }

    /**
     * A 3-dimensional, single-precision, double-point Point.
     *
     * @param x the X value of the Point
     * @param y the Y value of the Point
     * @param z the Z value of the Point
     */
    public Point(double x, double y, double z) {
        super();

        this.components = new double[]{x, y, z};
    }

    public double[] getComponents() {
        return this.components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }

    public Point get() {
        return this;
    }

    public double get(int index) {
        return this.getComponent(index);
    }

    public void set(double[] components) {
        this.components = components;
    }

    public void set(Point p) {
        this.components = p.getComponents();
    }

    public double getComponent(int index) {
        try {
            return this.components[index];
        } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
            return 0;
        }
    }

    public void setComponent(int index, double component) {
        this.components[index] = component;
    }

    public int getNumDimensions() {
        return this.components.length;
    }

    @Override
    public String toString() {

        String result = "";

        for (int i = 0; i < getNumDimensions() - 1; i++) {
            try {
                result += components[i] + ", ";
            } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                break;
            }
        }

        return "Point[" + result + components[getNumDimensions() - 1] + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Arrays.hashCode(getComponents());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Point other = (Point) obj;

        if (!Arrays.equals(this.getComponents(), other.getComponents())) {
            return false;
        }

        return true;
    }

    @Override
    protected Point clone() throws CloneNotSupportedException {
        return new Point(this);
    }

    public void translate(double delta) {
        for (double component : getComponents()) {
            component += delta;
        }
    }

    public void translate(int index, double delta) {
        try {
            this.components[index] += delta;
        } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
            throw outOfBoundsException;
        }
    }
}