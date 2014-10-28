package dwarf.gfx;

import java.util.ArrayList;

import dwarf.DwarfException;
import dwarf.GameObject;
import dwarf.random;
import dwarf.util.Point2D;
import java.util.Objects;

/**
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.gfx.Image
 * @see dwarf.GameObject
 * @see dwarf.Collidable
 * @see java.lang.Object
 */
@SuppressWarnings("serial")
public class Sprite extends dwarf.Collidable implements GameObject, Cloneable {

    /**
     * Default constructor.
     */
    public Sprite() {
        super();
    }

    private ArrayList<Image> textures;
    private Image activeTexture;

    public Sprite(Sprite sprite) {
        super();

        this.textures = sprite.textures;
        this.textures.add(sprite.getActiveTexture());
        this.activeTexture = textures.get(0);
    }

    public Sprite(Image image) {
        super();

        this.textures = new ArrayList<>();
        this.textures.add(image);
        this.activeTexture = textures.get(0);
    }

    public Sprite(Image image, Point2D position) {
        super(position, null);

        this.textures = new ArrayList<>();
        this.textures.add(image);
        this.activeTexture = textures.get(0);
    }

    @Override
    public void update() {
        this.activeTexture.update();
    }

    @Override
    public void render() {
        this.activeTexture.render();
    }

    public Image[] getTextures() {
        Image[] result = new Image[getNumtextures()];

        for (int i = 0; i < getNumtextures(); i++) {
            result[i] = this.textures.get(i);
        }

        return result;
    }

    public boolean setTextures(Image[] textures) throws DwarfException {
        try {
            this.textures.clear();

            for (Image image : textures) {
                this.textures.add(image);
            }
            return true;
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    public boolean setTextures(ArrayList<Image> textures) throws DwarfException {
        try {
            this.textures = textures;
            return true;
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    public int getNumtextures() {
        return this.textures.size();
    }

    /**
     * tries to add a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be added.
     * @return true if successful and false if it fails.
     */
    public boolean addTexture(Image input) throws DwarfException {
        try {
            return this.textures.add(input);
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to add a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be added.
     * @return true if successful and false if it fails.
     */
    public boolean addTexture(Object input) throws DwarfException {
        try {
            return this.textures.add((Image) input);
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be removed.
     * @return true if successful and false if it fails.
     */
    public boolean removeTexture(Image input) throws DwarfException {
        try {
            return this.textures.remove(input);
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be removed.
     * @return true if successful and false if it fails.
     */
    @SuppressWarnings("element-type-mismatch")
    public boolean removeGameObject(Object input) throws DwarfException {
        try {
            return this.textures.remove(input);
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param index of the <code>GameObject</code> to be removed.
     * @return true if successful and false if it fails.
     */
    public boolean removeGameObject(int index) throws DwarfException {
        try {
            this.textures.remove(index);
            return true;
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    public Image getActiveTexture() {
        return this.activeTexture;
    }

    public void setActiveTexture(int texture) {
        this.activeTexture = this.textures.get(texture);
        super.setVertices(activeTexture.getVertices());
    }

    public void nextTexture() {
        if (getActiveTexture() == getTextures()[getNumtextures() - 1]) {
            this.setActiveTexture(0);
        } else {
            for (int i = 0; i < getNumtextures() - 1; i++) {
                if (getActiveTexture() == getTextures()[i]) {
                    this.setActiveTexture(i + 1);
                }
            }
        }
    }

    public void previousTexture() {
        if (getActiveTexture() == getTextures()[0]) {
            this.setActiveTexture(getNumtextures() - 1);
        } else {
            for (int i = 0; i < getNumtextures() - 1; i++) {
                if (getActiveTexture() == getTextures()[i]) {
                    this.setActiveTexture(i - 1);
                }
            }
        }
    }

    /**
     * returns the index of a random <code>Image</code> in the texture
     * ArrayList.
     *
     * @see dwarf.random#interger(int)
     *
     * @return returns the index of a random texture.
     */
    public int randomTexture() {
        return random.interger(getNumtextures());
    }

    @Override
    public Sprite clone() throws CloneNotSupportedException {
        return new Sprite(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(textures);
        hash = 67 * hash + Objects.hashCode(activeTexture);
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
        } else if (super.getClass() != obj.getClass()) {
            return false;
        }

        final Sprite other = (Sprite) obj;

        if (!Objects.equals(this.textures, other.textures)) {
            return false;
        } else if (!Objects.equals(this.activeTexture, other.activeTexture)) {
            return false;
        }

        return true;
    }

    /**
     * Returns a string representation of the object.
     * <p>
     * In general, the toString method returns a string that "textually
     * represents" this object. The result should be a concise but informative
     * representation that is easy for a person to read. It is recommended that
     * all subclasses override this method.</p>
     *
     * @return a textually representation of this object
     */
    @Override
    public String toString() {
        return "Sprite[" + "textures: " + textures + ", activeTexture: " + activeTexture + "]";
    }
}
