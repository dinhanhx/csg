package usth.based.csg;

import javafx.geometry.Point3D;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    @Disabled
    void getTriangleMeshTest() {
    }

    @Test
    void getRadiusTest() {
        int dummyRadius = 128;
        Sphere sphere = new Sphere(dummyRadius, Point3D.ZERO);
        assert sphere.getRadius() == dummyRadius;
    }

    @Test
    @Disabled
    void setRadiusTest() {
    }

    @Test
    void getCenterTest() {
        Point3D dummyPoint = Point3D.ZERO;
        Sphere sphere = new Sphere(128, dummyPoint);
        assert sphere.getCenter().equals(dummyPoint);
    }

    @Test
    @Disabled
    void setCenterTest() {
    }
}