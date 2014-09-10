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
        new Game(1600, 900, "colour test - Dwarf 2D") {

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                Colour colours[] = {
                    aqua, black, blue, brown, darkGrey, white,grey,
                    lime, orange, pink, red, scarlet, yellow, violet
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
