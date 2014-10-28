package dwarf;

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
}
