package dwarf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Provides an interface to your system's clock and other time base utilities.
 *
 * @author sid_th3_sl0th
 */
public final class time {

    private static long sleepPrecision;
    private static long worstYieldTime;

    public time() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    /**
     * Amount of millisecond is a second.
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
     * @return Returns the value of a timer with an unspecified starting time.
     * The time is accurate to the microsecond.
     */
    public static long getNano() {
        return System.nanoTime();
    }

    public static String getDate() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date dateobj = new Date();

        return df.format(dateobj);
    }

    public static String getTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yy ");
        Date dateobj = new Date();

        return df.format(dateobj);
    }

    /**
     * Delta Time is the time it takes for the computer to go through all the
     * processing/rendering for a single frame. It is dynamically updated, so it
     * can fluctuate depending on what level of processing the last frame
     * required.
     *
     * @return Returns the time between the last two frames.
     */
    public static double getDelta() {
        return time.dt;
    }

    /**
     * time.dt = (time.getNano() - (double)lastTime) / time.SECOND
     *
     * @param lastTime
     */
    public static void setDelta(long lastTime) {
        time.dt = (time.getNano() - (double) lastTime) / time.SECOND;
    }

    /**
     * Sleep for the specified amount of time.
     *
     * @param nanos time to wait in nanoseconds.
     * @param tStart The time from which the waiting should start.
     *
     * @throws InterruptedException if another thread has interrupted the
     * current thread
     */
    public static void sleepFromTime(long nanos, long tStart) throws InterruptedException {
        long sleepNanos = nanos - sleepPrecision;

        // First, use Java's Thread.sleep() if it is precise enough
        if (nanos / sleepPrecision >= 2) {
            long actualDelayMillis = (sleepNanos) / 1000000L;
            int nanoRest = (int) (sleepNanos % 1000000L);
            if (Thread.interrupted()) {
                throw new InterruptedException("Time.sleepFromTime interrupted in sleep.");
            }
            Thread.sleep(actualDelayMillis, nanoRest);
        }

        // Second, yield in a busy loop if precise enough
        while ((System.nanoTime() - tStart + worstYieldTime) < nanos) {
            long t1 = System.nanoTime();
            if (Thread.interrupted()) {
                throw new InterruptedException("Time.sleepFromTime interrupted in yield.");
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
                throw new InterruptedException("Time.sleepFromTime interrupted in busy loop.");
            }
        }
    }

    /**
     * Causes the currently executing thread to sleep for the specified number
     * of milliseconds.
     *
     * @param millis the length of time to sleep in milliseconds
     */
    public static void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }

}
