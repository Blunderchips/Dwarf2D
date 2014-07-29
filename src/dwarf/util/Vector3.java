package dwarf.util;

import java.io.Serializable;
import static java.lang.Math.pow;

/**
 * A 3-dimensional, single-precision, double-point vector.
 *
 * @author sid_th3_sl0th
 */
public class Vector3 extends java.lang.Object implements Serializable, Cloneable {

    private static final long serialVersionUID = 1339934L;

    public final static Vector3 ZERO = new Vector3(0, 0, 0);
    public final static Vector3 UNIT_X = new Vector3(1, 0, 0);
    public final static Vector3 UNIT_Y = new Vector3(0, 1, 0);
    public final static Vector3 UNIT_Z = new Vector3(0, 0, 1);
    public final static Vector3 UNIT_XYZ = new Vector3(1, 1, 1);
    public final static Vector3 NaN = new Vector3(Double.NaN, Double.NaN, Double.NaN);
    public final static Vector3 POSITIVE_INFINITY = new Vector3(
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY);
    public final static Vector3 NEGATIVE_INFINITY = new Vector3(
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY);

    /**
     * the x-component of this Vector3
     */
    private double x;
    /**
     * the y-component of this Vector3
     */
    private double y;
    /**
     * the z-component of this Vector3
     */
    private double z;

    /**
     * @param vectorA - the first Vector3
     * @param vectorB - the second Vector3
     * @return returns the distance between two Vectors
     */
    public static double distance(Vector3 vectorA, Vector3 vectorB) {
        return Math.sqrt(pow((vectorA.getX() - vectorB.getX()), 2) + pow((vectorA.getY() - vectorB.getY()), 2) + pow((vectorA.getZ() - vectorB.getZ()), 2));
    }

    /**
     * @param vectorA - the first Vector
     * @param vectorB - the second Vector
     * @return returns the square distance between two Vectors
     */
    public static double distanceSq(Vector3 vectorA, Vector3 vectorB) {
        return pow((vectorA.getX() - vectorB.getX()), 2) + pow((vectorA.getY() - vectorB.getY()), 2) + pow((vectorA.getZ() - vectorB.getZ()), 2);
    }

    /**
     * @param vectorA - the first Vector
     * @param vectorB - the second Vector
     * @return returns the midpoint between two Vectors
     */
    public static Vector3 midpoint(Vector3 vectorA, Vector3 vectorB) {
        return new Vector3(((vectorA.getX() + vectorB.getX()) / 2), ((vectorA.getY() + vectorB.getY()) / 2), ((vectorA.getZ() + vectorB.getZ()) / 2));
    }

    public Vector3(double x, double y, double z) {
        super();
        this.init(x, y, z);
    }

    public Vector3() {
        super();
        this.init(0, 0, 0);
    }

    public Vector3(Vector3 input) {
        super();
        this.init(input.getX(), input.getY(), input.getZ());
    }

    public Vector3(double[] v) {
        super();

        if (v.length != 3) {
            throw new IllegalArgumentException("the double array inputed does not have 3 points");
        } else {
            this.init(v[0], v[1], v[2]);
        }
    }

    private void init(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY() + this.getZ() * this.getZ());
    }

    public double max() {
        return Math.max(this.getX(), Math.max(this.getY(), this.getZ()));
    }

    public double dot(Vector3 input) {
        return (this.getX() * input.getX()) + (this.getY() * input.getY()) + (this.z * input.getZ());
    }

    public Vector3 cross(Vector3 input) {
        double deltaX = (this.getY() * input.getZ()) - (this.getZ() * input.getY());
        double deltaY = (this.getZ() * input.getX()) - (this.getX() * input.getZ());
        double deltaZ = (this.getX() * input.getY()) - (this.getY() * input.getX());

        return new Vector3(deltaX, deltaY, deltaZ);
    }

    public Vector3 normalized() {
        double length = length();

        return new Vector3(this.getX() / length, this.y / length, this.getZ() / length);
    }

    /**
     * Turn this vector by the specified amount (in degrees).
     *
     * @param axis the axis to be rotated about
     * @param theta - the number of degrees to turn; positive values turn
     * clockwise
     * @return returns the resultant Vector2
     * @see #setRotation(double)
     */
    public Vector3 rotate(Vector3 axis, double theta) {
        double sinAngle = Math.sin(-theta);
        double cosAngle = Math.cos(-theta);

        return this.cross(axis.mul(sinAngle)).add(
                (this.mul(cosAngle)).add(
                        axis.mul(this.dot(axis.mul(1 - cosAngle)))));
    }

    public Vector3 lerp(Vector3 dest, double lerpFactor) {
        return dest.sub(this).mul(lerpFactor).add(this);
    }

    public Vector3 add(Vector3 input) {
        return new Vector3(this.getX() + input.getX(), this.getY() + input.getY(), this.getZ() + input.getZ());
    }

    public Vector3 add(double input) {
        return new Vector3(this.getX() + input, this.getY() + input, this.getZ() + input);
    }

    public Vector3 sub(Vector3 input) {
        return new Vector3(this.getX() - input.getX(), this.getY() - input.getY(), this.z - input.getZ());
    }

    public Vector3 sub(double input) {
        return new Vector3(this.getX() - input, this.getY() - input, this.getZ() - input);
    }

    public Vector3 mul(Vector3 input) {
        return new Vector3(this.getX() * input.getX(), this.getY() * input.getY(), this.getZ() * input.getZ());
    }

    public Vector3 mul(double input) {
        return new Vector3(this.getX() * input, this.getY() * input, this.getZ() * input);
    }

    public Vector3 div(Vector3 input) {
        return new Vector3(this.getX() / input.getX(), this.getY() / input.getY(), this.getZ() / input.getZ());
    }

    public Vector3 div(double input) {
        return new Vector3(this.getX() / input, this.getY() / input, this.getZ() / input);
    }

    public Vector3 mod(Vector3 input) {
        return new Vector3(this.getX() % input.getX(), this.getY() % input.getY(), this.getZ() % input.getZ());
    }

    public Vector3 mod(double input) {
        return new Vector3(this.getX() % input, this.getY() % input, this.getZ() % input);
    }

    public Vector3 abs() {
        return new Vector3(Math.abs(this.getX()), Math.abs(this.getY()), Math.abs(this.getZ()));
    }

    @Override
    public String toString() {
        return "Vector3d[" + this.getX() + ", " + this.getY() + ", " + this.z + "]";
    }

    public Vector2 getXY() {
        return new Vector2(this.getX(), this.getY());
    }

    public Vector2 getYZ() {
        return new Vector2(this.getY(), this.getZ());
    }

    public Vector2 getZX() {
        return new Vector2(this.getZ(), this.getX());
    }

    public Vector2 getYX() {
        return new Vector2(this.getY(), this.getX());
    }

    public Vector2 getZY() {
        return new Vector2(this.getZ(), this.getY());
    }

    public Vector2 getXZ() {
        return new Vector2(this.getX(), this.getZ());
    }

    public Vector3 set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        return this;
    }

    public Vector3 set(Vector3 input) {
        set(input.getX(), input.getY(), input.getZ());
        return this;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double xPos) {
        this.x = xPos;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double yPos) {
        this.y = yPos;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double zPos) {
        this.z = zPos;
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
        hash = 43 * hash + (int) (Double.doubleToLongBits(getX()) ^ (Double.doubleToLongBits(getX()) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(getY()) ^ (Double.doubleToLongBits(getY()) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(getZ()) ^ (Double.doubleToLongBits(getZ()) >>> 32));
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
        final Vector3 other = (Vector3) obj;
        if (Double.doubleToLongBits(getX()) != Double.doubleToLongBits(other.getX())) {
            return false;
        } else if (Double.doubleToLongBits(getY()) != Double.doubleToLongBits(other.getY())) {
            return false;
        } else if (Double.doubleToLongBits(getZ()) != Double.doubleToLongBits(other.getZ())) {
            return false;
        }
        return true;
    }

    public void change(Vector3 delta) {
        this.x = delta.getX();
        this.y = delta.getY();
        this.z = delta.getZ();
    }

    public void change(double delta) {
        this.x += delta;
        this.y += delta;
        this.z += delta;
    }

    public void changeX(double deltaX) {
        this.x += deltaX;
    }

    public void changeY(double deltaY) {
        this.y += deltaY;
    }

    public void changeZ(double deltaZ) {
        this.z += deltaZ;
    }

    public void flipX() {
        this.x = -x;
    }

    public void flipY() {
        this.y = -y;
    }

    public void flipZ() {
        this.z = -z;
    }

    public void flip() {
        this.x = -x;
        this.y = -y;
        this.z = -z;
    }

    public double absX() {
        return Math.abs(this.getX());
    }

    public double absY() {
        return Math.abs(this.getY());
    }

    public double absZ() {
        return Math.abs(this.getZ());
    }

    /**
     * Creates a new object of the same class as this object.
     *
     * @return a clone of this instance.
     * @exception OutOfMemoryError if there is not enough memory.
     * @throws java.lang.CloneNotSupportedException
     * @see java.lang.Cloneable
     */
    @Override
    public Vector3 clone() throws CloneNotSupportedException {
        Vector3 m = null;

        try {
            m = (Vector3) super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }

        return m;
    }

    public double[] toArray() {
        return new double[]{x, y, z};
    }

    public double get(int index) {
        switch (index) {
            case 0:
                return getX();
            case 1:
                return getY();
            case 2:
                return getZ();
        }
        throw new IllegalArgumentException("index must be either 0, 1 or 2");
    }

    public double angleBetween(Vector3 otherVector) {
        double dotProduct = dot(otherVector);
        double angle = Math.acos(dotProduct);
        return angle;
    }

}
