package dwarf;

import dwarf.engine.core.Engine;
import java.util.Objects;
import java.util.ArrayList;
import java.io.Serializable;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeSupport;

import static java.lang.Math.abs;

/**
 * the main <code>Game</code> file and is the entry point to the
 * <code>Dwarf2D Engine</code>. Create and runs the main game window and acts as
 * a buffer between the user and the main <code>Engine</code> file.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.io.Serializable
 *
 * @see dwarf.engine.core.Engine
 * @see dwarf.engine.core.Window
 */
@SuppressWarnings("serial")
public abstract class Game extends dwarf.engine.core.Engine
        implements Serializable, Runnable {

    public static final String PROP_GAMEOBJECTS = "PROP_GAMEOBJECTS";
    private final transient PropertyChangeSupport propertyChangeSupport;
    private final transient VetoableChangeSupport vetoableChangeSupport;

    /**
     * the main <code>GameObject</code> <code>ArrayList</code>.
     */
    public ArrayList<GameObject> gameObjects;

    /**
     * Default constructor.
     */
    public Game() {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init(800, 600, null);
    }

    /**
     * @param width the width of the window to be created.
     * @param height the height of the window to be created.
     * @param title the title of the window to be created.
     */
    public Game(int width, int height, String title) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init(width, height, title);
    }

    /**
     * @param title the title of the window to be created.
     */
    public Game(String title) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init(800, 600, title);
    }

    /**
     * @param width the width of the window to be created.
     * @param height the height of the window to be created.
     */
    public Game(int width, int height) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init(width, height, null);
    }

    /**
     * @param dimensions the dimensions of the window to be created.
     */
    public Game(java.awt.Dimension dimensions) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init((int) dimensions.getWidth(), (int) dimensions.getHeight(), null);
    }

    /**
     * @param dimensions the dimensions of the window to be created.
     * @param title the title of the window to be created.
     */
    public Game(java.awt.Dimension dimensions, String title) {
        super();

        this.vetoableChangeSupport = new java.beans.VetoableChangeSupport(this);
        this.propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

        this.init((int) dimensions.getWidth(), (int) dimensions.getHeight(), title);
    }

    @Override
    @Deprecated
    public void run() {
        super.run();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game(".:Dwarf 2D:.") {

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
     * initialises the <code>Game</code>.This method is called from within the
     * constructor to initialize the <code>Shape</code>. <b>WARNING: Do NOT
     * modify this code.</b>
     *
     * @see dwarf.engine.core.Engine#start(int, int, java.lang.String)
     *
     * @param width the width of the window
     * @param height the height of the window
     * @param title the title of the window
     */
    @SuppressWarnings("Convert2Diamond")
    private void init(int width, int height, String title) throws IllegalArgumentException {
        if (width == 0 || height == 0) {
            throw new IllegalArgumentException(
                    "the width nor the hieght can be equal to zero.");
        }

        this.gameObjects = new ArrayList<GameObject>();

        //starts the main game loop.
        super.start(abs(width), abs(height), title);
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
        return this.gameObjects;
    }

    /**
     * tries to set the main <code>GameObject</code> list to a inputed
     * <code>ArrayList</code> of <code>GameObject</code>
     *
     * @param gameObjects the inputed ArrayList of GameObjects
     * @return true if successful and false if it fails
     */
    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public boolean setGameObjects(ArrayList<GameObject> gameObjects) throws DwarfException {
        try {
            this.gameObjects = gameObjects;
            return true;
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to add a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be added.
     * @return true if successful and false if it fails.
     */
    public boolean addGameObject(GameObject input) throws DwarfException {
        try {
            return this.getGameObjects().add(input);
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to add a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be added.
     * @return true if successful and false if it fails.
     */
    public boolean addGameObject(Object input) throws DwarfException {
        try {
            if (input instanceof GameObject) {
                return this.getGameObjects().add((GameObject) input);
            } else {
                throw new DwarfException("illegal argument");
            }
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be removed.
     * @return true if successful and false if it fails.
     */
    public boolean removeGameObject(GameObject input) throws DwarfException {
        try {
            return this.getGameObjects().remove(input);
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param input the <code>GameObject</code> to be removed.
     * @return true if successful and false if it fails.
     */
    @SuppressWarnings("element-type-mismatch")
    public boolean removeGameObject(Object input) throws DwarfException {
        try {
            return this.getGameObjects().remove(input);
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * tries to remove a <code>GameObject</code> to the main
     * <code>GameObject</code> <code>ArrayList</code>.
     *
     * @param index of the <code>GameObject</code> to be removed.
     * @return true if successful and false if it fails.
     */
    public boolean removeGameObject(int index) throws DwarfException {
        try {
            this.getGameObjects().remove(index);
            return true;
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    public static void close(int status) {
        dwarf.engine.core.Engine.dispose();
        System.exit(status);
    }

    public static void close() {
        Game.close(0);
    }

    public static void close(Throwable cause) {
        throw new DwarfError(cause);
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @see java.lang.Object#equals(java.lang.Object)
     * @param obj the <code>Object</code> to be tested
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Game otherGame = (Game) obj;

        if (!Objects.equals(this.propertyChangeSupport, otherGame.propertyChangeSupport)) {
            return false;
        } else if (!Objects.equals(this.vetoableChangeSupport, otherGame.vetoableChangeSupport)) {
            return false;
        } else if (!Objects.equals(this.gameObjects, otherGame.gameObjects)) {
            return false;
        }

        return true;
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
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(propertyChangeSupport);
        hash = 47 * hash + Objects.hashCode(vetoableChangeSupport);
        hash = 47 * hash + Objects.hashCode(getGameObjects());
        return hash;
    }

    /**
     * Returns a string representation of the object.
     * <p>
     * In general, the toString method returns a string that "textually
     * represents" this object. The result should be a concise but informative
     * representation that is easy for a person to read. It is recommended that
     * all subclasses override this method.</p>
     *
     * @return a textually representation of this object
     */
    @Override
    public String toString() {
        return "Game = {"
                + "propertyChangeSupport: " + propertyChangeSupport + ", "
                + "vetoableChangeSupport: " + vetoableChangeSupport + ", "
                + "GameObjects: " + getGameObjects().toString()
                + "}";
    }

    /**
     * renders all <code>GameObject</code> in the main <code>GameObject</code>
     * <code>ArrayList</code>.
     */
    public void renderAllGameObjects() {
        for (GameObject obj : getGameObjects()) {
            obj.render();
        }
    }

    /**
     * updates all <code>GameObject</code> in the main <code>GameObject</code>
     * <code>ArrayList</code>.
     */
    public void updateAllGameObjects() {
        for (GameObject obj : getGameObjects()) {
            obj.update();
        }
    }

    /**
     * reset <code>GameObject</code> in the main <code>GameObject</code>
     * <code>ArrayList</code>.
     *
     * @return will return false if it fails and true if it does not
     */
    public boolean resetGameObjects() throws DwarfException {
        try {
            this.gameObjects = new ArrayList<>();
            return true;
        } catch (Exception ex) {
            throw new DwarfException(ex);
        }
    }

    /**
     * clears all <code>GameObject</code> in the main <code>GameObject</code>
     * <code>ArrayList</code>.
     */
    public void clearGameObjects() {
        this.gameObjects.clear();
    }

    public int getNumGameObjects() {
        return this.gameObjects.size();
    }

    @Override
    public void onCloseRequested() {
        Engine.dispose();
        System.exit(0);
    }
}
