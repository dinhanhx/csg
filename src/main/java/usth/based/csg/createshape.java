package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;


public class createshape extends TriangleMesh {

    public createshape(float radius, int triangles, float initx, float inity, float initz) {

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
                        (float) (radius * Math.cos(theta) * Math.cos(phi)), (float) (radius * Math.sin(theta)));
                this.getPoints().addAll(new Float(p3D.getX()) + initx, new Float(p3D.getY())+inity, new Float(p3D.getZ())+initz);
                theta += (thetamax - thetamin) / triangles;
            }
            phi += (phimax - phimin) / triangles;
        }
        this.getTexCoords().addAll(0, 0);
        for (int i = 0; i < triangles; i++) {
            int multiplier = (i * triangles) + i;
            for (int j = multiplier; j < triangles + multiplier; j++) {
                this.getFaces().addAll(j, 0, j + 1, 0, j + triangles + 1, 0);
                this.getFaces().addAll(j + triangles + 1, 0, j + 1, 0, j + triangles + 2, 0);
            }
            for (int j = triangles + multiplier; j > multiplier; j--) {
                this.getFaces().addAll(j, 0, j - 1, 0, j + triangles + 1, 0);
                this.getFaces().addAll(j - 1, 0, j + triangles, 0, j + triangles + 1, 0);
            }
        }
    }
}