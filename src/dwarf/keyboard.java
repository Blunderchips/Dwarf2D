package dwarf;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import dwarf.engine.core.Window;

import org.lwjgl.LWJGLException;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Provides an interface to the user's keyboard.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.engine.core.Input
 * @see dwarf.engine.core.Keyboard
 * @see org.lwjgl.input.Keyboard
 */
public final class keyboard implements dwarf.engine.core.Keyboard {

    /**
     * you can not instantiate this class.
     */
    public keyboard() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    private static ArrayList<Short> currentKeys;
    private static ArrayList<Short> downKeys;
    private static ArrayList<Short> upKeys;

    /**
     * initialization of the keyboard. The display must first have been created.
     * The reason for this is so the keyboard has a window to "focus" in.
     */
    public static void init() throws DwarfError {
        try {
            org.lwjgl.input.Keyboard.create();
        } catch (LWJGLException ex) {
            new dwarf.DwarfException(ex).display();
        }

        keyboard.currentKeys = new ArrayList<>();
        keyboard.downKeys = new ArrayList<>();
        keyboard.upKeys = new ArrayList<>();
    }

    public static void update() {
        upKeys.clear();

        for (short i = 0; i < NUM_KEYCODES; i++) {
            if (!isKeyDown(i) && currentKeys.contains(i)) {
                upKeys.add(i);
            }
        }

        downKeys.clear();

        for (short i = 0; i < NUM_KEYCODES; i++) {
            if (isKeyDown(i) && !currentKeys.contains(i)) {
                downKeys.add(i);
            }
        }

        currentKeys.clear();

        for (short i = 0; i < NUM_KEYCODES; i++) {
            if (isKeyDown(i)) {
                currentKeys.add(i);
            }
        }
    }

    public static void dispose() {
        org.lwjgl.input.Keyboard.destroy();
    }

    public static int getNumKeyCodes() {
        return keyboard.NUM_KEYCODES;
    }

    public static boolean isCreated() {
        return org.lwjgl.input.Keyboard.isCreated();
    }

    public static void reset() {
        keyboard.currentKeys = new ArrayList<>();
        keyboard.downKeys = new ArrayList<>();
        keyboard.upKeys = new ArrayList<>();
    }

    public static void poll() {
        org.lwjgl.input.Keyboard.poll();
    }

    //========================================================================
    // Keyboard events
    //========================================================================
    /**
     * Checks whether a certain key is down.
     *
     * @see org.lwjgl.input.Keyboard#isKeyDown(int)
     *
     * @param keyCode the key code of the key to be tested
     * @return true if the key is down, otherwise it will return false.
     */
    public static boolean isKeyDown(int keyCode) {
        return org.lwjgl.input.Keyboard.isKeyDown((short) keyCode);
    }

    /**
     * Checks whether a certain key is down.
     *
     * @see dwarf.keyboard#isKeyDown(int)
     * @see org.lwjgl.input.Keyboard#isKeyDown(int)
     *
     * @param keyName the name of the key to be tested
     * @return true if the key is down, otherwise it will return false.
     */
    public static boolean isKeyDown(String keyName) {
        return isKeyDown(getKeyCode(keyName));
    }

    /**
     * checks if a key is down for a single frame, callback function triggered
     * when a key is pressed.
     *
     * @param keyCode the key code of the key to be tested
     * @return if a key is pressed down for that frame (bool)
     */
    public static boolean isKeyPressed(int keyCode) {
        return downKeys.contains((short) keyCode);
    }

    /**
     * checks if a key is down for a single frame, callback function triggered
     * when a key is pressed.
     *
     * @see dwarf.keyboard#isKeyPressed(int)
     *
     * @param keyName the name of the key to be tested
     * @return if a key is pressed down for that frame (bool)
     */
    public static boolean isKeyPressed(String keyName) {
        return downKeys.contains(getKeyCode(keyName));
    }

    /**
     * checks if a key is released, callback function triggered when a key is
     * released.
     *
     * @param keyCode the key code of the key to be tested
     * @return if a key is released up for that frame (bool)
     */
    public static boolean isKeyReleased(int keyCode) {
        return upKeys.contains((short) keyCode);
    }

    /**
     * checks if a key is released, callback function triggered when a key is
     * released.
     *
     * @see dwarf.keyboard#isKeyReleased(int)
     *
     * @param keyName the name of the key to be tested
     * @return if a key is released up for that frame (bool)
     */
    public static boolean isKeyReleased(String keyName) {
        return upKeys.contains(getKeyCode(keyName));
    }

    /**
     * Gets a key's name.
     *
     * @param code The key
     * @throws IllegalArgumentException will throw if no suitable result is
     * found
     * @return a String with the key's human readable name in it or will throw a
     * IllegalArgumentException if the key is unnamed
     */
    private static short getKeyCode(String code) throws IllegalArgumentException {
        switch (code) {
            case "1":
                return KEY_1;
            case "2":
                return KEY_2;
            case "3":
                return KEY_3;
            case "4":
                return KEY_4;
            case "5":
                return KEY_5;
            case "6":
                return KEY_6;
            case "7":
                return KEY_7;
            case "8":
                return KEY_8;
            case "9":
                return KEY_9;
            case "0":
                return KEY_0;
            case "equals":
                return KEY_EQUALS;
            case "tab":
                return KEY_TAB;
            case "q":
                return KEY_Q;
            case "w":
                return KEY_W;
            case "e":
                return KEY_E;
            case "r":
                return KEY_R;
            case "t":
                return KEY_T;
            case "y":
                return KEY_Y;
            case "u":
                return KEY_U;
            case "i":
                return KEY_I;
            case "o":
                return KEY_O;
            case "p":
                return KEY_P;
            case "left bracket":
                return KEY_LBRACKET;
            case "right bracket":
                return KEY_RBRACKET;
            case "a":
                return KEY_A;
            case "s":
                return KEY_S;
            case "d":
                return KEY_D;
            case "f":
                return KEY_F;
            case "g":
                return KEY_G;
            case "h":
                return KEY_H;
            case "j":
                return KEY_J;
            case "k":
                return KEY_K;
            case "l":
                return KEY_L;
            case "semicolon":
                return KEY_SEMICOLON;
            case "apostrophe":
                return KEY_APOSTROPHE;
            case "left shift":
                return KEY_LSHIFT;
            case "backslash":
                return KEY_BACKSLASH;
            case "z":
                return KEY_Z;
            case "x":
                return KEY_X;
            case "c":
                return KEY_C;
            case "v":
                return KEY_V;
            case "b":
                return KEY_B;
            case "n":
                return KEY_N;
            case "m":
                return KEY_M;
            case "commma":
                return KEY_COMMA;
            case "right shift":
                return KEY_RSHIFT;
            case "space":
                return KEY_SPACE;
            case "capital":
                return KEY_CAPITAL;
            case "F1":
                return KEY_F1;
            case "F2":
                return KEY_F2;
            case "F3":
                return KEY_F3;
            case "F4":
                return KEY_F4;
            case "F5":
                return KEY_F5;
            case "F6":
                return KEY_F6;
            case "F7":
                return KEY_F7;
            case "F8":
                return KEY_F8;
            case "F9":
                return KEY_F9;
            case "F10":
                return KEY_F10;
            case "numlock":
                return KEY_NUMLOCK;
            case "numpad7":
                return KEY_NUMPAD7;
            case "numpad8":
                return KEY_NUMPAD8;
            case "numpad9":
                return KEY_NUMPAD9;
            case "numpad4":
                return KEY_NUMPAD4;
            case "numpad5":
                return KEY_NUMPAD5;
            case "numpad6":
                return KEY_NUMPAD6;
            case "numpad1":
                return KEY_NUMPAD1;
            case "numpad2":
                return KEY_NUMPAD2;
            case "numpad3":
                return KEY_NUMPAD3;
            case "numpad0":
                return KEY_NUMPAD0;
            case "F11":
                return KEY_F11;
            case "F12":
                return KEY_F12;
            case "right control":
                return KEY_RCONTROL;
            case "sysrq":
                return KEY_SYSRQ;
            case "power":
                return KEY_POWER;
            case "sleep":
                return KEY_SLEEP;
            case "backspace":
                return KEY_BACK;
            case "minus":
                return KEY_MINUS;
            case "return":
                return KEY_RETURN;
            case "enter":
                return KEY_ENTER;
            case "accent grave":
                return KEY_GRAVE;
            case "period":
                return KEY_PERIOD;
            case "Scroll Lock":
                return KEY_SCROLL;
            case "slash":
                return KEY_SLASH;
            case "subtract":
                return KEY_SLASH;
            case "multiply":
                return KEY_MULTIPLY;
            case "left alt":
                return KEY_LMENU;
            case "add":
                return KEY_ADD;
            case "decimal":
                return KEY_DECIMAL;
            case "F13":
                return KEY_F13;
            case "F14":
                return KEY_F14;
            case "F15":
                return KEY_F15;
            case "kana":
                return KEY_KANA;
            case "convert":
                return KEY_CONVERT;
            case "noconvert":
                return KEY_NOCONVERT;
            case "yen":
                return KEY_YEN;
            case "numpadequals":
                return KEY_NUMPADEQUALS;
            case "circumflex":
                return KEY_CIRCUMFLEX;
            case "at":
                return KEY_AT;
            case "colon":
                return KEY_COLON;
            case "underline":
                return KEY_UNDERLINE;
            case "kanji":
                return KEY_KANJI;
            case "stop":
                return KEY_STOP;
            case "ax":
                return KEY_AX;
            case "unlabeled":
                return KEY_UNLABELED;
            case "numpad enter":
                return KEY_NUMPADENTER;
            case "numpad comma":
                return KEY_NUMPADCOMMA;
            case "divide":
                return KEY_DIVIDE;
            case "right menu":
                return KEY_RMENU;
            case "pause":
                return KEY_PAUSE;
            case "home":
                return KEY_HOME;
            case "up":
                return KEY_UP;
            case "prior":
                return KEY_PRIOR;
            case "left":
                return KEY_LEFT;
            case "right":
                return KEY_RIGHT;
            case "end":
                return KEY_END;
            case "down":
                return KEY_DOWN;
            case "next":
                return KEY_NEXT;
            case "insert":
                return KEY_INSERT;
            case "delete":
                return KEY_DELETE;
            case "left windows":
                return KEY_LWIN;
            case "right windows":
                return KEY_RWIN;
            case "app menu":
                return KEY_APPS;
            default:
                throw new IllegalArgumentException("keycode '" + code + "' is unknown");
        }
    }

}
