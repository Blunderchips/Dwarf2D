package dwarf.graphics;

/**
 * utilities class for all util
 *
 * @author sid_th3_sl0th
 */
public final class util {

    private static Colour backgroundColour = new Colour();

    public util() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    public static void setBackgroundColour(int red, int green, int blue) {
        util.backgroundColour = new Colour(red, green, blue);
    }

    public static void setBackgroundColour(int red, int green, int blue, int alpha) {

        util.backgroundColour = new Colour(red, green, blue, alpha);
    }

    public static void setBackgroundColour(Colour backgroundColour) {
        util.backgroundColour = backgroundColour;
    }

    public static Colour getBackgroundColour() {
        return util.backgroundColour;
    }

}
