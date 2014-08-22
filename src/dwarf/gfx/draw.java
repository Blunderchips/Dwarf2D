package dwarf.gfx;

import java.util.Arrays;
import dwarf.util.Vector2;
import dwarf.lib.Slick2D.Texture;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static dwarf.util.math.TWO_PI;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_POINTS;
import static org.lwjgl.opengl.GL11.GL_POLYGON;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glFlush;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotated;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.opengl.GL11.glVertex2f;

/**
 * draws shapes to the screen using <a href='http://www.opengl.org/'>OpenGL</a>.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public final class draw {

    /**
     * you can not instantiate this class.
     */
    public draw() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    /**
     * 3 sided shape
     *
     * @see <a href='http://en.wikipedia.org/wiki/Triangle'>wikipedia</a>
     */
    public final static byte SHAPE_TRIANGLE = 0x3;
    /**
     * 4 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Square'>wikipedia</a>
     */
    public final static byte SHAPE_SQUARE = 0x4;
    /**
     * 5 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Pentagon'>wikipedia</a>
     */
    public final static byte SHAPE_PENTAGON = 0x5;
    /**
     * 6 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Hexagon'>wikipedia</a>
     */
    public final static byte SHAPE_HEXAGON = 0x6;
    /**
     * 7 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Heptagon'>wikipedia</a>
     */
    public final static byte SHAPE_HEPTAGON = 0x7;
    /**
     * 8 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Octagon'>wikipedia</a>
     */
    public final static byte SHAPE_OCTAGON = 0x8;
    /**
     * 9 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Nonagon'>wikipedia</a>
     */
    public final static byte SHAPE_NONAGON = 0x9;
    /**
     * 10 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Decagon'>wikipedia</a>
     */
    public final static byte SHAPE_DECAGON = 0xa;
    /**
     * 11 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Hendecagon'>wikipedia</a>
     */
    public final static byte SHAPE_HENDECAGON = 0xb;
    /**
     * 12 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Dodecagon'>wikipedia</a>
     */
    public final static byte SHAPE_DODECAGON = 0xc;
    /**
     * 13 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Tridecagon'>wikipedia</a>
     */
    public final static byte SHAPE_TRISKAIDECAGON = 0xd;
    /**
     * 14 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Tetradecagon'>wikipedia</a>
     */
    public final static byte SHAPE_TETRAKAIDECAGON = 0xe;
    /**
     * 15 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Pentadecagon'>wikipedia</a>
     */
    public final static byte SHAPE_PENTAKAIDECAGON = 0xf;
    /**
     * 16 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Hexadecagon'>wikipedia</a>
     */
    public final static byte SHAPE_HEXAKAIDECAGON = 0x10;
    /**
     * 17 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Heptakaidecagon'>wikipedia</a>
     */
    public final static byte SHAPE_HEPTAKAIDECAGON = 0x11;
    /**
     * 18 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Octadecagon'>wikipedia</a>
     */
    public final static byte SHAPE_OCTAKAIDECAGON = 0x12;
    /**
     * 19 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Enneadecagon'>wikipedia</a>
     */
    public final static byte SHAPE_ENNEAKAIDECAGON = 0x13;
    /**
     * 20 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Icosagon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSAGON = 0x14;
    /**
     * 21 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Icosikaihenagon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSIKAIHENAGON = 0x15;
    /**
     * 22 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Icosikaihexagon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSIKAIHEXAGON = 0x16;
    /**
     * 23 sided shape.
     *
     * @see <a
     * href='http://en.wikipedia.org/wiki/Icosikaitetragon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSIKAITRIGON = 0x17;
    /**
     * 24 sided shape.
     *
     * @see <a
     * href='http://en.wikipedia.org/wiki/Icosikaitetragon'>wikipedia</a>
     */
    public final static byte SHAPE_ICOSIKAITETRAGON = 0x18;
    /**
     * 30 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Triacontagon'>wikipedia</a>
     */
    public static final byte SHAPE_TRIACONTAGON = 0x1e;
    /**
     * 50 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Pentacontagon'>wikipedia</a>
     */
    public static final byte SHAPE_PENTACONTAGON = 0x32;
    /**
     * 60 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Circle'>wikipedia</a>
     */
    public final static byte SHAPE_CIRCLE = 0x3c;
    /**
     * 100 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Hectogon'>wikipedia</a>
     */
    public static final byte SHAPE_HECTOGON = 0x64;
    /**
     * 1000 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Chiliagon'>wikipedia</a>
     */
    public static final short SHAPE_CHILIAGON = 0x3e8;
    /**
     * 10000 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Myriagon'>wikipedia</a>
     */
    public static final short SHAPE_MYRIAGON = 0x2710;
    /**
     * 1000000 sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Megagon'>wikipedia</a>
     */
    public static final short SHAPE_MEGAGON = 0x4240;
    /**
     * infinite sided shape.
     *
     * @see <a href='http://en.wikipedia.org/wiki/Apeirogon'>wikipedia</a>
     */
    public static final long SHAPE_APEIROGON = Long.MAX_VALUE;

    public final static String STATE_FILL = "fill";
    public final static String STATE_STROKE = "stroke";

    public static void fillRect(float width, float hieght, Vector2 translation, Colour colour) {
        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            colour.bind();

            glBegin(GL_POLYGON);
            {
                glVertex2f(0, 0);
                glVertex2f(0, hieght);
                glVertex2f(width, hieght);
                glVertex2f(width, 0);
            }

            glEnd();
            glFlush();

            colour.realse();
        }
        glPopMatrix();
    }

    public static void basicText(String string, Vector2 position, Colour colour) {
        basicText(string, (float) position.getX(), (float) position.getY(), colour);
    }

    public static void basicText(char[] string, Vector2 position, Colour colour) {
        basicText(Arrays.toString(string), (float) position.getX(), (float) position.getY(), colour);
    }

    public static void basicText(char[] string, float xPos, float yPos, Colour colour) {
        basicText(Arrays.toString(string), xPos, yPos, colour);
    }

    public static void basicText(String string, float xPos, float yPos, Colour colour) {
        float startX = xPos;

        glPushMatrix();
        {
            colour.bind();

            glBegin(GL_POINTS);
            {
                for (char letter : string.toLowerCase().toCharArray()) {
                    if (letter == 'a') {
                        for (byte i = 0; i < 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (letter == 'b') {
                        for (byte i = 0; i < 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (byte i = 1; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos);
                            glVertex2d(xPos + i, yPos + 4);
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        glVertex2d(xPos + 7, yPos + 5);
                        glVertex2d(xPos + 7, yPos + 7);
                        glVertex2d(xPos + 7, yPos + 6);

                        glVertex2d(xPos + 7, yPos + 1);
                        glVertex2d(xPos + 7, yPos + 2);
                        glVertex2d(xPos + 7, yPos + 3);
                        xPos += 8;
                    } else if (letter == 'c') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos);
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        glVertex2d(xPos + 6, yPos + 1);
                        glVertex2d(xPos + 6, yPos + 2);

                        glVertex2d(xPos + 6, yPos + 6);
                        glVertex2d(xPos + 6, yPos + 7);

                        xPos += 8;
                    } else if (letter == 'd') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos);
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        glVertex2d(xPos + 6, yPos + 1);
                        glVertex2d(xPos + 6, yPos + 2);
                        glVertex2d(xPos + 6, yPos + 3);
                        glVertex2d(xPos + 6, yPos + 4);
                        glVertex2d(xPos + 6, yPos + 5);
                        glVertex2d(xPos + 6, yPos + 6);
                        glVertex2d(xPos + 6, yPos + 7);

                        xPos += 8;
                    } else if (letter == 'e') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 1; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 0);
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (letter == 'f') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 1; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (letter == 'g') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos);
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        glVertex2d(xPos + 6, yPos + 1);
                        glVertex2d(xPos + 6, yPos + 2);
                        glVertex2d(xPos + 6, yPos + 3);
                        glVertex2d(xPos + 5, yPos + 3);
                        glVertex2d(xPos + 7, yPos + 3);

                        glVertex2d(xPos + 6, yPos + 6);
                        glVertex2d(xPos + 6, yPos + 7);

                        xPos += 8;
                    } else if (letter == 'h') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (letter == 'i') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 3, yPos + i);
                        }
                        for (byte i = 1; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 0);
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        xPos += 7;
                    } else if (letter == 'j') {
                        for (byte i = 1; i <= 8; i++) {
                            glVertex2d(xPos + 6, yPos + i);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 0);
                        }
                        glVertex2d(xPos + 1, yPos + 3);
                        glVertex2d(xPos + 1, yPos + 2);
                        glVertex2d(xPos + 1, yPos + 1);
                        xPos += 8;
                    } else if (letter == 'k') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        glVertex2d(xPos + 6, yPos + 8);
                        glVertex2d(xPos + 5, yPos + 7);
                        glVertex2d(xPos + 4, yPos + 6);
                        glVertex2d(xPos + 3, yPos + 5);
                        glVertex2d(xPos + 2, yPos + 4);
                        glVertex2d(xPos + 2, yPos + 3);
                        glVertex2d(xPos + 3, yPos + 4);
                        glVertex2d(xPos + 4, yPos + 3);
                        glVertex2d(xPos + 5, yPos + 2);
                        glVertex2d(xPos + 6, yPos + 1);
                        glVertex2d(xPos + 7, yPos);
                        xPos += 8;
                    } else if (letter == 'l') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 1; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos);
                        }
                        xPos += 7;
                    } else if (letter == 'm') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        glVertex2d(xPos + 3, yPos + 6);
                        glVertex2d(xPos + 2, yPos + 7);
                        glVertex2d(xPos + 4, yPos + 5);

                        glVertex2d(xPos + 5, yPos + 6);
                        glVertex2d(xPos + 6, yPos + 7);
                        glVertex2d(xPos + 4, yPos + 5);
                        xPos += 8;
                    } else if (letter == 'n') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        glVertex2d(xPos + 2, yPos + 7);
                        glVertex2d(xPos + 2, yPos + 6);
                        glVertex2d(xPos + 3, yPos + 5);
                        glVertex2d(xPos + 4, yPos + 4);
                        glVertex2d(xPos + 5, yPos + 3);
                        glVertex2d(xPos + 6, yPos + 2);
                        glVertex2d(xPos + 6, yPos + 1);
                        xPos += 8;
                    } else if (letter == 'o' || letter == '0') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                            glVertex2d(xPos + i, yPos + 0);
                        }
                        xPos += 8;
                    } else if (letter == 'p') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        glVertex2d(xPos + 6, yPos + 7);
                        glVertex2d(xPos + 6, yPos + 5);
                        glVertex2d(xPos + 6, yPos + 6);
                        xPos += 8;
                    } else if (letter == 'q') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            if (i != 1) {
                                glVertex2d(xPos + 7, yPos + i);
                            }
                        }
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                            if (i != 6) {
                                glVertex2d(xPos + i, yPos + 0);
                            }
                        }
                        glVertex2d(xPos + 4, yPos + 3);
                        glVertex2d(xPos + 5, yPos + 2);
                        glVertex2d(xPos + 6, yPos + 1);
                        glVertex2d(xPos + 7, yPos);
                        xPos += 8;
                    } else if (letter == 'r') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        glVertex2d(xPos + 6, yPos + 7);
                        glVertex2d(xPos + 6, yPos + 5);
                        glVertex2d(xPos + 6, yPos + 6);

                        glVertex2d(xPos + 4, yPos + 3);
                        glVertex2d(xPos + 5, yPos + 2);
                        glVertex2d(xPos + 6, yPos + 1);
                        glVertex2d(xPos + 7, yPos);
                        xPos += 8;
                    } else if (letter == 's') {
                        for (byte i = 2; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2d(xPos + 1, yPos + 7);
                        glVertex2d(xPos + 1, yPos + 6);
                        glVertex2d(xPos + 1, yPos + 5);
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 4);
                            glVertex2d(xPos + i, yPos);
                        }
                        glVertex2d(xPos + 7, yPos + 3);
                        glVertex2d(xPos + 7, yPos + 2);
                        glVertex2d(xPos + 7, yPos + 1);
                        glVertex2d(xPos + 1, yPos + 1);
                        glVertex2d(xPos + 1, yPos + 2);
                        xPos += 8;
                    } else if (letter == 't') {
                        for (byte i = 0; i <= 8; i++) {
                            glVertex2d(xPos + 4, yPos + i);
                        }
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        xPos += 7;
                    } else if (letter == 'u') {
                        for (byte i = 1; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 0);
                        }
                        xPos += 8;
                    } else if (letter == 'v') {
                        for (byte i = 2; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 6, yPos + i);
                        }
                        glVertex2d(xPos + 2, yPos + 1);
                        glVertex2d(xPos + 5, yPos + 1);
                        glVertex2d(xPos + 3, yPos);
                        glVertex2d(xPos + 4, yPos);
                        xPos += 7;
                    } else if (letter == 'w') {
                        for (byte i = 1; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        glVertex2d(xPos + 2, yPos);
                        glVertex2d(xPos + 3, yPos);
                        glVertex2d(xPos + 5, yPos);
                        glVertex2d(xPos + 6, yPos);
                        for (byte i = 1; i <= 6; i++) {
                            glVertex2d(xPos + 4, yPos + i);
                        }
                        xPos += 8;
                    } else if (letter == 'x') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + i, yPos + i);
                        }
                        for (byte i = 7; i >= 1; i--) {
                            glVertex2d(xPos + i, yPos + 8 - i);
                        }
                        xPos += 8;
                    } else if (letter == 'y') {
                        glVertex2d(xPos + 4, yPos);
                        glVertex2d(xPos + 4, yPos + 1);
                        glVertex2d(xPos + 4, yPos + 2);
                        glVertex2d(xPos + 4, yPos + 3);
                        glVertex2d(xPos + 4, yPos + 4);

                        glVertex2d(xPos + 3, yPos + 5);
                        glVertex2d(xPos + 2, yPos + 6);
                        glVertex2d(xPos + 1, yPos + 7);
                        glVertex2d(xPos + 1, yPos + 8);

                        glVertex2d(xPos + 5, yPos + 5);
                        glVertex2d(xPos + 6, yPos + 6);
                        glVertex2d(xPos + 7, yPos + 7);
                        glVertex2d(xPos + 7, yPos + 8);
                        xPos += 8;
                    } else if (letter == 'z') {
                        for (byte i = 1; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos);
                            glVertex2d(xPos + i, yPos + 8);
                            glVertex2d(xPos + i, yPos + i);
                        }
                        glVertex2f(xPos + 6, yPos + 7);
                        xPos += 8;
                    } else if (letter == '1') {
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos);
                        }
                        for (byte i = 1; i <= 8; i++) {
                            glVertex2d(xPos + 4, yPos + i);
                        }
                        glVertex2d(xPos + 3, yPos + 7);
                        xPos += 8;
                    } else if (letter == '2') {
                        for (byte i = 1; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        glVertex2d(xPos + 1, yPos + 7);
                        glVertex2d(xPos + 1, yPos + 6);

                        glVertex2d(xPos + 6, yPos + 7);
                        glVertex2d(xPos + 6, yPos + 6);
                        glVertex2d(xPos + 6, yPos + 5);
                        glVertex2d(xPos + 5, yPos + 4);
                        glVertex2d(xPos + 4, yPos + 3);
                        glVertex2d(xPos + 3, yPos + 2);
                        glVertex2d(xPos + 2, yPos + 1);
                        xPos += 8;
                    } else if (letter == '3') {
                        for (byte i = 1; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                            glVertex2d(xPos + i, yPos);
                        }
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + 6, yPos + i);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (letter == '4') {
                        for (byte i = 2; i <= 8; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 2; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + 1);
                        }
                        for (byte i = 0; i <= 4; i++) {
                            glVertex2d(xPos + 4, yPos + i);
                        }
                        xPos += 8;
                    } else if (letter == '5') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        for (byte i = 4; i <= 7; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        glVertex2d(xPos + 1, yPos + 1);
                        glVertex2d(xPos + 2, yPos);
                        glVertex2d(xPos + 3, yPos);
                        glVertex2d(xPos + 4, yPos);
                        glVertex2d(xPos + 5, yPos);
                        glVertex2d(xPos + 6, yPos);

                        glVertex2d(xPos + 7, yPos + 1);
                        glVertex2d(xPos + 7, yPos + 2);
                        glVertex2d(xPos + 7, yPos + 3);

                        glVertex2d(xPos + 6, yPos + 4);
                        glVertex2d(xPos + 5, yPos + 4);
                        glVertex2d(xPos + 4, yPos + 4);
                        glVertex2d(xPos + 3, yPos + 4);
                        glVertex2d(xPos + 2, yPos + 4);
                        xPos += 8;
                    } else if (letter == '6') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos);
                        }
                        for (byte i = 2; i <= 5; i++) {
                            glVertex2d(xPos + i, yPos + 4);
                            glVertex2d(xPos + i, yPos + 8);
                        }
                        glVertex2d(xPos + 7, yPos + 1);
                        glVertex2d(xPos + 7, yPos + 2);
                        glVertex2d(xPos + 7, yPos + 3);
                        glVertex2d(xPos + 6, yPos + 4);
                        xPos += 8;
                    } else if (letter == '7') {
                        for (byte i = 0; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2d(xPos + 7, yPos + 7);
                        glVertex2d(xPos + 7, yPos + 6);

                        glVertex2d(xPos + 6, yPos + 5);
                        glVertex2d(xPos + 5, yPos + 4);
                        glVertex2d(xPos + 4, yPos + 3);
                        glVertex2d(xPos + 3, yPos + 2);
                        glVertex2d(xPos + 2, yPos + 1);
                        glVertex2d(xPos + 1, yPos);
                        xPos += 8;
                    } else if (letter == '8') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                            glVertex2d(xPos + i, yPos + 0);
                        }
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (letter == '9') {
                        for (byte i = 1; i <= 7; i++) {
                            glVertex2d(xPos + 7, yPos + i);
                        }
                        for (byte i = 5; i <= 7; i++) {
                            glVertex2d(xPos + 1, yPos + i);
                        }
                        for (byte i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 8);
                            glVertex2d(xPos + i, yPos + 0);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2d(xPos + i, yPos + 4);
                        }
                        glVertex2f(xPos + 1, yPos + 0);
                        xPos += 8;
                    } else if (letter == '.') {
                        glVertex2d(xPos + 1, yPos);
                        xPos += 2;
                    } else if (letter == ',') {
                        glVertex2d(xPos + 1, yPos);
                        glVertex2d(xPos + 1, yPos + 1);
                        xPos += 2;
                    } else if (letter == '\n') {
                        yPos -= 10;
                        xPos = startX;
                    } else if (letter == ' ') {
                        xPos += 8;
                    }
                }
            }
            glEnd();
            glFlush();
        }
        glPopMatrix();
    }

    public static void fillPolygon(Vector2[] points, Vector2 translation, Colour colour) {

        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            colour.bind();

            glBegin(GL_POLYGON);
            {
                for (Vector2 point : points) {
                    glVertex2d(point.getX(), point.getY());
                }
            }
            glEnd();
            glFlush();

            colour.realse();
        }
        glPopMatrix();
    }

    public static void fillShape(int numSides, double lineLength, Vector2 translation, double rotation, Colour colour) {

        if (numSides >= 3) {

            numSides = abs(numSides);

            if (numSides >= 60) {
                numSides = 60;
            }

            int angle = 0;
            Vector2 temp = new Vector2();

            glPushMatrix();
            {
                glTranslated(translation.getX(), translation.getY(), 0);
                glRotated(rotation, 0, 0, 1);

                colour.bind();

                glBegin(GL_POLYGON);
                {
                    for (byte i = 0; i < numSides; i++) {

                        glPushMatrix();

                        glRotated(angle, 0, 0, 1);
                        glVertex2d(lineLength, 0);

                        temp.move(lineLength);
                        temp.rotate(angle);

                        angle += 360 / numSides;
                    }

                    for (byte i = 0; i < numSides; i++) {
                        glPopMatrix();
                    }
                }
                glEnd();

                colour.realse();
            }
            glPopMatrix();

        } else {
            throw new dwarf.DwarfException("lol you stupid idiot, shapes require 3 or more sides.");
        }
    }

    public static void line(Vector2 A, Vector2 B, Colour colour) {

        glPushMatrix();
        {
            colour.bind();

            glBegin(GL_LINES);
            {
                glVertex2d(A.getX(), A.getY());
                glVertex2d(B.getX(), B.getY());
            }
            glEnd();

            colour.realse();
        }
        glPopMatrix();
    }

    public static void strokeRect(int width, int hieght, Vector2 translation, Colour colour) {
        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            line(new Vector2(0, 0), new Vector2(0, hieght), colour);
            line(new Vector2(0, hieght), new Vector2(width, hieght), colour);
            line(new Vector2(width, hieght), new Vector2(width, 0), colour);
            line(new Vector2(width, 0), new Vector2(0, 0), colour);
        }
        glPopMatrix();
    }

    public static void strokePolygon(Vector2[] points, Vector2 translation, Colour colour) {
        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            colour.bind();

            line(new Vector2(points[0]), points[1], colour);

            for (byte i = 1; i < (points.length - 1); i++) {
                line(points[i], points[i + 1], colour);
            }

            line(points[points.length - 1], points[0], colour);

            colour.realse();
        }
        glPopMatrix();
    }

    public static void strokeShape(int numSides, double lineLength, Vector2 translation, Colour colour) {

        numSides = abs(numSides);

        if (numSides >= 3) {

            if (numSides >= 60) {
                numSides = 60;
            }

            int angle = 360 / numSides;

            Vector2 tempA = new Vector2();
            Vector2 tempB = new Vector2();

            glPushMatrix();
            {
                glTranslated(translation.getX(), translation.getY(), 0);
                glRotated(translation.getRotation(), 0, 0, 1);

                colour.bind();

                for (byte i = 0; i < numSides; i++) {
                    tempA.move(lineLength);
                    tempA.rotate(angle);

                    line(tempB, tempA, colour);

                    tempB.set(tempA);
                }

                colour.realse();
            }
            glPopMatrix();

        } else {
            throw new dwarf.DwarfException("lol you stupid idiot, shapes require 3 or more sides.");
        }
    }

    public static void strokePolyLine(Vector2[] points, Vector2 translation, Colour colour) {
        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            colour.bind();

            line(new Vector2(translation.getX(), translation.getY()), points[1], colour);

            try {
                for (byte i = 0; i < points.length; i++) {
                    line(points[i], points[i + 1], colour);
                }
            } catch (Exception ex) {
                //System.err.println(ex);
            }

            colour.realse();
        }
        glPopMatrix();
    }

    public static void fillCircle(double radius, Vector2 position, Colour colour) {
        draw.fillShape(SHAPE_CIRCLE, ((TWO_PI * radius) / 60), position, 0, colour);
    }

    public static void strokeCircle(double radius, Vector2 position, Colour colour) {
        draw.strokeShape(SHAPE_CIRCLE, ((TWO_PI * radius) / 60), position, colour);
    }

    public static void strokeArc(double radius, Vector2 translation, Colour colour) {

        Vector2 tempA = new Vector2();
        Vector2 tempB = new Vector2();

        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            colour.bind();
            tempA.rotate(90);

            for (byte i = 0; i < 30; i++) {
                tempA.move(((TWO_PI * radius) / 60));
                tempA.rotate(6);

                line(tempB, tempA, colour);

                tempB.set(tempA);
            }

            colour.realse();
        }
        glPopMatrix();
    }

    public static void fillArc(double radius, Vector2 translation, Colour colour) {

        Vector2 temp = new Vector2();

        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            colour.bind();
            temp.rotate(90);

            glBegin(GL_POLYGON);
            {
                for (byte i = 0; i < 30; i++) {
                    temp.move(((TWO_PI * radius) / 60));
                    temp.rotate(6);

                    glVertex2d(temp.getX(), temp.getY());
                }

            }
            glEnd();
            glFlush();

            colour.realse();
        }
        glPopMatrix();

    }

    public static void parabola(float a, float b, float c, float length, Colour colour) {

        Vector2 tuna = new Vector2();
        Vector2 bacon = new Vector2();

        for (float x = 0; x != length; x++) {
            tuna.setX(x);
            tuna.setY((a * pow(x, 2) + b * x + c));

            line(bacon, tuna, colour);

            bacon.set(tuna);
        }
    }

    public static void line(float m, float c, float length, Colour colour) {

        Vector2 tuna = new Vector2();
        Vector2 bacon = new Vector2();

        for (float x = 0; x != length; x++) {
            tuna.setX(x);
            tuna.setY((m * x + c));

            line(bacon, tuna, colour);

            bacon.set(tuna);
        }
    }

    public static void texture(Vector2 translation, Texture texture) {
        glPushMatrix();
        {
            glEnable(GL_TEXTURE_2D);

            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            Colour.white.bind();
            texture.bind();

            glBegin(GL_QUADS);
            {
                glTexCoord2f(1, 1);
                glVertex2d(0, 0);
                glTexCoord2f(0, 1);
                glVertex2d(texture.getTextureWidth(), 0);
                glTexCoord2f(0, 0);
                glVertex2d(texture.getTextureWidth(), texture.getTextureHeight());
                glTexCoord2f(1, 0);
                glVertex2d(0, texture.getTextureHeight());
            }
            glEnd();
            glFlush();

            glDisable(GL_TEXTURE_2D);
        }
        glPopMatrix();
    }
}
