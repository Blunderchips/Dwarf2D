package dwarf.engine.core;

/**
 * @author Matthew 'siD' Van der Bijl
 */
public final class physics {

    public physics() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    public final static double yFric = 0.6;
    public final static double xFric = 0.7;
    public final static double GRAVITY = 9.81627603;
}
