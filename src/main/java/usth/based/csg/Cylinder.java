package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.TriangleMesh;

public class Cylinder implements Primitive{
    private int radius;
    private int height;
    private Point3D basePoint;
    private final TriangleMesh triangleMesh;

    /**
     *
     * @param radius positive integer
     * @param height positive integer
     * @param basePoint Point3D
     */
    public Cylinder(int radius, int height, Point3D basePoint) {
        this.radius = radius;
        this.height = height;
        this.basePoint = basePoint;

        // TODO un-null triangleMesh
        this.triangleMesh = null;
    }

    @Override
    public TriangleMesh getTriangleMesh() {
        return this.triangleMesh;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point3D getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Point3D basePoint) {
        this.basePoint = basePoint;
    }
}
