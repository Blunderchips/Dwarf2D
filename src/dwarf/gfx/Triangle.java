package dwarf.gfx;

import dwarf.util.Point2D;
import dwarf.DwarfException;

/**
 * A triangle is a polygon with three sides/edges and three vertices/corners. (A
 * basic 3 sided polygon)
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Triangle'>wikipedia</a>
 * @see dwarf.gfx.Polygon
 * @see dwarf.gfx.shapeConstants#SHAPE_TRIANGLE
 */
@SuppressWarnings("serial")
public class Triangle extends Polygon {

    /**
     * Default constructor.
     */
    public Triangle() {
        super();
    }

    public Triangle(Point2D position, int mode, Colour colour) {
        super(position, mode, colour);
    }

    public Triangle(Point2D vertexA, Point2D vertexB, Point2D vertexC, Point2D position, int mode, Colour colour) {
        super(position, mode, colour);

        Point2D[] vertices = {
            vertexA, vertexB, vertexC
        };

        super.setVertices(vertices);
    }

    public Triangle(Point2D[] vertices, Point2D position, int mode, Colour colour) {
        super(position, mode, colour);

        if (vertices != null) {
            if (vertices.length != 3) {
                throw new DwarfException("illegal argument");
            } else {
                super.setVertices(vertices);
            }
        }
    }

    public Triangle(Triangle triangle) {
        super(triangle.getVertices(), triangle.getPosition(), triangle.getMode(), triangle.getColour());
    }

    public boolean isRightAngledTriangle() {
        if (super.getType().equals("triangle")) {

            double a = Point2D.distanceSq(super.getVertices()[0], super.getVertices()[1]);
            double b = Point2D.distanceSq(super.getVertices()[1], super.getVertices()[2]);
            double c = Point2D.distanceSq(super.getVertices()[0], super.getVertices()[2]);

            if (a == b + c) {
                return true;
            }
            if (c == a + b) {
                return true;
            }
            if (b == a + c) {
                return true;
            }
        }

        return false;
    }

    public boolean isIsosTriangle() {
        if (super.getType().equals("triangle")) {

            double a = Point2D.distanceSq(super.getVertices()[0], super.getVertices()[1]);
            double b = Point2D.distanceSq(super.getVertices()[1], super.getVertices()[2]);
            double c = Point2D.distanceSq(super.getVertices()[0], super.getVertices()[2]);

            if (a == b) {
                return true;
            }
            if (c == a) {
                return true;
            }
            if (b == c) {
                return true;
            }
        }

        return false;
    }

    @Override
    @Deprecated
    public void addPoint(Point2D point) {
        super.addPoint(point);
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
    public void setVertices(double[] xPoints, double[] yPoints) throws DwarfException {
        if (xPoints.length == yPoints.length && xPoints.length == 3) {
            super.setVertices(xPoints, yPoints);
        } else {
            throw new DwarfException("illegal argument");
        }
    }

    @Override
    public void setVertices(java.awt.Polygon p) throws DwarfException {
        if (p.npoints == 3) {
            super.setVertices(p);
        } else {
            throw new DwarfException("illegal argument");
        }
    }

    @Override
    public void setVertices(Point2D[] vertices) throws DwarfException {
        if (vertices.length == 3) {
            super.setVertices(vertices);
        } else {
            throw new DwarfException("illegal argument");
        }
    }

    public void set(Point2D vertexA, Point2D vertexB, Point2D vertexC, Point2D position, int mode, Colour colour) {
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        Point2D[] vertices = {
            vertexA, vertexB, vertexC
        };

        super.setVertices(vertices);
    }

    public void set(Triangle triangle) {
        super.setVertices(triangle.getVertices());
        super.setPosition(triangle.getPosition());
        super.setMode(triangle.getMode());
        super.setColour(triangle.getColour());
    }

    @Override
    public Triangle clone() throws CloneNotSupportedException {
        return new Triangle(this);
    }

    @Override
    public Triangle get() {
        return this;
    }

    /**
     * TODO
     */
    @Deprecated
    public boolean isCongruent(Triangle t) {
        return false; //TODO
    }

    /**
     * TODO
     */
    @Deprecated
    public boolean isSimilar(Triangle t) {
        return false; //TODO
    }

}
