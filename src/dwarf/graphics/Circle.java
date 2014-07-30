package dwarf.graphics;

import static dwarf.util.math.TWO_PI;
import static dwarf.util.math.sqr;
import dwarf.util.Vector2;
import static java.lang.Math.PI;
import java.util.Objects;

/**
 * A circle is a simple shape of Euclidean geometry that is the set of all
 * points in a plane that are at a given distance from a given point, the
 * center. The distance between any of the points and the center is called the
 * radius. It can also be defined as the locus of a point equidistant from a
 * fixed point.
 *
 * @author sid_th3_sl0th
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius, Vector2 location, String state, Colour colour) {
        super(60, ((TWO_PI * radius) / 60), location, state, colour);
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

        final Circle other = (Circle) obj;

        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        } else if (!Objects.equals(getColour(), other.getColour())) {
            return false;
        } else {
            return Objects.equals(getColour(), other.getColour());
        }
    }

    public double getCircumference() {
        return TWO_PI * radius;
    }

    @Override
    public double getArea() {
        return PI * sqr(radius);
    }

    public double getDiameter() {
        return radius * 2;
    }

    /**
     * Length of a Circular Arc: (with central angle theta) if the angle theta
     * is in degrees, then length = theta x (PI/180) x r if the angle theta is
     * in radians, then length = r x theta
     *
     * @see http://www.math.com/tables/geometry/circles.htm
     *
     * @param theta (degrees)
     * @return theta * (PI / 180) * radius
     */
    public double getCircularArcLength(double theta) {
        return theta * (PI / 180) * radius;
    }

    /**
     * Area of Circle Sector: (with central angle theta) if the angle theta is
     * in degrees, then area = (theta/360)x PI r2 if the angle theta is in
     * radians, then area = ((theta/(2PI))x PI r2
     *
     * @see http://www.math.com/tables/geometry/circles.htm
     *
     * @param theta (degrees)
     * @return (theta / 360) * this.getArea()
     */
    public double getCircleSector(double theta) {
        return (theta / 360) * this.getArea();
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public float getHalfWidth() {
        return (float) radius;
    }

    public float getHalfHeight() {
        return (float) radius;
    }
}
