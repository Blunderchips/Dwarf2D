package dwarf.graphics;

/**
 * utilities class for all util
 *
 * @author Matthew 'siD' Van der Bijl
 */
public final class util {

    private static Colour backgroundColour = new Colour();

    public util() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    /**
     * Set the background colour of the screen. The red,green,blue colour
     * components are byte in the range 0-255. Black is 0,0,0 and white is
     * 255,255,255. Colour will take effect the next time the screen is cleared.
     *
     * @param red red component (byte)
     * @param green green component (byte)
     * @param blue blue component (byte)
     */
    public static void setBackgroundColour(byte red, byte green, byte blue) {
        util.backgroundColour = new Colour(red, green, blue);
    }

    /**
     * Set the background colour of the screen. The red,green,blue colour
     * components are byte in the range 0-255. Black is 0,0,0 and white is
     * 255,255,255. Colour will take effect the next time the screen is cleared.
     *
     * @param red red component (byte)
     * @param green green component (byte)
     * @param blue blue component (byte)
     * @param alpha alpha component (byte)
     */
    public static void setBackgroundColour(byte red, byte green, byte blue, byte alpha) {

        util.backgroundColour = new Colour(red, green, blue, alpha);
    }

    public static void setBackgroundColour(Colour backgroundColour) {
        util.backgroundColour = backgroundColour;
    }

    public static Colour getBackgroundColour() {
        return util.backgroundColour;
    }

}
