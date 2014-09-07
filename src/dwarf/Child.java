package dwarf;

import java.util.ArrayList;

/**
 * Definition of anything that can have "parent".
 * 
 * @author Matthew 'siD' Van der Bijl
 * 
 * @see dwarf.Parent
 */
public interface Child {

    public abstract Parent getParent();

    public abstract void setParent(Parent parent);

    public static ArrayList<Child> getSiblings(Child child) {
        return child.getParent().getChildren();
    }

    public static boolean hasSiblings(Child child) {
        return child.getParent().getChildren().size() > 1;
    }
    
   /**
    * returns true if the inputed <code>Child</code> has a <code>Parent</code> otherwise false.
    *
    * @param child the <code>Child</code> to be tested
    * @return if the child a has parent or not
    */
    public static boolean hasParent(Child child) {
        try {
            child.getParent().getChildren();
            return true;
        } catch (NullPointerException npe) {
            return false;
        }
    }
}
