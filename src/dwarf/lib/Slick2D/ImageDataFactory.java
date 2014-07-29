package dwarf.lib.Slick2D;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * A static utility to create the appropriate image data for a particular
 * reference.
 *
 * @author kevin
 */
public class ImageDataFactory {

    /**
     * True if we're going to use the native PNG loader - cached so it doesn't
     * have the security check repeatedly
     */
    private static boolean usePngLoader = true;
    /**
     * True if the PNG loader property has been checked
     */
    private static boolean pngLoaderPropertyChecked = false;

    /**
     * The name of the PNG loader configuration property
     */
    private static final String PNG_LOADER = "org.newdawn.slick.pngloader";

    /**
     * Check PNG loader property. If set the native PNG loader will not be used.
     */
    @SuppressWarnings("unchecked")
    private static void checkProperty() {
        if (!pngLoaderPropertyChecked) {
            pngLoaderPropertyChecked = true;

            try {
                AccessController.doPrivileged((PrivilegedAction) () -> {
                    String val = System.getProperty(PNG_LOADER);
                    if ("false".equalsIgnoreCase(val)) {
                        usePngLoader = false;
                    }
                    
                    System.err.println("Use Java PNG Loader = " + usePngLoader);
                    return null;
                });
            } catch (Throwable ex) {
                // ignore, security failure - probably an applet
            }
        }
    }

    /**
     * Create an image data that is appropriate for the reference supplied
     *
     * @param ref The reference to the image to retrieve
     * @return The image data that can be used to retrieve the data for that
     * resource
     */
    public static LoadableImageData getImageDataFor(String ref) {
        LoadableImageData imageData;
        checkProperty();

        ref = ref.toLowerCase();

        if (ref.endsWith(".tga")) {
            return new TGAImageData();
        }
        if (ref.endsWith(".png")) {
            CompositeImageData data = new CompositeImageData();
            if (usePngLoader) {
                data.add(new PNGImageData());
            }
            data.add(new ImageIOImageData());

            return data;
        }

        return new ImageIOImageData();
    }
}
