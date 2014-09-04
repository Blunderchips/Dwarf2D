package shapeTest;

import dwarf.Game;
import dwarf.gfx.Shape;
import dwarf.util.Point2D;

import static dwarf.gfx.Colours.black;
import static dwarf.gfx.Colours.white;
import static dwarf.gfx.Polygon.STROKE;

public class shapeTest {

    public static void main(String[] args) {
        new Game("shape test - Dwarf 2D") {

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                for (int i = 3; i < 25; i++) {
                    super.addGameObject(new Shape(i, 65, new Point2D(375, 20), STROKE, black));
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
