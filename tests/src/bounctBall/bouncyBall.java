package bounctBall;

import dwarf.Game;
import dwarf.gfx.Circle;
import dwarf.gfx.Polygon;
import dwarf.gfx.Rectangle;
import dwarf.time;
import dwarf.util.Vector2;

import static dwarf.gfx.Colour.black;
import static dwarf.gfx.Colour.blue;
import static dwarf.gfx.Colour.white;

public class bouncyBall {

    public static void main(String[] args) {
        new Game("Bouncy Ball - Dwarf 2D") {

            double velocity;

            Polygon ball;
            Polygon base;

            @Override
            public void load() {
                dwarf.gfx.util.setBackgroundColour(white);

                this.ball = new Circle(50, new Vector2(400, 300), "fill", blue);
                this.base = new Rectangle(800, 50, Vector2.ZERO, "fill", black);

                super.addGameObject(ball);
                super.addGameObject(base);
            }

            @Override
            public void update() {
                if (ball.intersects(base)) {
                    velocity = 10;
                } else {
                    velocity -= time.getDeltaTime();
                }

                ball.translateY(velocity);
            }

            @Override
            public void render() {
                super.renderAllGameObjects();
            }
        };
    }
}
