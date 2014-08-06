package dwarf.graphics;

import dwarf.util.Vector2;

/**
 * A basic 4 sided shape.
 *
 * @author sid_th3_sl0th
 *
 * @see <a href='http://en.wikipedia.org/wiki/Quadrilateral'>wikipedia</a>
 * @see dwarf.graphics.Polygon
 */
public class Quadrilateral extends Polygon {

    public Quadrilateral(Vector2[] points, Vector2 position, String mode, Colour colour) {
        super(position, mode, colour);

        if (points != null) {
            if (points.length != 4) {
                throw new IllegalArgumentException("lol you stupid idiot, quadrilaterals have 4 sides and thus are made up of 4 points.");
            } else {
                super.setVertices(points);
            }
        }
    }

    public Quadrilateral(Vector2 pointA, Vector2 pointB, Vector2 pointC, Vector2 pointD, Vector2 position, String mode, Colour colour) {
        super(position, mode, colour);

        Vector2[] points = {
            pointA, pointB, pointC, pointD
        };

        super.setVertices(points);
    }

    public Quadrilateral(Quadrilateral quadrilateral) {
        super(quadrilateral.getPosition(), quadrilateral.getMode(), quadrilateral.getColour());
        super.setVertices(quadrilateral.getVertices());
    }

    @Override
    public void addPoint(Vector2 point) {
        System.err.println("This method is unsuported with the Quadrilateral class.");
    }

    @Override
    public Quadrilateral get() {
        return this;
    }
}
