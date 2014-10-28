package dwarf.gfx;

import java.util.Arrays;

import dwarf.lwjgl.Texture;
import dwarf.util.Point2D;
import dwarf.util.Vector2;

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
import static org.lwjgl.opengl.GL11.glTexCoord2d;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.opengl.GL11.glVertex2f;

/**
 * Provides an interface to draw shapes and textures to the screen using <a
 * href='http://www.opengl.org/'>OpenGL</a>.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.lwjgl.Texture
 * @see dwarf.gfx.shapeConstants
 */
public final class draw implements dwarf.gfx.shapeConstants {

    /**
     * you can not instantiate this class.
     */
    public draw() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    public static void fillRect(float width, float hieght, Point2D translation, double rotation, Colour colour) {
        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(rotation, 0, 0, 1);

            colour.bind();

            glBegin(GL_QUADS);
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

    public static void basicText(String str, Point2D position, Colour colour) {
        basicText(str, (float) position.getX(), (float) position.getY(), colour);
    }

    public static void basicText(char[] str, Point2D position, Colour colour) {
        basicText(Arrays.toString(str), (float) position.getX(), (float) position.getY(), colour);
    }

    public static void basicText(char[] str, float xPos, float yPos, Colour colour) {
        basicText(Arrays.toString(str), xPos, yPos, colour);
    }

    public static void basicText(String str, float xPos, float yPos, Colour colour) {
        float startX = xPos;

        glPushMatrix();
        {
            colour.bind();

            glBegin(GL_POINTS);
            {
                for (char letter : str.toLowerCase().toCharArray()) {
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

    public static void fillPolygon(Point2D[] points, Point2D translation, double rotation, Colour colour) {

        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(rotation, 0, 0, 1);

            colour.bind();

            glBegin(GL_POLYGON);
            {
                for (Point2D point : points) {
                    glVertex2d(point.getX(), point.getY());
                }
            }
            glEnd();
            glFlush();

            colour.realse();
        }
        glPopMatrix();
    }

    public static void fillShape(int numSides, double lineLength, Point2D translation, double rotation, Colour colour) {

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
                glRotated(rotation, 0, 0, 1);

                colour.bind();

                glBegin(GL_POLYGON);
                {
                    for (byte i = 0; i < numSides; i++) {

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
            throw new dwarf.DwarfException("illegal argument");
        }
    }

    public static void line(Point2D A, Point2D B, Colour colour) {

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

    public static void strokeRect(int width, int hieght, Point2D translation, double rotation, Colour colour) {
        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(rotation, 0, 0, 1);

            line(new Point2D(0, 0), new Point2D(0, hieght), colour);
            line(new Point2D(0, hieght), new Point2D(width, hieght), colour);
            line(new Point2D(width, hieght), new Point2D(width, 0), colour);
            line(new Point2D(width, 0), new Point2D(0, 0), colour);
        }
        glPopMatrix();
    }

    public static void strokePolygon(Point2D[] points, Point2D translation, double rotation, Colour colour) {
        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(rotation, 0, 0, 1);

            colour.bind();

            line(new Point2D(points[0]), points[1], colour);

            for (byte i = 1; i < (points.length - 1); i++) {
                line(points[i], points[i + 1], colour);
            }

            line(points[points.length - 1], points[0], colour);

            colour.realse();
        }
        glPopMatrix();
    }

    public static void strokeShape(int numSides, double lineLength, Point2D translation, double rotation, Colour colour) {

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
                glRotated(rotation, 0, 0, 1);

                colour.bind();

                for (byte i = 0; i < numSides; i++) {
                    tempA.move(lineLength);
                    tempA.rotate(angle);

                    line(tempB.toPoint(), tempA.toPoint(), colour);

                    tempB.set(tempA);
                }

                colour.realse();
            }
            glPopMatrix();

        } else {
            throw new dwarf.DwarfException("illegal argument");
        }
    }

    public static void strokePolyLine(Point2D[] points, Point2D translation, double rotation, Colour colour) {
        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(rotation, 0, 0, 1);

            colour.bind();

            line(new Point2D(translation.getX(), translation.getY()), points[1], colour);

            try {
                for (byte i = 0; i < points.length; i++) {
                    line(points[i], points[i + 1], colour);
                }
            } catch (Exception ex) {
            }

            colour.realse();
        }
        glPopMatrix();
    }

    public static void fillCircle(double radius, Point2D position, double rotation, Colour colour) {
        draw.fillShape(SHAPE_CIRCLE, ((TWO_PI * radius) / 60), position, rotation, colour);
    }

    public static void strokeCircle(double radius, Point2D position, double rotation, Colour colour) {
        draw.strokeShape(SHAPE_CIRCLE, ((TWO_PI * radius) / 60), position, rotation, colour);
    }

    public static void strokeArc(double radius, Point2D translation, double rotation, Colour colour) {

        Vector2 tempA = new Vector2();
        Vector2 tempB = new Vector2();

        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(rotation, 0, 0, 1);

            colour.bind();
            tempA.rotate(90);

            for (byte i = 0; i < 30; i++) {
                tempA.move(((TWO_PI * radius) / 60));
                tempA.rotate(6);

                line(tempB.toPoint(), tempA.toPoint(), colour);

                tempB.set(tempA);
            }

            colour.realse();
        }
        glPopMatrix();
    }

    public static void fillArc(double radius, Point2D translation, double rotation, Colour colour) {

        Vector2 temp = new Vector2();

        glPushMatrix();
        {
            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(rotation, 0, 0, 1);

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

        Point2D tuna = new Point2D();
        Point2D bacon = new Point2D();

        for (float x = 0; x != length; x++) {
            tuna.setX(x);
            tuna.setY((a * pow(x, 2) + b * x + c));

            line(bacon, tuna, colour);

            bacon.set(tuna);
        }
    }

    public static void line(float m, float c, float length, Colour colour) {

        Point2D tuna = new Point2D();
        Point2D bacon = new Point2D();

        for (float x = 0; x != length; x++) {
            tuna.setX(x);
            tuna.setY((m * x + c));

            line(bacon, tuna, colour);

            bacon.set(tuna);
        }
    }

    public static void texture(Point2D translation, double rotation, Texture texture) {
        glPushMatrix();
        {

            glEnable(GL_TEXTURE_2D);

            glTranslated(translation.getX(), translation.getY(), 0);
            glRotated(rotation, 0, 0, 1);

            texture.bind();

            glBegin(GL_QUADS);
            {
                glTexCoord2d(0, texture.getHeight());
                glVertex2d(0, 0);

                glTexCoord2d(0, 0);
                glVertex2d(0, texture.getImageHeight());

                glTexCoord2d(texture.getWidth(), 0);
                glVertex2d(texture.getImageWidth(), texture.getImageHeight());

                glTexCoord2d(texture.getWidth(), texture.getHeight());
                glVertex2d(texture.getImageWidth(), 0);
            }
            glEnd();
            glFlush();

            glDisable(GL_TEXTURE_2D);
        }
        glPopMatrix();
    }
}
