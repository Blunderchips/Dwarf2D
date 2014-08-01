package dwarf.engine.core;

import dwarf.Input;
import dwarf.time;

/**
 * the main engine file for the <a href='http:/95.85.60.226/'>Dwarf2D Engine</a>
 *
 * @author sid_th3_sl0th
 *
 * @see java.lang.Object
 * @see dwarf.Input#init()
 * @see dwarf.Input#dispose()
 * @see dwarf.engine.core.Window#create(int, int, java.lang.String)
 * @see dwarf.engine.core.openAL#init()
 * @see dwarf.engine.core.openGL#init()
 * @see dwarf.engine.core.openAL#dispose()
 * @see dwarf.engine.core.Window#dispose()
 */
public abstract class Engine extends java.lang.Object {

    public Engine() {
        super();
        openAL.init();
    }

    public void start(int width, int hieght, String title) {
        Window.create(width, hieght, title);
        openGL.init();
        Input.init();

        this.load();
        this.run();
    }

    /**
     * Main loop of application.
     */
    private void run() {
        while (true) {
            long lastFPS = time.getNano();

            if (!Window.isCloseRequested()) {
                this.update();
                Window.update();

                Window.clear();
                this.draw();
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
     * Callback function used to draw on the screen every frame.
     */
    public abstract void draw();

    public static void dispose() {
        Input.dispose();
        Window.dispose();
        openAL.dispose();
    }

}
