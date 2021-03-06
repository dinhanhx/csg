package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.TriangleMesh;

public class Cube implements Primitive{
    private int sideLength;
    private Point3D center;
    private TriangleMesh triangleMesh;

    /**
     *
     * @param sideLength positive integer
     * @param center Point3D
     */
    public Cube(int sideLength, Point3D center) {
        this.sideLength = sideLength;
        this.center = center;

        // The magic starts here
        buildTriangleMesh();
    }

    private void buildTriangleMesh() {
        // TODO make this work with this.center

        // NOTE: still create mesh for degenerated box
        float hw = this.sideLength / 2f;
        float hh = this.sideLength / 2f;
        float hd = this.sideLength / 2f;
        double centerx = this.center.getX();
        double centery = this.center.getY();
        double centerz = this.center.getZ();
        float[] points = {
                -hw, -hh, -hd,
                hw, -hh, -hd,
                hw,  hh, -hd,
                -hw,  hh, -hd,
                -hw, -hh,  hd,
                hw, -hh,  hd,
                hw,  hh,  hd,
                -hw,  hh,  hd};
        for (int i = 0; i <8; i++)
        {
            points[i*3] += centerx;
            points[i*3+1] += centery;
            points[i*3+2] += centerz;
        }
        float[] texCoords = {0, 0, 1, 0, 1, 1, 0, 1};

        // Specifies hard edges.
        int faceSmoothingGroups[] = {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };

        int[] faces = {
                0, 0, 2, 2, 1, 1,
                2, 2, 0, 0, 3, 3,
                1, 0, 6, 2, 5, 1,
                6, 2, 1, 0, 2, 3,
                5, 0, 7, 2, 4, 1,
                7, 2, 5, 0, 6, 3,
                4, 0, 3, 2, 0, 1,
                3, 2, 4, 0, 7, 3,
                3, 0, 6, 2, 2, 1,
                6, 2, 3, 0, 7, 3,
                4, 0, 1, 2, 5, 1,
                1, 2, 4, 0, 0, 3,
        };

        this.triangleMesh = new TriangleMesh();
        triangleMesh.getPoints().setAll(points);
        triangleMesh.getTexCoords().setAll(texCoords);
        triangleMesh.getFaces().setAll(faces);
    }

    @Override
    public TriangleMesh getTriangleMesh() {
        return this.triangleMesh;
    }

    public int getSideLength() {
        return sideLength;
    }

    /**
     *
     * @param sideLength integer
     */
    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
        buildTriangleMesh();
    }

    public Point3D getCenter() {
        return center;
    }

    /**
     *
     * setCenter ONLY change the attribute
     * @param center Point3D
     */
    public void setCenter(Point3D center) {
        this.center = center;
    }
}
