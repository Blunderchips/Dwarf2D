package dwarf;

import dwarf.engine.core.Window;
import dwarf.util.Vector2;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Handle mouse and keyboard input from the user.
 *
 * @author sid_th3_sl0th
 */
public final class Input {

    public Input() {
        // Prevents instantiation of this class.
        throw new Error(
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
     * backspace
     */
    public static final byte KEY_BACK = 0x0E;
    /**
     * - on main keyboard
     */
    public static final byte KEY_MINUS = 0x0C;
    /**
     * Enter on main keyboard
     */
    public static final byte KEY_RETURN = 0x1C;
    /**
     * Enter on main keyboard
     */
    public static final byte KEY_ENTER = 0x1C;
    /**
     * accent grave
     */
    public static final byte KEY_GRAVE = 0x29;
    /**
     * . on main keyboard
     */
    public static final byte KEY_PERIOD = 0x34;
    /**
     * Scroll Lock
     */
    public static final byte KEY_SCROLL = 0x46;
    /**
     * / on main keyboard
     */
    public static final byte KEY_SLASH = 0x35;
    /**
     * - on numeric keypad
     */
    public static final byte KEY_SUBTRACT = 0x4A;
    /**
     * * on numeric keypad
     */
    public static final byte KEY_MULTIPLY = 0x37;
    /**
     * left Alt
     */
    public static final byte KEY_LMENU = 0x38;
    /**
     * + on numeric keypad
     */
    public static final byte KEY_ADD = 0x4E;
    /**
     * . on numeric keypad
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
     * Japanese keyboard
     */
    public static final byte KEY_KANA = 0x70;
    /**
     * Japanese keyboard
     */
    public static final byte KEY_CONVERT = 0x79;
    /**
     * Japanese keyboard
     */
    public static final byte KEY_NOCONVERT = 0x7B;
    /**
     * Japanese keyboard
     */
    public static final byte KEY_YEN = 0x7D;
    /**
     * = on numeric keypad (NEC PC98)
     */
    public static final short KEY_NUMPADEQUALS = 0x8D;
    /**
     * Japanese keyboard
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
     * Japanese keyboard
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
     * Enter on numeric keypad
     */
    public static final short KEY_NUMPADENTER = 0x9C;
    /**
     * , on numeric keypad (NEC PC98)
     */
    public static final short KEY_NUMPADCOMMA = 0xB3;
    /**
     * / on numeric keypad
     */
    public static final short KEY_DIVIDE = 0xB5;
    /**
     * right Alt
     */
    public static final short KEY_RMENU = 0xB8;
    /**
     * Pause
     */
    public static final short KEY_PAUSE = 0xC5;
    /**
     * Home on arrow keypad
     */
    public static final short KEY_HOME = 0xC7;
    /**
     * UpArrow on arrow keypad
     */
    public static final short KEY_UP = 0xC8;
    /**
     * PgUp on arrow keypad
     */
    public static final short KEY_PRIOR = 0xC9;
    /**
     * LeftArrow on arrow keypad
     */
    public static final short KEY_LEFT = 0xCB;
    /**
     * RightArrow on arrow keypad
     */
    public static final short KEY_RIGHT = 0xCD;
    /**
     * End on arrow keypad
     */
    public static final short KEY_END = 0xCF;
    /**
     * DownArrow on arrow keypad
     */
    public static final short KEY_DOWN = 0xD0;
    /**
     * PgDn on arrow keypad
     */
    public static final short KEY_NEXT = 0xD1;
    /**
     * Insert on arrow keypad
     */
    public static final short KEY_INSERT = 0xD2;
    /**
     * Delete on arrow keypad
     */
    public static final short KEY_DELETE = 0xD3;
    /**
     * Left Windows key
     */
    public static final short KEY_LWIN = 0xDB;
    /**
     * Right Windows key
     */
    public static final short KEY_RWIN = 0xDC;
    /**
     * AppMenu key
     */
    public static final short KEY_APPS = 0xDD;

    public static final byte MOUSE_LEFT = 0x0;
    public static final byte MOUSE_RIGHT = 0x1;
    public static final byte MOUSE_MIDDLE = 0x2;

    public static final short NUM_KEYCODES = 0x100;
    public static final byte NUM_MOUSEBUTTONS = 0x5;

    private static ArrayList<Short> currentKeys;
    private static ArrayList<Short> downKeys;
    private static ArrayList<Short> upKeys;

    private static ArrayList<Byte> currentMouse;
    private static ArrayList<Byte> downMouse;
    private static ArrayList<Byte> upMouse;

    public static void init() {
        try {
            Keyboard.create();
            Mouse.create();
        } catch (LWJGLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", ERROR_MESSAGE
            );
            Game.close(ex);
        }

        Input.currentKeys = new ArrayList<>();
        Input.downKeys = new ArrayList<>();
        Input.upKeys = new ArrayList<>();
        Input.currentMouse = new ArrayList<>();
        Input.downMouse = new ArrayList<>();
        Input.upMouse = new ArrayList<>();
    }

    public static void update() {
        upKeys.clear();

        for (short i = 0x0; i < NUM_KEYCODES; i++) {
            if (!isKeyDown(i) && currentKeys.contains(i)) {
                upKeys.add(i);
            }
        }

        downKeys.clear();

        for (short i = 0x0; i < NUM_KEYCODES; i++) {
            if (isKeyDown(i) && !currentKeys.contains(i)) {
                downKeys.add(i);
            }
        }

        currentKeys.clear();

        for (short i = 0x0; i < NUM_KEYCODES; i++) {
            if (isKeyDown(i)) {
                currentKeys.add(i);
            }
        }

        upMouse.clear();

        for (byte i = 0x0; i < NUM_MOUSEBUTTONS; i++) {
            if (!isMouseDown(i) && currentMouse.contains(i)) {
                upMouse.add(i);
            }
        }

        downMouse.clear();

        for (byte i = 0x0; i < NUM_MOUSEBUTTONS; i++) {
            if (isMouseDown(i) && !currentMouse.contains(i)) {
                downMouse.add(i);
            }
        }

        currentMouse.clear();

        for (byte i = 0x0; i < NUM_MOUSEBUTTONS; i++) {
            if (isMouseDown(i)) {
                currentMouse.add(i);
            }
        }

    }

    public static void dispose() {
        Mouse.destroy();
        Keyboard.destroy();
    }

    //========================================================================
    // Keyboard events
    //========================================================================
    
    /**
     * checks if a key is pressed
     *
     * @param keyCode the key code of the key to be tested
     * @return Keyboard.isKeyPressed(keyCode)
     */
    public static boolean isKeyDown(int keyCode) {
        return Keyboard.isKeyDown(keyCode);
    }

    /**
     * checks if a key is pressed
     *
     * @param keyName the name of the key to be tested
     * @return Keyboard.isKeyPressed(keyCode)
     */
    public static boolean isKeyDown(String keyName) {
        return Keyboard.isKeyDown(Input.getKeyCode(keyName));
    }

    /**
     * checks if a key is down for a single frame
     *
     * @param keyCode the key code of the key to be tested
     * @return if a key is pressed down for that frame (bool)
     */
    public static boolean isKeyPressed(int keyCode) {
        return Input.downKeys.contains(keyCode);
    }

    /**
     * checks if a key is down for a single frame
     *
     * @param keyName the name of the key to be tested
     * @return if a key is pressed down for that frame (bool)
     */
    public static boolean isKeyPressed(String keyName) {
        return Input.downKeys.contains(Input.getKeyCode(keyName));
    }

    /**
     * checks if a key is released
     *
     * @param keyCode the key code of the key to be tested
     * @return if a key is released up for that frame (bool)
     */
    public static boolean isKeyReleased(int keyCode) {
        return Input.upKeys.contains(keyCode);
    }

    /**
     * checks if a key is released
     *
     * @param keyName the name of the key to be tested
     * @return if a key is released up for that frame (bool)
     */
    public static boolean isKeyReleased(String keyName) {
        return upKeys.contains(Input.getKeyCode(keyName));
    }

    //========================================================================
    // Mouse events
    //========================================================================
    
    /**
     * checks if a mouse key is down
     *
     * @param mouseButton the key code of the button to be tested
     * @return Mouse.isButtonDown(mouseButton)
     */
    public static boolean isMouseDown(int mouseButton) {
        return Mouse.isButtonDown(mouseButton);
    }

    /**
     * checks if a mouse key is down
     *
     * @param buttonName the name of the button to be tested
     * @return Mouse.isButtonDown(mouseButton)
     */
    public static boolean isMouseDown(String buttonName) {
        return Mouse.isButtonDown(Input.getKeyCode(buttonName));
    }

    /**
     * checks if a mouse key is clicked
     *
     * @param mouseButton the key code of the button to be tested
     * @return return upMouse.contains(upKeys)
     */
    public static boolean isMouseClicked(int mouseButton) {
        return Input.downMouse.contains(mouseButton);
    }

    /**
     * checks if a mouse key is clicked
     *
     * @param buttonName the name of the button to be tested
     * @return return upMouse.contains(upKeys)
     */
    public static boolean isMouseClicked(String buttonName) {
        return Input.downMouse.contains(Input.getKeyCode(buttonName));
    }

    /**
     * checks if the left button mouse key is clicked
     *
     * @return true is the left mouse button is clicked other wise false
     */
    public static boolean isMouseClicked() {
        return Input.downMouse.contains(MOUSE_LEFT);
    }

    /**
     * checks if a mouse key is released
     *
     * @param mouseButton the key code of the button to be tested
     * @return return upMouse.contains(upKeys)
     */
    public static boolean isMouseRealesed(int mouseButton) {
        return Input.upMouse.contains(mouseButton);
    }

    /**
     * checks if a mouse key is released
     *
     * @param buttonName the name of the button to be tested
     * @return return upMouse.contains(upKeys)
     */
    public static boolean isMouseRealesed(String buttonName) {
        return Input.upMouse.contains(Input.getKeyCode(buttonName));
    }

    public static Vector2 getMousePosition() {
        return new Vector2(Mouse.getX(), Mouse.getY());
    }

    public static void setMousePosition(Vector2 pos) {
        Mouse.setCursorPosition((int) pos.getX(), (int) pos.getY());
    }

    public static void setMousePosition(int new_xPos, int new_yPos) {
        setMousePosition(new Vector2(new_xPos, new_yPos));
    }

    public static void setCursor(boolean enabled) {
        Mouse.setGrabbed(!enabled);
    }

    public static boolean isCreated() {
        return Keyboard.isCreated() && Mouse.isCreated();
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
            case "left click":
                return MOUSE_LEFT;
            case "right click":
                return MOUSE_RIGHT;
            case "scroler click":
                return MOUSE_MIDDLE;
            default:
                throw new IllegalArgumentException("keycode '" + code + "' is unknown");
        }
    }

}
