package dwarf;

import java.util.ArrayList;

public interface Child {

    public abstract Parent getParent();

    public abstract void setParent(Parent parent);

    public static ArrayList<Child> getSiblings(Child child) {
        return child.getParent().getChildren();
    }
}
