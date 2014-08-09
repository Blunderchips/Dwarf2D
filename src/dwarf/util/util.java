package dwarf.util;

/**
 * general utilities
 *
 * @author Matthew 'siD' Van der Bijl
 */
import dwarf.Game;
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

    /**
     * Flip an array of pixels vertically
     *
     * @param imgPixels the pixels contained within the image
     * @param imgw the width of the image
     * @param imgh the hieght of the image
     * 
     * @return int[] the pixel array fliped
     */
    public static int[] flipPixels(int[] imgPixels, int imgw, int imgh) {
        int[] flippedPixels = null;
        if (imgPixels != null) {
            flippedPixels = new int[imgw * imgh];
            for (int y = 0; y < imgh; y++) {
                for (int x = 0; x < imgw; x++) {
                    flippedPixels[ ((imgh - y - 1) * imgw) + x] = imgPixels[ (y * imgw) + x];
                }
            }
        }
        return flippedPixels;
    }
}
