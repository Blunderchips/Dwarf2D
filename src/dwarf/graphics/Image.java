package dwarf.graphics;

import dwarf.Game;
import dwarf.GameObject;
import dwarf.engine.core.Window;
import dwarf.lib.Slick2D.ResourceLoader;
import dwarf.lib.Slick2D.Texture;
import dwarf.lib.Slick2D.TextureLoader;
import dwarf.util.Vector2;
import java.io.IOException;
import java.util.Objects;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * A set of functions and variables required to create a malleable class for
 * drawing pictures to the game window.
 *
 * @author sid_th3_sl0th
 * @see dwarf.GameObject
 * @see dwarf.Collidable
 * @see java.lang.Object
 */
public class Image extends GameObject {

    private Texture tex;

    public Image(Texture texture, Vector2 position) {
        super(position);
        this.init(texture);
    }

    public Image(String key, Vector2 position) {
        super(position);

        Texture texture = null;

        try {
            texture = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream(key));
        } catch (IOException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", ERROR_MESSAGE
            );
            Game.close(ex);
        }

        this.init(texture);
    }

    /**
     * Callback function used to update the state of the game every frame.
     */
    @Override
    public void update() {
    }

    /**
     * Callback function used to render on the screen every frame.
     */
    @Override
    public void render() {
        draw.texture(getPosition(), getTexture());
    }

    protected final void init(Texture texture) {
        Vector2[] points = {
            new Vector2(0, 0),
            new Vector2(texture.getTextureWidth(), 0),
            new Vector2(texture.getTextureWidth(), texture.getTextureHeight()),
            new Vector2(0, texture.getTextureHeight())
        };

        this.tex = texture;
        this.setVertices(points);
    }

    public Texture getTexture() {
        return this.tex;
    }

    public void setTexture(Texture texture) {
        this.init(texture);
    }

    public void setTexture(String key) {
        Texture texture = null;

        try {
            texture = TextureLoader.getTexture("JPEG", ResourceLoader.getResourceAsStream(key));
        } catch (IOException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", ERROR_MESSAGE
            );
            Game.close(ex);
        }

        this.init(texture);
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
        hash = 79 * hash + Objects.hashCode(getTexture());
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
        } else if (!super.equals(obj)) {
            return false;
        }

        final Image other = (Image) obj;
        return Objects.equals(this.getTexture(), other.getTexture());
    }

    /**
     * Gets the height of the Image as a float.
     *
     * @return the height of the image
     */
    public float getHeight() {
        return this.getTexture().getHeight();
    }

    /**
     * Gets the width of the Image as a float.
     *
     * @return the width of the texture
     */
    public float getWidth() {
        return this.getTexture().getHeight();
    }

    /**
     * Gets the width and height of the Image as a new Vector2.
     *
     * @return the width and the hight of the image
     */
    public Vector2 getDimensions() {
        return new Vector2(
                this.getWidth(), this.getHeight()
        );
    }

    @Override
    public Image get() {
        return this;
    }
}
