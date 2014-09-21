package dwarf.gfx;

import java.awt.Dimension;
import java.util.Objects;

import dwarf.DwarfException;
import dwarf.LWJGL.Texture;
import dwarf.util.Point2D;
import dwarf.LWJGL.TextureLoader;

/**
 * A set of functions and variables required to create a malleable class for
 * drawing pictures to the game window in. Load various image formats for use
 * with <a href='http://www.opengl.org/'>OpenGL</a> (png, gif, jpg, etc).
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.LWJGL.Texture
 * @see dwarf.LWJGL.TextureLoader
 * @see dwarf.GameObject
 * @see dwarf.Collidable
 * @see dwarf.gfx.Rectangle
 */
@SuppressWarnings("serial")
public class Image extends Rectangle {

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
    public Image(String path, Point2D position) throws DwarfException {
        super(new Point2D(), position, STROKE, Colour.white);

        try {
            this.texture = TextureLoader.getTexture(path);
        } catch (DwarfException ex) {
            throw new DwarfException(ex);
        } finally {
            if (texture != null) {
                super.setDimensions(new Point2D(texture.getImageWidth(), texture.getImageHeight()));
            } else {
                throw new DwarfException("texture not loaded correctly");
            }
        }
    }

    public Image(Image img) {
        super(new Point2D(), img.getPosition(), STROKE, Colour.white);
        this.texture = img.getTexture();

        super.setDimensions(new Point2D(texture.getImageWidth(), texture.getImageHeight()));
    }

    /**
     * Callback function used to render the <code>Image</code> to the window.
     */
    @Override
    public void render() {
        if (getRender()) {
            dwarf.gfx.draw.texture(super.getPosition(), 0, getTexture());
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
        hash = 89 * hash + Objects.hashCode(texture);
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @param obj the <code>Object</code> to be tested
     * @see java.lang.Object#equals(java.lang.Object)
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
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

        final Image img = (Image) obj;

        if (!Objects.equals(this.getTexture(), img.getTexture())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Image[position: " + super.getPosition() + "texture:" + texture + "]";
    }

    @Override
    public Image get() {
        return this;
    }

    public void set(Image img) {
        this.texture = img.getTexture();
        super.setPosition(img.getPosition());
        super.setDimensions(new Point2D(texture.getImageWidth(), texture.getImageHeight()));

    }

    public void set(String path, Point2D position) throws DwarfException {
        super.setPosition(position);

        try {
            this.texture = TextureLoader.getTexture(path);
        } catch (DwarfException ex) {
            throw new DwarfException(ex);
        } finally {
            if (texture != null) {
                super.setDimensions(new Point2D(texture.getImageWidth(), texture.getImageHeight()));
            } else {
                throw new DwarfException("texture not loaded correctly");
            }
        }
    }

    @Override
    public Dimension getDimensions() {
        return new Dimension(texture.getImageWidth(), texture.getImageHeight());
    }
}
