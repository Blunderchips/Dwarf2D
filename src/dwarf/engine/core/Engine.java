package dwarf.engine.core;

import dwarf.Input;
import dwarf.time;

/**
 * the main engine file for the <a href='http://95.85.60.226/'>Dwarf2D</a>
 * Engine
 *
 * @author sid_th3_sl0th
 *
 * @see <a href='http://95.85.60.226/'>Dwarf2D</a>
 * @see java.lang.Object
 */
public abstract class Engine extends java.lang.Object {

    public Engine() {
        super();
        openAL.init();
    }

    public final void start(int width, int hieght, String title) {
        Window.create(width, hieght, title);
        openGL.init();
        Input.init();

        this.load();
        this.run();
    }

    /**
     * Main loop of the application.
     */
    private void run() {
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
                Engine.dispose();
                break;
            }

            time.setDelta(lastFPS);
        }
        System.exit(0);
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

    public final static void dispose() {
        Input.dispose();
        Window.dispose();
        openAL.dispose();
    }

}
