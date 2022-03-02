package usth.based.csg;

import javafx.geometry.Point3D;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    @Test
    @Disabled
    void getTriangleMesh() {
    }

    @Test
    void getSideLength() {
        int dummySideLength = 128;
        Cube cube = new Cube(dummySideLength, Point3D.ZERO);
        assert cube.getSideLength() == dummySideLength;
    }

    @Test
    @Disabled
    void setSideLength() {
        int dummySideLength = 128;
        Cube cube = new Cube(dummySideLength, Point3D.ZERO);
        int newDummySideLength = 64;
        cube.setSideLength(newDummySideLength);
        assert cube.getSideLength() == newDummySideLength;
    }

    @Test
    void getCenter() {
        Point3D dummyPoint3D = Point3D.ZERO;
        Cube cube = new Cube(128, dummyPoint3D);
        assert cube.getCenter().equals(dummyPoint3D);
    }

    @Test
    @Disabled
    void setCenter() {
    }
}