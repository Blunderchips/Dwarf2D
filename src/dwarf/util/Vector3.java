package dwarf.util;

import dwarf.DwarfException;

/**
 * A 3-dimensional, single-precision, double-point vector.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Object
 * @see java.lang.Cloneable
 */
public class Vector3 extends java.lang.Object implements Cloneable {

    public final static Vector3 ZERO = new Vector3(0, 0, 0);
    public final static Vector3 UNIT_X = new Vector3(1, 0, 0);
    public final static Vector3 UNIT_Y = new Vector3(0, 1, 0);
    public final static Vector3 UNIT_Z = new Vector3(0, 0, 1);
    public final static Vector3 UNIT_XYZ = new Vector3(1, 1, 1);

    /**
     * A constant holding a Not-a-Number (NaN) value of type
     * <code>Vector3</code>.
     */
    public final static Vector3 NaN = new Vector3(Double.NaN, Double.NaN, Double.NaN);
    /**
     * A constant holding the positive infinity of type <code>Vector3</code>.
     */
    public final static Vector3 POSITIVE_INFINITY = new Vector3(
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY,
            Double.POSITIVE_INFINITY
    );
    /**
     * A constant holding the negative infinity of type <code>Vector3</code>.
     */
    public final static Vector3 NEGATIVE_INFINITY = new Vector3(
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY,
            Double.NEGATIVE_INFINITY
    );

    /**
     * the x-component of this <code>Vector3</code>
     */
    private double x;
    /**
     * the y-component of this <code>Vector3</code>
     */
    private double y;
    /**
     * the z-component of this <code>Vector3</code>
     */
    private double z;

    /**
     * Default constructor.
     */
    public Vector3() {
        this(0, 0, 0);
    }

    public Vector3(double x, double y, double z) {
        super();

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector3 v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public Vector3(double[] ds) throws DwarfException {
        super();

        if (ds.length == 3) {
            this.x = ds[0];
            this.y = ds[1];
            this.z = ds[2];
        } else {
            throw new DwarfException("illegal argument");
        }
    }

    public Vector3(float[] fs) throws DwarfException {
        super();

        if (fs.length == 3) {
            this.x = fs[0];
            this.y = fs[1];
            this.z = fs[2];
        } else {
            throw new DwarfException("illegal argument");
        }
    }

    public double length() {
        return Math.sqrt(
                this.getX() * this.getX()
                + this.getY() * this.getY()
                + this.getZ() * this.getZ());
    }

    public double dot(Vector3 input) {
        return (this.getX() * input.getX())
                + (this.getY() * input.getY())
                + (this.getZ() * input.getZ());
    }

    public Vector3 cross(Vector3 input) {
        double deltaX = (this.getY() * input.getZ()) - (this.getZ() * input.getY());
        double deltaY = (this.getZ() * input.getX()) - (this.getX() * input.getZ());
        double deltaZ = (this.getX() * input.getY()) - (this.getY() * input.getX());

        return new Vector3(deltaX, deltaY, deltaZ);
    }

    public Vector3 normalized() {
        double length = length();

        return new Vector3(
                this.getX() / length,
                this.getY() / length,
                this.getZ() / length);
    }

    public void add(Vector3 input) {
        this.x += input.getX();
        this.y += input.getY();
        this.z += input.getZ();
    }

    public void add(double input) {
        this.x += input;
        this.y += input;
        this.z += input;
    }

    public void sub(Vector3 input) {
        this.x -= input.getX();
        this.y -= input.getY();
        this.z -= input.getZ();
    }

    public void sub(double input) {
        this.x -= input;
        this.y -= input;
        this.z -= input;
    }

    public void mul(Vector3 input) {
        this.x *= input.getX();
        this.y *= input.getY();
        this.z *= input.getZ();
    }

    public void mul(double input) {
        this.x *= input;
        this.y *= input;
        this.z *= input;
    }

    public void div(Vector3 input) {
        this.x /= input.getX();
        this.y /= input.getY();
        this.z /= input.getZ();
    }

    public void div(double input) {
        this.x /= input;
        this.y /= input;
        this.z /= input;
    }

    public void mod(Vector3 input) {
        this.x %= input.getX();
        this.y %= input.getY();
        this.z %= input.getZ();
    }

    public void mod(double input) {
        this.x %= input;
        this.y %= input;
        this.z %= input;
    }

    public Vector3 abs() {
        return new Vector3(
                Math.abs(getX()),
                Math.abs(getY()),
                Math.abs(getZ()));
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
        return "Vector3d[" + getX() + ", " + getY() + ", " + getZ() + "]";
    }

    public Vector2 getXY() {
        return new Vector2(getX(), getY());
    }

    public Vector2 getYZ() {
        return new Vector2(getY(), getZ());
    }

    public Vector2 getZX() {
        return new Vector2(getZ(), getX());
    }

    public Vector2 getYX() {
        return new Vector2(getY(), getX());
    }

    public Vector2 getZY() {
        return new Vector2(getZ(), getY());
    }

    public Vector2 getXZ() {
        return new Vector2(getX(), getZ());
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(Vector3 v) {
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
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
        } else if (!super.equals(obj)) {
            return false;
        }

        final Vector3 v = (Vector3) obj;

        if (Double.doubleToLongBits(getX()) != Double.doubleToLongBits(v.getX())) {
            return false;
        } else if (Double.doubleToLongBits(getY()) != Double.doubleToLongBits(v.getY())) {
            return false;
        } else if (Double.doubleToLongBits(getZ()) != Double.doubleToLongBits(v.getZ())) {
            return false;
        }
        return true;
    }

    public void translate(Vector3 delta) {
        this.x += delta.getX();
        this.y += delta.getY();
        this.z += delta.getZ();
    }

    public void translate(double delta) {
        this.x += delta;
        this.y += delta;
        this.z += delta;
    }

    public void translateX(double deltaX) {
        this.x += deltaX;
    }

    public void trannslateY(double deltaY) {
        this.y += deltaY;
    }

    public void translateZ(double deltaZ) {
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
     * @exception OutOfMemoryError if there is not enough memory.
     * @throws java.lang.CloneNotSupportedException if clone is not supported
     * thought this should not happen.
     *
     * @return a clone of this instance.
     */
    @Override
    public Vector3 clone() throws CloneNotSupportedException {
        return new Vector3(this);
    }

    public double[] toArray() {
        return new double[]{x, y, z};
    }

    public double get(int index) {
        switch (index) {
            case 0:
                return x;
            case 1:
                return y;
            case 2:
                return z;
        }
        throw new dwarf.DwarfException("illegal argument");
    }

    public double angleBetween(Vector3 otherVector) {
        double dotProduct = dot(otherVector);
        double angle = Math.acos(dotProduct);

        return angle;
    }
}
