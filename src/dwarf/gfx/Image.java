package dwarf.gfx;

import java.util.Objects;
import java.io.IOException;

import dwarf.GameObject;
import dwarf.util.Vector2;

import static dwarf.util.Vector2.ZERO;

/**
 * A set of functions and variables required to create a malleable class for
 * drawing pictures to the game window in. Load various image formats for use
 * with <a href='http://www.opengl.org/'>OpenGL</a> (png, gif, jpg, etc).
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.gfx.Texture
 * @see dwarf.gfx.TextureLoader
 * @see dwarf.GameObject
 * @see dwarf.Collidable
 */
public class Image extends Rectangle implements GameObject {

    /**
     * The texture that stores the image for this <code>Image</code>. (will hold
     * the image details)
     */
    private Texture texture;

    /**
     * Default constructor.
     */
    public Image() {
        super();
    }

    /**
     * Create a new sprite from a specified image.
     *
     * @param path A reference to the image on which this sprite should be based
     * @param position the position of the image on the screen
     */
    public Image(String path, Vector2 position) throws dwarf.DwarfException {
        super(ZERO, position, STROKE, WHITE);

        try {
            this.texture = TextureLoader.getTexture(path);
        } catch (IOException ioe) {
            throw new dwarf.DwarfException(ioe);
        } finally {
            super.setDimensions(new Vector2(texture.getImageWidth(), texture.getImageHeight()));
        }
    }

    public Image(Image img) {
        super(ZERO, img.getPosition(), STROKE, WHITE);
        this.texture = img.getTexture();

        super.setDimensions(new Vector2(texture.getImageWidth(), texture.getImageHeight()));
    }

    /**
     * Callback function used to render the <code>Image</code> to the window.
     */
    @Override
    public void render() {
        if (getRender()) {
            dwarf.gfx.draw.texture(super.getPosition(), getTexture());
        }
    }

    @Override
    public Image clone() throws CloneNotSupportedException {
        return new Image(this);
    }

    public Texture getTexture() {
        return this.texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(getTexture());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else if (!super.equals(obj)) {
            return false;
        }

        final Image img = (Image) obj;

        if (!Objects.equals(this.getTexture(), img.getTexture())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Image{" + "texture:" + texture + "}";
    }

    @Override
    public Image get() {
        return this;
    }

    public void set(Image img) {
        super.setPosition(img.getPosition());
        this.texture = img.getTexture();
        super.setDimensions(new Vector2(texture.getImageWidth(), texture.getImageHeight()));

    }

    public void set(String path, Vector2 position) throws dwarf.DwarfException {
        super.setPosition(position);

        try {
            texture = TextureLoader.getTexture(path);
        } catch (IOException ioe) {
            throw new dwarf.DwarfException(ioe);
        }

        super.setDimensions(new Vector2(texture.getImageWidth(), texture.getImageHeight()));

    }
}
