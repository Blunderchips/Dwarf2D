package dwarf;

import dwarf.lib.LWJGL.WaveData;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
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
 * play sounds using <a href='http://www.openal.org/'>OpenAL</a> (Open Audio
 * Library)
 *
 * @author sid_th3_sl0th
 * @see java.lang.Object
 */
public class Sfx extends java.lang.Object {

    private String key;
    private int source;
    private int buffer;
    private WaveData data;

    public Sfx(String key) throws FileNotFoundException {
        super();
        this.init(key);
    }

    public Sfx(Sfx audio) throws FileNotFoundException {
        super();
        this.init(audio.getKey());
    }

    private void init(String key) throws FileNotFoundException {
        this.setData(WaveData.create(new BufferedInputStream(new FileInputStream(key))));
        this.setBuffer(alGenBuffers());

        alBufferData(getBuffer(), getData().getFormat(), getData().getData(), getData().getSamplerate());
        this.getData().dispose();

        this.key = key;
        this.setSource(alGenSources());
        alSourcei(getSource(), AL_BUFFER, getBuffer());
    }

    /**
     * plays the sound
     */
    public void play() {
        alSourcePlay(getSource());
    }

    /**
     * pauses the sound
     */
    public void pause() {
        alSourcePause(getSource());
    }

    /**
     * stops the sound
     */
    public void stop() {
        alSourceStop(getSource());
    }

    /**
     * rewinds the sound
     */
    public void rewind() {
        alSourceRewind(getSource());
    }

    /**
     * dispose if the sound
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

    public String getKey() {
        return this.key;
    }

    public Sfx get() {
        return this;
    }

    public void set(Sfx sfx) {
        this.setBuffer(sfx.getBuffer());
        this.setData(sfx.getData());
        this.setSource(sfx.getSource());
    }

    public void set(int buffer, WaveData waveData, int source) {
        this.setBuffer(buffer);
        this.setData(waveData);
        this.setSource(source);
    }

}
