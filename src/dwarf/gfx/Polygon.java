package dwarf.gfx;

import java.util.Objects;

import dwarf.GameObject;
import dwarf.util.Vector2;

import static dwarf.gfx.draw.*;

/**
 * A basic shape with more than 3 sides.A rectilinear figure bounded by more
 * than three right lines is usually called a polygon. A polygon is said to be
 * convex when it has no re-entrant angle.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Polygon'>wikipedia</a>
 * @see dwarf.GameObject
 * @see dwarf.Collidable
 * @see dwarf.gfx.draw
 */
public class Polygon extends dwarf.Collidable implements GameObject, shapeConstants, Colours {

    public final static byte FILL = 0x0;
    public final static byte STROKE = 0x1;

    private Colour colour;
    private byte mode;

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
    public Polygon(Vector2 position, int mode, Colour colour) {
        super(position);
        this.init((byte) mode, colour);
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
    public Polygon(Vector2[] vertices, Vector2 position, int mode, Colour colour) {
        super(position);
        this.init(vertices, (byte) mode, colour);
    }

    public Polygon(Polygon polygon) {
        super(polygon.getPosition());
        this.init(polygon.getVertices(), (byte) polygon.getMode(), polygon.getColour());
    }

    /**
     * Constructs a new <code>Polygon</code> with no vertices.
     *
     * @param mode the mode of the <code>Polygon</code> to be created
     * @param colour the <code>Colour</code> of the <code>Polygon</code> to be
     * created
     */
    protected final void init(byte mode, Colour colour) {
        this.setColour(colour);
        this.setMode(mode);
    }

    /**
     * Constructs a new <code>Polygon</code> from a <code>Vector2</code> array
     * of parts of vertex points.
     *
     * @param vertices the vertices of the <code>Polygon</code> to be created.
     * @param mode the mode of the
     * @param colour the colour of the <code>Polygon</code> to be created.
     */
    protected final void init(Vector2[] vertices, byte mode, Colour colour) {
        this.setColour(colour);
        this.setMode(mode);
        super.setVertices(vertices);
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
     * @see dwarf.gfx.draw#fillPolygon(dwarf.util.Vector2[], dwarf.util.Vector2,
     * dwarf.gfx.Colour)
     * @see dwarf.gfx.draw#strokePolygon(dwarf.util.Vector2[],
     * dwarf.util.Vector2, dwarf.gfx.Colour)
     */
    @Override
    public void render() {
        if (isFill()) {
            draw.fillPolygon(super.getVertices(), super.getPosition(), this.getColour());
        } else {
            draw.strokePolygon(super.getVertices(), super.getPosition(), this.getColour());
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

    public void setMode(int mode) {
        if ((byte) mode == FILL || (byte) mode == STROKE) {
            this.mode = (byte) mode;
        } else {
            throw new dwarf.DwarfException();
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
        hash = 47 * hash + Objects.hashCode(getColour());
        hash = 47 * hash + Objects.hashCode(getMode());
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        } else if (!super.equals(obj)) {
            return false;
        }
        final Polygon other = (Polygon) obj;
        if (!Objects.equals(this.getColour(), other.getColour())) {
            return false;
        } else {
            return Objects.equals(this.getMode(), other.getMode());
        }
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

    public void set(Vector2 position, int mode, Colour colour) {
        this.init((byte) mode, colour);
        super.setPosition(position);
    }

    public void set(Vector2[] vertices, Vector2 position, int mode, Colour colour) {
        this.init(vertices, (byte) mode, colour);
        super.setPosition(position);
    }

    public void set(Polygon polygon) {
        this.init(polygon.getVertices(), (byte) polygon.getMode(), polygon.getColour());
        super.setPosition(polygon.getPosition());
    }

    @Override
    public Polygon clone() throws CloneNotSupportedException {
        return new Polygon(this);
    }
}
