package dwarf.graphics;

import dwarf.util.math;
import static dwarf.util.math.sqr;
import dwarf.util.Vector2;

/**
 * @author sid_th3_sl0th
 * 
 * @see <a href='http://en.wikipedia.org/wiki/Equilateral_triangle'>wikipedia</a>
 * @see dwarf.graphics.Shape
 * @see dwarf.graphics.Polygon
 */
public class EquilateralTriangle extends Shape {

    public EquilateralTriangle(double sideLength, Vector2 position, String mode, Colour colour) {
        super(3, sideLength, position, mode, colour);
    }

    public EquilateralTriangle(EquilateralTriangle equilateralTriangle) {
        super(3, equilateralTriangle.getLineLength(), equilateralTriangle.getPosition(), equilateralTriangle.getMode(), equilateralTriangle.getColour());
    }

    @Override
    public double getArea() {
        return math.sqrt(3) / 4 * sqr(getLineLength());
    }

    @Override
    public void addPoint(Vector2 point) {
        System.err.println("This method is unsuported with the EquilateralTriangle class.");
    }
}
