package dwarf.lib.Slick2D;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A collection of IOException that failed image data loading
 *
 * @author kevin
 */
@SuppressWarnings("serial")
public class CompositeIOException extends IOException {

    /**
     * The list of exceptions causing this one
     */
    private ArrayList exceptions = new ArrayList();

    /**
     * Create a new composite IO Exception
     */
    public CompositeIOException() {
        super();
    }

    /**
     * Add an exception that caused this exceptino
     *
     * @param e The exception
     */
    @SuppressWarnings("unchecked")
    public void addException(Exception e) {
        exceptions.add(e);
    }

    @Override
    public String getMessage() {
        String msg = "Composite Exception: \n";
        for (Object exception : exceptions) {
            msg += "\t" + ((Throwable) exception).getMessage() + "\n";
        }
        return msg;
    }
}
