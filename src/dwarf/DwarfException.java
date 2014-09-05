package dwarf;

/**
 * This exception is supplied to make exception handling more generic for
 * Dwarf2D specific exceptions.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.Crashform
 * @see java.lang.Exception
 */
@SuppressWarnings("serial")
public class DwarfException extends java.lang.RuntimeException implements Cloneable {

    /**
     * Default constructor. Creates a new instance of
     * <code>DwarfException</code> without detail message.
     */
    public DwarfException() {
        super();
    }

    /**
     * Constructs an instance of <code>DwarfException</code> with the specified
     * detail message (msg).
     *
     * @param msg the detail message.
     */
    public DwarfException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>DwarfException</code> with the specified
     * detail message (msg) and cause.
     *
     * @param msg String identifier for exception
     * @param cause the cause of the error
     */
    public DwarfException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructs an instance of <code>DwarfException</code> with the specified
     * cause.
     *
     * @param cause the cause of the error
     */
    public DwarfException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new <code>DwarfException</code> with the specified detail
     * message (msg), cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     *
     * @param msg the detail message.
     * @param cause the cause. (A <code>null</code> value is permitted, and
     * indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled or
     * disabled
     * @param writableStackTrace whether or not the stack trace should be
     * writable
     */
    public DwarfException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(msg, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Creates a new object of the same class as this object.
     *
     * @exception OutOfMemoryError if there is not enough memory.
     * @throws java.lang.CloneNotSupportedException if clone is not supported
     * thought this should not happen.
     *
     * @return a clone of this instance.
     */
    @Override
    public DwarfException clone() throws CloneNotSupportedException {
        return new DwarfException(this);
    }

    public DwarfException get() {
        return this;
    }

    public void print() {
        System.err.println(this);
    }

    /**
     * Displays the error in a new crash form.
     *
     * @see dwarf.Crashform
     */
    public void display() {
        new dwarf.Crashform(this);
    }

    /**
     * returns the <code>DwarfException</code> as a new <code>Exception</code>.
     *
     * @see java.lang.Exception
     *
     * @return <code>this</code> as a <code>Exception</code>
     */
    public java.lang.Exception toException() {
        return new Exception(this);
    }

    /**
     * returns the <code>DwarfException</code> as a new
     * <code>LWJGLException</code>.
     *
     * @see org.lwjgl.LWJGLException
     *
     * @return <code>this</code> as a <code>LWJGLException</code>
     */
    public org.lwjgl.LWJGLException toLWJGLException() {
        return new org.lwjgl.LWJGLException(this);
    }

    /**
     * "Destroys" the game engine.
     */
    public void destroyEngine() {
        dwarf.engine.core.Engine.dispose();
    }
}
