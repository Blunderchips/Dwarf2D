package pong;

import dwarf.time;
import dwarf.Game;
import dwarf.random;
import dwarf.gfx.Line;
import dwarf.util.Point2D;
import dwarf.gfx.Rectangle;
import dwarf.engine.core.Window;

import static dwarf.keyboard.isKeyDown;
import static dwarf.gfx.Polygon.FILL;
import static dwarf.gfx.Colours.WHITE;

public class pong {

    public static void main(String[] args) {
        new Game(1600, 900, "Pong - Dwarf 2D") {

            private int xvel;
            private int yvel;

            private int scoreA;
            private int scoreB;

            private Rectangle ball;
            private Rectangle[] players;

            @Override
            public void load() {
                this.players = new Rectangle[2];

                this.players[0] = new Rectangle(50, 200, new Point2D(50, (Window.getHeight() / 2) - 50), FILL, WHITE);
                this.players[1] = new Rectangle(50, 200, new Point2D(Window.getWidth() - 100, (Window.getHeight() / 2) - 50), FILL, WHITE);

                this.xvel = 7;
                this.yvel = 0;
                this.scoreA = 0;
                this.scoreB = 0;

                this.ball = new Rectangle(25, new Point2D((Window.getWidth() / 2), (Window.getHeight() / 2)), FILL, WHITE);

                super.addGameObject(ball);
                super.addGameObject(players[0]);
                super.addGameObject(players[1]);

                super.addGameObject(new Line(new Point2D((Window.getWidth() / 2), 0), new Point2D((Window.getWidth() / 2), Window.getHeight()), WHITE));

                if (random.bool()) {
                    this.xvel = -xvel;
                }
            }

            @Override
            public void update() {

                int speed = 50;

                if (isKeyDown("w")) {
                    this.players[0].translateY(speed * time.getDeltaTime());
                }
                if (isKeyDown("s")) {
                    this.players[0].translateY(-(speed * time.getDeltaTime()));
                }

                if (isKeyDown("up")) {
                    this.players[1].translateY(speed * time.getDeltaTime());
                }
                if (isKeyDown("down")) {
                    this.players[1].translateY(-(speed * time.getDeltaTime()));
                }

                for (Rectangle player : players) {
                    if (player.getPosition().getY() < 0) {
                        player.translateY(speed * time.getDeltaTime());
                    }
                    if (player.getPosition().getY() > Window.getHeight() - 200) {
                        player.translateY(-(speed * time.getDeltaTime()));
                    }

                    if (player.intersects(ball)) {
                        this.yvel = random.interger(25);
                        this.xvel = -xvel;
                        
                        if (random.bool()) {
                            this.yvel = -yvel;
                        }
                    }
                }

                if ((ball.getPosition().getY() < 0)
                        || (ball.getPosition().getY() > Window.getHeight() - 25)) {
                    this.yvel = -yvel;
                }

                if (ball.getPosition().getX() < Window.getWidth() && ball.getPosition().getX() > Window.getWidth() - 50) {
                    this.scoreA++;
                    this.yvel = 0;
                    this.xvel = -xvel;
                    this.ball.setPosition((Window.getWidth() / 2), (Window.getHeight() / 2));
                } else if (ball.getPosition().getX() > 0 && ball.getPosition().getX() < 50) {
                    this.scoreB++;
                    this.yvel = 0;
                    this.xvel = -xvel;
                    this.ball.setPosition((Window.getWidth() / 2), (Window.getHeight() / 2));
                }

                this.ball.translate(xvel, yvel);
                
                if (isKeyDown("space")) {
                    this.scoreA = 0;
                    this.scoreB = 0;
                }
            }

            @Override
            public void render() {
                dwarf.gfx.draw.basicText(scoreA + "  " + scoreB, new Point2D((Window.getWidth() / 2) - 16, Window.getHeight() - 50), WHITE);
                super.renderAllGameObjects();
            }
        };
    }
}
