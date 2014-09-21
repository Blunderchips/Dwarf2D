package dwarf;

import static dwarf.GLSL.VERTEX_SHADER;
import static dwarf.GLSL.FRAGMENT_SHADER;

/**
 * Handles all shader files and shader operation. A Shader is a program designed
 * to run on some stage of a graphics processor. Its purpose is to execute one
 * of the programmable stages of the rendering pipeline.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://en.wikipedia.org/wiki/Shader'>wikipedia</a>
 * @see dwarf.GLSL
 * @see java.lang.Object
 * @see java.lang.Cloneable
 */
public class Shader extends java.lang.Object implements Cloneable {

    private int type;
    private int program;

    /**
     * Default constructor.
     */
    public Shader() {
        super();
    }

    public Shader(String path, int type) throws DwarfException {
        super();

        this.setType(type);
        this.program = GLSL.createShader(path, type);
    }

    public Shader(Shader shader) {
        super();

        this.type = shader.getType();
        this.program = shader.getProgram();
    }

    /**
     * uses the <code>Shader</code>
     */
    public void use() {
        GLSL.useProgram(program);
    }

    public final void setType(int type) throws DwarfException {
        if (type == VERTEX_SHADER || type == FRAGMENT_SHADER) {
            this.type = type;
        } else {
            throw new DwarfException("illegal argument");
        }
    }

    /**
     * Gets the type of the object as a string.
     *
     * @return the type of shader <code>this</code> is (String)
     */
    public String type() {
        switch (type) {
            case VERTEX_SHADER:
                return "vertex shader";
            case FRAGMENT_SHADER:
                return "fragment shader";
            default:
                return null;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.type;
        hash = 97 * hash + this.program;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Shader shader = (Shader) obj;

        if (this.type != shader.type) {
            return false;
        } else if (this.program != shader.program) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Shader[" + "type: " + type + ", program: " + program + "]";
    }

    public int getType() {
        return this.type;
    }

    public int getProgram() {
        return this.program;
    }
}
