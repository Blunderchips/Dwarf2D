package dwarf.gfx;

import dwarf.util.Vector2;
import dwarf.util.math;

import static dwarf.util.math.sqr;
import static dwarf.gfx.draw.SHAPE_TRIANGLE;

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
    
    public EquilateralTriangle(double sideLength, Vector2 position, int mode, Colour colour) {
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
    public void addPoint(Vector2 point) {
        super.addPoint(point);
    }

    @Override
    public EquilateralTriangle get() {
        return this;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new EquilateralTriangle(this);
    }
}
