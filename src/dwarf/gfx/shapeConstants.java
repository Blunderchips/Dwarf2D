package dwarf.gfx;

/**
 *
 * @author Matthew 'siD' Van der Bijl
 */
public interface shapeConstants {

    /**
     * 3 sided shape
     *
     * @see <a href='http://en.wikipedia.org/wiki/Triangle'>wikipedia</a>
     */
    public final static byte SHAPE_TRIANGLE = 0x3;
    /**
     * 4 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Square'>wikipedia</a>
     */
    public final static byte SHAPE_SQUARE = 0x4;
    /**
     * 5 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Pentagon'>wikipedia</a>
     */
    public final static byte SHAPE_PENTAGON = 0x5;
    /**
     * 6 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Hexagon'>wikipedia</a>
     */
    public final static byte SHAPE_HEXAGON = 0x6;
    /**
     * 7 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Heptagon'>wikipedia</a>
     */
    public final static byte SHAPE_HEPTAGON = 0x7;
    /**
     * 8 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Octagon'>wikipedia</a>
     */
    public final static byte SHAPE_OCTAGON = 0x8;
    /**
     * 9 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Nonagon'>wikipedia</a>
     */
    public final static byte SHAPE_NONAGON = 0x9;
    /**
     * 10 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Decagon'>wikipedia</a>
     */
    public final static byte SHAPE_DECAGON = 0xa;
    /**
     * 11 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Hendecagon'>wikipedia</a>
     */
    public final static byte SHAPE_HENDECAGON = 0xb;
    /**
     * 12 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Dodecagon'>wikipedia</a>
     */
    public final static byte SHAPE_DODECAGON = 0xc;
    /**
     * 13 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Tridecagon'>wikipedia</a>
     */
    public final static byte SHAPE_TRISKAIDECAGON = 0xd;
    /**
     * 14 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Tetradecagon'>wikipedia</a>
     */
    public final static byte SHAPE_TETRAKAIDECAGON = 0xe;
    /**
     * 15 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Pentadecagon'>wikipedia</a>
     */
    public final static byte SHAPE_PENTAKAIDECAGON = 0xf;
    /**
     * 16 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Hexadecagon'>wikipedia</a>
     */
    public final static byte SHAPE_HEXAKAIDECAGON = 0x10;
    /**
     * 17 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Heptakaidecagon'>wikipedia</a>
     */
    public final static byte SHAPE_HEPTAKAIDECAGON = 0x11;
    /**
     * 18 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Octadecagon'>wikipedia</a>
     */
    public final static byte SHAPE_OCTAKAIDECAGON = 0x12;
    /**
     * 19 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Enneadecagon'>wikipedia</a>
     */
    public final static byte SHAPE_ENNEAKAIDECAGON = 0x13;
    /**
     * 20 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Icosagon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSAGON = 0x14;
    /**
     * 21 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Icosikaihenagon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSIKAIHENAGON = 0x15;
    /**
     * 22 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Icosikaihexagon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSIKAIHEXAGON = 0x16;
    /**
     * 23 sided shape.
     *
     * @see <a
     * href='http://en.wikipedia.org/wiki/Icosikaitetragon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSIKAITRIGON = 0x17;
    /**
     * 24 sided shape.
     *
     * @see <a
     * href='http://en.wikipedia.org/wiki/Icosikaitetragon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSIKAITETRAGON = 0x18;
    /**
     * 30 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Triacontagon'>wikipedia</a>
     */
    public static final byte SHAPE_TRIACONTAGON = 0x1e;
    /**
     * 50 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Pentacontagon'>wikipedia</a>
     */
    public static final byte SHAPE_PENTACONTAGON = 0x32;
    /**
     * 60 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Circle'>wikipedia</a>
     */
    public final static byte SHAPE_CIRCLE = 0x3c;
    /**
     * 100 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Hectogon'>wikipedia</a>
     */
    public static final byte SHAPE_HECTOGON = 0x64;
    /**
     * 1000 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Chiliagon'>wikipedia</a>
     */
    public static final short SHAPE_CHILIAGON = 0x3e8;
    /**
     * 10000 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Myriagon'>wikipedia</a>
     */
    public static final short SHAPE_MYRIAGON = 0x2710;
    /**
     * 1000000 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Megagon'>wikipedia</a>
     */
    public static final short SHAPE_MEGAGON = 0x4240;
    /**
     * infinite sided shape. (9,223,372,036,854,775,807)
     *
     * @see <a href='http://en.wikipedia.org/wiki/Apeirogon'>wikipedia</a>
     */
    public static final long SHAPE_APEIROGON = Long.MAX_VALUE;
}
