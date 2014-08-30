package dwarf.gfx;

import java.util.Objects;
import java.io.IOException;

import dwarf.GameObject;
import dwarf.util.Vector2;

import static dwarf.util.Vector2.ZERO;

/**
 * A set of functions and variables required to create a malleable class for
 * drawing pictures to the game window.
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
     * The texture that stores the image for this <code>Image</code>.
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
            texture = TextureLoader.getTexture(path);
        } catch (IOException ex) {
            throw new dwarf.DwarfException(ex);
        }

        super.setDimensions(new Vector2(texture.getImageWidth(), texture.getImageHeight()));
    }

    public Image(Image i) {
        super(ZERO, i.getPosition(), STROKE, WHITE);
        this.texture = i.getTexture();

        super.setDimensions(new Vector2(texture.getImageWidth(), texture.getImageHeight()));
    }

    /**
     * Callback function used to render the <code>Image</code> to the window.
     */
    @Override
    public void render() {
        dwarf.gfx.draw.texture(super.getPosition(), getTexture());
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

        final Image other = (Image) obj;

        if (!Objects.equals(this.getTexture(), other.getTexture())) {
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

    public void set(Image i) {
        super.setPosition(i.getPosition());
        this.texture = i.getTexture();
        super.setDimensions(new Vector2(texture.getImageWidth(), texture.getImageHeight()));

    }

    public void set(String path, Vector2 position) throws dwarf.DwarfException {
        super.setPosition(position);

        try {
            texture = TextureLoader.getTexture(path);
        } catch (IOException ex) {
            throw new dwarf.DwarfException(ex);
        }

        super.setDimensions(new Vector2(texture.getImageWidth(), texture.getImageHeight()));

    }
}
