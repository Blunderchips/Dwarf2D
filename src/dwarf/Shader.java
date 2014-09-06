package dwarf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glDeleteProgram;
import static org.lwjgl.opengl.GL20.glDeleteShader;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glValidateProgram;

/**
 * handles all shader files and shader operation. A Shader is a program designed
 * to run on some stage of a graphics processor. Its purpose is to execute one
 * of the programmable stages of the rendering pipeline.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Shader'>wikipedia</a>
 * @see java.lang.Object
 */
public class Shader extends java.lang.Object implements Cloneable {

    /**
     * The Vertex Shader is the programmable Shader stage in the rendering
     * pipeline that handles the processing of individual vertices.
     */
    public final static int VERTEX_SHADER = 0x8b31;
    /**
     * A Fragment Shader is a user-supplied program that, when executed, will
     * process a Fragment from the rasterization process into a set of colours
     * and a single depth value.
     */
    public final static int FRAGMENT_SHADER = 0x8b30;
    public final static int SHADER_PROGRAM = glCreateProgram();

    public static void deleteShaderProgram() {
        glDeleteProgram(SHADER_PROGRAM);
    }

    public static void use() {
        glUseProgram(SHADER_PROGRAM);
    }

    public static void stop() {
        glUseProgram(0);
    }

    private int type;
    private int program;
    private String path;
    private StringBuilder source;

    /**
     * Default constructor.
     */
    public Shader() {
        super();
    }

    public Shader(Shader shader) {
        super();

        this.path = shader.getPath();
        this.type = shader.getType();

        this.init();
    }

    public Shader(int type, String path) throws DwarfException {
        super();

        this.path = path;
        this.type = type;

        this.init();
    }

    /**
     * The Vertex Shader is the programmable Shader stage in the rendering
     * pipeline that handles the processing of individual vertices.
     *
     * @see dwarf.Shader#VERTEX_SHADER
     *
     * @return Shader.VERTEX_SHADER (35633)
     */
    public static int getVertexShader() {
        return Shader.VERTEX_SHADER;
    }

    /**
     * A Fragment Shader is a user-supplied program that, when executed, will
     * process a Fragment from the rasterization process into a set of colours
     * and a single depth value.
     *
     * @see dwarf.Shader#FRAGMENT_SHADER
     *
     * @return Shader.FRAGMENT_SHADER (35632)
     */
    public static int getFragmentShader() {
        return Shader.FRAGMENT_SHADER;
    }

    /**
     * A Fragment Shader is a user-supplied program that, when executed, will
     * process a Fragment from the rasterization process into a set of colours
     * and a single depth value.
     *
     * @see dwarf.Shader#SHADER_PROGRAM
     *
     * @return Shader.SHADER_PROGRAM
     */
    public static int getShaderProgram() {
        return Shader.SHADER_PROGRAM;
    }

    public int getProgram() {
        return this.program;
    }

    public void delete() {
        glDeleteShader(program);
    }

    /**
     * Class Object is the root of the class hierarchy. Every class has Object
     * as a superclass. All objects, including arrays, implement the methods of
     * this class.
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + program;
        hash = 89 * hash + Objects.hashCode(source);
        return hash;
    }

    public String getPath() {
        return this.path;
    }

    public StringBuilder getSource() {
        return this.source;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Shader shader = (Shader) obj;

        if (this.getProgram() != shader.getProgram()) {
            return false;
        } else if (!Objects.equals(this.getSource(), shader.getSource())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Shader["
                + "program:" + getProgram() + ", "
                + "source: " + getSource()
                + "]";
    }

    public Shader get() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the
     * <code>Shader</code>. WARNING: Do NOT modify this code.
     * 
     * @throws DwarfException if the source is not found
     */
    public final void init() throws DwarfException {
        this.source = new StringBuilder();

        if (type == FRAGMENT_SHADER || type == VERTEX_SHADER) {
            BufferedReader scanner = null;
            try {
                scanner = new BufferedReader(new FileReader(path));
                String ln;
                while ((ln = scanner.readLine()) != null) {
                    this.source.append(ln).append('\n');
                }
            } catch (IOException ioe) {
                throw new DwarfException(ioe);
            } finally {
                if (scanner != null) {
                    try {
                        scanner.close();
                    } catch (IOException ioe) {
                        throw new DwarfException(ioe);
                    }
                }
            }

            glShaderSource(program, source);
            glCompileShader(program);

            if (glGetShaderi(program, GL_COMPILE_STATUS) == GL_FALSE) {
                throw new DwarfException("Shader wan not able to be compiled correctly.");
            }

            glAttachShader(SHADER_PROGRAM, program);
            glLinkProgram(SHADER_PROGRAM);
            glValidateProgram(SHADER_PROGRAM);
        } else {
            throw new DwarfException("the shader type '" + type + "' is unrecognised.");
        }
    }

    public void set(Shader shader) {
        this.path = shader.getPath();
        this.type = shader.getType();

        this.init();
    }

    public void set(int type, String path) {
        this.path = path;
        this.type = type;

        this.init();
    }

    @Override
    public Shader clone() throws CloneNotSupportedException {
        return new Shader(this);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
