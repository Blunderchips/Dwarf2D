/* 
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are 
 * met:
 * 
 * * Redistributions of source code must retain the above copyright 
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of 
 *   its contributors may be used to endorse or promote products derived 
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package dwarf.lib.LWJGL;

import com.sun.media.sound.WaveFileReader;
import dwarf.Game;
import dwarf.engine.core.Window;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Objects;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static org.lwjgl.openal.AL10.AL_FORMAT_MONO16;
import static org.lwjgl.openal.AL10.AL_FORMAT_MONO8;
import static org.lwjgl.openal.AL10.AL_FORMAT_STEREO16;
import static org.lwjgl.openal.AL10.AL_FORMAT_STEREO8;

/**
 * utility class for loading wavefiles (.wav).
 */
public class WaveData extends java.lang.Object {

    /**
     * actual wave data
     */
    private ByteBuffer data;

    /**
     * format type of data
     */
    private int format;

    /**
     * sample rate of data
     */
    private int samplerate;

    public WaveData() {
        super();
        this.init(null, 0, 0);
    }

    /**
     * Creates a new WaveData
     *
     * @param data actual wavedata
     * @param format format of wave data
     * @param samplerate sample rate of data
     */
    public WaveData(ByteBuffer data, int format, int samplerate) {
        super();
        this.init(data, format, samplerate);
    }

    private void init(ByteBuffer data, int format, int samplerate) {
        this.data = data;
        this.format = format;
        this.samplerate = samplerate;
    }

    /**
     * Disposes the wavedata
     */
    public void dispose() {
        data.clear();
    }

    /**
     * Creates a WaveData container from the specified url
     *
     * @param path URL to file
     * @return WaveData containing data, or null if a failure occurred
     */
    public static WaveData create(URL path) {
        try {
            // due to an issue with AudioSystem.getAudioInputStream
            // and mixing unsigned and signed code
            // we will use the reader directly
            WaveFileReader wfr = new WaveFileReader();
            return create(wfr.getAudioInputStream(new BufferedInputStream(path.openStream())));
        } catch (IOException | UnsupportedAudioFileException ex) {
            System.err.println(ex);
            org.lwjgl.LWJGLUtil.log("Unable to create from: " + path + ", " + ex.getMessage());
            return null;
        }
    }

    /**
     * Creates a WaveData container from the specified in the classpath
     *
     * @param path path to file (relative, and in classpath)
     * @return WaveData containing data, or null if a failure occurred
     */
    public static WaveData create(String path) {
        return create(Thread.currentThread().getContextClassLoader().getResource(path));
    }

    /**
     * Creates a WaveData container from the specified inputstream
     *
     * @param is InputStream to read from
     * @return WaveData containing data, or null if a failure occurred
     */
    public static WaveData create(InputStream is) {
        try {
            return create(
                    AudioSystem.getAudioInputStream(is));
        } catch (UnsupportedAudioFileException | IOException ex) {
            System.out.println(ex);
            org.lwjgl.LWJGLUtil.log("Unable to create from inputstream, " + ex.getMessage());
            return null;
        }
    }

    /**
     * Creates a WaveData container from the specified bytes
     *
     * @param buffer array of bytes containing the complete wave file
     * @return WaveData containing data, or null if a failure occurred
     */
    public static WaveData create(byte[] buffer) {
        try {
            return create(
                    AudioSystem.getAudioInputStream(
                            new BufferedInputStream(new ByteArrayInputStream(buffer))));
        } catch (UnsupportedAudioFileException | IOException ex) {
            System.err.println(ex);
            org.lwjgl.LWJGLUtil.log("Unable to create from byte array, " + ex.getMessage());
            return null;
        }
    }

    /**
     * Creates a WaveData container from the specified ByetBuffer. If the buffer
     * is backed by an array, it will be used directly, else the contents of the
     * buffer will be copied using get(byte[]).
     *
     * @param buffer ByteBuffer containing sound file
     * @return WaveData containing data, or null if a failure occured
     */
    public static WaveData create(ByteBuffer buffer) {
        try {
            byte[] bytes = null;

            if (buffer.hasArray()) {
                bytes = buffer.array();
            } else {
                bytes = new byte[buffer.capacity()];
                buffer.get(bytes);
            }
            return create(bytes);
        } catch (Exception ex) {
            System.err.println(ex);
            org.lwjgl.LWJGLUtil.log("Unable to create from ByteBuffer, " + ex.getMessage());
            return null;
        }
    }

    /**
     * Creates a WaveData container from the specified stream
     *
     * @param ais AudioInputStream to read from
     * @return WaveData containing data, or null if a failure occurred
     */
    public static WaveData create(AudioInputStream ais) {
        //get format of data
        AudioFormat audioformat = ais.getFormat();

        // get channels
        int channels = 0;
        if (audioformat.getChannels() == 1) {
            if (audioformat.getSampleSizeInBits() == 8) {
                channels = AL_FORMAT_MONO8;
            } else if (audioformat.getSampleSizeInBits() == 16) {
                channels = AL_FORMAT_MONO16;
            } else {
                assert false : "Illegal sample size";
            }
        } else if (audioformat.getChannels() == 2) {
            if (audioformat.getSampleSizeInBits() == 8) {
                channels = AL_FORMAT_STEREO8;
            } else if (audioformat.getSampleSizeInBits() == 16) {
                channels = AL_FORMAT_STEREO16;
            } else {
                assert false : "Illegal sample size";
            }
        } else {
            assert false : "Only mono or stereo is supported";
        }

        //read data into buffer
        ByteBuffer buffer = null;
        try {
            int available = ais.available();
            if (available <= 0) {
                available = ais.getFormat().getChannels() * (int) ais.getFrameLength() * ais.getFormat().getSampleSizeInBits() / 8;
            }
            byte[] buf = new byte[ais.available()];
            int read = 0, total = 0;
            while ((read = ais.read(buf, total, buf.length - total)) != -1
                    && total < buf.length) {
                total += read;
            }
            buffer = convertAudioBytes(buf, audioformat.getSampleSizeInBits() == 16, audioformat.isBigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }

        //create our result
        WaveData wavedata
                = new WaveData(buffer, channels, (int) audioformat.getSampleRate());

        //close stream
        try {
            ais.close();
        } catch (IOException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(
                    Window.getParent(), ex, Window.getTitle() + " - ERROR", ERROR_MESSAGE
            );
            Game.close(ex);
        }

        return wavedata;
    }

    private static ByteBuffer convertAudioBytes(byte[] audio_bytes, boolean two_bytes_data, ByteOrder order) {
        ByteBuffer dest = ByteBuffer.allocateDirect(audio_bytes.length);
        dest.order(ByteOrder.nativeOrder());
        ByteBuffer src = ByteBuffer.wrap(audio_bytes);
        src.order(order);
        if (two_bytes_data) {
            ShortBuffer dest_short = dest.asShortBuffer();
            ShortBuffer src_short = src.asShortBuffer();
            while (src_short.hasRemaining()) {
                dest_short.put(src_short.get());
            }
        } else {
            while (src.hasRemaining()) {
                dest.put(src.get());
            }
        }
        dest.rewind();
        return dest;
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
        hash = 17 * hash + Objects.hashCode(getData());
        hash = 17 * hash + getFormat();
        hash = 17 * hash + getSamplerate();
        return hash;
    }

    /**
     * Returns true if the arguments are equal to each other and false
     * otherwise. Consequently, if both arguments are null, true is returned and
     * if exactly one argument is null, false is returned. Otherwise, equality
     * is determined by using the equals method of the first argument.
     *
     * @return true if the arguments are equal to each other and false otherwise
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
        final WaveData other = (WaveData) obj;
        if (!Objects.equals(this.getData(), other.getData())) {
            return false;
        } else if (this.getFormat() != other.getFormat()) {
            return false;
        } else if (this.getSamplerate() != other.getSamplerate()) {
            return false;
        } else {
            return true;
        }
    }

    public ByteBuffer getData() {
        return this.data;
    }

    public int getFormat() {
        return this.format;
    }

    public int getSamplerate() {
        return this.samplerate;
    }

    @Override
    public String toString() {
        return "WaveData{" + "data=" + getData() + ", format=" + getFormat() + ", samplerate=" + getSamplerate() + '}' + " " + super.toString();
    }

}
