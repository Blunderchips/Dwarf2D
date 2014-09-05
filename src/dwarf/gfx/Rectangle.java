package dwarf.gfx;

import java.awt.Dimension;

import dwarf.Collidable;
import dwarf.util.Point2D;

/**
 * A 4 sided shape where opposite sides are equal. (a parallelogram with a right
 * angle)
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Rectangle'>wikipedia</a>
 * @see dwarf.gfx.Quadrilateral
 * @see dwarf.gfx.Polygon
 */
public class Rectangle extends Quadrilateral {

    /**
     * the top of the <code>Rectangle</code>.
     *
     * @see dwarf.gfx.Rectangle#getNorthFace()
     * @see dwarf.gfx.Rectangle#intersects(int, dwarf.Collidable)
     */
    public static final byte NORTH_FACE = 0x0;
    /**
     * the right hand side of the <code>Rectangle</code>.
     *
     * @see dwarf.gfx.Rectangle#getEastFace()
     * @see dwarf.gfx.Rectangle#intersects(int, dwarf.Collidable)
     */
    public static final byte EAST_FACE = 0x1;
    /**
     * the bottom of the <code>Rectangle</code>.
     *
     * @see dwarf.gfx.Rectangle#getSouthFace()
     * @see dwarf.gfx.Rectangle#intersects(int, dwarf.Collidable)
     */
    public static final byte SOUTH_FACE = 0x2;
    /**
     * the left hand side of the <code>Rectangle</code>.
     *
     * @see dwarf.gfx.Rectangle#getWestFace()
     * @see dwarf.gfx.Rectangle#intersects(int, dwarf.Collidable)
     */
    public static final byte WEST_FACE = 0x3;

    /**
     * the dimensions of the <code>Rectangle</code>.
     */
    private java.awt.Dimension dimensions;

    /**
     * Default constructor.
     */
    public Rectangle() {
        super();
    }

    public Rectangle(float width, float height, Point2D position, int mode, Colour colour) {
        super(null, position, mode, colour);
        this.setVertices(width, height);
    }

    public Rectangle(double width, double height, Point2D position, int mode, Colour colour) {
        super(null, position, mode, colour);
        this.setVertices(width, height);
    }

    public Rectangle(Dimension dimensions, Point2D position, int mode, Colour colour) {
        super(null, position, mode, colour);
        this.setVertices(dimensions.getWidth(), dimensions.getHeight());
    }

    public Rectangle(Point2D dimensions, Point2D position, int mode, Colour colour) {
        super(null, position, mode, colour);
        this.setVertices(dimensions.getX(), dimensions.getY());
    }

    public Rectangle(Rectangle rectangle) {
        super(null, rectangle.getPosition(), rectangle.getMode(), rectangle.getColour());
        this.setVertices(rectangle.getDimensions().getWidth(), rectangle.getDimensions().getHeight());
    }

    /**
     * This method is called from within the constructor to initialize the
     * <code>Rectangle</code>. WARNING: Do NOT modify this code.
     *
     * @param width the width of the <code>Rectangle</code>.
     * @param height the height of the <code>Rectangle</code>
     */
    @SuppressWarnings("deprecation")
    public final void setVertices(double width, double height) {
//        this.addPoint(new Vector2(0, 0));
//        this.addPoint(new Vector2(0, height));
//        this.addPoint(new Vector2(width, height));
//        this.addPoint(new Vector2(width, 0));

        this.dimensions = new java.awt.Dimension((int) width, (int) height);

        // --
        Point2D[] vertices = {
            new Point2D(0, 0),
            new Point2D(0, height),
            new Point2D(width, height),
            new Point2D(width, 0)
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
        return (float) (this.getDimensions().getWidth() * this.getDimensions().getHeight());
    }

    public java.awt.Dimension getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(Point2D dimensions) {
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
     * @param face the face of the <code>Rectanlge</code> to be tested
     * @param coll - the <code>Collidable</code> to be tested
     * @return true if the <code>Collidable</code> has intersected/collided with
     * the inputed face of this.
     */
    public boolean intersects(int face, Collidable coll) throws dwarf.DwarfException {

        switch ((byte) face) {
            case NORTH_FACE:

                return coll.intersects(getNorthFace());

            case EAST_FACE:

                return coll.intersects(getEastFace());

            case SOUTH_FACE:

                return coll.intersects(getSouthFace());

            case WEST_FACE:

                return coll.intersects(getWestFace());

            default:
                throw new dwarf.DwarfException("the face '" + face + "' is not recognized.");
        }
    }

    @Override
    public boolean isSquare() {
        if (super.getType().equals("quadrilateral")) {
            return this instanceof Square || this.getDimensions().getWidth() == this.getDimensions().getHeight();
        } else {
            return false;
        }
    }

    @Override
    public Rectangle get() {
        return this;
    }

    public void scale(double delta) {
        this.getDimensions().setSize(
                this.getDimensions().getWidth() * delta,
                this.getDimensions().getHeight() * delta
        );
    }

    public void scale(double deltaX, double deltaY) {
        this.getDimensions().setSize(
                this.getDimensions().getWidth() * deltaX,
                this.getDimensions().getHeight() * deltaY
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
                (int) getDimensions().getWidth(), (int) getDimensions().getHeight()
        );
    }

    public double getHalfWidth() {
        return this.getDimensions().getWidth() / 2;
    }

    public double getHalfHeight() {
        return this.getDimensions().getHeight() / 2;
    }

    @Override
    public Point2D getCenterX() {
        return new Point2D(
                this.getPosition().getX() + this.getHalfWidth(),
                this.getPosition().getY()
        );
    }

    @Override
    public Point2D getCenterY() {
        return new Point2D(
                this.getPosition().getX(),
                this.getPosition().getY() + this.getHalfHeight()
        );
    }

    @Override
    public Point2D getCenter() {
        return new Point2D(
                this.getCenterX().getX(),
                this.getCenterY().getY()
        );
    }

    public void set(float width, float height, Point2D position, int mode, Colour colour) {
        this.setVertices(width, height);
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);
    }

    public void set(double width, double height, Point2D position, int mode, Colour colour) {
        this.setVertices(width, height);
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);
    }

    public void set(java.awt.Dimension dimensions, Point2D position, int mode, Colour colour) {
        this.setVertices(dimensions.getWidth(), dimensions.getHeight());
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);
    }

    public void set(Rectangle rectangle) {
        this.setVertices(
                rectangle.getDimensions().getWidth(),
                rectangle.getDimensions().getHeight()
        );

        // --
        super.setPosition(rectangle.getPosition());
        super.setMode(rectangle.getMode());
        super.setColour(rectangle.getColour());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setVertices(double[] xPoints, double[] yPoints) {
        if (xPoints.length == 4 && yPoints.length == 4) {
            super.setVertices(xPoints, yPoints);
        } else {
            throw new IllegalArgumentException("lol you stupid idiot, a Rectangle has 4 vertices.");
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setVertices(Point2D[] vertices) {
        if (vertices.length == 4) {
            super.setVertices(vertices);
        } else {
            throw new IllegalArgumentException("lol you stupid idiot, a Rectangle has 4 vertices.");
        }
    }

    @Override
    public float getAverageWidth() {
        return (float) this.getHalfWidth();
    }

    @Override
    public float getAverageHeight() {
        return (float) this.getHalfHeight();
    }

    /**
     * if this is a square this will return a Square or it will throw a error.
     *
     * @see dwarf.gfx.Square
     * @see java.lang.Exception
     *
     * @throws dwarf.DwarfException throws a error if this is not a square
     * @return this as a new Square if possible otherwise will throw a error
     */
    public Square toSquare() throws dwarf.DwarfException {
        if (isSquare()) {
            return new Square(
                    this.getDimensions().getWidth(),
                    super.getPosition(),
                    super.getMode(),
                    super.getColour()
            );
        } else {
            throw new dwarf.DwarfException("this is not a square. (length != breadth)");
        }
    }

    /**
     * returns a the <code>Collidable</code> top/north face of this.
     *
     * @see dwarf.gfx.Rectangle#NORTH_FACE
     *
     * @return the <code>Collidable</code> on the top/north face of the
     * <code>Rectangle</code>
     */
    public Collidable getNorthFace() {
        Rectangle rect = new Rectangle(
                this.getDimensions().getWidth(),
                10 * this.getDimensions().getHeight() / 100,
                super.getPosition(),
                STROKE, null
        );

        rect.setPosition(
                super.getPosition().getX(),
                super.getPosition().getY() + this.getDimensions().getHeight() - rect.getDimensions().getHeight()
        );

        return rect.getCollidable();
    }

    /**
     * returns a the <code>Collidable</code> right/east face of this.
     *
     * @see dwarf.gfx.Rectangle#EAST_FACE
     *
     * @return the <code>Collidable</code> on the right/east face of the
     * <code>Rectangle</code>
     */
    public Collidable getEastFace() {
        Rectangle rect = new Rectangle(
                10 * this.getDimensions().getWidth() / 100,
                this.getDimensions().getHeight(),
                super.getPosition(),
                STROKE, null
        );

        rect.setPosition(
                super.getPosition().getX() + this.getDimensions().getWidth() - rect.getDimensions().getWidth(),
                super.getPosition().getY()
        );

        return rect.getCollidable();
    }

    /**
     * returns a the <code>Collidable</code> bottom/south face of this.
     *
     * @see dwarf.gfx.Rectangle#SOUTH_FACE
     *
     * @return the <code>Collidable</code> on the top/north face of the
     * <code>Rectangle</code>
     */
    public Collidable getSouthFace() {
        return new Rectangle(
                this.getDimensions().getWidth(),
                10 * this.getDimensions().getHeight() / 100,
                super.getPosition(),
                STROKE, null
        ).getCollidable();
    }

    /**
     * returns a the <code>Collidable</code> left/west face of this.
     *
     * @see dwarf.gfx.Rectangle#WEST_FACE
     *
     * @return the <code>Collidable</code> on the left/west face of the
     * <code>Rectangle</code>
     */
    public Collidable getWestFace() {
        return new Rectangle(
                10 * this.getDimensions().getWidth() / 100,
                this.getDimensions().getHeight(),
                super.getPosition(),
                STROKE, null
        ).getCollidable();
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return new Rectangle(this);
    }
}
