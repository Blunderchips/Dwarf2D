package dwarf.engine.core;

import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeSupport;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author sid_th3_sl0th
 */
public abstract class Game extends Engine {

    private int WIDTH;
    private int HIEGHT;
    private String TITLE;

    public static ArrayList<GameObject> gameObjects;
    public static boolean debug = true;
    private boolean loaded = false;
    //NetBeans wanted these:
    public static final String PROP_GAMEOBJECTS = "PROP_GAMEOBJECTS";
    private final transient PropertyChangeSupport propertyChangeSupport;
    private final transient VetoableChangeSupport vetoableChangeSupport;

    public Game() {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init(800, 600, null);
    }

    public Game(int width, int hieght, String title) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init(width, hieght, title);
    }

    public Game(String title) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init(800, 600, title);
    }

    public Game(int width, int hieght) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init(width, hieght, null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Game defaultGame = new Game("Dwarf 2D") {

            @Override
            public void load() {
            }

            @Override
            public void update() {
            }

            @Override
            public void draw() {
            }
        };
    }

    private void init(int width, int hieght, String title) {
        if (width == 0 || hieght == 0) {
            throw new IllegalArgumentException(
                    "the width nor the hieght can be equal to zero.");
        }

        this.WIDTH = abs(width);
        this.HIEGHT = abs(hieght);
        this.TITLE = title;

        gameObjects = new ArrayList<>();

        this.run();
    }

    /**
     * starts and runs the main game loop
     */
    private void run() {
        this.start(WIDTH, HIEGHT, TITLE);
    }

    @Override
    protected void refresh() {
        if (loaded) {
            for (GameObject item : gameObjects) {
                item.update();
                item.updateChildren();
            }
            this.update();
        } else {
            this.load();
            this.loaded = true;
        }
    }

    @Override
    protected void render() {
        for (GameObject item : gameObjects) {
            item.render();
            item.renderChildren();
        }

        this.draw();
    }

    public abstract void load();

    public abstract void update();

    public abstract void draw();

    public ArrayList<GameObject> getGameObjects() {
        return Game.gameObjects;
    }

    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        Game.gameObjects = gameObjects;
    }

    public void addGameObject(GameObject input) {
        this.getGameObjects().add(input);
    }

    public void removeGameObject(GameObject input) {
        this.getGameObjects().remove(input);
    }

    public void removeGameObject(int index) {
        this.getGameObjects().remove(index);
    }

    public static void close(int status) {
        Engine.dispose();
        System.exit(status);
    }

    public static void close() {
        Game.close(0);
    }

    public static void close(Throwable ex) {
        Engine.dispose();
        throw new RuntimeException(ex);
    }

    public int getHieght() {
        return this.HIEGHT;
    }

    public int getWidth() {
        return this.WIDTH;
    }

    public String getTitle() {
        return this.TITLE;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + WIDTH;
        hash = 37 * hash + HIEGHT;
        hash = 37 * hash + Objects.hashCode(TITLE);
        hash = 37 * hash + Objects.hashCode(propertyChangeSupport);
        hash = 37 * hash + Objects.hashCode(vetoableChangeSupport);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else if (!super.equals(obj)) {
            return false;
        }

        final Game game = (Game) obj;

        if (this.getWidth() != game.getWidth()) {
            return false;
        } else if (this.getHieght() != game.getHieght()) {
            return false;
        } else if (!Objects.equals(this.getTitle(), game.getHieght())) {
            return false;
        } else if (!Objects.equals(this.propertyChangeSupport, game.propertyChangeSupport)) {
            return false;
        } else {
            return Objects.equals(this.vetoableChangeSupport, game.vetoableChangeSupport);
        }
    }

    @Override
    public String toString() {
        return "Game = {" + "\n"
                + "\t" + "width: " + this.getWidth() + "\n"
                + "\t" + "hieght: " + this.getHieght() + "\n"
                + "\t" + "title: " + this.getTitle() + "\n"
                + "\t" + "super: " + super.toString() + "\n"
                + "}";
    }

    public boolean isDebug() {
        return Game.debug;
    }

    public void setDebugMode(boolean mode) {
        Game.debug = mode;
    }

    public boolean isLoaded() {
        return this.loaded;
    }
}
