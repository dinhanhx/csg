package usth.based.csg;

import javafx.geometry.Point3D;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidTest {

    @Test
    @Disabled
    void getTriangleMesh() {
    }

    @Test
    void getBasePointToVertexDistance() {
        float dummyheight = 128;
        float dummyhypotenuse = 64;
        Pyramid pyramid = new Pyramid(dummyhypotenuse,dummyheight, Point3D.ZERO);
        assert pyramid.getHeight() == dummyheight;
        assert pyramid.getHypotenuse() == dummyhypotenuse;
    }

    @Test
    @Disabled
    void setBasePointToVertexDistance() {
    }

    @Test
    void getBasePoint() {
        Point3D dummyPoint3D = Point3D.ZERO;
        Pyramid pyramid = new Pyramid(64,128, dummyPoint3D);
        assert pyramid.getCenter().equals(dummyPoint3D);
    }

    @Test
    @Disabled
    void setCenter() {
    }
}