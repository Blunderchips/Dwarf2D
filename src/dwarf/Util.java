package dwarf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Provides an interface that offers general utilities to the user.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public class Util {

    /**
     * you can not instantiate this class.
     */
    public Util() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

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
                    flippedPixels[((imgh - y - 1) * imgw) + x] = imgPixels[(y * imgw) + x];
                }
            }
        }
        return flippedPixels;
    }

    /**
     * Read the file to a String
     *
     * @param path the path to the file
     * @return the file as a String
     */
    public static String readFileAsString(String path) throws DwarfException {
        StringBuilder source = new StringBuilder();
        InputStream in = GLSL.class.getResourceAsStream(path);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            try {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    source.append(line).append('\n');
                }
            } catch (Exception ex) {
                throw new DwarfException(ex);
            } finally {
                try {
                    reader.close();
                } catch (Exception ex) {
                    throw new DwarfException(ex);
                }
            }
        } catch (UnsupportedEncodingException uee) {
            throw new DwarfException(uee);
        } finally {
            try {
                in.close();
            } catch (IOException ioe) {
                throw new DwarfException(ioe);
            }
        }
        
        return source.toString();
    }
}
