package dwarf.gfx;

import java.util.Objects;

import dwarf.Collidable;
import dwarf.GameObject;
import dwarf.util.Point2D;

public class Line extends dwarf.Collidable implements GameObject, Colours {

    /**
     * The start point of the <code>Line</code>.
     */
    private Point2D pointA;
    /**
     * The end point of the <code>Line</code>.
     */
    private Point2D pointB;

    /**
     * the colour of the line.
     */
    private Colour colour;

    private boolean update;
    private boolean render;

    /**
     * Default constructor.
     */
    public Line() {
        super();
    }

    public Line(Point2D pointA, Point2D pointB, Colour colour) {
        super();

        this.pointA = pointA;
        this.pointB = pointB;
        this.colour = colour;

        this.update = true;
        this.render = true;

        // --
        Point2D tempA = pointA;
        Point2D tempB = pointA;
        Point2D tempC = pointB;
        Point2D tempD = pointB;

        tempA.translate(1);
        tempB.translate(-1);
        tempC.translate(1);
        tempD.translate(-1);
        // --

        super.setVertices(new Point2D[]{tempA, tempB, tempC, tempD});
    }

    public Line(Line line) {
        super(line);

        this.pointA = line.getPointA();
        this.pointB = line.getPointB();
    }

    /**
     * Create a new line based on two points.
     *
     * @param x1 The x coordinate of the start point
     * @param y1 The y coordinate of the start point
     * @param x2 The x coordinate of the end point
     * @param y2 The y coordinate of the end point
     * @param colour the colour of the <code>Line</code>
     */
    public Line(float x1, float y1, float x2, float y2, Colour colour) {
        this(new Point2D(x1, y1), new Point2D(x2, y2), colour);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        if (getRender()) {
            dwarf.gfx.draw.line(pointA, pointB, colour);
        }
    }

    /**
     * Returns a string representation of the object.
     * <p>
     * In general, the toString method returns a string that "textually
     * represents" this object. The result should be a concise but informative
     * representation that is easy for a person to read. It is recommended that
     * all subclasses override this method.</p>
     *
     * @return a textually representation of this object
     */
    @Override
    public String toString() {
        return "Line{" + "pointA:" + pointA + ", pointB:" + pointB + ", colour:" + colour + "}";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(pointA);
        hash = 29 * hash + Objects.hashCode(pointB);
        hash = 29 * hash + Objects.hashCode(colour);
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @param obj the <code>Object</code> to be tested
     * @see java.lang.Object#equals(java.lang.Object)
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Line other = (Line) obj;

        if (!Objects.equals(this.pointA, other.pointA)) {
            return false;
        } else if (!Objects.equals(this.pointB, other.pointB)) {
            return false;
        } else if (!Objects.equals(this.colour, other.colour)) {
            return false;
        }

        return true;
    }

    public Point2D getPointA() {
        return this.pointA;
    }

    public void setPointA(Point2D pointA) {
        this.pointA = pointA;
    }

    public Point2D getPointB() {
        return this.pointB;
    }

    public void setPointB(Point2D pointB) {
        this.pointB = pointB;
    }

    @Override
    @Deprecated
    public float getAverageWidth() {
        return super.getAverageWidth();
    }

    @Override
    @Deprecated
    public float getAverageHeight() {
        return super.getAverageHeight();
    }

    @Override
    @Deprecated
    public int getNumVertices() {
        return 2;
    }

    @Override
    @Deprecated
    public Point2D getCenterY() {
        return super.getCenterY();
    }

    @Override
    @Deprecated
    public Point2D getCenterX() {
        return super.getCenterX();
    }

    @Override
    @Deprecated
    public Point2D getCenter() {
        return super.getCenter();
    }

    @Override
    @Deprecated
    public void gotoPos(double xPos, double yPos, float speed) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void gotoPos(double xPos, double yPos) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void gotoPos(Point2D destination) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void gotoPos(Point2D destination, float speed) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void setPosition(double xPos, double yPos) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void setPosition(Point2D position) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void translateY(double deltaY) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void translateX(double deltaX) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void translate(Point2D delta) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void translate(double deltaX, double deltaY) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void setVertices(double[] xPoints, double[] yPoints) {
        super.setVertices(xPoints, yPoints);
    }

    @Override
    @Deprecated
    public void setVertices(java.awt.Polygon p) {
        super.setVertices(p);
    }

    @Override
    @Deprecated
    public void setVertices(Point2D[] vertices) {
        super.setVertices(vertices);
    }

    @Override
    @Deprecated
    public void set(Collidable coll) {
        super.set(coll);
    }

    @Override
    @Deprecated
    public void addPoints(Point2D[] points) {
        super.addPoints(points);
    }

    @Override
    @Deprecated
    public void addPoint(double xPos, double yPos) {
        super.addPoint(xPos, yPos);
    }

    @Override
    @Deprecated
    public void addPoint(Point2D point) {
        super.addPoint(point);
    }

    public Colour getColour() {
        return this.colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public boolean getUpdate() {
        return this.update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean getRender() {
        return this.render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public dwarf.util.Line toLine() {
        return new dwarf.util.Line(pointA, pointB);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        return new Line(this);
    }
}
