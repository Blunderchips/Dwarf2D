package dwarf;

import java.util.Objects;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;

import dwarf.lib.LWJGL.WaveData;

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
 * play sounds using <a href='http://www.openal.org/'>OpenAL</a>. (Open Audio
 * Library) Load various sound formats for use with <a
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

        try {
            this.data = WaveData.create(new BufferedInputStream(new FileInputStream(path)));
        } catch (FileNotFoundException notFoundException) {
            throw new DwarfException(notFoundException);
        } finally {
            this.buffer = alGenBuffers();

            alBufferData(buffer, data.getFormat(), data.getData(), data.getSamplerate());
            this.data.dispose();

            this.path = path;
            this.source = alGenSources();
            alSourcei(source, AL_BUFFER, buffer);
        }
    }

    public Sfx(Sfx audio) throws DwarfException {
        super();

        try {
            this.data = WaveData.create(new BufferedInputStream(new FileInputStream(audio.getPath())));
        } catch (FileNotFoundException notFoundException) {
            throw new DwarfException(notFoundException);
        } finally {
            this.buffer = alGenBuffers();

            alBufferData(buffer, data.getFormat(), data.getData(), data.getSamplerate());
            this.data.dispose();

            this.path = audio.getPath();
            this.source = alGenSources();
            alSourcei(source, AL_BUFFER, buffer);
        }
    }

    /**
     * plays the sound.
     */
    public void play() {
        if (!isMute()) {
            alSourcePlay(getSource());
        }
    }

    /**
     * pauses the sound.
     */
    public void pause() {
        alSourcePause(getSource());
    }

    /**
     * stops the sound.
     */
    public void stop() {
        alSourceStop(getSource());
    }

    /**
     * rewinds the sound.
     */
    public void rewind() {
        alSourceRewind(getSource());
    }

    /**
     * dispose if the sound.
     */
    public void destroy() {
        alDeleteBuffers(getBuffer());
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
        int hash = 3;
        hash = 13 * hash + getSource();
        hash = 13 * hash + getBuffer();
        hash = 13 * hash + Objects.hashCode(getData());
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else if (!super.equals(obj)) {
            return false;
        }
        final Sfx other = (Sfx) obj;
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
        return "Sound = {"
                + "source: " + getSource() + ", "
                + "buffer: " + getBuffer() + ", "
                + "data: " + getData() + ", "
                + "super: " + super.toString()
                + "}";
    }

    public String getPath() {
        return this.path;
    }

    public Sfx get() {
        return this;
    }

    public void set(Sfx audio) {
        try {
            this.data = WaveData.create(new BufferedInputStream(new FileInputStream(audio.getPath())));
        } catch (FileNotFoundException notFoundException) {
            throw new DwarfException(notFoundException);
        } finally {
            this.buffer = alGenBuffers();

            alBufferData(buffer, data.getFormat(), data.getData(), data.getSamplerate());
            this.data.dispose();

            this.path = audio.getPath();
            this.source = alGenSources();
            alSourcei(source, AL_BUFFER, buffer);
        }
    }

    public void set(String path) {
        try {
            this.data = WaveData.create(new BufferedInputStream(new FileInputStream(path)));
        } catch (FileNotFoundException notFoundException) {
            throw new DwarfException(notFoundException);
        } finally {
            this.buffer = alGenBuffers();

            alBufferData(buffer, data.getFormat(), data.getData(), data.getSamplerate());
            this.data.dispose();

            this.path = path;
            this.source = alGenSources();
            alSourcei(source, AL_BUFFER, buffer);
        }
    }

    @Override
    public Sfx clone() throws CloneNotSupportedException {
        return new Sfx(this);
    }
}
