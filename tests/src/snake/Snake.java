package snake;

import dwarf.time;
import dwarf.gfx.draw;
import dwarf.GameObject;
import dwarf.gfx.Colour;
import java.util.ArrayList;

import static dwarf.random.chance;
import static dwarf.gfx.Colours.white;

public class Snake extends dwarf.Game {

    public static Snake game;

    public static int score;
    public static Player player;
    public static Zombie zombie;

    public Snake() {
        super("Snake Demo - Dward 2D");
    }

    @Override
    public void load() {
        dwarf.gfx.background.setColour(white);

        player = new Player();
        zombie = new Zombie();
        score = 0;

        super.addGameObject(zombie);
        super.addGameObject(player);
    }

    @Override
    public void update() {
        if (chance(7)) {
            super.addGameObject(new coin());
        }
        this.updateAllGameObjects();

        System.out.println("Delta Time: " + time.getDeltaTime());
    }

    @Override
    public void render() {
        draw.basicText("Score " + score, 20, 580, Colour.black);
        super.renderAllGameObjects();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Snake.game = new Snake();
    }

    public ArrayList<GameObject> getGameObejects() {
        return super.getGameObjects();
    }
}
