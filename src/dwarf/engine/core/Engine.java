package dwarf.engine.core;

import dwarf.time;

/**
 * the main engine file for the <a href='http://95.85.60.226/'>Dwarf2D</a>
 * Engine
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see <a href='http://95.85.60.226/'>Dwarf2D</a>
 * @see java.lang.Object
 */
public abstract class Engine extends java.lang.Object {

    public Engine() {
        super();
        openAL.init();
    }

    /**
     * "Starts" the engine.
     *
     * @param width the width of the window to be created.
     * @param height the height of the window to be created.
     * @param title the title of the window to be created.
     */
    public final void start(int width, int height, String title) {
        Window.create(width, height, title);
        openGL.init();
        Input.init();

        this.run();
    }

    /**
     * Main loop of the application.
     */
    public void run() {
        new Thread().start();
        this.load();
        while (true) {
            long lastFPS = time.getNano();

            if (!Window.isCloseRequested()) {
                this.update();
                Window.update();

                Window.clear();
                this.render();
                Window.render();

                Input.update();
            } else {
                this.onCloseRequested();
            }

            time.setDelta(lastFPS);
        }
    }

    /**
     * This function is called exactly once at the beginning of the game.
     */
    public abstract void load();

    /**
     * Callback function used to update the state of the game every frame.
     */
    public abstract void update();

    /**
     * Callback function used to render on the screen every frame.
     */
    public abstract void render();

    public abstract void onCloseRequested();

    /**
     * Disposes of the Engine.
     */
    public static void dispose() {
        Input.dispose();
        Window.dispose();
        openAL.dispose();
    }
}
