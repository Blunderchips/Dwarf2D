package dwarf.graphics;

import dwarf.util.Vector2;

/**
 * @author sid_th3_sl0th
 */
public class Quadrilateral extends Polygon {

    public Quadrilateral(Vector2[] points, Vector2 position, String state, Colour colour) {
        super(position, state, colour);

        if (points != null) {
            if (points.length != 4) {
                throw new IllegalArgumentException("lol you stupid idiot, quadrilaterals have 4 sides and thus are made up of 4 points.");
            } else {
                super.setPoints(points);
            }
        }
    }

    public Quadrilateral(Vector2 pointA, Vector2 pointB, Vector2 pointC, Vector2 pointD, Vector2 position, String state, Colour colour) {
        super(position, state, colour);

        Vector2[] points = {
            pointA, pointB, pointC, pointD
        };

        super.setPoints(points);
    }

    @Override
    public void addPoint(Vector2 point) {
        System.err.println("This method is unsuported with Quadrilateral.");
    }
}
