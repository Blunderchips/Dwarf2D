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
 * @see dwarf.DwarfException
 * @see dwarf.engine.core.Engine#dispose()
 */
@SuppressWarnings("serial")
public class DwarfError extends dwarf.DwarfException {

    /**
     * Default constructor. Creates a new instance of <code>DwarfError</code>
     * without detail message. Will "destroy" the <code>Engine</code>.
     *
     * @see dwarf.engine.core.Engine#dispose()
     */
    public DwarfError() {
        super();
        dwarf.engine.core.Engine.dispose();
    }

    /**
     * Constructs an instance of <code>DwarfError</code> with the specified
     * detail message (msg). Will "destroy" the <code>Engine</code>.
     *
     * @see dwarf.engine.core.Engine#dispose()
     *
     * @param msg the detail message.
     */
    public DwarfError(String msg) {
        super(msg);
        dwarf.engine.core.Engine.dispose();
    }

    /**
     * Constructs an instance of <code>DwarfError</code> with the specified
     * detail message (msg) and cause. Will "destroy" the <code>Engine</code>.
     *
     * @see dwarf.engine.core.Engine#dispose()
     *
     * @param msg String identifier for exception
     * @param cause the cause
     */
    public DwarfError(String msg, Throwable cause) {
        super(msg, cause);
        dwarf.engine.core.Engine.dispose();
    }

    /**
     * Constructs an instance of <code>DwarfError</code> with the specified
     * cause. Will "destroy" the <code>Engine</code>.
     *
     * @see dwarf.engine.core.Engine#dispose()
     *
     * @param cause the cause
     */
    public DwarfError(Throwable cause) {
        super(cause);
        dwarf.engine.core.Engine.dispose();
    }

    /**
     * Constructs a new <code>DwarfError</code> with the specified detail
     * message (msg), cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled. Will "destroy" the <code>Engine</code>.
     *
     * @see dwarf.engine.core.Engine#dispose()
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
        dwarf.engine.core.Engine.dispose();
    }

    /**
     * Constructs an instance of <code>DwarfException</code> with the specified
     * exception. Will "destroy" the <code>Engine</code>.
     *
     * @see dwarf.engine.core.Engine#dispose()
     *
     * @param exception the specified Exception
     */
    public DwarfError(Exception exception) {
        super(exception.getMessage(), exception.getCause());
        dwarf.engine.core.Engine.dispose();
    }

    @Override
    public DwarfError clone() throws CloneNotSupportedException {
        return new DwarfError(this);
    }

    @Override
    public DwarfError get() {
        return this;
    }
}
