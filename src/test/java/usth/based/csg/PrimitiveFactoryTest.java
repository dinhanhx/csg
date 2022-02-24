package usth.based.csg;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveFactoryTest {

    @Test
    @DisplayName("Test makePrimitive()")
    void makePrimitiveTest() {
        PrimitiveFactory factory = new PrimitiveFactory();

        Primitive sphere = factory.makePrimitive("SPHERE");
        assert sphere.getClass().getSimpleName().equalsIgnoreCase("SPHERE");

        Primitive cube = factory.makePrimitive("CUBE");
        assert cube.getClass().getSimpleName().equalsIgnoreCase("CUBE");

        Primitive cylinder = factory.makePrimitive("CYLINDER");
        assert cylinder.getClass().getSimpleName().equalsIgnoreCase("CYLINDER");

        Primitive pyramid = factory.makePrimitive("PYRAMID");
        assert pyramid.getClass().getSimpleName().equalsIgnoreCase("PYRAMID");

        Primitive parallelepiped = factory.makePrimitive("PARALLELEPIPED");
        assert parallelepiped.getClass().getSimpleName().equalsIgnoreCase("PARALLELEPIPED");
    }
}