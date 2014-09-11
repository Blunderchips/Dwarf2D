package dwarf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides an interface that offers general utilities to the user.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public interface Util {

    public static int ASCENDING_ORDER = 0x0;
    public static int DESCENDING_ORDER = 0x1;

    public static String[] explode(String split, String input) {
        return input.split(split);
    }

    public static String[] RemoveEmptyStrings(String[] strings) {
        ArrayList<String> result = new ArrayList<>();

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

    public static byte[] intToByteArray(int value) {
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

    public static int[] sort(int[] nums, int order) throws DwarfException {
        switch (order) {
            case ASCENDING_ORDER:
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] > nums[j]) {
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
                return nums;
            case DESCENDING_ORDER:
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] < nums[j]) {
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
                return nums;
            default:
                throw new DwarfException("illegal argument");
        }
    }

    public static float[] sort(float[] nums, int order) throws DwarfException {
        switch (order) {
            case ASCENDING_ORDER:
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] > nums[j]) {
                            float temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
                return nums;
            case DESCENDING_ORDER:
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] < nums[j]) {
                            float temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
                return nums;
            default:
                throw new DwarfException("illegal argument");
        }
    }

    public static long[] sort(long[] nums, int order) throws DwarfException {
        switch (order) {
            case ASCENDING_ORDER:
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] > nums[j]) {
                            long temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
                return nums;
            case DESCENDING_ORDER:
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] < nums[j]) {
                            long temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
                return nums;
            default:
                throw new DwarfException("illegal argument");
        }
    }

    public static double[] sort(double[] nums, int order) throws DwarfException {
        switch (order) {
            case ASCENDING_ORDER:
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] > nums[j]) {
                            double temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
                return nums;
            case DESCENDING_ORDER:
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[i] < nums[j]) {
                            double temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
                return nums;
            default:
                throw new DwarfException("illegal argument");
        }
    }

    public static char[] sort(char[] chars, int order) throws DwarfException {
        switch (order) {
            case ASCENDING_ORDER:
                for (int i = 0; i < chars.length; i++) {
                    for (int j = i + 1; j < chars.length; j++) {
                        if (chars[i] > chars[j]) {
                            char temp = chars[i];
                            chars[i] = chars[j];
                            chars[j] = temp;
                        }
                    }
                }
                return chars;
            case DESCENDING_ORDER:
                for (int i = 0; i < chars.length; i++) {
                    for (int j = i + 1; j < chars.length; j++) {
                        if (chars[i] < chars[j]) {
                            char temp = chars[i];
                            chars[i] = chars[j];
                            chars[j] = temp;
                        }
                    }
                }
                return chars;
            default:
                throw new DwarfException("illegal argument");
        }
    }

    public static String[] sort(String[] strings, int order) throws DwarfException {
        switch (order) {
            case ASCENDING_ORDER:
                for (int i = 0; i < strings.length; i++) {
                    for (int j = i + 1; j < strings.length; j++) {
                        if (strings[i].compareTo(strings[j]) > 1) {
                            String temp = strings[i];
                            strings[i] = strings[j];
                            strings[j] = temp;
                        }
                    }
                }
                return strings;
            case DESCENDING_ORDER:
                for (int i = 0; i < strings.length; i++) {
                    for (int j = i + 1; j < strings.length; j++) {
                        if (strings[i].compareTo(strings[j]) > 1) {
                            String temp = strings[i];
                            strings[i] = strings[j];
                            strings[j] = temp;
                        }
                    }
                }
                return strings;
            default:
                throw new DwarfException("illegal argument");
        }
    }
}
