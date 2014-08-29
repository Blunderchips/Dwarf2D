package snake;

import java.util.ArrayList;

import dwarf.Game;
import dwarf.GameObject;
import dwarf.gfx.Colour;
import dwarf.gfx.draw;

import static dwarf.random.chance;

/**
 * @author sid_th3_sl0th
 */
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
        this.getGameObejects().clear();
        dwarf.gfx.util.setBackgroundColour(Colour.white);

        player = new Player();
        zombie = new Zombie();
        score = 0;

        this.addGameObject(zombie);
        this.addGameObject(player);
    }

    @Override
    public void update() {
        if (chance(7)) {
            this.addGameObject(new coin());
        }
        this.updateAllGameObjects();
    }

    @Override
    public void render() {
        draw.basicText("Score " + score, 20, 580, Colour.black);
        this.renderAllGameObjects();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Snake.game = new Snake();
    }

    public ArrayList<GameObject> getGameObejects() {
        return this.getGameObjects();
    }
}
