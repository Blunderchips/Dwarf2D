package dwarf;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Provides an interface to your system's clock and other time base utilities to
 * the user.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public final class time {

    /**
     * you can not instantiate this class.
     */
    public time() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    private static long sleepPrecision;
    private static long worstYieldTime;

    /**
     * Amount of Nanosecond is a second.
     */
    public static final long SECOND = 0x5f5e100L;

    /**
     * Delta Time is the time it takes for the computer to go through all the
     * processing/rendering for a single frame. It is dynamically updated, so it
     * can fluctuate depending on what level of processing the last frame
     * required.
     */
    private static double dt;

    /**
     * Returns the value of a timer with an unspecified starting time. The time
     * is accurate to the microsecond.
     *
     * @return the value of a timer with an unspecified starting time
     */
    public static long getNano() {
        return System.nanoTime();
    }

    public static String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static String getDate() {
        return new SimpleDateFormat("dd/MM/yy ").format(new Date());
    }

    /**
     * Delta Time is the time it takes for the computer to go through all the
     * processing/rendering for a single frame. It is dynamically updated, so it
     * can fluctuate depending on what level of processing the last frame
     * required.
     *
     * @return the time between the last two frames.
     */
    public static final double getDeltaTime() {
        return time.dt;
    }

    /**
     * time.dt = (time.getNano() - (double)lastTime) / time.SECOND
     *
     * @param lastTime the last frame time
     */
    public static final void setDelta(long lastTime) {
        time.dt = (time.getNano() - (double) lastTime) / time.SECOND;
    }

    /**
     * Sleep for the specified amount of time.
     *
     * @param nanos time to wait in nanoseconds.
     * @param tStart The time from which the waiting should start.
     *
     * @throws DwarfException if another thread has interrupted the current
     * thread
     */
    public static void sleepFromTime(long nanos, long tStart) throws DwarfException {
        long sleepNanos = nanos - sleepPrecision;

        // First, use Java's Thread.sleep() if it is precise enough
        if (nanos / sleepPrecision >= 2) {
            try {
                long actualDelayMillis = (sleepNanos) / 1000000L;
                int nanoRest = (int) (sleepNanos % 1000000L);
                if (Thread.interrupted()) {
                    throw new DwarfException("Time.sleepFromTime interrupted in sleep.");
                }
                Thread.sleep(actualDelayMillis, nanoRest);
            } catch (InterruptedException ie) {
                throw new DwarfException(ie);
            }
        }

        // Second, yield in a busy loop if precise enough
        while ((System.nanoTime() - tStart + worstYieldTime) < nanos) {
            long t1 = System.nanoTime();
            if (Thread.interrupted()) {
                throw new DwarfException("Time.sleepFromTime interrupted in yield.");
            }
            Thread.yield();
            long yieldTime = System.nanoTime() - t1;
            if (yieldTime > worstYieldTime) {
                worstYieldTime = yieldTime;
            }
        }

        // Third, run a busy loop for the rest of the time
        while ((System.nanoTime() - tStart) < nanos) {
            if (Thread.interrupted()) {
                throw new DwarfException("Time.sleepFromTime interrupted in busy loop.");
            }
        }
    }

    /**
     * Causes the currently executing thread to sleep for the specified number
     * of milliseconds.
     *
     * @param millis the length of time to sleep in milliseconds
     */
    public static void sleep(Long millis) throws DwarfException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            throw new DwarfException(ie);
        }
    }

}
