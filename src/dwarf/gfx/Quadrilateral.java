package dwarf.gfx;

import dwarf.util.Point2D;
import dwarf.DwarfException;

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

    public Quadrilateral(Point2D[] vertices, Point2D position, int mode, Colour colour) {
        super(position, mode, colour);

        if (vertices != null) {
            if (vertices.length != 4) {
                throw new IllegalArgumentException("illegal argument");
            } else {
                super.setVertices(vertices);
            }
        }
    }

    public Quadrilateral(Point2D vertexA, Point2D vertexB, Point2D vertexC, Point2D vertexD, Point2D position, int mode, Colour colour) {
        super(position, mode, colour);

        Point2D[] points = {
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
    public void addPoint(Point2D point) {
        super.addPoint(point);
    }

    @Override
    public Quadrilateral get() {
        return this;
    }

    @Override
    public void set(Point2D[] vertices, Point2D position, int mode, Colour colour) {
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        if (vertices != null) {
            if (vertices.length != 4) {
                throw new DwarfException("illegal argument");
            } else {
                super.setVertices(vertices);
            }
        } else {
            throw new DwarfException("illegal argument");
        }
    }

    public void set(Point2D vertexA, Point2D vertexB, Point2D vertexC, Point2D vertexD, Point2D position, int mode, Colour colour) {
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        Point2D[] points = {
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
    public void addPoints(Point2D[] points) {
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
    public void setVertices(Point2D[] vertices) {
        super.setVertices(vertices);
    }
}
