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
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glDeleteProgram;
import static org.lwjgl.opengl.GL20.glDeleteShader;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glValidateProgram;

/**
 * handles all shader files and shader operation.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Shader'>wikipedia</a>
 * @see java.lang.Object
 */
public class Shader extends java.lang.Object {

    public final static int VERTEX_SHADER = 0x8b31;
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

    private int program;
    private StringBuilder source;

    public Shader() {
        super();
    }

    public Shader(Shader shader) {
        super();

        this.setProgram(shader.getProgram());
        this.setSource(shader.getSource());
    }

    public Shader(int type, String key) {
        super();

        this.source = new StringBuilder();

        if (type == FRAGMENT_SHADER || type == VERTEX_SHADER) {
            this.setProgram(glCreateShader(type));
            System.out.println(getProgram());
        } else {
            throw new IllegalArgumentException("the shader type '" + type + "' is unrecognised.");
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(key));
            String line;
            while ((line = reader.readLine()) != null) {
                source.append(line).append('\n');
            }
        } catch (IOException ex) {
            System.err.println("Shader was not loaded properly. :( \n" + ex);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }

        glShaderSource(getProgram(), getSource());
        glCompileShader(getProgram());

        if (glGetShaderi(getProgram(), GL_COMPILE_STATUS) == GL_FALSE) {
            System.err.println("Vertex shader wasn't able to be compiled correctly. :(");
        }

        glAttachShader(SHADER_PROGRAM, getProgram());
        glLinkProgram(SHADER_PROGRAM);
        glValidateProgram(SHADER_PROGRAM);
    }

    public int getProgram() {
        return this.program;
    }

    public final void setProgram(int program) {
        this.program = program;
    }

    public int getShaderProgram() {
        return Shader.SHADER_PROGRAM;
    }

    public StringBuilder getSource() {
        return this.source;
    }

    public final void setSource(StringBuilder source) {
        this.source = source;
    }

    public void delete() {
        glDeleteShader(getProgram());
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
        hash = 89 * hash + getProgram();
        hash = 89 * hash + Objects.hashCode(getSource());
        return hash;
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
        final Shader other = (Shader) obj;
        if (this.getProgram() != other.getProgram()) {
            return false;
        } else if (!Objects.equals(this.getSource(), other.getSource())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shader = {"
                + "program:" + getProgram() + ", "
                + "source: " + getSource()
                + "}";
    }
}
