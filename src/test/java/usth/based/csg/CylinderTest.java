package usth.based.csg;

import javafx.geometry.Point3D;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    @Disabled
    void getTriangleMesh() {
    }

    @Test
    void getRadius() {
        int dummyRadius = 128;
        Cylinder cylinder = new Cylinder(dummyRadius, 256, Point3D.ZERO);
        assert cylinder.getRadius() == dummyRadius;
    }

    @Test
    @Disabled
    void setRadius() {
    }

    @Test
    void getHeight() {
        int dummyHeight = 256;
        Cylinder cylinder = new Cylinder(128, dummyHeight, Point3D.ZERO);
        assert cylinder.getHeight() == dummyHeight;
    }

    @Test
    @Disabled
    void setHeight() {
    }

    @Test
    void getBasePoint() {
        Point3D dummyPoint3D = Point3D.ZERO;
        Cylinder cylinder = new Cylinder(128, 256, dummyPoint3D);
        assert cylinder.getBasePoint().equals(dummyPoint3D);
    }

    @Test
    @Disabled
    void setBasePoint() {
    }
}