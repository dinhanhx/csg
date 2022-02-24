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
        float dummyRadius = 128;
        Cylinder cylinder = new Cylinder(64, dummyRadius, 256, Point3D.ZERO);
        assert cylinder.getRadius() == dummyRadius;
    }

    @Test
    @Disabled
    void setRadius() {
    }

    @Test
    void getHeight() {
        float dummyHeight = 256;
        Cylinder cylinder = new Cylinder(64, 128, dummyHeight, Point3D.ZERO);
        assert cylinder.getHeight() == dummyHeight;
    }

    @Test
    @Disabled
    void setHeight() {
    }

    @Test
    void getBasePoint() {
        Point3D dummyPoint3D = Point3D.ZERO;
        Cylinder cylinder = new Cylinder(64, 128, 256, dummyPoint3D);
        assert cylinder.getBasePoint().equals(dummyPoint3D);
    }

    @Test
    @Disabled
    void setBasePoint() {
    }

    @Test
    void getdivision() {
        int div = 64;
        Cylinder cylinder = new Cylinder(div, 128, 256, Point3D.ZERO);
        assert cylinder.getdivision() == div;
    }

    @Test
    @Disabled
    void setdivision() {
    }
}