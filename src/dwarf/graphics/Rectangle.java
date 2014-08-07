package dwarf.graphics;

import dwarf.Collidable;
import dwarf.util.Vector2;

/**
 * A 4 sided shape where opposite sides are equal. (a parallelogram with a right
 * angle)
 *
 * @author sid_th3_sl0th
 *
 * @see <a href='http://en.wikipedia.org/wiki/Rectangle'>wikipedia</a>
 * @see dwarf.graphics.Quadrilateral
 * @see dwarf.graphics.Polygon
 */
public class Rectangle extends Quadrilateral {

    /**
     * the top of the <code>Rectangle</code>.
     */
    public static final byte NORTH_FACE = 0x0;
    /**
     * the right hand side of the <code>Rectangle</code>.
     */
    public static final byte EAST_FACE = 0x1;
    /**
     * the bottom of the <code>Rectangle</code>.
     */
    public static final byte SOUTH_FACE = 0x2;
    /**
     * the left hand side of the <code>Rectangle</code>.
     */
    public static final byte WEST_FACE = 0x3;

    /**
     * the size of the <code>Rectangle</code>.
     */
    private Vector2 size;

    public Rectangle(float width, float height, Vector2 position, String mode, Colour colour) {
        super(null, position, mode, colour);
        this.setPoints(width, height);
    }

    public Rectangle(double width, double height, Vector2 position, String mode, Colour colour) {
        super(null, position, mode, colour);
        this.setPoints(width, height);
    }

    public Rectangle(Vector2 size, Vector2 position, String mode, Colour colour) {
        super(null, position, mode, colour);
        this.setPoints(size.getX(), size.getY());
    }

    public Rectangle(Rectangle rectangle) {
        super(null, rectangle.getPosition(), rectangle.getMode(), rectangle.getColour());
        this.setPoints(rectangle.getSize().getX(), rectangle.getSize().getY());
    }

    private void setPoints(double width, double height) {
//        this.addPoint(new Vector2(0, 0));
//        this.addPoint(new Vector2(0, height));
//        this.addPoint(new Vector2(width, height));
//        this.addPoint(new Vector2(width, 0));

        this.size = new Vector2(width, height);

        // --
        Vector2[] vertices = {
            new Vector2(0, 0),
            new Vector2(0, height),
            new Vector2(width, height),
            new Vector2(width, 0)
        };
        // --

        super.setVertices(vertices);
    }

    /**
     * returns the area of the <code>Rectangle</code>. (length * breadth)
     *
     * @return he area of the <code>Rectangle</code>
     */
    public float getArea() {
        return (float) (this.getSize().getX() * this.getSize().getY());
    }

    public Vector2 getSize() {
        return this.size;
    }

    public void setSize(Vector2 size) {
        this.setPoints(size.getX(), size.getY());
    }

    public void setSize(float width, float height) {
        this.setPoints(width, height);
    }

    public boolean intersects(int face, Collidable coll) {

        switch (face) {
            case NORTH_FACE:

                Rectangle ham = new Rectangle(
                        this.getSize().getX(),
                        10 * this.getSize().getY() / 100,
                        super.getPosition(),
                        "stroke", Colour.white
                );

                ham.setPosition(
                        super.getPosition().getX(),
                        super.getPosition().getY() + this.getSize().getY() - ham.getSize().getY()
                );

                return ham.intersects(coll);

            case EAST_FACE:

                Rectangle eggs = new Rectangle(
                        10 * this.getSize().getX() / 100,
                        this.getSize().getY(),
                        super.getPosition(),
                        "stroke", Colour.white
                );

                eggs.setPosition(
                        super.getPosition().getX() + this.getSize().getX() - eggs.getSize().getX(),
                        super.getPosition().getY()
                );

                return eggs.intersects(coll);
            case SOUTH_FACE:

                Rectangle tuna = new Rectangle(
                        this.getSize().getX(),
                        10 * this.getSize().getY() / 100,
                        super.getPosition(),
                        "stroke", Colour.white
                );

                return tuna.intersects(coll);

            case WEST_FACE:

                Rectangle salami = new Rectangle(
                        10 * this.getSize().getX() / 100,
                        this.getSize().getY(),
                        super.getPosition(),
                        "stroke", Colour.white
                );

                return salami.intersects(coll);

            default:
                System.err.println("the face '" + face + "' is not reconized");
                return false;
        }
    }

    public boolean isSquare() {
        return this.getSize().getX() == this.getSize().getY();
    }
    
    @Override
    public Rectangle get() {
        return this;
    }
    
    /**
     * The
     * <code>Rectangle</code> class encapsulates a description of a closed,
     * two-dimensional region within a coordinate space.
     *
     * @see java.awt.Rectangle
     * @return a new Java AWT Rectangle created by the points in the size and
     * the position of this
     */
    public java.awt.Rectangle toRectangle() {
        return new java.awt.Rectangle(
                (int) getPosition().getX(), (int) getPosition().getY(),
                (int) getSize().getX(), (int) getSize().getY()
        );
    }
}
