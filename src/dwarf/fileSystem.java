package dwarf;

import dwarf.engine.core.Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Provides an interface to the user's file system.
 *
 * @author sid_th3_sl0th
 */
public final class fileSystem {

    public fileSystem() {
        // Prevents instantiation of this class.
        throw new Error(
                "you can not instantiate this class.");
    }

    /**
     * Recursively creates a directory.
     *
     * @param fileName - The directory to create + path.
     * @return True if the directory was created, false if not.
     */
    public static boolean createDirectory(String fileName) {
        try {
            File f = new File(fileName);
            f.mkdirs();
            f.createNewFile();
            return true;
        } catch (IOException ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * Check whether a file or directory exists.
     *
     * @param filename - The path to a potential file or directory.
     * @return True if there is a file or directory with the specified name.
     * False otherwise.
     */
    public static boolean exists(String filename) {
        return new File(filename).exists();
    }

    /**
     * Returns a table with the names of files and subdirectories in the
     * specified path. The table is not sorted in any way; the order is
     * undefined.
     *
     * @param dir The directory.
     * @return A String array with the names of all files and subdirectories as
     * strings.
     */
    public static String[] getDirectoryNames(String dir) {
        File f = new File(dir);
        File[] listOfFiles = f.listFiles();

        String[] result = new String[listOfFiles.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = listOfFiles[i].getName();
        }

        return result;
    }

    /**
     * Gets the size in bytes of a file.
     *
     * @param fileName public static long getSize(String fileName
     * @return The size in bytes of the file
     */
    public static long getSize(String fileName) {
        return new File(fileName).getTotalSpace();
    }

    /**
     * Gets the last modification time of a file.
     *
     * @param fileName public static long getSize(String fileName
     * @return The size in bytes of the file
     */
    public static long getLastModified(String fileName) {
        return new File(fileName).lastModified();
    }

    /**
     * Removes a file or empty directory.
     *
     * @param fileName public static long getSize(String fileName
     * @return <code>true</code> if and only if the file or directory is
     * successfully deleted; <code>false</code> otherwise
     */
    public static boolean remove(String fileName) {
        return new File(fileName).delete();
    }

    /**
     * Check whether something is a directory.
     *
     * @param fileName The path to a potential directory.
     * @return True if there is a directory with the specified name. False
     * otherwise.
     */
    public static boolean isDirectory(String fileName) {
        return new File(fileName).isDirectory();
    }

    /**
     * Check whether something is a file.
     *
     * @param fileName The path to a potential directory.
     * @return True if there is a file with the specified name. False otherwise.
     */
    public static boolean isFile(String fileName) {
        return new File(fileName).isFile();
    }

    /**
     * Recursively creates a directory.
     *
     * @param fileName The path to a potential directory.
     * @return True if the directory was created, false if not.
     */
    public static boolean mkdir(String fileName) {
        return new File(fileName).mkdir();
    }

    @SuppressWarnings("unchecked")
    /**
     * reads in the content of a file
     *
     * @param the location of the file + extention
     */
    public static String[] loadFile(String location) {
        try {
            ArrayList temp = new ArrayList<String>();
            Scanner sc = new Scanner(new FileReader(location));

            while (sc.hasNextLine()) {
                boolean add = temp.add(sc.nextLine());
            }

            String output[] = new String[temp.size()];

            for (int i = 0; i < output.length; i++) {
                output[i] = (String) temp.get(i);
            }

            return output;
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            Game.close(1);
        }
        return null;
    }
}
