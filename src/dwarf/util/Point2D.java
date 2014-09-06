package dwarf.util;

/**
 * A 2-dimensional, single-precision, double-point Point.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.util.Point
 * @see java.lang.Object
 * @see java.lang.Cloneable
 */
public class Point2D extends dwarf.util.Point {

    public final static Point2D midPoint(Point2D pointA, Point2D pointB) {
        double x = (pointA.getX() + pointB.getX()) / 2;
        double y = (pointA.getY() + pointB.getY()) / 2;

        return new Point2D(x, y);
    }

    public final static double gradient(Point2D pointA, Point2D pointB) {
        return (pointA.getY() - pointB.getY()) / (pointA.getX() - pointB.getX());
    }

    public final static double distance(Point2D pointA, Point2D pointB) {
        return Math.sqrt(Point2D.distanceSq(pointA, pointB));
    }

    public final static double distanceSq(Point2D pointA, Point2D pointB) {
        return java.lang.Math.pow((pointA.getX() - pointB.getX()), 2)
                + java.lang.Math.pow((pointA.getY() - pointB.getY()), 2);
    }

    public static final Point2D ZERO = new Point2D(0, 0);
    public static final Point2D UNIT_X = new Point2D(1, 0);
    public static final Point2D UNIT_Y = new Point2D(0, 1);
    public static final Point2D UNIT_XY = new Point2D(1, 1);

    /**
     * A constant holding a Not-a-Number (NaN) value of type
     * <code>Point2D</code>.
     */
    public final static Point2D NaN = new Point2D(Double.NaN, Double.NaN);
    /**
     * A constant holding the positive infinity of type <code>Point2D</code>.
     */
    public static final Point2D POSITIVE_INFINITY = new Point2D(
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY
    );
    /**
     * A constant holding the negative infinity of type <code>Point2D</code>.
     */
    public static final Point2D NEGATIVE_INFINITY = new Point2D(
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY
    );

    /**
     * Default constructor.
     */
    public Point2D() {
        super(new double[]{0, 0});
    }

    public Point2D(double x, double y) {
        super(new double[]{x, y});
    }

    public Point2D(float x, float y) {
        super(new double[]{x, y});
    }

    public Point2D(Point2D p) {
        super(new double[]{p.getX(), p.getY()});
    }
    
    public Point2D(Point p) {
        super(new double[]{p.get(X), p.get(Y)});
    }

    public void set(double x, double y) {
        super.setComponent(X, x);
        super.setComponent(Y, y);
    }

    public void set(float x, float y) {
        super.setComponent(X, x);
        super.setComponent(Y, y);
    }

    public void set(Point2D p) {
        super.setComponent(X, p.getX());
        super.setComponent(Y, p.getY());
    }

    public double getX() {
        return super.get(X);
    }

    public void setX(double x) {
        super.setComponent(X, x);
    }

    public double getY() {
        return super.get(Y);
    }

    public void setY(double y) {
        super.setComponent(Y, y);
    }

    public void translate(Point2D delta) {
        super.translate(X, delta.getX());
        super.translate(Y, delta.getY());
    }

    @Override
    public void translate(double delta) {
        super.translate(delta);
    }

    public void translateX(double deltaX) {
        super.translate(X, deltaX);
    }

    public void translateY(double deltaY) {
        super.translate(Y, deltaY);
    }

    @Override
    public Point2D clone() throws CloneNotSupportedException {
        return new Point2D(this);
    }

    @Override
    public void translate(int index, double delta) {
        if (index <= 1) {
            super.translate(index, delta);
        } else {
            throw new dwarf.DwarfException("illegal argument");
        }
    }

    @Override
    public String toString() {
        return "Point2D[" + super.get(X) + ", " + super.get(Y) + "]";
    }

    @Override
    public void set(double[] components) {
        if (components.length == 2) {
            super.set(components);
        } else {
            throw new dwarf.DwarfException("illegal argument");
        }
    }

    @Override
    public void setComponents(double[] components) {
        if (components.length == 2) {
            super.set(components);
        } else {
            throw new dwarf.DwarfException("illegal argument");
        }
    }

    public Point toPoint() {
        return new Point(super.get(X), super.get(Y));
    }
}
