package dwarf.graphics;

import dwarf.util.math;
import static dwarf.util.math.sqr;
import dwarf.util.Vector2;

/**
 * @author sid_th3_sl0th
 */
public class EquilateralTriangle extends Shape {

    public EquilateralTriangle(double sideLength, Vector2 position, String state, Colour colour) {
        super(3, sideLength, position, state, colour);
    }

    @Override
    public double getArea() {
        return math.sqrt(3) / 4 * sqr(getLineLength());
    }
}
