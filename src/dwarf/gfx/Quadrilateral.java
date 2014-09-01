package dwarf.gfx;

import dwarf.util.Vector2;

/**
 * A quadrilateral is a polygon with four sides/edges and four vertices/corners.
 * (A basic 4 sided polygon)
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Quadrilateral'>wikipedia</a>
 * @see dwarf.gfx.Polygon
 */
public class Quadrilateral extends Polygon {

    /**
     * Default constructor.
     */
    public Quadrilateral() {
        super();
    }

    public Quadrilateral(Vector2[] vertices, Vector2 position, int mode, Colour colour) {
        super(position, mode, colour);

        if (vertices != null) {
            if (vertices.length != 4) {
                throw new IllegalArgumentException("lol you stupid idiot, quadrilaterals have 4 sides and thus are made up of 4 vertices/corners.");
            } else {
                super.setVertices(vertices);
            }
        }
    }

    public Quadrilateral(Vector2 vertexA, Vector2 vertexB, Vector2 vertexC, Vector2 vertexD, Vector2 position, int mode, Colour colour) {
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
    public void set(Vector2[] vertices, Vector2 position, int mode, Colour colour) {
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        if (vertices != null) {
            if (vertices.length != 4) {
                throw new IllegalArgumentException("lol you stupid idiot, quadrilaterals have 4 sides and thus are made up of 4 vertices/corners.");
            } else {
                super.setVertices(vertices);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void set(Vector2 vertexA, Vector2 vertexB, Vector2 vertexC, Vector2 vertexD, Vector2 position, int mode, Colour colour) {
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
    }

    @Override
    public Quadrilateral clone() throws CloneNotSupportedException {
        return new Quadrilateral(this);
    }

    @Override
    @Deprecated
    public void addPoints(Vector2[] points) {
        super.addPoints(points);
    }

    @Override
    @Deprecated
    public void addPoint(double xPos, double yPos) {
        super.addPoint(xPos, yPos);
    }

    @Override
    @Deprecated
    public void setVertices(double[] xPoints, double[] yPoints) {
        super.setVertices(xPoints, yPoints);
    }

    @Override
    @Deprecated
    public void setVertices(java.awt.Polygon p) {
        super.setVertices(p);
    }

    @Override
    @Deprecated
    public void setVertices(Vector2[] vertices) {
        super.setVertices(vertices);
    }

    public boolean isCyclicQuad() {
        return false; //TODO
    }

    public boolean isRectangle() {
        return this instanceof Rectangle; //TODO
    }

    public boolean isSquare() {
        return this instanceof Square; //TODO
    }
}
