package dwarf.graphics;

import dwarf.util.Vector2;

/**
 * @author sid_th3_sl0th
 */
public class Square extends Rectangle {

    public Square(float sideLength, Vector2 position, String state, Colour colour) {
        super(sideLength, sideLength, position, state, colour);
    }
    
    public Square(double sideLength, Vector2 position, String state, Colour colour) {
        super(sideLength, sideLength, position, state, colour);
    }
}
