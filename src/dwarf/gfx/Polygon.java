package dwarf.gfx;

import java.util.Objects;

import dwarf.GameObject;
import dwarf.util.Point2D;
import dwarf.DwarfException;

/**
 * A basic figure made up of 3 or more sides/edges and 3 or more
 * vertices/corners.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Polygon'>wikipedia</a>
 * @see dwarf.GameObject
 * @see dwarf.Collidable
 * @see dwarf.gfx.draw
 * @see dwarf.gfx.shapeConstants
 * @see dwarf.gfx.Colours
 */
@SuppressWarnings("serial")
public class Polygon extends dwarf.Collidable implements GameObject, shapeConstants, Colours {

    public final static byte FILL = 0x0;
    public final static byte STROKE = 0x1;

    /**
     * the colour of the Polygon.
     */
    private Colour colour;
    /**
     * the mode of the Polygon. (stroke/fill)
     */
    private byte mode;

    private boolean update;
    private boolean render;

    /**
     * Default constructor.
     */
    public Polygon() {
        super();
    }

    /**
     * Constructs a new <code>Polygon</code> with no vertices.
     *
     * @param position the position of the <code>Polygon</code> on the screen
     * @param mode the mode of the <code>Polygon</code> to be created
     * @param colour the <code>Colour</code> of the <code>Polygon</code> to be
     * created
     */
    public Polygon(Point2D position, int mode, Colour colour) {
        super(position);

        this.update = true;
        this.render = true;

        this.setMode(mode);
        this.colour = colour;
    }

    /**
     * Constructs a new <code>Polygon</code> with no vertices.
     *
     * @param vertices the vertices of the <code>Polygon</code> to be created
     * @param position the position of the <code>Polygon</code> on the screen
     * @param mode the mode of the <code>Polygon</code> to be created
     * @param colour the <code>Colour</code> of the <code>Polygon</code> to be
     * created
     */
    public Polygon(Point2D[] vertices, Point2D position, int mode, Colour colour) {
        super(position, null);

        this.update = true;
        this.render = true;

        this.setMode(mode);
        this.colour = colour;

        super.setVertices(vertices);
    }

    public Polygon(Polygon polygon) {
        super(polygon.getPosition(), null);

        this.update = true;
        this.render = true;

        this.setMode(polygon.getMode());
        this.colour = polygon.getColour();

        super.setVertices(polygon.getVertices());
    }

    /**
     * Callback function used to update the state of the game every frame.
     */
    @Override
    public void update() {
    }

    /**
     * Callback function used to render the <code>Polygon</code> to the screen.
     *
     * @see dwarf.gfx.draw#fillPolygon(dwarf.util.Point2D[], dwarf.util.Point2D,
     * double, dwarf.gfx.Colour)
     * @see dwarf.gfx.draw#strokePolygon(dwarf.util.Point2D[],
     * dwarf.util.Point2D, double, dwarf.gfx.Colour)
     */
    @Override
    public void render() {
        if (getRender()) {
            if (isFill()) {
                draw.fillPolygon(super.getVertices(), super.getPosition(), 0, this.getColour());
            } else {
                draw.strokePolygon(super.getVertices(), super.getPosition(), 0, this.getColour());
            }
        }
    }

    /**
     * @return true if the Polygon's mode is equal to Fill and if stroke will
     * return false
     */
    public boolean isFill() {
        return this.getMode() == FILL;
    }

    /**
     * @return true if the Polygon's mode is equal to stroke and if fill will
     * return false
     */
    public boolean isStroke() {
        return !isFill();
    }

    public Colour getColour() {
        return this.colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /**
     * This method is called from within the constructor to initialize the
     * <code>Polygon</code>. WARNING: Do NOT modify this code.
     *
     * @throws DwarfException it the inputed mode in not recognised
     * @param mode the mode of the <code>Polygon</code>
     */
    public final void setMode(int mode) throws DwarfException {
        if ((byte) mode == FILL || (byte) mode == STROKE) {
            this.mode = (byte) mode;
        } else {
            throw new DwarfException("illegal argument");
        }
    }

    /**
     * Class Object is the root of the class hierarchy. Every class has Object
     * as a superclass. All objects, including arrays, implement the methods of
     * this class.
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(mode);
        hash = 47 * hash + Objects.hashCode(colour);
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @param obj the <code>Object</code> to be tested
     * @see java.lang.Object#equals(java.lang.Object)
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else if (!super.equals(obj)) {
            return false;
        }

        final Polygon other = (Polygon) obj;

        if (!Objects.equals(this.getColour(), other.getColour())) {
            return false;
        } else if (Objects.equals(this.getMode(), other.getMode())) {
            return false;
        }

        return true;
    }

    public int getMode() {
        return this.mode;
    }

    /**
     * Returns what type of shape <code>this</code> is.
     *
     * @see dwarf.gfx.shapeConstants
     *
     * @return what type of shape <code>this</code> is
     */
    public String getType() {
        switch (super.getNumVertices()) {
            case SHAPE_TRIANGLE:
                return "triangle";
            case SHAPE_SQUARE:
                return "quadrilateral";
            case SHAPE_PENTAGON:
                return "pentagon";
            case SHAPE_HEXAGON:
                return "hexagon";
            case SHAPE_HEPTAGON:
                return "heptagon";
            case SHAPE_OCTAGON:
                return "octagon";
            case SHAPE_NONAGON:
                return "nonagon";
            case SHAPE_DECAGON:
                return "decagon";
            case SHAPE_HENDECAGON:
                return "hendecagon";
            case SHAPE_DODECAGON:
                return "dodecagon";
            case SHAPE_TRISKAIDECAGON:
                return "tridecagon";
            case SHAPE_TETRAKAIDECAGON:
                return "tetradecagon";
            case SHAPE_PENTAKAIDECAGON:
                return "pentadecagon";
            case SHAPE_HEXAKAIDECAGON:
                return "hexadecagon";
            case SHAPE_HEPTAKAIDECAGON:
                return "heptakaidecagon";
            case SHAPE_OCTAKAIDECAGON:
                return "octadecagon";
            case SHAPE_ENNEAKAIDECAGON:
                return "enneadecagon";
            case SHAPE_ICOSAGON:
                return "icosagon";
            case SHAPE_ICOSIKAIHEXAGON:
                return "icosikaihexagon";
            case SHAPE_ICOSIKAITRIGON:
                return "icosikaitetragon";
            case SHAPE_ICOSIKAITETRAGON:
                return "icosikaitetragon";
            case SHAPE_CIRCLE:
                return "circle";
            default:
                return "polygon";
        }
    }

    @Override
    public Polygon get() {
        return this;
    }

    public void set(Point2D[] vertices, Point2D position, int mode, Colour colour) {
        this.update = true;
        this.render = true;

        this.setMode(mode);
        this.colour = colour;

        super.setVertices(vertices);
        super.setPosition(position);
    }

    public void set(Polygon polygon) {
        this.setMode(polygon.getMode());
        this.colour = polygon.getColour();

        super.setVertices(polygon.getVertices());
        super.setPosition(polygon.getPosition());
    }

    @Override
    public Polygon clone() throws CloneNotSupportedException {
        return new Polygon(this);
    }

    public double getPerimeter() {
        double result = Point2D.distance(getVertices()[0], getVertices()[getNumVertices() - 1]);

        for (int i = 0; i < getNumVertices(); i++) {
            try {
                result += Point2D.distance(getVertices()[i], getVertices()[i + 1]);
            } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                break;
            }
        }

        return result;
    }

    public boolean getRender() {
        return this.render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public boolean getUpdate() {
        return this.update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    //TODO
    /**
     * TODO, A cyclic quadrilateral is a four-sided figure with all four
     * vertices lying on the circumference of a circle.
     *
     * @return true if this is a cyclic quad
     */
    public boolean isCyclicQuad() {
        //if this is a rectangle it will be a cyclic quad.
        if (this.isRectangle()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRectangle() {
        if (this.getType().equals("quadrilateral")) {

            dwarf.util.Line[] sides = {
                new dwarf.util.Line(super.getVertices()[0], super.getVertices()[1]),
                new dwarf.util.Line(super.getVertices()[1], super.getVertices()[2]),
                new dwarf.util.Line(super.getVertices()[2], super.getVertices()[3]),
                new dwarf.util.Line(super.getVertices()[3], super.getVertices()[0])
            };

            return sides[0].length() == sides[1].length() && sides[1].length() == sides[3].length();
        } else {
            return false;
        }
    }

    public boolean isSquare() {
        if (this.getType().equals("quadrilateral")) {

            dwarf.util.Line[] sides = {
                new dwarf.util.Line(super.getVertices()[0], super.getVertices()[1]),
                new dwarf.util.Line(super.getVertices()[1], super.getVertices()[2]),
                new dwarf.util.Line(super.getVertices()[2], super.getVertices()[3]),
                new dwarf.util.Line(super.getVertices()[3], super.getVertices()[0])
            };

            if (sides[0].length() != sides[3].length()) {
                return false;
            } else {
                for (int i = 0; i < sides.length; i++) {
                    try {
                        if (sides[i].length() != sides[i + 1].length()) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                        break;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
