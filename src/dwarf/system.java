package dwarf;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Provides an interface to your system (sys) and other system base utilities.
 *
 * @author Matthew 'siD' Van der Bijl
 */
public final class system {

    /**
     * you can not instantiate this class.
     */
    public system() throws UnsupportedOperationException {
        // Prevents instantiation of this class.
        throw new UnsupportedOperationException(
                "you can not instantiate this class.");
    }

    /**
     * @return Operating system version
     */
    public static String getOSVersion() {
        return System.getProperty("os.version");
    }

    /**
     * @return Operating system name
     */
    public static String getOSName() {
        return System.getProperty("os.name");
    }

    /**
     * @return Operating system architecture
     */
    public static String getOSArch() {
        return System.getProperty("os.arch");
    }

    /**
     * @return JRE version number
     */
    public static String getJavaVersion() {
        return System.getProperty("java.version");
    }

    /**
     * @return JRE vendor URL
     */
    public static String getJavaVenderUrl() {
        return System.getProperty("java.vendor.url");
    }

    /**
     * @return User account name
     */
    public static String getUserName() {
        return System.getProperty("user.name");
    }

    /**
     * @return User working directory
     */
    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    /**
     * @return Sequence used by operating system to separate lines in text
     * files.
     */
    public static String getLineSeparator() {
        return System.getProperty("line.separator");
    }

    /**
     * @return JRE vendor name
     */
    public static String getJavaVender() {
        return System.getProperty("java.vendor");
    }

    /**
     * @return Installation directory for Java Runtime Environment (JRE).
     */
    public static String getJavaHome() {
        return System.getProperty("java.home");
    }

    /**
     * @return Path used to find directories and JAR archives containing class
     * files. Elements of the class path are separated by a platform-specific
     * character specified in the path.separator property.
     */
    public static String getJavaClassPath() {
        return System.getProperty("java.class.path");
    }

    /**
     * @return Character that separates components of a file path. This is "/"
     * on UNIX and "\" on Windows.
     */
    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }

    /**
     * Total number of processors or cores available to the JVM.
     *
     * @return Available processors (cores)
     */
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Total amount of free memory available to the JVM.
     *
     * @return Free memory (bytes)
     */
    public static long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    /**
     * Total memory currently available to the JVM.
     *
     * @return Total memory available to JVM (bytes)
     */
    public static long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    /**
     * @return The Name of JIT.
     */
    public static String getJavaCompiler() {
        return System.getProperty("java.compiler");
    }

    public static String executeCommand(String command) throws DwarfException {
        StringBuilder output = new StringBuilder();

        Process p = null;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (IOException | InterruptedException ex) {
            throw new DwarfException(ex);
        }

        return output.toString();
    }

    /**
     * @return the version of the Lightweight Java Game Library (LWJGL) in use.
     */
    public static String getLWJGLVersion() {
        return org.lwjgl.Sys.getVersion();
    }
}
