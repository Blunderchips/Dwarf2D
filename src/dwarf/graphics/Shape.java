package dwarf.graphics;

import static dwarf.util.math.sin;
import dwarf.util.Vector2;
import dwarf.util.math;
import static java.lang.Math.tan;

/**
 * @author sid_th3_sl0th
 */
public class Shape extends Polygon {

    private int numSides;
    private double lineLength;

    public Shape(int numSides, double lineLength, Vector2 position, String state, Colour colour) {
        super(position, state, colour);

        if (numSides >= 3) {

            if (numSides >= 60) {
                numSides = 60;
            }

            this.init(numSides, lineLength);
        } else {
            throw new IllegalArgumentException("lol you stupid idiot, shapes require 3 or more sides.");
        }
    }

    private void init(int numSides, double lineLength) {
        this.numSides = numSides;
        this.lineLength = lineLength;

        Vector2[] point = new Vector2[numSides];

        Vector2 bacon = new Vector2();

        int angle = 360 / numSides;

        for (int i = 0; i < numSides; i++) {
            bacon.move(getLineLength());
            bacon.rotate(angle);

            point[i] = new Vector2(bacon.getX(), (bacon.getY()));
        }

        this.setPoints(point);
    }

    public int getNumSides() {
        return this.numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public double getLineLength() {
        return this.lineLength;
    }

    public void setLineLength(double lineLength) {
        this.lineLength = lineLength;
    }

    public float getPerimeter() {
        return (float) (numSides * lineLength);
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
        return 5 / (2 * tan(180 / numSides));
    }

    public double getRaduis() {
        return 5 / (2 * (sin(180 / numSides)));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + numSides;
        hash = 13 * hash + (int) (Double.doubleToLongBits(lineLength) ^ (Double.doubleToLongBits(lineLength) >>> 32));
        return hash;
    }

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

    public double getArea() {
        return (Math.round((math.sqr(getLineLength() / 2) * Math.tan(Math.toRadians(180 - (360 / getNumSides())) / 2)) * getNumSides()) * 1000) / 1000;
    }
}
