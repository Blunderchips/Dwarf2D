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
    private boolean useDefaultRender = true;
    private boolean useDefaultUpdate = true;
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

    public Game(float width, float hieght, String title) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init((int) width, (int) hieght, title);
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

    public Game(float width, float hieght) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init((int) width, (int) hieght, null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Game defaultGame = new Game(".:Dwarf 2D:.") {

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
     * starts the main game loop.
     */
    private void run() {
        this.start(WIDTH, HIEGHT, TITLE);
    }

    /**
     * Same as update(). Subclass can override refresh() instead of update().
     * Same thing, just a matter of taste. by default will update all
     * gameObjects and their children, will then call update()
     *
     * @see update()
     */
    @Override
    protected void refresh() {
        if (loaded) {
            if (useDefaultUpdate) {
                for (GameObject obj : gameObjects) {
                    obj.update();
                    obj.updateChildren();
                }
            }
            this.update();
        } else {
            this.load();
            this.loaded = true;
        }
    }

    /**
     * Same as draw(). Subclass can override render() instead of draw(). Same
     * thing, just a matter of taste. by default will render all gameObjects and
     * their children, will then call draw().
     *
     * @see draw()
     */
    @Override
    protected void render() {
        if (useDefaultRender) {
            for (GameObject obj : gameObjects) {
                obj.render();
                obj.renderChildren();
            }
        }
        this.draw();
    }

    public abstract void load();

    public abstract void update();

    public abstract void draw();

    public ArrayList<GameObject> getGameObjects() {
        return Game.gameObjects;
    }

    /**
     * tries to set the main GameObject list to a inputed ArrayList of
     * GameObects
     *
     * @param gameObjects
     * @gameObjects an ArrayList of GameObjects
     * @return true if successful and false if it fails
     */
    public boolean setGameObjects(ArrayList<GameObject> gameObjects) {
        try {
            Game.gameObjects = gameObjects;
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to add a GameObject to the main GameObject list
     *
     * @param input the GameObeject to be added
     * @return true if successful and false if it fails
     */
    public boolean addGameObject(GameObject input) {
        try {
            return this.getGameObjects().add(input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to add a GameObject to the main GameObject list
     *
     * @param input the GameObeject to be added
     * @return true if successful and false if it fails
     */
    public boolean addGameObject(Object input) {
        try {
            return this.getGameObjects().add((GameObject) input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to remove a GameObject to the main GameObject list
     *
     * @param input the GameObeject to be removed
     * @return true if successful and false if it fails
     */
    public boolean removeGameObject(GameObject input) {
        try {
            return this.getGameObjects().remove(input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to remove a GameObject to the main GameObject list
     *
     * @param input the GameObeject to be removed
     * @return true if successful and false if it fails
     */
    public boolean removeGameObject(Object input) {
        try {
            return this.getGameObjects().remove(input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to remove a GameObject to the main GameObject list
     *
     * @param index of the GameObject to be removed
     * @return true if successful and false if it fails
     */
    public boolean removeGameObject(int index) {
        try {
            this.getGameObjects().remove(index);
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
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

    /**
     * Class Object is the root of the class hierarchy. Every class has Object
     * as a superclass. All objects, including arrays, implement the methods of
     * this class.
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /**
     * Returns true if the arguments are equal to each other and false
     * otherwise. Consequently, if both arguments are null, true is returned and
     * if exactly one argument is null, false is returned. Otherwise, equality
     * is determined by using the equals method of the first argument.
     *
     * @return true if the arguments are equal to each other and false otherwise
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    public boolean useDefaultRender() {
        return this.useDefaultRender;
    }

    public void setUseDefaultRender(boolean useDefaultRender) {
        this.useDefaultRender = useDefaultRender;
    }

    public boolean useDefaultUpdate() {
        return this.useDefaultUpdate;
    }

    public void setUseDefaultUpdate(boolean useDefaultUpdate) {
        this.useDefaultUpdate = useDefaultUpdate;
    }
}
