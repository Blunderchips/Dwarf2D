package coulourTest;

import dwarf.Game;
import dwarf.gfx.Colour;
import dwarf.gfx.Rectangle;
import dwarf.util.Vector2;

import static dwarf.gfx.Colours.white;
import static dwarf.gfx.Polygon.FILL;

public class colourTest {

    public static void main(String[] args) {
        new Game("colour test - Dwarf 2D") {

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                Colour colours[] = {
                    Colour.AQUA, Colour.BLACK, Colour.BLUE, Colour.DARK_GREY, Colour.GREY, Colour.LIGHT_GREY,
                    Colour.LIME, Colour.MAGENTA, Colour.ORANGE, Colour.PINK, Colour.RED, Colour.WHITE, Colour.YELLOW
                };

                double xPos = 0;
                double yPos = 0;

                for (Colour colour : colours) {
                    super.addGameObject(new Rectangle(800 / colours.length, 600, new Vector2(xPos, yPos), FILL, colour));
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
