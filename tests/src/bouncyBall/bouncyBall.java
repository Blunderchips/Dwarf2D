package bouncyBall;

import dwarf.Game;
import dwarf.gfx.Circle;
import dwarf.gfx.Polygon;
import dwarf.gfx.Rectangle;
import dwarf.time;
import dwarf.util.Point;

import static dwarf.gfx.Colours.black;
import static dwarf.gfx.Colours.blue;
import static dwarf.gfx.Colours.white;
import static dwarf.gfx.Polygon.FILL;

public class bouncyBall {

    public static void main(String[] args) {
        new Game("Bouncy Ball - Dwarf 2D") {

            private double velocity;

            private Polygon ball;
            private Polygon base;

            @Override
            public void load() {
                dwarf.gfx.background.setColour(white);

                this.ball = new Circle(50, new Point(400, 300), FILL, blue);
                this.base = new Rectangle(800, 50, Point.ZERO, FILL, black);

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
