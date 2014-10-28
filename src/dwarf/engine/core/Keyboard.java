package dwarf.engine.core;

public interface Keyboard {

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
}
