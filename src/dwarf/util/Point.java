package dwarf.util;

/**
 * A 2D double point class, which looks remarkably like an LWJGL one...
 *
 * @author MAtthew
 */
public class Point extends java.lang.Object implements Cloneable {

    public static Point midPoint(Point pointA, Point pointB) {
        double x = (pointA.getX() + pointB.getX()) / 2;
        double y = (pointA.getY() + pointB.getY()) / 2;

        return new Point(x, y);
    }

    public static double gradient(Point pointA, Point pointB) {
        return (pointA.getY() - pointB.getY()) / (pointA.getX() - pointB.getX());
    }

    public static double distance(Point pointA, Point pointB) {
        return Math.sqrt(
                java.lang.Math.pow((pointA.getX() - pointB.getX()), 2)
                + java.lang.Math.pow((pointA.getY() - pointB.getY()), 2)
        );
    }

    public static double distanceSq(Point pointA, Point pointB) {
        return java.lang.Math.pow((pointA.getX() - pointB.getX()), 2)
                + java.lang.Math.pow((pointA.getY() - pointB.getY()), 2);
    }

    public static final Point ZERO = new Point(0, 0);
    public static final Point UNIT_X = new Point(1, 0);
    public static final Point UNIT_Y = new Point(0, 1);
    public static final Point UNIT_XY = new Point(1, 1);

    /**
     * A constant holding a Not-a-Number (NaN) value of type
     * <code>Vector2</code>.
     */
    public final static Point NaN = new Point(Double.NaN, Double.NaN);
    /**
     * A constant holding the positive infinity of type <code>Vector2</code>.
     */
    public static final Point POSITIVE_INFINITY = new Point(
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY
    );
    /**
     * A constant holding the negative infinity of type <code>Vector2</code>.
     */
    public static final Point NEGATIVE_INFINITY = new Point(
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY
    );

    /**
     * the x-component of this <code>Point</code>
     */
    private double x;
    /**
     * the y-component of this <code>Point</code>
     */
    private double y;

    /**
     * Default constructor.
     */
    public Point() {
        super();

        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        super();

        this.x = x;
        this.y = y;
    }

    public Point(float x, float y) {
        super();

        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        super();

        this.x = p.getX();
        this.y = p.getY();
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void translate(Point delta) {
        this.x += delta.getX();
        this.y += delta.getY();
    }

    public void translate(double delta) {
        this.x += delta;
        this.y += delta;
    }

    public void translateX(double deltaX) {
        this.x += deltaX;
    }

    public void translateY(double deltaY) {
        this.y += deltaY;
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        return new Point(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (Double.doubleToLongBits(getX()) ^ (Double.doubleToLongBits(getX()) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(getY()) ^ (Double.doubleToLongBits(getY()) >>> 32));
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

        if (Double.doubleToLongBits(this.getX()) != Double.doubleToLongBits(other.getX())) {
            return false;
        } else if (Double.doubleToLongBits(this.getY()) != Double.doubleToLongBits(other.getY())) {
            return false;
        }

        return true;
    }

}
