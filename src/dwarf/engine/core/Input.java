package dwarf.engine.core;

import dwarf.keyboard;
import dwarf.mouse;

/**
 * Handle mouse and keyboard input from the user.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.keyboard
 * @see dwarf.mouse
 */
public final class Input {

    /**
     * you can not instantiate this class.
     */
    public Input() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    public static final void init() {
        keyboard.init();
        mouse.init();
    }

    public static void update() {
        keyboard.update();
        mouse.update();
    }

    public static void dispose() {
        keyboard.dispose();
        mouse.dispose();
    }
}
