package dwarf.engine.core;

/**
 * @author Matthew 'siD' Van der Bijl
 */
public final class physics {

    /**
     * you can not instantiate this class.
     */
    public physics() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    public final static double yFric = 0.6;
    public final static double xFric = 0.7;
    public final static double GRAVITY = 9.81627603;
}
