package dwarf.gfx;

import java.awt.Color;

/**
 * utilities class for all background graphical operations.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public final class background {

    private static Colour backgroundColour = new Colour();

    /**
     * you can not instantiate this class.
     */
    public background() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
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
    public static void setColour(byte red, byte green, byte blue) {
        background.backgroundColour = new Colour(red, green, blue);
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
    public static void setColour(byte red, byte green, byte blue, byte alpha) {
        background.backgroundColour = new Colour(red, green, blue, alpha);
    }

    public static void setColour(Colour backgroundColour) {
        background.backgroundColour = backgroundColour;
    }

    public static void setColour(Color backgroundColour) {
        background.backgroundColour = new Colour(backgroundColour);
    }

    public static Colour getColour() {
        return background.backgroundColour;
    }

}
