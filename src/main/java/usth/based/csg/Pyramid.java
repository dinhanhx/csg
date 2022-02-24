package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.TriangleMesh;

public class Pyramid implements Primitive{
    private int basePointToVertexDistance;
    private Point3D basePoint;
    private final TriangleMesh triangleMesh;

    /**
     *
     * @param basePointToVertexDistance positive integer - the radius of the circumscribed sphere
     * @param basePoint Point3D - center of Pyramid
     * https://en.wikipedia.org/wiki/Tetrahedron#Coordinates_for_a_regular_tetrahedron
     */
    public Pyramid(int basePointToVertexDistance, Point3D basePoint) {
        this.basePointToVertexDistance = basePointToVertexDistance;
        this.basePoint = basePoint;

        // TODO un-null triangleMesh
        this.triangleMesh = null;
    }

    @Override
    public TriangleMesh getTriangleMesh() {
        return this.triangleMesh;
    }

    public int getBasePointToVertexDistance() {
        return basePointToVertexDistance;
    }

    public void setBasePointToVertexDistance(int basePointToVertexDistance) {
        this.basePointToVertexDistance = basePointToVertexDistance;
    }

    public Point3D getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Point3D basePoint) {
        this.basePoint = basePoint;
    }
}
