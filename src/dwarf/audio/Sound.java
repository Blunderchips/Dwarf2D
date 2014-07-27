package dwarf.audio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
import dwarf.engine.core.Game;
import dwarf.engine.core.Window;
import javax.swing.JOptionPane;
import static org.lwjgl.openal.AL10.AL_BUFFER;
import static org.lwjgl.openal.AL10.alBufferData;
import static org.lwjgl.openal.AL10.alDeleteBuffers;
import static org.lwjgl.openal.AL10.alGenBuffers;
import static org.lwjgl.openal.AL10.alGenSources;
import static org.lwjgl.openal.AL10.alSourcePlay;
import static org.lwjgl.openal.AL10.alSourcei;

/**
 * play sounds
 *
 * @author sid_th3_sl0th
 */
public class Sound extends java.lang.Object {

    private int source;
    private int buffer;

    private WaveData data;

    public Sound(String key) {
        super();

        try {
            this.init(key);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", JOptionPane.ERROR_MESSAGE
            );
            Game.close(ex);
        }
    }

    private void init(String key) throws FileNotFoundException {
        this.data = WaveData.create(new BufferedInputStream(new FileInputStream(key)));
        this.buffer = alGenBuffers();

        alBufferData(buffer, data.getFormat(), data.getData(), data.getSamplerate());
        this.data.dispose();

        this.source = alGenSources();
        alSourcei(source, AL_BUFFER, buffer);
    }

    public void play() {
        alSourcePlay(source);
    }

    public void destroy() {
        alDeleteBuffers(buffer);
    }

    public int getSource() {
        return this.source;
    }

    public int getBuffer() {
        return this.buffer;
    }

    public WaveData getData() {
        return this.data;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public void setData(WaveData data) {
        this.data = data;
    }

    public int format() {
        return this.data.getFormat();
    }

    public int samplerate() {
        return this.data.getSamplerate();
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
        int hash = 3;
        hash = 13 * hash + this.source;
        hash = 13 * hash + this.buffer;
        hash = 13 * hash + Objects.hashCode(this.data);
        return hash;
    }

    /**
     * Returns true if the arguments are equal to each other and false
     * otherwise. Consequently, if both arguments are null, true is returned and
     * if exactly one argument is null, false is returned. Otherwise, equality
     * is determined by using the equals method of the first argument.
     *
     * @return true if the sounds are equal other wise false.
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
        final Sound other = (Sound) obj;
        if (this.getSource() != other.getSource()) {
            return false;
        } else if (this.getBuffer() != other.getBuffer()) {
            return false;
        } else {
            return Objects.equals(this.getData(), other.getData());
        }
    }

    @Override
    public String toString() {
        return "Sound{" + "source=" + source + ", buffer=" + buffer + ", data=" + data + '}';
    }
}
