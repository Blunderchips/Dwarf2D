package snake;

import dwarf.engine.core.Window;
import dwarf.gfx.Shape;
import dwarf.random;
import dwarf.time;
import dwarf.util.Point;
import dwarf.util.Vector2;

import static snake.Snake.player;

public class Zombie extends Shape {

    private boolean alive;
    private double speed;

    public Zombie() {
        super(4, 30, new Point(
                random.interger(Window.getWidth()),
                random.interger(Window.getHeight())
        ), FILL, DARK_GREY);
        this.init();
    }

    private void init() {
        this.speed = 5;
        this.alive = true;
    }

    @Override
    public void update() {
        if (alive) {
            if (this.intersects(player)) {
                player.die();
            } else {
                if (getPosition().getX() > player.getPosition().getX()) {
                    this.getPosition().translateX(-(speed * time.getDeltaTime()));
                }
                if (getPosition().getX() < player.getPosition().getX()) {
                    this.getPosition().translateX((speed * time.getDeltaTime()));
                }
                if (getPosition().getY() < player.getPosition().getY()) {
                    this.getPosition().translateY((speed * time.getDeltaTime()));
                }
                if (getPosition().getY() > player.getPosition().getY()) {
                    this.getPosition().translateY(-(speed * time.getDeltaTime()));
                }
            }
        }
    }

    public void die() {
        this.alive = false;
        this.setPosition(Point.NaN);
    }

    @Override
    public void render() {
        if (alive) {
            super.render();
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (isAlive() ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        final Zombie other = (Zombie) obj;

        if (other.getVertices() != this.getVertices()) {
            return false;
        } else if (other.getCenter() != this.getCenter()) {
            return false;
        } else if (other.isAlive() != this.isAlive()) {
            return false;
        } else if (other.getPosition() != this.getPosition()) {
            return false;
        }

        return true;

    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
