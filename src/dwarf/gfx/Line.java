package dwarf.gfx;

import dwarf.Collidable;
import dwarf.util.Vector2;
import java.util.Objects;

public class Line extends Polygon {

    private Vector2 pointA;
    private Vector2 pointB;

    /**
     * Default constructor.
     */
    public Line() {
        super();
    }

    public Line(Vector2 pointA, Vector2 pointB, Colour colour) {
        super();

        this.pointA = pointA;
        this.pointB = pointB;

        super.setColour(colour);

        // --
        Vector2 tempA = pointA;
        Vector2 tempB = pointA;
        Vector2 tempC = pointB;
        Vector2 tempD = pointB;

        tempA.add(1);
        tempB.sub(1);
        tempC.add(1);
        tempD.sub(1);
        // --

        super.setVertices(new Vector2[]{tempA, tempB, tempC, tempD});
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
            dwarf.gfx.draw.line(pointA, pointB, getColour());
        }
    }

    @Override
    public String toString() {
        return "Line{" + "pointA:" + pointA + ", pointB:" + pointB + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(getPointA());
        hash = 29 * hash + Objects.hashCode(getPointB());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Line line = (Line) obj;

        if (!Objects.equals(this.getPointA(), line.getPointA())) {
            return false;
        } else if (!Objects.equals(this.getPointB(), line.getPointB())) {
            return false;
        }

        return true;
    }

    public Vector2 getPointA() {
        return this.pointA;
    }

    public void setPointA(Vector2 pointA) {
        this.pointA = pointA;
    }

    public Vector2 getPointB() {
        return this.pointB;
    }

    public void setPointB(Vector2 pointB) {
        this.pointB = pointB;
    }

    public Vector2 midPoint() {
        double x = (this.pointA.getX() + this.pointB.getX()) / 2;
        double y = (this.pointA.getY() + this.pointB.getY()) / 2;

        return new Vector2(x, y);
    }

    public double gradient() {
        return (this.pointA.getY() - this.pointB.getY()) / (this.pointA.getX() - this.pointB.getX());
    }

    public double length() {
        return Math.sqrt(
                java.lang.Math.pow((this.pointA.getX() - this.pointB.getX()), 2)
                + java.lang.Math.pow((this.pointA.getY() - this.pointB.getY()), 2)
        );
    }

    public double lengthSq() {
        return java.lang.Math.pow((this.pointA.getX() - this.pointB.getX()), 2)
                + java.lang.Math.pow((this.pointA.getY() - this.pointB.getY()), 2);
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
    public void set(Vector2 position, int mode, Colour colour) {
        super.set(position, mode, colour);
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
    public Vector2 getCenterY() {
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
    public Vector2 getCenterX() {
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
    public Vector2 getCenter() {
        return this.midPoint();
    }

    @Override
    @Deprecated
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    @Deprecated
    public void set(Polygon polygon) {
        super.set(polygon);
    }

    @Override
    @Deprecated
    public void set(Vector2[] vertices, Vector2 position, int mode, Colour colour) {
        super.set(vertices, position, mode, colour);
    }

    @Override
    @Deprecated
    public String getType() {
        return super.getType();
    }

    @Override
    @Deprecated
    public void setMode(int mode) {
        super.setMode(mode);
    }

    @Override
    public boolean isStroke() {
        return super.isStroke();
    }

    @Override
    @Deprecated
    public boolean isFill() {
        return super.isFill();
    }

    @Override
    @Deprecated
    public void gotoPos(double xPos, double yPos, float speed) {
        super.gotoPos(xPos, yPos, speed);
    }

    @Override
    @Deprecated
    public void gotoPos(double xPos, double yPos) {
        super.gotoPos(xPos, yPos);
    }

    @Override
    @Deprecated
    public void gotoPos(Vector2 destination) {
        super.gotoPos(destination);
    }

    @Override
    @Deprecated
    public void gotoPos(Vector2 destination, float speed) {
        super.gotoPos(destination, speed);
    }

    @Override
    @Deprecated
    public void setPosition(double xPos, double yPos) {
        super.setPosition(xPos, yPos);
    }

    @Override
    @Deprecated
    public void setPosition(Vector2 position) {
        super.setPosition(position);
    }

    @Override
    @Deprecated
    public void translateY(double deltaY) {
        super.translateY(deltaY);
    }

    @Override
    @Deprecated
    public void translateX(double deltaX) {
        super.translateX(deltaX);
    }

    @Override
    @Deprecated
    public void translate(Vector2 delta) {
        super.translate(delta);
    }

    @Override
    @Deprecated
    public void translate(double deltaX, double deltaY) {
        super.translate(deltaX, deltaY);
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
    public void setVertices(Vector2[] vertices) {
        super.setVertices(vertices);
    }

    @Override
    @Deprecated
    public void set(Collidable coll) {
        super.set(coll);
    }

    @Override
    @Deprecated
    public void addPoints(Vector2[] points) {
        super.addPoints(points);
    }

    @Override
    @Deprecated
    public void addPoint(double xPos, double yPos) {
        super.addPoint(xPos, yPos);
    }

    @Override
    @Deprecated
    public void addPoint(Vector2 point) {
        super.addPoint(point);
    }
}
