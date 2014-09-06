package dwarf.engine.core;

import java.nio.ByteBuffer;

import dwarf.gfx.draw;
import dwarf.util.Point2D;
import dwarf.DwarfException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static dwarf.gfx.background.getColour;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glTranslated;

/**
 * absolutely everything Window.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public final class Window {

    /**
     * you can not instantiate this class.
     */
    public Window() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    private static boolean vSync = true;
    private static boolean resizable = false;
    private static boolean fullscreen = false;

    private static java.awt.Canvas parent = null;

    public static Camera activeCamera = Camera.mainCamera;

    public static void update() {
        glClear(GL_COLOR_BUFFER_BIT);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

    public static void create(java.awt.Dimension dimensions, String title) throws DwarfException {
        Window.create((int) dimensions.getWidth(), (int) dimensions.getHeight(), title);
    }

    /**
     * Initialise the GL display.
     *
     * @param width The width of the display
     * @param height The height of the display
     * @param title The title of the display
     */
    public static void create(int width, int height, String title) throws DwarfException {
//        
//        Window.parent = new Canvas();
//        
//        Window.parent.setName(title);
//        Window.parent.setBackground(Color.white);
//        Window.parent.setMinimumSize(new Dimension(width, height));
//        Window.parent.setMaximumSize(new Dimension(width, height));
//        Window.parent.setPreferredSize(new Dimension(width, height));
//        Window.parent.setIgnoreRepaint(true);
//        Window.parent.setEnabled(true);
//        Window.parent.setFocusable(true);
//        Window.parent.setVisible(true);
//        
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle(title);
            Display.setVSyncEnabled(vSync);
            Display.setResizable(resizable);
            Display.setFullscreen(fullscreen);
            Display.setParent(parent);
            Display.setInitialBackground(0x0, 0x0, 0x0);
            Display.create();
        } catch (LWJGLException ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * "destroys" the window.
     */
    public static void dispose() {
        Display.destroy();
    }

    /**
     * clears the window.
     */
    public static void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glTranslated(Window.getActiveCamera().getPosition().getX(), Window.getActiveCamera().getPosition().getY(), 0);
        draw.fillRect(getWidth(), getHeight(), Window.getActiveCamera().getPosition(), 0, getColour());
    }

    /**
     * updates the window.
     */
    public static void render() {
        Display.update();
        Display.sync(64);
    }

    /**
     * @return Display.isCloseRequested()
     */
    public static boolean isCloseRequested() {
        return Display.isCloseRequested();
    }

    /**
     * Gets the width of the window as a integer (int).
     *
     * @return The width of the window.
     */
    public static int getWidth() {
        return Display.getWidth();
    }

    /**
     * Gets the height of the window as a integer (int).
     *
     * @return The height of the window.
     */
    public static int getHeight() {
        return Display.getHeight();
    }

    /**
     * Gets the window title.
     *
     * @return The current window title.
     */
    public static String getTitle() {
        return Display.getTitle();
    }

    public static boolean isFullscreen() {
        return Window.fullscreen;
    }

    public static boolean isVSync() {
        return Window.vSync;
    }

    public static boolean isResizable() {
        return Window.resizable;
    }

    /**
     * Checks if the window is dirty.
     *
     * @return Display.isDirty()
     */
    public static boolean isDirty() {
        return Display.isDirty();
    }

    public static String getVersion() {
        return Display.getVersion();
    }

    /**
     * Checks if the window is current.
     *
     * @return Display.isCurrent()
     */
    public static boolean isCurrent() throws DwarfException {
        try {
            return Display.isCurrent();
        } catch (LWJGLException ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * Checks if the window is active.
     *
     * @return Display.isActive)
     */
    public static boolean isActive() {
        return Display.isActive();
    }

    /**
     * Checks if the window has been created.
     *
     * @return True if the window has been created, false otherwise.
     */
    public static boolean isCreated() {
        return Display.isCreated();
    }

    /**
     * @return Display.wasResized()
     */
    public static boolean wasResized() {
        return Display.wasResized();
    }

    /**
     * Enters or exits fullscreen.
     *
     * @param fullscreen Whether to enter or exit fullscreen mode.
     */
    public static void setFullscreen(boolean fullscreen) throws DwarfException {
        Window.fullscreen = fullscreen;

        try {
            Display.setFullscreen(fullscreen);
        } catch (LWJGLException ex) {
            throw new DwarfException(ex);
        }
    }

    public static void setVSync(boolean vSync) {
        Window.vSync = vSync;
    }

    public static void setResizable(boolean resizable) {
        Window.resizable = resizable;
    }

    public static void setIcon(ByteBuffer[] icons) {
        Display.setIcon(icons);
    }

    /**
     * returns the parent to the Window.
     *
     * @see java.awt.Canvas
     *
     * @return the parent of the Window
     */
    public static java.awt.Canvas getParent() {
        return Window.parent;
    }

    public static void setTitle(String title) {
        Display.setTitle(title);
    }

    /**
     * Set the display configuration to the specified gamma, brightness and
     * contrast.
     *
     * @param gamma The gamma value
     * @param brightness The brightness value between -1.0 and 1.0, inclusive
     * @param contrast The contrast, larger than 0.0.
     */
    public static void setDisplayConfiguration(float gamma, float brightness, float contrast) throws dwarf.DwarfException {
        try {
            Display.setDisplayConfiguration(gamma, brightness, contrast);
        } catch (LWJGLException ex) {
            throw new dwarf.DwarfException(ex);
        }
    }

    public static Point2D getlocation() {
        return new Point2D(Display.getX(), Display.getY());
    }

    /**
     * Gets the width and height of the window.
     *
     * @return The width and height of the window as new <code>Vectro2</code>
     */
    public static java.awt.Dimension getDimensions() {
        return new java.awt.Dimension(Display.getWidth(), Display.getHeight());
    }

    public static Camera getActiveCamera() {
        return Window.activeCamera;
    }

    public static void setActiveCamera(Camera activeCamera) {
        Window.activeCamera = activeCamera;
    }
}
