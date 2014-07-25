package dwarf.util;

/**
 * general utilities
 *
 * @author sid_th3_sl0th
 */
import dwarf.engine.core.Game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class util {

    public util() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    public static String[] explode(String split, String input) {
        return input.split(split);
    }

    public static String[] RemoveEmptyStrings(String[] strings) {
        ArrayList<String> result = new ArrayList<String>();

        for (String string : strings) {
            if (!string.equals("")) {
                result.add(string);
            }
        }

        String[] resultArray = new String[result.size()];
        result.toArray(resultArray);

        return resultArray;
    }

    public static Object[] reverseArray(Object[] arr) {
        List<Object> list = Arrays.asList(arr);
        Collections.reverse(list);

        return list.toArray();
    }

    public static void debug(String level, String msg) {
        switch (level) {
            case "INFO":
                if (Game.debug) {
                    System.err.println("[INFO] " + msg);
                }
                break;
            case "WARNING":
                System.err.println("[WARNING] " + msg);
                break;
            case "SEVERE":
                System.err.println("[SEVERE] " + msg);
                Game.close(42);
                break;
            default:
                break;
        }
    }

    public static final byte[] intToByteArray(int value) {
        return new byte[]{(byte) (value >>> 24), (byte) (value >>> 16),
            (byte) (value >>> 8), (byte) value};
    }
}
