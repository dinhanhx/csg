package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.TriangleMesh;

public class Sphere implements Primitive {
    private int radius;
    private Point3D center;
    private TriangleMesh triangleMesh;

    /**
     *
     * @param radius positive integer
     * @param center Point3D
     */
    Sphere(int radius, Point3D center) {
        this.radius = radius;
        this.center = center;

        // The magic starts here
        buildTriangleMesh();
    }

    private void buildTriangleMesh() {
        this.triangleMesh = new TriangleMesh();
        int triangles = this.radius * 3;
        double phimin = 0;
        double phimax = 6.28;
        double phi = phimin;
        double theta;
        double thetamin = -3.14;
        double thetamax = 2;

        for (int i = 0; i < triangles + 1; i++) {
            theta = thetamin;
            for (int j = 0; j < triangles + 1; j++) {
                Point3D p3D = new Point3D((float) (this.radius * Math.cos(theta) * Math.sin(phi)),
                        (float) (this.radius * Math.cos(theta) * Math.cos(phi)),
                        (float) (this.radius * Math.sin(theta)));
                triangleMesh.getPoints().addAll((float) ((float) p3D.getX() + this.center.getX()),
                        (float) ((float) p3D.getY() + this.center.getY()),
                        (float) ((float) p3D.getZ() + this.center.getZ()));
                theta += (thetamax - thetamin) / triangles;
            }
            phi += (phimax - phimin) / triangles;
        }
        triangleMesh.getTexCoords().addAll(0, 0);
        for (int i = 0; i < triangles; i++) {
            int multiplier = (i * triangles) + i;
            for (int j = multiplier; j < triangles + multiplier; j++) {
                triangleMesh.getFaces().addAll(j, 0, j + 1, 0, j + triangles + 1, 0);
                triangleMesh.getFaces().addAll(j + triangles + 1, 0, j + 1, 0, j + triangles + 2, 0);
            }
            for (int j = triangles + multiplier; j > multiplier; j--) {
                triangleMesh.getFaces().addAll(j, 0, j - 1, 0, j + triangles + 1, 0);
                triangleMesh.getFaces().addAll(j - 1, 0, j + triangles, 0, j + triangles + 1, 0);
            }
        }
    }

    @Override
    public TriangleMesh getTriangleMesh() {
        return this.triangleMesh;
    }

    public int getRadius() {
        return radius;
    }

    /**
     * @param radius positive integer
     */
    public void setRadius(int radius) {
        this.radius = radius;
        buildTriangleMesh();
    }

    public Point3D getCenter() {
        return center;
    }

    /**
     * setCenter ONLY changes the attribute
     * @param center Point3D
     */
    public void setCenter(Point3D center) {
        this.center = center;
    }
}
