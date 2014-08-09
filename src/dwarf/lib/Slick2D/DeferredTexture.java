package dwarf.lib.Slick2D;

import java.io.IOException;
import java.io.InputStream;

/**
 * A texture proxy that can be used to load a texture at a later date while
 * still allowing elements to reference it
 *
 * @author kevin
 */
public class DeferredTexture extends TextureImpl {

    /**
     * The stream to read the texture from
     */
    private InputStream in;
    /**
     * The name of the resource to load
     */
    private String resourceName;
    /**
     * True if the image should be flipped
     */
    private boolean flipped;
    /**
     * The filter to apply to the texture
     */
    private int filter;
    /**
     * The texture we're proxying for
     */
    private TextureImpl target;
    /**
     * The color to be transparent
     */
    private int[] trans;

    /**
     * Create a new deferred texture
     *
     * @param in The input stream from which to read the texture
     * @param resourceName The name to give the resource
     * @param flipped True if the image should be flipped
     * @param filter The filter to apply
     * @param trans The colour to defined as transparent
     */
    public DeferredTexture(InputStream in, String resourceName, boolean flipped, int filter, int[] trans) {
        this.in = in;
        this.resourceName = resourceName;
        this.flipped = flipped;
        this.filter = filter;
        this.trans = trans;

        LoadingList.get().add((DeferredResource) this);
    }

    /**
     * @throws java.io.IOException throws an IOException if failed
     */
    public void load() throws IOException {
        boolean before = InternalTextureLoader.get().isDeferredLoading();
        InternalTextureLoader.get().setDeferredLoading(false);
        target = InternalTextureLoader.get().getTexture(in, resourceName, flipped, filter, trans);
        InternalTextureLoader.get().setDeferredLoading(before);
    }

    /**
     * Check if the target has been obtained already
     */
    private void checkTarget() {
        if (target == null) {
            try {
                load();
                LoadingList.get().remove((DeferredResource) this);
            } catch (IOException e) {
                throw new RuntimeException("Attempt to use deferred texture before loading and resource not found: " + resourceName);
            }
        }
    }

    @Override
    public void bind() {
        checkTarget();

        target.bind();
    }

    @Override
    public float getHeight() {
        checkTarget();

        return target.getHeight();
    }

    @Override
    public int getImageHeight() {
        checkTarget();
        return target.getImageHeight();
    }

    @Override
    public int getImageWidth() {
        checkTarget();
        return target.getImageWidth();
    }

    @Override
    public int getTextureHeight() {
        checkTarget();
        return target.getTextureHeight();
    }

    @Override
    public int getTextureID() {
        checkTarget();
        return target.getTextureID();
    }

    @Override
    public String getTextureRef() {
        checkTarget();
        return target.getTextureRef();
    }

    @Override
    public int getTextureWidth() {
        checkTarget();
        return target.getTextureWidth();
    }

    @Override
    public float getWidth() {
        checkTarget();
        return target.getWidth();
    }

    @Override
    public void release() {
        checkTarget();
        target.release();
    }

    @Override
    public void setAlpha(boolean alpha) {
        checkTarget();
        target.setAlpha(alpha);
    }

    @Override
    public void setHeight(int height) {
        checkTarget();
        target.setHeight(height);
    }

    @Override
    public void setTextureHeight(int texHeight) {
        checkTarget();
        target.setTextureHeight(texHeight);
    }

    @Override
    public void setTextureID(int textureID) {
        checkTarget();
        target.setTextureID(textureID);
    }

    @Override
    public void setTextureWidth(int texWidth) {
        checkTarget();
        target.setTextureWidth(texWidth);
    }

    @Override
    public void setWidth(int width) {
        checkTarget();
        target.setWidth(width);
    }

    @Override
    public byte[] getTextureData() {
        checkTarget();
        return target.getTextureData();
    }

    public String getDescription() {
        return resourceName;
    }

    @Override
    public boolean hasAlpha() {
        checkTarget();
        return target.hasAlpha();
    }

    /**
     * @param textureFilter the texture filter to be inputed
     */
    @Override
    public void setTextureFilter(int textureFilter) {
        checkTarget();
        target.setTextureFilter(textureFilter);
    }
}
