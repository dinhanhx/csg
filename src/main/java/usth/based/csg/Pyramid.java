package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.MeshView;

public class Pyramid implements Primitive{
    private int basePointToVertexDistance;
    private Point3D basePoint;

    public Pyramid(int basePointToVertexDistance, Point3D basePoint) {
        this.basePointToVertexDistance = basePointToVertexDistance;
        this.basePoint = basePoint;
    }

    @Override
    public void setMeshView(MeshView meshView) {

    }

    @Override
    public MeshView getMeshView() {
        return null;
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
