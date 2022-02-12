package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.TriangleMesh;

import java.util.ArrayList;

public class Parallelepiped implements Primitive{
    private ArrayList<Point3D> vertices;

    /**
     *
     * @param vertices have 4 elements: basePoint, 3 vertices
     * https://en.wikipedia.org/wiki/Parallelepiped#Volume
     */
    public Parallelepiped(ArrayList<Point3D> vertices) {
        this.vertices = vertices;
    }

    @Override
    public void setTriangleMesh(TriangleMesh triangleMesh) {

    }

    @Override
    public TriangleMesh getTriangleMesh() {
        return null;
    }

    public ArrayList<Point3D> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Point3D> vertices) {
        this.vertices = vertices;
    }
}
