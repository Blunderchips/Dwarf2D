package dwarf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides an interface to the user's file system.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public interface fileSystem {

    /**
     * Recursively creates a directory.
     *
     * @param path - The directory to create + path
     * @throws DwarfException if not successful
     * @return true if the directory was created
     */
    public static boolean createDirectory(String path) throws dwarf.DwarfException {
        try {
            File f = new File(path);
            f.mkdirs();
            f.createNewFile();
            return true;
        } catch (IOException ioe) {
            throw new dwarf.DwarfException(ioe);
        }
    }

    /**
     * Check whether a file or directory exists.
     *
     * @param path - The path to a potential file or directory.
     * @return true if there is a file or directory with the specified name.
     * False otherwise.
     */
    public static boolean exists(String path) {
        return new File(path).exists();
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
     * @param path public static long getSize(String fileName
     * @return The size in bytes of the file
     */
    public static long getSize(String path) {
        return new File(path).getTotalSpace();
    }

    /**
     * Gets the last modification time of a file.
     *
     * @param path public static long getSize(String fileName
     * @return The size in bytes of the file
     */
    public static long getLastModified(String path) {
        return new File(path).lastModified();
    }

    /**
     * Removes a file or empty directory.
     *
     * @param path public static long getSize(String fileName
     * @return <code>true</code> if and only if the file or directory is
     * successfully deleted; <code>false</code> otherwise
     */
    public static boolean remove(String path) {
        return new File(path).delete();
    }

    /**
     * Check whether something is a directory.
     *
     * @param path The path to a potential directory.
     * @return True if there is a directory with the specified name. False
     * otherwise.
     */
    public static boolean isDirectory(String path) {
        return new File(path).isDirectory();
    }

    /**
     * Check whether something is a file.
     *
     * @param path The path to a potential directory.
     * @return True if there is a file with the specified name. False otherwise.
     */
    public static boolean isFile(String path) {
        return new File(path).isFile();
    }

    /**
     * Recursively creates a directory.
     *
     * @param path The path to a potential directory.
     * @return True if the directory was created, false if not.
     */
    public static boolean mkdir(String path) {
        return new File(path).mkdir();
    }

    @SuppressWarnings("unchecked")
    /**
     * reads in the content of a file
     *
     * @throws DwarfException if not successful
     * @param the location of the file + extention
     */
    public static String[] loadFile(String location) throws dwarf.DwarfException {
        try {
            ArrayList<String> temp = new ArrayList<>();
            Scanner sc = new Scanner(new FileReader(location));

            while (sc.hasNextLine()) {
                temp.add(sc.nextLine());
            }

            String output[] = new String[temp.size()];

            for (int i = 0; i < output.length; i++) {
                output[i] = temp.get(i);
            }

            return output;
        } catch (FileNotFoundException notFoundException) {
            throw new dwarf.DwarfException(notFoundException);
        }
    }
}
