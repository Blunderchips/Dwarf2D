package dwarf.lib.Slick2D;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * A composite data source that checks multiple loaders in order of preference
 *
 * @author kevin
 */
public class CompositeImageData implements LoadableImageData {

    /**
     * The list of images sources in order of preference to try loading the data
     * with
     */
    private ArrayList sources = new ArrayList();
    /**
     * The data source that worked and was used - or null if no luck
     */
    private LoadableImageData picked;

    /**
     * Add a potentional source of image data
     *
     * @param data The data source to try
     */
    @SuppressWarnings("unchecked")
    public void add(LoadableImageData data) {
        sources.add(data);
    }

    /**
     * @throws java.io.IOException
     * @see
     * org.newdawn.slick.opengl.LoadableImageData#loadImage(java.io.InputStream)
     */
    @Override
    public ByteBuffer loadImage(InputStream fis) throws IOException {
        return loadImage(fis, false, null);
    }

    /**
     * @throws java.io.IOException
     * @see
     * org.newdawn.slick.opengl.LoadableImageData#loadImage(java.io.InputStream,
     * boolean, int[])
     */
    @Override
    public ByteBuffer loadImage(InputStream fis, boolean flipped, int[] transparent) throws IOException {
        return loadImage(fis, flipped, false, transparent);
    }

    /**
     * @param is
     * @throws java.io.IOException
     * @see
     * org.newdawn.slick.opengl.LoadableImageData#loadImage(java.io.InputStream,
     * boolean, boolean, int[])
     */
    @Override
    public ByteBuffer loadImage(InputStream is, boolean flipped, boolean forceAlpha, int[] transparent) throws IOException {
        CompositeIOException exception = new CompositeIOException();
        ByteBuffer buffer = null;

        BufferedInputStream in = new BufferedInputStream(is, is.available());
        in.mark(is.available());

        for (Object source : sources) {
            in.reset();
            try {
                LoadableImageData data = (LoadableImageData) source;
                buffer = data.loadImage(in, flipped, forceAlpha, transparent);
                picked = data;
                break;
            } catch (IOException ex) {
                exception.addException(ex);
            }
        }

        if (picked == null) {
            throw exception;
        }

        return buffer;
    }

    /**
     * Check the state of the image data and throw a runtime exception if theres
     * a problem
     */
    private void checkPicked() {
        if (picked == null) {
            throw new RuntimeException("Attempt to make use of uninitialised or invalid composite image data");
        }
    }

    /**
     * @see org.newdawn.slick.opengl.ImageData#getDepth()
     */
    @Override
    public int getDepth() {
        checkPicked();

        return picked.getDepth();
    }

    /**
     * @see org.newdawn.slick.opengl.ImageData#getHeight()
     */
    @Override
    public int getHeight() {
        checkPicked();

        return picked.getHeight();
    }

    /**
     * @see org.newdawn.slick.opengl.ImageData#getImageBufferData()
     */
    @Override
    public ByteBuffer getImageBufferData() {
        checkPicked();

        return picked.getImageBufferData();
    }

    /**
     * @see org.newdawn.slick.opengl.ImageData#getTexHeight()
     */
    @Override
    public int getTexHeight() {
        checkPicked();

        return picked.getTexHeight();
    }

    /**
     * @see org.newdawn.slick.opengl.ImageData#getTexWidth()
     */
    @Override
    public int getTexWidth() {
        checkPicked();

        return picked.getTexWidth();
    }

    /**
     * @see org.newdawn.slick.opengl.ImageData#getWidth()
     */
    @Override
    public int getWidth() {
        checkPicked();

        return picked.getWidth();
    }

    /**
     * @see org.newdawn.slick.opengl.LoadableImageData#configureEdging(boolean)
     */
    @Override
    @SuppressWarnings("unchecked")
    public void configureEdging(boolean edging) {
        sources.stream().forEach((source) -> {
            ((LoadableImageData) source).configureEdging(edging);
        });
    }

}
