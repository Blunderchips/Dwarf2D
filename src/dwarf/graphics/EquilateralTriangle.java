package dwarf.graphics;

import dwarf.util.math;
import static dwarf.util.math.sqr;
import dwarf.util.Vector2;

/**
 * In geometry, an equilateral triangle is a triangle in which all three sides
 * are equal. In traditional or Euclidean geometry, equilateral triangles are
 * also equiangular; that is, all three internal angles are also congruent to
 * each other and are each 60°. They are regular polygons, and can therefore
 * also be referred to as regular triangles.
 *
 * @author sid_th3_sl0th
 * @see dwarf.graphics.Shape
 * @see dwarf.graphics.Polygon
 */
public class EquilateralTriangle extends Shape {

    public EquilateralTriangle(double sideLength, Vector2 position, String state, Colour colour) {
        super(3, sideLength, position, state, colour);
    }

    @Override
    public double getArea() {
        return math.sqrt(3) / 4 * sqr(getLineLength());
    }

    @Override
    public void addPoint(Vector2 point) {
        System.err.println("This method is unsuported with the Quadrilateral class.");
    }
}
