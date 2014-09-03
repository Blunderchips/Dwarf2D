package textureTest;

import dwarf.DwarfException;
import dwarf.Game;
import static dwarf.gfx.Colours.white;
import dwarf.gfx.Image;
import dwarf.util.Point;


public class textureTest {

    public static void main(String[] args) {
        new Game("picture test - Dwarf 2D") {

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);
                try {
                    super.addGameObject(new Image("./textureTest/pixelDwarf.jpeg", new Point(280, 250)));
                } catch (DwarfException ex) {
                    ex.display();
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
