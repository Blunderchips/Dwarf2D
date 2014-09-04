package snake;

import dwarf.GameObject;
import dwarf.gfx.Colour;
import static dwarf.gfx.Colours.white;
import dwarf.gfx.draw;
import static dwarf.random.chance;
import dwarf.time;
import java.util.ArrayList;

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
        }System.out.println(time.getDeltaTime());
        this.updateAllGameObjects();
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
