package dwarf;

/**
 * A GameObject can update and render.
 * 
 * @author Matthew 'siD' Van der Bijl
 */
public interface GameObject {

    /**
     * Callback function used to update the state of the game every frame.
     */
    public abstract void update();

    /**
     * Callback function used to render on the screen every frame.
     */
    public abstract void render();
}
