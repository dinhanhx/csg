package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.MeshView;

import java.util.ArrayList;

public class Parallelepiped implements Primitive{
    private ArrayList<Point3D> vertices;

    /**
     *
     * @param vertices have 4 elements: basePoint, 3 vertices
     */
    public Parallelepiped(ArrayList<Point3D> vertices) {
        this.vertices = vertices;
    }

    @Override
    public void setMeshView(MeshView meshView) {

    }

    @Override
    public MeshView getMeshView() {
        return null;
    }

    public ArrayList<Point3D> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Point3D> vertices) {
        this.vertices = vertices;
    }
}
