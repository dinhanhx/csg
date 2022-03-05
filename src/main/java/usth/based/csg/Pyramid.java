package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.TriangleMesh;

public class Pyramid implements Primitive{
    private float height;
    private float hypotenuse;
    private Point3D center;
    private TriangleMesh triangleMesh;

    /**
     *
     * @param height positive integer
     * @param center Point3D
     */
    public Pyramid(float hypotenuse, float height, Point3D center) {
        this.height = height;
        this.center = center;
        this.hypotenuse = hypotenuse;

        // The magic starts here
        buildTriangleMesh();
    }

    private void buildTriangleMesh() {
        // TODO make this work with this.center

        double centerx = this.center.getX();
        double centery = this.center.getY();
        double centerz = this.center.getZ();
        float[] points = {
                0,0,0,
                0, height, -hypotenuse/2,
                -hypotenuse/2, height, 0,
                hypotenuse/2, height, 0,
                0, height, hypotenuse/2};
        for (int i = 0; i <5; i++)
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
                0,0,2,0,1,0,
                0,0,1,0,3,0,
                0,0,3,0,4,0,
                0,0,4,0,2,0,
                4,0,1,0,2,0,
                4,0,3,0,1,0
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

    public float getHeight() {
        return height;
    }
    public float getHypotenuse() {
        return hypotenuse;
    }
    /**
     *
     * @param height integer
     */
    public void setHeight(float height) {
        this.height = height;
        buildTriangleMesh();
    }
    public void setHypotenuse(float hypotenuse) {
        this.hypotenuse = hypotenuse;
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
