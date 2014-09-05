package dwarf;

/**
 * An <code>DwarfError</code> is a subclass of <code>DwarfException</code> that
 * indicates serious problems that a reasonable application should not try to
 * catch. When a <code>DwarfError</code> is created the <code>Engine</code> is
 * destroyed.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Exception
 * @see java.lang.Error
 *
 * @see dwarf.Crashform
 * @see dwarf.engine.core.Engine#dispose()
 */
@SuppressWarnings("serial")
public class DwarfError extends java.lang.Error implements Cloneable {

    /**
     * Default constructor. Creates a new instance of <code>DwarfError</code>
     * without detail message. Will "destroy" the <code>Engine</code>.
     */
    public DwarfError() {
        super();
    }

    /**
     * Constructs an instance of <code>DwarfError</code> with the specified
     * detail message (msg). Will "destroy" the <code>Engine</code>.
     *
     * @param msg the detail message.
     */
    public DwarfError(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>DwarfError</code> with the specified
     * detail message (msg) and cause. Will "destroy" the <code>Engine</code>.
     *
     * @param msg String identifier for exception
     * @param cause the cause of the error
     */
    public DwarfError(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructs an instance of <code>DwarfError</code> with the specified
     * cause. Will "destroy" the <code>Engine</code>.
     *
     * @param cause the cause of the error
     */
    public DwarfError(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new <code>DwarfError</code> with the specified detail
     * message (msg), cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled. Will "destroy" the <code>Engine</code>.
     *
     * @param msg the detail message.
     * @param cause the cause. (A <code>null</code> value is permitted, and
     * indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled or
     * disabled
     * @param writableStackTrace whether or not the stack trace should be
     * writable
     */
    public DwarfError(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
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
    public DwarfError clone() throws CloneNotSupportedException {
        return new DwarfError(this);
    }

    public DwarfError get() {
        return this;
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
     * "Destroys" the game engine.
     */
    public void destroyEngine() {
        dwarf.engine.core.Engine.dispose();
    }
}
