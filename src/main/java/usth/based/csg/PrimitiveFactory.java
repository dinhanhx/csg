package usth.based.csg;

import javafx.geometry.Point3D;

public class PrimitiveFactory {
    public Primitive makePrimitive(String type) {
        if (type.equalsIgnoreCase("SPHERE")) {
            return new Sphere(1, Point3D.ZERO);
        }

        if (type.equalsIgnoreCase("CUBE")) {
            return new Cube(2, Point3D.ZERO);
        }
        return null;
    }
}
