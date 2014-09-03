package coulourTest;

import dwarf.Game;
import dwarf.gfx.Colour;
import dwarf.gfx.Colours;
import dwarf.gfx.Rectangle;
import dwarf.util.Point;

import static dwarf.gfx.Polygon.FILL;
import static dwarf.gfx.Colours.white;

public class colourTest implements Colours {

    public static void main(String[] args) {
        new Game("colour test - Dwarf 2D") {

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                Colour colours[] = {
                    AQUA, BLACK, BLUE, DARK_GREY, GREY, LIGHT_GREY,
                    LIME, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW
                };

                double xPos = 0;
                double yPos = 0;

                for (Colour colour : colours) {
                    super.addGameObject(new Rectangle(800 / colours.length, 600, new Point(xPos, yPos), FILL, colour));
                    xPos += 800 / colours.length;
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
