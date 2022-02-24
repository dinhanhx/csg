package usth.based.csg;

import javafx.geometry.Point3D;
import javafx.scene.shape.TriangleMesh;

public class Cylinder implements Primitive{
    private float radius;
    private float height;
    private int   div;
    private Point3D basePoint;
    private TriangleMesh triangleMesh;

    /**
     *
     * @param radius positive integer
     * @param height positive integer
     * @param basePoint Point3D
     */
    public Cylinder(int div, float radius, float height, Point3D basePoint) {
        this.radius = radius;
        this.height = height;
        this.div = div;
        this.basePoint = basePoint;

        // NOTE: still create mesh for degenerated cylinder
        final int nPonits = div * 2 + 2;
        final int tcCount = (div + 1) * 4 + 1; // 2 cap tex
        final int faceCount = div * 4;

        float textureDelta = 1.f / 256;

        float dA = 1.f / div;
        height *= .5f;

        float points[] = new float[nPonits * 3];
        float tPoints[] = new float[tcCount * 2];
        int faces[] = new int[faceCount * 6];
        int smoothing[] = new int[faceCount];

        int pPos = 0, tPos = 0;

        for (int i = 0; i < div; ++i) {
            double a = dA * i * 2 * Math.PI;

            points[pPos + 0] = (float) (Math.sin(a) * radius);
            points[pPos + 2] = (float) (Math.cos(a) * radius);
            points[pPos + 1] = height;
            tPoints[tPos + 0] = 1 - dA * i;
            tPoints[tPos + 1] = 1 - textureDelta;
            pPos += 3; tPos += 2;
        }

        // top edge
        tPoints[tPos + 0] = 0;
        tPoints[tPos + 1] = 1 - textureDelta;
        tPos += 2;

        for (int i = 0; i < div; ++i) {
            double a = dA * i * 2 * Math.PI;
            points[pPos + 0] = (float) (Math.sin(a) * radius);
            points[pPos + 2] = (float) (Math.cos(a) * radius);
            points[pPos + 1] = -height;
            tPoints[tPos + 0] = 1 - dA * i;
            tPoints[tPos + 1] = textureDelta;
            pPos += 3; tPos += 2;
        }

        // bottom edge
        tPoints[tPos + 0] = 0;
        tPoints[tPos + 1] = textureDelta;
        tPos += 2;

        // add cap central points
        points[pPos + 0] = 0;
        points[pPos + 1] = height;
        points[pPos + 2] = 0;
        points[pPos + 3] = 0;
        points[pPos + 4] = -height;
        points[pPos + 5] = 0;
        pPos += 6;

        // add cap central points
        // bottom cap
        for (int i = 0; i <= div; ++i) {
            double a = (i < div) ? (dA * i * 2) * Math.PI: 0;
            tPoints[tPos + 0] = (float) (Math.sin(a) * 0.5f) + 0.5f;
            tPoints[tPos + 1] = (float) (Math.cos(a) * 0.5f) + 0.5f;
            tPos += 2;
        }

        // top cap
        for (int i = 0; i <= div; ++i) {
            double a = (i < div) ? (dA * i * 2) * Math.PI: 0;
            tPoints[tPos + 0] = 0.5f + (float) (Math.sin(a) * 0.5f);
            tPoints[tPos + 1] = 0.5f - (float) (Math.cos(a) * 0.5f);
            tPos += 2;
        }

        tPoints[tPos + 0] = .5f;
        tPoints[tPos + 1] = .5f;
        tPos += 2;

        int fIndex = 0;

        // build body faces
        for (int p0 = 0; p0 < div; ++p0) {
            int p1 = p0 + 1;
            int p2 = p0 + div;
            int p3 = p1 + div;

            // add p0, p1, p2
            faces[fIndex+0] = p0;
            faces[fIndex+1] = p0;
            faces[fIndex+2] = p2;
            faces[fIndex+3] = p2 + 1;
            faces[fIndex+4] = p1 == div ? 0 : p1;
            faces[fIndex+5] = p1;
            fIndex += 6;

            // add p3, p2, p1
            // *faces++ = SmFace(p3,p1,p2, p3,p1,p2, 1);
            faces[fIndex+0] = p3 % div == 0 ? p3 - div : p3;
            faces[fIndex+1] = p3 + 1;
            faces[fIndex+2] = p1 == div ? 0 : p1;
            faces[fIndex+3] = p1;
            faces[fIndex+4] = p2;
            faces[fIndex+5] = p2 + 1;
            fIndex += 6;

        }
        // build cap faces
        int tStart = (div + 1) * 2;
        int t1 = (div + 1) * 4;
        int p1 = div * 2;

        // bottom cap
        for (int p0 = 0; p0 < div; ++p0) {
            int p2 = p0 + 1;
            int t0 = tStart + p0;
            int t2 = t0 + 1;

            // add p0, p1, p2
            faces[fIndex+0] = p0;
            faces[fIndex+1] = t0;
            faces[fIndex+2] = p2 == div ? 0 : p2;
            faces[fIndex+3] = t2;
            faces[fIndex+4] = p1;
            faces[fIndex+5] = t1;
            fIndex += 6;
        }

        p1 = div * 2 + 1;
        tStart = (div + 1) * 3;

        // top cap
        for (int p0 = 0; p0 < div; ++p0) {
            int p2 = p0 + 1 + div;
            int t0 = tStart + p0;
            int t2 = t0 + 1;

            //*faces++ = SmFace(p0+div+1,p1,p2, t0,t1,t2, 2);
            faces[fIndex+0] = p0 + div;
            faces[fIndex+1] = t0;
            faces[fIndex+2] = p1;
            faces[fIndex+3] = t1;
            faces[fIndex+4] = p2 % div == 0 ? p2 - div : p2;
            faces[fIndex+5] = t2;
            fIndex += 6;
        }

        for (int i = 0; i < div * 2; ++i) {
            smoothing[i] = 1;
        }
        for (int i = div * 2; i < div * 4; ++i) {
            smoothing[i] = 2;
        }
        this.triangleMesh = new TriangleMesh();
        triangleMesh.getPoints().setAll(points);
        triangleMesh.getTexCoords().setAll(tPoints);
        triangleMesh.getFaces().setAll(faces);
        //triangleMesh.getFaceSmoothingGroups().setAll(smoothing);
    }

    @Override
    public void setTriangleMesh(TriangleMesh triangleMesh) {
        this.triangleMesh = triangleMesh;
    }

    @Override
    public TriangleMesh getTriangleMesh() {
        return this.triangleMesh;
    }

    public float getRadius() { return radius;    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point3D getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Point3D basePoint) {
        this.basePoint = basePoint;
    }
}
