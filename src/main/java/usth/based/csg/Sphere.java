package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.MeshView;

public class Sphere implements Primitive {

    private int radius;
    private Point3D center;

    Sphere(int radius, Point3D center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void setMeshView(MeshView meshView) {

    }

    @Override
    public MeshView getMeshView() {
        return null;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }
}
