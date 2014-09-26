package lineTest;

import dwarf.Game;
import dwarf.gfx.Line;
import dwarf.util.Point2D;
import dwarf.gfx.Rectangle;

import static dwarf.gfx.Colours.red;
import static dwarf.gfx.Colours.black;
import static dwarf.gfx.Colours.white;

public class lineTest {

    public static void main(String[] args) {
        new Game("line test - Dwarf 2D") {

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                super.addGameObject(new Rectangle(50, 50, new Point2D(375, 300), 0, red));
                super.addGameObject(new Line(new Point2D(0, 300), new Point2D(800, 300), black));
                super.addGameObject(new Line(new Point2D(400, 0), new Point2D(400, 600), black));
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
