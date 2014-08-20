package dwarf;

import dwarf.engine.core.Window;
import dwarf.util.Vector2;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.lwjgl.LWJGLException;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Provides an interface to the user's mouse.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.engine.core.Input
 * @see org.lwjgl.input.Mouse
 */
public final class mouse {

    /**
     * you can not instantiate this class.
     */
    public mouse() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    public static final byte MOUSE_LEFT = 0x0;
    public static final byte MOUSE_RIGHT = 0x1;
    public static final byte MOUSE_MIDDLE = 0x2;

    public static final byte NUM_MOUSEBUTTONS = (byte) org.lwjgl.input.Mouse.getButtonCount();

    private static ArrayList<Byte> currentMouse;
    private static ArrayList<Byte> downMouse;
    private static ArrayList<Byte> upMouse;

    /**
     * initialization the mouse. The display must first have been created.
     * Initially, the mouse is not grabbed and the delta values are reported
     * with respect to the center of the display.
     */
    public static void init() {
        try {
            org.lwjgl.input.Mouse.create();
        } catch (LWJGLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", ERROR_MESSAGE
            );
            Game.close(new dwarf.DwarfException(ex));
        }

        mouse.currentMouse = new ArrayList<>();
        mouse.downMouse = new ArrayList<>();
        mouse.upMouse = new ArrayList<>();
    }

    public static void update() {
        upMouse.clear();

        for (byte i = 0; i < NUM_MOUSEBUTTONS; i++) {
            if (!isMouseDown(i) && currentMouse.contains(i)) {
                upMouse.add(i);
            }
        }

        downMouse.clear();

        for (byte i = 0; i < NUM_MOUSEBUTTONS; i++) {
            if (isMouseDown(i) && !currentMouse.contains(i)) {
                downMouse.add(i);
            }
        }

        currentMouse.clear();

        for (byte i = 0; i < NUM_MOUSEBUTTONS; i++) {
            if (isMouseDown(i)) {
                currentMouse.add(i);
            }
        }
    }

    public static void dispose() {
        org.lwjgl.input.Mouse.destroy();
    }

    public static Vector2 getMousePosition() {
        return new Vector2(org.lwjgl.input.Mouse.getX(), org.lwjgl.input.Mouse.getY());
    }

    /**
     * Sets the current position of the mouse.
     *
     * @param pos The new position of the mouse
     */
    public static void setMousePosition(Vector2 pos) {
        org.lwjgl.input.Mouse.setCursorPosition((int) pos.getX(), (int) pos.getY());
    }

    public static void setMousePosition(int new_xPos, int new_yPos) {
        setMousePosition(new Vector2(new_xPos, new_yPos));
    }

    public static void setCursor(boolean enabled) {
        org.lwjgl.input.Mouse.setGrabbed(!enabled);
    }

    public static boolean isCreated() {
        return org.lwjgl.input.Mouse.isCreated();
    }

    public static int getNumMouseButtons() {
        return mouse.NUM_MOUSEBUTTONS;
    }

    public static void reset() {
        mouse.currentMouse = new ArrayList<>();
        mouse.downMouse = new ArrayList<>();
        mouse.upMouse = new ArrayList<>();
    }

    public static void poll() {
        org.lwjgl.input.Mouse.poll();
    }

    /**
     * returns true if the mouse has a wheel if not it will return false.
     *
     * @return whether or not this mouse has wheel support
     */
    public static boolean hasWheel() {
        return org.lwjgl.input.Mouse.hasWheel();
    }

    //========================================================================
    // Mouse events
    //========================================================================
    
    /**
     * Checks whether a certain mouse button is down.
     *
     * @see org.lwjgl.input.Mouse#isButtonDown(int)
     *
     * @param mouseButton the key code of the button to be tested
     * @return true if the mouse button is down, otherwise it will return false.
     */
    public static boolean isMouseDown(int mouseButton) {
        return org.lwjgl.input.Mouse.isButtonDown((byte) mouseButton);
    }

    /**
     * checks if a mouse key is downs.
     *
     * @see dwarf.mouse#isMouseDown(int)
     * @see org.lwjgl.input.Mouse#isButtonDown(int)
     *
     * @param buttonName the name of the button to be tested
     * @return true if the mouse button is down, otherwise it will return false.
     */
    public static boolean isMouseDown(String buttonName) {
        return isMouseDown(mouse.getKeyCode(buttonName));
    }

    /**
     * checks if a mouse key is clicked.
     *
     * @param mouseButton the key code of the button to be tested
     * @return return upMouse.contains(upKeys)
     */
    public static boolean isMouseClicked(int mouseButton) {
        return downMouse.contains((byte) mouseButton);
    }

    /**
     * checks if a mouse key is clicked, callback function triggered when a
     * mouse button is pressed.
     *
     * @see dwarf.mouse#isMouseClicked(int)
     *
     * @param buttonName the name of the button to be tested
     * @return true if the mouse button is clicked, otherwise it will return
     * false.
     */
    public static boolean isMouseClicked(String buttonName) {
        return downMouse.contains(mouse.getKeyCode(buttonName));
    }

    /**
     * checks if the left button mouse key is clicked, callback function
     * triggered when a mouse button is pressed.
     *
     * @see dwarf.mouse#isMouseClicked(int)
     *
     * @return true is the left mouse button is clicked otherwise false
     */
    public static boolean isMouseClicked() {
        return downMouse.contains(MOUSE_LEFT);
    }

    /**
     * checks if a mouse key is released, callback function triggered when a
     * mouse button is released.
     *
     * @param mouseButton the key code of the button to be tested
     * @return true if the mouse button is realesed, otherwise it will return
     * false.
     */
    public static boolean isMouseRealesed(int mouseButton) {
        return upMouse.contains((byte) mouseButton);
    }

    /**
     * checks if a mouse key is released, callback function triggered when a
     * mouse button is released.
     *
     * @see dwarf.mouse#isMouseRealesed(int)
     *
     * @param buttonName the name of the button to be tested
     * @return true if the mouse button is realesed, otherwise it will return
     * false.
     */
    public static boolean isMouseRealesed(String buttonName) {
        return upMouse.contains(mouse.getKeyCode(buttonName));
    }

    /**
     * Gets a button's name.
     *
     * @param code The button
     * @throws IllegalArgumentException will throw if no suitable result is
     * found
     * @return a String with the button's human readable name in it or will
     * throw a IllegalArgumentException if the button is unnamed
     */
    private static byte getKeyCode(String code) throws IllegalArgumentException {
        switch (code) {
            case "left":
                return MOUSE_LEFT;
            case "right":
                return MOUSE_RIGHT;
            case "scroler":
                return MOUSE_MIDDLE;
            default:
                throw new IllegalArgumentException("keycode '" + code + "' is unknown");
        }
    }

    /**
     * Retrieves whether or not the mouse cursor is within the bounds of the
     * window. If the mouse cursor was moved outside the display during a drag,
     * then the result of calling this method will be true until the button is
     * released.
     *
     * @see org.lwjgl.input.Mouse#isInsideWindow()
     *
     * @return true if mouse is inside display, false otherwise.
     */
    public static boolean isInsideWindow() {
        return org.lwjgl.input.Mouse.isInsideWindow();
    }
}
