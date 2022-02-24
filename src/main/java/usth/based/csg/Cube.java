package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.TriangleMesh;

public class Cube implements Primitive{
    private int sideLength;
    private Point3D center;
    private final TriangleMesh triangleMesh;

    /**
     *
     * @param sideLength positive integer
     * @param center Point3D
     */
    public Cube(int sideLength, Point3D center) {
        this.sideLength = sideLength;
        this.center = center;

        // TODO un-null triangleMesh
        this.triangleMesh = null;
    }

    @Override
    public TriangleMesh getTriangleMesh() {
        return this.triangleMesh;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }
}
