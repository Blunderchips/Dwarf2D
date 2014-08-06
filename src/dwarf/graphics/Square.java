package dwarf.graphics;

import dwarf.util.Vector2;

/**
 * A 4 sided shape where all 4 sides are equal and both diagonals bisect each
 * other. (a rhombus with a right angle)
 *
 * @author sid_th3_sl0th
 *
 * @see <a href='http://en.wikipedia.org/wiki/Square'>wikipedia</a>
 * @see dwarf.graphics.Rectangle
 * @see dwarf.graphics.Quadrilateral
 * @see dwarf.graphics.Polygon
 */
public class Square extends Rectangle {

    public Square(float sideLength, Vector2 position, String mode, Colour colour) {
        super(sideLength, sideLength, position, mode, colour);
    }

    public Square(double sideLength, Vector2 position, String mode, Colour colour) {
        super(sideLength, sideLength, position, mode, colour);
    }

    public Square(Square square) {
        super(square.getLineLength(), square.getLineLength(), square.getPosition(), square.getMode(), square.getColour());
    }

    public float getLineLength() {
        return (float) super.getSize().getX();
    }

    @Override
    public Square get() {
        return this;
    }
}
