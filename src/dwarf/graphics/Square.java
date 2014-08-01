package dwarf.graphics;

import dwarf.util.Vector2;

/**
 * In geometry, a square is a regular quadrilateral, which means that it has
 * four equal sides and four equal angles (90-degree angles, or right
 * angles). It can also be defined as a rectangle in which two adjacent sides
 * have equal length. A square with vertices ABCD would be denoted ABCD.
 *
 * @author sid_th3_sl0th
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
}
