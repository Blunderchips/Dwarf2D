package dwarf.engine.core;

import javax.swing.JOptionPane;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import static org.lwjgl.openal.AL10.AL_EXTENSIONS;
import static org.lwjgl.openal.AL10.AL_RENDERER;
import static org.lwjgl.openal.AL10.AL_VENDOR;
import static org.lwjgl.openal.AL10.AL_VERSION;
import static org.lwjgl.openal.AL10.alGetString;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;

/**
 * Open Audio Library
 *
 * @author sid_th3_sl0th
 */
public final class openAL {

    public openAL() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    /**
     * initializes openGL
     */
    protected static void init() {
        try {
            AL.create();
            //util.debug("INFO", "openAL version: " + openAL.getVersion());
        } catch (LWJGLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", JOptionPane.ERROR_MESSAGE
            );
            Game.close(ex);
        }
    }

    protected static void dispose() {
        AL.destroy();
    }

    /**
     * The version of OpenAL is returned. This usually has the format And can
     * then possibly still contain vendor-specific information.
     */
    public static String getVersion() {
        return alGetString(AL_VERSION);
    }

    /**
     * The manufacturer of the OpenAL implementation name is returned.
     */
    public static String getVender() {
        return alGetString(AL_VENDOR);
    }

    /**
     * Returns the name of the renderer.
     */
    public static String getRenderer() {
        return alGetString(AL_RENDERER);
    }

    /**
     * A list of available extensions is returned, the individual extensions are
     * separated by spaces. To test in a simple manner whether a certain
     * extension is present, one can use the function alIsExtensionPresent.
     */
    public static String getExtensions() {
        return alGetString(AL_EXTENSIONS);
    }

    public static boolean isCreated() {
        return AL.isCreated();
    }

    public static ALCcontext getContext() {
        return AL.getContext();
    }

    public static ALCdevice getDevice() {
        return AL.getDevice();
    }
}
