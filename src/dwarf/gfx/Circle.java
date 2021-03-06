package dwarf.gfx;

import dwarf.util.Point2D;

import static dwarf.util.math.PI;
import static dwarf.util.math.sqr;
import static dwarf.util.math.TWO_PI;

/**
 * A 60 sided shape with all methods overridden to return values for a circle.
 * (A simple Circle geometry)
 *
 * <p>
 * A circle is a plane figure formed by a curved line called the circumference
 * and is such that all right lines drawn from a certain point with in the
 * figure to the circumference are equal to one another. This point is called
 * the center. A radius of a circle is any right line drawn from the center to
 * the circumference. A diameter of a circle is aright line drawn through the
 * center and terminated both ways by the circumference. From the definition of
 * a circle it follows at once that the path of a movable point in a plane which
 * remains at a constant distance from a fixed point is a circle; also that any
 * point Pin the plane is inside, outside, or on the circumference of a circle
 * according as its distance from the center is less than greater than or equal
 * to, the radius.
 * </p>
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Circle'>wikipedia</a>
 * @see dwarf.gfx.Shape
 * @see dwarf.gfx.Polygon
 */
public class Circle extends Shape {

    /**
     * The radius of the circle.
     */
    private double radius;

    /**
     * Default constructor.
     */
    public Circle() {
        super();
    }

    public Circle(double radius, Point2D location, int mode, Colour colour) {
        super(SHAPE_CIRCLE, ((TWO_PI * radius) / 60), location, mode, colour);
        this.radius = radius;
    }

    public Circle(Circle circle) {
        super(SHAPE_CIRCLE, circle.getRadius(), circle.getPosition(), circle.getMode(), circle.getColour());
        this.radius = circle.getRadius();
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

        super.setNumSides(SHAPE_CIRCLE);
        super.setLineLength(((TWO_PI * radius) / 60));

        super.init();
    }

    public double getHalfWidth() {
        return radius;
    }

    public double getHalfHeight() {
        return radius;
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
    public Point2D getCenterX() {
        return new Point2D(
                this.getPosition().getX() + this.getRadius(),
                this.getPosition().getY()
        );
    }

    @Override
    public Point2D getCenterY() {
        return new Point2D(
                this.getPosition().getX(),
                this.getPosition().getY() + this.getRadius()
        );
    }

    @Override
    public Point2D getCenter() {
        return new Point2D(
                this.getCenterX().getX(),
                this.getCenterY().getY()
        );
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return new Circle(this);
    }

    @Override
    @Deprecated
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    @Deprecated
    public void changeNumSides(int input) {
        super.changeNumSides(input);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
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
        } else if (super.getClass() != obj.getClass()) {
            return false;
        }

        final Circle other = (Circle) obj;

        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }

        return true;
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
        return "Circle[" + "radius: " + radius + ", position: " + super.getPosition() + "]";
    }
}
