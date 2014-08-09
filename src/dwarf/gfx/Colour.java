package dwarf.gfx;

import dwarf.util.Vector3;
import java.io.Serializable;
import java.nio.ByteBuffer;
import static org.lwjgl.opengl.GL11.glColor4d;
import static org.lwjgl.opengl.GL11.glColor4f;

/**
 * A simple wrapper round the values required for a mutable colour class.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Object
 * @see dwarf.util.Vector3
 */
@SuppressWarnings("serial")
public class Colour extends dwarf.util.Vector3 implements Serializable, Cloneable {

    public static final Colour white = new Colour(0xff, 0xff, 0xff, 0xff);
    public static final Colour yellow = new Colour(0xff, 0xff, 0x0, 0xff);
    public static final Colour red = new Colour(0xff, 0x0, 0x0, 0xff);
    public static final Colour blue = new Colour(0x0, 0x0, 0xff, 0xff);
    public static final Colour lime = new Colour(0x0, 0xff, 0x0, 0xff);
    public static final Colour black = new Colour(0x0, 0x0, 0x0, 0xff);
    public static final Colour grey = new Colour(0.5f, 0.5f, 0.5f, 0xff);
    public static final Colour aqua = new Colour(0x0, 0xff, 0xff, 0xff);
    public static final Colour darkGrey = new Colour(0.3f, 0.3f, 0.3f, 0xff);
    public final static Colour magenta = new Colour(0xff, 0x0, 0xff, 0xff);

    private double alpha = 0x1;

    /**
     * @param colour the colour to be inputed
     */
    public static void setColour(Colour colour) {
        glColor4d(colour.getX(), colour.getY(), colour.getZ(), colour.getAlpha());
    }

    /**
     * @param colours (RBG)
     */
    public static void setColour(Vector3 colours) {
        setColour(new Colour(colours.getX(), colours.getY(), colours.getZ(), 1));
    }

    /**
     * @param red the red component of the colour
     * @param green the green component of the colour
     * @param blue the blue component of the colour
     */
    public static void setColour(byte red, byte green, byte blue) {
        setColour(red, green, blue, 1);
    }

    /**
     * @param red the red component of the colour
     * @param green the green component of the colour
     * @param blue the blue component of the colour
     * @param alpha the alpha component of the colour
     */
    public static void setColour(byte red, byte green, byte blue, double alpha) {
        glColor4d(red, green, blue, alpha);
    }

    public Colour() {
        super(0, 0, 0);
    }

    public Colour(Colour colour) {
        super(colour.getX(), colour.getY(), colour.getZ());
        this.alpha = colour.getAlpha();
    }

    public Colour(Vector3 input) {
        super(input.getX(), input.getY(), input.getZ());
    }

    public Colour(Vector3 input, float alpha) {
        super(input.getX(), input.getY(), input.getZ());
        this.alpha = alpha;
    }

    public Colour(double red, double green, double blue) {
        super(red, green, blue);
    }

    public Colour(double red, double green, double blue, double alpha) {
        super(red, green, blue);
        this.alpha = alpha;
    }

    public Colour(byte red, byte green, byte blue, byte alpha) {
        super(red, green, blue);
        this.alpha = alpha;
    }

    public Colour(byte red, byte green, byte blue) {
        super(red, green, blue);
    }

    /**
     * Create a colour from an evil integer packed 0xAARRGGBB. If AA is
     * specified as zero then it will be interpreted as unspecified and hence a
     * value of 255 will be recorded.
     *
     * @param value The value to interpret for the colour
     */
    public Colour(int value) {
        int red = (value & 0x00FF0000) >> 0x10;
        int green = (value & 0x0000FF00) >> 0x8;
        int blue = (value & 0x000000FF);
        int alpha = (value & 0xFF000000) >> 0x18;

        if (alpha < 0x0) {
            alpha += 0x100;
        }
        if (alpha == 0x0) {
            alpha = 0xff;
        }

        this.setX(red / 255.0f);
        this.setY(green / 255.0f);
        this.setZ(blue / 255.0f);
        this.setAlpha(alpha / 255.0f);
    }

    /**
     * Decode a number in a string and process it as a colour reference.
     *
     * @param nm The number string to decode
     * @return The color generated from the number read
     */
    public static Colour decode(String nm) {
        return new Colour(Integer.decode(nm));
    }

    /**
     * Bind this colour to the GL context
     */
    public void bind() {
        glColor4d(this.getX(), this.getY(), this.getZ(), this.getAlpha());
    }

    @Override
    public String toString() {
        return "Color [" + getRed() + ", " + getGreen() + ", " + getBlue() + ", " + getAlpha() + "]";
    }

    public Colour get() {
        return this;
    }

    /**
     * Make a brighter instance of this colour
     *
     * @return returns a brighter colour
     */
    public Colour brighter() {
        return brighter(0.2f);
    }

    public int getRedByte() {
        return (int) (this.getX() * 0xff);
    }

    public int getGreenByte() {
        return (int) (this.getY() * 0xff);
    }

    public int getBlueByte() {
        return (int) (this.getZ() * 0xff);
    }

    public int getAlphaByte() {
        return (int) (this.alpha * 0xff);
    }

    /**
     * Make a brighter instance of this colour
     *
     * @param scale what the colour is to be scaled by
     * @return a scales up colour
     */
    public Colour brighter(float scale) {
        scale += 1;
        Colour temp = new Colour((float) this.getX() * scale, (float) this.getY() * scale, (float) this.getZ() * scale, this.getAlpha());

        return temp;
    }

    /**
     * Scale the components of the colour by the given value
     *
     * @param value The value to scale by
     */
    public void scale(float value) {
        this.setRed((float) getX() * value);
        this.setGreen((float) this.getY() * value);
        this.setBlue((float) this.getZ() * value);
        this.alpha *= value;
    }

    /**
     * Add another colour to this one
     *
     * @param c The colour to add
     * @return The copy which has had the color added to it
     */
    public Colour addToCopy(Colour c) {
        Colour copy = new Colour(this.getX(), this.getY(), this.getZ(), this.getAlpha());
        copy.changeX(c.getX());
        copy.changeY(c.getY());
        copy.changeZ(c.getZ());
        copy.alpha += c.getAlpha();

        return copy;
    }

    public void setRed(float r) {
        this.setX(r);
    }

    public void setGreen(float g) {
        this.setY(g);
    }

    public void setBlue(float b) {
        this.setZ(b);
    }

    public void setAlpha(float a) {
        this.alpha = a;
    }

    public double getRed() {
        return this.getX();
    }

    public double getGreen() {
        return this.getY();
    }

    public double getBlue() {
        return this.getZ();
    }

    public double getAlpha() {
        return this.alpha;
    }

    public void realse() {
        glColor4f(0xff, 0xff, 0xff, 1);
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
        int hash = 3;
        hash = 97 * hash + Float.floatToIntBits((float) this.getAlpha());
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
        return (obj != null)
                && (obj instanceof Colour)
                && (((Colour) obj).getRed() == this.getRed())
                && (((Colour) obj).getGreen() == this.getGreen())
                && (((Colour) obj).getBlue() == this.getBlue())
                && (((Colour) obj).getAlpha() == this.getAlpha());
    }

    /**
     * Read a color from a byte buffer
     *
     * @param src The source buffer
     */
    public void readABGR(ByteBuffer src) {
        this.setAlpha(src.get());
        this.setBlue(src.get());
        this.setGreen(src.get());
        this.setRed(src.get());
    }

    public void writeRGBA(ByteBuffer dest) {
        dest.put((byte) this.getRed());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getBlue());
        dest.put((byte) this.getAlpha());
    }

    public void writeRGB(ByteBuffer dest) {
        dest.put((byte) this.getRed());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getBlue());
    }

    public void writeABGR(ByteBuffer dest) {
        dest.put((byte) this.getAlpha());
        dest.put((byte) this.getBlue());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getRed());
    }

    public void writeARGB(ByteBuffer dest) {
        dest.put((byte) this.getAlpha());
        dest.put((byte) this.getRed());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getBlue());
    }

    public void writeBGR(ByteBuffer dest) {
        dest.put((byte) this.getBlue());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getRed());
    }

    public void writeBGRA(ByteBuffer dest) {
        dest.put((byte) this.getBlue());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getRed());
        dest.put((byte) this.getAlpha());
    }

    /**
     * Read a color from a byte buffer
     *
     * @param src The source buffer
     */
    public void readRGBA(ByteBuffer src) {
        this.setRed(src.get());
        this.setGreen(src.get());
        this.setBlue(src.get());
        this.setAlpha(src.get());
    }

    /**
     * Read a color from a byte buffer
     *
     * @param src The source buffer
     */
    public void readRGB(ByteBuffer src) {
        this.setRed(src.get());
        this.setGreen(src.get());
        this.setBlue(src.get());
    }

    /**
     * Read a color from a byte buffer
     *
     * @param src The source buffer
     */
    public void readARGB(ByteBuffer src) {
        this.setAlpha(src.get());
        this.setRed(src.get());
        this.setGreen(src.get());
        this.setBlue(src.get());
    }

    /**
     * Read a color from a byte buffer
     *
     * @param src The source buffer
     */
    public void readBGRA(ByteBuffer src) {
        this.setBlue(src.get());
        this.setGreen(src.get());
        this.setRed(src.get());
        this.setAlpha(src.get());
    }

    /**
     * Read a color from a byte buffer
     *
     * @param src The source buffer
     */
    public void readBGR(ByteBuffer src) {
        this.setBlue(src.get());
        this.setGreen(src.get());
        this.setRed(src.get());
    }

    /**
     * RGB to HSB conversion, pinched from java.awt.Color. The HSB value is
     * returned in dest[] if dest[] is supplied. Values range from 0..1
     *
     * @param dest Destination floats, or null
     * @return dest, or a new float array
     */
    public double[] toHSB(double dest[]) {
        double r = getRed();
        double g = getGreen();
        double b = getBlue();
        if (dest == null) {
            dest = new double[3];
        }
        double l = r <= g ? g : r;
        if (b > l) {
            l = b;
        }
        double i1 = r >= g ? g : r;
        if (b < i1) {
            i1 = b;
        }
        double brightness = l / 255F;
        double saturation;
        if (l != 0) {
            saturation = (l - i1) / l;
        } else {
            saturation = 0.0F;
        }
        double hue;
        if (saturation == 0.0F) {
            hue = 0.0F;
        } else {
            double f3 = (l - r) / (l - i1);
            double f4 = (l - g) / (l - i1);
            double f5 = (l - b) / (l - i1);
            if (r == l) {
                hue = f5 - f4;
            } else if (g == l) {
                hue = (2.0F + f3) - f5;
            } else {
                hue = (4F + f4) - f3;
            }
            hue /= 6F;
            if (hue < 0.0F) {
                hue++;
            }
        }
        dest[0] = hue;
        dest[1] = saturation;
        dest[2] = brightness;
        return dest;
    }

    /**
     * HSB to RGB conversion, pinched from java.awt.Color.
     *
     * @see java.awt.Color
     *
     * @param hue (0..1.0f)
     * @param saturation (0..1.0f)
     * @param brightness (0..1.0f)
     */
    public void fromHSB(float hue, float saturation, float brightness) {
        if (saturation == 0.0F) {

            this.setRed(brightness * 255F + 0.5F);
            this.setGreen(brightness * 255F + 0.5F);
            this.setBlue(brightness * 255F + 0.5F);

        } else {

            float f3 = (hue - (float) Math.floor(hue)) * 6F;
            float f4 = f3 - (float) Math.floor(f3);
            float f5 = brightness * (1.0F - saturation);
            float f6 = brightness * (1.0F - saturation * f4);
            float f7 = brightness * (1.0F - saturation * (1.0F - f4));

            switch ((int) f3) {
                case 0:
                    this.setRed(brightness * 255F + 0.5F);
                    this.setGreen(f7 * 255F + 0.5F);
                    this.setBlue(f5 * 255F + 0.5F);
                    break;
                case 1:
                    this.setRed((f6 * 255F + 0.5F));
                    this.setGreen(brightness * 255F + 0.5F);
                    this.setBlue(f5 * 255F + 0.5F);
                    break;
                case 2:
                    this.setRed(f5 * 255F + 0.5F);
                    this.setGreen(brightness * 255F + 0.5F);
                    this.setBlue(f7 * 255F + 0.5F);
                    break;
                case 3:
                    this.setRed(f5 * 255F + 0.5F);
                    this.setGreen(f6 * 255F + 0.5F);
                    this.setBlue(brightness * 255F + 0.5F);
                    break;
                case 4:
                    this.setRed(f7 * 255F + 0.5F);
                    this.setGreen(f5 * 255F + 0.5F);
                    this.setBlue(brightness * 255F + 0.5F);
                    break;
                case 5:
                    this.setRed(brightness * 255F + 0.5F);
                    this.setGreen(f5 * 255F + 0.5F);
                    this.setBlue(f6 * 255F + 0.5F);
                    break;
            }
        }
    }

    @Override
    public Vector3 clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
