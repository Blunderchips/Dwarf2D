package dwarf.gfx;

import dwarf.util.Point;
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

    public Quadrilateral(Point[] vertices, Point position, int mode, Colour colour) {
        super(position, mode, colour);

        if (vertices != null) {
            if (vertices.length != 4) {
                throw new IllegalArgumentException("lol you stupid idiot, quadrilaterals have 4 sides and thus are made up of 4 vertices/corners.");
            } else {
                super.setVertices(vertices);
            }
        }
    }

    public Quadrilateral(Point vertexA, Point vertexB, Point vertexC, Point vertexD, Point position, int mode, Colour colour) {
        super(position, mode, colour);

        Point[] points = {
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
    public void addPoint(Point point) {
        super.addPoint(point);
    }

    @Override
    public Quadrilateral get() {
        return this;
    }

    @Override
    public void set(Point[] vertices, Point position, int mode, Colour colour) {
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

    public void set(Point vertexA, Point vertexB, Point vertexC, Point vertexD, Point position, int mode, Colour colour) {
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        Point[] points = {
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
    public void addPoints(Point[] points) {
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
    public void setVertices(Point[] vertices) {
        super.setVertices(vertices);
    }

    public boolean isCyclicQuad() {
        return false; //TODO
    }

    public boolean isRectangle() {
        if (super.getType().equals("quadrilateral")) {
            return this instanceof Rectangle; //TODO       
        } else {
            return false;
        }
    }

    public boolean isSquare() {
        if (super.getType().equals("quadrilateral")) {
            return this instanceof Square; //TODO
        } else {
            return false;
        }
    }
}
