package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class Sphere implements Primitive {

    private int radius;
    private Point3D center;
    private MeshView meshView;
    /**
     *
     * @param radius positive integer
     * @param center Point3D
     */
    Sphere(int radius, Point3D center) {
        this.radius = radius;
        this.center = center;

        // The magic starts here
        TriangleMesh mesh = new TriangleMesh();
        int triangles = radius * 3;
        double phimin = 0;
        double phimax = 6.28;
        double phi = phimin;
        double theta;
        double thetamin = -3.14;
        double thetamax = 2;

        for (int i = 0; i < triangles + 1; i++) {
            theta = thetamin;
            for (int j = 0; j < triangles + 1; j++) {
                Point3D p3D = new Point3D((float) (radius * Math.cos(theta) * Math.sin(phi)),
                        (float) (radius * Math.cos(theta) * Math.cos(phi)),
                        (float) (radius * Math.sin(theta)));
                mesh.getPoints().addAll((float) p3D.getX(),
                        (float) p3D.getY(),
                        (float) p3D.getZ());
                theta += (thetamax - thetamin) / triangles;
            }
            phi += (phimax - phimin) / triangles;
        }
        mesh.getTexCoords().addAll(0, 0);
        for (int i = 0; i < triangles; i++) {
            int multiplier = (i * triangles) + i;
            for (int j = multiplier; j < triangles + multiplier; j++) {
                mesh.getFaces().addAll(j, 0, j + 1, 0, j + triangles + 1, 0);
                mesh.getFaces().addAll(j + triangles + 1, 0, j + 1, 0, j + triangles + 2, 0);
            }
            for (int j = triangles + multiplier; j > multiplier; j--) {
                mesh.getFaces().addAll(j, 0, j - 1, 0, j + triangles + 1, 0);
                mesh.getFaces().addAll(j - 1, 0, j + triangles, 0, j + triangles + 1, 0);
            }
        }

        meshView = new MeshView(mesh);
        meshView.setTranslateX(center.getX());
        meshView.setTranslateY(center.getY());
        meshView.setTranslateZ(center.getZ());
    }

    @Override
    public void setMeshView(MeshView meshView) {
        this.meshView = meshView;
    }

    @Override
    public MeshView getMeshView() {
        return meshView;
    }

    public int getRadius() {
        return radius;
    }

    /**
     * setRadius ONLY changes the attribute
     * @param radius positive integer
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
        meshView.setTranslateX(center.getX());
        meshView.setTranslateY(center.getY());
        meshView.setTranslateZ(center.getZ());
    }
}
