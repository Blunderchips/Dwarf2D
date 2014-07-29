package dwarf.engine.core;

import dwarf.util.Vector2;

/**
 * @author sid_th3_sl0th
 */
public final class camera {

    private static Vector2 position = new Vector2();

    public camera() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    public static Vector2 getPosition() {
        return camera.position;
    }

    public static void setPosition(Vector2 position) {
        camera.position = position;
    }

    public static void translate(float deltaX, float deltaY) {
        camera.position.changeX(deltaX);
        camera.position.changeX(deltaY);
    }
    
    public static void translateX(float deltaX) {
        camera.position.changeX(deltaX);
    }
    
    public static void translateY(float deltaY) {
        camera.position.changeY(deltaY);
    }
}
