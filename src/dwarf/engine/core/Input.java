package dwarf.engine.core;

import dwarf.mouse;
import dwarf.keyboard;
import dwarf.DwarfError;

/**
 * Provides an interface to Handle all mouse and keyboard input from the user.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.keyboard
 * @see dwarf.mouse
 */
public interface Input {

    /**
     * initialises the keyboard and mouse. The display must first have been
     * created.
     *
     * @see dwarf.keyboard#init()
     * @see dwarf.mouse#init()
     *
     * @throws DwarfError will throw a <code>DwarfError</code> if a error
     * occurs.
     */
    public static void init() throws DwarfError {
        keyboard.init();
        mouse.init();
    }

    /**
     * updates the keyboard and mouse.
     *
     * @see dwarf.keyboard#update()
     * @see dwarf.mouse#update()
     */
    public static void update() {
        keyboard.update();
        mouse.update();
    }

    /**
     * "Destroys" the keyboard and mouse.
     *
     * @see dwarf.keyboard#dispose()
     * @see dwarf.mouse#dispose()
     */
    public static void dispose() {
        keyboard.dispose();
        mouse.dispose();
    }
    
    public static void poll() {
        keyboard.poll();
        mouse.poll();
    }
    
    public static void reset() {
        keyboard.reset();
        mouse.reset();
    }
    
    public static boolean isCreated() {
        return keyboard.isCreated() && mouse.isCreated();
    }
}
