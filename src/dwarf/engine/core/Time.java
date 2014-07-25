package dwarf.engine.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sid_th3_sl0th
 */
public final class Time {

    private static Long sleepPrecision;
    private static long worstYieldTime;

    public Time() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    /**
     * amount of millisecond is a second
     */
    public static final long SECOND = 0x5f5e100L;

    private static double delta;

    /**
     * @return System.nanoTime()
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
     * @return return time.delta
     */
    public static double getDelta() {
        return Time.delta;
    }

    /**
     * time.delta = (time.getNano() - (double)lastTime) / time.SECOND
     *
     * @param lastTime
     */
    public static void setDelta(long lastTime) {
        Time.delta = (Time.getNano() - (double) lastTime) / Time.SECOND;
    }

    /**
     * Sleep for the specified amount of time.
     *
     * @param nanos Time to wait in nanoseconds.
     * @param tStart The time from which the waiting should start.
     *
     * @throws InterruptedException if another thread has interrupted the
     * current thread
     */
    public static void sleepFromTime(long nanos, long tStart)
            throws InterruptedException {
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

    public static void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }

}
