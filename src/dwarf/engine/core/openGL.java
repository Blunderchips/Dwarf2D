package dwarf.engine.core;

import static org.lwjgl.opengl.GL11.GL_ALPHA_TEST;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_EXTENSIONS;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_MODULATE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_RENDERER;
import static org.lwjgl.opengl.GL11.GL_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_ENV;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_ENV_MODE;
import static org.lwjgl.opengl.GL11.GL_VENDOR;
import static org.lwjgl.opengl.GL11.GL_VERSION;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glGetString;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glShadeModel;
import static org.lwjgl.opengl.GL11.glTexEnvf;
import static org.lwjgl.opengl.GL20.GL_SHADING_LANGUAGE_VERSION;

/**
 * <a href='http://www.opengl.org/'>OpenGL</a> (Open Graphics Library) is a
 * cross-language, multi-platform application programming interface (API) for
 * rendering 2D and 3D vector graphics. The API is typically used to interact
 * with a graphics processing unit (GPU), to achieve hardware-accelerated
 * rendering.
 *
 * @see <a href='http://en.wikipedia.org/wiki/OpenGL'>wikipedia</a>
 * @see <a href='http://www.opengl.org/'>opengl.org</a>
 *
 * @author sid_th3_sl0th
 */
public final class openGL {

    public openGL() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    /**
     * initializes openGL
     */
    protected static final void init() {
        // util.debug("INFO", "openGL version: " + openGL.getVersion());

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Window.getWidth(), 0, Window.getHeight(), 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glClearColor(0, 0, 0, 1 | GL_COLOR_BUFFER_BIT);

        glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);

        // enable alpha blending
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        glDisable(GL_DEPTH_TEST);
        glEnable(GL_COLOR_MATERIAL);
        glEnable(GL_ALPHA_TEST);
        glEnable(GL_BLEND);
        glShadeModel(GL_SMOOTH);
    }

    /**
     * Returns a version or release number of the form
     *
     * @return a version or release number.
     */
    public static String getVersion() {
        return glGetString(GL_VERSION);
    }

    /**
     * @return the company responsible for this GL implementation. This name
     * does not change from release to release.
     */
    public static String getVendor() {
        return glGetString(GL_VENDOR);
    }

    /**
     * @return the name of the renderer. This name is typically specific to a
     * particular configuration of a hardware platform. It does not change from
     * release to release.
     */
    public static String getRenderer() {
        return glGetString(GL_RENDERER);
    }

    /**
     * @return a version or release number for the shading language.
     */
    public static String getShadingLanguageVersion() {
        return glGetString(GL_SHADING_LANGUAGE_VERSION);
    }

    /**
     * For glGetStringi only, returns the extension string supported by the
     * implementation at index.
     *
     * @return Returns a space-separated list of supported extensions to GL.
     */
    public static String getExtensions() {
        return glGetString(GL_EXTENSIONS);
    }
}
