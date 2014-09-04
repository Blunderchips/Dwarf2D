package snake;

import dwarf.engine.core.Window;
import dwarf.gfx.Shape;
import dwarf.random;
import dwarf.util.Point2D;
import dwarf.util.Vector2;

import static snake.Snake.player;
import static snake.Snake.score;

public class coin extends Shape {

    private int speed;
    private Vector2 velocity;
    private boolean alive;

    public coin() {
        super(4, 30, new Point2D(
                random.interger(Window.getWidth()),
                random.interger(Window.getHeight())
        ), FILL, LIME);
        this.init();
    }

    private void init() {
        this.velocity = new Vector2(speed, 0);
        this.alive = true;
    }

    @Override
    public void update() {
        if (alive) {
            if (this.intersects(player)) {
                score++;
                Snake.zombie.setSpeed(Snake.zombie.getSpeed() + 0.1);
                destory();
            }
        }
    }

    public void destory() {
        this.alive = false;
        this.setPosition(Point2D.NaN);
    }

    @Override
    public void render() {
        if (alive) {
            super.render();
        }
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Vector2 getVelocity() {
        return this.velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
