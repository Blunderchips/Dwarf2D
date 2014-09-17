package dwarf;

import static dwarf.Util.readFileAsString;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glDeleteShader;
import static org.lwjgl.opengl.GL20.glDetachShader;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUniform1i;
import static org.lwjgl.opengl.GL20.glUniform2f;
import static org.lwjgl.opengl.GL20.glUniform2i;
import static org.lwjgl.opengl.GL20.glUniform3f;
import static org.lwjgl.opengl.GL20.glUniform3i;
import static org.lwjgl.opengl.GL20.glUniform4f;
import static org.lwjgl.opengl.GL20.glUniform4i;
import static org.lwjgl.opengl.GL20.glUseProgram;

public final class GLSL {

    /**
     * you can not instantiate this class.
     */
    public GLSL() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    /**
     * A Vertex Shader is the programmable Shader stage in the rendering
     * pipeline that handles the processing of individual vertices.
     */
    public final static int VERTEX_SHADER = GL_VERTEX_SHADER;
    /**
     * A Fragment Shader is a user-supplied program that, when executed, will
     * process a Fragment from the rasterization process into a set of colours
     * and a single depth value.
     */
    public final static int FRAGMENT_SHADER = GL_FRAGMENT_SHADER;

    /**
     * Send floats to the shader
     */
    public static void sendFloats(String name, int program, float... values) {
        int location = glGetUniformLocation(program, name);
        switch (values.length) {
            case 1:
                glUniform1f(location, values[0]);
                break;
            case 2:
                glUniform2f(location, values[0], values[1]);
                break;
            case 3:
                glUniform3f(location, values[0], values[1], values[2]);
                break;
            case 4:
                glUniform4f(location, values[0], values[1], values[2], values[3]);
                break;
        }
    }

    /**
     * Send integers to the shader
     */
    public static void sendIntegers(String name, int program, int... values) {
        int location = glGetUniformLocation(program, name);
        switch (values.length) {
            case 1:
                glUniform1i(location, values[0]);
                break;
            case 2:
                glUniform2i(location, values[0], values[1]);
                break;
            case 3:
                glUniform3i(location, values[0], values[1], values[2]);
                break;
            case 4:
                glUniform4i(location, values[0], values[1], values[2], values[3]);
                break;
        }
    }

    /**
     * Run a given shader program
     *
     * @param program to shader program to be run.
     */
    public static void useProgram(int program) {
        glUseProgram(program);
    }

    /**
     * Reset the shader program being used
     */
    public static void resetShaders() {
        glUseProgram(0);
    }

    /**
     * Create a shader program
     */
    public static int createShaderProgram(int... shaders) {
        int program = glCreateProgram();
        for (int shader : shaders) {
            glAttachShader(program, shader);
        }
        glLinkProgram(program);
        for (int shader : shaders) {
            glDetachShader(program, shader);
            glDeleteShader(shader);
        }
        return program;
    }

    /**
     * Create a shader
     *
     * @see dwarf.GLSL#VERTEX_SHADER
     * @see dwarf.GLSL#FRAGMENT_SHADER
     *
     * @param type the type of shader to be created
     * @param path the path to the shader file
     *
     * @return the shader
     */
    public static int createShader(String path, int type) {
        int shader = -1;
        shader = glCreateShader(type);
        try {
            glShaderSource(shader, readFileAsString(path));
        } catch (Exception ex) {
            glDeleteShader(shader);
            return -1;
        }
        glCompileShader(shader);
        return shader;
    }

    /**
     * Load a fragment shader.
     *
     * @see dwarf.GLSL#createShader
     * @see dwarf.GLSL#FRAGMENT_SHADER
     *
     * @param path the path to the shader file
     *
     * @return the fragment shader
     */
    public static int createFragmentShader(String path) {
        return createShader(path, FRAGMENT_SHADER);
    }

    /**
     * Load a vertex shader.
     *
     * @see dwarf.GLSL#createShader
     * @see dwarf.GLSL#VERTEX_SHADER
     *
     * @param path the path to the shader file
     *
     * @return the vertex shader
     */
    public static int createVertexShader(String path) {
        return createShader(path, VERTEX_SHADER);
    }
}
