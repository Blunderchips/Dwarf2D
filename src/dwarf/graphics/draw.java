package dwarf.graphics;

import dwarf.lib.Slick2D.Texture;
import dwarf.util.Vector2;
import static dwarf.util.math.TWO_PI;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
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
 * draws shapes to the screen using openGL
 *
 * @author sid_th3_sl0th
 */
public final class draw {

    public draw() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    /**
     * 3 sided shape
     */
    public final static int SHAPE_TRIANGLE = 0x3;
    /**
     * 4 sided shape
     */
    public final static int SHAPE_SQUARE = 0x4;
    /**
     * 5 sided shape
     */
    public final static int SHAPE_PENTAGON = 0x5;
    /**
     * 6 sided shape
     */
    public final static int SHAPE_HEXAGON = 0x6;
    /**
     * 7 sided shape
     */
    public final static int SHAPE_HEPTAGON = 0x7;
    /**
     * 8 sided shape
     */
    public final static int SHAPE_OCTAGON = 0x8;
    /**
     * 9 sided shape
     */
    public final static int SHAPE_NONAGON = 0x9;
    /**
     * 10 sided shape
     */
    public final static int SHAPE_DECAGON = 0xa;
    /**
     * 11 sided shape
     */
    public final static int SHAPE_HENDECAGON = 0xb;
    /**
     * 12 sided shape
     */
    public final static int SHAPE_DODECAGON = 0xc;
    /**
     * 13 sided shape
     */
    public final static int SHAPE_TRISKAIDECAGON = 0xd;
    /**
     * 14 sided shape
     */
    public final static int SHAPE_TETRAKAIDECAGON = 0xe;
    /**
     * 15 sided shape
     */
    public final static int SHAPE_PENTAKAIDECAGON = 0xf;
    /**
     * 16 sided shape
     */
    public final static int SHAPE_HEXAKAIDECAGON = 0x10;
    /**
     * 17 sided shape
     */
    public final static int SHAPE_HEPTAKAIDECAGON = 0x11;
    /**
     * 18 sided shape
     */
    public final static int SHAPE_OCTAKAIDECAGON = 0x12;
    /**
     * 19 sided shape
     */
    public final static int SHAPE_ENNEAKAIDECAGON = 0x13;
    /**
     * 20 sided shape
     */
    public final static int SHAPE_ICOSAGON = 0x14;
    /**
     * 21 sided shape
     */
    public final static int SHAPE_ICOSIKAIHENAGON = 0x15;
    /**
     * 22 sided shape
     */
    public final static int SHAPE_ICOSIKAILHENAGON = 0x16;
    /**
     * 23 sided shape
     */
    public final static int SHAPE_ICOSIKAITRIGON = 0x17;
    /**
     * 24 sided shape
     */
    public final static int SHAPE_ICOSIKAITETRAGON = 0x18;

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
        basicText(string, (int) position.getX(), (int) position.getY(), colour);
    }

    public static void basicText(String string, int xPos, int yPos, Colour colour) {
        int startX = xPos;

        glPushMatrix();
        {
            colour.bind();

            glBegin(GL_POINTS);
            {
                for (char c : string.toLowerCase().toCharArray()) {
                    if (c == 'a') {
                        for (int i = 0; i < 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (c == 'b') {
                        for (int i = 0; i < 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 1; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos);
                            glVertex2f(xPos + i, yPos + 4);
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2f(xPos + 7, yPos + 5);
                        glVertex2f(xPos + 7, yPos + 7);
                        glVertex2f(xPos + 7, yPos + 6);

                        glVertex2f(xPos + 7, yPos + 1);
                        glVertex2f(xPos + 7, yPos + 2);
                        glVertex2f(xPos + 7, yPos + 3);
                        xPos += 8;
                    } else if (c == 'c') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos);
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2f(xPos + 6, yPos + 1);
                        glVertex2f(xPos + 6, yPos + 2);

                        glVertex2f(xPos + 6, yPos + 6);
                        glVertex2f(xPos + 6, yPos + 7);

                        xPos += 8;
                    } else if (c == 'd') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos);
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2f(xPos + 6, yPos + 1);
                        glVertex2f(xPos + 6, yPos + 2);
                        glVertex2f(xPos + 6, yPos + 3);
                        glVertex2f(xPos + 6, yPos + 4);
                        glVertex2f(xPos + 6, yPos + 5);
                        glVertex2f(xPos + 6, yPos + 6);
                        glVertex2f(xPos + 6, yPos + 7);

                        xPos += 8;
                    } else if (c == 'e') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 1; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 0);
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (c == 'f') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 1; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (c == 'g') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos);
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2f(xPos + 6, yPos + 1);
                        glVertex2f(xPos + 6, yPos + 2);
                        glVertex2f(xPos + 6, yPos + 3);
                        glVertex2f(xPos + 5, yPos + 3);
                        glVertex2f(xPos + 7, yPos + 3);

                        glVertex2f(xPos + 6, yPos + 6);
                        glVertex2f(xPos + 6, yPos + 7);

                        xPos += 8;
                    } else if (c == 'h') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (c == 'i') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 3, yPos + i);
                        }
                        for (int i = 1; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 0);
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        xPos += 7;
                    } else if (c == 'j') {
                        for (int i = 1; i <= 8; i++) {
                            glVertex2f(xPos + 6, yPos + i);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 0);
                        }
                        glVertex2f(xPos + 1, yPos + 3);
                        glVertex2f(xPos + 1, yPos + 2);
                        glVertex2f(xPos + 1, yPos + 1);
                        xPos += 8;
                    } else if (c == 'k') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        glVertex2f(xPos + 6, yPos + 8);
                        glVertex2f(xPos + 5, yPos + 7);
                        glVertex2f(xPos + 4, yPos + 6);
                        glVertex2f(xPos + 3, yPos + 5);
                        glVertex2f(xPos + 2, yPos + 4);
                        glVertex2f(xPos + 2, yPos + 3);
                        glVertex2f(xPos + 3, yPos + 4);
                        glVertex2f(xPos + 4, yPos + 3);
                        glVertex2f(xPos + 5, yPos + 2);
                        glVertex2f(xPos + 6, yPos + 1);
                        glVertex2f(xPos + 7, yPos);
                        xPos += 8;
                    } else if (c == 'l') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 1; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos);
                        }
                        xPos += 7;
                    } else if (c == 'm') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        glVertex2f(xPos + 3, yPos + 6);
                        glVertex2f(xPos + 2, yPos + 7);
                        glVertex2f(xPos + 4, yPos + 5);

                        glVertex2f(xPos + 5, yPos + 6);
                        glVertex2f(xPos + 6, yPos + 7);
                        glVertex2f(xPos + 4, yPos + 5);
                        xPos += 8;
                    } else if (c == 'n') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        glVertex2f(xPos + 2, yPos + 7);
                        glVertex2f(xPos + 2, yPos + 6);
                        glVertex2f(xPos + 3, yPos + 5);
                        glVertex2f(xPos + 4, yPos + 4);
                        glVertex2f(xPos + 5, yPos + 3);
                        glVertex2f(xPos + 6, yPos + 2);
                        glVertex2f(xPos + 6, yPos + 1);
                        xPos += 8;
                    } else if (c == 'o' || c == '0') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                            glVertex2f(xPos + i, yPos + 0);
                        }
                        xPos += 8;
                    } else if (c == 'p') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        glVertex2f(xPos + 6, yPos + 7);
                        glVertex2f(xPos + 6, yPos + 5);
                        glVertex2f(xPos + 6, yPos + 6);
                        xPos += 8;
                    } else if (c == 'q') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            if (i != 1) {
                                glVertex2f(xPos + 7, yPos + i);
                            }
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                            if (i != 6) {
                                glVertex2f(xPos + i, yPos + 0);
                            }
                        }
                        glVertex2f(xPos + 4, yPos + 3);
                        glVertex2f(xPos + 5, yPos + 2);
                        glVertex2f(xPos + 6, yPos + 1);
                        glVertex2f(xPos + 7, yPos);
                        xPos += 8;
                    } else if (c == 'r') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        glVertex2f(xPos + 6, yPos + 7);
                        glVertex2f(xPos + 6, yPos + 5);
                        glVertex2f(xPos + 6, yPos + 6);

                        glVertex2f(xPos + 4, yPos + 3);
                        glVertex2f(xPos + 5, yPos + 2);
                        glVertex2f(xPos + 6, yPos + 1);
                        glVertex2f(xPos + 7, yPos);
                        xPos += 8;
                    } else if (c == 's') {
                        for (int i = 2; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2f(xPos + 1, yPos + 7);
                        glVertex2f(xPos + 1, yPos + 6);
                        glVertex2f(xPos + 1, yPos + 5);
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 4);
                            glVertex2f(xPos + i, yPos);
                        }
                        glVertex2f(xPos + 7, yPos + 3);
                        glVertex2f(xPos + 7, yPos + 2);
                        glVertex2f(xPos + 7, yPos + 1);
                        glVertex2f(xPos + 1, yPos + 1);
                        glVertex2f(xPos + 1, yPos + 2);
                        xPos += 8;
                    } else if (c == 't') {
                        for (int i = 0; i <= 8; i++) {
                            glVertex2f(xPos + 4, yPos + i);
                        }
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        xPos += 7;
                    } else if (c == 'u') {
                        for (int i = 1; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 0);
                        }
                        xPos += 8;
                    } else if (c == 'v') {
                        for (int i = 2; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 6, yPos + i);
                        }
                        glVertex2f(xPos + 2, yPos + 1);
                        glVertex2f(xPos + 5, yPos + 1);
                        glVertex2f(xPos + 3, yPos);
                        glVertex2f(xPos + 4, yPos);
                        xPos += 7;
                    } else if (c == 'w') {
                        for (int i = 1; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        glVertex2f(xPos + 2, yPos);
                        glVertex2f(xPos + 3, yPos);
                        glVertex2f(xPos + 5, yPos);
                        glVertex2f(xPos + 6, yPos);
                        for (int i = 1; i <= 6; i++) {
                            glVertex2f(xPos + 4, yPos + i);
                        }
                        xPos += 8;
                    } else if (c == 'x') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + i);
                        }
                        for (int i = 7; i >= 1; i--) {
                            glVertex2f(xPos + i, yPos + 8 - i);
                        }
                        xPos += 8;
                    } else if (c == 'y') {
                        glVertex2f(xPos + 4, yPos);
                        glVertex2f(xPos + 4, yPos + 1);
                        glVertex2f(xPos + 4, yPos + 2);
                        glVertex2f(xPos + 4, yPos + 3);
                        glVertex2f(xPos + 4, yPos + 4);

                        glVertex2f(xPos + 3, yPos + 5);
                        glVertex2f(xPos + 2, yPos + 6);
                        glVertex2f(xPos + 1, yPos + 7);
                        glVertex2f(xPos + 1, yPos + 8);

                        glVertex2f(xPos + 5, yPos + 5);
                        glVertex2f(xPos + 6, yPos + 6);
                        glVertex2f(xPos + 7, yPos + 7);
                        glVertex2f(xPos + 7, yPos + 8);
                        xPos += 8;
                    } else if (c == 'z') {
                        for (int i = 1; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos);
                            glVertex2f(xPos + i, yPos + 8);
                            glVertex2f(xPos + i, yPos + i);
                        }
                        glVertex2f(xPos + 6, yPos + 7);
                        xPos += 8;
                    } else if (c == '1') {
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos);
                        }
                        for (int i = 1; i <= 8; i++) {
                            glVertex2f(xPos + 4, yPos + i);
                        }
                        glVertex2f(xPos + 3, yPos + 7);
                        xPos += 8;
                    } else if (c == '2') {
                        for (int i = 1; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2f(xPos + 1, yPos + 7);
                        glVertex2f(xPos + 1, yPos + 6);

                        glVertex2f(xPos + 6, yPos + 7);
                        glVertex2f(xPos + 6, yPos + 6);
                        glVertex2f(xPos + 6, yPos + 5);
                        glVertex2f(xPos + 5, yPos + 4);
                        glVertex2f(xPos + 4, yPos + 3);
                        glVertex2f(xPos + 3, yPos + 2);
                        glVertex2f(xPos + 2, yPos + 1);
                        xPos += 8;
                    } else if (c == '3') {
                        for (int i = 1; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                            glVertex2f(xPos + i, yPos);
                        }
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + 6, yPos + i);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (c == '4') {
                        for (int i = 2; i <= 8; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 2; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + 1);
                        }
                        for (int i = 0; i <= 4; i++) {
                            glVertex2f(xPos + 4, yPos + i);
                        }
                        xPos += 8;
                    } else if (c == '5') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        for (int i = 4; i <= 7; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        glVertex2f(xPos + 1, yPos + 1);
                        glVertex2f(xPos + 2, yPos);
                        glVertex2f(xPos + 3, yPos);
                        glVertex2f(xPos + 4, yPos);
                        glVertex2f(xPos + 5, yPos);
                        glVertex2f(xPos + 6, yPos);

                        glVertex2f(xPos + 7, yPos + 1);
                        glVertex2f(xPos + 7, yPos + 2);
                        glVertex2f(xPos + 7, yPos + 3);

                        glVertex2f(xPos + 6, yPos + 4);
                        glVertex2f(xPos + 5, yPos + 4);
                        glVertex2f(xPos + 4, yPos + 4);
                        glVertex2f(xPos + 3, yPos + 4);
                        glVertex2f(xPos + 2, yPos + 4);
                        xPos += 8;
                    } else if (c == '6') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos);
                        }
                        for (int i = 2; i <= 5; i++) {
                            glVertex2f(xPos + i, yPos + 4);
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2f(xPos + 7, yPos + 1);
                        glVertex2f(xPos + 7, yPos + 2);
                        glVertex2f(xPos + 7, yPos + 3);
                        glVertex2f(xPos + 6, yPos + 4);
                        xPos += 8;
                    } else if (c == '7') {
                        for (int i = 0; i <= 7; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                        }
                        glVertex2f(xPos + 7, yPos + 7);
                        glVertex2f(xPos + 7, yPos + 6);

                        glVertex2f(xPos + 6, yPos + 5);
                        glVertex2f(xPos + 5, yPos + 4);
                        glVertex2f(xPos + 4, yPos + 3);
                        glVertex2f(xPos + 3, yPos + 2);
                        glVertex2f(xPos + 2, yPos + 1);
                        glVertex2f(xPos + 1, yPos);
                        xPos += 8;
                    } else if (c == '8') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                            glVertex2f(xPos + i, yPos + 0);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        xPos += 8;
                    } else if (c == '9') {
                        for (int i = 1; i <= 7; i++) {
                            glVertex2f(xPos + 7, yPos + i);
                        }
                        for (int i = 5; i <= 7; i++) {
                            glVertex2f(xPos + 1, yPos + i);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 8);
                            glVertex2f(xPos + i, yPos + 0);
                        }
                        for (int i = 2; i <= 6; i++) {
                            glVertex2f(xPos + i, yPos + 4);
                        }
                        glVertex2f(xPos + 1, yPos + 0);
                        xPos += 8;
                    } else if (c == '.') {
                        glVertex2f(xPos + 1, yPos);
                        xPos += 2;
                    } else if (c == ',') {
                        glVertex2f(xPos + 1, yPos);
                        glVertex2f(xPos + 1, yPos + 1);
                        xPos += 2;
                    } else if (c == '\n') {
                        yPos -= 10;
                        xPos = startX;
                    } else if (c == ' ') {
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

    public static void fillShape(int numSides, double lineLength, Vector2 translation, Colour colour) {

        if (numSides >= 3) {

            numSides = abs(numSides);

            if (numSides >= 60) {
                numSides = 60;
            }

            int angle = 360 / numSides;
            Vector2 temp = new Vector2();

            glPushMatrix();
            {
                glTranslated(translation.getX(), translation.getY(), 0);
                glRotated(translation.getRotation(), 0, 0, 1);

                colour.bind();

                glBegin(GL_POLYGON);
                {
                    for (int i = 0; i < numSides; i++) {

                        glVertex2d(temp.getX(), temp.getY());

                        temp.move(lineLength);
                        temp.rotate(angle);
                    }

                }
                glEnd();

                colour.realse();
            }
            glPopMatrix();

        } else {
            throw new IllegalArgumentException("lol you stupid idiot, shapes require 3 or more sides.");
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

            for (int i = 1; i < (points.length - 1); i++) {
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

            Vector2 bacon = new Vector2();
            Vector2 tuna = new Vector2();

            glPushMatrix();
            {
                glTranslated(translation.getX(), translation.getY(), 0);
                glRotated(translation.getRotation(), 0, 0, 1);

                colour.bind();

                for (int i = 0; i < numSides; i++) {
                    bacon.move(lineLength);
                    bacon.rotate(angle);

                    line(tuna, bacon, colour);

                    tuna.set(bacon);
                }

                colour.realse();
            }
            glPopMatrix();

        } else {
            throw new IllegalArgumentException("lol you stupid idiot, shapes require 3 or more sides.");
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
                for (int i = 0; i < points.length; i++) {
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
        draw.fillShape(60, ((TWO_PI * radius) / 60), position, colour);
    }

    public static void strokeCircle(double radius, Vector2 position, Colour colour) {
        draw.strokeShape(60, ((TWO_PI * radius) / 60), position, colour);
    }

    public static void strokeArc(double radius, Vector2 translation, Colour colour) {

        Vector2 bacon = new Vector2();
        Vector2 tuna = new Vector2();

        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(translation.getRotation(), 0, 0, 1);

            colour.bind();
            bacon.rotate(90);

            for (int i = 0; i < 30; i++) {
                bacon.move(((TWO_PI * radius) / 60));
                bacon.rotate(6);

                line(tuna, bacon, colour);

                tuna.set(bacon);
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
                for (int i = 0; i < 30; i++) {
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
