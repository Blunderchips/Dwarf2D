package dwarf.engine.core;

import dwarf.time;

/**
 * the main engine file
 *
 * @author sid_th3_sl0th
 */
public abstract class Engine extends java.lang.Object {

    protected Engine() {
        super();
        openAL.init();
    }

    protected void start(int width, int hieght, String title) {
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
    protected abstract void load();

    /**
     * Callback function used to update the state of the game every frame.
     */
    protected abstract void update();

    /**
     * Callback function used to draw on the screen every frame.
     */
    protected abstract void draw();

    protected static void dispose() {
        Input.dispose();
        Window.dispose();
        openAL.dispose();
    }

}
