package coulourTest;

import dwarf.Game;
import dwarf.engine.core.Window;
import dwarf.gfx.Colour;
import dwarf.gfx.Colours;
import dwarf.gfx.Rectangle;
import dwarf.util.Point2D;

import static dwarf.gfx.Polygon.FILL;

public class colourTest implements Colours {

    public static void main(String[] args) {
        new Game(1600, 900) {

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                Colour colours[] = {
                    aqua, aquamarine, bakersChoc, black, blue, blueViolet, brass, brightGold, bronze, bronze2, brown,
                    cadetBlue, coolCopper, copper, coral, cornflowerBlue, darkBrown, darkGreen, darkGreenCopper, darkGrey,
                    darkOliveGreen, darkOrchid, darkPurple, darkSlateBlue, darkSlateGray, darkSlateGrey, darkTan, darkTurquoise,
                    darkWood, dustyRose, feldspar, firebrick, flesh, forestGreen, gold, goldenrod, greenCopper, greenYellow,
                    grey, huntersGreen, indianRed, khaki, lightBlue, lightSteelBlue, lightSteelBlue, lightWood, lime, limeGreen,
                    mandarinOrange, maroon, mediumForestGreen, mediumGoldenrod, mediumOrchid, mediumOrchid, mediumSeaGreen,
                    mediumTurquoise, mediumVioletRed, mediumWood, navy, navyBlue, neonBlue, neonPink, newMidnightBlue, newTan,
                    oldGold, orange, orchid, paleGreen, pink, plum, quartz, red, richBlue, salmon, scarlet, seaGreen, semiSweetChoc,
                    sienna, silver, skyBlue, spicyPink, steelBlue, summerSky, tan, thistle, turquoise, veryDarkBrown, violet, violetRed,
                    wheat, white, yellow, yellowGreen
                };

                double xPos = 0;
                double yPos = 0;

                for (Colour colour : colours) {
                    super.addGameObject(new Rectangle(Window.getWidth() / colours.length, Window.getHeight(), new Point2D(xPos, yPos), FILL, colour));
                    xPos += Window.getWidth() / colours.length;
                }
            }

            @Override
            public void update() {
            }

            @Override
            public void render() {
                super.renderAllGameObjects();
            }
        };
    }
}
