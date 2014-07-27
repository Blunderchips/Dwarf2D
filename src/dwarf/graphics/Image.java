package dwarf.graphics;

import dwarf.engine.core.Game;
import dwarf.engine.core.GameObject;
import dwarf.engine.core.Window;
import dwarf.lib.Slick2D.ResourceLoader;
import dwarf.lib.Slick2D.Texture;
import dwarf.lib.Slick2D.TextureLoader;
import dwarf.util.Vector2;
import java.io.IOException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 * Texture functions
 *
 * @author sid_th3_sl0th
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
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", JOptionPane.ERROR_MESSAGE
            );
            Game.close(ex);
        }

        this.init(texture);
    }

    @Override
    public void render() {
        draw.texture(getPosition(), getTexture());
    }

    @Override
    public void update() {
    }

    private void init(Texture texture) {
        Vector2[] points = {
            new Vector2(0, 0),
            new Vector2(texture.getTextureWidth(), 0),
            new Vector2(texture.getTextureWidth(), texture.getTextureHeight()),
            new Vector2(0, texture.getTextureHeight())
        };

        this.tex = texture;
        this.setPoints(points);
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
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", JOptionPane.ERROR_MESSAGE
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
     * Returns true if the arguments are equal to each other and false
     * otherwise. Consequently, if both arguments are null, true is returned and
     * if exactly one argument is null, false is returned. Otherwise, equality
     * is determined by using the equals method of the first argument.
     *
     * @return true if the arguments are equal to each other and false otherwise
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

}
