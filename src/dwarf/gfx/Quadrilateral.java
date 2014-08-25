package dwarf.gfx;

import dwarf.util.Vector2;

/**
 * A basic 4 sided polygon.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Quadrilateral'>wikipedia</a>
 * @see dwarf.gfx.Polygon
 */
public class Quadrilateral extends Polygon {

    public Quadrilateral(Vector2[] vertices, Vector2 position, String mode, Colour colour) {
        super(position, mode, colour);

        if (vertices != null) {
            if (vertices.length != 4) {
                throw new IllegalArgumentException("lol you stupid idiot, quadrilaterals have 4 sides and thus are made up of 4 vertices.");
            } else {
                super.setVertices(vertices);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Quadrilateral(Vector2 vertexA, Vector2 vertexB, Vector2 vertexC, Vector2 vertexD, Vector2 position, String mode, Colour colour) {
        super(position, mode, colour);

        Vector2[] points = {
            vertexA, vertexB, vertexC, vertexD
        };

        super.setVertices(points);
    }

    public Quadrilateral(Quadrilateral quadrilateral) {
        super(quadrilateral.getPosition(), quadrilateral.getMode(), quadrilateral.getColour());
        super.setVertices(quadrilateral.getVertices());
    }

    @Override
    @Deprecated
    public void addPoint(Vector2 point) {
        super.addPoint(point);
    }

    @Override
    public Quadrilateral get() {
        return this;
    }

    @Override
    public void set(Vector2[] vertices, Vector2 position, String mode, Colour colour) {
        super.setVertices(vertices);
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        if (vertices != null) {
            if (vertices.length != 4) {
                throw new IllegalArgumentException("lol you stupid idiot, quadrilaterals have 4 sides and thus are made up of 4 vertices.");
            } else {
                super.setVertices(vertices);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void set(Vector2 vertexA, Vector2 vertexB, Vector2 vertexC, Vector2 vertexD, Vector2 position, String mode, Colour colour) {
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        Vector2[] points = {
            vertexA, vertexB, vertexC, vertexD
        };

        super.setVertices(points);
    }

    public void set(Quadrilateral quadrilateral) {
        super.setVertices(quadrilateral.getVertices());
        super.setPosition(quadrilateral.getPosition());
        super.setMode(quadrilateral.getMode());
        super.setColour(quadrilateral.getColour());
        super.setVertices(quadrilateral.getVertices());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Quadrilateral(this);
    }
}
