package dwarf.gfx;

import dwarf.util.math;
import dwarf.util.Vector2;

import static java.lang.Math.abs;
import static java.lang.Math.tan;

import static dwarf.util.math.sin;

/**
 * A regular figure that has sides, edges and angles that are congruent.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.gfx.Polygon
 */
public class Shape extends Polygon {

    private byte numSides;
    private double lineLength;

    /**
     * Default constructor.
     */
    public Shape() {
        super();
    }

    public Shape(int numSides, double lineLength, Vector2 position, int mode, Colour colour) {
        super(position, mode, colour);

        numSides = abs(numSides);

        if (numSides >= 3) {

            if (numSides >= 60) {
                numSides = 60;
            }

            this.init(numSides, lineLength);
        } else {
            throw new dwarf.DwarfException("lol you stupid idiot, shapes require 3 or more sides.");
        }
    }

    public Shape(Shape shape) {
        super(shape.getPosition(), shape.getMode(), shape.getColour());
        this.init(shape.getNumSides(), shape.getLineLength());
    }

    protected final void init(int numSides, double lineLength) {
        this.numSides = (byte) numSides;
        this.lineLength = lineLength;

        Vector2[] point = new Vector2[numSides];

        Vector2 temp = new Vector2();

        int angle = 360 / numSides;

        for (int i = 0; i < numSides; i++) {
            temp.move(getLineLength());
            temp.rotate(angle);

            point[i] = new Vector2(temp.getX(), (temp.getY()));
        }

        super.setVertices(point);
    }

    public int getNumSides() {
        return this.numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = (byte) numSides;
    }

    public double getLineLength() {
        return this.lineLength;
    }

    public void setLineLength(double lineLength) {
        this.lineLength = lineLength;
    }

    public float getPerimeter() {
        return (float) (getNumSides() * getLineLength());
    }

    public void changeNumSides(int input) {
        this.numSides += input;
    }

    /**
     * The apothem is also the radius of the encircle of the polygon. For a
     * polygon of n sides, there are n possible apothem, all the same length of
     * course. The word apothem can refer to the line itself, or the length of
     * that line.
     *
     * @return 5 / (2 * tan(180 / numSides))
     */
    public double getApothem() {
        return 5 / (2 * tan(180 / getNumSides()));
    }

    public double getRadius() {
        return 5 / (2 * (sin(180 / getNumSides())));
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
        hash = 13 * hash + getNumSides();
        hash = 13 * hash + (int) (Double.doubleToLongBits(getLineLength()) ^ (Double.doubleToLongBits(getLineLength()) >>> 32));
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
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
        final Shape other = (Shape) obj;
        if (this.getNumSides() != other.getNumSides()) {
            return false;
        } else {
            return Double.doubleToLongBits(getLineLength()) == Double.doubleToLongBits(other.getLineLength());
        }
    }

    /**
     * calculates the area of any regular polygon using the length of each line
     * segment and the number of line segments. Rounds off to three decimal
     * places.
     *
     * @author Shane Acton
     * @author Isa Cattanach
     * @author Matthew Van der Bijl
     *
     * @return returns the area of the <code>Shape</code> (double)
     */
    public double getArea() {
        return (Math.round((math.sqr(getLineLength() / 2) * Math.tan(Math.toRadians(180 - (360 / getNumSides())) / 2)) * getNumSides()) * 1000) / 1000;
    }

    @Override
    public Shape get() {
        return this;
    }

    public void scale(double delta) {
        this.setLineLength(getLineLength() * delta);
    }

    @Override
    @Deprecated
    public void addPoint(Vector2 point) {
        super.addPoint(point);
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return new Shape(this);
    }
}
