package dwarf.lib.Slick2D;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

/**
 * An image data implementation which represents an empty texture
 *
 * @author kevin
 */
public class EmptyImageData implements ImageData {

    /**
     * The width of the data
     */
    private int width;
    /**
     * The height of the data
     */
    private int height;

    /**
     * Create an empty image data source
     *
     * @param width The width of the source
     * @param height The height of the source
     */
    public EmptyImageData(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getDepth() {
        return 32;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public ByteBuffer getImageBufferData() {
        return BufferUtils.createByteBuffer(getTexWidth() * getTexHeight() * 4);
    }

    @Override
    public int getTexHeight() {
        return InternalTextureLoader.get2Fold(height);
    }

    @Override
    public int getTexWidth() {
        return InternalTextureLoader.get2Fold(width);
    }

    @Override
    public int getWidth() {
        return width;
    }

}
