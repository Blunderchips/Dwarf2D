package dwarf.gfx;

import dwarf.util.Point;

/**
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Triangle'>wikipedia</a>
 * @see dwarf.gfx.Polygon
 * @see dwarf.gfx.shapeConstants#SHAPE_TRIANGLE
 */
public class Triangle extends Polygon {

    /**
     * Default constructor.
     */
    public Triangle() {
        super();
    }

    public Triangle(Point position, int mode, Colour colour) {
        super(position, mode, colour);
    }

    public Triangle(Point vertexA, Point vertexB, Point vertexC, Point position, int mode, Colour colour) {
        super(position, mode, colour);

        Point[] points = {
            vertexA, vertexB, vertexC
        };

        super.setVertices(points);
    }

    public Triangle(Point[] vertices, Point position, int mode, Colour colour) {
        super(position, mode, colour);

        if (vertices != null) {
            if (vertices.length != 3) {
                throw new IllegalArgumentException("lol you stupid idiot, triangle have 3 sides and thus are made up of 3 vertices.");
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

            double a = Point.distanceSq(super.getVertices()[0], super.getVertices()[1]);
            double b = Point.distanceSq(super.getVertices()[1], super.getVertices()[2]);
            double c = Point.distanceSq(super.getVertices()[0], super.getVertices()[2]);

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

            double a = Point.distanceSq(super.getVertices()[0], super.getVertices()[1]);
            double b = Point.distanceSq(super.getVertices()[1], super.getVertices()[2]);
            double c = Point.distanceSq(super.getVertices()[0], super.getVertices()[2]);

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
    public void addPoint(Point point) {
        super.addPoint(point);
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

    public void set(Point vertexA, Point vertexB, Point vertexC, Point position, int mode, Colour colour) {
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        Point[] points = {
            vertexA, vertexB, vertexC
        };

        super.setVertices(points);
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

    public boolean isCongruent(Triangle t) {
        return false; //TODO
    }
    
    public boolean isSimilar(Triangle t) {
        return false; //TODO
    }
}
