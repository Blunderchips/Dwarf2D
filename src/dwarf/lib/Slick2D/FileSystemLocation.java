package dwarf.lib.Slick2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A resource loading location that searches somewhere on the classpath
 *
 * @author kevin
 */
public class FileSystemLocation implements ResourceLocation {

    /**
     * The root of the file system to search
     */
    private File root;

    /**
     * Create a new resoruce location based on the file system
     *
     * @param root The root of the file system to search
     */
    public FileSystemLocation(File root) {
        this.root = root;
    }

    /**
     * @see ResourceLocation#getResource(String)
     */
    @Override
    public URL getResource(String ref) {
        try {
            File file = new File(root, ref);
            if (!file.exists()) {
                file = new File(ref);
            }
            if (!file.exists()) {
                return null;
            }

            return file.toURI().toURL();
        } catch (MalformedURLException ex) {
            return null;
        }
    }

    /**
     * @see ResourceLocation#getResourceAsStream(String)
     */
    @Override
    public InputStream getResourceAsStream(String ref) {
        try {
            File file = new File(root, ref);
            if (!file.exists()) {
                file = new File(ref);
            }
            return new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

}
