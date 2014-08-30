package dwarf;

import javax.swing.JOptionPane;

import dwarf.engine.core.Window;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * This exception is supplied to make exception handling more generic for
 * Dwarf2D specific exceptions.
 *
 * @author Matthew 'siD' Van der Bijl
 *
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
     * Constructs an instance of <code>DwarfException</code> with the specified
     * exception.
     *
     * @param exception the specified Exception
     */
    public DwarfException(Exception exception) {
        super(exception.getMessage(), exception.getCause());
    }

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

    public void display() {
        new dwarf.Crashform(this);
    }
}
