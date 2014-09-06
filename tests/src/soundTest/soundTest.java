package soundTest;

import dwarf.Sfx;
import dwarf.Game;
import dwarf.util.Point2D;
import dwarf.DwarfException;

import static dwarf.gfx.Colours.black;
import static dwarf.gfx.Colours.white;
import static dwarf.keyboard.isKeyDown;

public class soundTest {

    public static void main(String[] args) {
        new Game("audio test - Dwarf 2D") {

            private Sfx song;

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                try {
                    this.song = new Sfx("./src/soundTest/sound.wav");
                } catch (DwarfException ex) {
                    ex.display();
                }
            }

            @Override
            public void update() {
                if (isKeyDown("space")) {
                    this.song.play();
                }
            }

            @Override
            public void render() {
                dwarf.gfx.draw.basicText("Press the spacebar to the play sound.", new Point2D(250, 400), black);
            }
        };
    }
}