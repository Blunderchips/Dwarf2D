package snake;

import javax.swing.JOptionPane;

import dwarf.GameObject;
import dwarf.engine.core.Window;
import dwarf.gfx.Shape;
import dwarf.random;
import dwarf.util.Point2D;
import dwarf.util.Vector2;

import static snake.Snake.game;
import static dwarf.random.interger;

public class Player extends Shape {

    private int speed;
    private Vector2 velocity;

    public Player() {
        super(4, 10, new Point2D(
                interger(Window.getWidth()),
                interger(Window.getHeight())
        ), FILL, RED);
        this.init();
    }

    private void init() {
        this.speed = 5;
        this.velocity = new Vector2(speed, 0);
    }

    public void boundryCheck() {
        if (this.getPosition().getX() > Window.getWidth()) {
            this.getPosition().setX(0);
            this.velocity = new Vector2(speed, 0);
        } else if (this.getPosition().getX() < 0) {
            this.getPosition().setX(Window.getWidth());
            this.velocity = new Vector2(-speed, 0);
        } else if (this.getPosition().getY() > Window.getHeight()) {
            this.getPosition().setY(0);
            this.velocity = new Vector2(0, speed);
        } else if (this.getPosition().getY() < 0) {
            this.getPosition().setY(Window.getHeight());
            this.velocity = new Vector2(0, -speed);
        }
    }

    @Override
    public void update() {
        if (dwarf.keyboard.isKeyPressed("w")) {
            this.velocity = new Vector2(0, speed);
        }
        if (dwarf.keyboard.isKeyPressed("s")) {
            this.velocity = new Vector2(0, -speed);
        }
        if (dwarf.keyboard.isKeyPressed("d")) {
            this.velocity = new Vector2(speed, 0);
        }
        if (dwarf.keyboard.isKeyPressed("a")) {
            this.velocity = new Vector2(-speed, 0);
        }

        this.boundryCheck();
        this.translate(velocity.toPoint());
    }

    public void die() {
        JOptionPane.showMessageDialog(null, "Score: " + Snake.score, "You are Dead.", 0);

        Snake.player.setPosition(new Point2D(
                random.interger(Window.getWidth()),
                random.interger(Window.getHeight())
        ));
        Snake.zombie.setPosition(new Point2D(
                random.interger(Window.getWidth()),
                random.interger(Window.getHeight())
        ));
        Snake.score = 0;
        Snake.zombie.setSpeed(1);

        try {
            for (GameObject obj : game.getGameObejects()) {
                if (obj instanceof coin) {
                    coin zombie = (coin) obj;
                    zombie.destory();
                }
            }
        } catch (NullPointerException ex) {
        }
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
