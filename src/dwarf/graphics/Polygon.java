package dwarf.graphics;

import dwarf.GameObject;
import dwarf.util.Vector2;
import java.util.Objects;

/**
 * A simple wrapper round the values required for a mutable <code>Polygon</code>
 * class. <br/>
 * In geometry a polygon is traditionally a plane figure that is bounded by a
 * finite chain of straight line segments closing in a loop to form a closed
 * chain or circuit. These segments are called its edges or sides, and the
 * points where two edges meet are the polygon's vertices (singular: vertex) or
 * corners. The interior of the polygon is sometimes called its body. An n-gon
 * is a polygon with n sides. A polygon is a 2-dimensional example of the more
 * general polytope in any number of dimensions.
 *
 * @author sid_th3_sl0th
 * @see dwarf.GameObject
 * @see dwarf.Collidable
 */
public class Polygon extends GameObject {

    private Colour colour;
    private String mode;

    /**
     * Constructs a new <code>Polygon</code> with no vertices.
     *
     * @param position the position of the <code>Polygon</code> on the screen
     * @param mode the mode of the <code>Polygon</code> to be created
     * @param colour the <code>Colour</code> of the <code>Polygon</code> to be
     * created
     */
    public Polygon(Vector2 position, String mode, Colour colour) {
        super(position);
        this.init(mode, colour);
    }

    /**
     * Constructs a new <code>Polygon</code> with no vertices.
     *
     * @param position the position of the <code>Polygon</code> on the screen
     * @param mode the mode of the <code>Polygon</code> to be created
     * @param colour the <code>Colour</code> of the <code>Polygon</code> to be
     * created
     */
    private void init(String mode, Colour colour) {
        this.setColour(colour);
        this.setMode(mode);
    }

    /**
     * Constructs a new <code>Polygon</code> from a <code>Vector2</code> array
     * of parts of vertex points.
     */
    private void init(Vector2[] vertices, String mode, Colour colour) {
        this.setColour(colour);
        this.setMode(mode);
        this.setPoints(vertices);
    }

    /**
     * Callback function used to update the state of the game every frame.
     */
    @Override
    public void update() {
    }

    /**
     * Callback function used to draw on the screen every frame.
     */
    @Override
    public void draw() {
        if (isFill()) {
            draw.fillPolygon(getPoints(), getCenter(), getColour());
        } else {
            draw.strokePolygon(getPoints(), getCenter(), getColour());
        }
    }

    /**
     * @return true if the Polygon's mode is equal to Fill and if stroke will
     * return false
     */
    public boolean isFill() {
        return this.mode.equals("fill");
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

    public void setMode(String mode) {
        if (mode.equals("fill") || mode.equals("stroke")) {
            this.mode = mode;
        }//else if (mode == null) {
        //  throw new NullPointerException("the mode can not be null. (stroke/fill only)");
        //} 
        else {
            throw new IllegalArgumentException("the state '" + mode + "' is unknown. (stroke/fill only)");
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

    public String getMode() {
        return this.mode;
    }
}
