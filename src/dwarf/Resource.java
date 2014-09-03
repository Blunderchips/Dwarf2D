package dwarf;

import java.util.Objects;
import java.io.InputStream;

/**
 * Helper class which represents a resource (res) within the project folders or
 * jar file.
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see java.lang.Object
 * @see java.lang.Cloneable
 */
public class Resource extends java.lang.Object implements Cloneable {

    private String path;

    /**
     * Default constructor.
     */
    public Resource() {
        super();
        this.path = null;
    }

    /**
     * Constructs a new resource representation from the file in the given path.
     *
     * @param path the path of the resource file.
     */
    public Resource(String path) {
        super();
        this.path = path;
    }

    /**
     * Constructs a new resource representation from the <code>Resource</code>
     * given.
     *
     * @param r the given <code>Resource</code>.
     */
    public Resource(Resource r) {
        super();
        this.path = r.getPath();
    }

    /**
     * Returns the input stream from the resource data.
     *
     * @return the input stream from the resource data
     */
    public InputStream getInputStream() {
        Class<?> runtimeClass = getClass();
        ClassLoader classLoader = runtimeClass.getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(getPath());

        return stream;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Resource(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(getPath());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Resource other = (Resource) obj;

        if (!Objects.equals(this.getPath(), other.getPath())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Resource=[" + "path: " + getPath() + "]";
    }

    public Resource get() {
        return this;
    }

    public void set(String path) {
        this.path = path;
    }

    public void set(Resource r) {
        this.path = r.getPath();
    }
}
