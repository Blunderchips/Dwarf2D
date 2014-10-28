package dwarf;

import java.util.ArrayList;

/**
 * Definition of anything that can have "children".
 *
 * @author Matthew 'siD' Van der Bijl
 *
 * @see dwarf.Child
 */
public interface Parent {

    public abstract ArrayList<Child> getChildren();

    public abstract void setChildren(ArrayList<Child> children);
}
