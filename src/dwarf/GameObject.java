package dwarf;

import dwarf.util.Vector2;
import java.util.ArrayList;
import java.util.Objects;

/**
 * basic game object
 *
 * @author sid_th3_sl0th
 * @see java.lang.Object
 * @see dwarf.Collidable
 */
public abstract class GameObject extends Collidable {

    private ArrayList<GameObject> children;

    public GameObject(Vector2 position) {
        super(position);
        this.init();
    }

    public GameObject(GameObject obj) {
        super(obj.getPosition());
        
        // --
        this.setChildren(obj.getChildren());
        this.setPoints(obj.getPoints());
        this.setPosition(obj.getPosition());
        // --
        
        this.init();
    }

    private void init() {
        this.children = new ArrayList<>();
    }

    /**
     * Callback function used to update the state of the game every frame.
     */
    public abstract void update();

    /**
     * Callback function used to draw on the screen every frame.
     */
    public abstract void draw();

    public ArrayList<GameObject> getChildren() {
        return this.children;
    }

    public void setChildren(ArrayList children) {
        this.children = children;
    }

    public void updateChildren() {
        for (GameObject child : getChildren()) {
            child.update();
        }
    }

    public void renderChildren() {
        for (GameObject child : getChildren()) {
            child.draw();
        }
    }

    /**
     * Class Object is the root of the class hierarchy. Every class has Object
     * as a superclass. All objects, including arrays, implement the methods of
     * this class.
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(getChildren());
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else if (!super.equals(obj)) {
            return false;
        }

        final GameObject other = (GameObject) obj;

        return Objects.equals(this.getChildren(), other.getChildren());
    }

    @Override
    public String toString() {
        return "GameObject = {"
                + "children: " + getChildren() + ", "
                + "super:" + super.toString()
                + "}";
    }
//    @Override
//    public boolean intersects(Collidable coll) {
//        if (super.intersects(this)) {
//            return true;
//        } else {
//            for (GameObject child : children) {
//                if (child.intersects(coll)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean isClickedOn(int button) {
//        if (super.isClickedOn(button)) {
//            return true;
//        } else {
//            for (GameObject child : children) {
//                if (child.isClickedOn(button)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    
//    @Override
//    public boolean isClickedOn() {
//        if (super.isClickedOn()) {
//            return true;
//        } else {
//            for (GameObject child : children) {
//                if (child.isClickedOn()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
