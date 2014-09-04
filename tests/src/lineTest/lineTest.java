package lineTest;

import dwarf.Game;
import dwarf.gfx.Line;
import dwarf.gfx.Square;
import dwarf.util.Point2D;

import static dwarf.gfx.Colours.black;
import static dwarf.gfx.Colours.red;
import static dwarf.gfx.Colours.white;

public class lineTest {

    public static void main(String[] args) {
        new Game() {

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                super.addGameObject(new Line(new Point2D(400, 0), new Point2D(400, 600), black));
                super.addGameObject(new Square(50, new Point2D(375, 300), 0, red));
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
