package dwarf;

import dwarf.util.Vector2;
import dwarf.util.Vector3;

/**
 * Provides an interface to handle all random numbers and events.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Math#random()
 */
public interface random {

    public static int interger() {
        return Math.abs((int) (Math.random() * 100) - 100);
    }

    /**
     * @param minimum Minimum value. Must be smaller than maximum.
     * @param maximum Maximum value. Must be greater than minimum.
     * @return Integer between min and max.
     */
    public static int interger(int maximum, int minimum) {
        return minimum + (int) (Math.random() * maximum);
    }

    public static int interger(int maximum) {
        return (int) (Math.random() * maximum);
    }

    /**
     * @return returns a random boolean.
     */
    public static boolean bool() {
        return (random.interger() % 2) == 0;
    }

    public static boolean bool(int percent) {
        return interger() <= percent;
    }

    public static boolean chance(int chance) {
        for (int i = 0; i < chance; i++) {
            if (random.bool() == false) {
                return false;
            }
        }
        return true;
    }

    public static Vector2 vec2() {
        return new Vector2(
                random.interger(),
                random.interger()
        );
    }

    public static Vector2 vec2(int maximum) {
        return new Vector2(
                random.interger(maximum),
                random.interger(maximum)
        );
    }

    public static Vector2 vec2(int maximum, int minimum) {
        return new Vector2(
                random.interger(minimum, maximum),
                random.interger(minimum, maximum)
        );
    }

    public static Vector3 vec3() {
        return new Vector3(
                random.interger(),
                random.interger(),
                random.interger()
        );
    }

    public static Vector3 vec3(int maximum) {
        return new Vector3(
                random.interger(maximum),
                random.interger(maximum),
                random.interger(maximum)
        );
    }

    public static Vector3 vec3(int maximum, int minimum) {
        return new Vector3(
                random.interger(minimum, maximum),
                random.interger(minimum, maximum),
                random.interger(minimum, maximum)
        );
    }

    public static Object elementOfArray(Object[] array) {
        return array[interger(array.length - 1)];
    }
}
