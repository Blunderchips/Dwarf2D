package dwarf.gfx;

import dwarf.GameObject;
import dwarf.util.Point2D;

public class Text implements GameObject {

    private String text;
    private Point2D position;
    private Colour colour;

    /**
     * Default constructor.
     */
    public Text() {
        super();
    }

    public Text(String msg, Point2D position, Colour colour) {
        super();

        this.text = msg;
        this.colour = colour;
        this.position = position;
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        dwarf.gfx.draw.basicText(text, position, colour);
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Colour getColour() {
        return this.colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void append(String str) {
        this.text += str;
    }

    /**
     * Returns a string representation of the object.
     * <p>
     * In general, the toString method returns a string that "textually
     * represents" this object. The result should be a concise but informative
     * representation that is easy for a person to read. It is recommended that
     * all subclasses override this method.</p>
     *
     * @return a textually representation of this object
     */
    @Override
    public String toString() {
        return "Text[" + "text: " + text + ", position: " + position + ", colour: " + colour + "]";
    }
}
