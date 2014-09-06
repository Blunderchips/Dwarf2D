package dwarf.gfx;

/**
 * Provides a utilities class for all background graphical operations to the
 * user.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public final class background {

    /**
     * the colour of the background.
     */
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
     * @param red red component (double)
     * @param green green component (double)
     * @param blue blue component (double)
     */
    public static void setColour(double red, double green, double blue) {
        background.backgroundColour = new Colour(red, green, blue);
    }

    /**
     * Set the background colour of the screen. The red,green,blue colour
     * components are byte in the range 0-255. Black is 0,0,0 and white is
     * 255,255,255. Colour will take effect the next time the screen is cleared.
     *
     * @param red red component (double)
     * @param green green component (double)
     * @param blue blue component (double)
     * @param alpha alpha value (float)
     */
    public static void setColour(double red, double green, double blue, float alpha) {
        background.backgroundColour = new Colour(red, green, blue, alpha);
    }

    /**
     * sets the background to a inputed colour.
     *
     * @see dwarf.gfx.Colour
     *
     * @param backgroundColour the colour that the background is to be set to
     */
    public static void setColour(Colour backgroundColour) {
        background.backgroundColour = backgroundColour;
    }

    /**
     * sets the background to a inputed colour.
     *
     * @see java.awt.Color
     *
     * @param backgroundColour the colour that the background is to be set to
     */
    public static void setColour(java.awt.Color backgroundColour) {
        background.backgroundColour = new Colour(backgroundColour);
    }

    /**
     * returns the colour of the background as a <code>Colour</code>
     *
     * @return the background colour
     */
    public static Colour getColour() {
        return background.backgroundColour;
    }
}
