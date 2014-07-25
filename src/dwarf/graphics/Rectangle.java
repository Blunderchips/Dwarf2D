package dwarf.graphics;

import dwarf.engine.core.Collidable;
import dwarf.util.Vector2;

/**
 * @author sid_th3_sl0th
 */
public class Rectangle extends Quadrilateral {

    public static final byte NORTH_FACE = 0x0;
    public static final byte EAST_FACE = 0x1;
    public static final byte SOUTH_FACE = 0x2;
    public static final byte WEST_FACE = 0x3;

    private Vector2 size;

    public Rectangle(float width, float height, Vector2 position, String state, Colour colour) {
        super(null, position, state, colour);
        this.setPoints(width, height);
    }

    public Rectangle(double width, double height, Vector2 position, String state, Colour colour) {
        super(null, position, state, colour);
        this.setPoints(width, height);
    }

    public Rectangle(Vector2 size, Vector2 position, String state, Colour colour) {
        super(null, position, state, colour);
        this.setPoints(size.getX(), size.getY());
    }

    private void setPoints(double width, double height) {
//        this.addPoint(new Vector2(0, 0));
//        this.addPoint(new Vector2(0, height));
//        this.addPoint(new Vector2(width, height));
//        this.addPoint(new Vector2(width, 0));

        this.size = new Vector2(width, height);

        // --
        Vector2[] vertices = {
            new Vector2(0, 0),
            new Vector2(0, height),
            new Vector2(width, height),
            new Vector2(width, 0)
        };
        // --

        super.setPoints(vertices);
    }

    public float getArea() {
        return (float) (this.size.getX() * this.size.getY());
    }

    public Vector2 getSize() {
        return this.size;
    }

    public void setSize(Vector2 size) {
        this.setPoints(size.getX(), size.getY());
    }

    public void setSize(float width, float height) {
        this.setPoints(width, height);
    }

    public boolean intersects(int face, Collidable coll) {
        Collidable collFace = new Collidable(getPosition());

        switch (face) {
            case NORTH_FACE:

                Vector2[] salami = {
                    new Vector2(0, this.getSize().getY()),
                    new Vector2(0, this.getSize().getY() - (10 * this.getSize().getY() / 100)),
                    new Vector2(this.getSize().getX(), this.getSize().getY() - (10 * this.getSize().getY() / 100)),
                    new Vector2(this.getSize().getX(), this.getSize().getY())
                };

                collFace.setPoints(salami);

                return collFace.intersects(coll);

            case EAST_FACE:

                Vector2[] tuna = {
                    new Vector2(this.getSize().getX(), 0),
                    new Vector2(this.getSize().getX() - (10 * this.getSize().getX() / 100), 0),
                    new Vector2(this.getSize().getX() - (10 * this.getSize().getX() / 100), this.getSize().getY()),
                    new Vector2(this.getSize().getX(), this.getSize().getY())
                };

                collFace.setPoints(tuna);

                return collFace.intersects(coll);

            case SOUTH_FACE:

                Vector2[] bacon = {
                    new Vector2(0, 0),
                    new Vector2(0, (10 * this.getSize().getY() / 100)),
                    new Vector2(this.getSize().getX(), (10 * this.getSize().getY() / 100)),
                    new Vector2(this.getSize().getX(), 0)
                };

                collFace.setPoints(bacon);

                return collFace.intersects(coll);

            case WEST_FACE:

                Vector2[] ham = {
                    new Vector2(0, 0),
                    new Vector2((10 * this.getSize().getX() / 100), 0),
                    new Vector2((10 * this.getSize().getX() / 100), this.getSize().getY()),
                    new Vector2(0, this.getSize().getY())
                };

                collFace.setPoints(ham);
                
                return collFace.intersects(coll);

            default:
                System.err.println("the face '" + face + "' is not reconized");
                break;
        }

        return false;
    }
}
