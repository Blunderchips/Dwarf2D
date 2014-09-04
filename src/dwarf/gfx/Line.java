package dwarf.gfx;

import dwarf.Collidable;
import dwarf.GameObject;
import dwarf.util.Point2D;
import java.util.Objects;

public class Line extends dwarf.Collidable implements GameObject, Colours {

    private Point2D pointA;
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

    @Override
    public void update() {
    }

    @Override
    public void render() {
        if (getRender()) {
            dwarf.gfx.draw.line(pointA, pointB, colour);
        }
    }

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

    public Point2D midPoint() {
        return Point2D.midPoint(pointA, pointB);
    }

    public double gradient() {
        return Point2D.gradient(pointA, pointB);
    }

    public double distance() {
        return Point2D.distance(pointA, pointB);
    }

    public double distanceSq() {
        return Point2D.distanceSq(pointA, pointB);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        return new Line(this);
    }

    public boolean isPerpendicular(Line l) {
        return this.gradient() * l.gradient() == -1;
    }

    public boolean isParallel(Line l) {
        return this.gradient() == l.gradient();
    }

    public double getAngleBetween(Line l) {
        double slopeA = (this.getPointA().getY() - this.getPointA().getY()) / (this.getPointA().getX() - this.getPointB().getX());
        double slopeB = (l.getPointA().getY() - l.getPointA().getY()) / (l.getPointA().getX() - l.getPointB().getX());

        return Math.atan((slopeA - slopeB) / (1 - (slopeA * slopeB)));
    }

    @Override
    @Deprecated
    public float getAverageWidth() {
        return (float) this.midPoint().getX();
    }

    @Override
    @Deprecated
    public float getAverageHeight() {
        return (float) this.midPoint().getY();
    }

    @Override
    @Deprecated
    public int getNumVertices() {
        return 2;
    }

    /**
     * this method not supported.
     *
     * @see dwarf.gfx.Line#midPoint()
     * @deprecated method not supported
     * @return the midpoint of the line
     */
    @Override
    @Deprecated
    public Point2D getCenterY() {
        return this.midPoint();
    }

    /**
     * this method not supported.
     *
     * @see dwarf.gfx.Line#midPoint()
     * @deprecated method not supported
     * @return the midpoint of the line
     */
    @Override
    @Deprecated
    public Point2D getCenterX() {
        return this.midPoint();
    }

    /**
     * this method not supported.
     *
     * @see dwarf.gfx.Line#midPoint()
     * @deprecated method not supported
     * @return the midpoint of the line
     */
    @Override
    @Deprecated
    public Point2D getCenter() {
        return this.midPoint();
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
}
