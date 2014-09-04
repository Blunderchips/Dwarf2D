package dwarf.engine.core;

import java.util.Objects;

import dwarf.GameObject;
import dwarf.util.Point2D;
import dwarf.util.Vector2;

import static dwarf.util.Point2D.ZERO;

/**
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.GameObject
 * @see java.lang.Object
 * @see java.lang.Cloneable
 */
public class Camera extends java.lang.Object implements Cloneable, GameObject {

    /**
     * the default view port.
     */
    public static Camera mainCamera = new Camera();

    public static void setMainCamera(Camera mainCamera) {
        Camera.mainCamera = mainCamera;
    }

    public static Camera getMainCamera() {
        return Camera.mainCamera;
    }
    
    /**
     * the location of the camera.
     */
    private Point2D position;

    /**
     * Default constructor.
     */
    public Camera() {
        super();
        this.position = ZERO;
    }

    public Camera(Point2D position) {
        super();
        this.position = position;
    }

    public Camera(Camera camera) {
        super();
        this.position = camera.getPosition();
    }

    /**
     * Callback function used to update the state of the game every frame.
     */
    @Override
    public void update() {
    }

    /**
     * Callback function used to update the state of the game every frame.
     */
    @Override
    public void render() {
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public void translate(float deltaX, float deltaY) {
        this.position.translateX(deltaX);
        this.position.translateY(deltaY);
    }

    public void translateX(float deltaX) {
        this.position.translateX(deltaX);
    }

    public void translateY(float deltaY) {
        this.position.translateY(deltaY);
    }

    @Override
    public String toString() {
        return "Camera = {"
                + "position: " + getPosition() + ", "
                + "super: " + super.toString()
                + "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(getPosition());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }
        final Camera other = (Camera) obj;
        if (!Objects.equals(this.getPosition(), other.getPosition())) {
            return false;
        }
        return true;
    }

    public void gotoPos(Vector2 destination, float speed) {
        if (this.getPosition().getX() > destination.getX()) {
            this.getPosition().translateX(-speed);
        }
        if (this.getPosition().getX() < destination.getX()) {
            this.getPosition().translateX(speed);
        }
        if (this.getPosition().getY() < destination.getY()) {
            this.getPosition().translateY(speed);
        }
        if (this.getPosition().getY() > destination.getY()) {
            this.getPosition().translateY(-speed);
        }
    }

    public void gotoPos(Vector2 destination) {
        this.gotoPos(destination, 1);
    }

    public void gotoPos(double xPos, double yPos) {
        this.gotoPos(new Vector2(xPos, yPos), 1);
    }

    public void gotoPos(double xPos, double yPos, float speed) {
        this.gotoPos(new Vector2(xPos, yPos), speed);
    }

    public Vector2 getCenterPosition() {
        return new Vector2(
                this.getPosition().getX() + Window.getWidth() / 2,
                this.getPosition().getY() + Window.getHeight() / 2
        );
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Camera(this);
    }

}
