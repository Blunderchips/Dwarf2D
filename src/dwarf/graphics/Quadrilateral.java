package dwarf.graphics;

import dwarf.util.Vector2;

/**
 * In Euclidean plane geometry, a quadrilateral is a polygon with four sides (or
 * edges) and four vertices or corners. Sometimes, the term quadrangle is used,
 * by analogy with triangle, and sometimes tetragon for consistency with
 * pentagon (5-sided), hexagon (6-sided) and so on.
 *
 * @author sid_th3_sl0th
 * @see dwarf.graphics.Polygon
 */
public class Quadrilateral extends Polygon {

    public Quadrilateral(Vector2[] points, Vector2 position, String mode, Colour colour) {
        super(position, mode, colour);

        if (points != null) {
            if (points.length != 4) {
                throw new IllegalArgumentException("lol you stupid idiot, quadrilaterals have 4 sides and thus are made up of 4 points.");
            } else {
                super.setPoints(points);
            }
        }
    }

    public Quadrilateral(Vector2 pointA, Vector2 pointB, Vector2 pointC, Vector2 pointD, Vector2 position, String mode, Colour colour) {
        super(position, mode, colour);

        Vector2[] points = {
            pointA, pointB, pointC, pointD
        };

        super.setPoints(points);
    }
    
    public Quadrilateral(Quadrilateral quadrilateral) {
        super(quadrilateral.getPosition(), quadrilateral.getMode(), quadrilateral.getColour());
        super.setPoints(quadrilateral.getPoints());
    }

    @Override
    public void addPoint(Vector2 point) {
        System.err.println("This method is unsuported with the Quadrilateral class.");
    }
}
