package dwarf.engine.core;

import dwarf.util.Vector2;
import java.util.Objects;

/**
 * @author Matthew 'siD' Van der Bijl
 */
public class Camera extends java.lang.Object {

    /**
     * the default view port.
     */
    public static Camera mainCamera = new Camera();

    public static Camera getMainCamera() {
        return Camera.mainCamera;
    }

    public static void setMainCamera(Camera mainCamera) {
        Camera.mainCamera = mainCamera;
    }

    private Vector2 position;

    public Camera() {
        super();
        this.position = new Vector2();
    }

    public Camera(Vector2 position) {
        super();
        this.position = position;
    }

    /**
     * Callback function used to update the state of the game every frame.
     */
    public void update() {

    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void translate(float deltaX, float deltaY) {
        this.position.changeX(deltaX);
        this.position.changeX(deltaY);
    }

    public void translateX(float deltaX) {
        this.position.changeX(deltaX);
    }

    public void translateY(float deltaY) {
        this.position.changeY(deltaY);
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
            this.getPosition().changeX(-speed);
        }
        if (this.getPosition().getX() < destination.getX()) {
            this.getPosition().changeX(speed);
        }
        if (this.getPosition().getY() < destination.getY()) {
            this.getPosition().changeY(speed);
        }
        if (this.getPosition().getY() > destination.getY()) {
            this.getPosition().changeY(-speed);
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
}