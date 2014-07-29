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

        this.run();
    }

    /**
     * Main loop of application.
     */
    private void run() {
        while (true) {
            long lastFPS = time.getNano();

            if (!Window.isCloseRequested()) {
                this.refresh();
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

    protected abstract void refresh();

    protected abstract void render();

    protected static void dispose() {
        Input.dispose();
        Window.dispose();
        openAL.dispose();
    }

}
