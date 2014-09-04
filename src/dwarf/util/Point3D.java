package dwarf.util;

/**
 * A 3-dimensional, single-precision, double-point Point.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.util.Point
 * @see java.lang.Object
 * @see java.lang.Cloneable
 */
public class Point3D extends dwarf.util.Point {

    public final static Point3D midPoint(Point3D pointA, Point3D pointB) {
        double x = (pointA.getX() + pointB.getX()) / 2;
        double y = (pointA.getY() + pointB.getY()) / 2;
        double z = (pointA.getZ() + pointB.getZ()) / 2;

        return new Point3D(x, y, z);
    }

    public final static double distance(Point3D pointA, Point3D pointB) {
        return Math.sqrt(Point3D.distanceSq(pointA, pointB));
    }

    public final static double distanceSq(Point3D pointA, Point3D pointB) {
        return java.lang.Math.pow((pointA.getX() - pointB.getX()), 2)
                + java.lang.Math.pow((pointA.getY() - pointB.getY()), 2)
                + java.lang.Math.pow((pointA.getZ() - pointB.getZ()), 2);
    }

    public final static Point3D ZERO = new Point3D(0, 0, 0);
    public final static Point3D UNIT_X = new Point3D(1, 0, 0);
    public final static Point3D UNIT_Y = new Point3D(0, 1, 0);
    public final static Point3D UNIT_Z = new Point3D(0, 0, 1);
    public final static Point3D UNIT_XYZ = new Point3D(1, 1, 1);

    /**
     * A constant holding a Not-a-Number (NaN) value of type
     * <code>Point2D</code>.
     */
    public final static Point3D NaN = new Point3D(Double.NaN, Double.NaN, Double.NaN);
    /**
     * A constant holding the positive infinity of type <code>Point2D</code>.
     */
    public static final Point3D POSITIVE_INFINITY = new Point3D(
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY
    );
    /**
     * A constant holding the negative infinity of type <code>Point2D</code>.
     */
    public static final Point3D NEGATIVE_INFINITY = new Point3D(
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY
    );

    /**
     * Default constructor.
     */
    public Point3D() {
        super(new double[]{0, 0, 0});
    }

    public Point3D(double x, double y, double z) {
        super(new double[]{x, y, z});
    }

    public Point3D(float x, float y, float z) {
        super(new double[]{x, y, z});
    }

    public Point3D(Point3D p) {
        super(new double[]{p.getX(), p.getY(), p.getZ()});
    }

    public void set(double x, double y, double z) {
        super.setComponent(X, x);
        super.setComponent(Y, y);
        super.setComponent(Z, z);
    }

    public void set(float x, float y, double z) {
        super.setComponent(X, x);
        super.setComponent(Y, y);
        super.setComponent(Z, z);
    }

    public void set(Point3D p) {
        super.setComponent(X, p.getX());
        super.setComponent(Y, p.getY());
        super.setComponent(Z, p.getZ());
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

    public double getZ() {
        return super.get(Y);
    }

    public void setZ(double z) {
        super.setComponent(Z, z);
    }

    public void translate(Point3D delta) {
        super.translate(X, delta.getX());
        super.translate(Y, delta.getY());
        super.translate(Z, delta.getZ());
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

    public void translateZ(double deltaZ) {
        super.translate(Z, deltaZ);
    }

    @Override
    public Point3D clone() throws CloneNotSupportedException {
        return new Point3D(this);
    }

    @Override
    public void translate(int index, double delta) {
        if (index <= 2) {
            super.translate(index, delta);
        } else {
            throw new dwarf.DwarfException("illegal argument");
        }
    }

    @Override
    public String toString() {
        return "Point3D[" + super.get(X) + ", " + super.get(Y) + ", " + super.get(Z) + "]";
    }

    @Override
    public void set(double[] components) {
        if (components.length == 3) {
            super.set(components);
        } else {
            throw new dwarf.DwarfException("illegal argument");
        }
    }

    @Override
    public void setComponents(double[] components) {
        if (components.length == 3) {
            super.set(components);
        } else {
            throw new dwarf.DwarfException("illegal argument");
        }
    }

    public Point toPoint() {
        return new Point(super.get(X), super.get(Y), super.get(Z));
    }
}
