package dwarf.gfx;

import dwarf.util.Vector2;

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

    public Triangle(Vector2 position, int mode, Colour colour) {
        super(position, mode, colour);
    }

    public Triangle(Vector2 vertexA, Vector2 vertexB, Vector2 vertexC, Vector2 position, int mode, Colour colour) {
        super(position, mode, colour);

        Vector2[] points = {
            vertexA, vertexB, vertexC
        };

        super.setVertices(points);
    }

    public Triangle(Vector2[] vertices, Vector2 position, int mode, Colour colour) {
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

            double a = Vector2.distanceSq(super.getVertices()[0], super.getVertices()[1]);
            double b = Vector2.distanceSq(super.getVertices()[1], super.getVertices()[2]);
            double c = Vector2.distanceSq(super.getVertices()[0], super.getVertices()[2]);

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

            double a = Vector2.distanceSq(super.getVertices()[0], super.getVertices()[1]);
            double b = Vector2.distanceSq(super.getVertices()[1], super.getVertices()[2]);
            double c = Vector2.distanceSq(super.getVertices()[0], super.getVertices()[2]);

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
    public void addPoint(Vector2 point) {
        super.addPoint(point);
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

    public void set(Vector2 vertexA, Vector2 vertexB, Vector2 vertexC, Vector2 position, int mode, Colour colour) {
        super.setPosition(position);
        super.setMode(mode);
        super.setColour(colour);

        Vector2[] points = {
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
}
