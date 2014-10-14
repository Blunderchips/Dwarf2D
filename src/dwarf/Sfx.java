package dwarf;

import java.util.Objects;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;

import dwarf.lwjgl.WaveData;

import static org.lwjgl.openal.AL10.AL_BUFFER;
import static org.lwjgl.openal.AL10.alBufferData;
import static org.lwjgl.openal.AL10.alDeleteBuffers;
import static org.lwjgl.openal.AL10.alGenBuffers;
import static org.lwjgl.openal.AL10.alGenSources;
import static org.lwjgl.openal.AL10.alSourcePause;
import static org.lwjgl.openal.AL10.alSourcePlay;
import static org.lwjgl.openal.AL10.alSourceRewind;
import static org.lwjgl.openal.AL10.alSourceStop;
import static org.lwjgl.openal.AL10.alSourcei;

/**
 * play Sound effect (sfx) using <a href='http://www.openal.org/'>OpenAL</a>.
 * (Open Audio Library) Load various sound formats for use with <a
 * href='http://www.openal.org/'>OpenAL</a> (.wav, .xm, .ogg, etc).
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Object
 * @see java.lang.Cloneable
 * @see dwarf.engine.core.openAL
 * @see <a href='http://www.openal.org/'>openal.org</a>
 */
public class Sfx extends java.lang.Object implements Cloneable {

    private static boolean isMute = false;

    public static boolean isMute() {
        return Sfx.isMute;
    }

    public static void setMute(boolean isMute) {
        Sfx.isMute = isMute;
    }

    private String path;
    private int source;
    private int buffer;
    private WaveData data;

    /**
     * Default constructor.
     */
    public Sfx() {
        super();
    }

    public Sfx(String path) throws DwarfException {
        super();

        this.path = path;
        this.init();
    }

    public Sfx(Sfx audio) throws DwarfException {
        this(audio.getPath());
    }

    /**
     * plays the sound.
     */
    public void play() {
        // if (!isMute()) {
        alSourcePlay(source);
        //   }
    }

    /**
     * pauses the sound.
     */
    public void pause() {
        alSourcePause(source);
    }

    /**
     * stops the sound.
     */
    public void stop() {
        alSourceStop(source);
    }

    /**
     * rewinds the sound.
     */
    public void rewind() {
        alSourceRewind(source);
    }

    /**
     * dispose if the sound.
     */
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

    public int format() {
        return this.getData().getFormat();
    }

    public int samplerate() {
        return this.getData().getSamplerate();
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
        hash = 37 * hash + Objects.hashCode(this.path);
        hash = 37 * hash + this.source;
        hash = 37 * hash + this.buffer;
        hash = 37 * hash + Objects.hashCode(this.data);
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @param obj the <code>Object</code> to be tested
     * @see java.lang.Object#equals(java.lang.Object)
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

        final Sfx other = (Sfx) obj;

        if (!Objects.equals(this.path, other.path)) {
            return false;
        } else if (this.source != other.source) {
            return false;
        } else if (this.buffer != other.buffer) {
            return false;
        } else if (!Objects.equals(this.data, other.data)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Sound = {"
                + "source: " + getSource() + ", "
                + "buffer: " + getBuffer() + ", "
                + "data: " + getData()
                + "}";
    }

    public String getPath() {
        return this.path;
    }

    public Sfx get() {
        return this;
    }

    public void set(Sfx audio) {
        this.path = audio.getPath();
        this.init();
    }

    public void set(String path) throws DwarfException {
        this.path = path;
        this.init();
    }

    @Override
    public Sfx clone() throws CloneNotSupportedException {
        return new Sfx(this);
    }

    /**
     * This method is called from within the constructor to initialize the
     * <code>Sfx</code>. WARNING: Do NOT modify this code.
     *
     * @throws DwarfException if the source is not found
     */
    public final void init() throws DwarfException {
        try {
            this.data = WaveData.create(new BufferedInputStream(new FileInputStream(path)));
        } catch (FileNotFoundException notFoundException) {
            throw new DwarfException(notFoundException);
        } finally {
            this.buffer = alGenBuffers();
            alBufferData(buffer, data.getFormat(), data.getData(), data.getSamplerate());
            this.data.dispose();
            this.source = alGenSources();
            alSourcei(source, AL_BUFFER, buffer);
        }
    }
}
