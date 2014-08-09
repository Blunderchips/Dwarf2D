package dwarf.graphics;

import dwarf.Collidable;
import dwarf.util.Vector2;

/**
 * A 4 sided shape where opposite sides are equal. (a parallelogram with a right
 * angle)
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Rectangle'>wikipedia</a>
 * @see dwarf.graphics.Quadrilateral
 * @see dwarf.graphics.Polygon
 */
public class Rectangle extends Quadrilateral {

    /**
     * the top of the <code>Rectangle</code>.
     *
     * @see dwarf.graphics.Rectangle#getNorthFace()
     * @see dwarf.graphics.Rectangle#intersects(int, dwarf.Collidable)
     */
    public static final byte NORTH_FACE = 0x0;
    /**
     * the right hand side of the <code>Rectangle</code>.
     *
     * @see dwarf.graphics.Rectangle#getEastFace()
     * @see dwarf.graphics.Rectangle#intersects(int, dwarf.Collidable)
     */
    public static final byte EAST_FACE = 0x1;
    /**
     * the bottom of the <code>Rectangle</code>.
     *
     * @see dwarf.graphics.Rectangle#getSouthFace()
     * @see dwarf.graphics.Rectangle#intersects(int, dwarf.Collidable)
     */
    public static final byte SOUTH_FACE = 0x2;
    /**
     * the left hand side of the <code>Rectangle</code>.
     *
     * @see dwarf.graphics.Rectangle#getWestFace()
     * @see dwarf.graphics.Rectangle#intersects(int, dwarf.Collidable)
     */
    public static final byte WEST_FACE = 0x3;

    /**
     * the dimensions of the <code>Rectangle</code>.
     */
    private Vector2 dimensions;

    public Rectangle(float width, float height, Vector2 position, String mode, Colour colour) {
        super(null, position, mode, colour);
        this.setVertices(width, height);
    }

    public Rectangle(double width, double height, Vector2 position, String mode, Colour colour) {
        super(null, position, mode, colour);
        this.setVertices(width, height);
    }

    public Rectangle(Vector2 dimensions, Vector2 position, String mode, Colour colour) {
        super(null, position, mode, colour);
        this.setVertices(dimensions.getX(), dimensions.getY());
    }

    public Rectangle(Rectangle rectangle) {
        super(null, rectangle.getPosition(), rectangle.getMode(), rectangle.getColour());
        this.setVertices(rectangle.getDimensions().getX(), rectangle.getDimensions().getY());
    }

    /**
     * @param width the width of the <code>Rectangle</code>.
     * @param height the height of the <code>Rectangle</code>
     */
    protected final void setVertices(double width, double height) {
//        this.addPoint(new Vector2(0, 0));
//        this.addPoint(new Vector2(0, height));
//        this.addPoint(new Vector2(width, height));
//        this.addPoint(new Vector2(width, 0));

        this.dimensions = new Vector2(width, height);

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
        return (float) (this.getDimensions().getX() * this.getDimensions().getY());
    }

    public Vector2 getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(Vector2 dimensions) {
        this.setVertices(dimensions.getX(), dimensions.getY());
    }

    public void setSize(double width, double height) {
        this.setVertices(width, height);
    }

    /**
     * returns true if the <code>Rectanlge</code> face have intersected with the
     * inputed <code>Collidable</code>.
     *
     * @see dwarf.Collidable#intersects(dwarf.Collidable)
     *
     * @param face the face of the <code>Rectanlge</code> to be tested
     * @param coll - the <code>Collidable</code> to be tested
     * @return true if the <code>Collidable</code> has intersected/collided with
     * the inputed face of this.
     */
    public boolean intersects(int face, Collidable coll) {

        switch (face) {
            case NORTH_FACE:

                return coll.intersects(getNorthFace());

            case EAST_FACE:

                return coll.intersects(getEastFace());

            case SOUTH_FACE:

                return coll.intersects(getSouthFace());

            case WEST_FACE:

                return coll.intersects(getWestFace());

            default:
                System.err.println("the face '" + face + "' is not reconized");
                return false;
        }
    }

    public boolean isSquare() {
        return this.getDimensions().getX() == this.getDimensions().getY();
    }

    @Override
    public Rectangle get() {
        return this;
    }

    public void scale(double delta) {
        this.setDimensions(
                this.getDimensions().mul(delta)
        );
    }

    public void scale(Vector2 delta) {
        this.setDimensions(
                this.getDimensions().mul(delta)
        );
    }

    /**
     * The <code>Rectangle</code> class encapsulates a description of a closed,
     * two-dimensional region within a coordinate space.
     *
     * @see java.awt.Rectangle
     *
     * @return a new Java AWT Rectangle created by the points in the dimensions
     * and the position of this
     */
    public java.awt.Rectangle toRectangle() {
        return new java.awt.Rectangle(
                (int) getPosition().getX(), (int) getPosition().getY(),
                (int) getDimensions().getX(), (int) getDimensions().getY()
        );
    }

    public double getHalfX() {
        return this.getDimensions().getX() / 2;
    }

    public double getHalfY() {
        return this.getDimensions().getY() / 2;
    }

    @Override
    public Vector2 getCenterX() {
        return new Vector2(
                this.getPosition().getX() + this.getHalfX(),
                this.getPosition().getY()
        );
    }

    @Override
    public Vector2 getCenterY() {
        return new Vector2(
                this.getPosition().getX(),
                this.getPosition().getY() + this.getHalfY()
        );
    }

    @Override
    public Vector2 getCenter() {
        return new Vector2(
                this.getCenterX().getX(),
                this.getCenterY().getY()
        );
    }

    public void set(float width, float height, Vector2 position, String mode, Colour colour) {
        this.setVertices(width, height);
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);
    }

    public void set(double width, double height, Vector2 position, String mode, Colour colour) {
        this.setVertices(width, height);
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);
    }

    public void set(Vector2 dimensions, Vector2 position, String mode, Colour colour) {
        this.setVertices(dimensions.getX(), dimensions.getY());
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);
    }

    public void set(Rectangle rectangle) {
        this.setVertices(
                rectangle.getDimensions().getX(),
                rectangle.getDimensions().getY()
        );

        // --
        super.setPosition(rectangle.getPosition());
        super.setMode(rectangle.getMode());
        super.setColour(rectangle.getColour());
    }

    @Override
    public void setVertices(double[] xPoints, double[] yPoints) {
        if (xPoints.length == 4 && yPoints.length == 4) {
            super.setVertices(xPoints, yPoints);
        } else {
            throw new IllegalArgumentException("lol you stupid idiot, a Rectangle has 4 vertices.");
        }
    }

    @Override
    public void setVertices(Vector2[] vertices) {
        if (vertices.length == 4) {
            super.setVertices(vertices);
        } else {
            throw new IllegalArgumentException("lol you stupid idiot, a Rectangle has 4 vertices.");
        }
    }

    @Override
    public float getAverageWidth() {
        return (float) this.getHalfX();
    }

    @Override
    public float getAverageHeight() {
        return (float) this.getHalfY();
    }

    /**
     * if this is a square this will return a Square or it will throw a error.
     *
     * @see dwarf.graphics.Square
     * @see java.lang.Exception
     *
     * @throws java.lang.Exception throws a error if this is not a square
     * @return this as a new Square if possible otherwise will throw a error
     */
    public Square toSquare() throws Exception {
        if (isSquare()) {
            return new Square(
                    this.getDimensions().getX(),
                    super.getPosition(),
                    super.getMode(),
                    super.getColour()
            );
        } else {
            throw new Exception("this is not a square. (length != breadth)");
        }
    }

    public Collidable getNorthFace() {
        Rectangle rect = new Rectangle(
                this.getDimensions().getX(),
                10 * this.getDimensions().getY() / 100,
                super.getPosition(),
                "stroke", null
        );

        rect.setPosition(
                super.getPosition().getX(),
                super.getPosition().getY() + this.getDimensions().getY() - rect.getDimensions().getY()
        );

        return rect.getCollidable();
    }

    public Collidable getEastFace() {
        Rectangle rect = new Rectangle(
                10 * this.getDimensions().getX() / 100,
                this.getDimensions().getY(),
                super.getPosition(),
                "stroke", null
        );

        rect.setPosition(
                super.getPosition().getX() + this.getDimensions().getX() - rect.getDimensions().getX(),
                super.getPosition().getY()
        );

        return rect.getCollidable();
    }

    public Collidable getSouthFace() {
        return new Rectangle(
                this.getDimensions().getX(),
                10 * this.getDimensions().getY() / 100,
                super.getPosition(),
                "stroke", null
        ).getCollidable();
    }

    public Collidable getWestFace() {
        return new Rectangle(
                10 * this.getDimensions().getX() / 100,
                this.getDimensions().getY(),
                super.getPosition(),
                "stroke", null
        ).getCollidable();
    }
}
