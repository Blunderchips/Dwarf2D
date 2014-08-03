package dwarf;

import dwarf.engine.core.Engine;
import dwarf.util.Vector2;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeSupport;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Objects;

/**
 * the main <code>Game</code> file and is the entry point to the
 * <code>Dwarf2D Engine</code>. Create and runs the main game window and acts as
 * a buffer between the user and the main <code>Engine</code> file.
 *
 * @author sid_th3_sl0th
 *
 * @see dwarf.engine.core.Engine
 * @see dwarf.engine.core.Window
 */
public abstract class Game extends Engine {

    public static ArrayList<GameObject> gameObjects;
    public static boolean debug = true;
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

    public Game(Vector2 dimensions) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init((int) dimensions.getX(), (int) dimensions.getY(), null);
    }

    public Game(Vector2 dimensions, String title) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init((int) dimensions.getX(), (int) dimensions.getY(), title);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Game defaultGame = new Game(".:Dwarf 2D:.") {
            @Override
            public void load() {
                //This function is called exactly once at the beginning of the game.
            }

            @Override
            public void update() {
                //Callback function used to update the state of the game every frame.
            }

            @Override
            public void render() {
                //Callback function used to render on the screen every frame.
            }
        };
    }

    /**
     * initialises the <code>Game</code>.
     *
     * @param position the location of the game of the game window
     */
    @SuppressWarnings("Convert2Diamond")
    private void init(int width, int hieght, String title) {
        if (width == 0 || hieght == 0) {
            throw new IllegalArgumentException(
                    "the width nor the hieght can be equal to zero.");
        }

        Game.gameObjects = new ArrayList<GameObject>();

        //starts the main game loop.
        this.start(abs(width), abs(hieght), title);
    }

    /**
     * This function is called exactly once at the beginning of the game.
     */
    @Override
    public abstract void load();

    /**
     * Callback function used to update the state of the game every frame.
     */
    @Override
    public abstract void update();

    /**
     * Callback function used to render on the screen every frame.
     */
    @Override
    public abstract void render();

    /**
     * returns all <code>GameObject</code> added to the main
     * <code>GameObject</code> <code>ArrayList</code> as a new
     * <code>ArrayList</code>
     *
     * @return <code>ArrayList</code> of all added <code>GameObject</code>
     */
    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public ArrayList<GameObject> getGameObjects() {
        return Game.gameObjects;
    }

    /**
     * tries to set the main <code>GameObject</code> list to a inputed
     * <code>ArrayList</code> of <code>GameObject</code>
     *
     * @param gameObjects the inputed ArrayList of GameObjects
     * @return true if successful and false if it fails
     */
    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
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
     * tries to add a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>
     *
     * @param input the <code>GameObject</code> to be added
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
     * tries to add a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>
     *
     * @param input the <code>GameObject</code> to be added
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
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>
     *
     * @param input the <code>GameObject</code> to be removed
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
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>
     *
     * @param input the <code>GameObject</code> to be removed
     * @return true if successful and false if it fails
     */
    @SuppressWarnings("element-type-mismatch")
    public boolean removeGameObject(Object input) {
        try {
            return this.getGameObjects().remove(input);
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>
     *
     * @param index of the <code>GameObject</code> to be removed
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
        hash = 37 * hash + Objects.hashCode(propertyChangeSupport);
        hash = 37 * hash + Objects.hashCode(vetoableChangeSupport);
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    @SuppressWarnings("AccessingNonPublicFieldOfAnotherObject")
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else if (!super.equals(obj)) {
            return false;
        }

        final Game game = (Game) obj;
        if (!Objects.equals(this.propertyChangeSupport, game.propertyChangeSupport)) {
            return false;
        } else {
            return Objects.equals(this.vetoableChangeSupport, game.vetoableChangeSupport);
        }
    }

    @Override
    public String toString() {
        return "Game = {"
                + "propertyChangeSupport: " + propertyChangeSupport + ", "
                + "vetoableChangeSupport: " + vetoableChangeSupport + ", "
                + "super: " + super.toString()
                + "}";
    }

    /**
     * returns true if the game is in debug mode otherwise false
     *
     * @return if the game in in debug mode
     */
    public boolean isDebug() {
        return Game.debug;
    }

    public void setDebugMode(boolean mode) {
        Game.debug = mode;
    }

    /**
     * renders all <code>GameObject</code> in the main <code>GameObject</code>
     * <code>ArrayList</code>.
     */
    public void renderAllGameObjects() {
        getGameObjects().stream().map((child) -> {
            child.render();
            return child;
        }).forEach((child) -> {
            child.renderChildren();
        });
    }

    /**
     * updates all <code>GameObject</code> in the main <code>GameObject</code>
     * <code>ArrayList</code>.
     */
    public void updateAllGameObjects() {
        getGameObjects().stream().map((child) -> {
            child.update();
            return child;
        }).forEach((child) -> {
            child.updateChildren();
        });
    }

    /**
     * all <code>GameObject</code> in the main <code>GameObject</code>
     * <code>ArrayList</code>
     */
    @SuppressWarnings({"Convert2Diamond", "static-access"})
    public void clearGameObjects() {
        this.gameObjects = new ArrayList<GameObject>();
    }
}
