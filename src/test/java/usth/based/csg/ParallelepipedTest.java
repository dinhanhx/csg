package usth.based.csg;

import javafx.geometry.Point3D;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParallelepipedTest {

    @Test
    @Disabled
    void getTriangleMesh() {
    }

    @Test
    void getVertices() {
        ArrayList<Point3D> dummyVertices = new ArrayList<>();
        dummyVertices.add(Point3D.ZERO);
        dummyVertices.add(new Point3D(1, 0, 0));
        dummyVertices.add(new Point3D(0, 1, 0));
        dummyVertices.add(new Point3D(0, 0, 1));

        Parallelepiped parallelepiped = new Parallelepiped(dummyVertices);
        assert parallelepiped.getVertices().size() == 4;
        assert parallelepiped.getVertices().get(0).equals(dummyVertices.get(0));
        assert parallelepiped.getVertices().get(1).equals(dummyVertices.get(1));
        assert parallelepiped.getVertices().get(2).equals(dummyVertices.get(2));
        assert parallelepiped.getVertices().get(3).equals(dummyVertices.get(3));
    }

    @Test
    @Disabled
    void setVertices() {
    }
}