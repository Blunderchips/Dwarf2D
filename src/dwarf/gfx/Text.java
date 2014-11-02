package dwarf.gfx;

import dwarf.GameObject;
import dwarf.util.Point2D;
import java.util.Objects;

public class Text implements GameObject {

    private String text;
    private Point2D position;
    private Colour colour;

    private boolean update;
    private boolean render;

    /**
     * Default constructor.
     */
    public Text() {
        super();
    }

    public Text(String msg, Point2D position, Colour colour) {
        super();

        this.update = true;
        this.render = true;

        this.text = msg;
        this.colour = colour;
        this.position = position;
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        if (getRender()) {
            dwarf.gfx.draw.basicText(text, position, colour);
        }
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
        return "Text[" + "text: " + text + ", position: " + position
                + ", colour: " + colour + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.text);
        hash = 67 * hash + Objects.hashCode(this.position);
        hash = 67 * hash + Objects.hashCode(this.colour);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Text txt = (Text) obj;

        if (!Objects.equals(this.text, txt.text)) {
            return false;
        } else if (!Objects.equals(this.position, txt.position)) {
            return false;
        } else if (!Objects.equals(this.colour, txt.colour)) {
            return false;
        }
        return true;
    }

    public boolean getUpdate() {
        return this.update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean getRender() {
        return this.render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }
}

