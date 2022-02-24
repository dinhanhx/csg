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
        int dummyBasePointToVertexDistance = 128;
        Pyramid pyramid = new Pyramid(dummyBasePointToVertexDistance, Point3D.ZERO);
        assert pyramid.getBasePointToVertexDistance() == dummyBasePointToVertexDistance;
    }

    @Test
    @Disabled
    void setBasePointToVertexDistance() {
    }

    @Test
    void getBasePoint() {
        Point3D dummyPoint3D = Point3D.ZERO;
        Pyramid pyramid = new Pyramid(128, dummyPoint3D);
        assert pyramid.getBasePoint().equals(dummyPoint3D);
    }

    @Test
    @Disabled
    void setBasePoint() {
    }
}