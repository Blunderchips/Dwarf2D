package dwarf.engine.core;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;

import static org.lwjgl.openal.AL10.AL_EXTENSIONS;
import static org.lwjgl.openal.AL10.AL_RENDERER;
import static org.lwjgl.openal.AL10.AL_VENDOR;
import static org.lwjgl.openal.AL10.AL_VERSION;
import static org.lwjgl.openal.AL10.alGetString;

/**
 * <a href='http://www.openal.org/'>OpenAL</a> (Open Audio Library) is a
 * cross-platform audio application programming interface (API). It is designed
 * for efficient rendering of multichannel three-dimensional positional audio.
 * Its API style and conventions deliberately resemble those of <a
 * href='http://www.opengl.org/'>OpenGL</a>. Early versions of the framework
 * were open source software, but the later revisions are proprietary.
 *
 * @see <a href='http://en.wikipedia.org/wiki/OpenAL'>wikipedia</a>
 * @see <a href='http://www.openal.org/'>openal.org</a>
 *
 * @author Matthew 'siD' Van der Bijl
 */
public interface openAL {

    /**
     * initializes <a href='http://www.openal.org/'>OpenAL</a>
     */
    public static void init() {
        try {
            AL.create();
            // util.debug("INFO", "openAL version: " + openAL.getVersion());
        } catch (LWJGLException ex) {
            new dwarf.DwarfException(ex).display();
        }
    }

    public static void dispose() {
        AL.destroy();
    }

    /**
     * The version of <a href='http://www.openal.org/'>OpenAL</a> is returned.
     * This usually has the format And can then possibly still contain
     * vendor-specific information.
     *
     * @return returns the version on <a
     * href='http://www.openal.org/'>OpenAL</a> is use
     */
    public static String getVersion() {
        return alGetString(AL_VERSION);
    }

    /**
     * @return The manufacturer of the <a
     * href='http://www.openal.org/'>OpenAL</a> implementation name is returned.
     */
    public static String getVender() {
        return alGetString(AL_VENDOR);
    }

    /**
     * @return the name of the renderer.
     */
    public static String getRenderer() {
        return alGetString(AL_RENDERER);
    }

    /**
     * A list of available extensions is returned, the individual extensions are
     * separated by spaces. To test in a simple manner whether a certain
     * extension is present, one can use the function alIsExtensionPresent.
     *
     * @return A list of available extensions
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
