package dwarf.gfx;

/**
 * A simple wrapper round the values required for a mutable colour class.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Object
 * @see java.lang.Cloneable
 * @see dwarf.gfx.Colours
 */
@SuppressWarnings("serial")
public class Colour extends java.lang.Object implements Cloneable, Colours {

    /**
     * the colour the colour to be inputed. In the default sRGB space.
     *
     * @param colour the colour to be inputed
     */
    public static void setColour(Colour colour) {
        Colour.setColour(colour.getRed(), colour.getGreen(), colour.getBlue(), colour.getAlpha());
    }

    /**
     * @param colour (RBG)
     */
    public static void setColour(dwarf.util.Vector3 colour) {
        Colour.setColour(new Colour((float) colour.getX(), (float) colour.getY(), (float) colour.getZ(), 1));
    }

    /**
     * @param red the red component of the colour
     * @param green the green component of the colour
     * @param blue the blue component of the colour
     */
    public static void setColour(float red, float green, float blue) {
        Colour.setColour(red, green, blue, 1);
    }

    public static void setColour(java.awt.Color colour) {
        Colour.setColour(colour.getRed(), colour.getGreen(), colour.getBlue(), colour.getAlpha());
    }

    /**
     * @param red the red component of the colour
     * @param green the green component of the colour
     * @param blue the blue component of the colour
     * @param alpha the alpha component of the colour
     */
    public static void setColour(float red, float green, float blue, float alpha) {
        org.lwjgl.opengl.GL11.glColor4d(red, green, blue, alpha);
    }

    /**
     * the red component of the colour.
     */
    private float red;
    /**
     * the green component of the colour.
     */
    private float green;
    /**
     * the blue component of the colour.
     */
    private float blue;

    private float alpha = 0x1;

    /**
     * Default constructor.
     */
    public Colour() {
        super();

        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    public Colour(Colour colour) {
        super();

        this.red = colour.getRed();
        this.green = colour.getGreen();
        this.blue = colour.getBlue();
        this.alpha = colour.getAlpha();
    }

    public Colour(dwarf.util.Vector3 colour) {
        super();

        this.red = (float) colour.getX();
        this.green = (float) colour.getY();
        this.blue = (float) colour.getZ();
    }

    public Colour(dwarf.util.Vector3 colour, float alpha) {
        super();

        this.red = (float) colour.getX();
        this.green = (float) colour.getY();
        this.blue = (float) colour.getZ();
        this.alpha = alpha;
    }

    public Colour(float red, float green, float blue) {
        super();

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 1;
    }

    public Colour(float red, float green, float blue, float alpha) {
        super();

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public Colour(java.awt.Color colour) {
        super();

        this.red = colour.getRed();
        this.green = colour.getGreen();
        this.blue = colour.getBlue();
        this.alpha = colour.getAlpha();
    }

    /**
     * Create a colour from an evil integer packed 0xAARRGGBB. If AA is
     * specified as zero then it will be interpreted as unspecified and hence a
     * value of 255 will be recorded.
     *
     * @param value The value to interpret for the colour
     */
    public Colour(int value) {
        this.red = (((value & 0x00FF0000) >> 0x10) / 255.0f);
        this.green = (((value & 0x0000FF00) >> 0x8) / 255.0f);
        this.blue = ((value & 0x000000FF) / 255.0f);

        this.alpha = ((value & 0xFF000000) >> 0x18) / 255.0f;

        if (alpha < 0) {
            alpha += 0x100;
        }
        if (alpha == 0) {
            alpha = 0xff;
        }
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
     * Bind this colour to the GL context.
     */
    public void bind() {
        org.lwjgl.opengl.GL11.glColor4d(red, blue, green, alpha);
    }

    @Override
    public String toString() {
        return "Colour[" + getRed() + ", " + getGreen() + ", " + getBlue() + ", " + getAlpha() + "]";
    }

    public Colour get() {
        return this;
    }

    /**
     * Make a brighter instance of this colour.
     *
     * @return returns a brighter colour
     */
    public Colour brighter() {
        return brighter(0.2f);
    }

    public float getRedByte() {
        return this.red * 0xff;
    }

    public float getGreenByte() {
        return this.green * 0xff;
    }

    public float getBlueByte() {
        return this.blue * 0xff;
    }

    public float getAlphaByte() {
        return (this.alpha * 0xff);
    }

    /**
     * Make a brighter instance of this colour.
     *
     * @param scale what the colour is to be scaled by
     * @return a scales up colour
     */
    public Colour brighter(float scale) {
        return new Colour(this.getRed() * scale + 1, this.getGreen() * scale + 1, this.getBlue() * scale + 1, this.getAlpha());
    }

    /**
     * Scale the components of the colour by the given value.
     *
     * @param value The value to scale by
     */
    public void scale(float value) {
        this.red = (this.getRed() * value);
        this.green = (this.getGreen() * value);
        this.blue = (this.getBlue() * value);
        this.alpha *= value;
    }

    public void setRed(float r) {
        this.red = r;
    }

    public void setGreen(float g) {
        this.green = g;
    }

    public void setBlue(float b) {
        this.blue = b;
    }

    public void setAlpha(float a) {
        this.alpha = a;
    }

    public float getRed() {
        return this.red;
    }

    public float getGreen() {
        return this.green;
    }

    public float getBlue() {
        return this.blue;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void realse() {
        org.lwjgl.opengl.GL11.glColor4d(0xff, 0xff, 0xff, 1);
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
     * Class Object is the root of the class hierarchy. Every class has Object
     * as a superclass. All objects, including arrays, implement the methods of
     * this class.
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (79 * hash + this.red);
        hash = (int) (79 * hash + this.green);
        hash = (int) (79 * hash + this.blue);
        hash = 79 * hash + Float.floatToIntBits(this.alpha);
        return hash;
    }

    /**
     * Read a color from a byte buffer
     *
     * @param src The source buffer
     */
    public void readABGR(java.nio.ByteBuffer src) {
        this.setAlpha(src.get());
        this.setBlue(src.get());
        this.setGreen(src.get());
        this.setRed(src.get());
    }

    public void writeRGBA(java.nio.ByteBuffer dest) {
        dest.put((byte) this.getRed());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getBlue());
        dest.put((byte) this.getAlpha());
    }

    public void writeRGB(java.nio.ByteBuffer dest) {
        dest.put((byte) this.getRed());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getBlue());
    }

    public void writeABGR(java.nio.ByteBuffer dest) {
        dest.put((byte) this.getAlpha());
        dest.put((byte) this.getBlue());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getRed());
    }

    public void writeARGB(java.nio.ByteBuffer dest) {
        dest.put((byte) this.getAlpha());
        dest.put((byte) this.getRed());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getBlue());
    }

    public void writeBGR(java.nio.ByteBuffer dest) {
        dest.put((byte) this.getBlue());
        dest.put((byte) this.getGreen());
        dest.put((byte) this.getRed());
    }

    public void writeBGRA(java.nio.ByteBuffer dest) {
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
    public void readRGBA(java.nio.ByteBuffer src) {
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
    public void readRGB(java.nio.ByteBuffer src) {
        this.setRed(src.get());
        this.setGreen(src.get());
        this.setBlue(src.get());
    }

    /**
     * Read a color from a byte buffer
     *
     * @param src The source buffer
     */
    public void readARGB(java.nio.ByteBuffer src) {
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
    public void readBGRA(java.nio.ByteBuffer src) {
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
    public void readBGR(java.nio.ByteBuffer src) {
        this.setBlue(src.get());
        this.setGreen(src.get());
        this.setRed(src.get());
    }

    /**
     * RGB to HSB conversion, pinched from java.awt.Colour. The HSB value is
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
     * HSB to RGB conversion, pinched from java.awt.Colour.
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
            this.setBlue((brightness * 255F + 0.5F));

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
    public Colour clone() throws CloneNotSupportedException {
        return new Colour(this);
    }

    public dwarf.util.Vector3 toVector3() {
        return new dwarf.util.Vector3(
                this.getRed(),
                this.getGreen(),
                this.getBlue()
        );
    }

    public void set(Colour colour) {
        this.red = colour.getRed();
        this.green = colour.getGreen();
        this.blue = colour.getBlue();
        this.alpha = colour.getAlpha();
    }

    public void set(dwarf.util.Vector3 colour) {
        this.red = (float) colour.getX();
        this.green = (float) colour.getY();
        this.blue = (float) colour.getZ();
    }

    public void set(dwarf.util.Vector3 colour, float alpha) {
        this.red = (float) colour.getX();
        this.green = (float) colour.getY();
        this.blue = (float) colour.getZ();
        this.alpha = alpha;
    }

    public void set(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 1;
    }

    public void set(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public void set(java.awt.Color colour) {
        this.red = colour.getRed();
        this.green = colour.getGreen();
        this.blue = colour.getBlue();
        this.alpha = colour.getAlpha();
    }

    public java.awt.Color toColor() {
        return new java.awt.Color(red, green, blue, alpha);
    }
}
