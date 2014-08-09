package dwarf.graphics;

import dwarf.util.Vector2;
import java.util.Objects;
import static dwarf.util.math.TWO_PI;
import static dwarf.util.math.sqr;
import static java.lang.Math.PI;
import static dwarf.graphics.draw.SHAPE_CIRCLE;

/**
 * A 60 sided shape with all methods overridden to return values for a circle.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Circle'>wikipedia</a>
 * @see dwarf.graphics.Shape
 * @see dwarf.graphics.Polygon
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius, Vector2 location, String mode, Colour colour) {
        super(SHAPE_CIRCLE, ((TWO_PI * radius) / 60), location, mode, colour);
        this.radius = radius;
    }

    public Circle(Circle circle) {
        super(SHAPE_CIRCLE, circle.getRadius(), circle.getPosition(), circle.getMode(), circle.getColour());
        this.radius = circle.getRadius();
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

        final Circle other = (Circle) obj;

        if (Double.doubleToLongBits(this.getRadius()) != Double.doubleToLongBits(other.getRadius())) {
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
        return 2 * radius;
    }

    /**
     * Length of a Circular Arc: (with central angle theta) if the angle theta
     * is in degrees, then length = theta x (PI/180) x r if the angle theta is
     * in radians, then length = r x theta
     *
     * @see <a
     * href='http://www.math.com/tables/geometry/circles.htm'>www.math.com</a>
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
     * @see <a
     * href='http://www.math.com/tables/geometry/circles.htm'>www.math.com</a>
     *
     * @param theta (degrees)
     * @return (theta / 360) * this.getArea()
     */
    public double getCircleSector(double theta) {
        return (theta / 360) * this.getArea();
    }

    @Override
    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        super.init(SHAPE_CIRCLE, radius);
    }

    public float getHalfWidth() {
        return (float) radius;
    }

    public float getHalfHeight() {
        return (float) radius;
    }

    @Override
    public Circle get() {
        return this;
    }

    @Override
    public void scale(double delta) {
        this.setRadius(getRadius() * delta);
    }

    @Override
    public Vector2 getCenterX() {
        return new Vector2(
                this.getPosition().getX() + this.getRadius(),
                this.getPosition().getY()
        );
    }

    @Override
    public Vector2 getCenterY() {
        return new Vector2(
                this.getPosition().getX(),
                this.getPosition().getY() + this.getRadius()
        );
    }

    @Override
    public Vector2 getCenter() {
        return new Vector2(
                this.getCenterX().getX(),
                this.getCenterY().getY()
        );
    }
}
