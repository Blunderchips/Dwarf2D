package dwarf.gfx;

import dwarf.GameObject;
import dwarf.util.Vector2;
import dwarf.random;
import java.util.ArrayList;

/**
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.gfx.Image
 * @see dwarf.GameObject
 * @see dwarf.Collidable
 * @see java.lang.Object
 */
public class Sprite extends dwarf.Collidable implements GameObject {

    private ArrayList<Image> textures;
    private Image activeTexture;

    public Sprite(Image image) {
        super();

        this.textures = new ArrayList<>();
        this.textures.add(image);
        this.activeTexture = textures.get(0);
    }

    public Sprite(Image image, Vector2 position) {
        super(position);

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

    public boolean setTextures(Image[] textures) {
        try {
            this.textures.clear();

            for (Image image : textures) {
                this.textures.add(image);
            }
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    public boolean setTextures(ArrayList<Image> textures) {
        try {
            this.textures = textures;
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
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
    public boolean addTexture(Image input) {
        try {
            return this.textures.add(input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to add a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be added.
     * @return true if successful and false if it fails.
     */
    public boolean addTexture(Object input) {
        try {
            return this.textures.add((Image) input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be removed.
     * @return true if successful and false if it fails.
     */
    public boolean removeTexture(Image input) {
        try {
            return this.textures.remove(input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
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
    public boolean removeGameObject(Object input) {
        try {
            return this.textures.remove(input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param index of the <code>GameObject</code> to be removed.
     * @return true if successful and false if it fails.
     */
    public boolean removeGameObject(int index) {
        try {
            this.textures.remove(index);
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
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
     * @see dwarf.util.rand#interger(int)
     *
     * @return returns the index of a random texture.
     */
    public int randomTexture() {
        return random.interger(getNumtextures());
    }
}
