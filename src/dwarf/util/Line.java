package dwarf.util;

import java.util.Objects;

import dwarf.DwarfException;

/**
 * A line is length with out breath nor width, It represents the displacement
 * between two points.
 *
 * <p>
 * If a line had any breadth or depth, no matter how small, it would exist in
 * more than one dimension; hence a line has neither breadth nor depth and only
 * exist in one dimension. A Line is neither a solid nor a surface.</p>
 *
 * <p>
 * If the points share a component in any dimension the line created between
 * them can be called straight or right in that dimension, Illustration: If we
 * suspend a weight by a string, the string becomes stretched, and we say it is
 * straight, by which we mean to express that it has assumed a peculiar definite
 * shape. If we mentally abstract from this string all thickness, we obtain the
 * notion of the simplest of all lines, which we call a straight line.</p>
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.util.Point
 * @see java.lang.Object
 * @see java.lang.Cloneable
 */
public class Line extends java.lang.Object implements Cloneable {

    /**
     * The start point of the <code>Line</code>.
     */
    private Point A;
    /**
     * The end point of the <code>Line</code>.
     */
    private Point B;

    /**
     * Default constructor.
     */
    public Line() {
        this(null, null);
    }

    public Line(Point A, Point B) {
        super();

        this.A = A;
        this.B = B;
    }

    public Line(Line l) {
        this(l.getA(), l.getB());
    }

    /**
     * Create a new line based on two points.
     *
     * @param x1 The x coordinate of the start point
     * @param y1 The y coordinate of the start point
     * @param x2 The x coordinate of the end point
     * @param y2 The y coordinate of the end point
     */
    public Line(float x1, float y1, float x2, float y2) {
        this(new Point2D(x1, y1), new Point2D(x2, y2));
    }

    public Point getA() {
        return this.A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return this.B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public Line get() {
        return this;
    }

    public void set(Point A, Point B) {
        this.A = A;
        this.B = B;
    }

    public void set(Line l) {
        this.A = l.getA();
        this.B = l.getB();
    }

    public Point midpoint() {
        double[] result;

        if (A.getNumDimensions() >= B.getNumDimensions()) {
            result = new double[A.getNumDimensions()];
        } else {
            result = new double[B.getNumDimensions()];
        }

        for (int i = 0; i < result.length; i++) {
            double a;
            double b;

            try {
                a = A.getComponent(i);
            } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                a = 0;
            }
            try {
                b = B.getComponent(i);
            } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                b = 0;
            }

            result[i] = (a + b) / 2;
        }

        return new Point(result);
    }

    public double lengthSq() {

        double result = 0;

        int cnt;
        if (A.getNumDimensions() >= B.getNumDimensions()) {
            cnt = A.getNumDimensions();
        } else {
            cnt = B.getNumDimensions();
        }

        for (int i = 0; i < cnt; i++) {
            double a;
            double b;

            try {
                a = A.getComponent(i);
            } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                a = 0;
            }
            try {
                b = B.getComponent(i);
            } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                b = 0;
            }

            result += (a - b) * (a - b);
        }

        return result;
    }

    public double length() {
        return java.lang.Math.sqrt(this.lengthSq());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(A);
        hash = 19 * hash + Objects.hashCode(B);
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @param obj the <code>Object</code> to be tested
     * @see java.lang.Object#equals(java.lang.Object)
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Line other = (Line) obj;

        if (!Objects.equals(this.getA(), other.getA())) {
            return false;
        } else if (!Objects.equals(this.getB(), other.getB())) {
            return false;
        }

        return true;
    }

    /**
     * Returns a string representation of the object.
     * <p>
     * In general, the toString method returns a string that "textually
     * represents" this object. The result should be a concise but informative
     * representation that is easy for a person to read. It is recommended that
     * all subclasses override this method.</p>
     *
     * @return a textually representation of this object
     */
    @Override
    public String toString() {
        return "Line[" + A + ", " + B + "]";
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        return new Line(this);
    }

    public void translate(double delta) {
        A.translate(delta);
        B.translate(delta);
    }

    public void translate(int index, double delta) throws DwarfException {
        try {
            A.translate(index, delta);
            B.translate(index, delta);
        } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
            throw new DwarfException(outOfBoundsException);
        }
    }
}
