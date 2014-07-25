package dwarf.graphics;

import dwarf.engine.core.GameObject;
import dwarf.util.Vector2;
import java.util.Objects;

/**
 * A simple wrapper round the values required for a mutable Polygon class
 *
 * @author sid_th3_sl0th
 */
public class Polygon extends GameObject {

    private Colour colour;
    private String state;

    public Polygon(Vector2 position, String state, Colour colour) {
        super(position);
        this.init(state, colour);
    }

    private void init(String state, Colour colour) {
        this.setColour(colour);
        this.setState(state);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        if (isFill()) {
            draw.fillPolygon(getPoints(), getCenter(), getColour());
        } else {
            draw.strokePolygon(getPoints(), getCenter(), getColour());
        }
    }

    public boolean isFill() {
        return this.state.equals("fill");
    }

    public boolean isStroke() {
        return !isFill();
    }

    public Colour getColour() {
        return this.colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setState(String state) {
        if (state.equals("fill") || state.equals("stroke")) {
            this.state = state;
        }//else if (state == null) {
        //  throw new NullPointerException("the state can not be null. (stroke/fill only)");
        //} 
        else {
            throw new IllegalArgumentException("the state '" + state + "' is unknown. (stroke/fill only)");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.colour);
        hash = 47 * hash + Objects.hashCode(this.state);
        return hash;
    }

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
            return Objects.equals(this.getState(), other.getState());
        }
    }

    public String getState() {
        return this.state;
    }
}
