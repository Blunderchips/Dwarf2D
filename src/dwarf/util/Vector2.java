package dwarf.util;

/**
 * A 2-dimensional, single-precision, double-point vector.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Object
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 */
public class Vector2 extends java.lang.Object implements java.lang.Cloneable {

    public static final Vector2 ZERO = new Vector2(0, 0);
    public static final Vector2 UNIT_X = new Vector2(1, 0);
    public static final Vector2 UNIT_Y = new Vector2(0, 1);
    public static final Vector2 UNIT_XY = new Vector2(1, 1);
    /**
     * A constant holding a Not-a-Number (NaN) value of type <code>Vector2</code>.
     */
    public final static Vector2 NaN = new Vector2(Double.NaN, Double.NaN);
    /**
     * A constant holding the positive infinity of type <code>Vector2</code>.
     */
    public static final Vector2 POSITIVE_INFINITY = new Vector2(
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY
    );
    /**
     * A constant holding the negative infinity of type <code>Vector2</code>.
     */
    public static final Vector2 NEGATIVE_INFINITY = new Vector2(
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY
    );
    
    /**
     * Rotation in degrees (0-359)
     */
    private double rotation = 0;
    /**
     * the x-component of this <code>Vector2</code>
     */
    private double x;
    /**
     * the y-component of this <code>Vector2</code>
     */
    private double y;

    /**
     * returns the gradient between two Vectors2.
     *
     * @param vectorA the first Vector2
     * @param vectorB the second Vector2
     * @return returns the gradient between two Vectors
     */
    public static double gradient(Vector2 vectorA, Vector2 vectorB) {
        return (vectorA.getY() - vectorB.getY()) / (vectorA.getX() - vectorB.getX());
    }

    /**
     * returns the distance between two Vectors2.
     *
     * @param vectorA the first Vector2
     * @param vectorB the second Vector2
     * @return returns the distance between two Vectors
     */
    public static double distance(Vector2 vectorA, Vector2 vectorB) {
        return Math.sqrt(
                java.lang.Math.pow((vectorA.getX() - vectorB.getX()), 2)
                + java.lang.Math.pow((vectorA.getY() - vectorB.getY()), 2)
        );
    }

    /**
     * returns the square distance between two Vectors2.
     *
     * @param vectorA the first Vector
     * @param vectorB the second Vector
     * @return returns the square distance between two Vectors
     */
    public static double distanceSq(Vector2 vectorA, Vector2 vectorB) {
        return java.lang.Math.pow((vectorA.getX() - vectorB.getX()), 2)
                + java.lang.Math.pow((vectorA.getY() - vectorB.getY()), 2);
    }

    public Vector2() {
        super();

        this.x = 0;
        this.y = 0;
        setRotation(0);
    }

    public Vector2(double x, double y) {
        super();

        this.x = x;
        this.y = y;
        setRotation(0);
    }

    public Vector2(float x, float y) {
        super();

        this.x = x;
        this.y = y;
        setRotation(0);
    }

    public Vector2(double x, double y, double rotation) {
        super();

        this.x = x;
        this.y = y;
        setRotation(rotation);
    }

    public Vector2(float x, float y, double rotation) {
        super();

        this.x = x;
        this.y = y;
        setRotation(rotation);
    }

    public Vector2(Vector2 v) {
        super();

        this.x = v.getX();
        this.y = v.getY();
        setRotation(v.getRotation());
    }

    public Vector2(double[] points) {
        super();

        if (points.length == 2) {
            this.x = points[0];
            this.y = points[1];
            setRotation(0);
        } else {
            throw new IllegalArgumentException("the double array inputed does not have 2 points");
        }
    }

    public Vector2 midpoint(Vector2 vectorA, Vector2 vectorB) {
        return new Vector2(((vectorA.getX() + vectorB.getX()) / 2), ((vectorA.getY() + vectorB.getY()) / 2));
    }

    public double length() {
        return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY());
    }

    public double max() {
        return Math.max(this.getX(), this.getY());
    }

    public double dot(Vector2 input) {
        return this.getX() * input.getX()
                + this.getY() * input.getX();
    }

    public Vector2 normalized() {
        return new Vector2(
                this.getX() / length(),
                this.getY() / length());
    }

    public double cross(Vector2 input) {
        return this.getX() * input.getX()
                - this.getY() * input.getY();
    }

    public void add(Vector2 v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public void add(double v) {
        this.x += v;
        this.y += v;
    }

    public void sub(Vector2 v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public void sub(double v) {
        this.x -= v;
        this.y -= v;
    }

    public void mul(Vector2 v) {
        this.x *= v.getX();
        this.y *= v.getY();
    }

    public void mul(double v) {
        this.x *= v;
        this.y *= v;
    }

    public void div(Vector2 v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public void div(double v) {
        this.x /= v;
        this.y /= v;
    }

    public void mod(Vector2 v) {
        this.x %= v.getX();
        this.y %= v.getY();
    }

    public void mod(double v) {
        this.x %= v;
        this.y %= v;
    }

    public Vector2 abs() {
        return new Vector2(
                Math.abs(this.getX()),
                Math.abs(this.getY()));
    }

    public double absX() {
        return Math.abs(this.getX());
    }

    public double absY() {
        return Math.abs(this.getY());
    }

    @Override
    public String toString() {
        return "Vector2d[" + getX() + ", " + getY() + "]";
    }

    public void set(double x, double y, double rotation) {
        this.x = x;
        this.y = y;
        setRotation(rotation);
    }

    public void set(float x, float y, double rotation) {
        this.x = x;
        this.y = y;
        setRotation(rotation);
    }

    public void set(Vector2 v) {
        this.x = v.getX();
        this.y = v.getY();
        setRotation(v.getRotation());
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 get() {
        return this;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void translate(Vector2 delta) {
        this.x += delta.getX();
        this.y += delta.getY();
    }

    public void change(double delta) {
        this.x += delta;
        this.y += delta;
    }

    public void translateX(double deltaX) {
        this.x += deltaX;
    }

    public void translateY(double deltaY) {
        this.y += deltaY;
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
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(getRotation()) ^ (Double.doubleToLongBits(getRotation()) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(getX()) ^ (Double.doubleToLongBits(getX()) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(getY()) ^ (Double.doubleToLongBits(getY()) >>> 32));
        return hash;
    }

    /**
     * Returns true if the
     * <code>this</code> is equal to the argument and false otherwise.
     * Consequently, if both argument are null, true is returned, false is
     * returned. Otherwise, equality is determined by using the equals method of
     * the first argument.
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
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

        final Vector2 other = (Vector2) obj;

        if (Double.doubleToLongBits(getRotation()) != Double.doubleToLongBits(other.getRotation())) {
            return false;
        } else if (Double.doubleToLongBits(getX()) != Double.doubleToLongBits(other.getX())) {
            return false;
        } else {
            return Double.doubleToLongBits(getY()) == Double.doubleToLongBits(other.getY());
        }
    }

    public void flipX() {
        this.x = -x;
    }

    public void flipY() {
        this.y = -y;
    }

    public void flip() {
        this.x = -x;
        this.y = -y;
    }

    public double[] toArray() {
        return new double[]{
            this.getX(), this.getY()
        };
    }

    public double get(int index) {
        switch (index) {
            case 0:
                return this.getX();
            case 1:
                return this.getY();
        }
        throw new IllegalArgumentException("index must be either 0, 1");
    }

    public double smallestAngleBetween(Vector2 otherVector) {
        double dotProduct = dot(otherVector);
        double angle = Math.acos(dotProduct);
        return angle;
    }

    public double angleBetween(Vector2 otherVector) {
        double angle = Math.atan2(otherVector.getY(), otherVector.getX())
                - Math.atan2(this.getY(), this.getX());
        return angle;
    }

    public double getAngle() {
        return Math.atan2(this.getY(), this.getX());
    }

    public Vector2 limit(double max) {
        double m = length();
        if (m > max) {
            double div = m / max;
            return new Vector2(this.getX() / div, this.getY() / div);
        } else {
            return this;
        }
    }

    /**
     * Shear (a, b): (x, y) â†’ (x+ay, y+bx)
     *
     * @param input the <code>Vector2</code> to be sheered.
     * @return Vector2d(x + input.y, y + input.x)
     */
    public Vector2 sheer(Vector2 input) {
        return new Vector2(this.getX() + input.getY(), this.getY() + input.getX());
    }

    /**
     * Shear (a, b): (x, y) â†’ (x+ay, y+bx)
     *
     * @param a the X component of the <code>Vector2</code>.
     * @param b the Y component of the <code>Vector2</code>.
     * @return Vector2d(x + a, y + b)
     */
    public Vector2 sheer(double a, double b) {
        return this.sheer(new Vector2(a, b));
    }

    /**
     * Return the current rotation of this vector. Rotation is expressed as a
     * degree value, range (0..359). Zero degrees is towards the east
     * (right-hand side of the world), and the angle increases clockwise.
     *
     * @see #setRotation(double)
     *
     * @return The rotation in degrees.
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * Set the rotation of this vector. Rotation is expressed as a degree value,
     * range (0..359). Zero degrees is to the east (right-hand side of the
     * world), and the angle increases clockwise.
     *
     * @param rotation The rotation in degrees.
     */
    @SuppressWarnings({"AssignmentToMethodParameter", "AssignmentReplaceableWithOperatorAssignment"})
    public final void setRotation(double rotation) {
        // First normalize.
        if (rotation >= 360) {
            // Optimize the usual case: rotation has adjusted to a value greater than
            // 360, but is still within the 360 - 720 bound.
            if (rotation < 720) {
                rotation -= 360;
            } else {
                rotation = rotation % 360;
            }
        } else if (rotation < 0) {
            // Likwise, if less than 0, it's likely that the rotation was reduced by
            // a small amount and so will be >= -360.
            if (rotation >= -360) {
                rotation += 360;
            } else {
                rotation = 360 + (rotation % 360);
            }
        }

        if (this.rotation != rotation) {
            this.rotation = rotation;
        }
    }

    /**
     * Turn this vector to face towards a certain location.
     *
     * @param xPos The x-coordinate of the cell to turn towards
     * @param yPos The y-coordinate of the cell to turn towards
     */
    public void turnTowards(double xPos, double yPos) {
        double a = Math.atan2(yPos - this.getY(), xPos - this.getX());
        setRotation(Math.toDegrees(a));
    }

    /**
     * Move this vector the specified distance in the direction it is currently
     * facing.
     *
     * <p>
     * The direction can be set using the {@link #setRotation(double)} method.
     *
     * @param distance The distance to move (in pixels); a negative value will
     * move backwards
     */
    public void move(int distance) {
        double radians = Math.toRadians(getRotation());

        // We round to the nearest integer, to allow moving one unit at an angle
        // to actually move.
        int deltaX = (int) Math.round(Math.cos(radians) * distance);
        int deltaY = (int) Math.round(Math.sin(radians) * distance);
        this.set(this.getX() + deltaX, this.getY() + deltaY, this.getRotation());
    }

    /**
     * Move this vector the specified distance in the direction it is currently
     * facing.
     *
     * <p>
     * The direction can be set using the {@link #setRotation(double)} method.
     *
     * @param distance The distance to move (in pixels); a negative value will
     * move backwards
     */
    public void move(double distance) {
        double deltaX = Math.round(Math.cos(Math.toRadians(getRotation())) * distance);
        double deltaY = Math.round(Math.sin(Math.toRadians(getRotation())) * distance);

        this.set(
                this.getX() + deltaX,
                this.getY() + deltaY);
    }

    /**
     * Turn this vector by the specified amount (in degrees).
     *
     * @param amount the number of degrees to turn; positive values turn
     * clockwise
     *
     * @see #setRotation(double)
     */
    public void rotate(double amount) {
        setRotation((getRotation() + amount));
    }

    public void turnTowards(Vector2 input) {
        this.turnTowards(input.getX(), input.getY());
    }

    /**
     * Creates a new object of the same class as this object.
     *
     * @exception OutOfMemoryError if there is not enough memory.
     * @throws java.lang.CloneNotSupportedException thrown if the Vector2 can
     * not be cloned
     * @see java.lang.Cloneable
     *
     * @return a clone of this instance.
     */
    @Override
    public Vector2 clone() throws CloneNotSupportedException {
        try {
            return new Vector2(this);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
