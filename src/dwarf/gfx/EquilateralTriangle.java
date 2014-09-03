package dwarf.gfx;

import dwarf.util.math;
import dwarf.util.Vector2;

import static dwarf.util.math.sqr;
import static dwarf.gfx.draw.SHAPE_TRIANGLE;
import dwarf.util.Point;

/**
 * A 3 sided polygon where are 3 sides are equal.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a
 * href='http://en.wikipedia.org/wiki/Equilateral_triangle'>wikipedia</a>
 * @see dwarf.gfx.Shape
 * @see dwarf.gfx.Polygon
 */
public class EquilateralTriangle extends Shape {

    /**
     * Default constructor.
     */
    public EquilateralTriangle() {
        super();
    }

    public EquilateralTriangle(double sideLength, Point position, int mode, Colour colour) {
        super(SHAPE_TRIANGLE, sideLength, position, mode, colour);
    }

    public EquilateralTriangle(EquilateralTriangle et) {
        super(SHAPE_TRIANGLE, et.getLineLength(), et.getPosition(), et.getMode(), et.getColour());
    }

    @Override
    public double getArea() {
        return math.sqrt(3) / 4 * sqr(super.getLineLength());
    }

    @Override
    @Deprecated
    public void addPoint(Point point) {
        super.addPoint(point);
    }

    @Override
    public EquilateralTriangle get() {
        return this;
    }

    @Override
    public EquilateralTriangle clone() throws CloneNotSupportedException {
        return new EquilateralTriangle(this);
    }

    @Override
    @Deprecated
    public void changeNumSides(int input) {
        super.changeNumSides(input);
    }

    @Override
    @Deprecated
    public void addPoints(Point[] points) {
        super.addPoints(points);
    }

    @Override
    @Deprecated
    public void addPoint(double xPos, double yPos) {
        super.addPoint(xPos, yPos);
    }

    @Override
    @Deprecated
    public void setVertices(double[] xPoints, double[] yPoints) {
        super.setVertices(xPoints, yPoints);
    }

    @Override
    @Deprecated
    public void setVertices(java.awt.Polygon p) {
        super.setVertices(p);
    }

    @Override
    @Deprecated
    public void setVertices(Point[] vertices) {
        super.setVertices(vertices);
    }
}
