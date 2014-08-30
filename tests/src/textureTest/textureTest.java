package textureTest;

import dwarf.Game;
import dwarf.gfx.Image;
import dwarf.util.Vector2;
import dwarf.DwarfException;

import static dwarf.gfx.Colours.white;

public class textureTest {

    public static void main(String[] args) {
        new Game("picture test - Dwarf 2D") {

            Image tex;

            @Override
            public void load() {
                dwarf.gfx.util.setBackgroundColour(white);
                try {
                    this.tex = new Image("./textureTest/pixelDwarf.jpeg", new Vector2(280, 250));
                } catch (DwarfException ex) {
                    System.err.println(ex);
                }

                super.addGameObject(tex);
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
