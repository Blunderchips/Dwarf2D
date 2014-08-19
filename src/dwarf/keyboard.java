package dwarf;

import dwarf.engine.core.Window;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.lwjgl.LWJGLException;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Provides an interface to the user's keyboard.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.engine.core.Input
 * @see org.lwjgl.input.Keyboard
 */
public final class keyboard {

    /**
     * you can not instantiate this class.
     */
    public keyboard() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    public static final byte KEY_1 = 0x02;
    public static final byte KEY_2 = 0x03;
    public static final byte KEY_3 = 0x04;
    public static final byte KEY_4 = 0x05;
    public static final byte KEY_5 = 0x06;
    public static final byte KEY_6 = 0x07;
    public static final byte KEY_7 = 0x08;
    public static final byte KEY_8 = 0x09;
    public static final byte KEY_9 = 0x0A;
    public static final byte KEY_0 = 0x0B;
    public static final byte KEY_EQUALS = 0x0D;
    public static final byte KEY_TAB = 0x0F;
    public static final byte KEY_Q = 0x10;
    public static final byte KEY_W = 0x11;
    public static final byte KEY_E = 0x12;
    public static final byte KEY_R = 0x13;
    public static final byte KEY_T = 0x14;
    public static final byte KEY_Y = 0x15;
    public static final byte KEY_U = 0x16;
    public static final byte KEY_I = 0x17;
    public static final byte KEY_O = 0x18;
    public static final byte KEY_P = 0x19;
    public static final byte KEY_LBRACKET = 0x1A;
    public static final byte KEY_RBRACKET = 0x1B;
    public static final byte KEY_LCONTROL = 0x1D;
    public static final byte KEY_A = 0x1E;
    public static final byte KEY_S = 0x1F;
    public static final byte KEY_D = 0x20;
    public static final byte KEY_F = 0x21;
    public static final byte KEY_G = 0x22;
    public static final byte KEY_H = 0x23;
    public static final byte KEY_J = 0x24;
    public static final byte KEY_K = 0x25;
    public static final byte KEY_L = 0x26;
    public static final byte KEY_SEMICOLON = 0x27;
    public static final byte KEY_APOSTROPHE = 0x28;
    public static final byte KEY_LSHIFT = 0x2A;
    public static final byte KEY_BACKSLASH = 0x2B;
    public static final byte KEY_Z = 0x2C;
    public static final byte KEY_X = 0x2D;
    public static final byte KEY_C = 0x2E;
    public static final byte KEY_V = 0x2F;
    public static final byte KEY_B = 0x30;
    public static final byte KEY_N = 0x31;
    public static final byte KEY_M = 0x32;
    public static final byte KEY_COMMA = 0x33;
    public static final byte KEY_RSHIFT = 0x36;
    public static final byte KEY_SPACE = 0x39;
    public static final byte KEY_CAPITAL = 0x3A;
    public static final byte KEY_F1 = 0x3B;
    public static final byte KEY_F2 = 0x3C;
    public static final byte KEY_F3 = 0x3D;
    public static final byte KEY_F4 = 0x3E;
    public static final byte KEY_F5 = 0x3F;
    public static final byte KEY_F6 = 0x40;
    public static final byte KEY_F7 = 0x41;
    public static final byte KEY_F8 = 0x42;
    public static final byte KEY_F9 = 0x43;
    public static final byte KEY_F10 = 0x44;
    public static final byte KEY_NUMLOCK = 0x45;
    public static final byte KEY_NUMPAD7 = 0x47;
    public static final byte KEY_NUMPAD8 = 0x48;
    public static final byte KEY_NUMPAD9 = 0x49;
    public static final byte KEY_NUMPAD4 = 0x4B;
    public static final byte KEY_NUMPAD5 = 0x4C;
    public static final byte KEY_NUMPAD6 = 0x4D;
    public static final byte KEY_NUMPAD1 = 0x4F;
    public static final byte KEY_NUMPAD2 = 0x50;
    public static final byte KEY_NUMPAD3 = 0x51;
    public static final byte KEY_NUMPAD0 = 0x52;
    public static final byte KEY_F11 = 0x57;
    public static final byte KEY_F12 = 0x58;

    public static final short KEY_RCONTROL = 0x9d;
    public static final short KEY_SYSRQ = 0xB7;
    public static final short KEY_POWER = 0xDE;
    public static final short KEY_SLEEP = 0xDF;

    /**
     * backspace.
     */
    public static final byte KEY_BACK = 0x0E;
    /**
     * - on main keyboard.
     */
    public static final byte KEY_MINUS = 0x0C;
    /**
     * Enter on main keyboard.
     */
    public static final byte KEY_RETURN = 0x1C;
    /**
     * Enter on main keyboard.
     */
    public static final byte KEY_ENTER = 0x1C;
    /**
     * accent grave.
     */
    public static final byte KEY_GRAVE = 0x29;
    /**
     * . on main keyboard.
     */
    public static final byte KEY_PERIOD = 0x34;
    /**
     * Scroll Lock.
     */
    public static final byte KEY_SCROLL = 0x46;
    /**
     * / on main keyboard.
     */
    public static final byte KEY_SLASH = 0x35;
    /**
     * - on numeric keypad.
     */
    public static final byte KEY_SUBTRACT = 0x4A;
    /**
     * * on numeric keypad.
     */
    public static final byte KEY_MULTIPLY = 0x37;
    /**
     * left Alt.
     */
    public static final byte KEY_LMENU = 0x38;
    /**
     * + on numeric keypad.
     */
    public static final byte KEY_ADD = 0x4E;
    /**
     * . on numeric keypad.
     */
    public static final byte KEY_DECIMAL = 0x53;
    /**
     * NEC PC98
     */
    public static final byte KEY_F13 = 0x64;
    /**
     * NEC PC98
     */
    public static final byte KEY_F14 = 0x65;
    /**
     * NEC PC98
     */
    public static final byte KEY_F15 = 0x66;
    /**
     * Japanese keyboard.
     */
    public static final byte KEY_KANA = 0x70;
    /**
     * Japanese keyboard.
     */
    public static final byte KEY_CONVERT = 0x79;
    /**
     * Japanese keyboard.
     */
    public static final byte KEY_NOCONVERT = 0x7B;
    /**
     * Japanese keyboard.
     */
    public static final byte KEY_YEN = 0x7D;
    /**
     * = on numeric keypad. (NEC PC98)
     */
    public static final short KEY_NUMPADEQUALS = 0x8D;
    /**
     * Japanese keyboard.
     */
    public static final short KEY_CIRCUMFLEX = 0x90;
    /**
     * NEC PC98
     */
    public static final short KEY_AT = 0x91;
    /**
     * NEC PC98
     */
    public static final short KEY_COLON = 0x92;
    /**
     * NEC PC98
     */
    public static final short KEY_UNDERLINE = 0x93;
    /**
     * Japanese keyboard.
     */
    public static final short KEY_KANJI = 0x94;
    /**
     * NEC PC98
     */
    public static final short KEY_STOP = 0x95;
    /**
     * Japan AX
     */
    public static final short KEY_AX = 0x96;
    /**
     * J3100
     */
    public static final short KEY_UNLABELED = 0x97;
    /**
     * Enter on numeric keypad.
     */
    public static final short KEY_NUMPADENTER = 0x9C;
    /**
     * , on numeric keypad. (NEC PC98)
     */
    public static final short KEY_NUMPADCOMMA = 0xB3;
    /**
     * / on numeric keypad.
     */
    public static final short KEY_DIVIDE = 0xB5;
    /**
     * right Alt.
     */
    public static final short KEY_RMENU = 0xB8;
    /**
     * Pause.
     */
    public static final short KEY_PAUSE = 0xC5;
    /**
     * Home on arrow keypad.
     */
    public static final short KEY_HOME = 0xC7;
    /**
     * UpArrow on arrow keypad.
     */
    public static final short KEY_UP = 0xC8;
    /**
     * PgUp on arrow keypad.
     */
    public static final short KEY_PRIOR = 0xC9;
    /**
     * LeftArrow on arrow keypad.
     */
    public static final short KEY_LEFT = 0xCB;
    /**
     * RightArrow on arrow keypad.
     */
    public static final short KEY_RIGHT = 0xCD;
    /**
     * End on arrow keypad.
     */
    public static final short KEY_END = 0xCF;
    /**
     * DownArrow on arrow keypad.
     */
    public static final short KEY_DOWN = 0xD0;
    /**
     * PgDn on arrow keypad.
     */
    public static final short KEY_NEXT = 0xD1;
    /**
     * Insert on arrow keypad.
     */
    public static final short KEY_INSERT = 0xD2;
    /**
     * Delete on arrow keypad.
     */
    public static final short KEY_DELETE = 0xD3;
    /**
     * Left Windows key.
     */
    public static final short KEY_LWIN = 0xDB;
    /**
     * Right Windows key.
     */
    public static final short KEY_RWIN = 0xDC;
    /**
     * AppMenu key.
     */
    public static final short KEY_APPS = 0xDD;

    public static final short NUM_KEYCODES = (short) org.lwjgl.input.Keyboard.getKeyCount();

    private static ArrayList<Short> currentKeys;
    private static ArrayList<Short> downKeys;
    private static ArrayList<Short> upKeys;

    /**
     * initialization of the keyboard. The display must first have been created.
     * The reason for this is so the keyboard has a window to "focus" in.
     */
    public static void init() {
        try {
            org.lwjgl.input.Keyboard.create();
        } catch (LWJGLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", ERROR_MESSAGE
            );
            Game.close(ex);
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
     * @param keyCode the key code of the key to be tested
     * @return Keyboard.isKeyPressed(keyCode)
     */
    public static boolean isKeyDown(int keyCode) {
        return org.lwjgl.input.Keyboard.isKeyDown((short) keyCode);
    }

    /**
     * Checks whether a certain key is down.
     *
     * @param keyName the name of the key to be tested
     * @return Keyboard.isKeyPressed(keyCode)
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
     * @param keyName the name of the key to be tested
     * @return if a key is released up for that frame (bool)
     */
    public static boolean isKeyReleased(String keyName) {
        return upKeys.contains(getKeyCode(keyName));
    }

    private static short getKeyCode(String code) {
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
