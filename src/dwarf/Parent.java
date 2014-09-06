package dwarf;

import java.util.ArrayList;

/**
 * Definition of anything that can have children.
 * 
 * @author Matthew 'siD' Van der Bijl
 * 
 * @see dwarf.Child
 */
public interface Parent {

    public abstract ArrayList<Child> getChildren();

    public abstract void setChildren(ArrayList<Child> children);

    public static boolean addChild(Parent parent, Child child) {
        return parent.getChildren().add(child);
    }

    public static boolean removeChild(Parent parent, Child child) {
        return parent.getChildren().remove(child);
    }

    public static void clearChildren(Parent parent) {
        parent.getChildren().clear();
    }

    /**
     * returns true if the inputed <code>Parent</code> has children otherwise false.
     * 
     * @param parent the <code>Parent</code> to be tested
     * @return if the parent has children or not
     */
    public static boolean hasChildren(Parent parent) {
        return !parent.getChildren().isEmpty();
    }
}
