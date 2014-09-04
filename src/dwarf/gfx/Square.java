package dwarf.gfx;

import dwarf.util.Point2D;

/**
 * A 4 sided shape where all 4 sides are equal and both diagonals bisect each
 * other (a lozenge/rhombus with right angles). A Square has all the properties
 * of a parallelogram, a rectangle and a rhombus.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Square'>wikipedia</a>
 * @see dwarf.gfx.Rectangle
 * @see dwarf.gfx.Quadrilateral
 * @see dwarf.gfx.Polygon
 */
public class Square extends Rectangle {

    /**
     * Default constructor.
     */
    public Square() {
        super();
    }
    
    public Square(float sideLength, Point2D position, int mode, Colour colour) {
        super(sideLength, sideLength, position, mode, colour);
    }
    
    public Square(double sideLength, Point2D position, int mode, Colour colour) {
        super(sideLength, sideLength, position, mode, colour);
    }
    
    public Square(Square square) {
        super(square.getLineLength(), square.getLineLength(), square.getPosition(), square.getMode(), square.getColour());
    }
    
    public float getLineLength() {
        return (float) super.getDimensions().getWidth();
    }
    
    @Override
    public Square get() {
        return this;
    }
    
    public void setLineLength(double sideLength) {
        super.setSize(sideLength, sideLength);
    }
    
    @Override
    @Deprecated
    public void scale(double deltaX, double deltaY) {
        super.scale(deltaX, deltaY);
    }
    
    public void set(float sideLength, Point2D position, int mode, Colour colour) {
        this.setLineLength(sideLength);
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);
    }
    
    public void set(double sideLength, Point2D position, int mode, Colour colour) {
        this.setLineLength(sideLength);
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);
    }
    
    public void set(Square square) {
        this.setLineLength(square.getLineLength());
        super.setPosition(square.getPosition());
        super.setMode(square.getMode());
        super.setColour(square.getColour());
    }
    
    @Override
    public Square clone() throws CloneNotSupportedException {
        return new Square(this);
    }
}
