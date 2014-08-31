package dwarf;

import java.util.ArrayList;

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

    public static boolean hasChildren(Parent parent) {
        return !parent.getChildren().isEmpty();
    }
}
